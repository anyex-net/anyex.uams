/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.BrokerInfoMapper;
import com.uams.rpc.base.model.BrokerInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 经纪商信息表(券商期货公司)  服务实现类
 * <p>File：BrokerInfoServiceImpl.java </p>
 * <p>Title: BrokerInfoServiceImpl </p>
 * <p>Description:BrokerInfoServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class BrokerInfoServiceImpl extends GenericServiceImpl<BrokerInfoModel> implements BrokerInfoService
{

    protected BrokerInfoMapper brokerInfoMapper;

    @Autowired
    public BrokerInfoServiceImpl(BrokerInfoMapper brokerInfoMapper)
    {
        super(brokerInfoMapper);
        this.brokerInfoMapper = brokerInfoMapper;
    }
}
