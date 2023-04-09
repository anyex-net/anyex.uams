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
 * 平台期货持仓信息表onRspQryPosition 实体对象
 * <p>File：SysPosition.java</p>
 * <p>Title: SysPosition</p>
 * <p>Description:SysPosition</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "平台期货持仓信息表onRspQryPosition")
public class SysPositionEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**客户初始保证金*/
	@NotNull(message = "客户初始保证金不可为空")
	@ApiModelProperty(value = "客户初始保证金", required = true)
	protected java.math.BigDecimal accountInitialMargin;
	/**客户维持保证金*/
	@NotNull(message = "客户维持保证金不可为空")
	@ApiModelProperty(value = "客户维持保证金", required = true)
	protected java.math.BigDecimal accountMaintenanceMargin;
	/**客户资金账号*/
	@ApiModelProperty(value = "客户资金账号")
	protected String accountNo;
	/**当前计算价格*/
	@NotNull(message = "当前计算价格不可为空")
	@ApiModelProperty(value = "当前计算价格", required = true)
	protected java.math.BigDecimal calculatePrice;
	/**看张看跌*/
	@NotNull(message = "看张看跌不可为空")
	@ApiModelProperty(value = "看张看跌", required = true)
	protected String callOrPutFlag;
	/**品种币种*/
	@ApiModelProperty(value = "品种币种")
	protected String commodityCurrency;
	/**品种币种组*/
	@ApiModelProperty(value = "品种币种组")
	protected String commodityCurrencyGroup;
	/**品种编码*/
	@ApiModelProperty(value = "品种编码")
	protected String commodityNo;
	/**品种类型*/
	@NotNull(message = "品种类型不可为空")
	@ApiModelProperty(value = "品种类型", required = true)
	protected String commodityType;
	/**合约1*/
	@ApiModelProperty(value = "合约1")
	protected String contractNo;
	/**交易所编号*/
	@ApiModelProperty(value = "交易所编号")
	protected String exchangeNo;
	/**投机保值*/
	@NotNull(message = "投机保值不可为空")
	@ApiModelProperty(value = "投机保值", required = true)
	protected String hedgeFlag;
	/**LME持仓盈亏*/
	@NotNull(message = "LME持仓盈亏不可为空")
	@ApiModelProperty(value = "LME持仓盈亏", required = true)
	protected java.math.BigDecimal lMEPositionProfit;
	/**本地成交号*/
	@ApiModelProperty(value = "本地成交号")
	protected String matchNo;
	/**买入卖出*/
	@NotNull(message = "买入卖出不可为空")
	@ApiModelProperty(value = "买入卖出", required = true)
	protected String matchSide;
	/**期权市值*/
	@NotNull(message = "期权市值不可为空")
	@ApiModelProperty(value = "期权市值", required = true)
	protected java.math.BigDecimal optionMarketValue;
	/**委托编码*/
	@ApiModelProperty(value = "委托编码")
	protected String orderNo;
	/**本地持仓号*/
	@ApiModelProperty(value = "本地持仓号")
	protected String positionNo;
	/**持仓价*/
	@NotNull(message = "持仓价不可为空")
	@ApiModelProperty(value = "持仓价", required = true)
	protected java.math.BigDecimal positionPrice;
	/**持仓盈亏*/
	@NotNull(message = "持仓盈亏不可为空")
	@ApiModelProperty(value = "持仓盈亏", required = true)
	protected java.math.BigDecimal positionProfit;
	/**持仓量*/
	@NotNull(message = "持仓量不可为空")
	@ApiModelProperty(value = "持仓量", required = true)
	protected Long positionQty;
	/**持仓流号*/
	@NotNull(message = "持仓流号不可为空")
	@ApiModelProperty(value = "持仓流号", required = true)
	protected Integer positionStreamId;
	/**服务器标识*/
	@NotNull(message = "服务器标识不可为空")
	@ApiModelProperty(value = "服务器标识", required = true)
	protected String serverFlag;
	/**执行价格*/
	@ApiModelProperty(value = "执行价格")
	protected String strikePrice;
	/**上手初始保证金*/
	@NotNull(message = "上手初始保证金不可为空")
	@ApiModelProperty(value = "上手初始保证金", required = true)
	protected java.math.BigDecimal upperInitialMargin;
	/**上手维持保证金*/
	@NotNull(message = "上手维持保证金不可为空")
	@ApiModelProperty(value = "上手维持保证金", required = true)
	protected java.math.BigDecimal upperMaintenanceMargin;
	/**上手号*/
	@ApiModelProperty(value = "上手号")
	protected String upperNo;
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
	
	public java.math.BigDecimal getAccountInitialMargin()
	{
		return this.accountInitialMargin;
	}
	
	public void setAccountInitialMargin(java.math.BigDecimal accountInitialMargin)
	{
		this.accountInitialMargin = accountInitialMargin;
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
	
	public java.math.BigDecimal getCalculatePrice()
	{
		return this.calculatePrice;
	}
	
	public void setCalculatePrice(java.math.BigDecimal calculatePrice)
	{
		this.calculatePrice = calculatePrice;
	}
	
	public String getCallOrPutFlag()
	{
		return this.callOrPutFlag;
	}
	
	public void setCallOrPutFlag(String callOrPutFlag)
	{
		this.callOrPutFlag = callOrPutFlag;
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
	
	public java.math.BigDecimal getLMEPositionProfit()
	{
		return this.lMEPositionProfit;
	}
	
	public void setLMEPositionProfit(java.math.BigDecimal lMEPositionProfit)
	{
		this.lMEPositionProfit = lMEPositionProfit;
	}
	
	public String getMatchNo()
	{
		return this.matchNo;
	}
	
	public void setMatchNo(String matchNo)
	{
		this.matchNo = matchNo;
	}
	
	public String getMatchSide()
	{
		return this.matchSide;
	}
	
	public void setMatchSide(String matchSide)
	{
		this.matchSide = matchSide;
	}
	
	public java.math.BigDecimal getOptionMarketValue()
	{
		return this.optionMarketValue;
	}
	
	public void setOptionMarketValue(java.math.BigDecimal optionMarketValue)
	{
		this.optionMarketValue = optionMarketValue;
	}
	
	public String getOrderNo()
	{
		return this.orderNo;
	}
	
	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}
	
	public String getPositionNo()
	{
		return this.positionNo;
	}
	
	public void setPositionNo(String positionNo)
	{
		this.positionNo = positionNo;
	}
	
	public java.math.BigDecimal getPositionPrice()
	{
		return this.positionPrice;
	}
	
	public void setPositionPrice(java.math.BigDecimal positionPrice)
	{
		this.positionPrice = positionPrice;
	}
	
	public java.math.BigDecimal getPositionProfit()
	{
		return this.positionProfit;
	}
	
	public void setPositionProfit(java.math.BigDecimal positionProfit)
	{
		this.positionProfit = positionProfit;
	}
	
	public Long getPositionQty()
	{
		return this.positionQty;
	}
	
	public void setPositionQty(Long positionQty)
	{
		this.positionQty = positionQty;
	}
	
	public Integer getPositionStreamId()
	{
		return this.positionStreamId;
	}
	
	public void setPositionStreamId(Integer positionStreamId)
	{
		this.positionStreamId = positionStreamId;
	}
	
	public String getServerFlag()
	{
		return this.serverFlag;
	}
	
	public void setServerFlag(String serverFlag)
	{
		this.serverFlag = serverFlag;
	}
	
	public String getStrikePrice()
	{
		return this.strikePrice;
	}
	
	public void setStrikePrice(String strikePrice)
	{
		this.strikePrice = strikePrice;
	}
	
	public java.math.BigDecimal getUpperInitialMargin()
	{
		return this.upperInitialMargin;
	}
	
	public void setUpperInitialMargin(java.math.BigDecimal upperInitialMargin)
	{
		this.upperInitialMargin = upperInitialMargin;
	}
	
	public java.math.BigDecimal getUpperMaintenanceMargin()
	{
		return this.upperMaintenanceMargin;
	}
	
	public void setUpperMaintenanceMargin(java.math.BigDecimal upperMaintenanceMargin)
	{
		this.upperMaintenanceMargin = upperMaintenanceMargin;
	}
	
	public String getUpperNo()
	{
		return this.upperNo;
	}
	
	public void setUpperNo(String upperNo)
	{
		this.upperNo = upperNo;
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

