package com.alibaba.aliyun.oss;

import org.apache.log4j.Logger;

import com.aliyun.oss.OSSClient;
import com.uams.tools.consts.UamsConst;

/**
 * OSSClient是OSS服务的Java客户端，它为调用者提供了一系列的方法，用于和OSS服务进行交互<br>
 * 
 */
public class OSSClientFactory
{
    private static Logger    logger = Logger.getLogger(OSSClientFactory.class);
    
    private static OSSClient client = null;
    
    /**
     * 新建OSSClient 
     * 
     * @return client
     */
    public static OSSClient createOSSClient()
    {
        if (null == client)
        {
            client = new OSSClient(UamsConst.ALIYUN_OSS_ENDPOINT, UamsConst.ALIYUN_ACCESS_KEY, UamsConst.ALIYUN_ACCESS_SECRET);
            logger.info("First CreateOSSClient success.");
        }
        return client;
    }
}
