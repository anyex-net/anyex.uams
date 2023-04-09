/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.account.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.account.mapper.AccountMapper;
import com.uams.rpc.account.model.AccountModel;
import com.uams.tools.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账户表 服务实现类
 * <p>File：AccountServiceImpl.java </p>
 * <p>Title: AccountServiceImpl </p>
 * <p>Description:AccountServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class AccountServiceImpl extends GenericServiceImpl<AccountModel> implements AccountService
{

    protected AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper)
    {
        super(accountMapper);
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountModel findByNameAndNormal(String accountName) throws BusinessException
    {
        return accountMapper.findByNameAndNormal(accountName);
    }

    @Override public Long getMaxUNID()
    {
        return accountMapper.getMaxUNID();
    }

}
