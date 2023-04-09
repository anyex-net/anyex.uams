/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.system.entity.Organization;
import com.uams.rpc.system.mapper.OrganizationMapper;
import com.uams.tools.bean.TreeModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;

/**
 * 机构信息表 服务实现类
 * <p>File：Organization.java </p>
 * <p>Title: Organization </p>
 * <p>Description:Organization </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class OrganizationServiceImpl extends GenericServiceImpl<Organization> implements OrganizationService
{
    private OrganizationMapper organizationMapper;
    
    @Autowired
    public OrganizationServiceImpl(OrganizationMapper organizationMapper)
    {
        super(organizationMapper);
        this.organizationMapper = organizationMapper;
    }
    
    @Override
    public List<Organization> findChildOrganizations(Long orgId) throws BusinessException
    {
        if (null == orgId) return null;
        return organizationMapper.findChildOrganizations(orgId);
    }
    
    @Override
    public List<TreeModel> findByOrganization(Organization organization) throws BusinessException
    {
        List<Organization> data = organizationMapper.findList(organization);
        if (ListUtils.isNull(data)) return null;
        List<TreeModel> models = Lists.newArrayList();
        for (Organization org : data)
        {
            models.add(conventOrganization(org));
        }
        return models;
    }
    
    /**
     * 转换机构对象
     * @param orgiz
     * @return
     */
    private TreeModel conventOrganization(Organization orgiz)
    {
        TreeModel model = new TreeModel();
        model.setId(orgiz.getId());
        model.setPid(orgiz.getParentId());
        model.setText(orgiz.getOrgName());
        return model;
    }
}
