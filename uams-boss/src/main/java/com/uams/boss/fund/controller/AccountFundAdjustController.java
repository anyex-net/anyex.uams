/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.fund.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.account.model.AccountModel;
import com.uams.rpc.account.service.AccountService;
import com.uams.rpc.fund.model.AccountFundAdjustModel;
import com.uams.rpc.fund.service.AccountFundAdjustService;
import com.uams.rpc.fund.service.AccountFundCurrentService;
import com.uams.security.OnLineUserUtils;
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

import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * 账户资金调整记录表 控制器
 * <p>File：AccountFundAdjustController.java </p>
 * <p>Title: AccountFundAdjustController </p>
 * <p>Description:AccountFundAdjustController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping("/fund/accountFundAdjust")
@Api(description = "账户资金调整记录表")
public class AccountFundAdjustController extends GenericController {

    @Autowired(required = false)
    private AccountFundCurrentService accountFundCurrentService;

    @Autowired(required = false)
    private AccountFundAdjustService accountFundAdjustService;

    @Autowired(required = false)
    private AccountService accountService;

    /**
     * 列表页面导航
     *
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "")
    @RequiresPermissions("system:setting:fundAccountFundAdjust:index")
    public String list() throws BusinessException {
        return "boss/fund/accountFundAdjust/list";
    }

    /**
     * 编辑界面
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/modify")
    @RequiresPermissions("system:setting:fundAccountFundAdjust:operator")
    public ModelAndView modify(Long id) throws BusinessException {
        ModelAndView mav = new ModelAndView("boss/fund/accountFundAdjust/modify");
        AccountFundAdjustModel model = new AccountFundAdjustModel();
        if (null != id) {
            model = accountFundAdjustService.selectByPrimaryKey(id);
        }
        mav.addObject("model", model);
        return mav;
    }

    /**
     * 操作账户资金调整记录表
     *
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:fundAccountFundAdjust:operator")
    @ApiOperation(value = "保存账户资金调整记录表", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute AccountFundAdjustModel info) throws BusinessException {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);

        if (info.getAccountId()==null)
            throw new BusinessException("请选择账户");

        AccountModel accountModel = accountService.selectByPrimaryKey(info.getAccountId());
        if (accountModel == null)
            throw new BusinessException("账户不存在");
        info.setAccountName(accountModel.getAccountName());

        info.setCreateBy(OnLineUserUtils.getId());
        info.setCreateDate(new Date());
        accountFundAdjustService.save(info);
        accountFundCurrentService.saveAccountFundAdjust(info);//生成一条资金流水数据
        return json;
    }

    /**
     * 查询账户资金调整记录表
     *
     * @param entity
     * @param pagin
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/data")
    @RequiresPermissions("system:setting:fundAccountFundAdjust:data")
    @ApiOperation(value = "查询账户资金调整记录表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonMessage data(@ModelAttribute AccountFundAdjustModel entity, @ModelAttribute Pagination pagin) throws BusinessException {
        PaginateResult<AccountFundAdjustModel> result = accountFundAdjustService.search(pagin, entity);
        return getJsonMessage(CommonEnums.SUCCESS, result);
    }

    /**
     * 根据指定ID删除
     *
     * @param ids
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("system:setting:fundAccountFundAdjust:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "以','分割的编号组", paramType = "form")
    public JsonMessage del(String ids) throws BusinessException {
        accountFundAdjustService.deleteBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
