/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.mapper;

import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;
import com.uams.rpc.base.model.FutureKindModel;

/**
 * 期货品种表 持久层接口
 * <p>File：FutureKindMapper.java </p>
 * <p>Title: FutureKindMapper </p>
 * <p>Description:FutureKindMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface FutureKindMapper extends GenericMapper<FutureKindModel>
{

}
