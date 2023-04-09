/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 证券信息表 实体对象
 * <p>File：StockInfo.java</p>
 * <p>Title: StockInfo</p>
 * <p>Description:StockInfo</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "证券信息表")
public class StockInfoEntity extends GenericEntity
{
    protected static final long serialVersionUID = 1L;
    
    /**证券内码*/
    @NotNull(message = "证券内码不可为空")
    @ApiModelProperty(value = "证券内码", required = true)
    protected String            interCode;
    
    /**交易市场ID*/
    @NotNull(message = "交易市场ID不可为空")
    @ApiModelProperty(value = "交易市场ID", required = true)
    protected Long              marketId;
    
    /**证券代码*/
    @NotNull(message = "证券代码不可为空")
    @ApiModelProperty(value = "证券代码", required = true)
    protected String            stockCode;
    
    /**证券名称*/
    @NotNull(message = "证券名称不可为空")
    @ApiModelProperty(value = "证券名称", required = true)
    protected String            stockName;
    
    /**证券拼音码*/
    @NotNull(message = "证券拼音码不可为空")
    @ApiModelProperty(value = "证券拼音码", required = true)
    protected String            stockSpell;
    
    /**证券全称*/
    @NotNull(message = "证券全称不可为空")
    @ApiModelProperty(value = "证券全称", required = true)
    protected String            stockFullName;
    
    /**证券类别(数据字典)*/
    @NotNull(message = "证券类别(数据字典)不可为空")
    @ApiModelProperty(value = "证券类别(数据字典)", required = true)
    protected String            stockType;
    
    /**资产类别(数据字典)*/
    @NotNull(message = "资产类别(数据字典)不可为空")
    @ApiModelProperty(value = "资产类别(数据字典)", required = true)
    protected String            assetClass;
    
    /**外部行情表*/
    @NotNull(message = "外部行情表不可为空")
    @ApiModelProperty(value = "外部行情表", required = true)
    String                      quotationTable;
    
    /**最新价格*/
    @NotNull(message = "最新价格")
    @ApiModelProperty(value = "最新价格", required = true)
    BigDecimal                  lastPrice        = BigDecimal.ZERO;
    
    /**更新时间*/
    @NotNull(message = "更新时间不可为空")
    @ApiModelProperty(value = "更新时间", required = true)
    protected java.util.Date    updateDate;
    
    public String getInterCode()
    {
        return this.interCode;
    }
    
    public void setInterCode(String interCode)
    {
        this.interCode = interCode;
    }
    
    public Long getMarketId()
    {
        return this.marketId;
    }
    
    public void setMarketId(Long marketId)
    {
        this.marketId = marketId;
    }
    
    public String getStockCode()
    {
        return this.stockCode;
    }
    
    public void setStockCode(String stockCode)
    {
        this.stockCode = stockCode;
    }
    
    public String getStockName()
    {
        return this.stockName;
    }
    
    public void setStockName(String stockName)
    {
        this.stockName = stockName;
    }
    
    public String getStockSpell()
    {
        return this.stockSpell;
    }
    
    public void setStockSpell(String stockSpell)
    {
        this.stockSpell = stockSpell;
    }
    
    public String getStockFullName()
    {
        return this.stockFullName;
    }
    
    public void setStockFullName(String stockFullName)
    {
        this.stockFullName = stockFullName;
    }
    
    public String getStockType()
    {
        return this.stockType;
    }
    
    public void setStockType(String stockType)
    {
        this.stockType = stockType;
    }
    
    public String getAssetClass()
    {
        return this.assetClass;
    }
    
    public void setAssetClass(String assetClass)
    {
        this.assetClass = assetClass;
    }
    
    public java.util.Date getUpdateDate()
    {
        return this.updateDate;
    }
    
    public void setUpdateDate(java.util.Date updateDate)
    {
        this.updateDate = updateDate;
    }
    
    public String getQuotationTable()
    {
        return quotationTable;
    }
    
    public void setQuotationTable(String quotationTable)
    {
        this.quotationTable = quotationTable;
    }
    
    public BigDecimal getLastPrice()
    {
        return lastPrice;
    }
    
    public void setLastPrice(BigDecimal lastPrice)
    {
        this.lastPrice = lastPrice;
    }
}
