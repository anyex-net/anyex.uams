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
import com.uams.rpc.system.entity.UserData;
import com.uams.rpc.system.mapper.UserDataMapper;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.SerialnoUtils;
import com.uams.tools.utils.StringUtils;

/**
 * 数据权限信息 服务实现类
 * <p>File：UserDataServiceImpl.java </p>
 * <p>Title: UserDataServiceImpl </p>
 * <p>Description:UserDataServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class UserDataServiceImpl extends GenericServiceImpl<UserData> implements UserDataService
{
    protected UserDataMapper userDataMapper;
    
    @Autowired
    public UserDataServiceImpl(UserDataMapper userDataMapper)
    {
        super(userDataMapper);
        this.userDataMapper = userDataMapper;
    }
    
    @Override
    public void saveGrant(Long userId, String orgIds) throws BusinessException
    {
        if (null == userId) { throw new BusinessException("用户编码不可为空"); }
        if (StringUtils.isBlank(orgIds)) { throw new BusinessException("机构编号不可为空"); }
        userDataMapper.removeByUser(userId);
        String[] ids = orgIds.split(",");
        List<UserData> dataList = Lists.newArrayList();
        UserData userData;
        for (String id : ids)
        {
            userData = new UserData();
            userData.setId(SerialnoUtils.buildPrimaryKey());
            userData.setUserId(userId);
            userData.setOrgId(Long.parseLong(id));
            dataList.add(userData);
        }
        userDataMapper.insertBatch(dataList);
    }
    
    @Override
    public void removeByUser(Long userId) throws BusinessException
    {
        userDataMapper.removeByUser(userId);
    }
    
    @Override
    public void removeByOrg(Long orgId) throws BusinessException
    {
        userDataMapper.removeByOrg(orgId);
    }
    
    @Override
    public List<UserData> findByOrgId(Long orgId) throws BusinessException
    {
        if (null == orgId) { throw new BusinessException("机构编码不可为空"); }
        return userDataMapper.findByOrgId(orgId);
    }
}
