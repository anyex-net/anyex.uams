/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao ;
import com.uams.rpc.api.model.SysPositionProfitModel;

/**
 * 平台期货持仓损益信息表onRtnPositionProfit 持久层接口
 * <p>File：SysPositionProfitMapper.java </p>
 * <p>Title: SysPositionProfitMapper </p>
 * <p>Description:SysPositionProfitMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface SysPositionProfitMapper extends GenericMapper<SysPositionProfitModel>
{

}
