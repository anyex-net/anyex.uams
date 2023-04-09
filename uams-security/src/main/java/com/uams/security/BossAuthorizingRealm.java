package com.uams.security;

import java.util.List;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.uams.orm.utils.EncryptUtils;
import com.uams.rpc.system.entity.Resources;
import com.uams.rpc.system.entity.RoleInfo;
import com.uams.rpc.system.entity.UserInfo;
import com.uams.rpc.system.service.ResourcesService;
import com.uams.rpc.system.service.RoleInfoService;
import com.uams.rpc.system.service.UserInfoService;
import com.uams.security.shiro.model.UserPrincipal;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.StringUtils;

/**
 * <p>File：BossAuthorizingRealm.java </p>
 * <p>Title: 系统安全认证实现类 </p>
 * <p>Description: BossAuthorizingRealm </p>
 * <p>Copyright: Copyright (c) 2014 08/08/2015 15:42</p>
 * <p>Company: BloCain</p>
 *
 * @author playguy
 * @version 1.0
 */
public class BossAuthorizingRealm extends AuthorizingRealm
{
    @Autowired
    private UserInfoService  userInfoService;
    
    @Autowired
    private RoleInfoService  roleInfoService;
    
    @Autowired
    private ResourcesService resourcesService;
    
    /**
     * 认证回调函数, 登录时调用
     * <p>
     *  一次性将用户认证、操作权限等信息放到用户会话中
     * </p>
     * @param authToken
     * @return {@link AuthenticationInfo}
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException
    {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
        if (StringUtils.isBlank(token.getUsername())) throw new UnknownAccountException("用户不存在！");
        UserInfo userInfo = userInfoService.findByUserName(token.getUsername());
        if (null == userInfo) throw new UnknownAccountException("用户不存在！");
        if (!EncryptUtils.validatePassword(String.valueOf(token.getPassword()), userInfo.getPassWord()))
        {//
            throw new AuthenticationException("密码错误！");
        }
        List<RoleInfo> roles = roleInfoService.findByUserId(userInfo.getId());
        if (ListUtils.isNotNull(roles))
        {
            for (RoleInfo role : roles)
            {
                List<Resources> resources = resourcesService.findByRoleId(role.getId());
                role.setResources(resources);
            }
        }
        UserPrincipal userPrincipal = new UserPrincipal(userInfo.getId(), userInfo.getOrgId(), userInfo.getUserName(), userInfo.getTrueName(), roles);
        return new SimpleAuthenticationInfo(userPrincipal, userInfo.getPassWord(), getName());
    }
    
    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
     *
     * @param principals
     * @return {@link AuthenticationInfo}
     * @throws AuthenticationException
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        UserPrincipal principal = (UserPrincipal) getAvailablePrincipal(principals);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<RoleInfo> roles = principal.getRoles();
        if (ListUtils.isNotNull(roles))
        {
            for (RoleInfo role : roles)
            {
                authorizationInfo.addRole(role.getRoleCode());
                List<Resources> resources = role.getResources();
                if (ListUtils.isNotNull(roles))
                {
                    for (Resources res : resources)
                    {
                        authorizationInfo.addStringPermission(res.getResCode());
                    }
                }
            }
        }
        return authorizationInfo;
    }
}
