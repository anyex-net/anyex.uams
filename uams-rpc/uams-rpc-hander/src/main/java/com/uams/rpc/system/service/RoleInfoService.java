/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.system.service;

import com.uams.rpc.system.entity.RoleInfo;
import com.uams.orm.core.GenericService;
import com.uams.tools.bean.TreeModel;
import com.uams.tools.exception.BusinessException;

import java.util.List;

/**
 * 角色信息表 服务接口
 * <p>File：RoleInfoService.java </p>
 * <p>Title: RoleInfoService </p>
 * <p>Description:RoleInfoService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface RoleInfoService extends GenericService<RoleInfo>
{
    /**
     * 根据用户ID取角色
     * @param userId
     * @return
     */
    List<RoleInfo> findByUserId(Long userId);
    
    /**
     * 保存角色授权
     * @param id
     * @param resourceIds
     * @throws BusinessException
     */
    void saveGrant(Long id, String resourceIds) throws BusinessException;
    
    /**
     * 返回以TREEMODEL对象的所有数据
     * @param role
     * @return {@link List<TreeModel>}
     * @throws BusinessException
     */
    List<TreeModel> findByRole(RoleInfo role) throws BusinessException;
}
