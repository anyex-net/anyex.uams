/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.quotation.controller;

import com.uams.rpc.quotation.model.QuotationModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.uams.orm.core.GenericController;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.bean.PaginateResult;
import com.uams.tools.bean.Pagination;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.rpc.quotation.service.QuotationService;


/**
 * 外部实时行情表 控制器
 * <p>File：QuotationController.java </p>
 * <p>Title: QuotationController </p>
 * <p>Description:QuotationController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/quotation/quotation")
@Api(description = "外部实时行情表")
public class QuotationController extends GenericController
{
    @Autowired(required = false)
    private QuotationService quotationService;



    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:quotationQuotation:index")
    public String list() throws BusinessException
    {
        return "boss/quotation/quotation/list";
    }

    /**
     * 查询外部实时行情表
     * @param id
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/view")
    @ApiOperation(value = "按ID查询单条数据")
    public JsonMessage save(Long id ) throws BusinessException
    {
        QuotationModel model = quotationService.selectByPrimaryKey(id);
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS,model);
        return json;
    }

    /**
     * 查询外部实时行情表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data")
    @RequiresPermissions("system:setting:quotationQuotation:data")
    @ApiOperation(value = "查询外部实时行情表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute QuotationModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<QuotationModel> result = quotationService.search(pagin,entity);
        return getJsonMessage(CommonEnums.SUCCESS, result);
    }
}
