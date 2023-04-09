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
 * 平台资金账户资金信息表 实体对象
 * <p>File：SysAccountFund.java</p>
 * <p>Title: SysAccountFund</p>
 * <p>Description:SysAccountFund</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "平台资金账户资金信息表")
public class SysAccountFundEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**客户交割手续费*/
	@NotNull(message = "客户交割手续费不可为空")
	@ApiModelProperty(value = "客户交割手续费", required = true)
	protected java.math.BigDecimal accountDeliveryFee;
	/**客户手续费包含交割手续费*/
	@NotNull(message = "客户手续费包含交割手续费不可为空")
	@ApiModelProperty(value = "客户手续费包含交割手续费", required = true)
	protected java.math.BigDecimal accountFee;
	/**客户初始保证金*/
	@NotNull(message = "客户初始保证金不可为空")
	@ApiModelProperty(value = "客户初始保证金", required = true)
	protected java.math.BigDecimal accountIntialMargin;
	/**客户维持保证金*/
	@NotNull(message = "客户维持保证金不可为空")
	@ApiModelProperty(value = "客户维持保证金", required = true)
	protected java.math.BigDecimal accountMaintenanceMargin;
	/**客户资金账号*/
	@NotNull(message = "客户资金账号不可为空")
	@ApiModelProperty(value = "客户资金账号", required = true)
	protected String accountNo;
	/**授信资金*/
	@NotNull(message = "授信资金不可为空")
	@ApiModelProperty(value = "授信资金", required = true)
	protected java.math.BigDecimal authMoney;
	/**当日可用*/
	@NotNull(message = "当日可用不可为空")
	@ApiModelProperty(value = "当日可用", required = true)
	protected java.math.BigDecimal available;
	/**当日结存*/
	@NotNull(message = "当日结存不可为空")
	@ApiModelProperty(value = "当日结存", required = true)
	protected java.math.BigDecimal balance;
	/**可提取*/
	@NotNull(message = "可提取不可为空")
	@ApiModelProperty(value = "可提取", required = true)
	protected java.math.BigDecimal canDraw;
	/**资金调整*/
	@NotNull(message = "资金调整不可为空")
	@ApiModelProperty(value = "资金调整", required = true)
	protected java.math.BigDecimal cashAdjustValue;
	/**入金*/
	@NotNull(message = "入金不可为空")
	@ApiModelProperty(value = "入金", required = true)
	protected java.math.BigDecimal cashInValue;
	/**出金*/
	@NotNull(message = "出金不可为空")
	@ApiModelProperty(value = "出金", required = true)
	protected java.math.BigDecimal cashOutValue;
	/**质押资金*/
	@NotNull(message = "质押资金不可为空")
	@ApiModelProperty(value = "质押资金", required = true)
	protected java.math.BigDecimal cashPledged;
	/**平仓盈亏*/
	@NotNull(message = "平仓盈亏不可为空")
	@ApiModelProperty(value = "平仓盈亏", required = true)
	protected java.math.BigDecimal closeProfit;
	/**币种组号*/
	@NotNull(message = "币种组号不可为空")
	@ApiModelProperty(value = "币种组号", required = true)
	protected String currencyGroupNo;
	/**币种号*/
	@ApiModelProperty(value = "币种号")
	protected String currencyNo;
	/**交割盈亏*/
	@NotNull(message = "交割盈亏不可为空")
	@ApiModelProperty(value = "交割盈亏", required = true)
	protected java.math.BigDecimal deliveryProfit;
	/**LME贴现*/
	@NotNull(message = "LME贴现不可为空")
	@ApiModelProperty(value = "LME贴现", required = true)
	protected java.math.BigDecimal discount;
	/**当日权益*/
	@NotNull(message = "当日权益不可为空")
	@ApiModelProperty(value = "当日权益", required = true)
	protected java.math.BigDecimal equity;
	/**汇兑手续费*/
	@NotNull(message = "汇兑手续费不可为空")
	@ApiModelProperty(value = "汇兑手续费", required = true)
	protected java.math.BigDecimal exchangeFee;
	/**到期平仓盈亏*/
	@NotNull(message = "到期平仓盈亏不可为空")
	@ApiModelProperty(value = "到期平仓盈亏", required = true)
	protected java.math.BigDecimal expProfit;
	/**冻结保证金*/
	@NotNull(message = "冻结保证金不可为空")
	@ApiModelProperty(value = "冻结保证金", required = true)
	protected java.math.BigDecimal frozenDeposit;
	/**冻结手续费*/
	@NotNull(message = "冻结手续费不可为空")
	@ApiModelProperty(value = "冻结手续费", required = true)
	protected java.math.BigDecimal frozenFee;
	/**期货算法*/
	@ApiModelProperty(value = "期货算法")
	protected String futureAlg;
	/**ME持仓盈亏*/
	@NotNull(message = "ME持仓盈亏不可为空")
	@ApiModelProperty(value = "ME持仓盈亏", required = true)
	protected java.math.BigDecimal lmePositionProfit;
	/**账户市值*/
	@NotNull(message = "账户市值不可为空")
	@ApiModelProperty(value = "账户市值", required = true)
	protected java.math.BigDecimal marketEquity;
	/**期权算法*/
	@ApiModelProperty(value = "期权算法")
	protected String optionAlg;
	/**期权市值*/
	@NotNull(message = "期权市值不可为空")
	@ApiModelProperty(value = "期权市值", required = true)
	protected java.math.BigDecimal optionMarketValue;
	/**不含LME持仓盈亏*/
	@NotNull(message = "不含LME持仓盈亏不可为空")
	@ApiModelProperty(value = "不含LME持仓盈亏", required = true)
	protected java.math.BigDecimal positionProfit;
	/**上日可用*/
	@NotNull(message = "上日可用不可为空")
	@ApiModelProperty(value = "上日可用", required = true)
	protected java.math.BigDecimal preAvailable1;
	/**上日结存*/
	@NotNull(message = "上日结存不可为空")
	@ApiModelProperty(value = "上日结存", required = true)
	protected java.math.BigDecimal preBalance;
	/**上日权益*/
	@NotNull(message = "上日权益不可为空")
	@ApiModelProperty(value = "上日权益", required = true)
	protected java.math.BigDecimal preEquity;
	/**上日LME持仓平盈*/
	@NotNull(message = "上日LME持仓平盈不可为空")
	@ApiModelProperty(value = "上日LME持仓平盈", required = true)
	protected java.math.BigDecimal preLMEPositionProfit;
	/**上日市值权益*/
	@NotNull(message = "上日市值权益不可为空")
	@ApiModelProperty(value = "上日市值权益", required = true)
	protected java.math.BigDecimal preMarketEquity;
	/**权利金收取*/
	@NotNull(message = "权利金收取不可为空")
	@ApiModelProperty(value = "权利金收取", required = true)
	protected java.math.BigDecimal premiumIncome;
	/**利金支付*/
	@NotNull(message = "利金支付不可为空")
	@ApiModelProperty(value = "利金支付", required = true)
	protected java.math.BigDecimal premiumPay;
	/**上日未到期平盈*/
	@NotNull(message = "上日未到期平盈不可为空")
	@ApiModelProperty(value = "上日未到期平盈", required = true)
	protected java.math.BigDecimal preUnExpProfit;
	/**交易汇率*/
	@NotNull(message = "交易汇率不可为空")
	@ApiModelProperty(value = "交易汇率", required = true)
	protected java.math.BigDecimal tradeRate;
	/**未到期平盈*/
	@NotNull(message = "未到期平盈不可为空")
	@ApiModelProperty(value = "未到期平盈", required = true)
	protected java.math.BigDecimal unExpProfit;
	/**上手初始保证金*/
	@NotNull(message = "上手初始保证金不可为空")
	@ApiModelProperty(value = "上手初始保证金", required = true)
	protected java.math.BigDecimal upperInitalMargin;
	/**上手维持保证金*/
	@NotNull(message = "上手维持保证金不可为空")
	@ApiModelProperty(value = "上手维持保证金", required = true)
	protected java.math.BigDecimal upperMaintenanceMargin;
	/**备注*/
	@ApiModelProperty(value = "备注")
	protected String remark;
	/**创建时间*/
	@NotNull(message = "创建时间不可为空")
	@ApiModelProperty(value = "创建时间", required = true)
	protected java.util.Date createDate;
	/**修改时间*/
	@ApiModelProperty(value = "修改时间")
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

