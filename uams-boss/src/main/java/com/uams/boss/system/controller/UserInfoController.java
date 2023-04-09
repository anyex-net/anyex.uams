/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uams.orm.core.GenericController;
import com.uams.orm.utils.EncryptUtils;
import com.uams.rpc.system.entity.RoleInfo;
import com.uams.rpc.system.entity.UserData;
import com.uams.rpc.system.entity.UserInfo;
import com.uams.rpc.system.service.RoleInfoService;
import com.uams.rpc.system.service.UserDataService;
import com.uams.rpc.system.service.UserInfoService;
import com.uams.security.OnLineUserUtils;
import com.uams.tools.annotation.CSRFToken;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.bean.PaginateResult;
import com.uams.tools.bean.Pagination;
import com.uams.tools.consts.UamsConst;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;

/**
 * 用户基础信息表 控制器
 * <p>File：UserInfoController.java </p>
 * <p>Title: UserInfoController </p>
 * <p>Description:UserInfoController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping(UamsConst.SYSTEM)
public class UserInfoController extends GenericController
{
    @Autowired(required = false)
    private UserInfoService userInfoService;
    
    @Autowired(required = false)
    private RoleInfoService roleInfoService;
    
    @Autowired(required = false)
    private UserDataService userDataService;
    
    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/user")
    @RequiresPermissions("system:setting:user:index")
    public String list() throws BusinessException
    {
        return "boss/system/user/list";
    }
    
    /**
     * 编辑页面导航
     * @param id 
     * @return {@link String}
     * @throws BusinessException
     */
    @RequestMapping(value = "/user/modify")
    @RequiresPermissions("system:setting:user:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/system/user/modify");
        UserInfo user = null;
        String roleIds = null;
        if (null != id)
        {
            user = userInfoService.selectByPrimaryKey(id);
            List<RoleInfo> roles = roleInfoService.findByUserId(user.getId());
            if (ListUtils.isNotNull(roles))
            {
                StringBuffer tmpIds = new StringBuffer();
                for (RoleInfo role : roles)
                {
                    tmpIds.append(role.getId()).append(",");
                }
                roleIds = tmpIds.substring(0, tmpIds.lastIndexOf(","));
            }
        }
        mav.addObject("user", user);
        mav.addObject("roleIds", roleIds);
        return mav;
    }
    
    /**
    * 编辑页面导航
    * @param id
    * @return {@link String}
    * @throws BusinessException
    */
    @RequestMapping(value = "/user/grant")
    @RequiresPermissions("system:setting:user:operator")
    public ModelAndView grant(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/system/user/grant");
        mav.addObject("id", id);
        return mav;
    }
    
    /**
     * 数据授权信息
     * @return
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/user/findByUserId")
    @RequiresPermissions("system:setting:user:data")
    public JsonMessage findByRoleId(Long userId) throws BusinessException
    {
        if (null == userId) throw new BusinessException(CommonEnums.ERROR_PARAMS_VALID);
        UserData userData = new UserData();
        userData.setUserId(userId);
        List<UserData> data = userDataService.findList(userData);
        return getJsonMessage(CommonEnums.SUCCESS, data);
    }
    
    /**
     * 保存用户数据授权信息
     * @param userId
     * @param orgIds
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @CSRFToken
    @ResponseBody
    @RequiresPermissions("system:setting:user:operator")
    @RequestMapping(value = "/user/saveGrant", method = RequestMethod.POST)
    public JsonMessage saveGrant(Long userId, String orgIds) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        userDataService.saveGrant(userId, orgIds);
        return json;
    }
    
    /**
    * 操作用户基础信息表
    * @param info
    * @return {@link com.uams.tools.bean.JsonMessage}
    * @throws com.uams.tools.exception.BusinessException
    */
    @CSRFToken
    @ResponseBody
    @RequiresPermissions("system:setting:user:operator")
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public JsonMessage save(UserInfo info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        userInfoService.save(info);
        return json;
    }
    
    /**
     * 查询用户基础信息表
     * @return {@link com.uams.tools.bean.JsonMessage}
     * @throws com.uams.tools.exception.BusinessException
     */
    @ResponseBody
    @RequiresPermissions("system:setting:user:data")
    @RequestMapping(value = "/user/data", method = RequestMethod.POST)
    public JsonMessage data(UserInfo entity, Pagination pagin) throws BusinessException
    {
        if (null == entity) entity = new UserInfo();
        entity.setUid(OnLineUserUtils.getId());
        PaginateResult<UserInfo> result = userInfoService.search(pagin, entity);
        return getJsonMessage(CommonEnums.SUCCESS, result);
    }
    
    /**
     * 根据指定ID删除
     * @param ids
     * @return {@link com.uams.tools.bean.JsonMessage}
     * @throws com.uams.tools.exception.BusinessException
     */
    @CSRFToken
    @ResponseBody
    @RequiresPermissions("system:setting:user:operator")
    @RequestMapping(value = "/user/del", method = RequestMethod.POST)
    public JsonMessage del(String ids) throws BusinessException
    {
        userInfoService.deleteBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
    
    /**
     * 启用或信用用户
     * @param id
     * @return {@link com.uams.tools.bean.JsonMessage}
     * @throws com.uams.tools.exception.BusinessException
     */
    @CSRFToken
    @ResponseBody
    @RequiresPermissions("system:setting:user:operator")
    @RequestMapping(value = "/user/changeStatus", method = RequestMethod.POST)
    public JsonMessage changeStatus(Long id) throws BusinessException
    {
        if (null == id) throw new BusinessException("操作编号不可为空！");
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        userInfo.setActive(!userInfo.getActive());
        userInfoService.updateByPrimaryKey(userInfo);
        return getJsonMessage(CommonEnums.SUCCESS);
    }
    
    /**
    * 重置用户密码
    * @param id
    * @return {@link com.uams.tools.bean.JsonMessage}
    * @throws com.uams.tools.exception.BusinessException
    */
    @CSRFToken
    @ResponseBody
    @RequiresPermissions("system:setting:user:operator")
    @RequestMapping(value = "/user/resetPassword", method = RequestMethod.POST)
    public JsonMessage resetPassword(Long id) throws BusinessException
    {
        if (null == id) throw new BusinessException("操作编号不可为空！");
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        userInfo.setPassWord(EncryptUtils.entryptPassword(UamsConst.DEFAULT_PASSWORD));
        userInfoService.updateByPrimaryKey(userInfo);
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
