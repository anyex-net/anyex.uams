/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysPositionProfitMapper;
import com.uams.rpc.api.model.SysPositionProfitModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

/**
 * 平台期货持仓损益信息表onRtnPositionProfit 服务实现类
 * <p>File：SysPositionProfitServiceImpl.java </p>
 * <p>Title: SysPositionProfitServiceImpl </p>
 * <p>Description:SysPositionProfitServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysPositionProfitServiceImpl extends GenericServiceImpl<SysPositionProfitModel> implements SysPositionProfitService
{

    protected SysPositionProfitMapper sysPositionProfitMapper;

    @Autowired
    public SysPositionProfitServiceImpl(SysPositionProfitMapper sysPositionProfitMapper)
    {
        super(sysPositionProfitMapper);
        this.sysPositionProfitMapper = sysPositionProfitMapper;
    }

    @Override
    public int saveSysPositionProfit(SysPositionProfitModel sysPositionProfitModel) throws BusinessException {

        SysPositionProfitModel sysPositionProfit=new SysPositionProfitModel();
        sysPositionProfit.setCalculatePrice(sysPositionProfit.getCalculatePrice());

        List<SysPositionProfitModel> sysPositionProfitModelList=findList(sysPositionProfit);

        logger.debug("平台期货持仓变化记录表(onRtnPosition)...");
        logger.debug(String.valueOf(ListUtils.isNotNull(sysPositionProfitModelList)));
        logger.debug("sysPositionProfitModelList.size():" + sysPositionProfitModelList.size());
        boolean save=true;

        if(sysPositionProfitModelList==null || sysPositionProfitModelList.size()==0){
            sysPositionProfit =new SysPositionProfitModel();
        }else {
            sysPositionProfit=sysPositionProfitModelList.get(0);
            save =false;
        }

        sysPositionProfit.setId(SerialnoUtils.buildPrimaryKey());

        sysPositionProfit.setCalculatePrice(sysPositionProfitModel.getCalculatePrice());
        sysPositionProfit.setLMEPositionProfit(sysPositionProfitModel.getLMEPositionProfit());
        sysPositionProfit.setOptionMarketValue(sysPositionProfitModel.getOptionMarketValue());
        sysPositionProfit.setPositionNo(sysPositionProfitModel.getPositionNo());
        sysPositionProfit.setPositionProfit(sysPositionProfitModel.getPositionProfit());
        sysPositionProfit.setPositionStreamId(sysPositionProfitModel.getPositionStreamId());
        sysPositionProfit.setRemark("22222");
        sysPositionProfit.setCreateDate(new Date());
        sysPositionProfit.setUpdateDate(new Date());

        if (save){
            insert(sysPositionProfit);
        }else {
            updateByPrimaryKey(sysPositionProfit);
        }
        logger.debug("onRspQryAccount平台期货持仓变化记录");
        return 0;
    }
}
