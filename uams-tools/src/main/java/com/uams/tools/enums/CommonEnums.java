package com.uams.tools.enums;

import com.uams.tools.bean.EnumDescribable;

/**
 * <p>File：CommonConst.java </p>
 * <p>Title: CommonConst </p>
 * <p>Description: CommonConst </p>
 * <p>Copyright: Copyright (c) 15/9/15</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public enum CommonEnums implements EnumDescribable
{
    SUCCESS(200, "操作成功"), // 操作成功
    FAIL(1000, "操作失败"), // 操作失败
    ERROR_PARSE_JSON(1001, "参数解析失败"), // 操作失败
    USER_NOT_LOGIN(2000, "用户未登陆"), // 用户未登陆
    NEED_POLICY_CHECK(2001, "安全验证策略"), // 安全验证策略
    ERROR_DATA_VALID(2002,"数据校验失败"),//数据校验失败
    ERROR_PARAMS_VALID(2003, "参数验证错误"), // 参数验证错误
    ERROR_LOGIN_ACCOUNT(2004, "用户不存在"), // 用户不存在
    ERROR_LOGIN_PASSWORD(2005, "密码错误"), // 密码错误
    ERROR_LOGIN_TIMEOUT(2006, "会话超时"), // 会话超时
    ERROR_LOGIN_CAPTCHA(2007, "验证码错误"), // 验证码错误
    ERROR_LOGIN_LOCK(2008, "帐户已锁"), // 帐户已锁
    ERROR_CSRF_VALID(2009, "CSRF验证失败"), // CSRF验证
    ERROR_EMAIL_EXIST(2010, "邮箱已存在"), // 邮箱已存在
    ERROR_ILLEGAL_REQUEST(2011, "非法请求"), // 非法请求
    ERROR_DES_CHECK_FAILED(2012, "DES校验失败"), // DES校验失败
    ERROR_DATA_LENGTH_FAILED(2013, "数据长度校验失败"), // 数据长度校验失败
    ERROR_AUTHER_FAILED(2014, "身份认证失败"), // 身份认证失败
    ERROR_DB_ACCESS_FAILED(2015, "数据访问失败"), // 数据访问失败
    ERROR_EMAIL_VALID_FAILED(2016, "邮箱验证失败"), // 邮箱验证码失败
    ERROR_PHONE_VALID_FAILED(2017, "短信验证失败"), // 邮箱验证码失败
    ERROR_PHONE_FORMAT_FAILED(2018,"号码格式错误"),//GA未绑定
    ERROR_EMAIL_FORMAT_FAILED(2019, "邮箱格式错误"), // 邮箱格式错误
    ERROR_GA_VALID_FAILED(2020, "谷歌验证失败"), // 谷歌验证失败
    ERROR_WALLET_VALID_FAILED(2021, "资金密码验证失败"), // 资金密码验证失败
    ERROR_WALLET_VALID_NOEXIST(2022, "未设置资金密码"), // 未设置资金密码
    ERROR_SESSION_TIME_OUT(2023, "会话已过期"), // 会话已过期
    ERROR_GT_DAY_MAX_AMT(2024, "已超过当天最大限额"), // 已超过当天最大限额
    ERROR_GT_MAX_AMT(2025, "已超过最大限额"), // 已超过最大限额
    ERROR_GA_NOT_BIND(2026,"GA未绑定"),//GA未绑定
    ;
    public Integer code;
    
    public String  message;
    
    private CommonEnums(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }
    
    /**
     * 根据状态码获取状态码描述
     * @param code 状态码
     * @return String 状态码描述
     */
    public static String getMessage(Integer code)
    {
        String result = null;
        for (CommonEnums c : CommonEnums.values())
        {
            if (c.code.equals(code))
            {
                result = c.message;
                break;
            }
        }
        return result;
    }
    
    @Override
    public Integer getCode()
    {
        return this.code;
    }
    
    public void setCode(Integer code)
    {
        this.code = code;
    }
    
    @Override
    public String getMessage()
    {
        return this.message;
    }
    
    public void setMessage(String message)
    {
        this.message = message;
    }
}
