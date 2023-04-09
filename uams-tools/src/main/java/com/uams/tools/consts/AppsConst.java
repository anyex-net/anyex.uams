/*
 * @(#)ZttxConst.java 2015-4-14 下午2:02:23
 * Copyright 2015 Playguy, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.tools.consts;

/**
 * <p>File：AppsConst.java</p>
 * <p>Title:AppsConst </p>
 * <p>Description:AppsConst</p>
 * <p>Copyright: Copyright (c) 2015 2015-4-14 下午2:02:23</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class AppsConst
{
    private AppsConst()
    {// 防止实例化
    }
    
    // 登陆类型短信码
    public static final String SMS_VALID_LOGIN     = "login";
    
    // 注册类型短信码
    public static final String SMS_VALID_REGISTER  = "register";
    
    // 修改密码类型短信码
    public static final String SMS_VALID_MODIFYPWD = "modifyPwd";
    
    // 其它类型短信码
    public static final String SMS_VALID_OTHER     = "other";
    
    // 默认国家代码
    public static final String DEFAULT_COUNTRY     = "86";
}
