/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.fund.mapper.AccountAssetMapper;
import com.uams.rpc.fund.model.AccountAssetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账户持仓表 服务实现类
 * <p>File：AccountAssetServiceImpl.java </p>
 * <p>Title: AccountAssetServiceImpl </p>
 * <p>Description:AccountAssetServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class AccountAssetServiceImpl extends GenericServiceImpl<AccountAssetModel> implements AccountAssetService
{

    protected AccountAssetMapper accountAssetMapper;

    @Autowired
    public AccountAssetServiceImpl(AccountAssetMapper accountAssetMapper)
    {
        super(accountAssetMapper);
        this.accountAssetMapper = accountAssetMapper;
    }
}
