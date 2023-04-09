/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysAccountFundChangeMapper;
import com.uams.rpc.api.model.SysAccountFundChangeModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * SysAccountFundChange 服务实现类
 * <p>File：SysAccountFundChangeServiceImpl.java </p>
 * <p>Title: SysAccountFundChangeServiceImpl </p>
 * <p>Description:SysAccountFundChangeServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysAccountFundChangeServiceImpl extends GenericServiceImpl<SysAccountFundChangeModel> implements SysAccountFundChangeService
{

    protected SysAccountFundChangeMapper sysAccountFundChangeMapper;

    @Autowired
    public SysAccountFundChangeServiceImpl(SysAccountFundChangeMapper sysAccountFundChangeMapper)
    {
        super(sysAccountFundChangeMapper);
        this.sysAccountFundChangeMapper = sysAccountFundChangeMapper;
    }

    @Override
    public int saveSysAccountFundChange(SysAccountFundChangeModel sysAccountFundChangeModel) throws BusinessException {
        logger.debug("onRtnFund解析平台资金账户资金变化记录...");
        if (sysAccountFundChangeModel!= null) {
            logger.debug("sysAccountFundChangeModel处理开始");
            logger.debug("sysAccountFundChangeModel:"+sysAccountFundChangeModel);
            sysAccountFundChangeModel.setId(SerialnoUtils.buildPrimaryKey());
            sysAccountFundChangeModel.setUpdateDate(new Date());
            sysAccountFundChangeModel.setCreateDate(new Date());
            sysAccountFundChangeModel.setRemark("1111");
            insert(sysAccountFundChangeModel);
            logger.debug("sysAccountFundChangeModel");
        }
        logger.debug("onRtnFund解析交易信息结束");

        return 0;
    }
}
