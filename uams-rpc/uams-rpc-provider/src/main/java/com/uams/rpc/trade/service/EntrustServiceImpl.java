/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.trade.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.trade.mapper.EntrustMapper;
import com.uams.rpc.trade.model.EntrustModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 委托表 服务实现类
 * <p>File：EntrustServiceImpl.java </p>
 * <p>Title: EntrustServiceImpl </p>
 * <p>Description:EntrustServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class EntrustServiceImpl extends GenericServiceImpl<EntrustModel> implements EntrustService
{

    protected EntrustMapper entrustMapper;

    @Autowired
    public EntrustServiceImpl(EntrustMapper entrustMapper)
    {
        super(entrustMapper);
        this.entrustMapper = entrustMapper;
    }
}
