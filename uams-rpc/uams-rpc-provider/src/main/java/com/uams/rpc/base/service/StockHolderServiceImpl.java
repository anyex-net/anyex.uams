/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.StockHolderMapper;
import com.uams.rpc.base.model.StockHolderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表) 服务实现类
 * <p>File：StockHolderServiceImpl.java </p>
 * <p>Title: StockHolderServiceImpl </p>
 * <p>Description:StockHolderServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class StockHolderServiceImpl extends GenericServiceImpl<StockHolderModel> implements StockHolderService
{

    protected StockHolderMapper stockHolderMapper;

    @Autowired
    public StockHolderServiceImpl(StockHolderMapper stockHolderMapper)
    {
        super(stockHolderMapper);
        this.stockHolderMapper = stockHolderMapper;
    }
}
