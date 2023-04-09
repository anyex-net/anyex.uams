/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.system.service;

import java.util.List;

import com.uams.orm.core.GenericService;
import com.uams.rpc.system.entity.Organization;
import com.uams.tools.bean.TreeModel;
import com.uams.tools.exception.BusinessException;

/**
 * 机构信息表 服务接口
 * <p>File：OrganizationService.java </p>
 * <p>Title: OrganizationService </p>
 * <p>Description:OrganizationService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface OrganizationService extends GenericService<Organization>
{
    /**
     * 查询机构信息并返回树形对象
     * @param organization
     * @return {@link List}
     * @throws BusinessException
     */
    List<TreeModel> findByOrganization(Organization organization) throws BusinessException;
    
    /**
     * 根据当前机构编号取所有下级机构
     * @param orgId
     * @return {@link List}
     * @throws BusinessException
     */
    List<Organization> findChildOrganizations(Long orgId) throws BusinessException;
}
