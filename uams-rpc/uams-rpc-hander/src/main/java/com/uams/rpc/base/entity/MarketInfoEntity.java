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
 * 交易市场信息表 实体对象
 * <p>File：MarketInfo.java</p>
 * <p>Title: MarketInfo</p>
 * <p>Description:MarketInfo</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "交易市场信息表")
public class MarketInfoEntity extends GenericEntity
{
    protected static final long serialVersionUID = 1L;
    
    /**交易市场编码*/
    @NotNull(message = "交易市场编码不可为空")
    @ApiModelProperty(value = "交易市场编码", required = true)
    protected String            marketCode;
    
    /**交易市场简称*/
    @NotNull(message = "交易市场简称不可为空")
    @ApiModelProperty(value = "交易市场简称", required = true)
    protected String            marketName;
    
    /**交易市场全称*/
    @NotNull(message = "交易市场全称不可为空")
    @ApiModelProperty(value = "交易市场全称", required = true)
    protected String            marketFullName;
    
    /**停市标志*/
    @NotNull(message = "停市标志不可为空")
    @ApiModelProperty(value = "停市标志", required = true)
    protected Boolean           isStop;
    
    /**市场代码*/
    @NotNull(message = "市场代码不可为空")
    @ApiModelProperty(value = "市场代码", required = true)
    protected String            exchangeCode;
    
    /**国家或地区(数据字典)*/
    @NotNull(message = "国家或地区(数据字典)不可为空")
    @ApiModelProperty(value = "国家或地区(数据字典)", required = true)
    protected String            countryNo;
    
    /**更新时间*/
    @NotNull(message = "更新时间不可为空")
    @ApiModelProperty(value = "更新时间", required = true)
    protected java.util.Date    updateDate;
    
    public String getMarketCode()
    {
        return this.marketCode;
    }
    
    public void setMarketCode(String marketCode)
    {
        this.marketCode = marketCode;
    }
    
    public String getMarketName()
    {
        return this.marketName;
    }
    
    public void setMarketName(String marketName)
    {
        this.marketName = marketName;
    }
    
    public String getMarketFullName()
    {
        return this.marketFullName;
    }
    
    public void setMarketFullName(String marketFullName)
    {
        this.marketFullName = marketFullName;
    }
    
    public Boolean getIsStop()
    {
        return this.isStop;
    }
    
    public void setIsStop(Boolean isStop)
    {
        this.isStop = isStop;
    }
    
    public String getExchangeCode()
    {
        return this.exchangeCode;
    }
    
    public void setExchangeCode(String exchangeCode)
    {
        this.exchangeCode = exchangeCode;
    }
    
    public String getCountryNo()
    {
        return this.countryNo;
    }
    
    public void setCountryNo(String countryNo)
    {
        this.countryNo = countryNo;
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
