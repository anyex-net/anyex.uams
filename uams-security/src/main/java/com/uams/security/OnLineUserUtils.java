package com.uams.security;

import java.util.List;
import java.util.TreeSet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uams.rpc.system.entity.Resources;
import com.uams.rpc.system.entity.RoleInfo;
import com.uams.security.shiro.model.UserPrincipal;
import com.uams.tools.bean.TreeModel;
import com.uams.tools.exception.BusinessException;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * <p>File：OnLineUserUtils.java </p>
 * <p>Title: 在线用户工具类 </p>
 * <p>Description: OnLineUserUtils </p>
 * <p>Copyright: Copyright (c) 2014 08/08/2015 20:50</p>
 * <p>Company: BloCain</p>
 *
 * @author playguy
 * @version 1.0
 */
public class OnLineUserUtils
{
    private static Logger logger = LoggerFactory.getLogger(OnLineUserUtils.class);
    
    private OnLineUserUtils()
    {
    }
    
    /**
     * 获取当前登录者对象
     */
    public static UserPrincipal getPrincipal()
    {
        try
        {
            Subject subject = SecurityUtils.getSubject();
            Object object = subject.getPrincipal();
            if (null != object) { return (UserPrincipal) object; }
        }
        catch (UnavailableSecurityManagerException e)
        {
            logger.error(e.getLocalizedMessage());
        }
        catch (InvalidSessionException e)
        {
            logger.error(e.getLocalizedMessage());
        }
        return null;
    }
    
    /**
     * 判断角色中是否存在某个角色编码
     * @param roleCode
     * @return
     */
    public static boolean existRole(String roleCode)
    {
        boolean flag = false;
        UserPrincipal principal = getPrincipal();
        for (RoleInfo role : principal.getRoles())
        {// 判断角色中是否存在某个角色编码
            if (roleCode.equals(role.getRoleCode())) return true;
        }
        return flag;
    }
    
    /**
     * 取用户对应的厂店信息
     * @return
     */
    public static Long getId()
    {
        UserPrincipal principal = getPrincipal();
        return null != principal ? principal.getId() : null;
    }
    
    /**
     * 取邮件地址
     * @return
     */
    public static String getEmail()
    {
        UserPrincipal principal = getPrincipal();
        return null != principal ? principal.getUserMail() : "";
    }
    
    /**
     * 获取授权主要对象
     */
    public static Subject getSubject()
    {
        return SecurityUtils.getSubject();
    }
    
    /**
     * 取当前会话
     * @return
     */
    public static Session getSession()
    {
        try
        {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession(false);
            if (session == null)
            {
                session = subject.getSession();
            }
            if (session != null) { return session; }
        }
        catch (InvalidSessionException e)
        {
        }
        return null;
    }
    
    /**
     * 取当前用户的菜单
     * @return
     * @throws BusinessException
     */
    public static List<TreeModel> getUserResources() throws BusinessException
    {
        TreeSet<TreeModel> zTreeModels = getAllData();
        List<TreeModel> treeList = Lists.newArrayList();
        for (TreeModel parent : zTreeModels)
        {
            if (null == parent.getPid())
            {
                treeList.add(parent);
            }
            for (TreeModel child : zTreeModels)
            {
                if (parent.getId().equals(child.getPid()))
                {
                    if (parent.getChildren() == null)
                    {
                        parent.setChildren(Lists.newArrayList(child));
                    }
                    else
                    {
                        parent.getChildren().add(child);
                    }
                }
            }
        }
        return treeList;
    }
    
    /**
     * 取去重后的所有数据
     * @return {@link TreeSet< TreeModel >}
     * @throws BusinessException
     */
    protected static TreeSet<TreeModel> getAllData() throws BusinessException
    {
        UserPrincipal principal = getPrincipal();
        if (null == principal) throw new BusinessException("用户未登陆");
        TreeSet<TreeModel> treeModels = Sets.newTreeSet((o1, o2) -> {
            int result = o1.getSort().compareTo(o2.getSort());
            if (result == 0) result = o1.getId().compareTo(o2.getId());
            return result;
        });
        TreeModel menu;
        for (RoleInfo role : principal.getRoles())
        {
            for (Resources res : role.getResources())
            {
                if (res.getType()) continue;// 跳过权限
                menu = new TreeModel();
                menu.setId(res.getId());
                menu.setPid(res.getParentId());
                menu.setText(res.getResName());
                menu.setIconCls(res.getIcon());
                menu.setAttributes(res.getResUrl());
                menu.setSort(null == res.getSortNum() ? 99 : res.getSortNum());
                treeModels.add(menu);
            }
        }
        return treeModels;
    }
}
