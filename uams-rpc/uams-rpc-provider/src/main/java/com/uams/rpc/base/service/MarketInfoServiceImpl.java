/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.MarketInfoMapper;
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
 * 交易市场信息表 服务实现类
 * <p>File：MarketInfoServiceImpl.java </p>
 * <p>Title: MarketInfoServiceImpl </p>
 * <p>Description:MarketInfoServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class MarketInfoServiceImpl extends GenericServiceImpl<MarketInfoModel> implements MarketInfoService
{

    public static final Logger logger = LoggerFactory.getLogger(MarketInfoServiceImpl.class);

    protected MarketInfoMapper marketInfoMapper;

    @Autowired
    public MarketInfoServiceImpl(MarketInfoMapper marketInfoMapper)
    {
        super(marketInfoMapper);
        this.marketInfoMapper = marketInfoMapper;
    }

    @Override
    public int saveQuoteExchange(MarketInfoModel marketInfo) throws BusinessException {
        MarketInfoModel marketInfoModelSelect = new MarketInfoModel();
        marketInfoModelSelect.setExchangeCode(marketInfo.getExchangeCode());
        List<MarketInfoModel> marketInfoModelList = marketInfoMapper.findList(marketInfoModelSelect);
        logger.debug("onRspQryCommodity解析交易所...");
        logger.debug(String.valueOf(ListUtils.isNotNull(marketInfoModelList)));
        logger.debug("marketInfoModelList.size():" + marketInfoModelList.size());
        if (marketInfoModelList.size() == 0) {
            logger.debug("onRspQryCommodity解析交易所开始");
            MarketInfoModel marketInfoModel = new MarketInfoModel();
            marketInfoModel.setId(SerialnoUtils.buildPrimaryKey());
            marketInfoModel.setMarketCode(marketInfo.getExchangeCode());
            marketInfoModel.setMarketName(marketInfo.getExchangeCode());
            marketInfoModel.setMarketFullName(marketInfo.getExchangeCode());
            marketInfoModel.setExchangeCode(marketInfo.getExchangeCode());
            marketInfoModel.setIsStop(false);
            marketInfoModel.setCountryNo("国家待维护");
            marketInfoModel.setUpdateDate(new Date());
            marketInfoMapper.insert(marketInfoModel);
            logger.debug("onRspQryCommodity解析交易所结束");
        }

        return 0;
    }
}
