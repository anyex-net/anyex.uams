/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.fund.model.AccountFundAdjustModel;
import com.uams.rpc.fund.model.AccountFundCurrentModel;

/**
 * 账户资金流水表 服务接口
 * <p>File：AccountFundCurrentService.java </p>
 * <p>Title: AccountFundCurrentService </p>
 * <p>Description:AccountFundCurrentService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface AccountFundCurrentService extends GenericService<AccountFundCurrentModel>{

    public void saveAccountFundAdjust (AccountFundAdjustModel info);

}
