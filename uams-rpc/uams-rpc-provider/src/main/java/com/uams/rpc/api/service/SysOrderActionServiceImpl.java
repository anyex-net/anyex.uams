/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysOrderActionMapper;
import com.uams.rpc.api.model.SysOrderActionModel;
import com.uams.rpc.base.service.FutureInfoServiceImpl;
import com.uams.tools.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 平台委托实时响应表 服务实现类
 * <p>File：SysOrderActionServiceImpl.java </p>
 * <p>Title: SysOrderActionServiceImpl </p>
 * <p>Description:SysOrderActionServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysOrderActionServiceImpl extends GenericServiceImpl<SysOrderActionModel> implements SysOrderActionService
{
    public static final Logger logger = LoggerFactory.getLogger(FutureInfoServiceImpl.class);

    protected SysOrderActionMapper sysOrderActionMapper;

    @Autowired
    private SysOrderActionService sysOrderActionService;

    @Autowired
    public SysOrderActionServiceImpl(SysOrderActionMapper sysOrderActionMapper)
    {
        super(sysOrderActionMapper);
        this.sysOrderActionMapper = sysOrderActionMapper;
    }

    @Override
    public int saveRspOrderAction(SysOrderActionModel sysOrderActionModel) throws BusinessException {
        SysOrderActionModel soam=new SysOrderActionModel();
        soam.setOrderNo(sysOrderActionModel.getOrderNo());
        //根据委外编号查询该委外是否已经存在
        List<SysOrderActionModel> sysFillModelList = findList(soam);
        logger.debug("onOrderAction解析委托实时响应信息...");
        if(sysFillModelList.size()==0){
            //执行插入
            logger.debug("插入委托实时响应信息开始");
            logger.debug("sysOrderActionModel:" + sysOrderActionModel);
            //插入时间
            sysOrderActionModel.setCreateDate(new Date());
            //修改时间
            sysOrderActionModel.setUpdateDate(new Date());
            sysOrderActionMapper.insert(sysOrderActionModel);
            logger.debug("sysOrderActionModel委托实时响应信息结束");
        }else {
            //已经存在该委外，修改
            logger.debug("修改委托实时响应信息开始");
            //修改时间
            sysOrderActionModel.setUpdateDate(new Date());
            //获取已存在的数据ID
            sysOrderActionModel.setId(sysFillModelList.get(0).getId());
            updateByPrimaryKey(sysOrderActionModel);
            logger.debug("修改委托实时响应信息结束");
        }
        logger.debug("saveRspOrderAction解析委托实时响应信息结束");
        return 0;
    }
}
