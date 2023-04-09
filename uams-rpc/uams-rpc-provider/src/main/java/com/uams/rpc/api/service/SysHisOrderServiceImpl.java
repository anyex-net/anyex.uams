/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysHisOrderMapper;
import com.uams.rpc.api.model.SysHisOrderModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 平台历史委托表 服务实现类
 * <p>File：SysHisOrderServiceImpl.java </p>
 * <p>Title: SysHisOrderServiceImpl </p>
 * <p>Description:SysHisOrderServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysHisOrderServiceImpl extends GenericServiceImpl<SysHisOrderModel> implements SysHisOrderService
{

    protected SysHisOrderMapper sysHisOrderMapper;

    @Autowired
    public SysHisOrderServiceImpl(SysHisOrderMapper sysHisOrderMapper)
    {
        super(sysHisOrderMapper);
        this.sysHisOrderMapper = sysHisOrderMapper;
    }

    @Override
    public int saveSysHisOrder(SysHisOrderModel sysHisOrderModel) throws BusinessException {
        logger.debug("历史委托接口表(onRspQryHisOrder)...");
        if (sysHisOrderModel!= null) {
            logger.debug("sysHisOrderModel处理开始");
            logger.debug("sysHisOrderModel:"+sysHisOrderModel);
            sysHisOrderModel.setId(SerialnoUtils.buildPrimaryKey());
            sysHisOrderModel.setUpdateDate(new Date());
            sysHisOrderModel.setCreateDate(new Date());
            sysHisOrderModel.setRemark("1111");
            insert(sysHisOrderModel);
            logger.debug("sysHisOrderModel");
        }
        logger.debug("历史委托接口表(onRspQryHisOrder)结束");
        return 0;
    }
}
