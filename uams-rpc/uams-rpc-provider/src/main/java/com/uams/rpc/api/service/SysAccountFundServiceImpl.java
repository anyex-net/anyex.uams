/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysAccountFundMapper;
import com.uams.rpc.api.model.SysAccountFundModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 平台资金账户资金信息表 服务实现类
 * <p>File：SysAccountFundServiceImpl.java </p>
 * <p>Title: SysAccountFundServiceImpl </p>
 * <p>Description:SysAccountFundServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysAccountFundServiceImpl extends GenericServiceImpl<SysAccountFundModel> implements SysAccountFundService {

    protected SysAccountFundMapper sysAccountFundMapper;

    @Autowired
    public SysAccountFundServiceImpl(SysAccountFundMapper sysAccountFundMapper) {
        super(sysAccountFundMapper);
        this.sysAccountFundMapper = sysAccountFundMapper;
    }

    @Override
    public int saveSysAccountFund(SysAccountFundModel sysAccountFundModel) throws BusinessException {

        SysAccountFundModel sysAccountSelect = new SysAccountFundModel();
        sysAccountSelect.setAccountNo(sysAccountFundModel.getAccountNo());
        List<SysAccountFundModel> sysAccountFundModelList = findList(sysAccountSelect);
        logger.debug("onRspQryFund解析平台资金账户资金信息...");
        logger.debug(String.valueOf(ListUtils.isNotNull(sysAccountFundModelList)));
        logger.debug("sysAccountFundModelList.size():" + sysAccountFundModelList.size());

        boolean save = true;
        SysAccountFundModel sysAccountFund = null;
        if (sysAccountFundModelList == null || sysAccountFundModelList.size() == 0) {
            sysAccountFund = new SysAccountFundModel();
        } else {
            sysAccountFund = sysAccountFundModelList.get(0);
            save = false;
        }
        sysAccountFund.setId(SerialnoUtils.buildPrimaryKey());
        sysAccountFund.setAccountDeliveryFee(sysAccountFundModel.getAccountDeliveryFee());
        sysAccountFund.setAccountFee(sysAccountFundModel.getAccountFee());
        sysAccountFund.setAccountMaintenanceMargin(sysAccountFundModel.getAccountMaintenanceMargin());
        sysAccountFund.setAccountIntialMargin(sysAccountFundModel.getAccountIntialMargin());
        sysAccountFund.setAccountNo(sysAccountFundModel.getAccountNo());
        sysAccountFund.setAuthMoney(sysAccountFundModel.getAuthMoney());
        sysAccountFund.setAvailable(sysAccountFundModel.getAvailable());
        sysAccountFund.setBalance(sysAccountFundModel.getBalance());
        sysAccountFund.setCanDraw(sysAccountFundModel.getCanDraw());
        sysAccountFund.setCashAdjustValue(sysAccountFundModel.getCashAdjustValue());
        sysAccountFund.setCashInValue(sysAccountFundModel.getCashInValue());
        sysAccountFund.setCashOutValue(sysAccountFundModel.getCashOutValue());
        sysAccountFund.setCashPledged(sysAccountFundModel.getCashPledged());
        sysAccountFund.setCloseProfit(sysAccountFundModel.getCloseProfit());
        sysAccountFund.setCurrencyGroupNo(sysAccountFundModel.getCurrencyGroupNo());
        sysAccountFund.setCurrencyNo(sysAccountFundModel.getCurrencyNo());
        sysAccountFund.setDeliveryProfit(sysAccountFundModel.getDeliveryProfit());
        sysAccountFund.setDiscount(sysAccountFundModel.getDiscount());
        sysAccountFund.setEquity(sysAccountFundModel.getEquity());
        sysAccountFund.setExchangeFee(sysAccountFundModel.getExchangeFee());
        sysAccountFund.setExpProfit(sysAccountFundModel.getExpProfit());
        sysAccountFund.setFrozenDeposit(sysAccountFundModel.getFrozenDeposit());
        sysAccountFund.setFrozenFee(sysAccountFundModel.getFrozenFee());
        sysAccountFund.setFutureAlg(String.valueOf(sysAccountFundModel.getFutureAlg()));
        sysAccountFund.setLmePositionProfit(sysAccountFundModel.getLmePositionProfit());
        sysAccountFund.setMarketEquity(sysAccountFundModel.getMarketEquity());
        sysAccountFund.setOptionAlg(String.valueOf(sysAccountFundModel.getOptionAlg()));
        sysAccountFund.setOptionMarketValue(sysAccountFundModel.getOptionMarketValue());
        sysAccountFund.setPositionProfit(sysAccountFundModel.getPositionProfit());
        sysAccountFund.setPreAvailable1(sysAccountFundModel.getPreAvailable1());
        sysAccountFund.setPreBalance(sysAccountFundModel.getPreBalance());
        sysAccountFund.setPreEquity(sysAccountFundModel.getPreEquity());
        sysAccountFund.setPreLMEPositionProfit(sysAccountFundModel.getPreLMEPositionProfit());
        sysAccountFund.setPreMarketEquity(sysAccountFundModel.getPreMarketEquity());
        sysAccountFund.setPremiumIncome(sysAccountFundModel.getPremiumIncome());
        sysAccountFund.setPremiumPay(sysAccountFundModel.getPremiumPay());
        sysAccountFund.setPreUnExpProfit(sysAccountFundModel.getPreUnExpProfit());
        sysAccountFund.setTradeRate(sysAccountFundModel.getTradeRate());
        sysAccountFund.setUnExpProfit(sysAccountFundModel.getUnExpProfit());
        sysAccountFund.setUpperInitalMargin(sysAccountFundModel.getUpperInitalMargin());
        sysAccountFund.setUpperMaintenanceMargin(sysAccountFundModel.getUpperMaintenanceMargin());
        sysAccountFund.setRemark("11111");
        sysAccountFund.setCreateDate(new Date());
        sysAccountFund.setUpdateDate(new Date());
        if (save) {
            insert(sysAccountFund);
        } else {
            updateByPrimaryKey(sysAccountFund);
        }
        logger.debug("onRspQryAccount解析账户信息结束");
        return 0;
    }
}
