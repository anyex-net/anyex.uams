/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uams.rpc.common.mapper.RegionMapper;
import com.uams.rpc.common.entity.Region;
import com.uams.orm.core.GenericServiceImpl;

/**
 * 区域代码 服务实现类
 * <p>File：Region.java </p>
 * <p>Title: Region </p>
 * <p>Description:Region </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class RegionServiceImpl extends GenericServiceImpl<Region> implements RegionService
{
    RegionMapper regionMapper;
    
    @Autowired
    public RegionServiceImpl(RegionMapper regionMapper)
    {
        super(regionMapper);
        this.regionMapper = regionMapper;
    }
}
