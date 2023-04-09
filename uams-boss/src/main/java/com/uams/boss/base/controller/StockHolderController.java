/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.base.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.base.model.FutureInfoModel;
import com.uams.rpc.base.model.StockHolderModel;
import com.uams.rpc.base.service.StockHolderService;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.bean.PaginateResult;
import com.uams.tools.bean.Pagination;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
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
import java.util.List;

/**
 * 代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表) 控制器
 * <p>File：StockHolderController.java </p>
 * <p>Title: StockHolderController </p>
 * <p>Description:StockHolderController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/base/stockHolder")
@Api(description = "代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表)")
public class StockHolderController extends GenericController
{
    @Autowired(required = false)
    private StockHolderService stockHolderService;

    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:basestockHolder:index")
    public String list() throws BusinessException
    {
        return "boss/base/stockHolder/list";
    }

    /**
     * 编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:basestockHolder:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/base/stockHolder/modify");
        StockHolderModel model = new StockHolderModel();
        if (null != id)
        {
            model = stockHolderService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }

    /**
     * 操作代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表)
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:basestockHolder:operator")
    @ApiOperation(value = "保存代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表)", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute StockHolderModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setUpdateDate(new Date());
        stockHolderService.save(info);
        return json;
    }

    /**
     * 查询代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表)
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:basestockHolder:data")
    @ApiOperation(value = "查询代理公司在期货公司开设的交易帐号信息等设置表(证券股东信息表)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute StockHolderModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<StockHolderModel> result = stockHolderService.search(pagin,entity);
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

    @RequiresPermissions("system:setting:basestockHolder:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组",paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        stockHolderService.removeBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }

    /**
     * 查询股东查询表（全部）
     */
    @ResponseBody
    @RequestMapping(value = "/all")
    @RequiresPermissions("system:setting:basestockHolder:data")
    @ApiOperation(value = "股东信息查询表",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StockHolderModel> allData() throws BusinessException
    {
        List<StockHolderModel> result = stockHolderService.selectAll();
        return result;
    }
}
