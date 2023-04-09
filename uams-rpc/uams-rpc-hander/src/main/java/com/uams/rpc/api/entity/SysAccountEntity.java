/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

/**
 * 平台资金账户信息表 实体对象
 * <p>File：SysAccount.java</p>
 * <p>Title: SysAccount</p>
 * <p>Description:SysAccount</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "平台资金账户信息表")
public class SysAccountEntity extends GenericEntity
{
    protected static final long serialVersionUID = 1L;
    
    /**资金账号*/
    @NotNull(message = "资金账号不可为空")
    @ApiModelProperty(value = "资金账号", required = true)
    protected String            accountNo;
    
    /**账号简称*/
    @NotNull(message = "账号简称不可为空")
    @ApiModelProperty(value = "账号简称", required = true)
    protected String            accountShortName;
    
    /**账号英文简称*/
    @NotNull(message = "账号英文简称不可为空")
    @ApiModelProperty(value = "账号英文简称", required = true)
    protected String            accountEnShortName;
    
    /**账号类型*/
    @NotNull(message = "账号类型不可为空")
    @ApiModelProperty(value = "账号类型", required = true)
    protected String            accountType;
    
    /**账号状态*/
    @NotNull(message = "账号状态不可为空")
    @ApiModelProperty(value = "账号状态", required = true)
    protected String            accountState;
    
    /**交易状态*/
    @NotNull(message = "交易状态不可为空")
    @ApiModelProperty(value = "交易状态", required = true)
    protected String            accountTradeRight;
    
    /**可交易品种组*/
    @NotNull(message = "可交易品种组不可为空")
    @ApiModelProperty(value = "可交易品种组", required = true)
    protected String            commodityGroupNo;
    
    /**备注*/
    @ApiModelProperty(value = "备注")
    protected String            remark;
    
    /**创建时间*/
    @NotNull(message = "创建时间不可为空")
    @ApiModelProperty(value = "创建时间", required = true)
    protected java.util.Date    createDate;
    
    /**修改时间*/
    @ApiModelProperty(value = "修改时间")
    protected java.util.Date    updateDate;
    
    public String getAccountNo()
    {
        return this.accountNo;
    }
    
    public void setAccountNo(String accountNo)
    {
        this.accountNo = accountNo;
    }
    
    public String getAccountShortName()
    {
        return this.accountShortName;
    }
    
    public void setAccountShortName(String accountShortName)
    {
        this.accountShortName = accountShortName;
    }
    
    public String getAccountEnShortName()
    {
        return this.accountEnShortName;
    }
    
    public void setAccountEnShortName(String accountEnShortName)
    {
        this.accountEnShortName = accountEnShortName;
    }
    
    public String getAccountType()
    {
        return this.accountType;
    }
    
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }
    
    public String getAccountState()
    {
        return this.accountState;
    }
    
    public void setAccountState(String accountState)
    {
        this.accountState = accountState;
    }
    
    public String getAccountTradeRight()
    {
        return this.accountTradeRight;
    }
    
    public void setAccountTradeRight(String accountTradeRight)
    {
        this.accountTradeRight = accountTradeRight;
    }
    
    public String getCommodityGroupNo()
    {
        return this.commodityGroupNo;
    }
    
    public void setCommodityGroupNo(String commodityGroupNo)
    {
        this.commodityGroupNo = commodityGroupNo;
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
