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
 * 各分支机构品种交易费率配置表 实体对象
 * <p>File：OrgTradeFeeCfg.java</p>
 * <p>Title: OrgTradeFeeCfg</p>
 * <p>Description:OrgTradeFeeCfg</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "各分支机构品种交易费率配置表")
public class OrgTradeFeeCfgEntity extends GenericEntity
{
    protected static final long serialVersionUID = 1L;
    
    /**机构ID*/
    @NotNull(message = "机构ID不可为空")
    @ApiModelProperty(value = "机构ID", required = true)
    protected Long              orgId;
    
    /**交易市场ID*/
    @NotNull(message = "交易市场ID不可为空")
    @ApiModelProperty(value = "交易市场ID", required = true)
    protected Long              marketId;
    
    /**期货品种ID*/
    @NotNull(message = "期货品种ID不可为空")
    @ApiModelProperty(value = "期货品种ID", required = true)
    protected Long              futureKindId;
    
    /**费用类型(数据字典)*/
    @NotNull(message = "费用类型(数据字典)不可为空")
    @ApiModelProperty(value = "费用类型(数据字典)", required = true)
    protected String            feeType;
    
    /**费率类型(数据字典)*/
    @NotNull(message = "费率类型(数据字典)不可为空")
    @ApiModelProperty(value = "费率类型(数据字典)", required = true)
    protected String            feeRateType;
    
    /**费率*/
    @NotNull(message = "费率不可为空")
    @ApiModelProperty(value = "费率", required = true)
    protected String            feeRate;
    
    /**更新时间*/
    @NotNull(message = "更新时间不可为空")
    @ApiModelProperty(value = "更新时间", required = true)
    protected java.util.Date    updateDate;
    
    public Long getOrgId()
    {
        return this.orgId;
    }
    
    public void setOrgId(Long orgId)
    {
        this.orgId = orgId;
    }
    
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
    
    public String getFeeType()
    {
        return this.feeType;
    }
    
    public void setFeeType(String feeType)
    {
        this.feeType = feeType;
    }
    
    public String getFeeRateType()
    {
        return this.feeRateType;
    }
    
    public void setFeeRateType(String feeRateType)
    {
        this.feeRateType = feeRateType;
    }
    
    public String getFeeRate()
    {
        return this.feeRate;
    }
    
    public void setFeeRate(String feeRate)
    {
        this.feeRate = feeRate;
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
