/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysPositionModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台期货持仓信息表onRspQryPosition 服务接口
 * <p>File：SysPositionService.java </p>
 * <p>Title: SysPositionService </p>
 * <p>Description:SysPositionService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysPositionService extends GenericService<SysPositionModel>{

    int saveSysPosition(SysPositionModel sysPositionChangeModel)throws BusinessException;


}
