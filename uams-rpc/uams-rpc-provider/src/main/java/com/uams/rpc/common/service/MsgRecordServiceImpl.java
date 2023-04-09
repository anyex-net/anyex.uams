/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.common.consts.MessageConst;
import com.uams.rpc.common.entity.MsgRecord;
import com.uams.rpc.common.entity.MsgTemplate;
import com.uams.rpc.common.enums.MessageEnums;
import com.uams.rpc.common.mapper.MsgRecordMapper;
import com.uams.rpc.common.mapper.MsgTemplateMapper;
import com.uams.rpc.common.model.SMSResult;
import com.uams.rpc.common.utils.SMSClient;
import com.uams.tools.bean.SendMail;
import com.uams.tools.consts.CacheConst;
import com.uams.tools.consts.UamsConst;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.*;

/**
 * 短信记录表 服务实现类
 * <p>File：MsgRecordServiceImpl.java </p>
 * <p>Title: MsgRecordServiceImpl </p>
 * <p>Description:MsgRecordServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
@Service
public class MsgRecordServiceImpl extends GenericServiceImpl<MsgRecord> implements MsgRecordService
{
    protected MsgRecordMapper msgRecordMapper;
    
    @Autowired
    private MsgTemplateMapper msgTemplateMapper;
    
//    @Autowired
//    private SendMail          sendMail;
    
    @Autowired
    public MsgRecordServiceImpl(MsgRecordMapper msgRecordMapper)
    {
        super(msgRecordMapper);
        this.msgRecordMapper = msgRecordMapper;
    }
    
    @Override
    public void sendSms(String phone, String lang, String type) throws BusinessException
    {
        if (StringUtils.isBlank(phone)) { throw new BusinessException(CommonEnums.ERROR_PARAMS_VALID); }
        String expireKey = new StringBuffer(CacheConst.CACHE_EXPIRE_SMS_PERFIX).append(UamsConst.SEPARATOR).append(type).append(UamsConst.SEPARATOR).append(phone).toString();
        if (StringUtils.isNotBlank(RedisUtils.get(expireKey)))
        { // 一分钟内只允许发送一次短信
            return;
        }
        MsgTemplate template = msgTemplateMapper.findByKeyAndLang(MessageConst.TEMPLATE_SMS_SENDVALICODE, MessageConst.MESSAGE_SMS, lang);
        if (null == template) throw new BusinessException(MessageEnums.ERROR_TEMPLATE_NOTEXISTS);
        String cacheKey = new StringBuffer(CacheConst.CACHE_SEND_SMS_PERFIX).append(UamsConst.SEPARATOR).append(type).append(UamsConst.SEPARATOR).append(phone).toString();
        String randomKey = RedisUtils.get(cacheKey);
        if (StringUtils.isBlank(randomKey)) randomKey = SerialnoUtils.randomNum(6);
        RedisUtils.putObject(cacheKey, randomKey, CacheConst.FIFTEEN_MINUTE_CACHE_TIME);
        RedisUtils.putObject(expireKey, phone, 60);// 加入一分钟限制
        String content = String.format(template.getContent(), randomKey);
        MsgRecord record = new MsgRecord("sms", phone, content, Boolean.FALSE);
        record.setId(SerialnoUtils.buildPrimaryKey());
        record.setCreateDate(CalendarUtils.getCurrentLong());
        new Thread(() -> {
            try
            {
                SMSResult result = SMSClient.sendIntSMS(phone, content);
                if (StringUtils.isNotBlank(result.getMsgid()))
                {// 表示发送成功
                    record.setStatus(Boolean.TRUE);
                }
            }
            catch (BusinessException e)
            {
                LoggerUtils.logError(logger, e.getMessage());
            }
            finally
            {
                msgRecordMapper.insert(record);
            }
        }).start();
    }
    
    @Override
    public boolean validSMSCode(String phone, String validCode, String type)
    {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(validCode)) return false;
        String cacheKey = new StringBuffer(CacheConst.CACHE_SEND_SMS_PERFIX).append(UamsConst.SEPARATOR).append(type).append(UamsConst.SEPARATOR).append(phone).toString();
        String sysCode = RedisUtils.get(cacheKey);
        boolean flag = StringUtils.equalsIgnoreCase(validCode, sysCode) ? true : false;
        if (flag)
        {
            String expireKey = new StringBuffer(CacheConst.CACHE_EXPIRE_SMS_PERFIX).append(UamsConst.SEPARATOR).append(type).append(UamsConst.SEPARATOR).append(phone).toString();
            RedisUtils.del(cacheKey);// 用完之后清除缓存
            RedisUtils.del(expireKey);// 清除发送发送次数缓存
        }
        return flag;
    }
}
