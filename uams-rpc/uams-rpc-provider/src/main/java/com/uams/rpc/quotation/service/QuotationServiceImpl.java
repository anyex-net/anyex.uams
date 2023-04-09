/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.quotation.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.quotation.mapper.QuotationMapper;
import com.uams.rpc.quotation.model.QuotationModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 外部实时行情表 服务实现类
 * <p>File：QuotationServiceImpl.java </p>
 * <p>Title: QuotationServiceImpl </p>
 * <p>Description:QuotationServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class QuotationServiceImpl extends GenericServiceImpl<QuotationModel> implements QuotationService
{

    protected QuotationMapper quotationMapper;

    @Autowired
    public QuotationServiceImpl(QuotationMapper quotationMapper)
    {
        super(quotationMapper);
        this.quotationMapper = quotationMapper;
    }

    @Override
    public int saveRtnQuote(QuotationModel quotationModel) throws BusinessException {
        logger.debug("onRtnQuote解析交易信息...");
        if (quotationModel!= null) {
            logger.debug("quotationModel处理开始");
            logger.debug("quotationModel:"+quotationModel);
            quotationMapper.insert(quotationModel);
            logger.debug("quotationModel处理结束");
        }
        logger.debug("onRtnQuote解析交易信息结束");
        return 0;
    }
}
