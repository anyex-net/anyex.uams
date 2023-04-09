/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.base.model.FutureInfoModel;
import com.uams.rpc.base.model.FutureKindModel;
import com.uams.rpc.base.model.MarketInfoModel;
import com.uams.rpc.base.model.StockInfoModel;
import com.uams.tools.exception.BusinessException;

/**
 * 期货信息表 服务接口
 * <p>File：FutureInfoService.java </p>
 * <p>Title: FutureInfoService </p>
 * <p>Description:FutureInfoService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface FutureInfoService extends GenericService<FutureInfoModel>{

    /**
     * 根据外部接口入库证券基本信息以及期货基本信息
     * @param futureInfo
     */
    int saveQuoteContract(StockInfoModel stockInfo, FutureInfoModel futureInfo, MarketInfoModel marketInfo, FutureKindModel futureKind) throws BusinessException;

}
