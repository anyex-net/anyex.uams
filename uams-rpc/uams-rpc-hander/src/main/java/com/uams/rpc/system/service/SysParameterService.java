/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.system.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.system.entity.SysParameter;

import java.util.List;


/**
 * 系统参数表 服务接口
 * <p>File：SysParameterService.java </p>
 * <p>Title: SysParameterService </p>
 * <p>Description:SysParameterService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysParameterService extends GenericService<SysParameter>
{
    SysParameter getSysParameterByEntity(SysParameter sysParameter);
    
    /**
     * 多个参数名称查询参数值
     * @param systemName
     * @param params
     * @return
     */
    List<SysParameter> getSysValueByParams(String systemName, String... params);
}
