/*
 * @(#)ZttxConst.java 2015-4-14 下午2:02:23
 * Copyright 2015 Playguy, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.tools.consts;

import com.uams.tools.utils.PropertiesUtils;

/**
 * <p>File：BitmsConst.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-4-14 下午2:02:23</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class UamsConst
{
    public static final PropertiesUtils properties = new PropertiesUtils("uams.properties");
    
    private UamsConst()
    {// 防止实例化
    }
    
    /**
     * 当前页面
     */
    public static final Integer DEFAULT_CURRENT_PAGE  = 1;
    
    /**
     * 分页大小
     */
    public static final Integer DEFAULT_PAGE_SIZE     = 20;
    
    /**
     * 分页起始大小
     */
    public static final Integer DEFAULT_START_INDEX   = 0;
    
    /**
     * UUID length
     */
    public static final Integer UUID_SIZE             = 32;
    
    /**
     * COOKIE存放路径
     */
    public static final String  COOKIE_PATH           = "/";
    
    /**
     * 请求方式
     */
    public static final String  POST                  = "post";
    
    /**
     * 操作标识
     */
    public static final String  OP                    = "op";
    
    /**
     * 分割符
     */
    public static final char    SEPARATOR             = '|';
    
    // 阿里云
    public static final String  ALIYUN_ACCESS_KEY     = properties.getProperty("aliyun.access.key");
    
    public static final String  ALIYUN_ACCESS_SECRET  = properties.getProperty("aliyun.access.secret");
    
    public static final String  ALIYUN_OSS_ENDPOINT   = properties.getProperty("aliyun.access.endpoint");
    
    // amazon AWS
    public static final String  AWS_ACCESS_KEY_ID     = properties.getProperty("aws.access.key");
    
    public static final String  AWS_SECRET_ACCESS_KEY = properties.getProperty("aws.access.secret");
    
    public static final String  AWS_S3_ENDPOINT       = properties.getProperty("aws.access.endpoint");
    
    // 项目名称
    public static final String  PROJECT_NAME          = properties.getProperty("project.name");
    
    // HOSTURL
    public static final String  HOST_URL              = properties.getProperty("server.url");
    
    // 正式空间
    public static final String  BUCKET_BITMS_NAME     = properties.getProperty("bucket.release.name");
    
    public static final String  BUCKET_BITMS_URL      = properties.getProperty("bucket.release.url");
    
    // 临时空间
    public static final String  BUCKET_TEMP_NAME      = properties.getProperty("bucket.temp.name");
    
    public static final String  BUCKET_TEMP_URL       = properties.getProperty("bucket.temp.url");
    
    // 默认密码
    public static final String  DEFAULT_PASSWORD      = properties.getProperty("default.pwd");
    
    // 公用模块(如：注册、取回密码)
    public static final String  COMMON                = "/common";
    
    // 系统功能
    public static final String  SYSTEM                = "/system";
}
