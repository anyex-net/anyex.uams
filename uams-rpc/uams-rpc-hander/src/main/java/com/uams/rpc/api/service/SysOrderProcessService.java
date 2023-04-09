/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysOrderProcessModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台委托处理状态表 服务接口
 * <p>File：SysOrderProcessService.java </p>
 * <p>Title: SysOrderProcessService </p>
 * <p>Description:SysOrderProcessService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysOrderProcessService extends GenericService<SysOrderProcessModel>{

    /**
     * 根据外部接口入库委托处理状态
     * @param sysOrderProcessModel
     */
    int saveRspQryOrderProcess(SysOrderProcessModel sysOrderProcessModel) throws BusinessException;
}
