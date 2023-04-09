/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.quotation.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 外部实时行情表 实体对象
 * <p>File：Quotation.java</p>
 * <p>Title: Quotation</p>
 * <p>Description:Quotation</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "外部实时行情表")
public class QuotationEntity extends GenericEntity
{
    protected static final long    serialVersionUID = 1L;
    
    /**证券内码*/
    @NotNull(message = "证券内码不可为空")
    @ApiModelProperty(value = "证券内码", required = true)
    protected String               interCode;
    
    /**交易市场代码*/
    @NotNull(message = "交易市场代码不可为空")
    @ApiModelProperty(value = "交易市场代码", required = true)
    protected String               marketCode;
    
    /**品种代码*/
    @NotNull(message = "品种代码不可为空")
    @ApiModelProperty(value = "品种代码", required = true)
    protected String               kindCode;
    
    /**币种代码*/
    @NotNull(message = "币种代码不可为空")
    @ApiModelProperty(value = "币种代码", required = true)
    protected String               currencyNo;
    
    /**五日均量*/
    @NotNull(message = "五日均量不可为空")
    @ApiModelProperty(value = "五日均量", required = true)
    protected java.math.BigDecimal fiveDayAvgQty;
    
    /**均价*/
    @NotNull(message = "均价不可为空")
    @ApiModelProperty(value = "均价", required = true)
    protected java.math.BigDecimal averagePrice;
    
    /**涨幅*/
    @NotNull(message = "涨幅不可为空")
    @ApiModelProperty(value = "涨幅", required = true)
    protected java.math.BigDecimal changeRate;
    
    /**涨速*/
    @NotNull(message = "涨速不可为空")
    @ApiModelProperty(value = "涨速", required = true)
    protected java.math.BigDecimal changeSpeed;
    
    /**涨跌值*/
    @NotNull(message = "涨跌值不可为空")
    @ApiModelProperty(value = "涨跌值", required = true)
    protected java.math.BigDecimal changeValue;
    
    /**收盘价*/
    @NotNull(message = "收盘价不可为空")
    @ApiModelProperty(value = "收盘价", required = true)
    protected java.math.BigDecimal closingPrice;
    
    /**今虚实度*/
    @NotNull(message = "今虚实度不可为空")
    @ApiModelProperty(value = "今虚实度", required = true)
    protected java.math.BigDecimal currDelta;
    
    /**最高价*/
    @NotNull(message = "最高价不可为空")
    @ApiModelProperty(value = "最高价", required = true)
    protected java.math.BigDecimal highPrice;
    
    /**最低价*/
    @NotNull(message = "最低价不可为空")
    @ApiModelProperty(value = "最低价", required = true)
    protected java.math.BigDecimal lowPrice;
    
    /**历史最高价*/
    @NotNull(message = "历史最高价不可为空")
    @ApiModelProperty(value = "历史最高价", required = true)
    protected java.math.BigDecimal hisHighPrice;
    
    /**历史最低价*/
    @NotNull(message = "历史最低价不可为空")
    @ApiModelProperty(value = "历史最低价", required = true)
    protected java.math.BigDecimal hisLowPrice;
    
    /**内盘量*/
    @NotNull(message = "内盘量不可为空")
    @ApiModelProperty(value = "内盘量", required = true)
    protected java.math.BigDecimal insideQty;
    
    /**外盘量*/
    @NotNull(message = "外盘量不可为空")
    @ApiModelProperty(value = "外盘量", required = true)
    protected java.math.BigDecimal outsideQty;
    
    /**最新价*/
    @NotNull(message = "最新价不可为空")
    @ApiModelProperty(value = "最新价", required = true)
    protected java.math.BigDecimal lastPrice;
    
    /**最新成交量*/
    @NotNull(message = "最新成交量不可为空")
    @ApiModelProperty(value = "最新成交量", required = true)
    protected java.math.BigDecimal lastQty;
    
    /**跌停价*/
    @NotNull(message = "跌停价不可为空")
    @ApiModelProperty(value = "跌停价", required = true)
    protected java.math.BigDecimal limitDownPrice;
    
    /**涨停价*/
    @NotNull(message = "涨停价不可为空")
    @ApiModelProperty(value = "涨停价", required = true)
    protected java.math.BigDecimal limitUpPrice;
    
    /**流通市值*/
    @NotNull(message = "流通市值不可为空")
    @ApiModelProperty(value = "流通市值", required = true)
    protected java.math.BigDecimal negotiableValue;
    
    /**开盘价*/
    @NotNull(message = "开盘价不可为空")
    @ApiModelProperty(value = "开盘价", required = true)
    protected java.math.BigDecimal openingPrice;
    
    /**市盈率*/
    @NotNull(message = "市盈率不可为空")
    @ApiModelProperty(value = "市盈率", required = true)
    protected java.math.BigDecimal pERatio;
    
    /**持仓走势*/
    @NotNull(message = "持仓走势不可为空")
    @ApiModelProperty(value = "持仓走势", required = true)
    protected java.math.BigDecimal positionTrend;
    
    /**昨收盘价*/
    @NotNull(message = "昨收盘价不可为空")
    @ApiModelProperty(value = "昨收盘价", required = true)
    protected java.math.BigDecimal preClosingPrice;
    
    /**昨持仓量*/
    @NotNull(message = "昨持仓量不可为空")
    @ApiModelProperty(value = "昨持仓量", required = true)
    protected java.math.BigDecimal prePositionQty;
    
    /**昨结算价*/
    @NotNull(message = "昨结算价不可为空")
    @ApiModelProperty(value = "昨结算价", required = true)
    protected java.math.BigDecimal preSettlePrice;
    
    /**结算价*/
    @NotNull(message = "结算价不可为空")
    @ApiModelProperty(value = "结算价", required = true)
    protected java.math.BigDecimal settlePrice;
    
    /**振幅*/
    @NotNull(message = "振幅不可为空")
    @ApiModelProperty(value = "振幅", required = true)
    protected java.math.BigDecimal swing;
    
    /**委卖总量*/
    @NotNull(message = "委卖总量不可为空")
    @ApiModelProperty(value = "委卖总量", required = true)
    protected java.math.BigDecimal totalAskQty;
    
    /**委买总量*/
    @NotNull(message = "委买总量不可为空")
    @ApiModelProperty(value = "委买总量", required = true)
    protected java.math.BigDecimal totalBidQty;
    
    /**当日总成交量*/
    @NotNull(message = "当日总成交量不可为空")
    @ApiModelProperty(value = "当日总成交量", required = true)
    protected java.math.BigDecimal totalQty;
    
    /**当日成交金额*/
    @NotNull(message = "当日成交金额不可为空")
    @ApiModelProperty(value = "当日成交金额", required = true)
    protected java.math.BigDecimal totalTurnover;
    
    /**总市值*/
    @NotNull(message = "总市值不可为空")
    @ApiModelProperty(value = "总市值", required = true)
    protected java.math.BigDecimal totalValue;
    
    /**换手率*/
    @NotNull(message = "换手率不可为空")
    @ApiModelProperty(value = "换手率", required = true)
    protected java.math.BigDecimal turnoverRate;
    
    /**交易状态*/
    @NotNull(message = "交易状态不可为空")
    @ApiModelProperty(value = "交易状态", required = true)
    protected java.math.BigDecimal tradingState;
    
    /**askPrice1*/
    @NotNull(message = "askPrice1不可为空")
    @ApiModelProperty(value = "askPrice1", required = true)
    protected java.math.BigDecimal askPrice1;
    
    /**askPrice2*/
    @NotNull(message = "askPrice2不可为空")
    @ApiModelProperty(value = "askPrice2", required = true)
    protected java.math.BigDecimal askPrice2;
    
    /**askPrice3*/
    @NotNull(message = "askPrice3不可为空")
    @ApiModelProperty(value = "askPrice3", required = true)
    protected java.math.BigDecimal askPrice3;
    
    /**askPrice4*/
    @NotNull(message = "askPrice4不可为空")
    @ApiModelProperty(value = "askPrice4", required = true)
    protected java.math.BigDecimal askPrice4;
    
    /**askPrice5*/
    @NotNull(message = "askPrice5不可为空")
    @ApiModelProperty(value = "askPrice5", required = true)
    protected java.math.BigDecimal askPrice5;
    
    /**askPrice6*/
    @NotNull(message = "askPrice6不可为空")
    @ApiModelProperty(value = "askPrice6", required = true)
    protected java.math.BigDecimal askPrice6;
    
    /**askPrice7*/
    @NotNull(message = "askPrice7不可为空")
    @ApiModelProperty(value = "askPrice7", required = true)
    protected java.math.BigDecimal askPrice7;
    
    /**askPrice8*/
    @NotNull(message = "askPrice8不可为空")
    @ApiModelProperty(value = "askPrice8", required = true)
    protected java.math.BigDecimal askPrice8;
    
    /**askPrice9*/
    @NotNull(message = "askPrice9不可为空")
    @ApiModelProperty(value = "askPrice9", required = true)
    protected java.math.BigDecimal askPrice9;
    
    /**askPrice10*/
    @NotNull(message = "askPrice10不可为空")
    @ApiModelProperty(value = "askPrice10", required = true)
    protected java.math.BigDecimal askPrice10;
    
    /**askPrice11*/
    @NotNull(message = "askPrice11不可为空")
    @ApiModelProperty(value = "askPrice11", required = true)
    protected java.math.BigDecimal askPrice11;
    
    /**askPrice12*/
    @NotNull(message = "askPrice12不可为空")
    @ApiModelProperty(value = "askPrice12", required = true)
    protected java.math.BigDecimal askPrice12;
    
    /**askPrice13*/
    @NotNull(message = "askPrice13不可为空")
    @ApiModelProperty(value = "askPrice13", required = true)
    protected java.math.BigDecimal askPrice13;
    
    /**askPrice14*/
    @NotNull(message = "askPrice14不可为空")
    @ApiModelProperty(value = "askPrice14", required = true)
    protected java.math.BigDecimal askPrice14;
    
    /**askPrice15*/
    @NotNull(message = "askPrice15不可为空")
    @ApiModelProperty(value = "askPrice15", required = true)
    protected java.math.BigDecimal askPrice15;
    
    /**askPrice16*/
    @NotNull(message = "askPrice16不可为空")
    @ApiModelProperty(value = "askPrice16", required = true)
    protected java.math.BigDecimal askPrice16;
    
    /**askPrice17*/
    @NotNull(message = "askPrice17不可为空")
    @ApiModelProperty(value = "askPrice17", required = true)
    protected java.math.BigDecimal askPrice17;
    
    /**askPrice18*/
    @NotNull(message = "askPrice18不可为空")
    @ApiModelProperty(value = "askPrice18", required = true)
    protected java.math.BigDecimal askPrice18;
    
    /**askPrice19*/
    @NotNull(message = "askPrice19不可为空")
    @ApiModelProperty(value = "askPrice19", required = true)
    protected java.math.BigDecimal askPrice19;
    
    /**askPrice20*/
    @NotNull(message = "askPrice20不可为空")
    @ApiModelProperty(value = "askPrice20", required = true)
    protected java.math.BigDecimal askPrice20;
    
    /**askQty1*/
    @NotNull(message = "askQty1不可为空")
    @ApiModelProperty(value = "askQty1", required = true)
    protected java.math.BigDecimal askQty1;
    
    /**askQty2*/
    @NotNull(message = "askQty2不可为空")
    @ApiModelProperty(value = "askQty3", required = true)
    protected java.math.BigDecimal askQty2;
    
    /**askQty3*/
    @NotNull(message = "askQty3不可为空")
    @ApiModelProperty(value = "askQty3", required = true)
    protected java.math.BigDecimal askQty3;
    
    /**askQty4*/
    @NotNull(message = "askQty4不可为空")
    @ApiModelProperty(value = "askQty4", required = true)
    protected java.math.BigDecimal askQty4;
    
    /**askQty5*/
    @NotNull(message = "askQty5不可为空")
    @ApiModelProperty(value = "askQty5", required = true)
    protected java.math.BigDecimal askQty5;
    
    /**askQty6*/
    @NotNull(message = "askQty6不可为空")
    @ApiModelProperty(value = "askQty6", required = true)
    protected java.math.BigDecimal askQty6;
    
    /**askQty7*/
    @NotNull(message = "askQty7不可为空")
    @ApiModelProperty(value = "askQty7", required = true)
    protected java.math.BigDecimal askQty7;
    
    /**askQty8*/
    @NotNull(message = "askQty8不可为空")
    @ApiModelProperty(value = "askQty8", required = true)
    protected java.math.BigDecimal askQty8;
    
    /**askQty9*/
    @NotNull(message = "askQty9不可为空")
    @ApiModelProperty(value = "askQty9", required = true)
    protected java.math.BigDecimal askQty9;
    
    /**askQty10*/
    @NotNull(message = "askQty10不可为空")
    @ApiModelProperty(value = "askQty10", required = true)
    protected java.math.BigDecimal askQty10;
    
    /**askQty11*/
    @NotNull(message = "askQty11不可为空")
    @ApiModelProperty(value = "askQty11", required = true)
    protected java.math.BigDecimal askQty11;
    
    /**askQty12*/
    @NotNull(message = "askQty12不可为空")
    @ApiModelProperty(value = "askQty12", required = true)
    protected java.math.BigDecimal askQty12;
    
    /**askQty13*/
    @NotNull(message = "askQty13不可为空")
    @ApiModelProperty(value = "askQty13", required = true)
    protected java.math.BigDecimal askQty13;
    
    /**askQty14*/
    @NotNull(message = "askQty14不可为空")
    @ApiModelProperty(value = "askQty14", required = true)
    protected java.math.BigDecimal askQty14;
    
    /**askQty15*/
    @NotNull(message = "askQty15不可为空")
    @ApiModelProperty(value = "askQty15", required = true)
    protected java.math.BigDecimal askQty15;
    
    /**askQty16*/
    @NotNull(message = "askQty16不可为空")
    @ApiModelProperty(value = "askQty16", required = true)
    protected java.math.BigDecimal askQty16;
    
    /**askQty17*/
    @NotNull(message = "askQty17不可为空")
    @ApiModelProperty(value = "askQty17", required = true)
    protected java.math.BigDecimal askQty17;
    
    /**askQty18*/
    @NotNull(message = "askQty18不可为空")
    @ApiModelProperty(value = "askQty18", required = true)
    protected java.math.BigDecimal askQty18;
    
    /**askQty19*/
    @NotNull(message = "askQty19不可为空")
    @ApiModelProperty(value = "askQty19", required = true)
    protected java.math.BigDecimal askQty19;
    
    /**askQty20*/
    @NotNull(message = "askQty20不可为空")
    @ApiModelProperty(value = "askQty20", required = true)
    protected java.math.BigDecimal askQty20;
    
    /**bidPrice1*/
    @NotNull(message = "bidPrice1不可为空")
    @ApiModelProperty(value = "bidPrice1", required = true)
    protected java.math.BigDecimal bidPrice1;
    
    /**bidPrice2*/
    @NotNull(message = "bidPrice2不可为空")
    @ApiModelProperty(value = "bidPrice2", required = true)
    protected java.math.BigDecimal bidPrice2;
    
    /**bidPrice3*/
    @NotNull(message = "bidPrice3不可为空")
    @ApiModelProperty(value = "bidPrice3", required = true)
    protected java.math.BigDecimal bidPrice3;
    
    /**bidPrice4*/
    @NotNull(message = "bidPrice4不可为空")
    @ApiModelProperty(value = "bidPrice4", required = true)
    protected java.math.BigDecimal bidPrice4;
    
    /**bidPrice5*/
    @NotNull(message = "bidPrice5不可为空")
    @ApiModelProperty(value = "bidPrice5", required = true)
    protected java.math.BigDecimal bidPrice5;
    
    /**bidPrice6*/
    @NotNull(message = "bidPrice6不可为空")
    @ApiModelProperty(value = "bidPrice6", required = true)
    protected java.math.BigDecimal bidPrice6;
    
    /**bidPrice7*/
    @NotNull(message = "bidPrice7不可为空")
    @ApiModelProperty(value = "bidPrice7", required = true)
    protected java.math.BigDecimal bidPrice7;
    
    /**bidPrice8*/
    @NotNull(message = "bidPrice8不可为空")
    @ApiModelProperty(value = "bidPrice8", required = true)
    protected java.math.BigDecimal bidPrice8;
    
    /**bidPrice9*/
    @NotNull(message = "bidPrice9不可为空")
    @ApiModelProperty(value = "bidPrice9", required = true)
    protected java.math.BigDecimal bidPrice9;
    
    /**bidPrice10*/
    @NotNull(message = "bidPrice10不可为空")
    @ApiModelProperty(value = "bidPrice10", required = true)
    protected java.math.BigDecimal bidPrice10;
    
    /**bidPrice11*/
    @NotNull(message = "bidPrice11不可为空")
    @ApiModelProperty(value = "bidPrice11", required = true)
    protected java.math.BigDecimal bidPrice11;
    
    /**bidPrice12*/
    @NotNull(message = "bidPrice12不可为空")
    @ApiModelProperty(value = "bidPrice12", required = true)
    protected java.math.BigDecimal bidPrice12;
    
    /**bidPrice13*/
    @NotNull(message = "bidPrice13不可为空")
    @ApiModelProperty(value = "bidPrice13", required = true)
    protected java.math.BigDecimal bidPrice13;
    
    /**bidPrice14*/
    @NotNull(message = "bidPrice14不可为空")
    @ApiModelProperty(value = "bidPrice14", required = true)
    protected java.math.BigDecimal bidPrice14;
    
    /**bidPrice15*/
    @NotNull(message = "bidPrice15不可为空")
    @ApiModelProperty(value = "bidPrice15", required = true)
    protected java.math.BigDecimal bidPrice15;
    
    /**bidPrice16*/
    @NotNull(message = "bidPrice16不可为空")
    @ApiModelProperty(value = "bidPrice16", required = true)
    protected java.math.BigDecimal bidPrice16;
    
    /**bidPrice17*/
    @NotNull(message = "bidPrice17不可为空")
    @ApiModelProperty(value = "bidPrice17", required = true)
    protected java.math.BigDecimal bidPrice17;
    
    /**bidPrice18*/
    @NotNull(message = "bidPrice18不可为空")
    @ApiModelProperty(value = "bidPrice18", required = true)
    protected java.math.BigDecimal bidPrice18;
    
    /**bidPrice19*/
    @NotNull(message = "bidPrice19不可为空")
    @ApiModelProperty(value = "bidPrice19", required = true)
    protected java.math.BigDecimal bidPrice19;
    
    /**bidPrice20*/
    @NotNull(message = "bidPrice20不可为空")
    @ApiModelProperty(value = "bidPrice20", required = true)
    protected java.math.BigDecimal bidPrice20;
    
    /**bidQty1*/
    @NotNull(message = "bidQty1不可为空")
    @ApiModelProperty(value = "bidQty1", required = true)
    protected java.math.BigDecimal bidQty1;
    
    /**bidQty2*/
    @NotNull(message = "bidQty2不可为空")
    @ApiModelProperty(value = "bidQty2", required = true)
    protected java.math.BigDecimal bidQty2;
    
    /**bidQty3*/
    @NotNull(message = "bidQty3不可为空")
    @ApiModelProperty(value = "bidQty3", required = true)
    protected java.math.BigDecimal bidQty3;
    
    /**bidQty4*/
    @NotNull(message = "bidQty4不可为空")
    @ApiModelProperty(value = "bidQty4", required = true)
    protected java.math.BigDecimal bidQty4;
    
    /**bidQty5*/
    @NotNull(message = "bidQty5不可为空")
    @ApiModelProperty(value = "bidQty5", required = true)
    protected java.math.BigDecimal bidQty5;
    
    /**bidQty6*/
    @NotNull(message = "bidQty6不可为空")
    @ApiModelProperty(value = "bidQty6", required = true)
    protected java.math.BigDecimal bidQty6;
    
    /**bidQty7*/
    @NotNull(message = "bidQty7不可为空")
    @ApiModelProperty(value = "bidQty7", required = true)
    protected java.math.BigDecimal bidQty7;
    
    /**bidQty8*/
    @NotNull(message = "bidQty8不可为空")
    @ApiModelProperty(value = "bidQty8", required = true)
    protected java.math.BigDecimal bidQty8;
    
    /**bidQty9*/
    @NotNull(message = "bidQty9不可为空")
    @ApiModelProperty(value = "bidQty9", required = true)
    protected java.math.BigDecimal bidQty9;
    
    /**bidQty10*/
    @NotNull(message = "bidQty10不可为空")
    @ApiModelProperty(value = "bidQty10", required = true)
    protected java.math.BigDecimal bidQty10;
    
    /**bidQty11*/
    @NotNull(message = "bidQty11不可为空")
    @ApiModelProperty(value = "bidQty11", required = true)
    protected java.math.BigDecimal bidQty11;
    
    /**bidQty12*/
    @NotNull(message = "bidQty12不可为空")
    @ApiModelProperty(value = "bidQty12", required = true)
    protected java.math.BigDecimal bidQty12;
    
    /**bidQty13*/
    @NotNull(message = "bidQty13不可为空")
    @ApiModelProperty(value = "bidQty13", required = true)
    protected java.math.BigDecimal bidQty13;
    
    /**bidQty14*/
    @NotNull(message = "bidQty14不可为空")
    @ApiModelProperty(value = "bidQty14", required = true)
    protected java.math.BigDecimal bidQty14;
    
    /**bidQty15*/
    @NotNull(message = "bidQty15不可为空")
    @ApiModelProperty(value = "bidQty15", required = true)
    protected java.math.BigDecimal bidQty15;
    
    /**bidQty16*/
    @NotNull(message = "bidQty16不可为空")
    @ApiModelProperty(value = "bidQty16", required = true)
    protected java.math.BigDecimal bidQty16;
    
    /**bidQty17*/
    @NotNull(message = "bidQty17不可为空")
    @ApiModelProperty(value = "bidQty17", required = true)
    protected java.math.BigDecimal bidQty17;
    
    /**bidQty18*/
    @NotNull(message = "bidQty18不可为空")
    @ApiModelProperty(value = "bidQty18", required = true)
    protected java.math.BigDecimal bidQty18;
    
    /**bidQty19*/
    @NotNull(message = "bidQty19不可为空")
    @ApiModelProperty(value = "bidQty19", required = true)
    protected java.math.BigDecimal bidQty19;
    
    /**bidQty20*/
    @NotNull(message = "bidQty20不可为空")
    @ApiModelProperty(value = "bidQty20", required = true)
    protected java.math.BigDecimal bidQty20;
    
    /**行情实时时间*/
    @NotNull(message = "行情实时时间不可为空")
    @ApiModelProperty(value = "行情实时时间", required = true)
    protected java.util.Date       quotationTime;
    
    public String getInterCode()
    {
        return this.interCode;
    }
    
    public void setInterCode(String interCode)
    {
        this.interCode = interCode;
    }
    
    public String getMarketCode()
    {
        return this.marketCode;
    }
    
    public void setMarketCode(String marketCode)
    {
        this.marketCode = marketCode;
    }
    
    public String getKindCode()
    {
        return this.kindCode;
    }
    
    public void setKindCode(String kindCode)
    {
        this.kindCode = kindCode;
    }
    
    public String getCurrencyNo()
    {
        return this.currencyNo;
    }
    
    public void setCurrencyNo(String currencyNo)
    {
        this.currencyNo = currencyNo;
    }
    
    public java.math.BigDecimal getFiveDayAvgQty()
    {
        return this.fiveDayAvgQty;
    }
    
    public void setFiveDayAvgQty(java.math.BigDecimal fiveDayAvgQty)
    {
        this.fiveDayAvgQty = fiveDayAvgQty;
    }
    
    public java.math.BigDecimal getAveragePrice()
    {
        return this.averagePrice;
    }
    
    public void setAveragePrice(java.math.BigDecimal averagePrice)
    {
        this.averagePrice = averagePrice;
    }
    
    public java.math.BigDecimal getChangeRate()
    {
        return this.changeRate;
    }
    
    public void setChangeRate(java.math.BigDecimal changeRate)
    {
        this.changeRate = changeRate;
    }
    
    public java.math.BigDecimal getChangeSpeed()
    {
        return this.changeSpeed;
    }
    
    public void setChangeSpeed(java.math.BigDecimal changeSpeed)
    {
        this.changeSpeed = changeSpeed;
    }
    
    public java.math.BigDecimal getChangeValue()
    {
        return this.changeValue;
    }
    
    public void setChangeValue(java.math.BigDecimal changeValue)
    {
        this.changeValue = changeValue;
    }
    
    public java.math.BigDecimal getClosingPrice()
    {
        return this.closingPrice;
    }
    
    public void setClosingPrice(java.math.BigDecimal closingPrice)
    {
        this.closingPrice = closingPrice;
    }
    
    public java.math.BigDecimal getCurrDelta()
    {
        return this.currDelta;
    }
    
    public void setCurrDelta(java.math.BigDecimal currDelta)
    {
        this.currDelta = currDelta;
    }
    
    public java.math.BigDecimal getHighPrice()
    {
        return this.highPrice;
    }
    
    public void setHighPrice(java.math.BigDecimal highPrice)
    {
        this.highPrice = highPrice;
    }
    
    public java.math.BigDecimal getLowPrice()
    {
        return this.lowPrice;
    }
    
    public void setLowPrice(java.math.BigDecimal lowPrice)
    {
        this.lowPrice = lowPrice;
    }
    
    public java.math.BigDecimal getHisHighPrice()
    {
        return this.hisHighPrice;
    }
    
    public void setHisHighPrice(java.math.BigDecimal hisHighPrice)
    {
        this.hisHighPrice = hisHighPrice;
    }
    
    public java.math.BigDecimal getHisLowPrice()
    {
        return this.hisLowPrice;
    }
    
    public void setHisLowPrice(java.math.BigDecimal hisLowPrice)
    {
        this.hisLowPrice = hisLowPrice;
    }
    
    public java.math.BigDecimal getInsideQty()
    {
        return this.insideQty;
    }
    
    public void setInsideQty(java.math.BigDecimal insideQty)
    {
        this.insideQty = insideQty;
    }
    
    public java.math.BigDecimal getOutsideQty()
    {
        return this.outsideQty;
    }
    
    public void setOutsideQty(java.math.BigDecimal outsideQty)
    {
        this.outsideQty = outsideQty;
    }
    
    public java.math.BigDecimal getLastPrice()
    {
        return this.lastPrice;
    }
    
    public void setLastPrice(java.math.BigDecimal lastPrice)
    {
        this.lastPrice = lastPrice;
    }
    
    public java.math.BigDecimal getLastQty()
    {
        return this.lastQty;
    }
    
    public void setLastQty(java.math.BigDecimal lastQty)
    {
        this.lastQty = lastQty;
    }
    
    public java.math.BigDecimal getLimitDownPrice()
    {
        return this.limitDownPrice;
    }
    
    public void setLimitDownPrice(java.math.BigDecimal limitDownPrice)
    {
        this.limitDownPrice = limitDownPrice;
    }
    
    public java.math.BigDecimal getLimitUpPrice()
    {
        return this.limitUpPrice;
    }
    
    public void setLimitUpPrice(java.math.BigDecimal limitUpPrice)
    {
        this.limitUpPrice = limitUpPrice;
    }
    
    public java.math.BigDecimal getNegotiableValue()
    {
        return this.negotiableValue;
    }
    
    public void setNegotiableValue(java.math.BigDecimal negotiableValue)
    {
        this.negotiableValue = negotiableValue;
    }
    
    public java.math.BigDecimal getOpeningPrice()
    {
        return this.openingPrice;
    }
    
    public void setOpeningPrice(java.math.BigDecimal openingPrice)
    {
        this.openingPrice = openingPrice;
    }
    
    public java.math.BigDecimal getPERatio()
    {
        return this.pERatio;
    }
    
    public void setPERatio(java.math.BigDecimal pERatio)
    {
        this.pERatio = pERatio;
    }
    
    public java.math.BigDecimal getPositionTrend()
    {
        return this.positionTrend;
    }
    
    public void setPositionTrend(java.math.BigDecimal positionTrend)
    {
        this.positionTrend = positionTrend;
    }
    
    public java.math.BigDecimal getPreClosingPrice()
    {
        return this.preClosingPrice;
    }
    
    public void setPreClosingPrice(java.math.BigDecimal preClosingPrice)
    {
        this.preClosingPrice = preClosingPrice;
    }
    
    public java.math.BigDecimal getPrePositionQty()
    {
        return this.prePositionQty;
    }
    
    public void setPrePositionQty(java.math.BigDecimal prePositionQty)
    {
        this.prePositionQty = prePositionQty;
    }
    
    public java.math.BigDecimal getPreSettlePrice()
    {
        return this.preSettlePrice;
    }
    
    public void setPreSettlePrice(java.math.BigDecimal preSettlePrice)
    {
        this.preSettlePrice = preSettlePrice;
    }
    
    public BigDecimal getSettlePrice()
    {
        return settlePrice;
    }
    
    public void setSettlePrice(BigDecimal settlePrice)
    {
        this.settlePrice = settlePrice;
    }
    
    public java.math.BigDecimal getSwing()
    {
        return this.swing;
    }
    
    public void setSwing(java.math.BigDecimal swing)
    {
        this.swing = swing;
    }
    
    public java.math.BigDecimal getTotalAskQty()
    {
        return this.totalAskQty;
    }
    
    public void setTotalAskQty(java.math.BigDecimal totalAskQty)
    {
        this.totalAskQty = totalAskQty;
    }
    
    public java.math.BigDecimal getTotalBidQty()
    {
        return this.totalBidQty;
    }
    
    public void setTotalBidQty(java.math.BigDecimal totalBidQty)
    {
        this.totalBidQty = totalBidQty;
    }
    
    public java.math.BigDecimal getTotalQty()
    {
        return this.totalQty;
    }
    
    public void setTotalQty(java.math.BigDecimal totalQty)
    {
        this.totalQty = totalQty;
    }
    
    public java.math.BigDecimal getTotalTurnover()
    {
        return this.totalTurnover;
    }
    
    public void setTotalTurnover(java.math.BigDecimal totalTurnover)
    {
        this.totalTurnover = totalTurnover;
    }
    
    public java.math.BigDecimal getTotalValue()
    {
        return this.totalValue;
    }
    
    public void setTotalValue(java.math.BigDecimal totalValue)
    {
        this.totalValue = totalValue;
    }
    
    public java.math.BigDecimal getTurnoverRate()
    {
        return this.turnoverRate;
    }
    
    public void setTurnoverRate(java.math.BigDecimal turnoverRate)
    {
        this.turnoverRate = turnoverRate;
    }
    
    public java.math.BigDecimal getTradingState()
    {
        return this.tradingState;
    }
    
    public void setTradingState(java.math.BigDecimal tradingState)
    {
        this.tradingState = tradingState;
    }
    
    public java.math.BigDecimal getAskPrice1()
    {
        return this.askPrice1;
    }
    
    public void setAskPrice1(java.math.BigDecimal askPrice1)
    {
        this.askPrice1 = askPrice1;
    }
    
    public java.math.BigDecimal getAskPrice2()
    {
        return this.askPrice2;
    }
    
    public void setAskPrice2(java.math.BigDecimal askPrice2)
    {
        this.askPrice2 = askPrice2;
    }
    
    public java.math.BigDecimal getAskPrice3()
    {
        return this.askPrice3;
    }
    
    public void setAskPrice3(java.math.BigDecimal askPrice3)
    {
        this.askPrice3 = askPrice3;
    }
    
    public java.math.BigDecimal getAskPrice4()
    {
        return this.askPrice4;
    }
    
    public void setAskPrice4(java.math.BigDecimal askPrice4)
    {
        this.askPrice4 = askPrice4;
    }
    
    public java.math.BigDecimal getAskPrice5()
    {
        return this.askPrice5;
    }
    
    public void setAskPrice5(java.math.BigDecimal askPrice5)
    {
        this.askPrice5 = askPrice5;
    }
    
    public java.math.BigDecimal getAskPrice6()
    {
        return this.askPrice6;
    }
    
    public void setAskPrice6(java.math.BigDecimal askPrice6)
    {
        this.askPrice6 = askPrice6;
    }
    
    public java.math.BigDecimal getAskPrice7()
    {
        return this.askPrice7;
    }
    
    public void setAskPrice7(java.math.BigDecimal askPrice7)
    {
        this.askPrice7 = askPrice7;
    }
    
    public java.math.BigDecimal getAskPrice8()
    {
        return this.askPrice8;
    }
    
    public void setAskPrice8(java.math.BigDecimal askPrice8)
    {
        this.askPrice8 = askPrice8;
    }
    
    public java.math.BigDecimal getAskPrice9()
    {
        return this.askPrice9;
    }
    
    public void setAskPrice9(java.math.BigDecimal askPrice9)
    {
        this.askPrice9 = askPrice9;
    }
    
    public java.math.BigDecimal getAskPrice10()
    {
        return this.askPrice10;
    }
    
    public void setAskPrice10(java.math.BigDecimal askPrice10)
    {
        this.askPrice10 = askPrice10;
    }
    
    public java.math.BigDecimal getAskPrice11()
    {
        return this.askPrice11;
    }
    
    public void setAskPrice11(java.math.BigDecimal askPrice11)
    {
        this.askPrice11 = askPrice11;
    }
    
    public java.math.BigDecimal getAskPrice12()
    {
        return this.askPrice12;
    }
    
    public void setAskPrice12(java.math.BigDecimal askPrice12)
    {
        this.askPrice12 = askPrice12;
    }
    
    public java.math.BigDecimal getAskPrice13()
    {
        return this.askPrice13;
    }
    
    public void setAskPrice13(java.math.BigDecimal askPrice13)
    {
        this.askPrice13 = askPrice13;
    }
    
    public java.math.BigDecimal getAskPrice14()
    {
        return this.askPrice14;
    }
    
    public void setAskPrice14(java.math.BigDecimal askPrice14)
    {
        this.askPrice14 = askPrice14;
    }
    
    public java.math.BigDecimal getAskPrice15()
    {
        return this.askPrice15;
    }
    
    public void setAskPrice15(java.math.BigDecimal askPrice15)
    {
        this.askPrice15 = askPrice15;
    }
    
    public java.math.BigDecimal getAskPrice16()
    {
        return this.askPrice16;
    }
    
    public void setAskPrice16(java.math.BigDecimal askPrice16)
    {
        this.askPrice16 = askPrice16;
    }
    
    public java.math.BigDecimal getAskPrice17()
    {
        return this.askPrice17;
    }
    
    public void setAskPrice17(java.math.BigDecimal askPrice17)
    {
        this.askPrice17 = askPrice17;
    }
    
    public java.math.BigDecimal getAskPrice18()
    {
        return this.askPrice18;
    }
    
    public void setAskPrice18(java.math.BigDecimal askPrice18)
    {
        this.askPrice18 = askPrice18;
    }
    
    public java.math.BigDecimal getAskPrice19()
    {
        return this.askPrice19;
    }
    
    public void setAskPrice19(java.math.BigDecimal askPrice19)
    {
        this.askPrice19 = askPrice19;
    }
    
    public java.math.BigDecimal getAskPrice20()
    {
        return this.askPrice20;
    }
    
    public void setAskPrice20(java.math.BigDecimal askPrice20)
    {
        this.askPrice20 = askPrice20;
    }
    
    public java.math.BigDecimal getAskQty1()
    {
        return this.askQty1;
    }
    
    public void setAskQty1(java.math.BigDecimal askQty1)
    {
        this.askQty1 = askQty1;
    }
    
    public java.math.BigDecimal getAskQty2()
    {
        return this.askQty2;
    }
    
    public void setAskQty2(java.math.BigDecimal askQty2)
    {
        this.askQty2 = askQty2;
    }
    
    public BigDecimal getAskQty3()
    {
        return askQty3;
    }
    
    public void setAskQty3(BigDecimal askQty3)
    {
        this.askQty3 = askQty3;
    }
    
    public java.math.BigDecimal getAskQty4()
    {
        return this.askQty4;
    }
    
    public void setAskQty4(java.math.BigDecimal askQty4)
    {
        this.askQty4 = askQty4;
    }
    
    public java.math.BigDecimal getAskQty5()
    {
        return this.askQty5;
    }
    
    public void setAskQty5(java.math.BigDecimal askQty5)
    {
        this.askQty5 = askQty5;
    }
    
    public java.math.BigDecimal getAskQty6()
    {
        return this.askQty6;
    }
    
    public void setAskQty6(java.math.BigDecimal askQty6)
    {
        this.askQty6 = askQty6;
    }
    
    public java.math.BigDecimal getAskQty7()
    {
        return this.askQty7;
    }
    
    public void setAskQty7(java.math.BigDecimal askQty7)
    {
        this.askQty7 = askQty7;
    }
    
    public java.math.BigDecimal getAskQty8()
    {
        return this.askQty8;
    }
    
    public void setAskQty8(java.math.BigDecimal askQty8)
    {
        this.askQty8 = askQty8;
    }
    
    public java.math.BigDecimal getAskQty9()
    {
        return this.askQty9;
    }
    
    public void setAskQty9(java.math.BigDecimal askQty9)
    {
        this.askQty9 = askQty9;
    }
    
    public java.math.BigDecimal getAskQty10()
    {
        return this.askQty10;
    }
    
    public void setAskQty10(java.math.BigDecimal askQty10)
    {
        this.askQty10 = askQty10;
    }
    
    public java.math.BigDecimal getAskQty11()
    {
        return this.askQty11;
    }
    
    public void setAskQty11(java.math.BigDecimal askQty11)
    {
        this.askQty11 = askQty11;
    }
    
    public java.math.BigDecimal getAskQty12()
    {
        return this.askQty12;
    }
    
    public void setAskQty12(java.math.BigDecimal askQty12)
    {
        this.askQty12 = askQty12;
    }
    
    public java.math.BigDecimal getAskQty13()
    {
        return this.askQty13;
    }
    
    public void setAskQty13(java.math.BigDecimal askQty13)
    {
        this.askQty13 = askQty13;
    }
    
    public java.math.BigDecimal getAskQty14()
    {
        return this.askQty14;
    }
    
    public void setAskQty14(java.math.BigDecimal askQty14)
    {
        this.askQty14 = askQty14;
    }
    
    public java.math.BigDecimal getAskQty15()
    {
        return this.askQty15;
    }
    
    public void setAskQty15(java.math.BigDecimal askQty15)
    {
        this.askQty15 = askQty15;
    }
    
    public java.math.BigDecimal getAskQty16()
    {
        return this.askQty16;
    }
    
    public void setAskQty16(java.math.BigDecimal askQty16)
    {
        this.askQty16 = askQty16;
    }
    
    public java.math.BigDecimal getAskQty17()
    {
        return this.askQty17;
    }
    
    public void setAskQty17(java.math.BigDecimal askQty17)
    {
        this.askQty17 = askQty17;
    }
    
    public java.math.BigDecimal getAskQty18()
    {
        return this.askQty18;
    }
    
    public void setAskQty18(java.math.BigDecimal askQty18)
    {
        this.askQty18 = askQty18;
    }
    
    public java.math.BigDecimal getAskQty19()
    {
        return this.askQty19;
    }
    
    public void setAskQty19(java.math.BigDecimal askQty19)
    {
        this.askQty19 = askQty19;
    }
    
    public java.math.BigDecimal getAskQty20()
    {
        return this.askQty20;
    }
    
    public void setAskQty20(java.math.BigDecimal askQty20)
    {
        this.askQty20 = askQty20;
    }
    
    public java.math.BigDecimal getBidPrice1()
    {
        return this.bidPrice1;
    }
    
    public void setBidPrice1(java.math.BigDecimal bidPrice1)
    {
        this.bidPrice1 = bidPrice1;
    }
    
    public java.math.BigDecimal getBidPrice2()
    {
        return this.bidPrice2;
    }
    
    public void setBidPrice2(java.math.BigDecimal bidPrice2)
    {
        this.bidPrice2 = bidPrice2;
    }
    
    public java.math.BigDecimal getBidPrice3()
    {
        return this.bidPrice3;
    }
    
    public void setBidPrice3(java.math.BigDecimal bidPrice3)
    {
        this.bidPrice3 = bidPrice3;
    }
    
    public java.math.BigDecimal getBidPrice4()
    {
        return this.bidPrice4;
    }
    
    public void setBidPrice4(java.math.BigDecimal bidPrice4)
    {
        this.bidPrice4 = bidPrice4;
    }
    
    public java.math.BigDecimal getBidPrice5()
    {
        return this.bidPrice5;
    }
    
    public void setBidPrice5(java.math.BigDecimal bidPrice5)
    {
        this.bidPrice5 = bidPrice5;
    }
    
    public java.math.BigDecimal getBidPrice6()
    {
        return this.bidPrice6;
    }
    
    public void setBidPrice6(java.math.BigDecimal bidPrice6)
    {
        this.bidPrice6 = bidPrice6;
    }
    
    public java.math.BigDecimal getBidPrice7()
    {
        return this.bidPrice7;
    }
    
    public void setBidPrice7(java.math.BigDecimal bidPrice7)
    {
        this.bidPrice7 = bidPrice7;
    }
    
    public java.math.BigDecimal getBidPrice8()
    {
        return this.bidPrice8;
    }
    
    public void setBidPrice8(java.math.BigDecimal bidPrice8)
    {
        this.bidPrice8 = bidPrice8;
    }
    
    public java.math.BigDecimal getBidPrice9()
    {
        return this.bidPrice9;
    }
    
    public void setBidPrice9(java.math.BigDecimal bidPrice9)
    {
        this.bidPrice9 = bidPrice9;
    }
    
    public java.math.BigDecimal getBidPrice10()
    {
        return this.bidPrice10;
    }
    
    public void setBidPrice10(java.math.BigDecimal bidPrice10)
    {
        this.bidPrice10 = bidPrice10;
    }
    
    public java.math.BigDecimal getBidPrice11()
    {
        return this.bidPrice11;
    }
    
    public void setBidPrice11(java.math.BigDecimal bidPrice11)
    {
        this.bidPrice11 = bidPrice11;
    }
    
    public java.math.BigDecimal getBidPrice12()
    {
        return this.bidPrice12;
    }
    
    public void setBidPrice12(java.math.BigDecimal bidPrice12)
    {
        this.bidPrice12 = bidPrice12;
    }
    
    public java.math.BigDecimal getBidPrice13()
    {
        return this.bidPrice13;
    }
    
    public void setBidPrice13(java.math.BigDecimal bidPrice13)
    {
        this.bidPrice13 = bidPrice13;
    }
    
    public java.math.BigDecimal getBidPrice14()
    {
        return this.bidPrice14;
    }
    
    public void setBidPrice14(java.math.BigDecimal bidPrice14)
    {
        this.bidPrice14 = bidPrice14;
    }
    
    public java.math.BigDecimal getBidPrice15()
    {
        return this.bidPrice15;
    }
    
    public void setBidPrice15(java.math.BigDecimal bidPrice15)
    {
        this.bidPrice15 = bidPrice15;
    }
    
    public java.math.BigDecimal getBidPrice16()
    {
        return this.bidPrice16;
    }
    
    public void setBidPrice16(java.math.BigDecimal bidPrice16)
    {
        this.bidPrice16 = bidPrice16;
    }
    
    public java.math.BigDecimal getBidPrice17()
    {
        return this.bidPrice17;
    }
    
    public void setBidPrice17(java.math.BigDecimal bidPrice17)
    {
        this.bidPrice17 = bidPrice17;
    }
    
    public java.math.BigDecimal getBidPrice18()
    {
        return this.bidPrice18;
    }
    
    public void setBidPrice18(java.math.BigDecimal bidPrice18)
    {
        this.bidPrice18 = bidPrice18;
    }
    
    public java.math.BigDecimal getBidPrice19()
    {
        return this.bidPrice19;
    }
    
    public void setBidPrice19(java.math.BigDecimal bidPrice19)
    {
        this.bidPrice19 = bidPrice19;
    }
    
    public java.math.BigDecimal getBidPrice20()
    {
        return this.bidPrice20;
    }
    
    public void setBidPrice20(java.math.BigDecimal bidPrice20)
    {
        this.bidPrice20 = bidPrice20;
    }
    
    public java.math.BigDecimal getBidQty1()
    {
        return this.bidQty1;
    }
    
    public void setBidQty1(java.math.BigDecimal bidQty1)
    {
        this.bidQty1 = bidQty1;
    }
    
    public java.math.BigDecimal getBidQty2()
    {
        return this.bidQty2;
    }
    
    public void setBidQty2(java.math.BigDecimal bidQty2)
    {
        this.bidQty2 = bidQty2;
    }
    
    public java.math.BigDecimal getBidQty3()
    {
        return this.bidQty3;
    }
    
    public void setBidQty3(java.math.BigDecimal bidQty3)
    {
        this.bidQty3 = bidQty3;
    }
    
    public java.math.BigDecimal getBidQty4()
    {
        return this.bidQty4;
    }
    
    public void setBidQty4(java.math.BigDecimal bidQty4)
    {
        this.bidQty4 = bidQty4;
    }
    
    public java.math.BigDecimal getBidQty5()
    {
        return this.bidQty5;
    }
    
    public void setBidQty5(java.math.BigDecimal bidQty5)
    {
        this.bidQty5 = bidQty5;
    }
    
    public java.math.BigDecimal getBidQty6()
    {
        return this.bidQty6;
    }
    
    public void setBidQty6(java.math.BigDecimal bidQty6)
    {
        this.bidQty6 = bidQty6;
    }
    
    public java.math.BigDecimal getBidQty7()
    {
        return this.bidQty7;
    }
    
    public void setBidQty7(java.math.BigDecimal bidQty7)
    {
        this.bidQty7 = bidQty7;
    }
    
    public java.math.BigDecimal getBidQty8()
    {
        return this.bidQty8;
    }
    
    public void setBidQty8(java.math.BigDecimal bidQty8)
    {
        this.bidQty8 = bidQty8;
    }
    
    public java.math.BigDecimal getBidQty9()
    {
        return this.bidQty9;
    }
    
    public void setBidQty9(java.math.BigDecimal bidQty9)
    {
        this.bidQty9 = bidQty9;
    }
    
    public java.math.BigDecimal getBidQty10()
    {
        return this.bidQty10;
    }
    
    public void setBidQty10(java.math.BigDecimal bidQty10)
    {
        this.bidQty10 = bidQty10;
    }
    
    public java.math.BigDecimal getBidQty11()
    {
        return this.bidQty11;
    }
    
    public void setBidQty11(java.math.BigDecimal bidQty11)
    {
        this.bidQty11 = bidQty11;
    }
    
    public java.math.BigDecimal getBidQty12()
    {
        return this.bidQty12;
    }
    
    public void setBidQty12(java.math.BigDecimal bidQty12)
    {
        this.bidQty12 = bidQty12;
    }
    
    public java.math.BigDecimal getBidQty13()
    {
        return this.bidQty13;
    }
    
    public void setBidQty13(java.math.BigDecimal bidQty13)
    {
        this.bidQty13 = bidQty13;
    }
    
    public java.math.BigDecimal getBidQty14()
    {
        return this.bidQty14;
    }
    
    public void setBidQty14(java.math.BigDecimal bidQty14)
    {
        this.bidQty14 = bidQty14;
    }
    
    public java.math.BigDecimal getBidQty15()
    {
        return this.bidQty15;
    }
    
    public void setBidQty15(java.math.BigDecimal bidQty15)
    {
        this.bidQty15 = bidQty15;
    }
    
    public java.math.BigDecimal getBidQty16()
    {
        return this.bidQty16;
    }
    
    public void setBidQty16(java.math.BigDecimal bidQty16)
    {
        this.bidQty16 = bidQty16;
    }
    
    public java.math.BigDecimal getBidQty17()
    {
        return this.bidQty17;
    }
    
    public void setBidQty17(java.math.BigDecimal bidQty17)
    {
        this.bidQty17 = bidQty17;
    }
    
    public java.math.BigDecimal getBidQty18()
    {
        return this.bidQty18;
    }
    
    public void setBidQty18(java.math.BigDecimal bidQty18)
    {
        this.bidQty18 = bidQty18;
    }
    
    public java.math.BigDecimal getBidQty19()
    {
        return this.bidQty19;
    }
    
    public void setBidQty19(java.math.BigDecimal bidQty19)
    {
        this.bidQty19 = bidQty19;
    }
    
    public java.math.BigDecimal getBidQty20()
    {
        return this.bidQty20;
    }
    
    public void setBidQty20(java.math.BigDecimal bidQty20)
    {
        this.bidQty20 = bidQty20;
    }
    
    public java.util.Date getQuotationTime()
    {
        return this.quotationTime;
    }
    
    public void setQuotationTime(java.util.Date quotationTime)
    {
        this.quotationTime = quotationTime;
    }
}
