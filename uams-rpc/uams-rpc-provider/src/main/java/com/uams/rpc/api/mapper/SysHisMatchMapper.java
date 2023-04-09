/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao ;
import com.uams.rpc.api.model.SysHisMatchModel;

/**
 * 平台历史成交表 持久层接口
 * <p>File：SysHisMatchMapper.java </p>
 * <p>Title: SysHisMatchMapper </p>
 * <p>Description:SysHisMatchMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface SysHisMatchMapper extends GenericMapper<SysHisMatchModel>
{

}
