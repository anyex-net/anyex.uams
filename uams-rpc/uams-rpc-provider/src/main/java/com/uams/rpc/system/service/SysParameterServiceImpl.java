/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.system.service;

import com.google.common.collect.Lists;
import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.system.entity.SysParameter;
import com.uams.rpc.system.mapper.SysParameterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统参数表 服务实现类
 * <p>File：SysParameter.java </p>
 * <p>Title: SysParameter </p>
 * <p>Description:SysParameter </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysParameterServiceImpl extends GenericServiceImpl<SysParameter> implements SysParameterService
{
    private SysParameterMapper sysParameterMapper;
    
    @Autowired
    public SysParameterServiceImpl(SysParameterMapper sysParameterMapper)
    {
        super(sysParameterMapper);
        this.sysParameterMapper = sysParameterMapper;
    }
    
    @Override
    public SysParameter getSysParameterByEntity(SysParameter sysParameter)
    {
        return sysParameterMapper.getSysParameterByEntity(sysParameter);
    }
    
    @Override
    public List<SysParameter> getSysValueByParams(String systemName, String ... params)
    {
        List<String> filter = Lists.newArrayList(params);
        return sysParameterMapper.getSysValueByParams(systemName, filter.toArray(new String[]{}));
    }
}
