/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.base.controller;

import com.uams.rpc.base.model.OrgTradeFeeCfgModel;
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
import com.uams.rpc.base.service.OrgTradeFeeCfgService;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


/**
 * 各分支机构品种交易费率配置表 控制器
 * <p>File：OrgTradeFeeCfgController.java </p>
 * <p>Title: OrgTradeFeeCfgController </p>
 * <p>Description:OrgTradeFeeCfgController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/base/orgTradeFeeCfg")
@Api(description = "各分支机构品种交易费率配置表")
public class OrgTradeFeeCfgController extends GenericController
{
    @Autowired(required = false)
    private OrgTradeFeeCfgService orgTradeFeeCfgService;


    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:baseorgTradeFeeCfg:index")
    public String list() throws BusinessException
    {
        return "boss/base/orgTradeFeeCfg/list";
    }


    /**
     *编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:baseorgTradeFeeCfg:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/base/orgTradeFeeCfg/modify");
        OrgTradeFeeCfgModel model = new OrgTradeFeeCfgModel();
        if (null != id)
        {
            model = orgTradeFeeCfgService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }

    /**
     * 操作各分支机构品种交易费率配置表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:baseorgTradeFeeCfg:operator")
    @ApiOperation(value = "保存各分支机构品种交易费率配置表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute OrgTradeFeeCfgModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setUpdateDate(new Date());
        orgTradeFeeCfgService.save(info);
        return json;
    }

    /**
     * 查询各分支机构品种交易费率配置表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    @RequiresPermissions("system:setting:baseorgTradeFeeCfg:data")
    @ApiOperation(value = "查询各分支机构品种交易费率配置表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute OrgTradeFeeCfgModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<OrgTradeFeeCfgModel> result = orgTradeFeeCfgService.search(pagin,entity);
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
    @RequiresPermissions("system:setting:baseorgTradeFeeCfg:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组",paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        orgTradeFeeCfgService.deleteBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
