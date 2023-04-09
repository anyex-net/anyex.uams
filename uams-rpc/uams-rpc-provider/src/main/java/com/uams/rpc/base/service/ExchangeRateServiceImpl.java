/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.ExchangeRateMapper;
import com.uams.rpc.base.model.ExchangeRateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 汇率表 服务实现类
 * <p>File：ExchangeRateServiceImpl.java </p>
 * <p>Title: ExchangeRateServiceImpl </p>
 * <p>Description:ExchangeRateServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class ExchangeRateServiceImpl extends GenericServiceImpl<ExchangeRateModel> implements ExchangeRateService
{

    protected ExchangeRateMapper exchangeRateMapper;

    @Autowired
    public ExchangeRateServiceImpl(ExchangeRateMapper exchangeRateMapper)
    {
        super(exchangeRateMapper);
        this.exchangeRateMapper = exchangeRateMapper;
    }
}
