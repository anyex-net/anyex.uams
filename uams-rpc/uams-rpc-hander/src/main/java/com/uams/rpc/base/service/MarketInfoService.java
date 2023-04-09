/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.base.model.MarketInfoModel;
import com.uams.tools.exception.BusinessException;

/**
 * 交易市场信息表 服务接口
 * <p>File：MarketInfoService.java </p>
 * <p>Title: MarketInfoService </p>
 * <p>Description:MarketInfoService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface MarketInfoService extends GenericService<MarketInfoModel>{

    /**
     * 根据外部接口入库交易所信息
     * @param marketInfo
     */
    int saveQuoteExchange(MarketInfoModel marketInfo) throws BusinessException;

}
