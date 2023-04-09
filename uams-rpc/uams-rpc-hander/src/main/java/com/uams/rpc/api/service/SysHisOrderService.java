/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysHisOrderModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台历史委托表 服务接口
 * <p>File：SysHisOrderService.java </p>
 * <p>Title: SysHisOrderService </p>
 * <p>Description:SysHisOrderService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysHisOrderService extends GenericService<SysHisOrderModel>{

    int saveSysHisOrder(SysHisOrderModel sysHisOrderModel)throws BusinessException;

}
