/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysPositionChangeModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台期货持仓变化记录表 服务接口
 * <p>File：SysPositionChangeService.java </p>
 * <p>Title: SysPositionChangeService </p>
 * <p>Description:SysPositionChangeService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysPositionChangeService extends GenericService<SysPositionChangeModel>{

    int saveSysPositionChange(SysPositionChangeModel sysPositionChangeModel)throws BusinessException;

}
