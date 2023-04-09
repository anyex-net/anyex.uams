/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.model;

import com.uams.orm.core.GenericEntity;
import com.uams.rpc.fund.entity.AccountFundAdjustEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 账户资金调整记录表 实体对象
 * <p>File：AccountFundAdjust.java</p>
 * <p>Title: AccountFundAdjust</p>
 * <p>Description:AccountFundAdjust</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "账户资金调整记录表")
public class AccountFundAdjustModel extends AccountFundAdjustEntity
{
    private String accountName;
    
    public String getAccountName()
    {
        return accountName;
    }
    
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AccountFundAdjustModel{");
        sb.append("id=").append(id);
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", accountId=").append(accountId);
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", adjustType='").append(adjustType).append('\'');
        sb.append(", adjustAmt=").append(adjustAmt);
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append('}');
        return sb.toString();
    }
}
