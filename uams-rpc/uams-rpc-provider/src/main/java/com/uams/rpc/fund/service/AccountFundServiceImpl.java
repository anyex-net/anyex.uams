/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.fund.mapper.AccountFundMapper;
import com.uams.rpc.fund.model.AccountFundAdjustModel;
import com.uams.rpc.fund.model.AccountFundModel;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 账户资金表 服务实现类
 * <p>File：AccountFundServiceImpl.java </p>
 * <p>Title: AccountFundServiceImpl </p>
 * <p>Description:AccountFundServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class AccountFundServiceImpl extends GenericServiceImpl<AccountFundModel> implements AccountFundService
{

    protected AccountFundMapper accountFundMapper;

    @Autowired
    public AccountFundServiceImpl(AccountFundMapper accountFundMapper)
    {
        super(accountFundMapper);
        this.accountFundMapper = accountFundMapper;
    }

    public void saveAccountFundRecord (AccountFundAdjustModel info){
        BigDecimal test=new BigDecimal(0.0);
        AccountFundModel info1 =new AccountFundModel();
        info1.setAccountName(info.getAccountName());
        info1.setAccountId(info.getAccountId());
        info1.setCurrency(info.getCurrency());
        info1.setCurrentAmount(test);
        info1.setFrozenAmt(test);
        info1.setCreditAmt(test);
        info1.setInitAmt(test);
        info1.setUpdateDate(info.getCreateDate());
        info1.setId(SerialnoUtils.buildPrimaryKey());
        insert(info1);

    }
}
