/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.account.model;

import com.uams.orm.core.GenericEntity;
import com.uams.rpc.account.entity.AccountEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
public class AccountModel extends AccountEntity
{
    private static final long serialVersionUID = 1L;
    
    /**经纪人姓名*/
    private String            salesBrokerName;
    
    /**所属机构*/
    private String            belongOrgName;
    
    public String getSalesBrokerName()
    {
        return salesBrokerName;
    }
    
    public void setSalesBrokerName(String salesBrokerName)
    {
        this.salesBrokerName = salesBrokerName;
    }
    
    public String getBelongOrgName()
    {
        return belongOrgName;
    }
    
    public void setBelongOrgName(String belongOrgName)
    {
        this.belongOrgName = belongOrgName;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AccountModel{");
        sb.append("id=").append(id);
        sb.append(", salesBrokerName='").append(salesBrokerName).append('\'');
        sb.append(", unid=").append(unid);
        sb.append(", accountType='").append(accountType).append('\'');
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", certificateType='").append(certificateType).append('\'');
        sb.append(", certificateNumber='").append(certificateNumber).append('\'');
        sb.append(", dateBirth=").append(dateBirth);
        sb.append(", contactNumber='").append(contactNumber).append('\'');
        sb.append(", mobilePhone='").append(mobilePhone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", postCode='").append(postCode).append('\'');
        sb.append(", contactAddress='").append(contactAddress).append('\'');
        sb.append(", frontSideIDPhoto='").append(frontSideIDPhoto).append('\'');
        sb.append(", backSideIDPhoto='").append(backSideIDPhoto).append('\'');
        sb.append(", handWithIDPhoto='").append(handWithIDPhoto).append('\'');
        sb.append(", riskLevel='").append(riskLevel).append('\'');
        sb.append(", lang='").append(lang).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", province='").append(province).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", openAccountTime=").append(openAccountTime);
        sb.append(", closeAccountTime=").append(closeAccountTime);
        sb.append(", loginPwd='").append(loginPwd).append('\'');
        sb.append(", fundPwd='").append(fundPwd).append('\'');
        sb.append(", companyLicenseCode='").append(companyLicenseCode).append('\'');
        sb.append(", companyLicensePhoto='").append(companyLicensePhoto).append('\'');
        sb.append(", operatorName='").append(operatorName).append('\'');
        sb.append(", operatorCertificateType='").append(operatorCertificateType).append('\'');
        sb.append(", operatorCertificateNumber='").append(operatorCertificateNumber).append('\'');
        sb.append(", operatorFrontSideIDPhoto='").append(operatorFrontSideIDPhoto).append('\'');
        sb.append(", operatorBackSideIDPhoto='").append(operatorBackSideIDPhoto).append('\'');
        sb.append(", operatorContactNumber='").append(operatorContactNumber).append('\'');
        sb.append(", operatorMobilePhone='").append(operatorMobilePhone).append('\'');
        sb.append(", salesBrokerId=").append(salesBrokerId);
        sb.append(", belongOrgId=").append(belongOrgId);
        sb.append(", accountStatus='").append(accountStatus).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
