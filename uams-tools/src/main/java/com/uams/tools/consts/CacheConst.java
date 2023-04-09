package com.uams.tools.consts;

/**
 * <p>File：CacheConst.java </p>
 * <p>Title: 缓存前缀声明 </p>
 * <p>Description: CacheConst </p>
 * <p>Copyright: Copyright (c) 15/9/1</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class CacheConst
{
    private CacheConst()
    {
    }
    
    /**
     * APP参数默认缓存时间(5分钟)
     */
    public static final Integer DEFAULT_CACHE_TIME         = 300;
    
    /**
     * 15分钟
     */
    public static final Integer FIFTEEN_MINUTE_CACHE_TIME  = 900;
    
    /**
     * 30分钟
     */
    public static final Integer THIRTY_MINUTE_CACHE_TIME   = 1800;
    
    /**
     * 60分钟
     */
    public static final Integer ONE_HOUR_CACHE_TIME        = 3600;
    
    /**
     * 24小时
     */
    public static final Integer TWENTYFOUR_HOUR_CACHE_TIME = 86400;
    
    /**
     * GOOGLE CODE
     */
    public static final String  GOOGLE_CODE_PERFIX         = "google|code";
    
    /**
     * 消息发送
     */
    public static final String  CACHE_SEND_SMS_PERFIX      = "message|phone";
    
    /**
    * 消息邮件
    */
    public static final String  CACHE_SEND_EMAIL_PERFIX    = "message|email";
    
    /**
     * 消息过期
     */
    public static final String  CACHE_EXPIRE_SMS_PERFIX    = "message|expire";
    
    /**
     * 会话对象
     */
    public static final String  REDIS_SHIRO_CACHE_PREFIX   = "session|cache";
    
    /**
     * APP会话对象
     */
    public static final String  REDIS_APPS_CACHE_PREFIX    = "app|session";
    
    /**
     * 会话统计
     */
    public static final String  REDIS_SHIRO_SESSION_PREFIX = "session|statis";
}
