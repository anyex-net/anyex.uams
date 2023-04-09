/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.quotation.mapper;

import com.uams.orm.core.GenericMapper;
import com.uams.orm.annotation.MyBatisDao ;
import com.uams.rpc.quotation.model.QuotationModel;

/**
 * 外部实时行情表 持久层接口
 * <p>File：QuotationMapper.java </p>
 * <p>Title: QuotationMapper </p>
 * <p>Description:QuotationMapper </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface QuotationMapper extends GenericMapper<QuotationModel>
{

}
