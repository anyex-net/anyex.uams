/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.model;

import com.uams.rpc.base.entity.FutureKindEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

/**
 * 期货品种表 实体对象
 * <p>File：FutureKind.java</p>
 * <p>Title: FutureKind</p>
 * <p>Description:FutureKind</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "期货品种表")
public class FutureKindModel extends FutureKindEntity
{
    /** 交易市场*/
    private String marketName;
    
    public String getMarketName()
    {
        return marketName;
    }
    
    public void setMarketName(String marketName)
    {
        this.marketName = marketName;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("FutureKindModel{");
        sb.append("id=").append(id);
        sb.append(", marketName='").append(marketName).append('\'');
        sb.append(", marketId=").append(marketId);
        sb.append(", kindCode='").append(kindCode).append('\'');
        sb.append(", kindName='").append(kindName).append('\'');
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
