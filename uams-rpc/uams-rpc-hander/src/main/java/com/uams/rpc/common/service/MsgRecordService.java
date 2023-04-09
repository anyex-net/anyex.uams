/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.common.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.common.entity.MsgRecord;
import com.uams.tools.exception.BusinessException;

/**
 * 短信记录表 服务接口
 * <p>File：MsgRecordService.java </p>
 * <p>Title: MsgRecordService </p>
 * <p>Description:MsgRecordService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public interface MsgRecordService extends GenericService<MsgRecord>
{
    /**
    * 发送手机验证码
    * @param phone 手机号
    * @param lang 语言编码
    * @param type 短信类别
    * @throws BusinessException
    */
    void sendSms(String phone, String lang, String type) throws BusinessException;
    
    /**
     * 验证手机验证码
     * @param phone
     * @param validCode
     * @param type 短信类别
     * @return {@link Boolean}
     */
    boolean validSMSCode(String phone, String validCode, String type);


}
