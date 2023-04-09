/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.model;

import com.uams.orm.core.GenericEntity;
import com.uams.rpc.fund.entity.AccountFundCurrentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 账户资金流水表 实体对象
 * <p>File：AccountFundCurrent.java</p>
 * <p>Title: AccountFundCurrent</p>
 * <p>Description:AccountFundCurrent</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "账户资金流水表")
public class AccountFundCurrentModel extends AccountFundCurrentEntity
{
    private static final long serialVersionUID = 1L;
    
    private String            accountName;
    
    private String            stockCode;
    
    public String getAccountName()
    {
        return accountName;
    }
    
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }
    
    public String getStockCode()
    {
        return stockCode;
    }
    
    public void setStockCode(String stockCode)
    {
        this.stockCode = stockCode;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AccountFundCurrentModel{");
        sb.append("id=").append(id);
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", accountId=").append(accountId);
        sb.append(", stockCode='").append(stockCode).append('\'');
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", currentDate=").append(currentDate);
        sb.append(", businessFlag='").append(businessFlag).append('\'');
        sb.append(", stockinfoId=").append(stockinfoId);
        sb.append(", occurDirect='").append(occurDirect).append('\'');
        sb.append(", orgAmt=").append(orgAmt);
        sb.append(", occurAmt=").append(occurAmt);
        sb.append(", lastAmt=").append(lastAmt);
        sb.append(", forzenOrgAmt=").append(forzenOrgAmt);
        sb.append(", occurForzenAmt=").append(occurForzenAmt);
        sb.append(", forzenLastAmt=").append(forzenLastAmt);
        sb.append(", transId='").append(transId).append('\'');
        sb.append(", sourceAccountBankId=").append(sourceAccountBankId);
        sb.append(", targetAccountBankId=").append(targetAccountBankId);
        sb.append(", fee=").append(fee);
        sb.append(", netFee=").append(netFee);
        sb.append(", originalBusinessId=").append(originalBusinessId);
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
