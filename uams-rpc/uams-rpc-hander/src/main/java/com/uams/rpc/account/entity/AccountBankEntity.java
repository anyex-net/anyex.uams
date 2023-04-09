/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.account.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

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
public class AccountBankEntity extends GenericEntity
{
    protected static final long serialVersionUID = 1L;
    
    /**账户ID*/
    @NotNull(message = "账户ID不可为空")
    @ApiModelProperty(value = "账户ID", required = true)
    protected Long              accountId;
    
    /**开户银行(数据字典)*/
    @NotNull(message = "开户银行(数据字典)不可为空")
    @ApiModelProperty(value = "开户银行(数据字典)", required = true)
    protected String            bankDeposit;
    
    /**开户名*/
    @NotNull(message = "开户名不可为空")
    @ApiModelProperty(value = "开户名", required = true)
    protected String            bankAccountName;
    
    /**开户银行地址*/
    @NotNull(message = "开户银行地址不可为空")
    @ApiModelProperty(value = "开户银行地址", required = true)
    protected String            bankAddress;
    
    /**银行帐号*/
    @NotNull(message = "银行帐号不可为空")
    @ApiModelProperty(value = "银行帐号", required = true)
    protected String            bankAccountNumber;
    
    /**联行号*/
    @ApiModelProperty(value = "联行号")
    protected String            branchBankNo;
    
    /**银行卡正面照*/
    @NotNull(message = "银行卡正面照不可为空")
    @ApiModelProperty(value = "银行卡正面照", required = true)
    protected String            frontSideBankCardPhoto;
    
    /**银行卡背面照*/
    @NotNull(message = "银行卡背面照不可为空")
    @ApiModelProperty(value = "银行卡背面照", required = true)
    protected String            backSideBankCardPhoto;
    
    /**省市*/
    @NotNull(message = "省市不可为空")
    @ApiModelProperty(value = "省市", required = true)
    protected String            province;
    
    /**地市*/
    @NotNull(message = "地市不可为空")
    @ApiModelProperty(value = "地市", required = true)
    protected String            city;
    
    /**县市*/
    @NotNull(message = "县市不可为空")
    @ApiModelProperty(value = "县市", required = true)
    protected String            district;
    
    /**手机号码*/
    @NotNull(message = "手机号码不可为空")
    @ApiModelProperty(value = "手机号码", required = true)
    protected String            mobilePhone;
    
    /**状态*/
    @NotNull(message = "状态不可为空")
    @ApiModelProperty(value = "状态", required = true)
    protected String            status;
    
    /**备注*/
    @ApiModelProperty(value = "备注")
    protected String            remark;
    
    /**创建时间*/
    @NotNull(message = "创建时间不可为空")
    @ApiModelProperty(value = "创建时间", required = true)
    protected java.util.Date    createDate;
    
    public Long getAccountId()
    {
        return this.accountId;
    }
    
    public void setAccountId(Long accountId)
    {
        this.accountId = accountId;
    }
    
    public String getBankDeposit()
    {
        return this.bankDeposit;
    }
    
    public void setBankDeposit(String bankDeposit)
    {
        this.bankDeposit = bankDeposit;
    }
    
    public String getBankAccountName()
    {
        return this.bankAccountName;
    }
    
    public void setBankAccountName(String bankAccountName)
    {
        this.bankAccountName = bankAccountName;
    }
    
    public String getBankAddress()
    {
        return this.bankAddress;
    }
    
    public void setBankAddress(String bankAddress)
    {
        this.bankAddress = bankAddress;
    }
    
    public String getBankAccountNumber()
    {
        return this.bankAccountNumber;
    }
    
    public void setBankAccountNumber(String bankAccountNumber)
    {
        this.bankAccountNumber = bankAccountNumber;
    }
    
    public String getBranchBankNo()
    {
        return this.branchBankNo;
    }
    
    public void setBranchBankNo(String branchBankNo)
    {
        this.branchBankNo = branchBankNo;
    }
    
    public String getFrontSideBankCardPhoto()
    {
        return this.frontSideBankCardPhoto;
    }
    
    public void setFrontSideBankCardPhoto(String frontSideBankCardPhoto)
    {
        this.frontSideBankCardPhoto = frontSideBankCardPhoto;
    }
    
    public String getBackSideBankCardPhoto()
    {
        return this.backSideBankCardPhoto;
    }
    
    public void setBackSideBankCardPhoto(String backSideBankCardPhoto)
    {
        this.backSideBankCardPhoto = backSideBankCardPhoto;
    }
    
    public String getProvince()
    {
        return this.province;
    }
    
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    public String getCity()
    {
        return this.city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getDistrict()
    {
        return this.district;
    }
    
    public void setDistrict(String district)
    {
        this.district = district;
    }
    
    public String getMobilePhone()
    {
        return this.mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }
    
    public String getStatus()
    {
        return this.status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
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
}
