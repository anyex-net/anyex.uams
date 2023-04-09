/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.OrgTradeChannelCfgMapper;
import com.uams.rpc.base.model.OrgTradeChannelCfgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 各分支机构期货交易所走期货公司通道配置表 服务实现类
 * <p>File：OrgTradeChannelCfgServiceImpl.java </p>
 * <p>Title: OrgTradeChannelCfgServiceImpl </p>
 * <p>Description:OrgTradeChannelCfgServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class OrgTradeChannelCfgServiceImpl extends GenericServiceImpl<OrgTradeChannelCfgModel> implements OrgTradeChannelCfgService
{

    protected OrgTradeChannelCfgMapper orgTradeChannelCfgMapper;

    @Autowired
    public OrgTradeChannelCfgServiceImpl(OrgTradeChannelCfgMapper orgTradeChannelCfgMapper)
    {
        super(orgTradeChannelCfgMapper);
        this.orgTradeChannelCfgMapper = orgTradeChannelCfgMapper;
    }
}
