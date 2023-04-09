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
 * 平台历史成交表 实体对象
 * <p>File：SysHisMatchEntity.java</p>
 * <p>Title: SysHisMatchEntity</p>
 * <p>Description:SysHisMatchEntity</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "平台历史成交表")
public class SysHisMatchEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**客户手续费*/
	@NotNull(message = "客户手续费不可为空")
	@ApiModelProperty(value = "客户手续费", required = true)
	protected java.math.BigDecimal accountFee;
	/**客户手续费币种*/
	@NotNull(message = "客户手续费币种不可为空")
	@ApiModelProperty(value = "客户手续费币种", required = true)
	protected String accountFeeCurrency;
	/**客户手续费币种组*/
	@NotNull(message = "客户手续费币种组不可为空")
	@ApiModelProperty(value = "客户手续费币种组", required = true)
	protected String accountFeeCurrencyGroup;
	/**客户资金帐号*/
	@NotNull(message = "客户资金帐号不可为空")
	@ApiModelProperty(value = "客户资金帐号", required = true)
	protected String accountNo;
	/**其他费用*/
	@NotNull(message = "其他费用不可为空")
	@ApiModelProperty(value = "其他费用", required = true)
	protected java.math.BigDecimal accountOtherFee;
	/**看涨看跌*/
	@NotNull(message = "看涨看跌不可为空")
	@ApiModelProperty(value = "看涨看跌", required = true)
	protected String callOrPutFlag;
	/**指定平仓价格*/
	@NotNull(message = "指定平仓价格不可为空")
	@ApiModelProperty(value = "指定平仓价格", required = true)
	protected java.math.BigDecimal closePrice;
	/**平仓盈亏*/
	@NotNull(message = "平仓盈亏不可为空")
	@ApiModelProperty(value = "平仓盈亏", required = true)
	protected java.math.BigDecimal closeProfit;
	/**平仓量*/
	@NotNull(message = "平仓量不可为空")
	@ApiModelProperty(value = "平仓量", required = true)
	protected Long closeQty;
	/**品种币种*/
	@NotNull(message = "品种币种不可为空")
	@ApiModelProperty(value = "品种币种", required = true)
	protected String commodityCurrency;
	/**品种币种组*/
	@NotNull(message = "品种币种组不可为空")
	@ApiModelProperty(value = "品种币种组", required = true)
	protected String commodityCurrencyGroup;
	/**品种编号*/
	@NotNull(message = "品种编号不可为空")
	@ApiModelProperty(value = "品种编号", required = true)
	protected String commodityNo;
	/**品种类型*/
	@NotNull(message = "品种类型不可为空")
	@ApiModelProperty(value = "品种类型", required = true)
	protected String commodityType;
	/**合约号*/
	@NotNull(message = "合约号不可为空")
	@ApiModelProperty(value = "合约号", required = true)
	protected String contractNo;
	/**交易所成交号*/
	@NotNull(message = "交易所成交号不可为空")
	@ApiModelProperty(value = "交易所成交号", required = true)
	protected String exchangeMatchNo;
	/**交易所编号*/
	@NotNull(message = "交易所编号不可为空")
	@ApiModelProperty(value = "交易所编号", required = true)
	protected String exchangeNo;
	/**投机保值*/
	@NotNull(message = "投机保值不可为空")
	@ApiModelProperty(value = "投机保值", required = true)
	protected String hedgeFlag;
	/**人工客户手续费标记*/
	@NotNull(message = "人工客户手续费标记不可为空")
	@ApiModelProperty(value = "人工客户手续费标记", required = true)
	protected String isManualFee;
	/**人工上手手续费标记*/
	@NotNull(message = "人工上手手续费标记不可为空")
	@ApiModelProperty(value = "人工上手手续费标记", required = true)
	protected String isUpperManualFee;
	/**组合号*/
	@NotNull(message = "组合号不可为空")
	@ApiModelProperty(value = "组合号", required = true)
	protected String matchCmbNo;
	/**成交时间*/
	@NotNull(message = "成交时间不可为空")
	@ApiModelProperty(value = "成交时间", required = true)
	protected String matchDateTime;
	/**成交序号*/
	@NotNull(message = "成交序号不可为空")
	@ApiModelProperty(value = "成交序号", required = true)
	protected String matchNo;
	/**成交价*/
	@NotNull(message = "成交价不可为空")
	@ApiModelProperty(value = "成交价", required = true)
	protected java.math.BigDecimal matchPrice;
	/**成交量*/
	@NotNull(message = "成交量不可为空")
	@ApiModelProperty(value = "成交量", required = true)
	protected Long matchQty;
	/**买入卖出*/
	@NotNull(message = "买入卖出不可为空")
	@ApiModelProperty(value = "买入卖出", required = true)
	protected String matchSide;
	/**委托来源*/
	@NotNull(message = "委托来源不可为空")
	@ApiModelProperty(value = "委托来源", required = true)
	protected String matchSource;
	/**成交流水号*/
	@NotNull(message = "成交流水号不可为空")
	@ApiModelProperty(value = "成交流水号", required = true)
	protected Long matchStreamID;
	/**上手流水号*/
	@NotNull(message = "上手流水号不可为空")
	@ApiModelProperty(value = "上手流水号", required = true)
	protected Long matchUpperStreamID;
	/**操作时间*/
	@NotNull(message = "操作时间不可为空")
	@ApiModelProperty(value = "操作时间", required = true)
	protected String operateTime;
	/**操作员*/
	@NotNull(message = "操作员不可为空")
	@ApiModelProperty(value = "操作员", required = true)
	protected String operatorNo;
	/**委托号*/
	@NotNull(message = "委托号不可为空")
	@ApiModelProperty(value = "委托号", required = true)
	protected String orderNo;
	/**开平标志*/
	@NotNull(message = "开平标志不可为空")
	@ApiModelProperty(value = "开平标志", required = true)
	protected String positionEffect;
	/**权利金收入*/
	@NotNull(message = "权利金收入不可为空")
	@ApiModelProperty(value = "权利金收入", required = true)
	protected java.math.BigDecimal premiumIncome;
	/**权利金支出*/
	@NotNull(message = "权利金支出不可为空")
	@ApiModelProperty(value = "权利金支出", required = true)
	protected java.math.BigDecimal premiumPay;
	/**结算日期*/
	@NotNull(message = "结算日期不可为空")
	@ApiModelProperty(value = "结算日期", required = true)
	protected String settleDate;
	/**结算分组*/
	@NotNull(message = "结算分组不可为空")
	@ApiModelProperty(value = "结算分组", required = true)
	protected String settleGroupNo;
	/**执行价*/
	@NotNull(message = "执行价不可为空")
	@ApiModelProperty(value = "执行价", required = true)
	protected String strikePrice;
	/**交易日期*/
	@NotNull(message = "交易日期不可为空")
	@ApiModelProperty(value = "交易日期", required = true)
	protected String tradeDate;
	/**成交金额*/
	@NotNull(message = "成交金额不可为空")
	@ApiModelProperty(value = "成交金额", required = true)
	protected java.math.BigDecimal turnover;
	/**上手手续费*/
	@NotNull(message = "上手手续费不可为空")
	@ApiModelProperty(value = "上手手续费", required = true)
	protected java.math.BigDecimal upperFee;
	/**上手手续费币种*/
	@NotNull(message = "上手手续费币种不可为空")
	@ApiModelProperty(value = "上手手续费币种", required = true)
	protected String upperFeeCurrency;
	/**上手手续费币种组*/
	@NotNull(message = "上手手续费币种组不可为空")
	@ApiModelProperty(value = "上手手续费币种组", required = true)
	protected String upperFeeCurrencyGroup;
	/**上手成交时间*/
	@NotNull(message = "上手成交时间不可为空")
	@ApiModelProperty(value = "上手成交时间", required = true)
	protected String upperMatchDateTime;
	/**上手号*/
	@NotNull(message = "上手号不可为空")
	@ApiModelProperty(value = "上手号", required = true)
	protected String upperNo;
	/**上手其他手续费*/
	@NotNull(message = "上手其他手续费不可为空")
	@ApiModelProperty(value = "上手其他手续费", required = true)
	protected java.math.BigDecimal upperOtherFee;
	/**备注*/
	@ApiModelProperty(value = "备注")
	protected String remark;
	/**添加时间*/
	@NotNull(message = "添加时间不可为空")
	@ApiModelProperty(value = "添加时间", required = true)
	protected java.util.Date createDate;
	/**更新时间*/
	@ApiModelProperty(value = "更新时间")
	protected java.util.Date updateDate;
	
	public java.math.BigDecimal getAccountFee()
	{
		return this.accountFee;
	}
	
	public void setAccountFee(java.math.BigDecimal accountFee)
	{
		this.accountFee = accountFee;
	}
	
	public String getAccountFeeCurrency()
	{
		return this.accountFeeCurrency;
	}
	
	public void setAccountFeeCurrency(String accountFeeCurrency)
	{
		this.accountFeeCurrency = accountFeeCurrency;
	}
	
	public String getAccountFeeCurrencyGroup()
	{
		return this.accountFeeCurrencyGroup;
	}
	
	public void setAccountFeeCurrencyGroup(String accountFeeCurrencyGroup)
	{
		this.accountFeeCurrencyGroup = accountFeeCurrencyGroup;
	}
	
	public String getAccountNo()
	{
		return this.accountNo;
	}
	
	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	
	public java.math.BigDecimal getAccountOtherFee()
	{
		return this.accountOtherFee;
	}
	
	public void setAccountOtherFee(java.math.BigDecimal accountOtherFee)
	{
		this.accountOtherFee = accountOtherFee;
	}
	
	public String getCallOrPutFlag()
	{
		return this.callOrPutFlag;
	}
	
	public void setCallOrPutFlag(String callOrPutFlag)
	{
		this.callOrPutFlag = callOrPutFlag;
	}
	
	public java.math.BigDecimal getClosePrice()
	{
		return this.closePrice;
	}
	
	public void setClosePrice(java.math.BigDecimal closePrice)
	{
		this.closePrice = closePrice;
	}
	
	public java.math.BigDecimal getCloseProfit()
	{
		return this.closeProfit;
	}
	
	public void setCloseProfit(java.math.BigDecimal closeProfit)
	{
		this.closeProfit = closeProfit;
	}
	
	public Long getCloseQty()
	{
		return this.closeQty;
	}
	
	public void setCloseQty(Long closeQty)
	{
		this.closeQty = closeQty;
	}
	
	public String getCommodityCurrency()
	{
		return this.commodityCurrency;
	}
	
	public void setCommodityCurrency(String commodityCurrency)
	{
		this.commodityCurrency = commodityCurrency;
	}
	
	public String getCommodityCurrencyGroup()
	{
		return this.commodityCurrencyGroup;
	}
	
	public void setCommodityCurrencyGroup(String commodityCurrencyGroup)
	{
		this.commodityCurrencyGroup = commodityCurrencyGroup;
	}
	
	public String getCommodityNo()
	{
		return this.commodityNo;
	}
	
	public void setCommodityNo(String commodityNo)
	{
		this.commodityNo = commodityNo;
	}
	
	public String getCommodityType()
	{
		return this.commodityType;
	}
	
	public void setCommodityType(String commodityType)
	{
		this.commodityType = commodityType;
	}
	
	public String getContractNo()
	{
		return this.contractNo;
	}
	
	public void setContractNo(String contractNo)
	{
		this.contractNo = contractNo;
	}
	
	public String getExchangeMatchNo()
	{
		return this.exchangeMatchNo;
	}
	
	public void setExchangeMatchNo(String exchangeMatchNo)
	{
		this.exchangeMatchNo = exchangeMatchNo;
	}
	
	public String getExchangeNo()
	{
		return this.exchangeNo;
	}
	
	public void setExchangeNo(String exchangeNo)
	{
		this.exchangeNo = exchangeNo;
	}
	
	public String getHedgeFlag()
	{
		return this.hedgeFlag;
	}
	
	public void setHedgeFlag(String hedgeFlag)
	{
		this.hedgeFlag = hedgeFlag;
	}
	
	public String getIsManualFee()
	{
		return this.isManualFee;
	}
	
	public void setIsManualFee(String isManualFee)
	{
		this.isManualFee = isManualFee;
	}
	
	public String getIsUpperManualFee()
	{
		return this.isUpperManualFee;
	}
	
	public void setIsUpperManualFee(String isUpperManualFee)
	{
		this.isUpperManualFee = isUpperManualFee;
	}
	
	public String getMatchCmbNo()
	{
		return this.matchCmbNo;
	}
	
	public void setMatchCmbNo(String matchCmbNo)
	{
		this.matchCmbNo = matchCmbNo;
	}
	
	public String getMatchDateTime()
	{
		return this.matchDateTime;
	}
	
	public void setMatchDateTime(String matchDateTime)
	{
		this.matchDateTime = matchDateTime;
	}
	
	public String getMatchNo()
	{
		return this.matchNo;
	}
	
	public void setMatchNo(String matchNo)
	{
		this.matchNo = matchNo;
	}
	
	public java.math.BigDecimal getMatchPrice()
	{
		return this.matchPrice;
	}
	
	public void setMatchPrice(java.math.BigDecimal matchPrice)
	{
		this.matchPrice = matchPrice;
	}
	
	public Long getMatchQty()
	{
		return this.matchQty;
	}
	
	public void setMatchQty(Long matchQty)
	{
		this.matchQty = matchQty;
	}
	
	public String getMatchSide()
	{
		return this.matchSide;
	}
	
	public void setMatchSide(String matchSide)
	{
		this.matchSide = matchSide;
	}
	
	public String getMatchSource()
	{
		return this.matchSource;
	}
	
	public void setMatchSource(String matchSource)
	{
		this.matchSource = matchSource;
	}
	
	public Long getMatchStreamID()
	{
		return this.matchStreamID;
	}
	
	public void setMatchStreamID(Long matchStreamID)
	{
		this.matchStreamID = matchStreamID;
	}
	
	public Long getMatchUpperStreamID()
	{
		return this.matchUpperStreamID;
	}
	
	public void setMatchUpperStreamID(Long matchUpperStreamID)
	{
		this.matchUpperStreamID = matchUpperStreamID;
	}
	
	public String getOperateTime()
	{
		return this.operateTime;
	}
	
	public void setOperateTime(String operateTime)
	{
		this.operateTime = operateTime;
	}
	
	public String getOperatorNo()
	{
		return this.operatorNo;
	}
	
	public void setOperatorNo(String operatorNo)
	{
		this.operatorNo = operatorNo;
	}
	
	public String getOrderNo()
	{
		return this.orderNo;
	}
	
	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}
	
	public String getPositionEffect()
	{
		return this.positionEffect;
	}
	
	public void setPositionEffect(String positionEffect)
	{
		this.positionEffect = positionEffect;
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
	
	public String getSettleDate()
	{
		return this.settleDate;
	}
	
	public void setSettleDate(String settleDate)
	{
		this.settleDate = settleDate;
	}
	
	public String getSettleGroupNo()
	{
		return this.settleGroupNo;
	}
	
	public void setSettleGroupNo(String settleGroupNo)
	{
		this.settleGroupNo = settleGroupNo;
	}
	
	public String getStrikePrice()
	{
		return this.strikePrice;
	}
	
	public void setStrikePrice(String strikePrice)
	{
		this.strikePrice = strikePrice;
	}
	
	public String getTradeDate()
	{
		return this.tradeDate;
	}
	
	public void setTradeDate(String tradeDate)
	{
		this.tradeDate = tradeDate;
	}
	
	public java.math.BigDecimal getTurnover()
	{
		return this.turnover;
	}
	
	public void setTurnover(java.math.BigDecimal turnover)
	{
		this.turnover = turnover;
	}
	
	public java.math.BigDecimal getUpperFee()
	{
		return this.upperFee;
	}
	
	public void setUpperFee(java.math.BigDecimal upperFee)
	{
		this.upperFee = upperFee;
	}
	
	public String getUpperFeeCurrency()
	{
		return this.upperFeeCurrency;
	}
	
	public void setUpperFeeCurrency(String upperFeeCurrency)
	{
		this.upperFeeCurrency = upperFeeCurrency;
	}
	
	public String getUpperFeeCurrencyGroup()
	{
		return this.upperFeeCurrencyGroup;
	}
	
	public void setUpperFeeCurrencyGroup(String upperFeeCurrencyGroup)
	{
		this.upperFeeCurrencyGroup = upperFeeCurrencyGroup;
	}
	
	public String getUpperMatchDateTime()
	{
		return this.upperMatchDateTime;
	}
	
	public void setUpperMatchDateTime(String upperMatchDateTime)
	{
		this.upperMatchDateTime = upperMatchDateTime;
	}
	
	public String getUpperNo()
	{
		return this.upperNo;
	}
	
	public void setUpperNo(String upperNo)
	{
		this.upperNo = upperNo;
	}
	
	public java.math.BigDecimal getUpperOtherFee()
	{
		return this.upperOtherFee;
	}
	
	public void setUpperOtherFee(java.math.BigDecimal upperOtherFee)
	{
		this.upperOtherFee = upperOtherFee;
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

