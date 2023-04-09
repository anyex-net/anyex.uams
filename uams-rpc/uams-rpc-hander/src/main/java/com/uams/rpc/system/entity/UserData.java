/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.system.entity;

import javax.validation.constraints.NotNull;

import com.uams.orm.core.GenericEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 数据权限信息 实体对象
 * <p>File：UserData.java</p>
 * <p>Title: UserData</p>
 * <p>Description:UserData</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "数据权限信息")
public class UserData extends GenericEntity
{
    private static final long serialVersionUID = 1L;
    
    /**用户ID*/
    @NotNull(message = "用户ID不可为空")
    @ApiModelProperty(value = "用户ID", required = true)
    private Long              userId;
    
    /**机构ID*/
    @NotNull(message = "机构ID不可为空")
    @ApiModelProperty(value = "机构ID", required = true)
    private Long              orgId;
    
    public Long getUserId()
    {
        return this.userId;
    }
    
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
    
    public Long getOrgId()
    {
        return this.orgId;
    }
    
    public void setOrgId(Long orgId)
    {
        this.orgId = orgId;
    }
}
