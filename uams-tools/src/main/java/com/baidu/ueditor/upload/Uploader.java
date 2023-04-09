package com.baidu.ueditor.upload;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.alibaba.aliyun.oss.BucketService;
import com.alibaba.aliyun.oss.OSSClientFactory;
import com.alibaba.aliyun.oss.OSSClientProperties;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.baidu.ueditor.SystemUtil;
import com.baidu.ueditor.define.State;
import com.uams.tools.consts.UamsConst;

/**
 * 同步上传文件到阿里云OSS<br>
 * 
 * @author XieXianbin me@xiexianbin.cn
 */
public class Uploader
{
    private static Logger       logger  = Logger.getLogger(Uploader.class);
    
    private HttpServletRequest  request = null;
    
    private Map<String, Object> conf    = null;
    
    public Uploader(HttpServletRequest request, Map<String, Object> conf)
    {
        this.request = request;
        this.conf = conf;
    }
    
    public final State doExec()
    {
        String filedName = (String) this.conf.get("fieldName");
        State state = null;
        if ("true".equals(this.conf.get("isBase64")))
        {
            state = Base64Uploader.save(this.request.getParameter(filedName), this.conf);
        }
        else
        {
            state = BinaryUploader.save(this.request, this.conf);
            JSONObject stateJson = JSON.parseObject(state.toJSONString());
            // 判别云同步方式
            if (OSSClientProperties.useStatus)
            {
                OSSClient client = OSSClientFactory.createOSSClient();
                // auto create Bucket to default zone
                if (OSSClientProperties.autoCreateBucket)
                {
                    Bucket bucket = BucketService.create(client, UamsConst.BUCKET_BITMS_NAME);
                    logger.debug("Bucket 's " + bucket.getName() + " Created.");
                }
                // upload type
                if (OSSClientProperties.useAsynUploader)
                {
                    AsynUploaderThreader asynThreader = new AsynUploaderThreader();
                    asynThreader.init(stateJson, client, this.request);
                    Thread uploadThreader = new Thread(asynThreader);
                    uploadThreader.start();
                }
                else
                {
                    SynUploader synUploader = new SynUploader();
                    synUploader.upload(stateJson, client, this.request);
                }
                // storage type
                if (false == OSSClientProperties.useLocalStorager)
                {
                    String uploadFilePath = this.conf.get("rootPath") + stateJson.getString("url");
                    File uploadFile = new File(uploadFilePath);
                    if (uploadFile.isFile() && uploadFile.exists())
                    {
                        uploadFile.delete();
                    }
                }
                state.putInfo("url", OSSClientProperties.ossEndPoint + stateJson.getString("url"));
            }
            else
            {
                state.putInfo("url", "/" + SystemUtil.getProjectName() + stateJson.getString("url"));
            }
        }
        logger.debug(state.toJSONString());
        return state;
    }
}
