/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.fund.model.AccountFundAdjustModel;

/**
 * 账户资金调整记录表 服务接口
 * <p>File：AccountFundAdjustService.java </p>
 * <p>Title: AccountFundAdjustService </p>
 * <p>Description:AccountFundAdjustService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface AccountFundAdjustService extends GenericService<AccountFundAdjustModel>{
    public void saveAccountFund (AccountFundAdjustModel info);

}
