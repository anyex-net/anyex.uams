/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysHisMatchMapper;
import com.uams.rpc.api.model.SysHisMatchModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 平台历史成交表 服务实现类
 * <p>File：SysHisMatchServiceImpl.java </p>
 * <p>Title: SysHisMatchServiceImpl </p>
 * <p>Description:SysHisMatchServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysHisMatchServiceImpl extends GenericServiceImpl<SysHisMatchModel> implements SysHisMatchService
{

    protected SysHisMatchMapper sysHisMatchMapper;

    @Autowired
    public SysHisMatchServiceImpl(SysHisMatchMapper sysHisMatchMapper)
    {
        super(sysHisMatchMapper);
        this.sysHisMatchMapper = sysHisMatchMapper;
    }

    /**
     * 添加历史成交
     *
     * @param sysHisMatchModel
     * @return
     * @throws BusinessException
     */
    @Override
    public int saveSysHisMatch(SysHisMatchModel sysHisMatchModel) throws BusinessException {

        logger.debug("onRspQryHisMatch解析历史成交信息...");
        if (sysHisMatchModel!= null) {
            logger.debug("sysHisMatchModel");
            logger.debug("sysHisMatchModel:"+sysHisMatchModel);
            sysHisMatchModel.setId(SerialnoUtils.buildPrimaryKey());
            sysHisMatchModel.setUpdateDate(new Date());
            sysHisMatchModel.setCreateDate(new Date());
            sysHisMatchModel.setRemark("1111");
            insert(sysHisMatchModel);
            logger.debug("sysHisMatchModel");
        }
        logger.debug("onRspQryHisMatch解析历史成交信息结束");

        return 0;
    }
}
