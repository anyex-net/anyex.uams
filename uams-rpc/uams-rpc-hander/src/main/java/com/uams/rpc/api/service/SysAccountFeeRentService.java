/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysAccountFeeRentModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台资金账户费率(保证金费率等)信息表 服务接口
 * <p>File：SysAccountFeeRentService.java </p>
 * <p>Title: SysAccountFeeRentService </p>
 * <p>Description:SysAccountFeeRentService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysAccountFeeRentService extends GenericService<SysAccountFeeRentModel>{

    /**
     *
     * @param sysAccountFeeRentModel
     * @return
     * @throws BusinessException
     */
    int saveSysAccountFeeRent(SysAccountFeeRentModel sysAccountFeeRentModel)throws BusinessException;

}
