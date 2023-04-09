/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.system.service;

import java.util.List;

import com.uams.orm.core.GenericService;
import com.uams.rpc.system.entity.UserData;
import com.uams.tools.exception.BusinessException;

/**
 * 数据权限信息 服务接口
 * <p>File：UserDataService.java </p>
 * <p>Title: UserDataService </p>
 * <p>Description:UserDataService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface UserDataService extends GenericService<UserData>
{
    /**
     * 根据用户数据授权
     * @param userId
     * @param orgIds
     * @throws BusinessException
     */
    void saveGrant(Long userId, String orgIds) throws BusinessException;
    
    /**
     * 根据用户编号取数据权限
     * @param orgId
     * @return
     */
    List<UserData> findByOrgId(Long orgId) throws BusinessException;
    
    /**
     * 根据用户ID删除
     * @param userId
     */
    void removeByUser(Long userId) throws BusinessException;
    
    /**
     * 根据机构ID删除
     * @param orgId
     */
    void removeByOrg(Long orgId) throws BusinessException;
}
