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
 * 平台历史委托表 实体对象
 * <p>File：SysHisOrderEntity.java</p>
 * <p>Title: SysHisOrderEntity</p>
 * <p>Description:SysHisOrderEntity</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "平台历史委托表")
public class SysHisOrderEntity extends GenericEntity {
	
	protected static final long serialVersionUID = 1L;
	
	/**客户资金帐号*/
	@ApiModelProperty(value = "客户资金帐号")
	protected String accountNo;
	/**是否T+1有效*/
	@ApiModelProperty(value = "是否T+1有效")
	protected String addOneIsValid;
	/**看涨看跌1*/
	@ApiModelProperty(value = "看涨看跌1")
	protected String callOrPutFlag;
	/**看涨看跌2*/
	@ApiModelProperty(value = "看涨看跌2")
	protected String callOrPutFlag2;
	/**品种编号*/
	@ApiModelProperty(value = "品种编号")
	protected String commodityNo;
	/**品种类型*/
	@ApiModelProperty(value = "品种类型")
	protected String commodityType;
	/**合约1*/
	@ApiModelProperty(value = "合约1")
	protected String contractNo;
	/**合约2*/
	@ApiModelProperty(value = "合约2")
	protected String contractNo2;
	/**日期*/
	@ApiModelProperty(value = "日期")
	protected String date1;
	/**错误信息码*/
	@ApiModelProperty(value = "错误信息码")
	protected String errorCode;
	/**错误信息*/
	@ApiModelProperty(value = "错误信息")
	protected String errorText;
	/**交易所编号*/
	@ApiModelProperty(value = "交易所编号")
	protected String exchangeNo;
	/**有效日期(GTD情况下使用)*/
	@ApiModelProperty(value = "有效日期(GTD情况下使用)")
	protected String expireTime;
	/**投机保值*/
	@ApiModelProperty(value = "投机保值")
	protected String hedgeFlag;
	/**询价号*/
	@ApiModelProperty(value = "询价号")
	protected String inquiryNo;
	/**是否为T+1单*/
	@ApiModelProperty(value = "是否为T+1单")
	protected String isAddOne;
	/**是否为录入委托单*/
	@ApiModelProperty(value = "是否为录入委托单")
	protected String isBackInput;
	/**委托成交删除标志*/
	@ApiModelProperty(value = "委托成交删除标志")
	protected String isDeleted;
	/**是否风险报单*/
	@ApiModelProperty(value = "是否风险报单")
	protected String isRiskOrder;
	/**软件授权号*/
	@ApiModelProperty(value = "软件授权号")
	protected String licenseNo;
	/**冰山单最大随机量*/
	@NotNull(message = "冰山单最大随机量不可为空")
	@ApiModelProperty(value = "冰山单最大随机量", required = true)
	protected Long maxClipSize;
	/**冰山单最小随机量*/
	@NotNull(message = "冰山单最小随机量不可为空")
	@ApiModelProperty(value = "冰山单最小随机量", required = true)
	protected Long minClipSize;
	/**撤单数量*/
	@NotNull(message = "撤单数量不可为空")
	@ApiModelProperty(value = "撤单数量", required = true)
	protected Integer orderCanceledQty;
	/**录单操作人*/
	@ApiModelProperty(value = "录单操作人")
	protected String orderCommandUserNo;
	/**交易所系统号*/
	@ApiModelProperty(value = "交易所系统号")
	protected String orderExchangeSystemNo;
	/**下单时间*/
	@ApiModelProperty(value = "下单时间")
	protected String orderInsertTime;
	/**下单人*/
	@ApiModelProperty(value = "下单人")
	protected String orderInsertUserNo;
	/**本地号*/
	@ApiModelProperty(value = "本地号")
	protected String orderLocalNo;
	/**成交价1*/
	@NotNull(message = "成交价1不可为空")
	@ApiModelProperty(value = "成交价1", required = true)
	protected java.math.BigDecimal orderMatchPrice;
	/**成交价2*/
	@NotNull(message = "成交价2不可为空")
	@ApiModelProperty(value = "成交价2", required = true)
	protected java.math.BigDecimal orderMatchPrice2;
	/**成交量1*/
	@NotNull(message = "成交量1不可为空")
	@ApiModelProperty(value = "成交量1", required = true)
	protected Integer orderMatchQty;
	/**成交量2*/
	@NotNull(message = "成交量2不可为空")
	@ApiModelProperty(value = "成交量2", required = true)
	protected Integer orderMatchQty2;
	/**最小成交量*/
	@NotNull(message = "最小成交量不可为空")
	@ApiModelProperty(value = "最小成交量", required = true)
	protected Integer orderMinQty;
	/**委托编码*/
	@ApiModelProperty(value = "委托编码")
	protected String orderNo;
	/**父单系统号*/
	@ApiModelProperty(value = "父单系统号")
	protected String orderParentSystemNo;
	/**委托价格1*/
	@NotNull(message = "委托价格1不可为空")
	@ApiModelProperty(value = "委托价格1", required = true)
	protected java.math.BigDecimal orderPrice;
	/**委托价格2*/
	@NotNull(message = "委托价格2不可为空")
	@ApiModelProperty(value = "委托价格2", required = true)
	protected java.math.BigDecimal orderPrice2;
	/**委托数量*/
	@NotNull(message = "委托数量不可为空")
	@ApiModelProperty(value = "委托数量", required = true)
	protected Long orderQty;
	/**买入卖出*/
	@ApiModelProperty(value = "买入卖出")
	protected String orderSide;
	/**委托来源*/
	@ApiModelProperty(value = "委托来源")
	protected String orderSource;
	/**委托状态*/
	@ApiModelProperty(value = "委托状态")
	protected String orderState;
	/**委托流水号*/
	@ApiModelProperty(value = "委托流水号")
	protected Integer orderStreamID;
	/**系统号*/
	@ApiModelProperty(value = "系统号")
	protected String orderSystemNo;
	/**委托类型*/
	@ApiModelProperty(value = "委托类型")
	protected String orderType;
	/**委托更新时间*/
	@ApiModelProperty(value = "委托更新时间")
	protected String orderUpdateTime;
	/**委托更新人*/
	@ApiModelProperty(value = "委托更新人")
	protected String orderUpdateUserNo;
	/**开平标志1*/
	@ApiModelProperty(value = "开平标志1")
	protected String positionEffect;
	/**开平标志2*/
	@ApiModelProperty(value = "开平标志2")
	protected String positionEffect2;
	/**浮点参考值*/
	@NotNull(message = "浮点参考值不可为空")
	@ApiModelProperty(value = "浮点参考值", required = true)
	protected java.math.BigDecimal refDouble;
	/**整型参考值*/
	@NotNull(message = "整型参考值不可为空")
	@ApiModelProperty(value = "整型参考值", required = true)
	protected Integer refInt;
	/**字符串参考值*/
	@NotNull(message = "字符串参考值不可为空")
	@ApiModelProperty(value = "字符串参考值", required = true)
	protected String refString;
	/**服务器标识*/
	@ApiModelProperty(value = "服务器标识")
	protected String serverFlag;
	/**触发价格*/
	@NotNull(message = "触发价格不可为空")
	@ApiModelProperty(value = "触发价格", required = true)
	protected java.math.BigDecimal stopPrice;
	/**执行价格1*/
	@NotNull(message = "执行价格1不可为空")
	@ApiModelProperty(value = "执行价格1", required = true)
	protected java.math.BigDecimal strikePrice;
	/**执行价格12*/
	@NotNull(message = "执行价格12不可为空")
	@ApiModelProperty(value = "执行价格12", required = true)
	protected java.math.BigDecimal strikePrice2;
	/**策略单类型*/
	@ApiModelProperty(value = "策略单类型")
	protected String tacticsType;
	/**委托有效类型*/
	@ApiModelProperty(value = "委托有效类型")
	protected String timeInForce;
	/**触发条件*/
	@ApiModelProperty(value = "触发条件")
	protected String triggerCondition;
	/**触发价格类型*/
	@ApiModelProperty(value = "触发价格类型")
	protected String triggerPriceType;
	/**上手通道号*/
	@ApiModelProperty(value = "上手通道号")
	protected String upperChannelNo;
	/**上手号*/
	@ApiModelProperty(value = "上手号")
	protected String upperNo;
	/**上手流号*/
	@NotNull(message = "上手流号不可为空")
	@ApiModelProperty(value = "上手流号", required = true)
	protected Integer upperStreamID;
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
	
	public String getAccountNo()
	{
		return this.accountNo;
	}
	
	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	
	public String getAddOneIsValid()
	{
		return this.addOneIsValid;
	}
	
	public void setAddOneIsValid(String addOneIsValid)
	{
		this.addOneIsValid = addOneIsValid;
	}
	
	public String getCallOrPutFlag()
	{
		return this.callOrPutFlag;
	}
	
	public void setCallOrPutFlag(String callOrPutFlag)
	{
		this.callOrPutFlag = callOrPutFlag;
	}
	
	public String getCallOrPutFlag2()
	{
		return this.callOrPutFlag2;
	}
	
	public void setCallOrPutFlag2(String callOrPutFlag2)
	{
		this.callOrPutFlag2 = callOrPutFlag2;
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
	
	public String getContractNo2()
	{
		return this.contractNo2;
	}
	
	public void setContractNo2(String contractNo2)
	{
		this.contractNo2 = contractNo2;
	}
	
	public String getDate1()
	{
		return this.date1;
	}
	
	public void setDate1(String date1)
	{
		this.date1 = date1;
	}
	
	public String getErrorCode()
	{
		return this.errorCode;
	}
	
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}
	
	public String getErrorText()
	{
		return this.errorText;
	}
	
	public void setErrorText(String errorText)
	{
		this.errorText = errorText;
	}
	
	public String getExchangeNo()
	{
		return this.exchangeNo;
	}
	
	public void setExchangeNo(String exchangeNo)
	{
		this.exchangeNo = exchangeNo;
	}
	
	public String getExpireTime()
	{
		return this.expireTime;
	}
	
	public void setExpireTime(String expireTime)
	{
		this.expireTime = expireTime;
	}
	
	public String getHedgeFlag()
	{
		return this.hedgeFlag;
	}
	
	public void setHedgeFlag(String hedgeFlag)
	{
		this.hedgeFlag = hedgeFlag;
	}
	
	public String getInquiryNo()
	{
		return this.inquiryNo;
	}
	
	public void setInquiryNo(String inquiryNo)
	{
		this.inquiryNo = inquiryNo;
	}
	
	public String getIsAddOne()
	{
		return this.isAddOne;
	}
	
	public void setIsAddOne(String isAddOne)
	{
		this.isAddOne = isAddOne;
	}
	
	public String getIsBackInput()
	{
		return this.isBackInput;
	}
	
	public void setIsBackInput(String isBackInput)
	{
		this.isBackInput = isBackInput;
	}
	
	public String getIsDeleted()
	{
		return this.isDeleted;
	}
	
	public void setIsDeleted(String isDeleted)
	{
		this.isDeleted = isDeleted;
	}
	
	public String getIsRiskOrder()
	{
		return this.isRiskOrder;
	}
	
	public void setIsRiskOrder(String isRiskOrder)
	{
		this.isRiskOrder = isRiskOrder;
	}
	
	public String getLicenseNo()
	{
		return this.licenseNo;
	}
	
	public void setLicenseNo(String licenseNo)
	{
		this.licenseNo = licenseNo;
	}
	
	public Long getMaxClipSize()
	{
		return this.maxClipSize;
	}
	
	public void setMaxClipSize(Long maxClipSize)
	{
		this.maxClipSize = maxClipSize;
	}
	
	public Long getMinClipSize()
	{
		return this.minClipSize;
	}
	
	public void setMinClipSize(Long minClipSize)
	{
		this.minClipSize = minClipSize;
	}
	
	public Integer getOrderCanceledQty()
	{
		return this.orderCanceledQty;
	}
	
	public void setOrderCanceledQty(Integer orderCanceledQty)
	{
		this.orderCanceledQty = orderCanceledQty;
	}
	
	public String getOrderCommandUserNo()
	{
		return this.orderCommandUserNo;
	}
	
	public void setOrderCommandUserNo(String orderCommandUserNo)
	{
		this.orderCommandUserNo = orderCommandUserNo;
	}
	
	public String getOrderExchangeSystemNo()
	{
		return this.orderExchangeSystemNo;
	}
	
	public void setOrderExchangeSystemNo(String orderExchangeSystemNo)
	{
		this.orderExchangeSystemNo = orderExchangeSystemNo;
	}
	
	public String getOrderInsertTime()
	{
		return this.orderInsertTime;
	}
	
	public void setOrderInsertTime(String orderInsertTime)
	{
		this.orderInsertTime = orderInsertTime;
	}
	
	public String getOrderInsertUserNo()
	{
		return this.orderInsertUserNo;
	}
	
	public void setOrderInsertUserNo(String orderInsertUserNo)
	{
		this.orderInsertUserNo = orderInsertUserNo;
	}
	
	public String getOrderLocalNo()
	{
		return this.orderLocalNo;
	}
	
	public void setOrderLocalNo(String orderLocalNo)
	{
		this.orderLocalNo = orderLocalNo;
	}
	
	public java.math.BigDecimal getOrderMatchPrice()
	{
		return this.orderMatchPrice;
	}
	
	public void setOrderMatchPrice(java.math.BigDecimal orderMatchPrice)
	{
		this.orderMatchPrice = orderMatchPrice;
	}
	
	public java.math.BigDecimal getOrderMatchPrice2()
	{
		return this.orderMatchPrice2;
	}
	
	public void setOrderMatchPrice2(java.math.BigDecimal orderMatchPrice2)
	{
		this.orderMatchPrice2 = orderMatchPrice2;
	}
	
	public Integer getOrderMatchQty()
	{
		return this.orderMatchQty;
	}
	
	public void setOrderMatchQty(Integer orderMatchQty)
	{
		this.orderMatchQty = orderMatchQty;
	}
	
	public Integer getOrderMatchQty2()
	{
		return this.orderMatchQty2;
	}
	
	public void setOrderMatchQty2(Integer orderMatchQty2)
	{
		this.orderMatchQty2 = orderMatchQty2;
	}
	
	public Integer getOrderMinQty()
	{
		return this.orderMinQty;
	}
	
	public void setOrderMinQty(Integer orderMinQty)
	{
		this.orderMinQty = orderMinQty;
	}
	
	public String getOrderNo()
	{
		return this.orderNo;
	}
	
	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}
	
	public String getOrderParentSystemNo()
	{
		return this.orderParentSystemNo;
	}
	
	public void setOrderParentSystemNo(String orderParentSystemNo)
	{
		this.orderParentSystemNo = orderParentSystemNo;
	}
	
	public java.math.BigDecimal getOrderPrice()
	{
		return this.orderPrice;
	}
	
	public void setOrderPrice(java.math.BigDecimal orderPrice)
	{
		this.orderPrice = orderPrice;
	}
	
	public java.math.BigDecimal getOrderPrice2()
	{
		return this.orderPrice2;
	}
	
	public void setOrderPrice2(java.math.BigDecimal orderPrice2)
	{
		this.orderPrice2 = orderPrice2;
	}
	
	public Long getOrderQty()
	{
		return this.orderQty;
	}
	
	public void setOrderQty(Long orderQty)
	{
		this.orderQty = orderQty;
	}
	
	public String getOrderSide()
	{
		return this.orderSide;
	}
	
	public void setOrderSide(String orderSide)
	{
		this.orderSide = orderSide;
	}
	
	public String getOrderSource()
	{
		return this.orderSource;
	}
	
	public void setOrderSource(String orderSource)
	{
		this.orderSource = orderSource;
	}
	
	public String getOrderState()
	{
		return this.orderState;
	}
	
	public void setOrderState(String orderState)
	{
		this.orderState = orderState;
	}
	
	public Integer getOrderStreamID()
	{
		return this.orderStreamID;
	}
	
	public void setOrderStreamID(Integer orderStreamID)
	{
		this.orderStreamID = orderStreamID;
	}
	
	public String getOrderSystemNo()
	{
		return this.orderSystemNo;
	}
	
	public void setOrderSystemNo(String orderSystemNo)
	{
		this.orderSystemNo = orderSystemNo;
	}
	
	public String getOrderType()
	{
		return this.orderType;
	}
	
	public void setOrderType(String orderType)
	{
		this.orderType = orderType;
	}
	
	public String getOrderUpdateTime()
	{
		return this.orderUpdateTime;
	}
	
	public void setOrderUpdateTime(String orderUpdateTime)
	{
		this.orderUpdateTime = orderUpdateTime;
	}
	
	public String getOrderUpdateUserNo()
	{
		return this.orderUpdateUserNo;
	}
	
	public void setOrderUpdateUserNo(String orderUpdateUserNo)
	{
		this.orderUpdateUserNo = orderUpdateUserNo;
	}
	
	public String getPositionEffect()
	{
		return this.positionEffect;
	}
	
	public void setPositionEffect(String positionEffect)
	{
		this.positionEffect = positionEffect;
	}
	
	public String getPositionEffect2()
	{
		return this.positionEffect2;
	}
	
	public void setPositionEffect2(String positionEffect2)
	{
		this.positionEffect2 = positionEffect2;
	}
	
	public java.math.BigDecimal getRefDouble()
	{
		return this.refDouble;
	}
	
	public void setRefDouble(java.math.BigDecimal refDouble)
	{
		this.refDouble = refDouble;
	}
	
	public Integer getRefInt()
	{
		return this.refInt;
	}
	
	public void setRefInt(Integer refInt)
	{
		this.refInt = refInt;
	}
	
	public String getRefString()
	{
		return this.refString;
	}
	
	public void setRefString(String refString)
	{
		this.refString = refString;
	}
	
	public String getServerFlag()
	{
		return this.serverFlag;
	}
	
	public void setServerFlag(String serverFlag)
	{
		this.serverFlag = serverFlag;
	}
	
	public java.math.BigDecimal getStopPrice()
	{
		return this.stopPrice;
	}
	
	public void setStopPrice(java.math.BigDecimal stopPrice)
	{
		this.stopPrice = stopPrice;
	}
	
	public java.math.BigDecimal getStrikePrice()
	{
		return this.strikePrice;
	}
	
	public void setStrikePrice(java.math.BigDecimal strikePrice)
	{
		this.strikePrice = strikePrice;
	}
	
	public java.math.BigDecimal getStrikePrice2()
	{
		return this.strikePrice2;
	}
	
	public void setStrikePrice2(java.math.BigDecimal strikePrice2)
	{
		this.strikePrice2 = strikePrice2;
	}
	
	public String getTacticsType()
	{
		return this.tacticsType;
	}
	
	public void setTacticsType(String tacticsType)
	{
		this.tacticsType = tacticsType;
	}
	
	public String getTimeInForce()
	{
		return this.timeInForce;
	}
	
	public void setTimeInForce(String timeInForce)
	{
		this.timeInForce = timeInForce;
	}
	
	public String getTriggerCondition()
	{
		return this.triggerCondition;
	}
	
	public void setTriggerCondition(String triggerCondition)
	{
		this.triggerCondition = triggerCondition;
	}
	
	public String getTriggerPriceType()
	{
		return this.triggerPriceType;
	}
	
	public void setTriggerPriceType(String triggerPriceType)
	{
		this.triggerPriceType = triggerPriceType;
	}
	
	public String getUpperChannelNo()
	{
		return this.upperChannelNo;
	}
	
	public void setUpperChannelNo(String upperChannelNo)
	{
		this.upperChannelNo = upperChannelNo;
	}
	
	public String getUpperNo()
	{
		return this.upperNo;
	}
	
	public void setUpperNo(String upperNo)
	{
		this.upperNo = upperNo;
	}
	
	public Integer getUpperStreamID()
	{
		return this.upperStreamID;
	}
	
	public void setUpperStreamID(Integer upperStreamID)
	{
		this.upperStreamID = upperStreamID;
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

