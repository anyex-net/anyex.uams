/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.account.mapper;

import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;
import com.uams.rpc.account.model.AccountBankModel;

/**
 * 账户银行表 持久层接口
 * <p>File：AccountBankMapper.java </p>
 * <p>Title: AccountBankMapper </p>
 * <p>Description:AccountBankMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface AccountBankMapper extends GenericMapper<AccountBankModel>
{

}
