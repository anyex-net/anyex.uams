/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.fund.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.fund.model.AccountAssetModel;
import com.uams.rpc.fund.service.AccountAssetService;
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


/**
 * 账户持仓表 控制器
 * <p>File：AccountAssetController.java </p>
 * <p>Title: AccountAssetController </p>
 * <p>Description:AccountAssetController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/fund/accountAsset")
@Api(description = "账户持仓表")
public class AccountAssetController extends GenericController
{
    @Autowired(required = false)
    private AccountAssetService accountAssetService;

    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:fundAccountAsset:index")
    public String list() throws BusinessException
    {
        return "boss/fund/accountAsset/list";
    }

    /**
     * 操作账户持仓表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存账户持仓表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute AccountAssetModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        accountAssetService.save(info);
        return json;
    }

    /**
     * 查询账户持仓表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data")
    @RequiresPermissions("system:setting:fundAccountAsset:operator")
    @ApiOperation(value = "查询账户持仓表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute AccountAssetModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<AccountAssetModel> result = accountAssetService.search(pagin,entity);
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
        accountAssetService.deleteBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
