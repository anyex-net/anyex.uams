package com.uams.security.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uams.orm.utils.EncryptUtils;
import com.uams.tools.annotation.CSRFToken;
import com.uams.tools.consts.UamsConst;
import com.uams.tools.utils.LoggerUtils;
import com.uams.tools.utils.RedisLock;
import com.uams.tools.utils.StringUtils;

/**
 * <p>File：CSRFHandlerInterceptor</p>
 * <p>Title: </p>
 * <p>Description: 用于配合 spring <form:form> 标签防止 CSRF 攻击 </form:form></p>
 * <p>Copyright: Copyright (c) 2014 2014/3/22 10:52</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class CSRFHandlerInterceptor extends HandlerInterceptorAdapter
{
    private CSRFTokenManager   csrfTokenManager;
    
    private RedisTemplate      redisTemplate;
    
    public static final Logger logger = LoggerFactory.getLogger(CSRFHandlerInterceptor.class);
    
    public void setCsrfTokenManager(CSRFTokenManager csrfTokenManager)
    {
        this.csrfTokenManager = csrfTokenManager;
    }
    
    public void setRedisTemplate(RedisTemplate redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        if (!request.getMethod().equalsIgnoreCase(UamsConst.POST))
        {// 非POST请求直接放行
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        CSRFToken csrfToken = method.getAnnotation(CSRFToken.class);
        // 如果配置了校验csrf token校验，则校验
        if (null != csrfToken && csrfToken.check())
        {
            String requestToken = CSRFTokenManager.getTokenFromRequest(request);
            if (StringUtils.isBlank(requestToken))
            {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Bad or missing CSRF value");
                return false;
            }
            RedisLock lock = new RedisLock(redisTemplate, requestToken);
            if (lock.lock())
            {
                try
                {
                    String decrypt = EncryptUtils.desDecrypt(requestToken);
                    String formId = decrypt.substring(0, decrypt.indexOf(UamsConst.SEPARATOR));
                    String sessionToken = csrfTokenManager.getTokenForRequest(request, formId);
                    if (StringUtils.equals(sessionToken, requestToken))
                    {// 验证成功之后清除TOKEN
                        csrfTokenManager.removeTokenForRequest(request, formId);
                        response.addHeader(CSRFTokenManager.CSRF_TOKEN_NAME, csrfTokenManager.getTokenForRequest(request, formId));
                    }
                    else
                    {
                        response.addHeader(CSRFTokenManager.CSRF_TOKEN_NAME, sessionToken);
                    }
                }
                catch (RuntimeException e)
                {
                    LoggerUtils.logError(logger, "锁获取失败：{}", e.getMessage());
                }
                finally
                {
                    lock.unlock();
                }
                return true;
            }
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Bad or missing CSRF value");
            return false;
        }
        else
        {
            return true;
        }
    }
}
