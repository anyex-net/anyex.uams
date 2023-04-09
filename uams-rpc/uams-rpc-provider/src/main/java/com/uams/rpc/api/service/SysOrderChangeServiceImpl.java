/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysOrderChangeMapper;
import com.uams.rpc.api.model.SysOrderChangeModel;
import com.uams.rpc.base.service.FutureInfoServiceImpl;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 平台委托变化记录表 服务实现类
 * <p>File：SysOrderChangeServiceImpl.java </p>
 * <p>Title: SysOrderChangeServiceImpl </p>
 * <p>Description:SysOrderChangeServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysOrderChangeServiceImpl extends GenericServiceImpl<SysOrderChangeModel> implements SysOrderChangeService
{
    public static final Logger logger = LoggerFactory.getLogger(FutureInfoServiceImpl.class);

    protected SysOrderChangeMapper sysOrderChangeMapper;

    @Autowired
    private SysOrderChangeService sysOrderChangeService;

    @Autowired
    public SysOrderChangeServiceImpl(SysOrderChangeMapper sysOrderChangeMapper)
    {
        super(sysOrderChangeMapper);
        this.sysOrderChangeMapper = sysOrderChangeMapper;
    }

    @Override
    public int saveRtnOrderChange(SysOrderChangeModel sysOrderChangeModel) throws BusinessException {
        SysOrderChangeModel socm=new SysOrderChangeModel();
        socm.setOrderNo(sysOrderChangeModel.getOrderNo());
        //根据委外编号查询该委外是否已经存在
        List<SysOrderChangeModel> sysOrderChangeModelList = sysOrderChangeService.findList(socm);
        logger.debug("saveRtnOrderChange解析委托变化信息...");
        logger.debug("委外编号"+sysOrderChangeModel.getOrderNo());
        if (sysOrderChangeModel!= null) {
            if(sysOrderChangeModelList.size()!=0) {
                //已经存在该委外，修改
                logger.debug("修改委托变化开始");
                //修改时间
                sysOrderChangeModel.setUpdateDate(new Date());
                //获取已存在的数据ID
                sysOrderChangeModel.setId(sysOrderChangeModelList.get(0).getId());
                sysOrderChangeService.updateByPrimaryKey(sysOrderChangeModel);
                logger.debug("修改委托变化结束");
            }else {
                //执行插入
                logger.debug("插入委托变化开始");
                logger.debug("sysOrderChangeModel:" + sysOrderChangeModel);
                //插入时间
                sysOrderChangeModel.setCreateDate(new Date());
                sysOrderChangeMapper.insert(sysOrderChangeModel);
                logger.debug("sysOrderChangeModel委托变化结束");
            }
        }
        logger.debug("saveRtnOrderChange解析委托变化信息结束");
        return 0;
    }
}
