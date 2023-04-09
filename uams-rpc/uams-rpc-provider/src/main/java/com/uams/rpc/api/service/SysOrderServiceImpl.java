/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysOrderMapper;
import com.uams.rpc.api.model.SysOrderModel;
import com.uams.rpc.base.service.FutureInfoServiceImpl;
import com.uams.tools.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 平台委托信息表 服务实现类
 * <p>File：SysOrderServiceImpl.java </p>
 * <p>Title: SysOrderServiceImpl </p>
 * <p>Description:SysOrderServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysOrderServiceImpl extends GenericServiceImpl<SysOrderModel> implements SysOrderService
{

    public static final Logger logger = LoggerFactory.getLogger(FutureInfoServiceImpl.class);

    protected SysOrderMapper sysOrderMapper;

    @Autowired
    private SysOrderService sysOrderService;

    @Autowired
    public SysOrderServiceImpl(SysOrderMapper sysOrderMapper)
    {
        super(sysOrderMapper);
        this.sysOrderMapper = sysOrderMapper;
    }

    @Override
    public int saveRspQryOrder(SysOrderModel sysOrderModel) throws BusinessException {
        SysOrderModel som=new SysOrderModel();
        som.setOrderNo(sysOrderModel.getOrderNo());
        //根据委外编号查询该委外是否已经存在
        List<SysOrderModel> sysOrderModelList = sysOrderService.findList(som);
        logger.debug("onRspQryOrder解析委托信息...");
        logger.debug("委外编号"+sysOrderModel.getOrderNo());
        if (sysOrderModel!= null) {
            if(sysOrderModelList.size()!=0 && sysOrderModelList!=null) {
                //已经存在该委外，修改
                logger.debug("修改处理开始");
                //修改时间
                sysOrderModel.setUpdateDate(new Date());
                //获取已存在的数据ID
                sysOrderModel.setId(sysOrderModelList.get(0).getId());
                sysOrderService.updateByPrimaryKey(sysOrderModel);
                logger.debug("修改处理结束");
            }else {
                //执行插入
                logger.debug("插入处理开始");
                logger.debug("sysOrderModel:" + sysOrderModel);
                //插入时间
                sysOrderModel.setCreateDate(new Date());
                sysOrderMapper.insert(sysOrderModel);
                logger.debug("sysOrderModel");
            }
        }
        logger.debug("saveRspQryOrder解析委托信息结束");
        return 0;
    }
}
