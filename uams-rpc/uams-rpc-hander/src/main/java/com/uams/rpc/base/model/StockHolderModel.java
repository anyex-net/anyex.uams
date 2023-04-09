/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.model;

import com.uams.rpc.base.entity.StockHolderEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

/**
 * 代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表) 实体对象
 * <p>File：StockHolder.java</p>
 * <p>Title: StockHolder</p>
 * <p>Description:StockHolder</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表)")
public class StockHolderModel extends StockHolderEntity
{
    /**经纪商名称*/
    private String brokerName;
    
    /**交易市场简称*/
    private String marketName;
    
    public String getBrokerName()
    {
        return brokerName;
    }
    
    public void setBrokerName(String brokerName)
    {
        this.brokerName = brokerName;
    }
    
    public String getMarketName()
    {
        return marketName;
    }
    
    public void setMarketName(String marketName)
    {
        this.marketName = marketName;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("StockHolderModel{");
        sb.append("id=").append(id);
        sb.append(", brokerName='").append(brokerName).append('\'');
        sb.append(", marketName='").append(marketName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
