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
 * 平台资金账户费率(保证金费率等)信息表 实体对象
 * <p>File：SysAccountFeeRent.java</p>
 * <p>Title: SysAccountFeeRent</p>
 * <p>Description:SysAccountFeeRent</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "平台资金账户费率(保证金费率等)信息表")
public class SysAccountFeeRentEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**资金账号*/
	@NotNull(message = "资金账号不可为空")
	@ApiModelProperty(value = "资金账号", required = true)
	protected String accountNo;
	/**计算方式*/
	@ApiModelProperty(value = "计算方式")
	protected String calculateMode;
	/**平今费用*/
	@NotNull(message = "平今费用不可为空")
	@ApiModelProperty(value = "平今费用", required = true)
	protected java.math.BigDecimal closeTodayFee;
	/**品种编号*/
	@NotNull(message = "品种编号不可为空")
	@ApiModelProperty(value = "品种编号", required = true)
	protected String commodityNo;
	/**品种类型*/
	@NotNull(message = "品种类型不可为空")
	@ApiModelProperty(value = "品种类型", required = true)
	protected String commodityType;
	/**币种组*/
	@NotNull(message = "币种组不可为空")
	@ApiModelProperty(value = "币种组", required = true)
	protected String currencyGroupNo;
	/**币种*/
	@ApiModelProperty(value = "币种")
	protected String currencyNo;
	/**市场号*/
	@NotNull(message = "市场号不可为空")
	@ApiModelProperty(value = "市场号", required = true)
	protected String exchangeNo;
	/**成交来源*/
	@NotNull(message = "成交来源不可为空")
	@ApiModelProperty(value = "成交来源", required = true)
	protected String matchSource;
	/**开平仓费用*/
	@NotNull(message = "开平仓费用不可为空")
	@ApiModelProperty(value = "开平仓费用", required = true)
	protected java.math.BigDecimal openCloseFee;
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
	
	public String getCalculateMode()
	{
		return this.calculateMode;
	}
	
	public void setCalculateMode(String calculateMode)
	{
		this.calculateMode = calculateMode;
	}
	
	public java.math.BigDecimal getCloseTodayFee()
	{
		return this.closeTodayFee;
	}
	
	public void setCloseTodayFee(java.math.BigDecimal closeTodayFee)
	{
		this.closeTodayFee = closeTodayFee;
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
	
	public String getExchangeNo()
	{
		return this.exchangeNo;
	}
	
	public void setExchangeNo(String exchangeNo)
	{
		this.exchangeNo = exchangeNo;
	}
	
	public String getMatchSource()
	{
		return this.matchSource;
	}
	
	public void setMatchSource(String matchSource)
	{
		this.matchSource = matchSource;
	}
	
	public java.math.BigDecimal getOpenCloseFee()
	{
		return this.openCloseFee;
	}
	
	public void setOpenCloseFee(java.math.BigDecimal openCloseFee)
	{
		this.openCloseFee = openCloseFee;
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

