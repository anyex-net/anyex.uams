/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

/**
 * 经纪商信息表(券商期货公司) 实体对象
 * <p>File：BrokerInfo.java</p>
 * <p>Title: BrokerInfo</p>
 * <p>Description:BrokerInfo</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "经纪商信息表(券商期货公司)")
public class BrokerInfoEntity extends GenericEntity
{
    protected static final long serialVersionUID = 1L;
    
    /**经纪商代码*/
    @NotNull(message = "经纪商代码不可为空")
    @ApiModelProperty(value = "经纪商代码", required = true)
    protected String            brokerCode;
    
    /**经纪商名称*/
    @NotNull(message = "经纪商名称不可为空")
    @ApiModelProperty(value = "经纪商名称", required = true)
    protected String            brokerName;
    
    /**更新时间*/
    @NotNull(message = "更新时间不可为空")
    @ApiModelProperty(value = "更新时间", required = true)
    protected java.util.Date    updateDate;
    
    public String getBrokerCode()
    {
        return this.brokerCode;
    }
    
    public void setBrokerCode(String brokerCode)
    {
        this.brokerCode = brokerCode;
    }
    
    public String getBrokerName()
    {
        return this.brokerName;
    }
    
    public void setBrokerName(String brokerName)
    {
        this.brokerName = brokerName;
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
