package com.uams.tools.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.jaq.model.v20161123.AfsCheckRequest;
import com.aliyuncs.jaq.model.v20161123.AfsCheckResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.uams.tools.bean.AliyunModel;
import com.uams.tools.consts.UamsConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AliyunUtils Introduce
 * <p>File：AliyunUtils.java</p>
 * <p>Title: AliyunUtils</p>
 * <p>Description: AliyunUtils</p>
 * <p>Copyright: Copyright (c) 2017/8/3</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class AliyunUtils
{
    private static IAcsClient client;
    
    private AliyunUtils()
    {// 防止实例化
    }
    
    public static final Logger logger = LoggerFactory.getLogger(AliyunUtils.class);
    static
    {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", UamsConst.ALIYUN_ACCESS_KEY, UamsConst.ALIYUN_ACCESS_SECRET);
        client = new DefaultAcsClient(profile);
        try
        {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Jaq", "jaq.aliyuncs.com");
        }
        catch (ClientException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 判断用户验证码
     * @param model
     * @return {@link Boolean}
     */
    public static Boolean validParams(AliyunModel model)
    {
        try
        {
            AfsCheckRequest request = new AfsCheckRequest();
            request.setPlatform(3);// 必填参数，请求来源： 1：Android端； 2：iOS端； 3：PC端及其他
            request.setSession(model.getCsessionid());// 必填参数，从前端获取，不可更改
            request.setSig(model.getSig());// 必填参数，从前端获取，不可更改
            request.setToken(model.getToken());// 必填参数，从前端获取，不可更改
            request.setScene(model.getScene());// 必填参数，从前端获取，不可更改
            AfsCheckResponse response = client.getAcsResponse(request);
            return null != response.getData() ? response.getData() : false;
        }
        catch (ClientException e)
        {
            LoggerUtils.logError(logger, e.getMessage());
        }
        return false;
    }
}
