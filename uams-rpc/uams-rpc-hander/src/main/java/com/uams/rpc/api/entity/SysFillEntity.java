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
 * 平台成交信息表 实体对象
 * <p>File：SysFillEntity.java</p>
 * <p>Title: SysFillEntity</p>
 * <p>Description:SysFillEntity</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "平台成交信息表")
public class SysFillEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**客户资金帐号*/
	@NotNull(message = "客户资金帐号不可为空")
	@ApiModelProperty(value = "客户资金帐号", required = true)
	protected String accountNo;
	/**看涨看跌*/
	@NotNull(message = "看涨看跌不可为空")
	@ApiModelProperty(value = "看涨看跌", required = true)
	protected String callOrPutFlag;
	/**指定价格平仓*/
	@NotNull(message = "指定价格平仓不可为空")
	@ApiModelProperty(value = "指定价格平仓", required = true)
	protected java.math.BigDecimal closePrositionPrice;
	/**品种编号*/
	@NotNull(message = "品种编号不可为空")
	@ApiModelProperty(value = "品种编号", required = true)
	protected String commodityNo;
	/**品种类型*/
	@NotNull(message = "品种类型不可为空")
	@ApiModelProperty(value = "品种类型", required = true)
	protected String commodityType;
	/**合约1*/
	@NotNull(message = "合约1不可为空")
	@ApiModelProperty(value = "合约1", required = true)
	protected String contractNo;
	/**交易所编号*/
	@NotNull(message = "交易所编号不可为空")
	@ApiModelProperty(value = "交易所编号", required = true)
	protected String exchangeNo;
	/**手续费币种*/
	@NotNull(message = "手续费币种不可为空")
	@ApiModelProperty(value = "手续费币种", required = true)
	protected String feeCurrency;
	/**手续费币种组*/
	@NotNull(message = "手续费币种组不可为空")
	@ApiModelProperty(value = "手续费币种组", required = true)
	protected String feeCurrencyGroup;
	/**手续费*/
	@NotNull(message = "手续费不可为空")
	@ApiModelProperty(value = "手续费", required = true)
	protected java.math.BigDecimal feeValue;
	/**是否为T+1单*/
	@NotNull(message = "是否为T+1单不可为空")
	@ApiModelProperty(value = "是否为T+1单", required = true)
	protected String isAddOne;
	/**委托成交删除标*/
	@NotNull(message = "委托成交删除标不可为空")
	@ApiModelProperty(value = "委托成交删除标", required = true)
	protected String isDeleted;
	/**人工客户手续费标记*/
	@NotNull(message = "人工客户手续费标记不可为空")
	@ApiModelProperty(value = "人工客户手续费标记", required = true)
	protected String isManualFee;
	/**成交时间*/
	@ApiModelProperty(value = "成交时间")
	protected java.util.Date matchDateTime;
	/**本地成交号*/
	@NotNull(message = "本地成交号不可为空")
	@ApiModelProperty(value = "本地成交号", required = true)
	protected String matchNo;
	/**成交价*/
	@NotNull(message = "成交价不可为空")
	@ApiModelProperty(value = "成交价", required = true)
	protected java.math.BigDecimal matchPrice;
	/**成交量*/
	@NotNull(message = "成交量不可为空")
	@ApiModelProperty(value = "成交量", required = true)
	protected Integer matchQty;
	/**买入卖出*/
	@NotNull(message = "买入卖出不可为空")
	@ApiModelProperty(value = "买入卖出", required = true)
	protected String matchSide;
	/**委托来源*/
	@NotNull(message = "委托来源不可为空")
	@ApiModelProperty(value = "委托来源", required = true)
	protected String matchSource;
	/**委托编码*/
	@NotNull(message = "委托编码不可为空")
	@ApiModelProperty(value = "委托编码", required = true)
	protected String orderNo;
	/**系统号*/
	@NotNull(message = "系统号不可为空")
	@ApiModelProperty(value = "系统号", required = true)
	protected String orderSystemNo;
	/**开平标志1*/
	@NotNull(message = "开平标志1不可为空")
	@ApiModelProperty(value = "开平标志1", required = true)
	protected String positionEffect;
	/**服务器标识*/
	@NotNull(message = "服务器标识不可为空")
	@ApiModelProperty(value = "服务器标识", required = true)
	protected String serverFlag;
	/**执行价格*/
	@NotNull(message = "执行价格不可为空")
	@ApiModelProperty(value = "执行价格", required = true)
	protected String strikePrice;
	/**上手成交时间*/
	@ApiModelProperty(value = "上手成交时间")
	protected java.util.Date upperMatchDateTime;
	/**上手成交号*/
	@NotNull(message = "上手成交号不可为空")
	@ApiModelProperty(value = "上手成交号", required = true)
	protected String upperMatchNo;
	/**上手号*/
	@NotNull(message = "上手号不可为空")
	@ApiModelProperty(value = "上手号", required = true)
	protected String upperNo;
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
	
	public String getAccountNo()
	{
		return this.accountNo;
	}
	
	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	
	public String getCallOrPutFlag()
	{
		return this.callOrPutFlag;
	}
	
	public void setCallOrPutFlag(String callOrPutFlag)
	{
		this.callOrPutFlag = callOrPutFlag;
	}
	
	public java.math.BigDecimal getClosePrositionPrice()
	{
		return this.closePrositionPrice;
	}
	
	public void setClosePrositionPrice(java.math.BigDecimal closePrositionPrice)
	{
		this.closePrositionPrice = closePrositionPrice;
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
	
	public String getFeeCurrency()
	{
		return this.feeCurrency;
	}
	
	public void setFeeCurrency(String feeCurrency)
	{
		this.feeCurrency = feeCurrency;
	}
	
	public String getFeeCurrencyGroup()
	{
		return this.feeCurrencyGroup;
	}
	
	public void setFeeCurrencyGroup(String feeCurrencyGroup)
	{
		this.feeCurrencyGroup = feeCurrencyGroup;
	}
	
	public java.math.BigDecimal getFeeValue()
	{
		return this.feeValue;
	}
	
	public void setFeeValue(java.math.BigDecimal feeValue)
	{
		this.feeValue = feeValue;
	}
	
	public String getIsAddOne()
	{
		return this.isAddOne;
	}
	
	public void setIsAddOne(String isAddOne)
	{
		this.isAddOne = isAddOne;
	}
	
	public String getIsDeleted()
	{
		return this.isDeleted;
	}
	
	public void setIsDeleted(String isDeleted)
	{
		this.isDeleted = isDeleted;
	}
	
	public String getIsManualFee()
	{
		return this.isManualFee;
	}
	
	public void setIsManualFee(String isManualFee)
	{
		this.isManualFee = isManualFee;
	}
	
	public java.util.Date getMatchDateTime()
	{
		return this.matchDateTime;
	}
	
	public void setMatchDateTime(java.util.Date matchDateTime)
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
	
	public Integer getMatchQty()
	{
		return this.matchQty;
	}
	
	public void setMatchQty(Integer matchQty)
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
	
	public String getOrderNo()
	{
		return this.orderNo;
	}
	
	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}
	
	public String getOrderSystemNo()
	{
		return this.orderSystemNo;
	}
	
	public void setOrderSystemNo(String orderSystemNo)
	{
		this.orderSystemNo = orderSystemNo;
	}
	
	public String getPositionEffect()
	{
		return this.positionEffect;
	}
	
	public void setPositionEffect(String positionEffect)
	{
		this.positionEffect = positionEffect;
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
	
	public java.util.Date getUpperMatchDateTime()
	{
		return this.upperMatchDateTime;
	}
	
	public void setUpperMatchDateTime(java.util.Date upperMatchDateTime)
	{
		this.upperMatchDateTime = upperMatchDateTime;
	}
	
	public String getUpperMatchNo()
	{
		return this.upperMatchNo;
	}
	
	public void setUpperMatchNo(String upperMatchNo)
	{
		this.upperMatchNo = upperMatchNo;
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

