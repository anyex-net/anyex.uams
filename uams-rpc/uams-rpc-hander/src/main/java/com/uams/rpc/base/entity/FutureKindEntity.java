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
 * 期货品种表 实体对象
 * <p>File：FutureKind.java</p>
 * <p>Title: FutureKind</p>
 * <p>Description:FutureKind</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "期货品种表")
public class FutureKindEntity extends GenericEntity
{
    protected static final long serialVersionUID = 1L;
    
    /**交易市场ID*/
    @NotNull(message = "交易市场ID不可为空")
    @ApiModelProperty(value = "交易市场ID", required = true)
    protected Long              marketId;
    
    /**品种编码*/
    @NotNull(message = "品种编码不可为空")
    @ApiModelProperty(value = "品种编码", required = true)
    protected String            kindCode;
    
    /**品种名称*/
    @NotNull(message = "品种名称不可为空")
    @ApiModelProperty(value = "品种名称", required = true)
    protected String            kindName;
    
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
    
    public String getKindCode()
    {
        return this.kindCode;
    }
    
    public void setKindCode(String kindCode)
    {
        this.kindCode = kindCode;
    }
    
    public String getKindName()
    {
        return this.kindName;
    }
    
    public void setKindName(String kindName)
    {
        this.kindName = kindName;
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
