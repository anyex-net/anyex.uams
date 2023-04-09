/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.model;

import com.uams.rpc.base.entity.MarketInfoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

/**
 * 交易市场信息表 实体对象
 * <p>File：MarketInfo.java</p>
 * <p>Title: MarketInfo</p>
 * <p>Description:MarketInfo</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "交易市场信息表")
public class MarketInfoModel extends MarketInfoEntity
{
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("MarketInfoModel{");
        sb.append("id=").append(id);
        sb.append(", marketCode='").append(marketCode).append('\'');
        sb.append(", marketName='").append(marketName).append('\'');
        sb.append(", marketFullName='").append(marketFullName).append('\'');
        sb.append(", isStop=").append(isStop);
        sb.append(", exchangeCode='").append(exchangeCode).append('\'');
        sb.append(", countryNo='").append(countryNo).append('\'');
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
