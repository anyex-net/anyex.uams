/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysPositionProfitModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台期货持仓损益信息表onRtnPositionProfit 服务接口
 * <p>File：SysPositionProfitService.java </p>
 * <p>Title: SysPositionProfitService </p>
 * <p>Description:SysPositionProfitService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysPositionProfitService extends GenericService<SysPositionProfitModel>{

    int saveSysPositionProfit(SysPositionProfitModel sysPositionChangeModel)throws BusinessException;

}
