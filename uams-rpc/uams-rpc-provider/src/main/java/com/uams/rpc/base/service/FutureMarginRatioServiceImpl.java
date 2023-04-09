/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.FutureMarginRatioMapper;
import com.uams.rpc.base.model.FutureMarginRatioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 期货保证金比例设置表 服务实现类
 * <p>File：FutureMarginRatioServiceImpl.java </p>
 * <p>Title: FutureMarginRatioServiceImpl </p>
 * <p>Description:FutureMarginRatioServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class FutureMarginRatioServiceImpl extends GenericServiceImpl<FutureMarginRatioModel> implements FutureMarginRatioService
{

    protected FutureMarginRatioMapper futureMarginRatioMapper;

    @Autowired
    public FutureMarginRatioServiceImpl(FutureMarginRatioMapper futureMarginRatioMapper)
    {
        super(futureMarginRatioMapper);
        this.futureMarginRatioMapper = futureMarginRatioMapper;
    }
}
