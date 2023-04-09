/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao ;
import com.uams.rpc.api.model.SysAccountFundModel;

/**
 * 平台资金账户资金信息表 持久层接口
 * <p>File：SysAccountFundMapper.java </p>
 * <p>Title: SysAccountFundMapper </p>
 * <p>Description:SysAccountFundMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface SysAccountFundMapper extends GenericMapper<SysAccountFundModel>
{

}
