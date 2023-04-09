/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysHisMatchModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台历史成交表 服务接口
 * <p>File：SysHisMatchService.java </p>
 * <p>Title: SysHisMatchService </p>
 * <p>Description:SysHisMatchService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysHisMatchService extends GenericService<SysHisMatchModel>{

    /**
     * 添加历史成交
     * @param sysHisMatchModel
     * @return
     * @throws BusinessException
     */
    int saveSysHisMatch(SysHisMatchModel sysHisMatchModel)throws BusinessException;

}
