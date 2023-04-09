/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysAccountFundModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台资金账户资金信息表 服务接口
 * <p>File：SysAccountFundService.java </p>
 * <p>Title: SysAccountFundService </p>
 * <p>Description:SysAccountFundService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysAccountFundService extends GenericService<SysAccountFundModel>{

    /**
     * 更新添加平台资金账户资金信息
     * @param sysAccountFundModel
     * @return
     * @throws BusinessException
     */
    int saveSysAccountFund(SysAccountFundModel sysAccountFundModel)throws BusinessException;

}
