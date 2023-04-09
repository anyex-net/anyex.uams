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
 * 各分支机构可交易各大交易所期货品种配置表 实体对象
 * <p>File：OrgTradeStockKindCfg.java</p>
 * <p>Title: OrgTradeStockKindCfg</p>
 * <p>Description:OrgTradeStockKindCfg</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "各分支机构可交易各大交易所期货品种配置表")
public class OrgTradeStockKindCfgEntity extends GenericEntity
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
    
    public java.util.Date getUpdateDate()
    {
        return this.updateDate;
    }
    
    public void setUpdateDate(java.util.Date updateDate)
    {
        this.updateDate = updateDate;
    }
}
