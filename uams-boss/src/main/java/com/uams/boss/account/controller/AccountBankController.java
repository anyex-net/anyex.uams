/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.account.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.account.model.AccountBankModel;
import com.uams.rpc.account.model.AccountModel;
import com.uams.rpc.account.service.AccountBankService;
import com.uams.rpc.account.service.AccountService;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.bean.PaginateResult;
import com.uams.tools.bean.Pagination;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.Account;
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
 * 账户银行表 控制器
 * <p>File：AccountBankController.java </p>
 * <p>Title: AccountBankController </p>
 * <p>Description:AccountBankController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/account/accountBank")
@Api(description = "账户银行表")
public class AccountBankController extends GenericController
{
    @Autowired(required = false)
    private AccountBankService accountBankService;

    @Autowired(required = false)
    private AccountService     accountService;

    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:accountAccountBank:index")
    public String list() throws BusinessException
    {
        return "boss/account/accountBank/list";
    }

    /**
     *编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:accountAccountBank:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/account/accountBank/modify");
        AccountBankModel model = new AccountBankModel();
        if (null != id)
        {
            model = accountBankService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }

    /**
     * 操作账户银行表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:accountAccountBank:operator")
    @ApiOperation(value = "保存账户银行表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute AccountBankModel info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setCreateDate(new Date());
        AccountModel account = accountService.findByNameAndNormal(info.getAccountName());
        if (account == null)
        {
            throw new BusinessException("该用户不存在！");
        }
        info.setAccountId(account.getId());
        accountBankService.save(info);
        return json;
    }

    /**
     * 查询账户银行表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data")
    @RequiresPermissions("system:setting:accountAccountBank:data")
    @ApiOperation(value = "查询账户银行表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute AccountBankModel entity,@ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<AccountBankModel> result = accountBankService.search(pagin,entity);
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
    @RequiresPermissions("system:setting:accountAccountBank:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组",paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        accountBankService.removeBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
