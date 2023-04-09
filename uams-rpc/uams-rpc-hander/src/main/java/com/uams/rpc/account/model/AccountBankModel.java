/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.account.model;

import javax.validation.constraints.NotNull;

import com.uams.orm.core.GenericEntity;
import com.uams.rpc.account.entity.AccountBankEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 账户银行表 实体对象
 * <p>File：AccountBank.java</p>
 * <p>Title: AccountBank</p>
 * <p>Description:AccountBank</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "账户银行表")
public class AccountBankModel extends AccountBankEntity
{
    private static final long serialVersionUID = 1L;
    
    /**账户名*/
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
        final StringBuilder sb = new StringBuilder("AccountBankModel{");
        sb.append("id=").append(id);
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", accountId=").append(accountId);
        sb.append(", bankDeposit='").append(bankDeposit).append('\'');
        sb.append(", bankAccountName='").append(bankAccountName).append('\'');
        sb.append(", bankAddress='").append(bankAddress).append('\'');
        sb.append(", bankAccountNumber='").append(bankAccountNumber).append('\'');
        sb.append(", branchBankNo='").append(branchBankNo).append('\'');
        sb.append(", frontSideBankCardPhoto='").append(frontSideBankCardPhoto).append('\'');
        sb.append(", backSideBankCardPhoto='").append(backSideBankCardPhoto).append('\'');
        sb.append(", province='").append(province).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", mobilePhone='").append(mobilePhone).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append('}');
        return sb.toString();
    }
}
