/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao ;
import com.uams.rpc.api.model.SysOrderChangeModel;

/**
 * 平台委托变化记录表 持久层接口
 * <p>File：SysOrderChangeMapper.java </p>
 * <p>Title: SysOrderChangeMapper </p>
 * <p>Description:SysOrderChangeMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface SysOrderChangeMapper extends GenericMapper<SysOrderChangeModel>
{

}
