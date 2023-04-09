/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.account.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.account.model.AccountModel;
import com.uams.tools.exception.BusinessException;

/**
 * 账户表 服务接口
 * <p>File：AccountService.java </p>
 * <p>Title: AccountService </p>
 * <p>Description:AccountService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface AccountService extends GenericService<AccountModel>{

    /**
     * 根据帐户名取正常状态的数据
     * @param accountName
     */
    AccountModel findByNameAndNormal(String accountName) throws BusinessException;

    Long getMaxUNID();
}
