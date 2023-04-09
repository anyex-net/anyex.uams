/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.base.model;

import com.uams.rpc.base.entity.OrgTradeFeeCfgEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;

/**
 * 各分支机构品种交易费率配置表 实体对象
 * <p>File：OrgTradeFeeCfg.java</p>
 * <p>Title: OrgTradeFeeCfg</p>
 * <p>Description:OrgTradeFeeCfg</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "各分支机构品种交易费率配置表")
public class OrgTradeFeeCfgModel extends OrgTradeFeeCfgEntity
{
    /** 机构名称 */
    private String orgName;
    
    /** 期货品种名称*/
    private String kindName;
    
    /** 交易市场简称*/
    private String marketName;
    
    public String getOrgName()
    {
        return orgName;
    }
    
    public void setOrgName(String orgName)
    {
        this.orgName = orgName;
    }
    
    public String getKindName()
    {
        return kindName;
    }
    
    public void setKindName(String kindName)
    {
        this.kindName = kindName;
    }
    
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
        final StringBuilder sb = new StringBuilder("OrgTradeFeeCfgModel{");
        sb.append("id=").append(id);
        sb.append(", orgName='").append(orgName).append('\'');
        sb.append(", kindName='").append(kindName).append('\'');
        sb.append(", marketName='").append(marketName).append('\'');
        sb.append(", orgId=").append(orgId);
        sb.append(", marketId=").append(marketId);
        sb.append(", futureKindId=").append(futureKindId);
        sb.append(", feeType='").append(feeType).append('\'');
        sb.append(", feeRateType='").append(feeRateType).append('\'');
        sb.append(", feeRate='").append(feeRate).append('\'');
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
