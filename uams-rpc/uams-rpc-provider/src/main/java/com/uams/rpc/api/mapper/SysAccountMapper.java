/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao ;
import com.uams.rpc.api.model.SysAccountModel;

/**
 * 平台资金账户信息表 持久层接口
 * <p>File：SysAccountMapper.java </p>
 * <p>Title: SysAccountMapper </p>
 * <p>Description:SysAccountMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface SysAccountMapper extends GenericMapper<SysAccountModel>
{

}
