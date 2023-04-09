/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.FutureKindMapper;
import com.uams.rpc.base.model.FutureKindModel;
import com.uams.rpc.base.model.MarketInfoModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.SerialnoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 期货品种表 服务实现类
 * <p>File：FutureKindServiceImpl.java </p>
 * <p>Title: FutureKindServiceImpl </p>
 * <p>Description:FutureKindServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class FutureKindServiceImpl extends GenericServiceImpl<FutureKindModel> implements FutureKindService
{

    public static final Logger  logger = LoggerFactory.getLogger(FutureKindServiceImpl.class);

    protected FutureKindMapper  futureKindMapper;

    @Autowired
    private MarketInfoService   marketInfoService;

    @Autowired
    public FutureKindServiceImpl(FutureKindMapper futureKindMapper)
    {
        super(futureKindMapper);
        this.futureKindMapper = futureKindMapper;
    }

    @Override
    public int saveQuoteCommodity(MarketInfoModel marketInfo, FutureKindModel futureKind) throws BusinessException {
        FutureKindModel futureKindModellSelect = new FutureKindModel();
        futureKindModellSelect.setKindCode(futureKind.getKindCode());
        List<FutureKindModel> futureKindModelList = futureKindMapper.findList(futureKindModellSelect);
        logger.debug("onRspQryCommodity解析交易所品种信息...");
        logger.debug(String.valueOf(ListUtils.isNotNull(futureKindModelList)));
        logger.debug("marketInfoModelList.size():" + futureKindModelList.size());
        if (futureKindModelList.size() == 0) {
            logger.debug("onRspQryCommodity解析交易所品种信息开始");
            MarketInfoModel marketInfoModelSelect = new MarketInfoModel();
            marketInfoModelSelect.setExchangeCode(marketInfo.getExchangeCode());
            List<MarketInfoModel> marketInfoModelList = marketInfoService.findList(marketInfoModelSelect);
            if (marketInfoModelList.size() > 0) {
                logger.debug("onRspQryCommodity解析交易所品种信息  对应交易所记录存在");
                FutureKindModel futureKindModel = new FutureKindModel();
                futureKindModel.setId(SerialnoUtils.buildPrimaryKey());
                futureKindModel.setMarketId(marketInfoModelList.get(0).getId()); // 交易所ID字段
                futureKindModel.setKindCode(futureKind.getKindCode());
                futureKindModel.setKindName("品种名称待维护");
                futureKindModel.setUpdateDate(new Date());
                futureKindMapper.insert(futureKindModel);
            }
            logger.debug("onRspQryCommodity解析交易所品种信息结束");
        }

        return 0;
    }
}
