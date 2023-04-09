package com.uams.security.shiro.model;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 *  登陆参数对象
 * <p>File： AccountToken.java </p>
 * <p>Title:  AccountToken </p>
 * <p>Description: AccountToken </p>
 * <p>Copyright: Copyright (c) 2017/8/2 </p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class AccountToken extends UsernamePasswordToken
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5758802251381953812L;
    
    // ID
    private Long              id;
    
    // 策略用户
    private Integer           level;
    
    // 手机号
    private String            mobNo;
    
    public AccountToken()
    {
        super();
    }
    
    public AccountToken(String username, char[] password)
    {
        super(username, password);
    }
    
    public AccountToken(String username, String password)
    {
        super(username, password);
    }
    
    public AccountToken(String username, char[] password, String host)
    {
        super(username, password, host);
    }
    
    public AccountToken(String username, String password, String host)
    {
        super(username, password, host);
    }
    
    public AccountToken(String username, char[] password, boolean rememberMe)
    {
        super(username, password, rememberMe);
    }
    
    public AccountToken(String username, String password, boolean rememberMe)
    {
        super(username, password, rememberMe);
    }
    
    public AccountToken(String username, char[] password, boolean rememberMe, String host)
    {
        super(username, password, rememberMe, host);
    }
    
    public AccountToken(String username, String password, boolean rememberMe, String host)
    {
        super(username, password, rememberMe, host);
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Integer getLevel()
    {
        return level;
    }
    
    public void setLevel(Integer level)
    {
        this.level = level;
    }
    
    public String getMobNo()
    {
        return mobNo;
    }
    
    public void setMobNo(String mobNo)
    {
        this.mobNo = mobNo;
    }
}
