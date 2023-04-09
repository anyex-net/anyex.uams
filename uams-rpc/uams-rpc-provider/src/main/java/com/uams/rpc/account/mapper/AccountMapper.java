/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.account.mapper;

import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;
import com.uams.rpc.account.model.AccountModel;
import com.uams.tools.exception.BusinessException;
import org.apache.ibatis.annotations.Param;

/**
 * 账户表 持久层接口
 * <p>File：AccountMapper.java </p>
 * <p>Title: AccountMapper </p>
 * <p>Description:AccountMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface AccountMapper extends GenericMapper<AccountModel>
{
    Long getMaxUNID();

    /**
     * 根据帐户名取正常状态的数据
     * @param accountName
     */
    AccountModel findByNameAndNormal(@Param("accountName") String accountName);

}
