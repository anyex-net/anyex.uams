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
 * 市场交易日表 实体对象
 * <p>File：MarketTradeDay.java</p>
 * <p>Title: MarketTradeDay</p>
 * <p>Description:MarketTradeDay</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "市场交易日表")
public class MarketTradeDayEntity extends GenericEntity
{
    protected static final long serialVersionUID = 1L;
    
    /**交易市场ID*/
    @NotNull(message = "交易市场ID不可为空")
    @ApiModelProperty(value = "交易市场ID", required = true)
    protected Long              marketId;
    
    /**期货品种ID*/
    @NotNull(message = "期货品种ID不可为空")
    @ApiModelProperty(value = "期货品种ID", required = true)
    protected Long              futureKindId;
    
    /**自然日YYYYMMDD*/
    @NotNull(message = "自然日YYYYMMDD不可为空")
    @ApiModelProperty(value = "自然日YYYYMMDD", required = true)
    protected Integer           natureDay;
    
    /**星期几*/
    @NotNull(message = "星期几不可为空")
    @ApiModelProperty(value = "星期几", required = true)
    protected Byte              week;
    
    /**是否是交易日(数据字典)*/
    @NotNull(message = "是否是交易日(数据字典)不可为空")
    @ApiModelProperty(value = "是否是交易日(数据字典)", required = true)
    protected Boolean           isTradeDay;
    
    /**更新时间*/
    @NotNull(message = "更新时间不可为空")
    @ApiModelProperty(value = "更新时间", required = true)
    protected java.util.Date    updateDate;
    
    public Long getMarketId()
    {
        return this.marketId;
    }
    
    public void setMarketId(Long marketId)
    {
        this.marketId = marketId;
    }
    
    public Long getFutureKindId()
    {
        return this.futureKindId;
    }
    
    public void setFutureKindId(Long futureKindId)
    {
        this.futureKindId = futureKindId;
    }
    
    public Integer getNatureDay()
    {
        return this.natureDay;
    }
    
    public void setNatureDay(Integer natureDay)
    {
        this.natureDay = natureDay;
    }
    
    public Byte getWeek()
    {
        return this.week;
    }
    
    public void setWeek(Byte week)
    {
        this.week = week;
    }
    
    public Boolean getIsTradeDay()
    {
        return this.isTradeDay;
    }
    
    public void setIsTradeDay(Boolean isTradeDay)
    {
        this.isTradeDay = isTradeDay;
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
