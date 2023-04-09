/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.common.mapper;

import com.uams.rpc.common.entity.MsgRecord;
import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;

/**
 * 短信记录表 持久层接口
 * <p>File：MsgRecordMapper.java </p>
 * <p>Title: MsgRecordMapper </p>
 * <p>Description:MsgRecordMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface MsgRecordMapper extends GenericMapper<MsgRecord>
{
}
