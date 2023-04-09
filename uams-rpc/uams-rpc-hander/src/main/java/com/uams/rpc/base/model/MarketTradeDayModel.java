/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.model;

import com.uams.rpc.base.entity.MarketTradeDayEntity;
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
public class MarketTradeDayModel extends MarketTradeDayEntity
{
    /** 期货品种名称*/
    private String kindName;
    
    /** 交易市场简称*/
    private String marketName;
    
    public String getKindName()
    {
        return kindName;
    }
    
    public void setKindName(String kindName)
    {
        this.kindName = kindName;
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
        final StringBuilder sb = new StringBuilder("MarketTradeDayModel{");
        sb.append("id=").append(id);
        sb.append(", kindName='").append(kindName).append('\'');
        sb.append(", marketName='").append(marketName).append('\'');
        sb.append(", marketId=").append(marketId);
        sb.append(", futureKindId=").append(futureKindId);
        sb.append(", natureDay=").append(natureDay);
        sb.append(", week=").append(week);
        sb.append(", isTradeDay=").append(isTradeDay);
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
