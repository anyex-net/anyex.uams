/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysOrderModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台委托信息表 服务接口
 * <p>File：SysOrderService.java </p>
 * <p>Title: SysOrderService </p>
 * <p>Description:SysOrderService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysOrderService extends GenericService<SysOrderModel>{

    /**
     * 根据外部接口入库委托信息
     * @param sysOrderModel
     */
    int saveRspQryOrder(SysOrderModel sysOrderModel) throws BusinessException;
}
