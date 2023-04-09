/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.common.entity;

import javax.validation.constraints.NotNull;

import com.uams.orm.core.GenericEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * FeedBack 实体对象
 * <p>File：FeedBack.java</p>
 * <p>Title: FeedBack</p>
 * <p>Description:FeedBack</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "FeedBack")
public class FeedBack extends GenericEntity
{
    private static final long serialVersionUID = 1L;
    
    /**帐户编号*/
    @NotNull(message = "帐户编号不可为空")
    @ApiModelProperty(value = "帐户编号", required = true)
    private Long              accountId;
    
    /**反馈内容*/
    @NotNull(message = "反馈内容不可为空")
    @ApiModelProperty(value = "反馈内容", required = true)
    private String            note;
    
    /**设备信息*/
    @ApiModelProperty(value = "设备信息")
    private String            ext;
    
    /**创建时间*/
    @NotNull(message = "创建时间不可为空")
    @ApiModelProperty(value = "创建时间", required = true)
    private Long              createDate;
    
    public FeedBack()
    {
    }
    
    public FeedBack(Long accountId)
    {
        this.accountId = accountId;
    }
    
    public Long getAccountId()
    {
        return this.accountId;
    }
    
    public void setAccountId(Long accountId)
    {
        this.accountId = accountId;
    }
    
    public String getNote()
    {
        return this.note;
    }
    
    public void setNote(String note)
    {
        this.note = note;
    }
    
    public String getExt()
    {
        return this.ext;
    }
    
    public void setExt(String ext)
    {
        this.ext = ext;
    }
    
    public Long getCreateDate()
    {
        return this.createDate;
    }
    
    public void setCreateDate(Long createDate)
    {
        this.createDate = createDate;
    }
}
