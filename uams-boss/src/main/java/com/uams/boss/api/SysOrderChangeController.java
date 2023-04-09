/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.api;

import com.uams.rpc.api.model.SysOrderChangeModel;
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
import com.uams.rpc.api.service.SysOrderChangeService;


/**
 * 平台委托变化记录表 控制器
 * <p>File：SysOrderChangeController.java </p>
 * <p>Title: SysOrderChangeController </p>
 * <p>Description:SysOrderChangeController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/api/sysOrderChange")
@Api(description = "平台委托变化记录表")
public class SysOrderChangeController extends GenericController
{
    @Autowired(required = false)
    private SysOrderChangeService sysOrderChangeService;

    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:sysOrderChange:index")
    public String list() throws BusinessException
    {
        return "boss/api/sysOrderChange/list";
    }

    /**
     * 操作平台委托变化记录表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:sysOrderChange:operator")
    @ApiOperation(value = "保存平台委托变化记录表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute SysOrderChangeModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        sysOrderChangeService.save(info);
        return json;
    }

    /**
     * 查询平台委托变化记录表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:sysOrderChange:data")
    @ApiOperation(value = "查询平台委托变化记录表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute SysOrderChangeModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<SysOrderChangeModel> result = sysOrderChangeService.search(pagin,entity);
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
        sysOrderChangeService.deleteBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
