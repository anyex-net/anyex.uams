package com.alibaba.aliyun.oss;

import org.apache.log4j.Logger;

import com.uams.tools.utils.PropertiesUtils;

public class OSSClientProperties
{
    private static Logger          logger            = Logger.getLogger(OSSClientProperties.class);
    
    private static PropertiesUtils properties        = new PropertiesUtils("OSSKey.properties");
    
    // 阿里云是否启用配置
    public static boolean          useStatus         = false;
    
    public static boolean          autoCreateBucket  = false;
    
    public static String           ossCliendEndPoint = "";
    
    public static String           ossEndPoint       = "";
    
    public static boolean          useCDN            = false;
    
    public static String           cdnEndPoint       = "";
    
    public static boolean          useLocalStorager  = false;
    
    public static String           uploadBasePath    = "upload";
    
    public static boolean          useAsynUploader   = false;
    static
    {
        try
        {
            ossEndPoint = properties.getProperty("ossEndPoint");
            cdnEndPoint = properties.getProperty("cdnEndPoint");
            uploadBasePath = properties.getProperty("uploadBasePath");
            ossCliendEndPoint = properties.getProperty("ossCliendEndPoint");
            useCDN = "true".equalsIgnoreCase(properties.getProperty("useCDN")) ? true : false;
            useStatus = "true".equalsIgnoreCase(properties.getProperty("useStatus")) ? true : false;
            useLocalStorager = "true".equalsIgnoreCase(properties.getProperty("useLocalStorager")) ? true : false;
            useAsynUploader = "true".equalsIgnoreCase(properties.getProperty("useAsynUploader")) ? true : false;
            autoCreateBucket = "true".equalsIgnoreCase(properties.getProperty("autoCreateBucket")) ? true : false;
        }
        catch (Exception e)
        {
            logger.warn("系统未找到指定文件：OSSKey.properties --> 系统按照ueditor默认配置执行。");
        }
    }
}
