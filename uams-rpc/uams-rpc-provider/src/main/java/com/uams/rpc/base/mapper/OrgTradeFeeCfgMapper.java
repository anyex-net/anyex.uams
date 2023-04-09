/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao ;
import com.uams.rpc.base.model.OrgTradeFeeCfgModel;

/**
 * 各分支机构品种交易费率配置表 持久层接口
 * <p>File：OrgTradeFeeCfgMapper.java </p>
 * <p>Title: OrgTradeFeeCfgMapper </p>
 * <p>Description:OrgTradeFeeCfgMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface OrgTradeFeeCfgMapper extends GenericMapper<OrgTradeFeeCfgModel>
{

}
