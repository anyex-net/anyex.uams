package com.baidu.ueditor.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.alibaba.aliyun.oss.ObjectService;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.baidu.ueditor.SystemUtil;
import com.uams.tools.consts.UamsConst;

/**
 * 同步上传文件到阿里云OSS<br>
 * 
 * @author XieXianbin me@xiexianbin.cn
 */
public class SynUploader extends Thread
{
    private static Logger logger = Logger.getLogger(SynUploader.class);
    
    public boolean upload(JSONObject stateJson, OSSClient client, HttpServletRequest request)
    {
        String key = stateJson.getString("url").replaceFirst("/", "");
        try
        {
            FileInputStream fileInputStream = new FileInputStream(new File(SystemUtil.getProjectRootPath() + key));
            PutObjectResult result = ObjectService.putObject(client, UamsConst.BUCKET_BITMS_NAME, key, fileInputStream);
            logger.debug("upload file to aliyun OSS object server success. ETag: " + result.getETag());
            return true;
        }
        catch (FileNotFoundException e)
        {
            logger.error("upload file to aliyun OSS object server occur FileNotFoundException.");
        }
        catch (NumberFormatException e)
        {
            logger.error("upload file to aliyun OSS object server occur NumberFormatException.");
        }
        catch (IOException e)
        {
            logger.error("upload file to aliyun OSS object server occur IOException.");
        }
        return false;
    }
}
