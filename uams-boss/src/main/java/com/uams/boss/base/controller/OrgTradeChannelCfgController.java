/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.base.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.base.model.OrgTradeChannelCfgModel;
import com.uams.rpc.base.model.StockHolderModel;
import com.uams.rpc.base.service.OrgTradeChannelCfgService;
import com.uams.rpc.base.service.StockHolderService;
import com.uams.tools.bean.BusinessEnums;
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
 * 各分支机构期货交易所走期货公司通道配置表 控制器
 * <p>File：OrgTradeChannelCfgController.java </p>
 * <p>Title: OrgTradeChannelCfgController </p>
 * <p>Description:OrgTradeChannelCfgController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/base/orgTradeChannelCfg")
@Api(description = "各分支机构期货交易所走期货公司通道配置表")
public class OrgTradeChannelCfgController extends GenericController
{
    @Autowired(required = false)
    private OrgTradeChannelCfgService orgTradeChannelCfgService;

    @Autowired(required = false)
    private StockHolderService stockHolderService;

    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:baseorgTradeChannelCfg:index")
    public String list() throws BusinessException
    {
        return "boss/base/orgTradeChannelCfg/list";
    }

    /**
     *编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:baseorgTradeChannelCfg:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/base/orgTradeChannelCfg/modify");
        OrgTradeChannelCfgModel model = new OrgTradeChannelCfgModel();
        if (null != id)
        {
            model = orgTradeChannelCfgService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }



    /**
     * 操作各分支机构期货交易所走期货公司通道配置表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:baseorgTradeChannelCfg:operator")
    @ApiOperation(value = "保存各分支机构期货交易所走期货公司通道配置表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute OrgTradeChannelCfgModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);

        if (info.getStockHolderId()==null)
            //当对象为空当时候抛异常
            throw new BusinessException("股东信息为空") ;
            //根据股东ID查询对应的信息
        StockHolderModel stockHolderModel = stockHolderService.selectByPrimaryKey(info.getStockHolderId());
        if (stockHolderModel==null)
            throw new BusinessException("未找到对应当股东信息");
        info.setFundAccout(stockHolderModel.getFundAccout());
        info.setTradeAcount(stockHolderModel.getTradeAcount());
        info.setUpdateDate(new Date());
        orgTradeChannelCfgService.save(info);
        return json;
    }

    /**
     * 查询各分支机构期货交易所走期货公司通道配置表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:baseorgTradeChannelCfg:data")
    @ApiOperation(value = "查询各分支机构期货交易所走期货公司通道配置表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute OrgTradeChannelCfgModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<OrgTradeChannelCfgModel> result = orgTradeChannelCfgService.search(pagin,entity);
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
    @RequiresPermissions("system:setting:baseorgTradeChannelCfg:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组",paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        orgTradeChannelCfgService.removeBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
