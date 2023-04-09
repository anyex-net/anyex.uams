/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.OrgTradeStockKindCfgMapper;
import com.uams.rpc.base.model.OrgTradeStockKindCfgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 各分支机构可交易各大交易所期货品种配置表 服务实现类
 * <p>File：OrgTradeStockKindCfgServiceImpl.java </p>
 * <p>Title: OrgTradeStockKindCfgServiceImpl </p>
 * <p>Description:OrgTradeStockKindCfgServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class OrgTradeStockKindCfgServiceImpl extends GenericServiceImpl<OrgTradeStockKindCfgModel> implements OrgTradeStockKindCfgService
{

    protected OrgTradeStockKindCfgMapper orgTradeStockKindCfgMapper;

    @Autowired
    public OrgTradeStockKindCfgServiceImpl(OrgTradeStockKindCfgMapper orgTradeStockKindCfgMapper)
    {
        super(orgTradeStockKindCfgMapper);
        this.orgTradeStockKindCfgMapper = orgTradeStockKindCfgMapper;
    }
}
