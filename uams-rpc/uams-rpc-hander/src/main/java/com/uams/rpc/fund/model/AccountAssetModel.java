/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.fund.model;

import com.uams.orm.core.GenericEntity;
import com.uams.rpc.fund.entity.AccountAssetEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 账户持仓表 实体对象
 * <p>File：AccountAsset.java</p>
 * <p>Title: AccountAsset</p>
 * <p>Description:AccountAsset</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "账户持仓表")
public class AccountAssetModel extends AccountAssetEntity
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
        final StringBuilder sb = new StringBuilder("AccountAssetModel{");
        sb.append("id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", stockinfoId=").append(stockinfoId);
        sb.append(", direction='").append(direction).append('\'');
        sb.append(", currentAmount=").append(currentAmount);
        sb.append(", frozenAmt=").append(frozenAmt);
        sb.append(", initAmt=").append(initAmt);
        sb.append(", price=").append(price);
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
