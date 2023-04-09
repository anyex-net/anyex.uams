/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.base.mapper.FutureInfoMapper;
import com.uams.rpc.base.model.FutureInfoModel;
import com.uams.rpc.base.model.FutureKindModel;
import com.uams.rpc.base.model.MarketInfoModel;
import com.uams.rpc.base.model.StockInfoModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.SerialnoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 期货信息表 服务实现类
 * <p>File：FutureInfoServiceImpl.java </p>
 * <p>Title: FutureInfoServiceImpl </p>
 * <p>Description:FutureInfoServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class FutureInfoServiceImpl extends GenericServiceImpl<FutureInfoModel> implements FutureInfoService
{

    public static final Logger logger = LoggerFactory.getLogger(FutureInfoServiceImpl.class);

    protected FutureInfoMapper futuresInfoMapper;

    @Autowired
    private StockInfoService   stockInfoService;

    @Autowired
    private MarketInfoService  marketInfoService;

    @Autowired
    private FutureKindService  futureKindService;

    @Autowired
    public FutureInfoServiceImpl(FutureInfoMapper futuresInfoMapper)
    {
        super(futuresInfoMapper);
        this.futuresInfoMapper = futuresInfoMapper;
    }

    @Override
    public int saveQuoteContract(StockInfoModel stockInfo, FutureInfoModel futureInfo, MarketInfoModel marketInfo, FutureKindModel futureKind) throws BusinessException {
        StockInfoModel stockInfoModelSelect = new StockInfoModel();
        stockInfoModelSelect.setInterCode(stockInfo.getInterCode());
        List<StockInfoModel> stockInfoModelList = stockInfoService.findList(stockInfoModelSelect);
        logger.debug("onRspQryContract解析交易所合约信息...");
        logger.debug(String.valueOf(ListUtils.isNotNull(stockInfoModelList)));
        logger.debug("stockInfoModelList.size():" + stockInfoModelList.size());
        if (stockInfoModelList.size() == 0) {
            logger.debug("onRspQryContract解析交易所合约信息开始");
            MarketInfoModel marketInfoModelSelect = new MarketInfoModel();
            marketInfoModelSelect.setExchangeCode(marketInfo.getExchangeCode());
            List<MarketInfoModel> marketInfoModelList = marketInfoService.findList(marketInfoModelSelect);
            logger.debug("onRspQryCommodity解析交易所...");
            logger.debug(String.valueOf(ListUtils.isNotNull(marketInfoModelList)));
            logger.debug("marketInfoModelList.size():" + marketInfoModelList.size());
            if(marketInfoModelList.size() > 0){
                FutureKindModel futureKindModellSelect = new FutureKindModel();
                futureKindModellSelect.setKindCode(futureKind.getKindCode());
                List<FutureKindModel> futureKindModelList = futureKindService.findList(futureKindModellSelect);
                logger.debug("onRspQryCommodity解析交易所品种信息...");
                logger.debug(String.valueOf(ListUtils.isNotNull(futureKindModelList)));
                logger.debug("marketInfoModelList.size():" + futureKindModelList.size());
                if (futureKindModelList.size() > 0) {
                    //StockInfoModel
                    logger.debug("StockInfoModel处理开始");
                    StockInfoModel stockInfoModel = new StockInfoModel();
                    stockInfoModel.setId(SerialnoUtils.buildPrimaryKey());
                    stockInfoModel.setInterCode(stockInfo.getInterCode());
                    stockInfoModel.setMarketId(marketInfoModelList.get(0).getId());
                    stockInfoModel.setStockCode(stockInfo.getStockCode());
                    stockInfoModel.setStockSpell(stockInfo.getStockCode());
                    stockInfoModel.setStockName(stockInfo.getStockCode());
                    stockInfoModel.setStockFullName(stockInfo.getStockCode());
                    stockInfoModel.setStockType("indexFutures");
                    stockInfoModel.setAssetClass("stockAsset");
                    stockInfoModel.setUpdateDate(new Date());
                    logger.debug("stockInfoModel:"+stockInfoModel);
                    stockInfoService.insert(stockInfoModel);
                    logger.debug("StockInfoModel处理结束");

                    //FutureInfoModel
                    logger.debug("FutureInfoModel处理开始");
                    FutureInfoModel futureInfoModel = new FutureInfoModel();
                    futureInfoModel.setId(SerialnoUtils.buildPrimaryKey());
                    futureInfoModel.setInterCode(stockInfo.getInterCode());//证券内码
                    futureInfoModel.setFutureKindId(futureKindModelList.get(0).getId());
                      futureInfoModel.setMarketId(marketInfoModelList.get(0).getId());
                    futureInfoModel.setContractMonth(futureInfo.getContractMonth());//合约月份
                    futureInfoModel.setIsMainContract(true);//是否主力合约
                    futureInfoModel.setTargetMarketId(marketInfoModelList.get(0).getId());//标的物市场ID
                    futureInfoModel.setTargetStockCode(stockInfo.getInterCode());//标的物证券代码
                    futureInfoModel.setMultiple(futureInfo.getMultiple());//合约乘数
                    futureInfoModel.setLastTradeDate(0);//最后交易日YYYYMMDD
                    futureInfoModel.setLastSettlementDate(0);//交割日
                    futureInfoModel.setLastTradeTime(0);//最后交易日时间HHMMSS
                    futureInfoModel.setPrice(BigDecimal.ZERO);//结算价
                    futureInfoModel.setRealPrice(BigDecimal.ZERO);//实时行情的结算价
                    futureInfoModel.setPrePrice(BigDecimal.ZERO);//前结算价
                    futureInfoModel.setPositionAmount(0l);//持仓量
                    futureInfoModel.setPrePositionAmount(0l);//前持仓量
                    futureInfoModel.setStatus("trading");//期货合约状态
                    futureInfoModel.setUpdateDate(new Date());
                    logger.debug("futureInfoModel:"+futureInfoModel);
                    futuresInfoMapper.insert(futureInfoModel);
                    logger.debug("FutureInfoModel处理结束");
                }
            }
            logger.debug("onRspQryContract解析交易所合约信息结束");
        }

        return 0;
    }
}
