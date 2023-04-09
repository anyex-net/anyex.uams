/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 账户资金表 实体对象
 * <p>File：AccountFund.java</p>
 * <p>Title: AccountFund</p>
 * <p>Description:AccountFund</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "账户资金表")
public class AccountFundEntity extends GenericEntity
{
    protected static final long    serialVersionUID = 1L;
    
    /**账户ID*/
    @NotNull(message = "账户ID不可为空")
    @ApiModelProperty(value = "账户ID", required = true)
    protected Long                 accountId;
    
    /**币种(数据字典)*/
    @NotNull(message = "币种(数据字典)不可为空")
    @ApiModelProperty(value = "币种(数据字典)", required = true)
    protected String               currency;
    
    /**当前金额数量*/
    @NotNull(message = "当前金额数量不可为空")
    @ApiModelProperty(value = "当前金额数量", required = true)
    protected java.math.BigDecimal currentAmount;
    
    /**冻结金额数量*/
    @NotNull(message = "冻结金额数量不可为空")
    @ApiModelProperty(value = "冻结金额数量", required = true)
    protected java.math.BigDecimal frozenAmt;
    
    /**授信金额数量(配资)*/
    @NotNull(message = "授信金额数量(配资)不可为空")
    @ApiModelProperty(value = "授信金额数量(配资)", required = true)
    protected java.math.BigDecimal creditAmt;
    
    /**期初金额数量*/
    @NotNull(message = "期初金额数量不可为空")
    @ApiModelProperty(value = "期初金额数量", required = true)
    protected java.math.BigDecimal initAmt;
    
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
    
    public String getCurrency()
    {
        return this.currency;
    }
    
    public void setCurrency(String currency)
    {
        this.currency = currency;
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
    
    public java.util.Date getUpdateDate()
    {
        return this.updateDate;
    }
    
    public void setUpdateDate(java.util.Date updateDate)
    {
        this.updateDate = updateDate;
    }
    
    public BigDecimal getCreditAmt()
    {
        return creditAmt;
    }
    
    public void setCreditAmt(BigDecimal creditAmt)
    {
        this.creditAmt = creditAmt;
    }
}
