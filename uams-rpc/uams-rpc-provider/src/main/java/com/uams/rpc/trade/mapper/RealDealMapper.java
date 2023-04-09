/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.trade.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao ;
import com.uams.rpc.trade.model.RealDealModel;

/**
 * 成交表 持久层接口
 * <p>File：RealDealMapper.java </p>
 * <p>Title: RealDealMapper </p>
 * <p>Description:RealDealMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface RealDealMapper extends GenericMapper<RealDealModel>
{

}
