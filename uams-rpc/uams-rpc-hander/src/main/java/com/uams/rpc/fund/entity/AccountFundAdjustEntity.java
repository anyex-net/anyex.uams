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
 * 账户资金调整记录表 实体对象
 * <p>File：AccountFundAdjust.java</p>
 * <p>Title: AccountFundAdjust</p>
 * <p>Description:AccountFundAdjust</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "账户资金调整记录表")
public class AccountFundAdjustEntity extends GenericEntity
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
    
    /**调整类型(数据字典:入金调增、出金调减、授信调增、授信调减)*/
    @NotNull(message = "调整类型不可为空")
    @ApiModelProperty(value = "调整类型(数据字典:入金调增、出金调减、授信调增、授信调减)", required = true)
    protected String               adjustType;
    
    /**调整金额数量*/
    @NotNull(message = "调整金额数量不可为空")
    @ApiModelProperty(value = "调整金额数量", required = true)
    protected java.math.BigDecimal adjustAmt;
    
    /**备注*/
    @ApiModelProperty(value = "备注")
    protected String               remark;
    
    /**创建人*/
    @ApiModelProperty(value = "创建人")
    protected Long                 createBy;
    
    /**创建时间*/
    @NotNull(message = "创建时间不可为空")
    @ApiModelProperty(value = "创建时间", required = true)
    protected java.util.Date       createDate;
    
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
    
    public String getAdjustType()
    {
        return this.adjustType;
    }
    
    public void setAdjustType(String adjustType)
    {
        this.adjustType = adjustType;
    }
    
    public java.math.BigDecimal getAdjustAmt()
    {
        return this.adjustAmt;
    }
    
    public void setAdjustAmt(java.math.BigDecimal adjustAmt)
    {
        this.adjustAmt = adjustAmt;
    }
    
    public String getRemark()
    {
        return this.remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    
    public Long getCreateBy()
    {
        return this.createBy;
    }
    
    public void setCreateBy(Long createBy)
    {
        this.createBy = createBy;
    }
    
    public java.util.Date getCreateDate()
    {
        return this.createDate;
    }
    
    public void setCreateDate(java.util.Date createDate)
    {
        this.createDate = createDate;
    }
}
