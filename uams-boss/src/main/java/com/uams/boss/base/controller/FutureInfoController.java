/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.base.controller;

import com.uams.esunny.quote.QueryContractAPI;
import com.uams.orm.core.GenericController;
import com.uams.rpc.base.model.FutureInfoModel;
import com.uams.rpc.base.service.FutureInfoService;
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
 * 期货信息表 控制器
 * <p>File：FutureInfoController.java </p>
 * <p>Title: FutureInfoController </p>
 * <p>Description:FutureInfoController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/base/futureInfo")
@Api(description = "期货信息表")
public class FutureInfoController extends GenericController
{
    @Autowired(required = false)
    private FutureInfoService futureInfoService;

    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:basefutureInfo:index")
    public String list() throws BusinessException
    {
        //new QueryContractAPI();
        return "boss/base/futureInfo/list";
    }

    /**
     *编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:basefutureInfo:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/base/futureInfo/modify");
        FutureInfoModel model = new FutureInfoModel();
        if (null != id)
        {
            model = futureInfoService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }

    /**
     * 操作期货信息表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:basefutureInfo:operator")
    @ApiOperation(value = "保存期货信息表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute FutureInfoModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setUpdateDate(new Date());
        futureInfoService.save(info);
        return json;
    }

    /**
     * 查询期货信息表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:basefutureInfo:operator")
    @ApiOperation(value = "查询期货信息表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute FutureInfoModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<FutureInfoModel> result = futureInfoService.search(pagin,entity);
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
    @RequiresPermissions("system:setting:basefutureInfo:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组",paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        futureInfoService.removeBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }

    /**
     * 查询货期品种表（全部）
     */
    @ResponseBody
    @RequestMapping(value = "/all")
    @RequiresPermissions("system:setting:basefutureInfo:data")
    @ApiOperation(value = "查询货期品种信息表",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FutureInfoModel> allData() throws BusinessException
    {
        List<FutureInfoModel> result = futureInfoService.selectAll();
        return result;
    }
}
