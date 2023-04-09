/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.model;

import com.uams.rpc.base.entity.ExchangeRateEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

/**
 * 汇率表 实体对象
 * <p>File：ExchangeRate.java</p>
 * <p>Title: ExchangeRate</p>
 * <p>Description:ExchangeRate</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "汇率表")
public class ExchangeRateModel extends ExchangeRateEntity
{
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ExchangeRateModel{");
        sb.append("id=").append(id);
        sb.append(", exchangDate=").append(exchangDate);
        sb.append(", currencySource='").append(currencySource).append('\'');
        sb.append(", currencyTarget='").append(currencyTarget).append('\'');
        sb.append(", buyPrice=").append(buyPrice);
        sb.append(", sellPrice=").append(sellPrice);
        sb.append(", midPrice=").append(midPrice);
        sb.append(", unitAmount=").append(unitAmount);
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
