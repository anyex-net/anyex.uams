/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.base.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.base.model.MarketTradeDayModel;
import com.uams.rpc.base.service.FutureKindService;
import com.uams.rpc.base.service.MarketInfoService;
import com.uams.rpc.base.service.MarketTradeDayService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 市场交易日表 控制器
 * <p>File：MarketTradeDayController.java </p>
 * <p>Title: MarketTradeDayController </p>
 * <p>Description:MarketTradeDayController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/base/marketTradeDay")
@Api(description = "市场交易日表")
public class MarketTradeDayController extends GenericController
{
    @Autowired(required = false)
    private MarketTradeDayService marketTradeDayService;

    
    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:basemarketTradeDay:index")
    public String list() throws BusinessException
    {
        return "boss/base/marketTradeDay/list";
    }

    /**
     * 编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:basemarketTradeDay:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/base/marketTradeDay/modify");
        MarketTradeDayModel model = new MarketTradeDayModel();
        if (null != id)
        {
            model = marketTradeDayService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }
    
    /**
     * 操作市场交易日表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:basemarketTradeDay:operator")
    @ApiOperation(value = "保存市场交易日表")
    public JsonMessage save( MarketTradeDayModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setUpdateDate(new Date());
        marketTradeDayService.save(info);
        return json;
    }
    
    /**
     * 查询市场交易日表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data")
    @RequiresPermissions("system:setting:basemarketTradeDay:data")
    @ApiOperation(value = "查询市场交易日表", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data( MarketTradeDayModel entity,  Pagination pagin) throws BusinessException
    {
        PaginateResult<MarketTradeDayModel> result = marketTradeDayService.search(pagin, entity);
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
    @RequiresPermissions("system:setting:basemarketTradeDay:operator")
    @ApiOperation(value = "根据指定ID删除")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组", paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        marketTradeDayService.removeBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
