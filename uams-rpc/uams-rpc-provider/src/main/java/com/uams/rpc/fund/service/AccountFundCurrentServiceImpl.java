/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.fund.mapper.AccountFundCurrentMapper;
import com.uams.rpc.fund.model.AccountFundAdjustModel;
import com.uams.rpc.fund.model.AccountFundCurrentModel;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 账户资金流水表 服务实现类
 * <p>File：AccountFundCurrentServiceImpl.java </p>
 * <p>Title: AccountFundCurrentServiceImpl </p>
 * <p>Description:AccountFundCurrentServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class AccountFundCurrentServiceImpl extends GenericServiceImpl<AccountFundCurrentModel> implements AccountFundCurrentService
{

    protected AccountFundCurrentMapper accountFundCurrentMapper;

    @Autowired
    public AccountFundCurrentServiceImpl(AccountFundCurrentMapper accountFundCurrentMapper)
    {
        super(accountFundCurrentMapper);
        this.accountFundCurrentMapper = accountFundCurrentMapper;
    }

    //插入资金流水记录



    public void saveAccountFundAdjust (AccountFundAdjustModel info){
        AccountFundCurrentModel info1 =new AccountFundCurrentModel();
        BigDecimal test=new BigDecimal(10.0);
        long h=34;
        info1.setAccountName("111");
        info1.setStockCode("111");
        info1.setAccountId(h);
        info1.setForzenLastAmt(test);
        info1.setTransId("111");
        info1.setSourceAccountBankId(h);
        info1.setTargetAccountBankId(h);
        info1.setNetFee(test);
        info1.setOriginalBusinessId(h);
        info1.setRemark(info.getRemark());
        info1.setId(SerialnoUtils.buildPrimaryKey());
        info1.setCurrency(info.getCurrency());
        info1.setCurrentDate(info.getCreateDate());
        info1.setBusinessFlag("111");//数据字典
        info1.setStockinfoId(h);//证券信息id,对应Stockinfo表中的ID字段
        info1.setOccurDirect("increase");//资产发生方向,增加increase、减少decrease、冻结frozen、解冻unfrozen、解冻并减少frozenDecrease
        info1.setOrgAmt(test);//原资产当前数量余额
        info1.setOccurAmt(test);//资产增加减少发生数量
        info1.setLastAmt(test);//最新资产当前数量余额
        info1.setForzenOrgAmt(test);//原冻结资产数量余额
        info1.setOccurForzenAmt(test);//冻结解冻发生数量
        info1.setFee(test);//费用
        info1.setOriginalBusinessId(info.getAccountId());
        insert(info1);
    }
}
