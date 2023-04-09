/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.trade.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao ;
import com.uams.rpc.trade.model.EntrustModel;

/**
 * 委托表 持久层接口
 * <p>File：EntrustMapper.java </p>
 * <p>Title: EntrustMapper </p>
 * <p>Description:EntrustMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface EntrustMapper extends GenericMapper<EntrustModel>
{

}
