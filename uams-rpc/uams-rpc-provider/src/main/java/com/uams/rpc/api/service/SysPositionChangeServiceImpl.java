/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysPositionChangeMapper;
import com.uams.rpc.api.model.SysAccountModel;
import com.uams.rpc.api.model.SysPositionChangeModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 平台期货持仓变化记录表 服务实现类
 * <p>File：SysPositionChangeServiceImpl.java </p>
 * <p>Title: SysPositionChangeServiceImpl </p>
 * <p>Description:SysPositionChangeServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysPositionChangeServiceImpl extends GenericServiceImpl<SysPositionChangeModel> implements SysPositionChangeService
{

    protected SysPositionChangeMapper sysPositionChangeMapper;

    @Autowired
    public SysPositionChangeServiceImpl(SysPositionChangeMapper sysPositionChangeMapper)
    {
        super(sysPositionChangeMapper);
        this.sysPositionChangeMapper = sysPositionChangeMapper;
    }

    @Override
    public int saveSysPositionChange(SysPositionChangeModel sysPositionChangeModel) throws BusinessException {

        SysPositionChangeModel sysPositionChange=new SysPositionChangeModel();

        sysPositionChange.setAccountInitialMargin(sysPositionChange.getAccountInitialMargin());

        List<SysPositionChangeModel> sysPositionChangeModelList=findList(sysPositionChange);

        logger.debug("平台期货持仓变化记录表(onRtnPosition)...");
        logger.debug(String.valueOf(ListUtils.isNotNull(sysPositionChangeModelList)));
        logger.debug("sysPositionChangeModelList.size():" + sysPositionChangeModelList.size());
        boolean save=true;

        if(sysPositionChangeModelList==null || sysPositionChangeModelList.size()==0){
            sysPositionChange =new SysPositionChangeModel();
        }else {
            sysPositionChange=sysPositionChangeModelList.get(0);
            save =false;
        }
        sysPositionChange.setId(SerialnoUtils.buildPrimaryKey());
        sysPositionChange.setAccountInitialMargin(sysPositionChangeModel.getAccountInitialMargin());
        sysPositionChange.setAccountMaintenanceMargin(sysPositionChangeModel.getAccountMaintenanceMargin());
        sysPositionChange.setAccountNo(sysPositionChangeModel.getAccountNo());
        sysPositionChange.setCalculatePrice(sysPositionChangeModel.getCalculatePrice());
        sysPositionChange.setCallOrPutFlag(String.valueOf(sysPositionChangeModel.getCallOrPutFlag()));
        sysPositionChange.setCommodityCurrency(sysPositionChangeModel.getCommodityCurrency());
        sysPositionChange.setCommodityCurrencyGroup(sysPositionChangeModel.getCommodityCurrencyGroup());
        sysPositionChange.setCommodityNo(sysPositionChangeModel.getCommodityNo());
        sysPositionChange.setCommodityType(String.valueOf(sysPositionChangeModel.getCommodityType()));
        sysPositionChange.setContractNo(sysPositionChangeModel.getContractNo());
        sysPositionChange.setExchangeNo(sysPositionChangeModel.getExchangeNo());
        sysPositionChange.setHedgeFlag(String.valueOf(sysPositionChangeModel.getHedgeFlag()));
        sysPositionChange.setLMEPositionProfit(sysPositionChangeModel.getLMEPositionProfit());
        sysPositionChange.setMatchNo(sysPositionChangeModel.getMatchNo());
        sysPositionChange.setMatchSide(String.valueOf(sysPositionChangeModel.getMatchSide()));
        sysPositionChange.setOptionMarketValue(sysPositionChangeModel.getOptionMarketValue());
        sysPositionChange.setOrderNo(sysPositionChangeModel.getOrderNo());
        sysPositionChange.setPositionNo(sysPositionChangeModel.getPositionNo());
        sysPositionChange.setPositionPrice(sysPositionChangeModel.getPositionPrice());
        sysPositionChange.setPositionProfit(sysPositionChangeModel.getPositionProfit());
        sysPositionChange.setPositionQty(sysPositionChangeModel.getPositionQty());
        sysPositionChange.setPositionStreamId(sysPositionChangeModel.getPositionStreamId());
        sysPositionChange.setServerFlag(String.valueOf(sysPositionChangeModel.getServerFlag()));
        sysPositionChange.setStrikePrice(sysPositionChangeModel.getStrikePrice());
        sysPositionChange.setUpperInitialMargin(sysPositionChangeModel.getUpperInitialMargin());
        sysPositionChange.setUpperMaintenanceMargin(sysPositionChangeModel.getUpperMaintenanceMargin());
        sysPositionChange.setUpperNo(sysPositionChangeModel.getUpperNo());
        sysPositionChange.setRemark("22222");
        sysPositionChange.setCreateDate(new Date());
        sysPositionChange.setUpdateDate(new Date());
        if (save){
            insert(sysPositionChange);
        }else {
            updateByPrimaryKey(sysPositionChange);
        }
        logger.debug("onRspQryAccount平台期货持仓变化记录");
        return 0;
    }
}
