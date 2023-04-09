/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.model;

import com.uams.orm.core.GenericEntity;
import com.uams.rpc.fund.entity.AccountFundEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 账户资金表 实体对象
 * <p>File：AccountFund.java</p>
 * <p>Title: AccountFund</p>
 * <p>Description:AccountFund</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "账户资金表")
public class AccountFundModel extends AccountFundEntity
{
    private static final long serialVersionUID = 1L;
    
    private String            accountName;
    
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
        final StringBuilder sb = new StringBuilder("AccountFundModel{");
        sb.append("id=").append(id);
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", accountId=").append(accountId);
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", currentAmount=").append(currentAmount);
        sb.append(", frozenAmt=").append(frozenAmt);
        sb.append(", creditAmt=").append(creditAmt);
        sb.append(", initAmt=").append(initAmt);
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
