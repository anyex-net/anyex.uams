/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysAccountFundChangeModel;
import com.uams.tools.exception.BusinessException;

/**
 * SysAccountFundChange 服务接口
 * <p>File：SysAccountFundChangeService.java </p>
 * <p>Title: SysAccountFundChangeService </p>
 * <p>Description:SysAccountFundChangeService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysAccountFundChangeService extends GenericService<SysAccountFundChangeModel>{

    /**
     * 新增修改平台资金账户资金变化记录
     * @param sysAccountFundChangeModel
     * @return
     * @throws BusinessException
     */
    int saveSysAccountFundChange(SysAccountFundChangeModel sysAccountFundChangeModel)throws BusinessException;


}
