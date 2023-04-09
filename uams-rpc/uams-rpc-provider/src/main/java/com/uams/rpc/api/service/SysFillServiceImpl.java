/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysFillMapper;
import com.uams.rpc.api.model.SysFillModel;
import com.uams.rpc.base.service.FutureInfoServiceImpl;
import com.uams.tools.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 平台成交信息表 服务实现类
 * <p>File：SysFillServiceImpl.java </p>
 * <p>Title: SysFillServiceImpl </p>
 * <p>Description:SysFillServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysFillServiceImpl extends GenericServiceImpl<SysFillModel> implements SysFillService
{
    public static final Logger logger = LoggerFactory.getLogger(FutureInfoServiceImpl.class);

    protected SysFillMapper sysFillMapper;

    @Autowired
    private SysFillService sysFillService;

    @Autowired
    public SysFillServiceImpl(SysFillMapper sysFillMapper)
    {
        super(sysFillMapper);
        this.sysFillMapper = sysFillMapper;
    }


    @Override
    public int saveRspQryFill(SysFillModel sysFillModel) throws BusinessException {
        SysFillModel sfm=new SysFillModel();
        sfm.setOrderNo(sysFillModel.getOrderNo());
        //根据委外编号查询该委外是否已经存在
        List<SysFillModel> sysFillModelList = sysFillService.findList(sfm);
        logger.debug("onRspQryFill解析成交信息...");
        if(sysFillModelList.size()==0){
            //执行插入
            logger.debug("插入成交信息开始");
            logger.debug("sysFillModel:" + sysFillModel);
            //插入时间
            sysFillModel.setCreateDate(new Date());
            //修改时间
            sysFillModel.setUpdateDate(new Date());
            sysFillMapper.insert(sysFillModel);
            logger.debug("sysFillModel成交信息结束");
        }else {
            //已经存在该委外，修改
            logger.debug("修改成交信息开始");
            //修改时间
            sysFillModel.setUpdateDate(new Date());
            //获取已存在的数据ID
            sysFillModel.setId(sysFillModelList.get(0).getId());
            updateByPrimaryKey(sysFillModel);
            logger.debug("修改成交信息结束");
        }
        logger.debug("saveRspQryFill解析成交信息结束");
        return 0;
    }
}
