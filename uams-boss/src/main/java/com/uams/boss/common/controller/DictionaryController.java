/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.common.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uams.orm.core.GenericController;
import com.uams.rpc.common.entity.Dictionary;
import com.uams.rpc.common.model.DictModel;
import com.uams.rpc.common.service.DictionaryService;
import com.uams.security.OnLineUserUtils;
import com.uams.security.shiro.model.UserPrincipal;
import com.uams.tools.annotation.CSRFToken;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.bean.TreeModel;
import com.uams.tools.consts.UamsConst;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.StringUtils;

/**
 * 数据典 控制器
 * <p>File：DictionaryController.java </p>
 * <p>Title: DictionaryController </p>
 * <p>Description:DictionaryController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping(UamsConst.COMMON)
public class DictionaryController extends GenericController
{
    @Autowired(required = false)
    private DictionaryService dictionaryService;
    
    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/dict")
    @RequiresPermissions("system:setting:dict:index")
    public String list() throws BusinessException
    {
        return "boss/common/dict/treelist";
    }
    
    /**
     * 编辑页面导航
     * @param id
     * @return {@link String}
     * @throws BusinessException
     */
    @RequestMapping(value = "/dict/modify")
    @RequiresPermissions("system:setting:dict:operator")
    public ModelAndView modify(Long id, Long parentId) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/common/dict/modify");
        Dictionary dict = new Dictionary();
        if (null != parentId) dict.setParentId(parentId);
        if (null != id) dict = dictionaryService.selectByPrimaryKey(id);
        mav.addObject("dict", dict);
        return mav;
    }
    
    /**
     * 返回以TREEMODEL对象的所有字典数据
     * @return {@link List}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/dict/tree")
    public List<TreeModel> tree(String id) throws BusinessException
    {
        return dictionaryService.findByDict(id);
    }
    
    /**
     * 根据编码取字典值
     * @param code
     * @return {@link List}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/dict/get")
    public List<Dictionary> getDict(HttpServletRequest request, String code) throws BusinessException
    {
        if (StringUtils.isBlank(code)) throw new BusinessException("字典编码不可为空！");
        String lang = "zh_CN";
        return dictionaryService.findByCode(lang, code);
    }
    
    /**
     * 操作数据典
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @CSRFToken
    @ResponseBody
    @RequiresPermissions("system:setting:dict:operator")
    @RequestMapping(value = "/dict/save", method = RequestMethod.POST)
    public JsonMessage save(Dictionary info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        UserPrincipal principal = OnLineUserUtils.getPrincipal();
        if (null == info.getId())
        {
            info.setCreateBy(principal.getId());
            info.setCreateDate(new Date());
            info.setActive(Boolean.TRUE);
        }
        dictionaryService.save(info);
        return json;
    }
    
    /**
     * 查询数据典
     * @param entity
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequiresPermissions("system:setting:dict:data")
    @RequestMapping(value = "/dict/data", method = RequestMethod.POST)
    public List<Dictionary> data(Dictionary entity) throws BusinessException
    {
        return dictionaryService.findList(entity);
    }
    
    /**
     * 根据指定ID删除
     * @param ids
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @CSRFToken
    @ResponseBody
    @RequiresPermissions("system:setting:dict:operator")
    @RequestMapping(value = "/dict/del", method = RequestMethod.POST)
    public JsonMessage del(String ids) throws BusinessException
    {
        dictionaryService.deleteBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
    
    /**
     * 取所有字典
     * @return {@link List}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/dict/json")
    public List<DictModel> getAll() throws BusinessException
    {
        return dictionaryService.findAllDict();
    }
}
