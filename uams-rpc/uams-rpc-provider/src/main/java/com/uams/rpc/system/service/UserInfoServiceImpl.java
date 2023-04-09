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
import com.uams.orm.utils.EncryptUtils;
import com.uams.rpc.system.entity.Organization;
import com.uams.rpc.system.entity.UserData;
import com.uams.rpc.system.entity.UserInfo;
import com.uams.rpc.system.entity.UserRole;
import com.uams.rpc.system.mapper.OrganizationMapper;
import com.uams.rpc.system.mapper.UserDataMapper;
import com.uams.rpc.system.mapper.UserInfoMapper;
import com.uams.rpc.system.mapper.UserRoleMapper;
import com.uams.tools.consts.UamsConst;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.SerialnoUtils;
import com.uams.tools.utils.StringUtils;

/**
 * 用户基础信息表 服务实现类
 * <p>File：UserInfo.java </p>
 * <p>Title: UserInfo </p>
 * <p>Description:UserInfo </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class UserInfoServiceImpl extends GenericServiceImpl<UserInfo> implements UserInfoService
{
    private UserInfoMapper     userInfoMapper;
    
    @Autowired
    private UserRoleMapper     userRoleMapper;
    
    @Autowired
    private UserDataMapper     userDataMapper;
    
    @Autowired
    private OrganizationMapper organizationMapper;
    
    @Autowired
    public UserInfoServiceImpl(UserInfoMapper userInfoMapper)
    {
        super(userInfoMapper);
        this.userInfoMapper = userInfoMapper;
    }
    
    @Override
    public int save(UserInfo entity) throws BusinessException
    {
        int flag;
        this.beanValidator(entity);
        if (null == entity.getId())
        {
            if (StringUtils.isBlank(entity.getPassWord()))
            {// 如果用户没有设置密码，初始化一个
                entity.setPassWord(UamsConst.DEFAULT_PASSWORD);
            }
            entity.setId(SerialnoUtils.buildPrimaryKey());
            entity.setPassWord(EncryptUtils.entryptPassword(entity.getPassWord()));
            flag = userInfoMapper.insert(entity);
            saveUserData(entity);
            saveUserRole(entity);
        }
        else
        {
            if (StringUtils.isNotBlank(entity.getPassWord()))
            {// 修改密码
                entity.setPassWord(EncryptUtils.entryptPassword(entity.getPassWord()));
            }
            flag = userInfoMapper.updateByPrimaryKey(entity);
            saveUserRole(entity);
        }
        return flag;
    }
    
    /**
     * 保存用户与机构的关联关系
     * <p>
     *     为避免修改用户信息时破坏掉先前用户的数据权限，修改用户时不可调用此方法
     * </p>
     * @param info
     */
    private void saveUserData(UserInfo info)
    {
        userDataMapper.removeByUser(info.getId());
        List<Organization> childOrgs = organizationMapper.findChildOrganizations(info.getOrgId());
        if (ListUtils.isNotNull(childOrgs))
        {
            List<UserData> userDataList = Lists.newArrayList();
            UserData userData;
            for (Organization orgInfo : childOrgs)
            {
                userData = new UserData();
                userData.setId(SerialnoUtils.buildPrimaryKey());
                userData.setUserId(info.getId());
                userData.setOrgId(orgInfo.getId());
                userDataList.add(userData);
            }
            userDataMapper.insertBatch(userDataList);
        }
    }
    
    /**
     * 保存用户角色
     * @param info
     */
    private void saveUserRole(UserInfo info)
    {
        userRoleMapper.removeByUser(info.getId());
        if (StringUtils.isNotBlank(info.getRoleIds()))
        {
            String[] roleIds = info.getRoleIds().split(",");
            List<UserRole> userRoleList = Lists.newArrayList();
            UserRole userRole;
            for (String roleId : roleIds)
            {
                userRole = new UserRole(Long.parseLong(roleId), info.getId());
                userRole.setId(SerialnoUtils.buildPrimaryKey());
                userRoleList.add(userRole);
            }
            userRoleMapper.insertBatch(userRoleList);
        }
    }
    
    @Override
    public UserInfo findByUserName(String userName)
    {
        return userInfoMapper.findByUserName(userName);
    }
}
