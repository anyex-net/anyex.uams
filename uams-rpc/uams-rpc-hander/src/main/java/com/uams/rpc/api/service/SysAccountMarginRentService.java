/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysAccountMarginRentModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台资金账户保证金信息表 服务接口
 * <p>File：SysAccountMarginRentService.java </p>
 * <p>Title: SysAccountMarginRentService </p>
 * <p>Description:SysAccountMarginRentService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysAccountMarginRentService extends GenericService<SysAccountMarginRentModel>{

    /**
     * 增加修改保证金
     * @param sysAccountMarginRentModel
     * @return
     * @throws BusinessException
     */
    int saveSysAccountMarginRent(SysAccountMarginRentModel sysAccountMarginRentModel)throws BusinessException;

}
