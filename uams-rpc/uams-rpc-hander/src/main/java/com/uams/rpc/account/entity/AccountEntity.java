/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.account.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 账户表 实体对象
 * <p>File：Account.java</p>
 * <p>Title: Account</p>
 * <p>Description:Account</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "账户表")
public class AccountEntity extends GenericEntity
{
    protected static final long serialVersionUID = 1L;
    
    /**用户编号*/
    @NotNull(message = "用户编号不可为空")
    @ApiModelProperty(value = "用户编号", required = true)
    protected Long              unid;
    
    /**账户类型(数据字典)*/
    @NotNull(message = "账户类型(数据字典)不可为空")
    @ApiModelProperty(value = "账户类型(数据字典)", required = true)
    protected String            accountType;
    
    /**账户名(个人或者法人姓名)*/
    @NotNull(message = "账户名(个人或者法人姓名)不可为空")
    @ApiModelProperty(value = "账户名(个人或者法人姓名)", required = true)
    protected String            accountName;
    
    /**证件类型(数据字典)*/
    @NotNull(message = "证件类型(数据字典)不可为空")
    @ApiModelProperty(value = "证件类型(数据字典)", required = true)
    protected String            certificateType;
    
    /**证件号码*/
    @NotNull(message = "证件号码不可为空")
    @ApiModelProperty(value = "证件号码", required = true)
    protected String            certificateNumber;
    
    /**出生年月*/
    @NotNull(message = "出生年月不可为空")
    @ApiModelProperty(value = "出生年月", required = true)
    protected Integer           dateBirth;
    
    /**联系电话*/
    @NotNull(message = "联系电话不可为空")
    @ApiModelProperty(value = "联系电话", required = true)
    protected String            contactNumber;
    
    /**手机号*/
    @NotNull(message = "手机号不可为空")
    @ApiModelProperty(value = "手机号", required = true)
    protected String            mobilePhone;
    
    /**电子邮箱*/
    @NotNull(message = "电子邮箱不可为空")
    @ApiModelProperty(value = "电子邮箱", required = true)
    protected String            email;
    
    /**邮政编码*/
    @NotNull(message = "邮政编码不可为空")
    @ApiModelProperty(value = "邮政编码", required = true)
    protected String            postCode;
    
    /**联系地址*/
    @NotNull(message = "联系地址不可为空")
    @ApiModelProperty(value = "联系地址", required = true)
    protected String            contactAddress;
    
    /**证件正面照*/
    @NotNull(message = "证件正面照不可为空")
    @ApiModelProperty(value = "证件正面照", required = true)
    protected String            frontSideIDPhoto;
    
    /**证件背面照*/
    @NotNull(message = "证件背面照不可为空")
    @ApiModelProperty(value = "证件背面照", required = true)
    protected String            backSideIDPhoto;
    
    /**手持证件照*/
    @NotNull(message = "手持证件照不可为空")
    @ApiModelProperty(value = "手持证件照", required = true)
    protected String            handWithIDPhoto;
    
    /**风险等级(数据字典)*/
    @NotNull(message = "风险等级(数据字典)不可为空")
    @ApiModelProperty(value = "风险等级(数据字典)", required = true)
    protected String            riskLevel;
    
    /**语言(数据字典)*/
    @NotNull(message = "语言(数据字典)不可为空")
    @ApiModelProperty(value = "语言(数据字典)", required = true)
    protected String            lang;
    
    /**国家地区(数据字典)*/
    @NotNull(message = "国家地区(数据字典)不可为空")
    @ApiModelProperty(value = "国家地区(数据字典)", required = true)
    protected String            country;
    
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
    
    /**开户时间*/
    @NotNull(message = "开户时间不可为空")
    @ApiModelProperty(value = "开户时间", required = true)
    protected java.util.Date    openAccountTime;
    
    /**销户时间*/
    @ApiModelProperty(value = "销户时间")
    protected java.util.Date    closeAccountTime;
    
    /**登录密码*/
    @NotNull(message = "登录密码不可为空")
    @ApiModelProperty(value = "登录密码", required = true)
    protected String            loginPwd;
    
    /**资金密码*/
    @ApiModelProperty(value = "资金密码")
    protected String            fundPwd;
    
    /**企业营业执照代码*/
    @ApiModelProperty(value = "企业营业执照代码")
    protected String            companyLicenseCode;
    
    /**企业营业执照照片*/
    @ApiModelProperty(value = "企业营业执照照片")
    protected String            companyLicensePhoto;
    
    /**经办人姓名*/
    @ApiModelProperty(value = "经办人姓名")
    protected String            operatorName;
    
    /**经办人证件类型(数据字典)*/
    @ApiModelProperty(value = "经办人证件类型(数据字典)")
    protected String            operatorCertificateType;
    
    /**经办人证件号码*/
    @ApiModelProperty(value = "经办人证件号码")
    protected String            operatorCertificateNumber;
    
    /**经办人证件正面照*/
    @ApiModelProperty(value = "经办人证件正面照")
    protected String            operatorFrontSideIDPhoto;
    
    /**经办人证件背面照*/
    @ApiModelProperty(value = "经办人证件背面照")
    protected String            operatorBackSideIDPhoto;
    
    /**经办人联系电话*/
    @ApiModelProperty(value = "经办人联系电话")
    protected String            operatorContactNumber;
    
    /**经办人手机号码*/
    @ApiModelProperty(value = "经办人手机号码")
    protected String            operatorMobilePhone;
    
    /**经纪人ID(userinfo用户表ID)*/
    @NotNull(message = "经纪人ID(userinfo用户表ID)不可为空")
    @ApiModelProperty(value = "经纪人ID(userinfo用户表ID)", required = true)
    protected Long              salesBrokerId;
    
    /**所属机构ID*/
    @NotNull(message = "所属机构ID不可为空")
    @ApiModelProperty(value = "所属机构ID", required = true)
    protected Long              belongOrgId;
    
    /**账户状态(数据字典:正常、冻结、注销)*/
    @NotNull(message = "账户状态(数据字典:正常、冻结、注销)不可为空")
    @ApiModelProperty(value = "账户状态(数据字典:正常、冻结、注销)", required = true)
    protected String            accountStatus;
    
    /**语言标识*/
    @ApiModelProperty(value = "语言标识")
    protected String            remark;
    
    /**创建时间*/
    @NotNull(message = "创建时间不可为空")
    @ApiModelProperty(value = "创建时间", required = true)
    protected java.util.Date    createDate;
    
    /**修改时间*/
    @ApiModelProperty(value = "修改时间")
    protected java.util.Date    updateDate;
    
    public Long getUnid()
    {
        return unid;
    }
    
    public void setUnid(Long unid)
    {
        this.unid = unid;
    }
    
    public String getAccountType()
    {
        return accountType;
    }
    
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }
    
    public String getAccountName()
    {
        return accountName;
    }
    
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }
    
    public String getCertificateType()
    {
        return certificateType;
    }
    
    public void setCertificateType(String certificateType)
    {
        this.certificateType = certificateType;
    }
    
    public String getCertificateNumber()
    {
        return certificateNumber;
    }
    
    public void setCertificateNumber(String certificateNumber)
    {
        this.certificateNumber = certificateNumber;
    }
    
    public Integer getDateBirth()
    {
        return dateBirth;
    }
    
    public void setDateBirth(Integer dateBirth)
    {
        this.dateBirth = dateBirth;
    }
    
    public String getContactNumber()
    {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }
    
    public String getMobilePhone()
    {
        return mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getPostCode()
    {
        return postCode;
    }
    
    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }
    
    public String getContactAddress()
    {
        return contactAddress;
    }
    
    public void setContactAddress(String contactAddress)
    {
        this.contactAddress = contactAddress;
    }
    
    public String getFrontSideIDPhoto()
    {
        return frontSideIDPhoto;
    }
    
    public void setFrontSideIDPhoto(String frontSideIDPhoto)
    {
        this.frontSideIDPhoto = frontSideIDPhoto;
    }
    
    public String getBackSideIDPhoto()
    {
        return backSideIDPhoto;
    }
    
    public void setBackSideIDPhoto(String backSideIDPhoto)
    {
        this.backSideIDPhoto = backSideIDPhoto;
    }
    
    public String getHandWithIDPhoto()
    {
        return handWithIDPhoto;
    }
    
    public void setHandWithIDPhoto(String handWithIDPhoto)
    {
        this.handWithIDPhoto = handWithIDPhoto;
    }
    
    public String getRiskLevel()
    {
        return riskLevel;
    }
    
    public void setRiskLevel(String riskLevel)
    {
        this.riskLevel = riskLevel;
    }
    
    public String getLang()
    {
        return lang;
    }
    
    public void setLang(String lang)
    {
        this.lang = lang;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public void setCountry(String country)
    {
        this.country = country;
    }
    
    public String getProvince()
    {
        return province;
    }
    
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getDistrict()
    {
        return district;
    }
    
    public void setDistrict(String district)
    {
        this.district = district;
    }
    
    public Date getOpenAccountTime()
    {
        return openAccountTime;
    }
    
    public void setOpenAccountTime(Date openAccountTime)
    {
        this.openAccountTime = openAccountTime;
    }
    
    public Date getCloseAccountTime()
    {
        return closeAccountTime;
    }
    
    public void setCloseAccountTime(Date closeAccountTime)
    {
        this.closeAccountTime = closeAccountTime;
    }
    
    public String getLoginPwd()
    {
        return loginPwd;
    }
    
    public void setLoginPwd(String loginPwd)
    {
        this.loginPwd = loginPwd;
    }
    
    public String getFundPwd()
    {
        return fundPwd;
    }
    
    public void setFundPwd(String fundPwd)
    {
        this.fundPwd = fundPwd;
    }
    
    public String getCompanyLicenseCode()
    {
        return companyLicenseCode;
    }
    
    public void setCompanyLicenseCode(String companyLicenseCode)
    {
        this.companyLicenseCode = companyLicenseCode;
    }
    
    public String getCompanyLicensePhoto()
    {
        return companyLicensePhoto;
    }
    
    public void setCompanyLicensePhoto(String companyLicensePhoto)
    {
        this.companyLicensePhoto = companyLicensePhoto;
    }
    
    public String getOperatorName()
    {
        return operatorName;
    }
    
    public void setOperatorName(String operatorName)
    {
        this.operatorName = operatorName;
    }
    
    public String getOperatorCertificateType()
    {
        return operatorCertificateType;
    }
    
    public void setOperatorCertificateType(String operatorCertificateType)
    {
        this.operatorCertificateType = operatorCertificateType;
    }
    
    public String getOperatorCertificateNumber()
    {
        return operatorCertificateNumber;
    }
    
    public void setOperatorCertificateNumber(String operatorCertificateNumber)
    {
        this.operatorCertificateNumber = operatorCertificateNumber;
    }
    
    public String getOperatorFrontSideIDPhoto()
    {
        return operatorFrontSideIDPhoto;
    }
    
    public void setOperatorFrontSideIDPhoto(String operatorFrontSideIDPhoto)
    {
        this.operatorFrontSideIDPhoto = operatorFrontSideIDPhoto;
    }
    
    public String getOperatorBackSideIDPhoto()
    {
        return operatorBackSideIDPhoto;
    }
    
    public void setOperatorBackSideIDPhoto(String operatorBackSideIDPhoto)
    {
        this.operatorBackSideIDPhoto = operatorBackSideIDPhoto;
    }
    
    public String getOperatorContactNumber()
    {
        return operatorContactNumber;
    }
    
    public void setOperatorContactNumber(String operatorContactNumber)
    {
        this.operatorContactNumber = operatorContactNumber;
    }
    
    public String getOperatorMobilePhone()
    {
        return operatorMobilePhone;
    }
    
    public void setOperatorMobilePhone(String operatorMobilePhone)
    {
        this.operatorMobilePhone = operatorMobilePhone;
    }
    
    public Long getSalesBrokerId()
    {
        return salesBrokerId;
    }
    
    public void setSalesBrokerId(Long salesBrokerId)
    {
        this.salesBrokerId = salesBrokerId;
    }
    
    public Long getBelongOrgId()
    {
        return belongOrgId;
    }
    
    public void setBelongOrgId(Long belongOrgId)
    {
        this.belongOrgId = belongOrgId;
    }
    
    public String getAccountStatus()
    {
        return accountStatus;
    }
    
    public void setAccountStatus(String accountStatus)
    {
        this.accountStatus = accountStatus;
    }
    
    public String getRemark()
    {
        return remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    
    public Date getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
    
    public Date getUpdateDate()
    {
        return updateDate;
    }
    
    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
    }
}
