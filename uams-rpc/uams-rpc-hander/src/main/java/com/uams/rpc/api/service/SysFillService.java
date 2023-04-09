/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.api.model.SysFillModel;
import com.uams.tools.exception.BusinessException;

/**
 * 平台成交信息表 服务接口
 * <p>File：SysFillService.java </p>
 * <p>Title: SysFillService </p>
 * <p>Description:SysFillService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface SysFillService extends GenericService<SysFillModel>{

    /**
     * 根据外部接口入库成交信息
     * @param sysFillModel
     */
    int saveRspQryFill(SysFillModel sysFillModel) throws BusinessException;
}
