/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysOrderProcessMapper;
import com.uams.rpc.api.model.SysOrderProcessModel;
import com.uams.rpc.base.service.FutureInfoServiceImpl;
import com.uams.tools.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 平台委托处理状态表 服务实现类
 * <p>File：SysOrderProcessServiceImpl.java </p>
 * <p>Title: SysOrderProcessServiceImpl </p>
 * <p>Description:SysOrderProcessServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysOrderProcessServiceImpl extends GenericServiceImpl<SysOrderProcessModel> implements SysOrderProcessService
{

    public static final Logger logger = LoggerFactory.getLogger(FutureInfoServiceImpl.class);

    protected SysOrderProcessMapper sysOrderProcessMapper;

    @Autowired
    public SysOrderProcessServiceImpl(SysOrderProcessMapper sysOrderProcessMapper)
    {
        super(sysOrderProcessMapper);
        this.sysOrderProcessMapper = sysOrderProcessMapper;
    }

    @Override
    public int saveRspQryOrderProcess(SysOrderProcessModel sysOrderProcessModel) throws BusinessException {
        SysOrderProcessModel sopm=new SysOrderProcessModel();
        sopm.setOrderNo(sysOrderProcessModel.getOrderNo());
        //根据委外编号查询该委外是否已经存在
        List<SysOrderProcessModel> sysOrderProcessModelList = findList(sopm);
        logger.debug("saveRspQryOrderProcess解析委托处理状态信息...");
        logger.debug("委外编号"+sysOrderProcessModel.getOrderNo());
        if(sysOrderProcessModelList.size()!=0) {
            //已经存在该委外，修改
            logger.debug("修改委托处理状态开始");
            //修改时间
            sysOrderProcessModel.setUpdateDate(new Date());
            //获取已存在的数据ID
            sysOrderProcessModel.setId(sysOrderProcessModelList.get(0).getId());
            sysOrderProcessMapper.updateByPrimaryKey(sysOrderProcessModel);
            logger.debug("修改委托处理状态结束");
        }else {
            //执行插入
            logger.debug("插入委托处理状态开始");
            logger.debug("sysOrderProcessModel:" + sysOrderProcessModel);
            //插入时间
            sysOrderProcessModel.setCreateDate(new Date());
            sysOrderProcessMapper.insert(sysOrderProcessModel);
            logger.debug("sysOrderProcessModel");
        }

        logger.debug("saveRspQryOrderProcess解析委托处理状态结束");
        return 0;
    }
}
