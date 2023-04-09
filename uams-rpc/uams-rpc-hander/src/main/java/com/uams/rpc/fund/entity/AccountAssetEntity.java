/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

/**
 * 账户持仓表 实体对象
 * <p>File：AccountAsset.java</p>
 * <p>Title: AccountAsset</p>
 * <p>Description:AccountAsset</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "账户持仓表")
public class AccountAssetEntity extends GenericEntity
{
    protected static final long    serialVersionUID = 1L;
    
    /**账户ID*/
    @NotNull(message = "账户ID不可为空")
    @ApiModelProperty(value = "账户ID", required = true)
    protected Long                 accountId;
    
    /**证券信息id,对应Stockinfo表中的ID字段*/
    @NotNull(message = "证券信息id,对应Stockinfo表中的ID字段不可为空")
    @ApiModelProperty(value = "证券信息id,对应Stockinfo表中的ID字段", required = true)
    protected Long                 stockinfoId;
    
    /**方向(多头Long,空头Short)*/
    @NotNull(message = "方向(多头Long,空头Short)不可为空")
    @ApiModelProperty(value = "方向(多头Long,空头Short)", required = true)
    protected String               direction;
    
    /**当前金额数量*/
    @NotNull(message = "当前金额数量不可为空")
    @ApiModelProperty(value = "当前金额数量", required = true)
    protected java.math.BigDecimal currentAmount;
    
    /**冻结金额数量*/
    @NotNull(message = "冻结金额数量不可为空")
    @ApiModelProperty(value = "冻结金额数量", required = true)
    protected java.math.BigDecimal frozenAmt;
    
    /**期初金额数量*/
    @NotNull(message = "期初金额数量不可为空")
    @ApiModelProperty(value = "期初金额数量", required = true)
    protected java.math.BigDecimal initAmt;
    
    /**加权成本价格*/
    @NotNull(message = "加权成本价格不可为空")
    @ApiModelProperty(value = "加权成本价格", required = true)
    protected java.math.BigDecimal price;
    
    /**更新时间*/
    @NotNull(message = "更新时间不可为空")
    @ApiModelProperty(value = "更新时间", required = true)
    protected java.util.Date       updateDate;
    
    public Long getAccountId()
    {
        return this.accountId;
    }
    
    public void setAccountId(Long accountId)
    {
        this.accountId = accountId;
    }
    
    public Long getStockinfoId()
    {
        return this.stockinfoId;
    }
    
    public void setStockinfoId(Long stockinfoId)
    {
        this.stockinfoId = stockinfoId;
    }
    
    public String getDirection()
    {
        return this.direction;
    }
    
    public void setDirection(String direction)
    {
        this.direction = direction;
    }
    
    public java.math.BigDecimal getCurrentAmount()
    {
        return this.currentAmount;
    }
    
    public void setCurrentAmount(java.math.BigDecimal currentAmount)
    {
        this.currentAmount = currentAmount;
    }
    
    public java.math.BigDecimal getFrozenAmt()
    {
        return this.frozenAmt;
    }
    
    public void setFrozenAmt(java.math.BigDecimal frozenAmt)
    {
        this.frozenAmt = frozenAmt;
    }
    
    public java.math.BigDecimal getInitAmt()
    {
        return this.initAmt;
    }
    
    public void setInitAmt(java.math.BigDecimal initAmt)
    {
        this.initAmt = initAmt;
    }
    
    public java.math.BigDecimal getPrice()
    {
        return this.price;
    }
    
    public void setPrice(java.math.BigDecimal price)
    {
        this.price = price;
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
