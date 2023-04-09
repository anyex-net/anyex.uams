/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.account.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.account.mapper.AccountBankMapper;
import com.uams.rpc.account.model.AccountBankModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账户银行表 服务实现类
 * <p>File：AccountBankServiceImpl.java </p>
 * <p>Title: AccountBankServiceImpl </p>
 * <p>Description:AccountBankServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class AccountBankServiceImpl extends GenericServiceImpl<AccountBankModel> implements AccountBankService
{

    protected AccountBankMapper accountBankMapper;

    @Autowired
    public AccountBankServiceImpl(AccountBankMapper accountBankMapper)
    {
        super(accountBankMapper);
        this.accountBankMapper = accountBankMapper;
    }
}
