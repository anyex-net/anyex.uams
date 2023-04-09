/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.base.model.FutureKindModel;
import com.uams.rpc.base.model.MarketInfoModel;
import com.uams.tools.exception.BusinessException;

/**
 * 期货品种表 服务接口
 * <p>File：FutureKindService.java </p>
 * <p>Title: FutureKindService </p>
 * <p>Description:FutureKindService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface FutureKindService extends GenericService<FutureKindModel>{

    /**
     * 根据外部接口入库交易所品种信息
     * @param marketInfo
     */
    int saveQuoteCommodity(MarketInfoModel marketInfo, FutureKindModel futureKind) throws BusinessException;

}
