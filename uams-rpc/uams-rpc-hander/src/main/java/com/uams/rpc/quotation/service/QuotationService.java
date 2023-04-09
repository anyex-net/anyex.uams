/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.quotation.service;

import com.uams.orm.core.GenericService;
import com.uams.rpc.quotation.model.QuotationModel;
import com.uams.tools.exception.BusinessException;

/**
 * 外部实时行情表 服务接口
 * <p>File：QuotationService.java </p>
 * <p>Title: QuotationService </p>
 * <p>Description:QuotationService </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
public interface QuotationService extends GenericService<QuotationModel>{

    /**
     * 根据外部接口入库行情信息
     * @param quotationModel
     */
    int saveRtnQuote(QuotationModel quotationModel) throws BusinessException;

}
