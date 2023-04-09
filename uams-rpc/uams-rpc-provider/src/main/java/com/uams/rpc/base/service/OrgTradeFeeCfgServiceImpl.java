/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.OrgTradeFeeCfgMapper;
import com.uams.rpc.base.model.OrgTradeFeeCfgModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 各分支机构品种交易费率配置表 服务实现类
 * <p>File：OrgTradeFeeCfgServiceImpl.java </p>
 * <p>Title: OrgTradeFeeCfgServiceImpl </p>
 * <p>Description:OrgTradeFeeCfgServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class OrgTradeFeeCfgServiceImpl extends GenericServiceImpl<OrgTradeFeeCfgModel> implements OrgTradeFeeCfgService
{

    protected OrgTradeFeeCfgMapper orgTradeFeeCfgMapper;

    @Autowired
    public OrgTradeFeeCfgServiceImpl(OrgTradeFeeCfgMapper orgTradeFeeCfgMapper)
    {
        super(orgTradeFeeCfgMapper);
        this.orgTradeFeeCfgMapper = orgTradeFeeCfgMapper;
    }
}
