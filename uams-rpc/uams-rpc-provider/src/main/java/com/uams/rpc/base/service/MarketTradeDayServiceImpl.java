/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.MarketTradeDayMapper;
import com.uams.rpc.base.model.MarketTradeDayModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 市场交易日表 服务实现类
 * <p>File：MarketTradeDayServiceImpl.java </p>
 * <p>Title: MarketTradeDayServiceImpl </p>
 * <p>Description:MarketTradeDayServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class MarketTradeDayServiceImpl extends GenericServiceImpl<MarketTradeDayModel> implements MarketTradeDayService
{

    protected MarketTradeDayMapper marketTradeDayMapper;

    @Autowired
    public MarketTradeDayServiceImpl(MarketTradeDayMapper marketTradeDayMapper)
    {
        super(marketTradeDayMapper);
        this.marketTradeDayMapper = marketTradeDayMapper;
    }
}
