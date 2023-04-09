/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.account.controller;

import com.uams.orm.core.GenericController;
import com.uams.orm.utils.EncryptUtils;
import com.uams.rpc.account.consts.AccountConsts;
import com.uams.rpc.account.model.AccountModel;
import com.uams.rpc.account.service.AccountService;
import com.uams.security.OnLineUserUtils;
import com.uams.security.shiro.model.UserPrincipal;
import com.uams.tools.annotation.CSRFToken;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.bean.PaginateResult;
import com.uams.tools.bean.Pagination;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.DateUtils;
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
 * 账户表 控制器
 * <p>File：AccountController.java </p>
 * <p>Title: AccountController </p>
 * <p>Description:AccountController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/account/account")
@Api(description = "账户表")
public class AccountController extends GenericController
{
    @Autowired(required = false)
    private AccountService accountService;
    
    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:accountAccount:index")
    public String list() throws BusinessException
    {
        return "boss/account/account/list";
    }
    
    /**
     *编辑界面
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:accountAccount:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/account/account/modify");
        AccountModel model = new AccountModel();
        if (null != id)
        {
            model = accountService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }
    
    /**
     * 操作账户表
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:accountAccount:operator")
    @ApiOperation(value = "保存账户表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute AccountModel info,String closeAccountTimeStr,String openAccountTimeStr) throws BusinessException
    {
        UserPrincipal principal = OnLineUserUtils.getPrincipal();
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        info.setCloseAccountTime(DateUtils.parseDate(closeAccountTimeStr));
        info.setOpenAccountTime(DateUtils.parseDate(openAccountTimeStr));
        if(info.getId()!=null)
        {
            info.setUpdateDate(new Date());
            AccountModel account = accountService.selectByPrimaryKey(info.getId());
            info.setLoginPwd(account.getLoginPwd());
            info.setFundPwd(account.getFundPwd());
            info.setCreateDate(account.getCreateDate());
            info.setUnid(account.getUnid());
        }
        else
        {
            info.setCreateDate(new Date());
            info.setUpdateDate(new Date());
            info.setLoginPwd(EncryptUtils.entryptPassword(info.getLoginPwd()));
            info.setFundPwd("");
            Long unidStart = 10000000L;
            Long unidNext = 1L;
            Long unid = accountService.getMaxUNID();
            if (null != unid)
            {
                unidNext += unid;
            }
            else
            {
                unidNext = unidStart;
            }
            info.setUnid(unidNext);
        }
        info.setSalesBrokerId(principal.getId());
        if (beanValidator(json, info))
        {
            accountService.save(info);
        }
        return json;
    }
    
    /**
     * 查询账户表
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:accountAccount:data")
    @ApiOperation(value = "查询账户表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute AccountModel entity, @ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<AccountModel> result = accountService.search(pagin, entity);
        return getJsonMessage(CommonEnums.SUCCESS, result);
    }
    
    /**
     * 账户-审核通过(解冻)
     * @param id
     */
    @CSRFToken
    @ResponseBody
    @RequestMapping(value = "/pass", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:accountAccount:operator")
    public JsonMessage pass(Long id) throws BusinessException
    {
        AccountModel account = accountService.selectByPrimaryKey(id);
        account.setAccountStatus(AccountConsts.ACCOUNT_STATUS_NORMAL);
        accountService.updateByPrimaryKey(account);
        return getJsonMessage(CommonEnums.SUCCESS);
    }
    
    /**
     * 账户-审核不通过（冻结）
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/nopass", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:accountAccount:operator")
    public JsonMessage nopass(Long id) throws BusinessException
    {
        AccountModel account = accountService.selectByPrimaryKey(id);
        account.setAccountStatus(AccountConsts.ACCOUNT_STATUS_FROZEN);
        accountService.updateByPrimaryKey(account);
        return getJsonMessage(CommonEnums.SUCCESS);
    }
    
    /**
     * 关闭账户（关闭）
     * @param id
     */
    @CSRFToken
    @ResponseBody
    @RequestMapping(value = "/close", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:accountAccount:operator")
    public JsonMessage closeAccount(Long id) throws BusinessException
    {
        AccountModel account = accountService.selectByPrimaryKey(id);
        account.setAccountStatus(AccountConsts.ACCOUNT_STATUS_CLOSE);
        accountService.updateByPrimaryKey(account);
        return getJsonMessage(CommonEnums.SUCCESS);
    }
    
    /**
     * 重置密码
     * @param id
     */
    @CSRFToken
    @ResponseBody
    @RequestMapping(value = "/initLoginPass", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:accountAccount:operator")
    public JsonMessage initAccountLoginPwd(Long id) throws BusinessException
    {
        AccountModel account = accountService.selectByPrimaryKey(id);
        account.setLoginPwd(EncryptUtils.entryptPassword("fuzaMIMA@123.com"));
        accountService.updateByPrimaryKey(account);
        return getJsonMessage(CommonEnums.SUCCESS);
    }
    
    /**
     * 根据指定ID删除
     * @param ids
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:accountAccount:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组", paramType = "form")
    public JsonMessage del(String ids) throws BusinessException
    {
        for (String id : ids.split(","))
        {
            AccountModel account = accountService.selectByPrimaryKey(Long.parseLong(id));
            account.setAccountStatus(AccountConsts.ACCOUNT_STATUS_CLOSE);
            accountService.updateByPrimaryKey(account);
        }
        return getJsonMessage(CommonEnums.SUCCESS);
    }

    /**
     * 查询账户表（全部）
     */
    @ResponseBody
    @RequestMapping(value = "/all")
    @RequiresPermissions("system:setting:accountAccount:data")
    @ApiOperation(value = "查询账户表",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AccountModel> allData() throws BusinessException
    {
        List<AccountModel> result = accountService.selectAll();
        return result;
    }
}
