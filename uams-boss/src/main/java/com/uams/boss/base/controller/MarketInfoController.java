/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.base.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.base.model.MarketInfoModel;
import com.uams.rpc.base.service.MarketInfoService;
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
 * 交易市场信息表 控制器
 * <p>File：MarketInfoController.java </p>
 * <p>Title: MarketInfoController </p>
 * <p>Description:MarketInfoController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/base/marketInfo")
@Api(description = "交易市场信息表")
public class MarketInfoController extends GenericController
{
    @Autowired(required = false)
    private MarketInfoService marketInfoService;
    
    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:basemarketInfo:index")
    public String list() throws BusinessException
    {
        return "boss/base/marketInfo/list";
    }
    
    /**
     *编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:basemarketInfo:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/base/marketInfo/modify");
        MarketInfoModel model = new MarketInfoModel();
        if (null != id)
        {
            model = marketInfoService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }
    
    /**
     * 操作交易市场信息表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:basemarketInfo:operator")
    @ApiOperation(value = "保存交易市场信息表")
    public JsonMessage save(@ModelAttribute MarketInfoModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setUpdateDate(new Date());
        marketInfoService.save(info);
        return json;
    }
    
    /**
     * 查询交易市场信息表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data")
    @RequiresPermissions("system:setting:basemarketInfo:data")
    @ApiOperation(value = "查询交易市场信息表",  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data( MarketInfoModel entity,  Pagination pagin) throws BusinessException
    {
        PaginateResult<MarketInfoModel> result = marketInfoService.search(pagin, entity);
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
    @RequiresPermissions("system:setting:basemarketInfo:operator")
    @ApiOperation(value = "根据指定ID删除")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组", paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        marketInfoService.removeBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }

    /**
     * 查询交易市场信息表（全部）
     */
    @ResponseBody
    @RequestMapping(value = "/all")
    @RequiresPermissions("system:setting:basemarketInfo:data")
    @ApiOperation(value = "查询交易市场信息表",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MarketInfoModel> allData() throws BusinessException
    {
        List<MarketInfoModel> result = marketInfoService.selectAll();
        return result;
    }
}
