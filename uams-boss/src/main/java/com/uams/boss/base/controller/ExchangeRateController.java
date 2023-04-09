/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.base.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.base.model.ExchangeRateModel;
import com.uams.rpc.base.service.ExchangeRateService;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.bean.PaginateResult;
import com.uams.tools.bean.Pagination;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 汇率表 控制器
 * <p>File：ExchangeRateController.java </p>
 * <p>Title: ExchangeRateController </p>
 * <p>Description:ExchangeRateController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/base/exchangeRate")
@Api(description = "汇率表")
public class ExchangeRateController extends GenericController
{
    @Autowired(required = false)
    private ExchangeRateService exchangeRateService;
    
    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:baseexchangeRate:index")
    public String list() throws BusinessException
    {
        return "boss/base/exchangeRate/list";
    }

    /**
     * 编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:baseexchangeRate:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/base/exchangeRate/modify");
        ExchangeRateModel model = new ExchangeRateModel();
        if (null != id)
        {
            model = exchangeRateService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }
    
    /**
     * 操作汇率表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:baseexchangeRate:operator")
    @ApiOperation(value = "保存汇率表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute ExchangeRateModel info,String date) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setUpdateDate(new Date());
        info.setExchangDate(DateUtils.parseDate(date));
        exchangeRateService.save(info);
        return json;
    }
    
    /**
     * 查询汇率表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data")
    @RequiresPermissions("system:setting:baseexchangeRate:data")
    @ApiOperation(value = "查询汇率表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute ExchangeRateModel entity,String date, @ModelAttribute Pagination pagin) throws BusinessException
    {
        entity.setExchangDate(DateUtils.parseDate(date));
        PaginateResult<ExchangeRateModel> result = exchangeRateService.search(pagin, entity);
        return getJsonMessage(CommonEnums.SUCCESS, result);
    }
    
    /**
     * 根据指定ID删除
     * @param ids
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:baseexchangeRate:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组", paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        exchangeRateService.removeBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
