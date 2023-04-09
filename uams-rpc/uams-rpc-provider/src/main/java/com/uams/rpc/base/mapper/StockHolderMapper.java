/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.mapper;

import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;
import com.uams.rpc.base.model.StockHolderModel;

/**
 * 代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表) 持久层接口
 * <p>File：StockHolderMapper.java </p>
 * <p>Title: StockHolderMapper </p>
 * <p>Description:StockHolderMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface StockHolderMapper extends GenericMapper<StockHolderModel>
{

}
