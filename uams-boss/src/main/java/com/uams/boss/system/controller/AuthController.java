package com.uams.boss.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uams.orm.core.GenericController;
import com.uams.security.shiro.model.AccountToken;
import com.uams.tools.annotation.CSRFToken;
import com.uams.tools.bean.AliyunModel;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.AliyunUtils;
import com.uams.tools.utils.IPUtil;

/**
 * AuthController Introduce
 * <p>File：AuthController.java </p>
 * <p>Title: AuthController </p>
 * <p>Description:AuthController </p>
 * <p>Copyright: Copyright (c) 17/6/21</p>
 * <p>Company: blocain.com</p>
 *
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AuthController extends GenericController
{
    /**
     * 登陆页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping("/login")
    public String login() throws BusinessException
    {
        if (SecurityUtils.getSubject().isAuthenticated())
        {// 如果登陆过就直接进入后台
            return "redirect:/dispatch";
        }
        return "login";
    }
    
    /**
     * 用户登陆认证
     * @param request
     * @param token
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @CSRFToken
    @ResponseBody
    @RequestMapping("/login/submit")
    public JsonMessage submit(HttpServletRequest request, @ModelAttribute AccountToken token, @ModelAttribute AliyunModel model)
    {
        if (SecurityUtils.getSubject().isAuthenticated())
        {// 如果登陆过就直接进入后台
            return this.getJsonMessage(CommonEnums.SUCCESS);
        }
        if (!AliyunUtils.validParams(model))
        {// 验证不通过时
            return this.getJsonMessage(CommonEnums.ERROR_LOGIN_CAPTCHA, Boolean.TRUE);
        }
        token.setHost(IPUtil.getOriginalIpAddr(request));
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
        }
        catch (IncorrectCredentialsException ice)
        {
            return this.getJsonMessage(CommonEnums.ERROR_LOGIN_PASSWORD);
        }
        catch (UnknownAccountException uae)
        {
            return this.getJsonMessage(CommonEnums.ERROR_LOGIN_ACCOUNT);
        }
        catch (ExcessiveAttemptsException eae)
        {
            return this.getJsonMessage(CommonEnums.ERROR_LOGIN_TIMEOUT);
        }
        return this.getJsonMessage(CommonEnums.SUCCESS);
    }
    
    /**
     * 退出认证
     * @return {@link String}
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/logout")
    public JsonMessage logout(HttpServletRequest request) throws Exception
    {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject)
        {
            subject.logout();
        }
        return this.getJsonMessage(CommonEnums.SUCCESS);
    }
}
