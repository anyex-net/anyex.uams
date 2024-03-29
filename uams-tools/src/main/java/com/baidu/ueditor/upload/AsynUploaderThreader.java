package com.baidu.ueditor.upload;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import org.apache.log4j.Logger;

/**
 * 异步上传文件到阿里云OSS
 * 
 * @author XieXianbin me@xiexianbin.cn
 */
public class AsynUploaderThreader extends Thread
{
    private static Logger      logger    = Logger.getLogger(AsynUploaderThreader.class);
    
    private JSONObject stateJson = null;
    
    private OSSClient client    = null;
    
    private HttpServletRequest request   = null;
    
    public AsynUploaderThreader()
    {
    }
    
    public void init(JSONObject stateJson, OSSClient client, HttpServletRequest request)
    {
        this.stateJson = stateJson;
        this.client = client;
        this.request = request;
    }
    
    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        SynUploader synUploader = new SynUploader();
        synUploader.upload(stateJson, client, request);
        logger.debug("asynchronous upload image to aliyun oss success.");
    }
}
