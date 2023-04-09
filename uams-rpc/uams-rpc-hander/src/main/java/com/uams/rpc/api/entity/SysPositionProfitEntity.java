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
 * 平台期货持仓损益信息表onRtnPositionProfit 实体对象
 * <p>File：SysPositionProfit.java</p>
 * <p>Title: SysPositionProfit</p>
 * <p>Description:SysPositionProfit</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "平台期货持仓损益信息表onRtnPositionProfit")
public class SysPositionProfitEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**计算价格*/
	@NotNull(message = "计算价格不可为空")
	@ApiModelProperty(value = "计算价格", required = true)
	protected java.math.BigDecimal calculatePrice;
	/**LME持仓盈亏*/
	@NotNull(message = "LME持仓盈亏不可为空")
	@ApiModelProperty(value = "LME持仓盈亏", required = true)
	protected java.math.BigDecimal lMEPositionProfit;
	/**期权市值*/
	@NotNull(message = "期权市值不可为空")
	@ApiModelProperty(value = "期权市值", required = true)
	protected java.math.BigDecimal optionMarketValue;
	/**本地持仓号*/
	@ApiModelProperty(value = "本地持仓号")
	protected String positionNo;
	/**持仓盈亏*/
	@NotNull(message = "持仓盈亏不可为空")
	@ApiModelProperty(value = "持仓盈亏", required = true)
	protected java.math.BigDecimal positionProfit;
	/**持仓流号*/
	@NotNull(message = "持仓流号不可为空")
	@ApiModelProperty(value = "持仓流号", required = true)
	protected Integer positionStreamId;
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
	
	public java.math.BigDecimal getCalculatePrice()
	{
		return this.calculatePrice;
	}
	
	public void setCalculatePrice(java.math.BigDecimal calculatePrice)
	{
		this.calculatePrice = calculatePrice;
	}
	
	public java.math.BigDecimal getLMEPositionProfit()
	{
		return this.lMEPositionProfit;
	}
	
	public void setLMEPositionProfit(java.math.BigDecimal lMEPositionProfit)
	{
		this.lMEPositionProfit = lMEPositionProfit;
	}
	
	public java.math.BigDecimal getOptionMarketValue()
	{
		return this.optionMarketValue;
	}
	
	public void setOptionMarketValue(java.math.BigDecimal optionMarketValue)
	{
		this.optionMarketValue = optionMarketValue;
	}
	
	public String getPositionNo()
	{
		return this.positionNo;
	}
	
	public void setPositionNo(String positionNo)
	{
		this.positionNo = positionNo;
	}
	
	public java.math.BigDecimal getPositionProfit()
	{
		return this.positionProfit;
	}
	
	public void setPositionProfit(java.math.BigDecimal positionProfit)
	{
		this.positionProfit = positionProfit;
	}
	
	public Integer getPositionStreamId()
	{
		return this.positionStreamId;
	}
	
	public void setPositionStreamId(Integer positionStreamId)
	{
		this.positionStreamId = positionStreamId;
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

