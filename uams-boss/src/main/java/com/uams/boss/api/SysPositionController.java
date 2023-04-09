/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.api;

import com.uams.rpc.api.model.SysPositionModel;
import com.uams.rpc.api.service.SysPositionService;
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

/**
 * 平台期货持仓信息表onRspQryPosition 控制器
 * <p>File：SysPositionController.java </p>
 * <p>Title: SysPositionController </p>
 * <p>Description:SysPositionController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/api/sysPosition")
@Api(description = "平台期货持仓信息表onRspQryPosition")
public class SysPositionController extends GenericController
{
    @Autowired(required = false)
    private SysPositionService sysPositionService;


    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:apiSysPosition:index")
    public String list() throws BusinessException
    {
        return "boss/api/sysPosition/list";
    }

    /**
     * 操作平台期货持仓信息表onRspQryPosition
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存平台期货持仓信息表onRspQryPosition", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute SysPositionModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        sysPositionService.save(info);
        return json;
    }

    /**
     * 查询平台期货持仓信息表onRspQryPosition
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:apiSysPosition:data")
    @ApiOperation(value = "查询平台期货持仓信息表onRspQryPosition", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute SysPositionModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<SysPositionModel> result = sysPositionService.search(pagin,entity);
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
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组",paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        sysPositionService.deleteBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
