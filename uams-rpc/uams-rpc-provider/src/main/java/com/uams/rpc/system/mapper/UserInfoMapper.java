/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.system.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao;
import com.uams.rpc.system.entity.UserInfo;

/**
 * 用户基础信息表 持久层接口
 * <p>File：UserInfoDao.java </p>
 * <p>Title: UserInfoDao </p>
 * <p>Description:UserInfoDao </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface UserInfoMapper extends GenericMapper<UserInfo>
{
    /**
     * 根据用户名找用户
     * @param userName
     * @return
     */
    UserInfo findByUserName(String userName);
}
