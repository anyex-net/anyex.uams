/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.fund.model.AccountFundAdjustModel;
import com.uams.rpc.fund.model.AccountFundModel;

/**
 * 账户资金表 服务接口
 * <p>File：AccountFundService.java </p>
 * <p>Title: AccountFundService </p>
 * <p>Description:AccountFundService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface AccountFundService extends GenericService<AccountFundModel>{
    public void saveAccountFundRecord (AccountFundAdjustModel info);

}
