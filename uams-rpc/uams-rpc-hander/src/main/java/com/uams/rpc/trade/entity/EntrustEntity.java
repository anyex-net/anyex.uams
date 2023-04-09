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
 * 委托表 实体对象
 * <p>File：EntrustEntity.java</p>
 * <p>Title: EntrustEntity</p>
 * <p>Description:EntrustEntity</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "委托表")
public class EntrustEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**账户ID*/
	@NotNull(message = "账户ID不可为空")
	@ApiModelProperty(value = "账户ID", required = true)
	protected Long accountId;
	/**委托时间*/
	@NotNull(message = "委托时间不可为空")
	@ApiModelProperty(value = "委托时间", required = true)
	protected java.util.Date entrustTime;
	/**委托来源(web,app,api,agent)*/
	@NotNull(message = "委托来源(web,app,api,agent)不可为空")
	@ApiModelProperty(value = "委托来源(web,app,api,agent)", required = true)
	protected String entrustSource;
	/**业务类别(数据字典)*/
	@NotNull(message = "业务类别(数据字典)不可为空")
	@ApiModelProperty(value = "业务类别(数据字典)", required = true)
	protected String businessFlag;
	/**交易类型(数据字典)*/
	@NotNull(message = "交易类型(数据字典)不可为空")
	@ApiModelProperty(value = "交易类型(数据字典)", required = true)
	protected String tradeType;
	/**委托类型(限价limitPrice、市价marketPrice)*/
	@NotNull(message = "委托类型(限价limitPrice、市价marketPrice)不可为空")
	@ApiModelProperty(value = "委托类型(限价limitPrice、市价marketPrice)", required = true)
	protected String entrustType;
	/**委托方向(数据字典)*/
	@NotNull(message = "委托方向(数据字典)不可为空")
	@ApiModelProperty(value = "委托方向(数据字典)", required = true)
	protected String entrustDirect;
	/**委托证券ID*/
	@NotNull(message = "委托证券ID不可为空")
	@ApiModelProperty(value = "委托证券ID", required = true)
	protected Long entrustStockinfoId;
	/**委托数量(对于买入就是委托金额)*/
	@NotNull(message = "委托数量(对于买入就是委托金额)不可为空")
	@ApiModelProperty(value = "委托数量(对于买入就是委托金额)", required = true)
	protected java.math.BigDecimal entrustAmt;
	/**委托价格*/
	@NotNull(message = "委托价格不可为空")
	@ApiModelProperty(value = "委托价格", required = true)
	protected java.math.BigDecimal entrustPrice;
	/**委托备注*/
	@ApiModelProperty(value = "委托备注")
	protected String entrustRemark;
	/**委托账户类型(0用户委托、1平台委托)*/
	@NotNull(message = "委托账户类型(0用户委托、1平台委托)不可为空")
	@ApiModelProperty(value = "委托账户类型(0用户委托、1平台委托)", required = true)
	protected Boolean entrustAccountType;
	/**手续费类型*/
	@NotNull(message = "手续费类型不可为空")
	@ApiModelProperty(value = "手续费类型", required = true)
	protected Long feeType;
	/**手续费率*/
	@NotNull(message = "手续费率不可为空")
	@ApiModelProperty(value = "手续费率", required = true)
	protected java.math.BigDecimal feeRate;
	/**成交数量*/
	@NotNull(message = "成交数量不可为空")
	@ApiModelProperty(value = "成交数量", required = true)
	protected java.math.BigDecimal dealAmt;
	/**成交金额*/
	@NotNull(message = "成交金额不可为空")
	@ApiModelProperty(value = "成交金额", required = true)
	protected java.math.BigDecimal dealBalance;
	/**成交手续费*/
	@NotNull(message = "成交手续费不可为空")
	@ApiModelProperty(value = "成交手续费", required = true)
	protected java.math.BigDecimal dealFee;
	/**状态(初始化init、未成交noDeal、部分成交partialDeal、全部成交allDeal、已撤单withDrawed、异常委托abnormal)*/
	@NotNull(message = "状态(初始化init、未成交noDeal、部分成交partialDeal、全部成交allDeal、已撤单withDrawed、异常委托abnormal)不可为空")
	@ApiModelProperty(value = "状态(初始化init、未成交noDeal、部分成交partialDeal、全部成交allDeal、已撤单withDrawed、异常委托abnormal)", required = true)
	protected String status;
	/**最后更新时间*/
	@NotNull(message = "最后更新时间不可为空")
	@ApiModelProperty(value = "最后更新时间", required = true)
	protected java.util.Date updateTime;
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
	
	public java.util.Date getEntrustTime()
	{
		return this.entrustTime;
	}
	
	public void setEntrustTime(java.util.Date entrustTime)
	{
		this.entrustTime = entrustTime;
	}
	
	public String getEntrustSource()
	{
		return this.entrustSource;
	}
	
	public void setEntrustSource(String entrustSource)
	{
		this.entrustSource = entrustSource;
	}
	
	public String getBusinessFlag()
	{
		return this.businessFlag;
	}
	
	public void setBusinessFlag(String businessFlag)
	{
		this.businessFlag = businessFlag;
	}
	
	public String getTradeType()
	{
		return this.tradeType;
	}
	
	public void setTradeType(String tradeType)
	{
		this.tradeType = tradeType;
	}
	
	public String getEntrustType()
	{
		return this.entrustType;
	}
	
	public void setEntrustType(String entrustType)
	{
		this.entrustType = entrustType;
	}
	
	public String getEntrustDirect()
	{
		return this.entrustDirect;
	}
	
	public void setEntrustDirect(String entrustDirect)
	{
		this.entrustDirect = entrustDirect;
	}
	
	public Long getEntrustStockinfoId()
	{
		return this.entrustStockinfoId;
	}
	
	public void setEntrustStockinfoId(Long entrustStockinfoId)
	{
		this.entrustStockinfoId = entrustStockinfoId;
	}
	
	public java.math.BigDecimal getEntrustAmt()
	{
		return this.entrustAmt;
	}
	
	public void setEntrustAmt(java.math.BigDecimal entrustAmt)
	{
		this.entrustAmt = entrustAmt;
	}
	
	public java.math.BigDecimal getEntrustPrice()
	{
		return this.entrustPrice;
	}
	
	public void setEntrustPrice(java.math.BigDecimal entrustPrice)
	{
		this.entrustPrice = entrustPrice;
	}
	
	public String getEntrustRemark()
	{
		return this.entrustRemark;
	}
	
	public void setEntrustRemark(String entrustRemark)
	{
		this.entrustRemark = entrustRemark;
	}
	
	public Boolean getEntrustAccountType()
	{
		return this.entrustAccountType;
	}
	
	public void setEntrustAccountType(Boolean entrustAccountType)
	{
		this.entrustAccountType = entrustAccountType;
	}
	
	public Long getFeeType()
	{
		return this.feeType;
	}
	
	public void setFeeType(Long feeType)
	{
		this.feeType = feeType;
	}
	
	public java.math.BigDecimal getFeeRate()
	{
		return this.feeRate;
	}
	
	public void setFeeRate(java.math.BigDecimal feeRate)
	{
		this.feeRate = feeRate;
	}
	
	public java.math.BigDecimal getDealAmt()
	{
		return this.dealAmt;
	}
	
	public void setDealAmt(java.math.BigDecimal dealAmt)
	{
		this.dealAmt = dealAmt;
	}
	
	public java.math.BigDecimal getDealBalance()
	{
		return this.dealBalance;
	}
	
	public void setDealBalance(java.math.BigDecimal dealBalance)
	{
		this.dealBalance = dealBalance;
	}
	
	public java.math.BigDecimal getDealFee()
	{
		return this.dealFee;
	}
	
	public void setDealFee(java.math.BigDecimal dealFee)
	{
		this.dealFee = dealFee;
	}
	
	public String getStatus()
	{
		return this.status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public java.util.Date getUpdateTime()
	{
		return this.updateTime;
	}
	
	public void setUpdateTime(java.util.Date updateTime)
	{
		this.updateTime = updateTime;
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

