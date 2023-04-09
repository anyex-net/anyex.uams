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
 * 平台资金账户保证金信息表 实体对象
 * <p>File：SysAccountMarginRent.java</p>
 * <p>Title: SysAccountMarginRent</p>
 * <p>Description:SysAccountMarginRent</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "平台资金账户保证金信息表")
public class SysAccountMarginRentEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**资金账号*/
	@NotNull(message = "资金账号不可为空")
	@ApiModelProperty(value = "资金账号", required = true)
	protected String accountNo;
	/**计算方式*/
	@ApiModelProperty(value = "计算方式")
	protected String calculateMode;
	/**看涨看跌标示*/
	@NotNull(message = "看涨看跌标示不可为空")
	@ApiModelProperty(value = "看涨看跌标示", required = true)
	protected String callOrPutFlag;
	/**品种编号*/
	@NotNull(message = "品种编号不可为空")
	@ApiModelProperty(value = "品种编号", required = true)
	protected String commodityNo;
	/**品种类型*/
	@NotNull(message = "品种类型不可为空")
	@ApiModelProperty(value = "品种类型", required = true)
	protected String commodityType;
	/**合约代码*/
	@ApiModelProperty(value = "合约代码")
	protected String contractNo;
	/**币种组*/
	@NotNull(message = "币种组不可为空")
	@ApiModelProperty(value = "币种组", required = true)
	protected String currencyGroupNo;
	/**币种*/
	@NotNull(message = "币种不可为空")
	@ApiModelProperty(value = "币种", required = true)
	protected String currencyNo;
	/**市场号*/
	@NotNull(message = "市场号不可为空")
	@ApiModelProperty(value = "市场号", required = true)
	protected String exchangeNo;
	/**初始保证金*/
	@NotNull(message = "初始保证金不可为空")
	@ApiModelProperty(value = "初始保证金", required = true)
	protected java.math.BigDecimal initialMargin;
	/**锁仓保证金*/
	@NotNull(message = "锁仓保证金不可为空")
	@ApiModelProperty(value = "锁仓保证金", required = true)
	protected java.math.BigDecimal lockMargin;
	/**维持保证金*/
	@NotNull(message = "维持保证金不可为空")
	@ApiModelProperty(value = "维持保证金", required = true)
	protected java.math.BigDecimal maintenanceMargin;
	/**卖出初始保证金*/
	@NotNull(message = "卖出初始保证金不可为空")
	@ApiModelProperty(value = "卖出初始保证金", required = true)
	protected java.math.BigDecimal sellInitialMargin;
	/**卖出维持保证金*/
	@NotNull(message = "卖出维持保证金不可为空")
	@ApiModelProperty(value = "卖出维持保证金", required = true)
	protected java.math.BigDecimal sellMaintenanceMargin;
	/**执行价*/
	@NotNull(message = "执行价不可为空")
	@ApiModelProperty(value = "执行价", required = true)
	protected String strikePrice;
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
	
	public String getCallOrPutFlag()
	{
		return this.callOrPutFlag;
	}
	
	public void setCallOrPutFlag(String callOrPutFlag)
	{
		this.callOrPutFlag = callOrPutFlag;
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
	
	public java.math.BigDecimal getInitialMargin()
	{
		return this.initialMargin;
	}
	
	public void setInitialMargin(java.math.BigDecimal initialMargin)
	{
		this.initialMargin = initialMargin;
	}
	
	public java.math.BigDecimal getLockMargin()
	{
		return this.lockMargin;
	}
	
	public void setLockMargin(java.math.BigDecimal lockMargin)
	{
		this.lockMargin = lockMargin;
	}
	
	public java.math.BigDecimal getMaintenanceMargin()
	{
		return this.maintenanceMargin;
	}
	
	public void setMaintenanceMargin(java.math.BigDecimal maintenanceMargin)
	{
		this.maintenanceMargin = maintenanceMargin;
	}
	
	public java.math.BigDecimal getSellInitialMargin()
	{
		return this.sellInitialMargin;
	}
	
	public void setSellInitialMargin(java.math.BigDecimal sellInitialMargin)
	{
		this.sellInitialMargin = sellInitialMargin;
	}
	
	public java.math.BigDecimal getSellMaintenanceMargin()
	{
		return this.sellMaintenanceMargin;
	}
	
	public void setSellMaintenanceMargin(java.math.BigDecimal sellMaintenanceMargin)
	{
		this.sellMaintenanceMargin = sellMaintenanceMargin;
	}
	
	public String getStrikePrice()
	{
		return this.strikePrice;
	}
	
	public void setStrikePrice(String strikePrice)
	{
		this.strikePrice = strikePrice;
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

