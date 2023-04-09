/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.base.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.base.model.FutureKindModel;
import com.uams.rpc.base.service.FutureKindService;
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
 * 期货品种表 控制器
 * <p>File：FutureKindController.java </p>
 * <p>Title: FutureKindController </p>
 * <p>Description:FutureKindController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/base/futureKind")
@Api(description = "期货品种表")
public class FutureKindController extends GenericController
{
    @Autowired(required = false)
    private FutureKindService futureKindService;
    
    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:basefutureKind:index")
    public String list() throws BusinessException
    {
        return "boss/base/futureKind/list";
    }
    
    /**
     *编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:basefutureKind:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/base/futureKind/modify");
        FutureKindModel model = new FutureKindModel();
        if (null != id)
        {
            model = futureKindService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }
    
    /**
     * 操作期货品种表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:basefutureKind:operator")
    @ApiOperation(value = "保存期货品种表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute FutureKindModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setUpdateDate(new Date());
        futureKindService.save(info);
        return json;
    }
    
    /**
     * 查询期货品种表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data")
    @RequiresPermissions("system:setting:basefutureKind:data")
    @ApiOperation(value = "查询期货品种表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute FutureKindModel entity, @ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<FutureKindModel> result = futureKindService.search(pagin, entity);
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
    @RequiresPermissions("system:setting:basefutureKind:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组", paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        futureKindService.removeBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }


    /**
     * 查询货期品种表（全部）
     */
    @ResponseBody
    @RequestMapping(value = "/all")
    @RequiresPermissions("system:setting:basefutureKind:data")
    @ApiOperation(value = "查询货期品种信息表",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FutureKindModel> allData() throws BusinessException
    {
        List<FutureKindModel> result = futureKindService.selectAll();
        return result;
    }

}
