/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.mapper;

import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;
import com.uams.rpc.base.model.StockInfoModel;

/**
 * 证券信息表 持久层接口
 * <p>File：StockInfoMapper.java </p>
 * <p>Title: StockInfoMapper </p>
 * <p>Description:StockInfoMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface StockInfoMapper extends GenericMapper<StockInfoModel>
{

}
