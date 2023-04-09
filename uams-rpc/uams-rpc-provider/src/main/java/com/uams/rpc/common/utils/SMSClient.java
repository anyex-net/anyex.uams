package com.uams.rpc.common.utils;

import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSON;
import com.uams.orm.utils.EncryptUtils;
import com.uams.rpc.common.model.SMSModel;
import com.uams.rpc.common.model.SMSResult;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.HttpUtils;
import com.uams.tools.utils.PropertiesUtils;
import com.uams.tools.utils.StringUtils;

/**
 * 短信发送客户端 Introduce
 * <p>File：SMSClient.java</p>
 * <p>Title: SMSClient</p>
 * <p>Description: SMSClient</p>
 * <p>Copyright: Copyright (c) 2017/7/5</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public abstract class SMSClient
{
    public static final PropertiesUtils properties        = new PropertiesUtils("sms.properties");
    
    public static final String          SEND_SIGNATURE_EN = properties.getProperty("sms.signature.en");
    
    public static final String          SEND_SIGNATURE_CN = properties.getProperty("sms.signature.cn");
    

    
    /**
     * 发送国内短信服务
     * @param mobile
     * @param content
     * @return {@link SMSResult}
     * @throws BusinessException
     */
    public static SMSResult sendSMS(String mobile, String content) throws BusinessException
    {
        if (StringUtils.isBlank(mobile) || StringUtils.isBlank(content))
        {// 防止空指针
            throw new BusinessException(CommonEnums.ERROR_PARAMS_VALID);
        }
        SMSModel model = new SMSModel();
        model.setAccount(properties.getProperty("sms.send.user.prop"));
        model.setPassword(EncryptUtils.desDecrypt(properties.getProperty("sms.send.pass.prop")));
        model.setPhone(mobile);
        model.setMsg(content);
        model.setReport(true);
        if (StringUtils.isNotBlank(SEND_SIGNATURE_CN))
        {
            StringBuffer sms = new StringBuffer(content).append("【").append(SEND_SIGNATURE_CN).append("】");
            model.setMsg(sms.toString());
        }
        String params = JSON.toJSONString(model);
        CloseableHttpClient client = HttpUtils.getHttpClient2();
        String response = HttpUtils.postWithJSON(client, properties.getProperty("sms.send.host.prop"), params);
        HttpUtils.releaseHttpClient(client);
        if (StringUtils.isBlank(response)) return null;
        return JSON.parseObject(response, SMSResult.class);
    }
    
    /**
     * 发送国际短信服务
     * @param mobile
     * @param content
     * @return {@link SMSResult}
     * @throws BusinessException
     */
    public static SMSResult sendIntSMS(String mobile, String content) throws BusinessException
    {
        if (StringUtils.isBlank(mobile) || StringUtils.isBlank(content))
        {// 防止空指针
            throw new BusinessException(CommonEnums.ERROR_PARAMS_VALID);
        }
        SMSModel model = new SMSModel();
        model.setAccount(properties.getProperty("sms.send.intuser.prop"));
        model.setPassword(EncryptUtils.desDecrypt(properties.getProperty("sms.send.intpass.prop")));
        model.setMobile(mobile);
        if (StringUtils.isNotBlank(SEND_SIGNATURE_EN))
        {
            StringBuffer sms = new StringBuffer(content).append("【").append(SEND_SIGNATURE_EN).append("】");
            model.setMsg(sms.toString());
        }
        String params = JSON.toJSONString(model);
        CloseableHttpClient client = HttpUtils.getHttpClient2();
        String response = HttpUtils.postWithJSON(client, properties.getProperty("sms.send.inthost.prop"), params);
        HttpUtils.releaseHttpClient(client);
        if (StringUtils.isBlank(response)) return null;
        return JSON.parseObject(response, SMSResult.class);
    }
    
    public static void main(String[] args) throws BusinessException
    {
        SMSResult result = sendIntSMS("8615306620878", "BITMS SMS TEST");
        System.out.println(JSON.toJSONString(result));
    }
}
