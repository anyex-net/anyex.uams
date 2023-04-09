/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.trade.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.trade.mapper.RealDealMapper;
import com.uams.rpc.trade.model.RealDealModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 成交表 服务实现类
 * <p>File：RealDealServiceImpl.java </p>
 * <p>Title: RealDealServiceImpl </p>
 * <p>Description:RealDealServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class RealDealServiceImpl extends GenericServiceImpl<RealDealModel> implements RealDealService
{

    protected RealDealMapper realDealMapper;

    @Autowired
    public RealDealServiceImpl(RealDealMapper realDealMapper)
    {
        super(realDealMapper);
        this.realDealMapper = realDealMapper;
    }
}
