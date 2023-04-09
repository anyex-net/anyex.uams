/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.base.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.base.model.BrokerInfoModel;
import com.uams.rpc.base.service.BrokerInfoService;
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
 * 券商期货公司信息表 控制器
 * <p>File：BrokerInfoController.java </p>
 * <p>Title: BrokerInfoController </p>
 * <p>Description:BrokerInfoController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/base/brokerInfo")
@Api(description = "券商期货公司信息表")
public class BrokerInfoController extends GenericController
{
    @Autowired(required = false)
    private BrokerInfoService brokerInfoService;

    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:basebrokerInfo:index")
    public String list() throws BusinessException
    {
        return "boss/base/brokerInfo/list";
    }

    /**
     *编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:basebrokerInfo:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/base/brokerInfo/modify");
        BrokerInfoModel model = new BrokerInfoModel();
        if (null != id)
        {
            model = brokerInfoService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }

    /**
     * 操作券商期货公司信息表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存券商期货公司信息表", httpMethod = "POST")
    @RequiresPermissions("system:setting:basebrokerInfo:operator")
    public JsonMessage save(@ModelAttribute BrokerInfoModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setUpdateDate(new Date());
        brokerInfoService.save(info);
        return json;
    }

    /**
     * 查询券商期货公司信息表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:basebrokerInfo:data")
    @ApiOperation(value = "查询券商期货公司信息表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute BrokerInfoModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<BrokerInfoModel> result = brokerInfoService.search(pagin,entity);
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
    @RequiresPermissions("system:setting:basebrokerInfo:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组",paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        brokerInfoService.removeBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }

    /**
     * 查询经纪商息表（全部）
     */
    @ResponseBody
    @RequestMapping(value = "/all")
    @RequiresPermissions("system:setting:basebrokerInfo:data")
    @ApiOperation(value = "查询经纪商信息表",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BrokerInfoModel> allData() throws BusinessException
    {
        List<BrokerInfoModel> result = brokerInfoService.selectAll();
        return result;
    }

}
