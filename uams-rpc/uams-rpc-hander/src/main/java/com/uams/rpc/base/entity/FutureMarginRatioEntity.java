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
public class FutureMarginRatioEntity extends GenericEntity
{
    protected static final long serialVersionUID = 1L;
    
    /**证券信息ID*/
    @NotNull(message = "证券信息ID不可为空")
    @ApiModelProperty(value = "证券信息ID", required = true)
    protected Long              stockInfoId;
    
    /**券商期货ID("brokerInfo"表)*/
    @NotNull(message = "券商期货ID(brokerInfo表)不可为空")
    @ApiModelProperty(value = "券商期货ID(brokerInfo表)", required = true)
    protected Long              brokerId;
    
    /**股东代码ID*/
    @NotNull(message = "股东代码ID不可为空")
    @ApiModelProperty(value = "股东代码ID", required = true)
    protected String            stockHolderId;
    
    /**保证金比例*/
    @NotNull(message = "保证金比例不可为空")
    @ApiModelProperty(value = "保证金比例", required = true)
    protected String            ratio;
    
    /**更新时间*/
    @NotNull(message = "更新时间不可为空")
    @ApiModelProperty(value = "更新时间", required = true)
    protected java.util.Date    updateDate;
    
    public Long getStockInfoId()
    {
        return this.stockInfoId;
    }
    
    public void setStockInfoId(Long stockInfoId)
    {
        this.stockInfoId = stockInfoId;
    }
    
    public Long getBrokerId()
    {
        return this.brokerId;
    }
    
    public void setBrokerId(Long brokerId)
    {
        this.brokerId = brokerId;
    }
    
    public String getStockHolderId()
    {
        return this.stockHolderId;
    }
    
    public void setStockHolderId(String stockHolderId)
    {
        this.stockHolderId = stockHolderId;
    }
    
    public String getRatio()
    {
        return this.ratio;
    }
    
    public void setRatio(String ratio)
    {
        this.ratio = ratio;
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
