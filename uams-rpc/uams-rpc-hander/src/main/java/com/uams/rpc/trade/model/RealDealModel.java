/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.trade.model;

import com.uams.orm.core.GenericEntity;
import com.uams.rpc.trade.entity.RealDealEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
public class RealDealModel extends RealDealEntity
{
	
	protected static final long serialVersionUID = 1L;

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("RealDealModel{");
		sb.append("id=").append(id);
		sb.append(", uid=").append(uid);
		sb.append(", accountId=").append(accountId);
		sb.append(", delFlag=").append(delFlag);
		sb.append(", entrustId=").append(entrustId);
		sb.append(", tradeType='").append(tradeType).append('\'');
		sb.append(", businessFlag='").append(businessFlag).append('\'');
		sb.append(", dealDirect='").append(dealDirect).append('\'');
		sb.append(", dealStockInfoId=").append(dealStockInfoId);
		sb.append(", dealAmt=").append(dealAmt);
		sb.append(", dealPrice=").append(dealPrice);
		sb.append(", dealBalance=").append(dealBalance);
		sb.append(", dealTime=").append(dealTime);
		sb.append(", feeType=").append(feeType);
		sb.append(", fee=").append(fee);
		sb.append(", remark='").append(remark).append('\'');
		sb.append('}');
		return sb.toString();
	}
}

