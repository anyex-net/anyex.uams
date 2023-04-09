/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.mapper;

import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;
import com.uams.rpc.base.model.OrgTradeStockKindCfgModel;

/**
 * 各分支机构可交易各大交易所期货品种配置表 持久层接口
 * <p>File：OrgTradeStockKindCfgMapper.java </p>
 * <p>Title: OrgTradeStockKindCfgMapper </p>
 * <p>Description:OrgTradeStockKindCfgMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface OrgTradeStockKindCfgMapper extends GenericMapper<OrgTradeStockKindCfgModel>
{

}
