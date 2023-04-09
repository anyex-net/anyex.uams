/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.api;

import com.uams.rpc.api.model.SysAccountMarginRentModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
import com.uams.rpc.api.service.SysAccountMarginRentService;


/**
 * 平台资金账户保证金信息表 控制器
 * <p>File：SysAccountMarginRentController.java </p>
 * <p>Title: SysAccountMarginRentController </p>
 * <p>Description:SysAccountMarginRentController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/api/sysAccountMarginRent")
@Api(description = "平台资金账户保证金信息表")
public class SysAccountMarginRentController extends GenericController
{
    @Autowired(required = false)
    private SysAccountMarginRentService sysAccountMarginRentService;

    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:apiSysAccountMarginRent:index")
    public String list() throws BusinessException
    {
        return "boss/api/sysAccountMarginRent/list";
    }

    /**
     * 操作平台资金账户保证金信息表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:apiSysAccountMarginRent:operator")
    @ApiOperation(value = "保存平台资金账户保证金信息表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute SysAccountMarginRentModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        sysAccountMarginRentService.save(info);
        return json;
    }

    /**
     * 查询平台资金账户保证金信息表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:apiSysAccountMarginRent:data")
    @ApiOperation(value = "查询平台资金账户保证金信息表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute SysAccountMarginRentModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<SysAccountMarginRentModel> result = sysAccountMarginRentService.search(pagin,entity);
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
    @RequiresPermissions("system:setting:apiSysAccountMarginRent:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组",paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        sysAccountMarginRentService.deleteBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
