/*
 * @(#)StringEditorSupport.java 2014-6-14 下午4:28:04
 * Copyright 2014 Playguy, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.tools.editor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>File：StringEditorSupport.java</p>
 * <p>Title: 字符串型参数处理</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2014 2014-6-14 下午4:28:04</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class StringEditorSupport extends PropertyEditorSupport
{
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        if (StringUtils.isNotBlank(text))
        {
            setValue(StringEscapeUtils.escapeHtml4(text));
            return;
        }
        setValue(null);
    }
    
    @Override
    public String getAsText()
    {
        String value = (String) getValue();
        return (value != null) ? value.toString() : null;
    }
}
