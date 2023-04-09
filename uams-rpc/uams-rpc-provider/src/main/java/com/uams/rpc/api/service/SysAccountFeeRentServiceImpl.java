/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysAccountFeeRentMapper;
import com.uams.rpc.api.model.SysAccountFeeRentModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 平台资金账户费率(保证金费率等)信息表 服务实现类
 * <p>File：SysAccountFeeRentServiceImpl.java </p>
 * <p>Title: SysAccountFeeRentServiceImpl </p>
 * <p>Description:SysAccountFeeRentServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysAccountFeeRentServiceImpl extends GenericServiceImpl<SysAccountFeeRentModel> implements SysAccountFeeRentService
{

    protected SysAccountFeeRentMapper sysAccountFeeRentMapper;

    @Autowired
    public SysAccountFeeRentServiceImpl(SysAccountFeeRentMapper sysAccountFeeRentMapper)
    {
        super(sysAccountFeeRentMapper);
        this.sysAccountFeeRentMapper = sysAccountFeeRentMapper;
    }

    @Override
    public int saveSysAccountFeeRent(SysAccountFeeRentModel sysAccountFeeRentModel) throws BusinessException {

        SysAccountFeeRentModel sysAccountFeeRentSelect=new SysAccountFeeRentModel();
        sysAccountFeeRentSelect.setAccountNo(sysAccountFeeRentModel.getAccountNo());
        List<SysAccountFeeRentModel> sysAccountFeeRentModelList=findList(sysAccountFeeRentSelect);
        logger.debug("onRspQryAccountFeeRent解析平台资金账户费率(保证金费率等)...");
        logger.debug(String.valueOf(ListUtils.isNotNull(sysAccountFeeRentModelList)));
        logger.debug("sysAccountFeeRentModelList.size():" + sysAccountFeeRentModelList.size());
        boolean save=true;
        SysAccountFeeRentModel sysAccountFeeRent=null;
        if(sysAccountFeeRentModelList==null || sysAccountFeeRentModelList.size()==0){
            sysAccountFeeRent=new SysAccountFeeRentModel();
        }else {
            sysAccountFeeRent=sysAccountFeeRentModelList.get(0);
            save=false;
        }
        sysAccountFeeRent.setId(SerialnoUtils.buildPrimaryKey());
        sysAccountFeeRent.setAccountNo(sysAccountFeeRentModel.getAccountNo());
        sysAccountFeeRent.setCalculateMode(sysAccountFeeRentModel.getCalculateMode());
        sysAccountFeeRent.setCloseTodayFee(sysAccountFeeRentModel.getCloseTodayFee());
        sysAccountFeeRent.setCommodityNo(sysAccountFeeRentModel.getCommodityNo());
        sysAccountFeeRent.setCommodityType(sysAccountFeeRentModel.getCommodityType());
        sysAccountFeeRent.setCurrencyGroupNo(sysAccountFeeRentModel.getCurrencyGroupNo());
        sysAccountFeeRent.setCurrencyNo(sysAccountFeeRentModel.getCurrencyNo());
        sysAccountFeeRent.setExchangeNo(sysAccountFeeRentModel.getExchangeNo());
        sysAccountFeeRent.setMatchSource(sysAccountFeeRentModel.getMatchSource());
        sysAccountFeeRent.setOpenCloseFee(sysAccountFeeRentModel.getOpenCloseFee());
        sysAccountFeeRent.setRemark("1111");
        if (save){
            sysAccountFeeRent.setCreateDate(new Date());
            insert(sysAccountFeeRent);
        }else {
            sysAccountFeeRent.setUpdateDate(new Date());
            updateByPrimaryKey(sysAccountFeeRent);
        }
        logger.debug("onRspQryAccount解析平台资金账户费率(保证金费率等)结束");

        return 0;
    }
}
