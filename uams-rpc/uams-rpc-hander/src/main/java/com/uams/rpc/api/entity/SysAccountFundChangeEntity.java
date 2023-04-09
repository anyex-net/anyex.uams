/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity ;
import javax.validation.constraints.NotNull;
/**
 * SysAccountFundChange 实体对象
 * <p>File：SysAccountFundChange.java</p>
 * <p>Title: SysAccountFundChange</p>
 * <p>Description:SysAccountFundChange</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "平台资金账户资金变化记录")
public class SysAccountFundChangeEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**accountDeliveryFee*/
	@NotNull(message = "accountDeliveryFee不可为空")
	@ApiModelProperty(value = "accountDeliveryFee", required = true)
	protected java.math.BigDecimal accountDeliveryFee;
	/**accountFee*/
	@NotNull(message = "accountFee不可为空")
	@ApiModelProperty(value = "accountFee", required = true)
	protected java.math.BigDecimal accountFee;
	/**accountIntialMargin*/
	@NotNull(message = "accountIntialMargin不可为空")
	@ApiModelProperty(value = "accountIntialMargin", required = true)
	protected java.math.BigDecimal accountIntialMargin;
	/**accountMaintenanceMargin*/
	@NotNull(message = "accountMaintenanceMargin不可为空")
	@ApiModelProperty(value = "accountMaintenanceMargin", required = true)
	protected java.math.BigDecimal accountMaintenanceMargin;
	/**accountNo*/
	@NotNull(message = "accountNo不可为空")
	@ApiModelProperty(value = "accountNo", required = true)
	protected String accountNo;
	/**authMoney*/
	@NotNull(message = "authMoney不可为空")
	@ApiModelProperty(value = "authMoney", required = true)
	protected java.math.BigDecimal authMoney;
	/**available*/
	@NotNull(message = "available不可为空")
	@ApiModelProperty(value = "available", required = true)
	protected java.math.BigDecimal available;
	/**balance*/
	@NotNull(message = "balance不可为空")
	@ApiModelProperty(value = "balance", required = true)
	protected java.math.BigDecimal balance;
	/**canDraw*/
	@NotNull(message = "canDraw不可为空")
	@ApiModelProperty(value = "canDraw", required = true)
	protected java.math.BigDecimal canDraw;
	/**cashAdjustValue*/
	@NotNull(message = "cashAdjustValue不可为空")
	@ApiModelProperty(value = "cashAdjustValue", required = true)
	protected java.math.BigDecimal cashAdjustValue;
	/**cashInValue*/
	@NotNull(message = "cashInValue不可为空")
	@ApiModelProperty(value = "cashInValue", required = true)
	protected java.math.BigDecimal cashInValue;
	/**cashOutValue*/
	@NotNull(message = "cashOutValue不可为空")
	@ApiModelProperty(value = "cashOutValue", required = true)
	protected java.math.BigDecimal cashOutValue;
	/**cashPledged*/
	@NotNull(message = "cashPledged不可为空")
	@ApiModelProperty(value = "cashPledged", required = true)
	protected java.math.BigDecimal cashPledged;
	/**closeProfit*/
	@NotNull(message = "closeProfit不可为空")
	@ApiModelProperty(value = "closeProfit", required = true)
	protected java.math.BigDecimal closeProfit;
	/**currencyGroupNo*/
	@NotNull(message = "currencyGroupNo不可为空")
	@ApiModelProperty(value = "currencyGroupNo", required = true)
	protected String currencyGroupNo;
	/**currencyNo*/
	@ApiModelProperty(value = "currencyNo")
	protected String currencyNo;
	/**deliveryProfit*/
	@NotNull(message = "deliveryProfit不可为空")
	@ApiModelProperty(value = "deliveryProfit", required = true)
	protected java.math.BigDecimal deliveryProfit;
	/**discount*/
	@NotNull(message = "discount不可为空")
	@ApiModelProperty(value = "discount", required = true)
	protected java.math.BigDecimal discount;
	/**equity*/
	@NotNull(message = "equity不可为空")
	@ApiModelProperty(value = "equity", required = true)
	protected java.math.BigDecimal equity;
	/**exchangeFee*/
	@NotNull(message = "exchangeFee不可为空")
	@ApiModelProperty(value = "exchangeFee", required = true)
	protected java.math.BigDecimal exchangeFee;
	/**expProfit*/
	@NotNull(message = "expProfit不可为空")
	@ApiModelProperty(value = "expProfit", required = true)
	protected java.math.BigDecimal expProfit;
	/**frozenDeposit*/
	@NotNull(message = "frozenDeposit不可为空")
	@ApiModelProperty(value = "frozenDeposit", required = true)
	protected java.math.BigDecimal frozenDeposit;
	/**frozenFee*/
	@NotNull(message = "frozenFee不可为空")
	@ApiModelProperty(value = "frozenFee", required = true)
	protected java.math.BigDecimal frozenFee;
	/**futureAlg*/
	@ApiModelProperty(value = "futureAlg")
	protected String futureAlg;
	/**lmePositionProfit*/
	@NotNull(message = "lmePositionProfit不可为空")
	@ApiModelProperty(value = "lmePositionProfit", required = true)
	protected java.math.BigDecimal lmePositionProfit;
	/**marketEquity*/
	@NotNull(message = "marketEquity不可为空")
	@ApiModelProperty(value = "marketEquity", required = true)
	protected java.math.BigDecimal marketEquity;
	/**optionAlg*/
	@ApiModelProperty(value = "optionAlg")
	protected String optionAlg;
	/**optionMarketValue*/
	@NotNull(message = "optionMarketValue不可为空")
	@ApiModelProperty(value = "optionMarketValue", required = true)
	protected java.math.BigDecimal optionMarketValue;
	/**positionProfit*/
	@NotNull(message = "positionProfit不可为空")
	@ApiModelProperty(value = "positionProfit", required = true)
	protected java.math.BigDecimal positionProfit;
	/**preAvailable1*/
	@NotNull(message = "preAvailable1不可为空")
	@ApiModelProperty(value = "preAvailable1", required = true)
	protected java.math.BigDecimal preAvailable1;
	/**preBalance*/
	@NotNull(message = "preBalance不可为空")
	@ApiModelProperty(value = "preBalance", required = true)
	protected java.math.BigDecimal preBalance;
	/**preEquity*/
	@NotNull(message = "preEquity不可为空")
	@ApiModelProperty(value = "preEquity", required = true)
	protected java.math.BigDecimal preEquity;
	/**preLMEPositionProfit*/
	@NotNull(message = "preLMEPositionProfit不可为空")
	@ApiModelProperty(value = "preLMEPositionProfit", required = true)
	protected java.math.BigDecimal preLMEPositionProfit;
	/**preMarketEquity*/
	@NotNull(message = "preMarketEquity不可为空")
	@ApiModelProperty(value = "preMarketEquity", required = true)
	protected java.math.BigDecimal preMarketEquity;
	/**premiumIncome*/
	@NotNull(message = "premiumIncome不可为空")
	@ApiModelProperty(value = "premiumIncome", required = true)
	protected java.math.BigDecimal premiumIncome;
	/**premiumPay*/
	@NotNull(message = "premiumPay不可为空")
	@ApiModelProperty(value = "premiumPay", required = true)
	protected java.math.BigDecimal premiumPay;
	/**preUnExpProfit*/
	@NotNull(message = "preUnExpProfit不可为空")
	@ApiModelProperty(value = "preUnExpProfit", required = true)
	protected java.math.BigDecimal preUnExpProfit;
	/**tradeRate*/
	@NotNull(message = "tradeRate不可为空")
	@ApiModelProperty(value = "tradeRate", required = true)
	protected java.math.BigDecimal tradeRate;
	/**unExpProfit*/
	@NotNull(message = "unExpProfit不可为空")
	@ApiModelProperty(value = "unExpProfit", required = true)
	protected java.math.BigDecimal unExpProfit;
	/**upperInitalMargin*/
	@NotNull(message = "upperInitalMargin不可为空")
	@ApiModelProperty(value = "upperInitalMargin", required = true)
	protected java.math.BigDecimal upperInitalMargin;
	/**upperMaintenanceMargin*/
	@NotNull(message = "upperMaintenanceMargin不可为空")
	@ApiModelProperty(value = "upperMaintenanceMargin", required = true)
	protected java.math.BigDecimal upperMaintenanceMargin;
	/**remark*/
	@ApiModelProperty(value = "remark")
	protected String remark;
	/**createDate*/
	@NotNull(message = "createDate不可为空")
	@ApiModelProperty(value = "createDate", required = true)
	protected java.util.Date createDate;
	/**updateDate*/
	@ApiModelProperty(value = "updateDate")
	protected java.util.Date updateDate;
	
	public java.math.BigDecimal getAccountDeliveryFee()
	{
		return this.accountDeliveryFee;
	}
	
	public void setAccountDeliveryFee(java.math.BigDecimal accountDeliveryFee)
	{
		this.accountDeliveryFee = accountDeliveryFee;
	}
	
	public java.math.BigDecimal getAccountFee()
	{
		return this.accountFee;
	}
	
	public void setAccountFee(java.math.BigDecimal accountFee)
	{
		this.accountFee = accountFee;
	}
	
	public java.math.BigDecimal getAccountIntialMargin()
	{
		return this.accountIntialMargin;
	}
	
	public void setAccountIntialMargin(java.math.BigDecimal accountIntialMargin)
	{
		this.accountIntialMargin = accountIntialMargin;
	}
	
	public java.math.BigDecimal getAccountMaintenanceMargin()
	{
		return this.accountMaintenanceMargin;
	}
	
	public void setAccountMaintenanceMargin(java.math.BigDecimal accountMaintenanceMargin)
	{
		this.accountMaintenanceMargin = accountMaintenanceMargin;
	}
	
	public String getAccountNo()
	{
		return this.accountNo;
	}
	
	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	
	public java.math.BigDecimal getAuthMoney()
	{
		return this.authMoney;
	}
	
	public void setAuthMoney(java.math.BigDecimal authMoney)
	{
		this.authMoney = authMoney;
	}
	
	public java.math.BigDecimal getAvailable()
	{
		return this.available;
	}
	
	public void setAvailable(java.math.BigDecimal available)
	{
		this.available = available;
	}
	
	public java.math.BigDecimal getBalance()
	{
		return this.balance;
	}
	
	public void setBalance(java.math.BigDecimal balance)
	{
		this.balance = balance;
	}
	
	public java.math.BigDecimal getCanDraw()
	{
		return this.canDraw;
	}
	
	public void setCanDraw(java.math.BigDecimal canDraw)
	{
		this.canDraw = canDraw;
	}
	
	public java.math.BigDecimal getCashAdjustValue()
	{
		return this.cashAdjustValue;
	}
	
	public void setCashAdjustValue(java.math.BigDecimal cashAdjustValue)
	{
		this.cashAdjustValue = cashAdjustValue;
	}
	
	public java.math.BigDecimal getCashInValue()
	{
		return this.cashInValue;
	}
	
	public void setCashInValue(java.math.BigDecimal cashInValue)
	{
		this.cashInValue = cashInValue;
	}
	
	public java.math.BigDecimal getCashOutValue()
	{
		return this.cashOutValue;
	}
	
	public void setCashOutValue(java.math.BigDecimal cashOutValue)
	{
		this.cashOutValue = cashOutValue;
	}
	
	public java.math.BigDecimal getCashPledged()
	{
		return this.cashPledged;
	}
	
	public void setCashPledged(java.math.BigDecimal cashPledged)
	{
		this.cashPledged = cashPledged;
	}
	
	public java.math.BigDecimal getCloseProfit()
	{
		return this.closeProfit;
	}
	
	public void setCloseProfit(java.math.BigDecimal closeProfit)
	{
		this.closeProfit = closeProfit;
	}
	
	public String getCurrencyGroupNo()
	{
		return this.currencyGroupNo;
	}
	
	public void setCurrencyGroupNo(String currencyGroupNo)
	{
		this.currencyGroupNo = currencyGroupNo;
	}
	
	public String getCurrencyNo()
	{
		return this.currencyNo;
	}
	
	public void setCurrencyNo(String currencyNo)
	{
		this.currencyNo = currencyNo;
	}
	
	public java.math.BigDecimal getDeliveryProfit()
	{
		return this.deliveryProfit;
	}
	
	public void setDeliveryProfit(java.math.BigDecimal deliveryProfit)
	{
		this.deliveryProfit = deliveryProfit;
	}
	
	public java.math.BigDecimal getDiscount()
	{
		return this.discount;
	}
	
	public void setDiscount(java.math.BigDecimal discount)
	{
		this.discount = discount;
	}
	
	public java.math.BigDecimal getEquity()
	{
		return this.equity;
	}
	
	public void setEquity(java.math.BigDecimal equity)
	{
		this.equity = equity;
	}
	
	public java.math.BigDecimal getExchangeFee()
	{
		return this.exchangeFee;
	}
	
	public void setExchangeFee(java.math.BigDecimal exchangeFee)
	{
		this.exchangeFee = exchangeFee;
	}
	
	public java.math.BigDecimal getExpProfit()
	{
		return this.expProfit;
	}
	
	public void setExpProfit(java.math.BigDecimal expProfit)
	{
		this.expProfit = expProfit;
	}
	
	public java.math.BigDecimal getFrozenDeposit()
	{
		return this.frozenDeposit;
	}
	
	public void setFrozenDeposit(java.math.BigDecimal frozenDeposit)
	{
		this.frozenDeposit = frozenDeposit;
	}
	
	public java.math.BigDecimal getFrozenFee()
	{
		return this.frozenFee;
	}
	
	public void setFrozenFee(java.math.BigDecimal frozenFee)
	{
		this.frozenFee = frozenFee;
	}
	
	public String getFutureAlg()
	{
		return this.futureAlg;
	}
	
	public void setFutureAlg(String futureAlg)
	{
		this.futureAlg = futureAlg;
	}
	
	public java.math.BigDecimal getLmePositionProfit()
	{
		return this.lmePositionProfit;
	}
	
	public void setLmePositionProfit(java.math.BigDecimal lmePositionProfit)
	{
		this.lmePositionProfit = lmePositionProfit;
	}
	
	public java.math.BigDecimal getMarketEquity()
	{
		return this.marketEquity;
	}
	
	public void setMarketEquity(java.math.BigDecimal marketEquity)
	{
		this.marketEquity = marketEquity;
	}
	
	public String getOptionAlg()
	{
		return this.optionAlg;
	}
	
	public void setOptionAlg(String optionAlg)
	{
		this.optionAlg = optionAlg;
	}
	
	public java.math.BigDecimal getOptionMarketValue()
	{
		return this.optionMarketValue;
	}
	
	public void setOptionMarketValue(java.math.BigDecimal optionMarketValue)
	{
		this.optionMarketValue = optionMarketValue;
	}
	
	public java.math.BigDecimal getPositionProfit()
	{
		return this.positionProfit;
	}
	
	public void setPositionProfit(java.math.BigDecimal positionProfit)
	{
		this.positionProfit = positionProfit;
	}
	
	public java.math.BigDecimal getPreAvailable1()
	{
		return this.preAvailable1;
	}
	
	public void setPreAvailable1(java.math.BigDecimal preAvailable1)
	{
		this.preAvailable1 = preAvailable1;
	}
	
	public java.math.BigDecimal getPreBalance()
	{
		return this.preBalance;
	}
	
	public void setPreBalance(java.math.BigDecimal preBalance)
	{
		this.preBalance = preBalance;
	}
	
	public java.math.BigDecimal getPreEquity()
	{
		return this.preEquity;
	}
	
	public void setPreEquity(java.math.BigDecimal preEquity)
	{
		this.preEquity = preEquity;
	}
	
	public java.math.BigDecimal getPreLMEPositionProfit()
	{
		return this.preLMEPositionProfit;
	}
	
	public void setPreLMEPositionProfit(java.math.BigDecimal preLMEPositionProfit)
	{
		this.preLMEPositionProfit = preLMEPositionProfit;
	}
	
	public java.math.BigDecimal getPreMarketEquity()
	{
		return this.preMarketEquity;
	}
	
	public void setPreMarketEquity(java.math.BigDecimal preMarketEquity)
	{
		this.preMarketEquity = preMarketEquity;
	}
	
	public java.math.BigDecimal getPremiumIncome()
	{
		return this.premiumIncome;
	}
	
	public void setPremiumIncome(java.math.BigDecimal premiumIncome)
	{
		this.premiumIncome = premiumIncome;
	}
	
	public java.math.BigDecimal getPremiumPay()
	{
		return this.premiumPay;
	}
	
	public void setPremiumPay(java.math.BigDecimal premiumPay)
	{
		this.premiumPay = premiumPay;
	}
	
	public java.math.BigDecimal getPreUnExpProfit()
	{
		return this.preUnExpProfit;
	}
	
	public void setPreUnExpProfit(java.math.BigDecimal preUnExpProfit)
	{
		this.preUnExpProfit = preUnExpProfit;
	}
	
	public java.math.BigDecimal getTradeRate()
	{
		return this.tradeRate;
	}
	
	public void setTradeRate(java.math.BigDecimal tradeRate)
	{
		this.tradeRate = tradeRate;
	}
	
	public java.math.BigDecimal getUnExpProfit()
	{
		return this.unExpProfit;
	}
	
	public void setUnExpProfit(java.math.BigDecimal unExpProfit)
	{
		this.unExpProfit = unExpProfit;
	}
	
	public java.math.BigDecimal getUpperInitalMargin()
	{
		return this.upperInitalMargin;
	}
	
	public void setUpperInitalMargin(java.math.BigDecimal upperInitalMargin)
	{
		this.upperInitalMargin = upperInitalMargin;
	}
	
	public java.math.BigDecimal getUpperMaintenanceMargin()
	{
		return this.upperMaintenanceMargin;
	}
	
	public void setUpperMaintenanceMargin(java.math.BigDecimal upperMaintenanceMargin)
	{
		this.upperMaintenanceMargin = upperMaintenanceMargin;
	}
	
	public String getRemark()
	{
		return this.remark;
	}
	
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	
	public java.util.Date getCreateDate()
	{
		return this.createDate;
	}
	
	public void setCreateDate(java.util.Date createDate)
	{
		this.createDate = createDate;
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

