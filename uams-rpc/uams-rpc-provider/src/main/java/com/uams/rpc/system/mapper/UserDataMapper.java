/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.system.mapper;

import java.util.List;

import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;
import com.uams.rpc.system.entity.UserData;

/**
 * 数据权限信息 持久层接口
 * <p>File：UserDataMapper.java </p>
 * <p>Title: UserDataMapper </p>
 * <p>Description:UserDataMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface UserDataMapper extends GenericMapper<UserData>
{
    /**
     * 根据用户ID删除
     * @param userId
     */
    void removeByUser(Long userId);

    /**
     * 根据机构ID删除
     * @param orgId
     */
    void removeByOrg(Long orgId);

    /**
     * 根据用户编号取数据权限
     * @param orgId
     * @return
     */
    List<UserData> findByOrgId(Long orgId);
}
