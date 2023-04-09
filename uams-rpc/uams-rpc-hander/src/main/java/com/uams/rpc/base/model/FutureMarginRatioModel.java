/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.model;

import com.uams.rpc.base.entity.FutureMarginRatioEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

/**
 * 期货保证金比例设置表 实体对象
 * <p>File：FutureMarginRatio.java</p>
 * <p>Title: FutureMarginRatio</p>
 * <p>Description:FutureMarginRatio</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "期货保证金比例设置表")
public class FutureMarginRatioModel extends FutureMarginRatioEntity
{
    /**证券名称*/
    private String stockName;
    
    /**经纪商名称*/
    private String brokerName;
    
    /**股东代码名称*/
    private String stockHolderName;
    
    public String getStockName()
    {
        return stockName;
    }
    
    public void setStockName(String stockName)
    {
        this.stockName = stockName;
    }
    
    public String getBrokerName()
    {
        return brokerName;
    }
    
    public void setBrokerName(String brokerName)
    {
        this.brokerName = brokerName;
    }
    
    public String getStockHolderName()
    {
        return stockHolderName;
    }
    
    public void setStockHolderName(String stockHolderName)
    {
        this.stockHolderName = stockHolderName;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("FutureMarginRatioModel{");
        sb.append("id=").append(id);
        sb.append(", stockName='").append(stockName).append('\'');
        sb.append(", brokerName='").append(brokerName).append('\'');
        sb.append(", stockHolderName='").append(stockHolderName).append('\'');
        sb.append(", stockInfoId=").append(stockInfoId);
        sb.append(", brokerId=").append(brokerId);
        sb.append(", stockHolderId='").append(stockHolderId).append('\'');
        sb.append(", ratio='").append(ratio).append('\'');
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
