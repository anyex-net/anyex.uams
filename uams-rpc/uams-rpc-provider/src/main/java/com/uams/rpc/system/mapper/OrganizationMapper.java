/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.system.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao;
import com.uams.rpc.system.entity.Organization;

import java.util.List;

/**
 * 机构信息表 持久层接口
 * <p>File：OrganizationDao.java </p>
 * <p>Title: OrganizationDao </p>
 * <p>Description:OrganizationDao </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface OrganizationMapper extends GenericMapper<Organization>
{

    /**
     * 根据当前机构编号取所有下级机构
     * @param orgId
     * @return
     */
    List<Organization> findChildOrganizations(Long orgId);
}
