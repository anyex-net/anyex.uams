/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity ;
import javax.validation.constraints.NotNull;
/**
 * 代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表) 实体对象
 * <p>File：StockHolder.java</p>
 * <p>Title: StockHolder</p>
 * <p>Description:StockHolder</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表)")
public class StockHolderEntity extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	/**券商期货ID(brokerInfo表)*/
	@NotNull(message = "券商期货ID(brokerInfo表)不可为空")
	@ApiModelProperty(value = "券商期货ID(brokerInfo表)", required = true)
	private Long brokerId;
	/**交易市场ID*/
	@NotNull(message = "股东代码名称不可为空")
	@ApiModelProperty(value = "股东代码名称", required = true)
	private String stockHolderName;
	/**交易市场ID*/
	@NotNull(message = "交易市场ID不可为空")
	@ApiModelProperty(value = "交易市场ID", required = true)
	private Long marketId;
	/**开户日期*/
	@NotNull(message = "开户日期不可为空")
	@ApiModelProperty(value = "开户日期", required = true)
	private Integer openDate;
	/**交易帐号*/
	@NotNull(message = "交易帐号不可为空")
	@ApiModelProperty(value = "交易帐号", required = true)
	private String tradeAcount;
	/**资金帐号*/
	@NotNull(message = "资金帐号不可为空")
	@ApiModelProperty(value = "资金帐号", required = true)
	private String fundAccout;
	/**更新时间*/
	@NotNull(message = "更新时间不可为空")
	@ApiModelProperty(value = "更新时间", required = true)
	private java.util.Date updateDate;
	
	public Long getBrokerId()
	{
		return this.brokerId;
	}
	
	public void setBrokerId(Long brokerId)
	{
		this.brokerId = brokerId;
	}
	
	public String getStockHolderName()
	{
		return this.stockHolderName;
	}
	
	public void setStockHolderName(String stockHolderName)
	{
		this.stockHolderName = stockHolderName;
	}
	
	public Long getMarketId()
	{
		return this.marketId;
	}
	
	public void setMarketId(Long marketId)
	{
		this.marketId = marketId;
	}
	
	public Integer getOpenDate()
	{
		return this.openDate;
	}
	
	public void setOpenDate(Integer openDate)
	{
		this.openDate = openDate;
	}
	
	public String getTradeAcount()
	{
		return this.tradeAcount;
	}
	
	public void setTradeAcount(String tradeAcount)
	{
		this.tradeAcount = tradeAcount;
	}
	
	public String getFundAccout()
	{
		return this.fundAccout;
	}
	
	public void setFundAccout(String fundAccout)
	{
		this.fundAccout = fundAccout;
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

