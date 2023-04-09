/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysAccountModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台资金账户信息表 服务接口
 * <p>File：SysAccountService.java </p>
 * <p>Title: SysAccountService </p>
 * <p>Description:SysAccountService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysAccountService extends GenericService<SysAccountModel>{


    int saveSysAccount(SysAccountModel sysAccountModel)throws BusinessException;

}
