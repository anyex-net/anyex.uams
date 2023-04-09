/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.mapper;

import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;
import com.uams.rpc.fund.model.AccountFundCurrentModel;

/**
 * 账户资金流水表 持久层接口
 * <p>File：AccountFundCurrentMapper.java </p>
 * <p>Title: AccountFundCurrentMapper </p>
 * <p>Description:AccountFundCurrentMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface AccountFundCurrentMapper extends GenericMapper<AccountFundCurrentModel>
{

}
