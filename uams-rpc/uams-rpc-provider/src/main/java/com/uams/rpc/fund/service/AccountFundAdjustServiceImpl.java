/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.fund.mapper.AccountFundAdjustMapper;
import com.uams.rpc.fund.model.AccountFundAdjustModel;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 账户资金调整记录表 服务实现类
 * <p>File：AccountFundAdjustServiceImpl.java </p>
 * <p>Title: AccountFundAdjustServiceImpl </p>
 * <p>Description:AccountFundAdjustServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class AccountFundAdjustServiceImpl extends GenericServiceImpl<AccountFundAdjustModel> implements AccountFundAdjustService
{
    @Autowired(required = false)
    private AccountFundCurrentService accountFundCurrentService;

    protected AccountFundAdjustMapper accountFundAdjustMapper;

    @Autowired
    public AccountFundAdjustServiceImpl(AccountFundAdjustMapper accountFundAdjustMapper)
    {
        super(accountFundAdjustMapper);
        this.accountFundAdjustMapper = accountFundAdjustMapper;
    }

    //插入账户资金变化记录

    public void saveAccountFund (AccountFundAdjustModel info){
        AccountFundAdjustModel info1 =new AccountFundAdjustModel();
        info1.setAccountName("111");
        info1.setAccountId(info.getAccountId());
        info1.setCurrency(info.getCurrency());
        info1.setAdjustType(info.getAdjustType());
        info1.setAdjustAmt(info.getAdjustAmt());
        info1.setRemark(info.getRemark());
        info1.setCreateBy(info.getCreateBy());
        info1.setCreateDate(info.getCreateDate());
        info1.setId(SerialnoUtils.buildPrimaryKey());
        insert(info1);

    }

}
