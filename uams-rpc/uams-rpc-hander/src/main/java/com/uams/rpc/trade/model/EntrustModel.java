/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.trade.model;

import com.uams.orm.core.GenericEntity;
import com.uams.rpc.trade.entity.EntrustEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
public class EntrustModel extends EntrustEntity
{
	protected static final long serialVersionUID = 1L;

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("EntrustModel{");
		sb.append("id=").append(id);
		sb.append(", accountId=").append(accountId);
		sb.append(", entrustTime=").append(entrustTime);
		sb.append(", entrustSource='").append(entrustSource).append('\'');
		sb.append(", businessFlag='").append(businessFlag).append('\'');
		sb.append(", tradeType='").append(tradeType).append('\'');
		sb.append(", entrustType='").append(entrustType).append('\'');
		sb.append(", entrustDirect='").append(entrustDirect).append('\'');
		sb.append(", entrustStockinfoId=").append(entrustStockinfoId);
		sb.append(", entrustAmt=").append(entrustAmt);
		sb.append(", entrustPrice=").append(entrustPrice);
		sb.append(", entrustRemark='").append(entrustRemark).append('\'');
		sb.append(", entrustAccountType=").append(entrustAccountType);
		sb.append(", feeType=").append(feeType);
		sb.append(", feeRate=").append(feeRate);
		sb.append(", dealAmt=").append(dealAmt);
		sb.append(", dealBalance=").append(dealBalance);
		sb.append(", dealFee=").append(dealFee);
		sb.append(", status='").append(status).append('\'');
		sb.append(", updateTime=").append(updateTime);
		sb.append(", remark='").append(remark).append('\'');
		sb.append('}');
		return sb.toString();
	}
}

