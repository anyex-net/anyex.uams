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
 * 账户资金流水表 实体对象
 * <p>File：AccountFundCurrent.java</p>
 * <p>Title: AccountFundCurrent</p>
 * <p>Description:AccountFundCurrent</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "账户资金流水表")
public class AccountFundCurrentEntity extends GenericEntity
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
    
    /**流水时间戳*/
    @NotNull(message = "流水时间戳不可为空")
    @ApiModelProperty(value = "流水时间戳", required = true)
    protected java.util.Date       currentDate;
    
    /**业务类别(数据字典)*/
    @NotNull(message = "业务类别(数据字典)不可为空")
    @ApiModelProperty(value = "业务类别(数据字典)", required = true)
    protected String               businessFlag;
    
    /**证券信息id,对应Stockinfo表中的ID字段*/
    @NotNull(message = "证券信息id,对应Stockinfo表中的ID字段不可为空")
    @ApiModelProperty(value = "证券信息id,对应Stockinfo表中的ID字段", required = true)
    protected Long                 stockinfoId;
    
    /**资产发生方向(增加increase、减少decrease、冻结frozen、解冻unfrozen、解冻并减少frozenDecrease)*/
    @NotNull(message = "资产发生方向(增加increase、减少decrease、冻结frozen、解冻unfrozen、解冻并减少frozenDecrease)不可为空")
    @ApiModelProperty(value = "资产发生方向(增加increase、减少decrease、冻结frozen、解冻unfrozen、解冻并减少frozenDecrease)", required = true)
    protected String               occurDirect;
    
    /**原资产当前数量余额*/
    @NotNull(message = "原资产当前数量余额不可为空")
    @ApiModelProperty(value = "原资产当前数量余额", required = true)
    protected java.math.BigDecimal orgAmt;
    
    /**资产增加减少发生数量*/
    @NotNull(message = "资产增加减少发生数量不可为空")
    @ApiModelProperty(value = "资产增加减少发生数量", required = true)
    protected java.math.BigDecimal occurAmt;
    
    /**最新资产当前数量余额*/
    @NotNull(message = "最新资产当前数量余额不可为空")
    @ApiModelProperty(value = "最新资产当前数量余额", required = true)
    protected java.math.BigDecimal lastAmt;
    
    /**原冻结资产数量余额*/
    @NotNull(message = "原冻结资产数量余额不可为空")
    @ApiModelProperty(value = "原冻结资产数量余额", required = true)
    protected java.math.BigDecimal forzenOrgAmt;
    
    /**冻结解冻发生数量*/
    @NotNull(message = "冻结解冻发生数量不可为空")
    @ApiModelProperty(value = "冻结解冻发生数量", required = true)
    protected java.math.BigDecimal occurForzenAmt;
    
    /**最新冻结资产数量余额*/
    @NotNull(message = "最新冻结资产数量余额不可为空")
    @ApiModelProperty(value = "最新冻结资产数量余额", required = true)
    protected java.math.BigDecimal forzenLastAmt;
    
    /**支付交易ID*/
    @ApiModelProperty(value = "支付交易ID")
    protected String               transId;
    
    /**源账户银行ID*/
    @ApiModelProperty(value = "源账户银行ID")
    protected Long                 sourceAccountBankId;
    
    /**目标账户银行ID*/
    @ApiModelProperty(value = "目标账户银行ID")
    protected Long                 targetAccountBankId;
    
    /**费用*/
    @NotNull(message = "费用不可为空")
    @ApiModelProperty(value = "费用", required = true)
    protected java.math.BigDecimal fee;
    
    /**转账费用*/
    @ApiModelProperty(value = "转账费用")
    protected java.math.BigDecimal netFee;
    
    /**原始业务ID*/
    @NotNull(message = "原始业务ID不可为空")
    @ApiModelProperty(value = "原始业务ID", required = true)
    protected Long                 originalBusinessId;
    
    /**备注*/
    @ApiModelProperty(value = "备注")
    protected String               remark;
    
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
    
    public java.util.Date getCurrentDate()
    {
        return this.currentDate;
    }
    
    public void setCurrentDate(java.util.Date currentDate)
    {
        this.currentDate = currentDate;
    }
    
    public String getBusinessFlag()
    {
        return this.businessFlag;
    }
    
    public void setBusinessFlag(String businessFlag)
    {
        this.businessFlag = businessFlag;
    }
    
    public Long getStockinfoId()
    {
        return this.stockinfoId;
    }
    
    public void setStockinfoId(Long stockinfoId)
    {
        this.stockinfoId = stockinfoId;
    }
    
    public String getOccurDirect()
    {
        return this.occurDirect;
    }
    
    public void setOccurDirect(String occurDirect)
    {
        this.occurDirect = occurDirect;
    }
    
    public java.math.BigDecimal getOrgAmt()
    {
        return this.orgAmt;
    }
    
    public void setOrgAmt(java.math.BigDecimal orgAmt)
    {
        this.orgAmt = orgAmt;
    }
    
    public java.math.BigDecimal getOccurAmt()
    {
        return this.occurAmt;
    }
    
    public void setOccurAmt(java.math.BigDecimal occurAmt)
    {
        this.occurAmt = occurAmt;
    }
    
    public java.math.BigDecimal getLastAmt()
    {
        return this.lastAmt;
    }
    
    public void setLastAmt(java.math.BigDecimal lastAmt)
    {
        this.lastAmt = lastAmt;
    }
    
    public java.math.BigDecimal getForzenOrgAmt()
    {
        return this.forzenOrgAmt;
    }
    
    public void setForzenOrgAmt(java.math.BigDecimal forzenOrgAmt)
    {
        this.forzenOrgAmt = forzenOrgAmt;
    }
    
    public java.math.BigDecimal getOccurForzenAmt()
    {
        return this.occurForzenAmt;
    }
    
    public void setOccurForzenAmt(java.math.BigDecimal occurForzenAmt)
    {
        this.occurForzenAmt = occurForzenAmt;
    }
    
    public java.math.BigDecimal getForzenLastAmt()
    {
        return this.forzenLastAmt;
    }
    
    public void setForzenLastAmt(java.math.BigDecimal forzenLastAmt)
    {
        this.forzenLastAmt = forzenLastAmt;
    }
    
    public String getTransId()
    {
        return this.transId;
    }
    
    public void setTransId(String transId)
    {
        this.transId = transId;
    }
    
    public Long getSourceAccountBankId()
    {
        return this.sourceAccountBankId;
    }
    
    public void setSourceAccountBankId(Long sourceAccountBankId)
    {
        this.sourceAccountBankId = sourceAccountBankId;
    }
    
    public Long getTargetAccountBankId()
    {
        return this.targetAccountBankId;
    }
    
    public void setTargetAccountBankId(Long targetAccountBankId)
    {
        this.targetAccountBankId = targetAccountBankId;
    }
    
    public java.math.BigDecimal getFee()
    {
        return this.fee;
    }
    
    public void setFee(java.math.BigDecimal fee)
    {
        this.fee = fee;
    }
    
    public java.math.BigDecimal getNetFee()
    {
        return this.netFee;
    }
    
    public void setNetFee(java.math.BigDecimal netFee)
    {
        this.netFee = netFee;
    }
    
    public Long getOriginalBusinessId()
    {
        return this.originalBusinessId;
    }
    
    public void setOriginalBusinessId(Long originalBusinessId)
    {
        this.originalBusinessId = originalBusinessId;
    }
    
    public String getRemark()
    {
        return this.remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}
