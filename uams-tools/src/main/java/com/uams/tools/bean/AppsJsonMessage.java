/*
 * @(#)JsonMessage.java 2014-4-17 下午4:04:43
 * Copyright 2014 Playguy, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.tools.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>File：JsonMessage.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2014 2014-4-17 下午4:04:43</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "JSON返回对象")
public class AppsJsonMessage implements Serializable
{
    //
    private static final long serialVersionUID = 714679657596837388L;

    @ApiModelProperty(value = "编码")
    private Integer           code;

    @ApiModelProperty(value = "消息")
    private String            message;

    @ApiModelProperty(value = "对象")
    private Object            data;

    public AppsJsonMessage()
    {
    }

    public AppsJsonMessage(EnumDescribable enumDescribable)
    {
        this.code = enumDescribable.getCode();
        this.message = enumDescribable.getMessage();
    }

    public AppsJsonMessage(EnumDescribable enumDescribable, Object data)
    {
        this.data = data;
        this.code = enumDescribable.getCode();
        this.message = enumDescribable.getMessage();
    }

    public AppsJsonMessage(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }
    
    public Integer getCode()
    {
        return code;
    }
    
    public void setCode(Integer code)
    {
        this.code = code;
    }
    
    public String getMessage()
    {
        return message;
    }
    
    public void setMessage(String message)
    {
        this.message = message;
    }
    
    public Object getData()
    {
        return data;
    }
    
    public void setData(Object data)
    {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AppsJsonMessage{");
        sb.append("code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}