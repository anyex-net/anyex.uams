/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.trade.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity ;
import javax.validation.constraints.NotNull;
/**
 * 成交表 实体对象
 * <p>File：RealDealEntity.java</p>
 * <p>Title: RealDealEntity</p>
 * <p>Description:RealDealEntity</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "成交表")
public class RealDealEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**账户ID*/
	@NotNull(message = "账户ID不可为空")
	@ApiModelProperty(value = "账户ID", required = true)
	protected Long accountId;
	/**委托ID*/
	@NotNull(message = "委托ID不可为空")
	@ApiModelProperty(value = "委托ID", required = true)
	protected Long entrustId;
	/**交易类型(数据字典)*/
	@NotNull(message = "交易类型(数据字典)不可为空")
	@ApiModelProperty(value = "交易类型(数据字典)", required = true)
	protected String tradeType;
	/**业务类别(数据字典)*/
	@NotNull(message = "业务类别(数据字典)不可为空")
	@ApiModelProperty(value = "业务类别(数据字典)", required = true)
	protected String businessFlag;
	/**成交方向(数据字典),同委托方向*/
	@NotNull(message = "成交方向(数据字典),同委托方向不可为空")
	@ApiModelProperty(value = "成交方向(数据字典),同委托方向", required = true)
	protected String dealDirect;
	/**成交证券ID*/
	@NotNull(message = "成交证券ID不可为空")
	@ApiModelProperty(value = "成交证券ID", required = true)
	protected Long dealStockInfoId;
	/**成交数量(数量)*/
	@NotNull(message = "成交数量(数量)不可为空")
	@ApiModelProperty(value = "成交数量(数量)", required = true)
	protected java.math.BigDecimal dealAmt;
	/**成交价格*/
	@NotNull(message = "成交价格不可为空")
	@ApiModelProperty(value = "成交价格", required = true)
	protected java.math.BigDecimal dealPrice;
	/**成交金额(金额)*/
	@NotNull(message = "成交金额(金额)不可为空")
	@ApiModelProperty(value = "成交金额(金额)", required = true)
	protected java.math.BigDecimal dealBalance;
	/**成交时间*/
	@NotNull(message = "成交时间不可为空")
	@ApiModelProperty(value = "成交时间", required = true)
	protected java.util.Date dealTime;
	/**手续费对应证券ID*/
	@NotNull(message = "手续费对应证券ID不可为空")
	@ApiModelProperty(value = "手续费对应证券ID", required = true)
	protected Long feeType;
	/**手续费*/
	@NotNull(message = "手续费不可为空")
	@ApiModelProperty(value = "手续费", required = true)
	protected java.math.BigDecimal fee;
	/**备注*/
	@ApiModelProperty(value = "备注")
	protected String remark;
	
	public Long getAccountId()
	{
		return this.accountId;
	}
	
	public void setAccountId(Long accountId)
	{
		this.accountId = accountId;
	}
	
	public Long getEntrustId()
	{
		return this.entrustId;
	}
	
	public void setEntrustId(Long entrustId)
	{
		this.entrustId = entrustId;
	}
	
	public String getTradeType()
	{
		return this.tradeType;
	}
	
	public void setTradeType(String tradeType)
	{
		this.tradeType = tradeType;
	}
	
	public String getBusinessFlag()
	{
		return this.businessFlag;
	}
	
	public void setBusinessFlag(String businessFlag)
	{
		this.businessFlag = businessFlag;
	}
	
	public String getDealDirect()
	{
		return this.dealDirect;
	}
	
	public void setDealDirect(String dealDirect)
	{
		this.dealDirect = dealDirect;
	}
	
	public Long getDealStockInfoId()
	{
		return this.dealStockInfoId;
	}
	
	public void setDealStockInfoId(Long dealStockInfoId)
	{
		this.dealStockInfoId = dealStockInfoId;
	}
	
	public java.math.BigDecimal getDealAmt()
	{
		return this.dealAmt;
	}
	
	public void setDealAmt(java.math.BigDecimal dealAmt)
	{
		this.dealAmt = dealAmt;
	}
	
	public java.math.BigDecimal getDealPrice()
	{
		return this.dealPrice;
	}
	
	public void setDealPrice(java.math.BigDecimal dealPrice)
	{
		this.dealPrice = dealPrice;
	}
	
	public java.math.BigDecimal getDealBalance()
	{
		return this.dealBalance;
	}
	
	public void setDealBalance(java.math.BigDecimal dealBalance)
	{
		this.dealBalance = dealBalance;
	}
	
	public java.util.Date getDealTime()
	{
		return this.dealTime;
	}
	
	public void setDealTime(java.util.Date dealTime)
	{
		this.dealTime = dealTime;
	}
	
	public Long getFeeType()
	{
		return this.feeType;
	}
	
	public void setFeeType(Long feeType)
	{
		this.feeType = feeType;
	}
	
	public java.math.BigDecimal getFee()
	{
		return this.fee;
	}
	
	public void setFee(java.math.BigDecimal fee)
	{
		this.fee = fee;
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

