/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.StockInfoMapper;
import com.uams.rpc.base.model.StockInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 证券信息表 服务实现类
 * <p>File：StockInfoServiceImpl.java </p>
 * <p>Title: StockInfoServiceImpl </p>
 * <p>Description:StockInfoServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class StockInfoServiceImpl extends GenericServiceImpl<StockInfoModel> implements StockInfoService
{

    protected StockInfoMapper stockInfoMapper;

    @Autowired
    public StockInfoServiceImpl(StockInfoMapper stockInfoMapper)
    {
        super(stockInfoMapper);
        this.stockInfoMapper = stockInfoMapper;
    }
}
