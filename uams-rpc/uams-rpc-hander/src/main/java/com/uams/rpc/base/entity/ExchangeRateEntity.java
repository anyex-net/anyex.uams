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
 * 汇率表 实体对象
 * <p>File：ExchangeRate.java</p>
 * <p>Title: ExchangeRate</p>
 * <p>Description:ExchangeRate</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "汇率表")
public class ExchangeRateEntity extends GenericEntity
{
    protected static final long    serialVersionUID = 1L;
    
    /**汇率日期*/
    @NotNull(message = "汇率日期不可为空")
    @ApiModelProperty(value = "汇率日期", required = true)
    protected java.util.Date       exchangDate;
    
    /**源币种(数据字典)*/
    @NotNull(message = "源币种(数据字典)不可为空")
    @ApiModelProperty(value = "源币种(数据字典)", required = true)
    protected String               currencySource;
    
    /**目标币种(数据字典)*/
    @NotNull(message = "目标币种(数据字典)不可为空")
    @ApiModelProperty(value = "目标币种(数据字典)", required = true)
    protected String               currencyTarget;
    
    /**买入价*/
    @NotNull(message = "买入价不可为空")
    @ApiModelProperty(value = "买入价", required = true)
    protected java.math.BigDecimal buyPrice;
    
    /**卖出价*/
    @NotNull(message = "卖出价不可为空")
    @ApiModelProperty(value = "卖出价", required = true)
    protected java.math.BigDecimal sellPrice;
    
    /**中间价*/
    @NotNull(message = "中间价不可为空")
    @ApiModelProperty(value = "中间价", required = true)
    protected java.math.BigDecimal midPrice;
    
    /**最小单位*/
    @NotNull(message = "最小单位不可为空")
    @ApiModelProperty(value = "最小单位", required = true)
    protected Long                 unitAmount;
    
    /**更新时间*/
    @NotNull(message = "更新时间不可为空")
    @ApiModelProperty(value = "更新时间", required = true)
    protected java.util.Date       updateDate;
    
    public java.util.Date getExchangDate()
    {
        return this.exchangDate;
    }
    
    public void setExchangDate(java.util.Date exchangDate)
    {
        this.exchangDate = exchangDate;
    }
    
    public String getCurrencySource()
    {
        return this.currencySource;
    }
    
    public void setCurrencySource(String currencySource)
    {
        this.currencySource = currencySource;
    }
    
    public String getCurrencyTarget()
    {
        return this.currencyTarget;
    }
    
    public void setCurrencyTarget(String currencyTarget)
    {
        this.currencyTarget = currencyTarget;
    }
    
    public java.math.BigDecimal getBuyPrice()
    {
        return this.buyPrice;
    }
    
    public void setBuyPrice(java.math.BigDecimal buyPrice)
    {
        this.buyPrice = buyPrice;
    }
    
    public java.math.BigDecimal getSellPrice()
    {
        return this.sellPrice;
    }
    
    public void setSellPrice(java.math.BigDecimal sellPrice)
    {
        this.sellPrice = sellPrice;
    }
    
    public java.math.BigDecimal getMidPrice()
    {
        return this.midPrice;
    }
    
    public void setMidPrice(java.math.BigDecimal midPrice)
    {
        this.midPrice = midPrice;
    }
    
    public Long getUnitAmount()
    {
        return this.unitAmount;
    }
    
    public void setUnitAmount(Long unitAmount)
    {
        this.unitAmount = unitAmount;
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
