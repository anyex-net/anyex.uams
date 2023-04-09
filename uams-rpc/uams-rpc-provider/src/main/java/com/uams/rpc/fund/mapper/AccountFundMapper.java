/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.mapper;

import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;
import com.uams.rpc.fund.model.AccountFundModel;

/**
 * 账户资金表 持久层接口
 * <p>File：AccountFundMapper.java </p>
 * <p>Title: AccountFundMapper </p>
 * <p>Description:AccountFundMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface AccountFundMapper extends GenericMapper<AccountFundModel>
{

}
