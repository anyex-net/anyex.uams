/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysAccountMarginRentMapper;
import com.uams.rpc.api.model.SysAccountMarginRentModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 平台资金账户保证金信息表 服务实现类
 * <p>File：SysAccountMarginRentServiceImpl.java </p>
 * <p>Title: SysAccountMarginRentServiceImpl </p>
 * <p>Description:SysAccountMarginRentServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysAccountMarginRentServiceImpl extends GenericServiceImpl<SysAccountMarginRentModel> implements SysAccountMarginRentService
{

    protected SysAccountMarginRentMapper sysAccountMarginRentMapper;

    @Autowired
    public SysAccountMarginRentServiceImpl(SysAccountMarginRentMapper sysAccountMarginRentMapper)
    {
        super(sysAccountMarginRentMapper);
        this.sysAccountMarginRentMapper = sysAccountMarginRentMapper;
    }

    /**
     * 增加修改保证金
     *
     * @param sysAccountMarginRentModel
     * @return
     * @throws BusinessException
     */
    @Override
    public int saveSysAccountMarginRent(SysAccountMarginRentModel sysAccountMarginRentModel) throws BusinessException {
        SysAccountMarginRentModel sysAccountMarginRentSelect=new SysAccountMarginRentModel();
        sysAccountMarginRentSelect.setAccountNo(sysAccountMarginRentModel.getAccountNo());
        List<SysAccountMarginRentModel> sysAccountMarginRentModelList=findList(sysAccountMarginRentSelect);
        logger.debug("onRspQryAccountMarginRent解析平台资金账户保证金信息...");
        logger.debug(String.valueOf(ListUtils.isNotNull(sysAccountMarginRentModelList)));
        logger.debug("sysAccountMarginRentModelList.size():" + sysAccountMarginRentModelList.size());
        boolean save=true;
        SysAccountMarginRentModel sysAccountMarginRent=null;

        if(sysAccountMarginRentModelList==null || sysAccountMarginRentModelList.size()==0){
            sysAccountMarginRent=new SysAccountMarginRentModel();
        }else {
            sysAccountMarginRent=sysAccountMarginRentModelList.get(0);
            save=false;
        }
        sysAccountMarginRent.setId(SerialnoUtils.buildPrimaryKey());
        sysAccountMarginRent.setAccountNo(sysAccountMarginRentModel.getAccountNo());
        sysAccountMarginRent.setCalculateMode(sysAccountMarginRentModel.getCalculateMode());
        sysAccountMarginRent.setCallOrPutFlag(sysAccountMarginRentModel.getCallOrPutFlag());
        sysAccountMarginRent.setCommodityNo(sysAccountMarginRentModel.getCommodityNo());
        sysAccountMarginRent.setCommodityType(sysAccountMarginRentModel.getCommodityType());
        sysAccountMarginRent.setContractNo(sysAccountMarginRentModel.getContractNo());
        sysAccountMarginRent.setCurrencyGroupNo(sysAccountMarginRentModel.getCurrencyGroupNo());
        sysAccountMarginRent.setCurrencyNo(sysAccountMarginRentModel.getCurrencyNo());
        sysAccountMarginRent.setExchangeNo(sysAccountMarginRentModel.getExchangeNo());
        sysAccountMarginRent.setInitialMargin(sysAccountMarginRentModel.getInitialMargin());
        sysAccountMarginRent.setLockMargin(sysAccountMarginRentModel.getLockMargin());
        sysAccountMarginRent.setMaintenanceMargin(sysAccountMarginRentModel.getMaintenanceMargin());
        sysAccountMarginRent.setSellInitialMargin(sysAccountMarginRentModel.getSellInitialMargin());
        sysAccountMarginRent.setSellMaintenanceMargin(sysAccountMarginRentModel.getSellMaintenanceMargin());
        sysAccountMarginRent.setStrikePrice(sysAccountMarginRentModel.getStrikePrice());
        sysAccountMarginRent.setRemark("111");
        if (save){
            sysAccountMarginRent.setCreateDate(new Date());
            insert(sysAccountMarginRent);
        }else {
            sysAccountMarginRent.setUpdateDate(new Date());
            updateByPrimaryKey(sysAccountMarginRent);
        }
        logger.debug("onRspQryAccountMarginRent解析平台资金账户保证金信息结束");
        return 0;
    }
}
