/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

/**
 * 期货信息表 实体对象
 * <p>File：FuturesInfo.java</p>
 * <p>Title: FuturesInfo</p>
 * <p>Description:FuturesInfo</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "期货信息表")
public class FutureInfoEntity extends GenericEntity
{
    protected static final long    serialVersionUID = 1L;
    
    /**证券内码*/
    @NotNull(message = "证券内码不可为空")
    @ApiModelProperty(value = "证券内码", required = true)
    protected String               interCode;
    
    /**期货品种ID*/
    @NotNull(message = "期货品种ID不可为空")
    @ApiModelProperty(value = "期货品种ID", required = true)
    protected Long                 futureKindId;
    
    /**交易市场ID*/
    @NotNull(message = "交易市场ID不可为空")
    @ApiModelProperty(value = "交易市场ID", required = true)
    protected Long                 marketId;
    
    /**合约月份YYYYMM*/
    @NotNull(message = "合约月份YYYYMM不可为空")
    @ApiModelProperty(value = "合约月份YYYYMM", required = true)
    protected Integer              contractMonth;
    
    /**是否主力合约*/
    @NotNull(message = "是否主力合约不可为空")
    @ApiModelProperty(value = "是否主力合约", required = true)
    protected Boolean              isMainContract;
    
    /**标的物市场ID*/
    @NotNull(message = "标的物市场ID不可为空")
    @ApiModelProperty(value = "标的物市场ID", required = true)
    protected Long                 targetMarketId;
    
    /**标的物证券代码*/
    @NotNull(message = "标的物证券代码不可为空")
    @ApiModelProperty(value = "标的物证券代码", required = true)
    protected String               targetStockCode;
    
    /**合约乘数*/
    @NotNull(message = "合约乘数不可为空")
    @ApiModelProperty(value = "合约乘数", required = true)
    protected Long                 multiple;
    
    /**最后交易日YYYYMMDD*/
    @NotNull(message = "最后交易日YYYYMMDD不可为空")
    @ApiModelProperty(value = "最后交易日YYYYMMDD", required = true)
    protected Integer              lastTradeDate;
    
    /**交割日YYYYMMDD*/
    @NotNull(message = "交割日YYYYMMDD不可为空")
    @ApiModelProperty(value = "交割日YYYYMMDD", required = true)
    protected Integer              lastSettlementDate;
    
    /**最后交易日时间HHMMSS*/
    @NotNull(message = "最后交易日时间HHMMSS不可为空")
    @ApiModelProperty(value = "最后交易日时间HHMMSS", required = true)
    protected Integer              lastTradeTime;
    
    /**结算价*/
    @NotNull(message = "结算价不可为空")
    @ApiModelProperty(value = "结算价", required = true)
    protected java.math.BigDecimal price;
    
    /**实时行情的结算价*/
    @NotNull(message = "实时行情的结算价不可为空")
    @ApiModelProperty(value = "实时行情的结算价", required = true)
    protected java.math.BigDecimal realPrice;
    
    /**前结算价*/
    @NotNull(message = "前结算价不可为空")
    @ApiModelProperty(value = "前结算价", required = true)
    protected java.math.BigDecimal prePrice;
    
    /**持仓量*/
    @NotNull(message = "持仓量不可为空")
    @ApiModelProperty(value = "持仓量", required = true)
    protected Long                 positionAmount;
    
    /**前持仓量*/
    @NotNull(message = "前持仓量不可为空")
    @ApiModelProperty(value = "前持仓量", required = true)
    protected Long                 prePositionAmount;
    
    /**期货合约状态(数据字典)*/
    @NotNull(message = "期货合约状态(数据字典)不可为空")
    @ApiModelProperty(value = "期货合约状态(数据字典)", required = true)
    protected String               status;
    
    /**更新时间*/
    @NotNull(message = "更新时间不可为空")
    @ApiModelProperty(value = "更新时间", required = true)
    protected java.util.Date       updateDate;
    
    public String getInterCode()
    {
        return this.interCode;
    }
    
    public void setInterCode(String interCode)
    {
        this.interCode = interCode;
    }
    
    public Long getFutureKindId()
    {
        return this.futureKindId;
    }
    
    public void setFutureKindId(Long futureKindId)
    {
        this.futureKindId = futureKindId;
    }
    
    public Long getMarketId()
    {
        return this.marketId;
    }
    
    public void setMarketId(Long marketId)
    {
        this.marketId = marketId;
    }
    
    public Integer getContractMonth()
    {
        return this.contractMonth;
    }
    
    public void setContractMonth(Integer contractMonth)
    {
        this.contractMonth = contractMonth;
    }
    
    public Boolean getIsMainContract()
    {
        return this.isMainContract;
    }
    
    public void setIsMainContract(Boolean isMainContract)
    {
        this.isMainContract = isMainContract;
    }
    
    public Long getTargetMarketId()
    {
        return this.targetMarketId;
    }
    
    public void setTargetMarketId(Long targetMarketId)
    {
        this.targetMarketId = targetMarketId;
    }
    
    public String getTargetStockCode()
    {
        return this.targetStockCode;
    }
    
    public void setTargetStockCode(String targetStockCode)
    {
        this.targetStockCode = targetStockCode;
    }
    
    public Long getMultiple()
    {
        return this.multiple;
    }
    
    public void setMultiple(Long multiple)
    {
        this.multiple = multiple;
    }
    
    public Integer getLastTradeDate()
    {
        return this.lastTradeDate;
    }
    
    public void setLastTradeDate(Integer lastTradeDate)
    {
        this.lastTradeDate = lastTradeDate;
    }
    
    public Integer getLastSettlementDate()
    {
        return this.lastSettlementDate;
    }
    
    public void setLastSettlementDate(Integer lastSettlementDate)
    {
        this.lastSettlementDate = lastSettlementDate;
    }
    
    public Integer getLastTradeTime()
    {
        return this.lastTradeTime;
    }
    
    public void setLastTradeTime(Integer lastTradeTime)
    {
        this.lastTradeTime = lastTradeTime;
    }
    
    public java.math.BigDecimal getPrice()
    {
        return this.price;
    }
    
    public void setPrice(java.math.BigDecimal price)
    {
        this.price = price;
    }
    
    public java.math.BigDecimal getRealPrice()
    {
        return this.realPrice;
    }
    
    public void setRealPrice(java.math.BigDecimal realPrice)
    {
        this.realPrice = realPrice;
    }
    
    public java.math.BigDecimal getPrePrice()
    {
        return this.prePrice;
    }
    
    public void setPrePrice(java.math.BigDecimal prePrice)
    {
        this.prePrice = prePrice;
    }
    
    public Long getPositionAmount()
    {
        return this.positionAmount;
    }
    
    public void setPositionAmount(Long positionAmount)
    {
        this.positionAmount = positionAmount;
    }
    
    public Long getPrePositionAmount()
    {
        return this.prePositionAmount;
    }
    
    public void setPrePositionAmount(Long prePositionAmount)
    {
        this.prePositionAmount = prePositionAmount;
    }
    
    public String getStatus()
    {
        return this.status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public java.util.Date getUpdateDate()
    {
        return this.updateDate;
    }
    
    public void setUpdateDate(java.util.Date updateDate)
    {
        this.updateDate = updateDate;
    }
}
