/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysOrderActionModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台委托实时响应表 服务接口
 * <p>File：SysOrderActionService.java </p>
 * <p>Title: SysOrderActionService </p>
 * <p>Description:SysOrderActionService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysOrderActionService extends GenericService<SysOrderActionModel>{

    /**
     * 根据外部接口入库委托实时响应信息
     * @param sysOrderActionModel
     */
    int saveRspOrderAction(SysOrderActionModel sysOrderActionModel) throws BusinessException;
}
