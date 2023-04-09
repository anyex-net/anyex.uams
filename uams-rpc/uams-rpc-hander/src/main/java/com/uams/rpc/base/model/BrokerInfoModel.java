/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.model;

import com.uams.rpc.base.entity.BrokerInfoEntity;
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
public class BrokerInfoModel extends BrokerInfoEntity
{
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("BrokerInfoModel{");
        sb.append("id=").append(id);
        sb.append(", brokerCode='").append(brokerCode).append('\'');
        sb.append(", brokerName='").append(brokerName).append('\'');
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
