/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.model;

import com.uams.rpc.base.entity.StockInfoEntity;
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
public class StockInfoModel extends StockInfoEntity
{
    private String            marketName;

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
        final StringBuilder sb = new StringBuilder("StockInfoModel{");
        sb.append("id=").append(id);
        sb.append(", interCode='").append(interCode).append('\'');
        sb.append(", marketId=").append(marketId);
        sb.append(", stockCode='").append(stockCode).append('\'');
        sb.append(", stockName='").append(stockName).append('\'');
        sb.append(", stockSpell='").append(stockSpell).append('\'');
        sb.append(", stockFullName='").append(stockFullName).append('\'');
        sb.append(", stockType='").append(stockType).append('\'');
        sb.append(", assetClass='").append(assetClass).append('\'');
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
