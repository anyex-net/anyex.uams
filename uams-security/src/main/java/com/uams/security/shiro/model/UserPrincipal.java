package com.uams.security.shiro.model;

import java.io.Serializable;
import java.util.List;

import com.uams.rpc.system.entity.RoleInfo;

/**
 * <p>File：UserPrincipal.java </p>
 * <p>Title: UserPrincipal </p>
 * <p>Description: UserPrincipal </p>
 * <p>Copyright: Copyright (c) 2014 08/08/2015 20:41</p>
 * <p>Company: BloCain</p>
 *
 * @author playguy
 * @version 1.0
 */
public class UserPrincipal implements Serializable
{
    private static final long serialVersionUID = 191434150385861991L;
    
    /**主键编号*/
    private Long              id;
    
    /**用户编号*/
    private Long              orgId;
    
    /**  语言标识*/
    private String            lang;
    
    /**帐号*/
    private String            userName;
    
    /**昵称*/
    private String            trueName;
    
    /**手机号码*/
    private String            userMobile;
    
    /**电子邮箱*/
    private String            userMail;
    
    /**角色和权限**/
    List<RoleInfo>            roles;
    
    /**
     * DEFAULT CONSTRUCTOR
     * @param id
     */
    public UserPrincipal(Long id)
    {
        this.id = id;
    }
    
    public UserPrincipal(Long id, String userName, String trueName, List<RoleInfo> roles)
    {
        this.id = id;
        this.userName = userName;
        this.trueName = trueName;
        this.roles = roles;
    }
    
    public UserPrincipal(Long id, Long orgId, String userName, String trueName, List<RoleInfo> roles)
    {
        this.id = id;
        this.orgId = orgId;
        this.userName = userName;
        this.trueName = trueName;
        this.roles = roles;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Long getOrgId()
    {
        return orgId;
    }
    
    public void setOrgId(Long orgId)
    {
        this.orgId = orgId;
    }
    
    public String getLang()
    {
        return lang;
    }
    
    public void setLang(String lang)
    {
        this.lang = lang;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getTrueName()
    {
        return trueName;
    }
    
    public void setTrueName(String trueName)
    {
        this.trueName = trueName;
    }
    
    public String getUserMobile()
    {
        return userMobile;
    }
    
    public void setUserMobile(String userMobile)
    {
        this.userMobile = userMobile;
    }
    
    public String getUserMail()
    {
        return userMail;
    }
    
    public void setUserMail(String userMail)
    {
        this.userMail = userMail;
    }
    
    public List<RoleInfo> getRoles()
    {
        return roles;
    }
    
    public void setRoles(List<RoleInfo> roles)
    {
        this.roles = roles;
    }
}
