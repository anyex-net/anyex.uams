/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysPositionMapper;
import com.uams.rpc.api.model.SysPositionModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 平台期货持仓信息表onRspQryPosition 服务实现类
 * <p>File：SysPositionServiceImpl.java </p>
 * <p>Title: SysPositionServiceImpl </p>
 * <p>Description:SysPositionServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysPositionServiceImpl extends GenericServiceImpl<SysPositionModel> implements SysPositionService
{

    protected SysPositionMapper sysPositionMapper;

    @Autowired
    public SysPositionServiceImpl(SysPositionMapper sysPositionMapper)
    {
        super(sysPositionMapper);
        this.sysPositionMapper = sysPositionMapper;
    }
    @Override
    public int saveSysPosition(SysPositionModel sysPositionModel) throws BusinessException {

        SysPositionModel sysPosition=new SysPositionModel();
        sysPosition.setAccountNo(sysPositionModel.getAccountNo());
        List<SysPositionModel> sysPositionModelList=findList(sysPosition);

        logger.debug("平台期货持仓记录表(onRtnPosition)...");
        logger.debug(String.valueOf(ListUtils.isNotNull(sysPositionModelList)));
        logger.debug("sysPositionModelList.size():" + sysPositionModelList.size());
        boolean save=true;

        if(sysPositionModelList==null || sysPositionModelList.size()==0){
            sysPosition =new SysPositionModel();
        }else {
            sysPosition=sysPositionModelList.get(0);
            save =false;
        }
        sysPosition.setId(SerialnoUtils.buildPrimaryKey());
        sysPosition.setAccountInitialMargin(sysPositionModel.getAccountInitialMargin());
        sysPosition.setAccountMaintenanceMargin(sysPositionModel.getAccountMaintenanceMargin());
        sysPosition.setAccountNo(sysPositionModel.getAccountNo());
        sysPosition.setCalculatePrice(sysPositionModel.getCalculatePrice());
        sysPosition.setCallOrPutFlag(String.valueOf(sysPositionModel.getCallOrPutFlag()));
        sysPosition.setCommodityCurrency(sysPositionModel.getCommodityCurrency());
        sysPosition.setCommodityCurrencyGroup(sysPositionModel.getCommodityCurrencyGroup());
        sysPosition.setCommodityNo(sysPositionModel.getCommodityNo());
        sysPosition.setCommodityType(String.valueOf(sysPositionModel.getCommodityType()));
        sysPosition.setContractNo(sysPositionModel.getContractNo());
        sysPosition.setExchangeNo(sysPositionModel.getExchangeNo());
        sysPosition.setHedgeFlag(String.valueOf(sysPositionModel.getHedgeFlag()));
        sysPosition.setLMEPositionProfit(sysPositionModel.getLMEPositionProfit());
        sysPosition.setMatchNo(sysPositionModel.getMatchNo());
        sysPosition.setMatchSide(String.valueOf(sysPositionModel.getMatchSide()));
        sysPosition.setOptionMarketValue(sysPositionModel.getOptionMarketValue());
        sysPosition.setOrderNo(sysPositionModel.getOrderNo());
        sysPosition.setPositionNo(sysPositionModel.getPositionNo());
        sysPosition.setPositionPrice(sysPositionModel.getPositionPrice());

        sysPosition.setPositionQty(sysPositionModel.getPositionQty());

        sysPosition.setPositionProfit(sysPositionModel.getPositionProfit());
        sysPosition.setPositionStreamId(sysPositionModel.getPositionStreamId());
        sysPosition.setServerFlag(String.valueOf(sysPositionModel.getServerFlag()));
        sysPosition.setStrikePrice(sysPositionModel.getStrikePrice());
        sysPosition.setUpperInitialMargin(sysPositionModel.getUpperInitialMargin());
        sysPosition.setUpperMaintenanceMargin(sysPositionModel.getUpperMaintenanceMargin());
        sysPosition.setUpperNo(sysPositionModel.getUpperNo());
        sysPosition.setRemark("22222");
        sysPosition.setCreateDate(new Date());
        sysPosition.setUpdateDate(new Date());

        if (save){
            insert(sysPosition);
        }else {
            updateByPrimaryKey(sysPosition);
        }
        logger.debug("onRspQryAccount平台期货持仓变化记录");
        return 0;
    }
}
