/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysOrderChangeModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台委托变化记录表 服务接口
 * <p>File：SysOrderChangeService.java </p>
 * <p>Title: SysOrderChangeService </p>
 * <p>Description:SysOrderChangeService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysOrderChangeService extends GenericService<SysOrderChangeModel>{

    /**
     * 根据外部接口入库委外变化信息
     * @param sysOrderChangeModel
     */
    int saveRtnOrderChange(SysOrderChangeModel sysOrderChangeModel) throws BusinessException;

}
