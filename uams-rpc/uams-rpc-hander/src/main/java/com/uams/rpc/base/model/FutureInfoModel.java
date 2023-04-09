/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.model;

import com.uams.rpc.base.entity.FutureInfoEntity;
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
public class FutureInfoModel extends FutureInfoEntity
{
    /** 期货品种名称*/
    private String kindName;
    
    /** 交易市场简称*/
    private String marketName;
    
    /** 目标交易市场简称*/
    private String targetStockName;
    
    public String getMarketName()
    {
        return marketName;
    }
    
    public void setMarketName(String marketName)
    {
        this.marketName = marketName;
    }
    
    public String getTargetStockName()
    {
        return targetStockName;
    }
    
    public void setTargetStockName(String targetStockName)
    {
        this.targetStockName = targetStockName;
    }
    
    public String getKindName()
    {
        return kindName;
    }
    
    public void setKindName(String kindName)
    {
        this.kindName = kindName;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("FutureInfoModel{");
        sb.append("id=").append(id);
        sb.append(", kindName='").append(kindName).append('\'');
        sb.append(", marketName='").append(marketName).append('\'');
        sb.append(", targetStockName='").append(targetStockName).append('\'');
        sb.append(", interCode='").append(interCode).append('\'');
        sb.append(", futureKindId=").append(futureKindId);
        sb.append(", marketId=").append(marketId);
        sb.append(", contractMonth=").append(contractMonth);
        sb.append(", isMainContract=").append(isMainContract);
        sb.append(", targetMarketId=").append(targetMarketId);
        sb.append(", targetStockCode='").append(targetStockCode).append('\'');
        sb.append(", multiple=").append(multiple);
        sb.append(", lastTradeDate=").append(lastTradeDate);
        sb.append(", lastSettlementDate=").append(lastSettlementDate);
        sb.append(", lastTradeTime=").append(lastTradeTime);
        sb.append(", price=").append(price);
        sb.append(", realPrice=").append(realPrice);
        sb.append(", prePrice=").append(prePrice);
        sb.append(", positionAmount=").append(positionAmount);
        sb.append(", prePositionAmount=").append(prePositionAmount);
        sb.append(", status='").append(status).append('\'');
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
