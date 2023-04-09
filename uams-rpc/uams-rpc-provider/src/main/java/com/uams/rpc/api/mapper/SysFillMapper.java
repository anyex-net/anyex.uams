/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao ;
import com.uams.rpc.api.model.SysFillModel;

/**
 * 平台成交信息表 持久层接口
 * <p>File：SysFillMapper.java </p>
 * <p>Title: SysFillMapper </p>
 * <p>Description:SysFillMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface SysFillMapper extends GenericMapper<SysFillModel>
{

}
