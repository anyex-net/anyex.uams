/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.base.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.base.model.OrgTradeStockKindCfgModel;
import com.uams.rpc.base.service.OrgTradeStockKindCfgService;
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


/**
 * 各分支机构可交易各大交易所期货品种配置表 控制器
 * <p>File：OrgTradeStockKindCfgController.java </p>
 * <p>Title: OrgTradeStockKindCfgController </p>
 * <p>Description:OrgTradeStockKindCfgController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/base/orgTradeStockKindCfg")
@Api(description = "各分支机构可交易各大交易所期货品种配置表")
public class OrgTradeStockKindCfgController extends GenericController
{
    @Autowired(required = false)
    private OrgTradeStockKindCfgService orgTradeStockKindCfgService;

    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:baseorgTradeStockKindCfg:index")
    public String list() throws BusinessException
    {
        return "boss/base/orgTradeStockKindCfg/list";
    }

    /**
     * 编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:baseorgTradeStockKindCfg:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/base/orgTradeStockKindCfg/modify");
        OrgTradeStockKindCfgModel model = new OrgTradeStockKindCfgModel();
        if (null != id)
        {
            model = orgTradeStockKindCfgService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }

    /**
     * 操作各分支机构可交易各大交易所期货品种配置表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:baseorgTradeStockKindCfg:operator")
    @ApiOperation(value = "保存各分支机构可交易各大交易所期货品种配置表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute OrgTradeStockKindCfgModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setUpdateDate(new Date());
        orgTradeStockKindCfgService.save(info);
        return json;
    }

    /**
     * 查询各分支机构可交易各大交易所期货品种配置表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:baseorgTradeStockKindCfg:data")
    @ApiOperation(value = "查询各分支机构可交易各大交易所期货品种配置表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute OrgTradeStockKindCfgModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<OrgTradeStockKindCfgModel> result = orgTradeStockKindCfgService.search(pagin,entity);
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
    @RequiresPermissions("system:setting:baseorgTradeStockKindCfg:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组",paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        orgTradeStockKindCfgService.removeBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
