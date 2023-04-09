/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.boss.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uams.orm.core.GenericController;
import com.uams.rpc.system.entity.Organization;
import com.uams.rpc.system.entity.UserData;
import com.uams.rpc.system.service.OrganizationService;
import com.uams.rpc.system.service.UserDataService;
import com.uams.security.OnLineUserUtils;
import com.uams.security.shiro.model.UserPrincipal;
import com.uams.tools.annotation.CSRFToken;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.bean.TreeModel;
import com.uams.tools.consts.UamsConst;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.CalendarUtils;
import com.uams.tools.utils.SerialnoUtils;

/**
 * 机构信息表 控制器
 * <p>File：OrganizationController.java </p>
 * <p>Title: OrganizationController </p>
 * <p>Description:OrganizationController </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping(UamsConst.SYSTEM)
public class OrganizationController extends GenericController
{
    @Autowired(required = false)
    private OrganizationService organizationService;
    
    @Autowired(required = false)
    private UserDataService     userDataService;
    
    /**
     * 列表页面导航
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/organiz")
    @RequiresPermissions("system:setting:orgaiz:index")
    public String list() throws BusinessException
    {
        return "boss/system/organiz/treelist";
    }
    
    /**
     * 编辑页面导航
     * @param id
     * @return {@link String}
     * @throws BusinessException
     */
    @RequestMapping(value = "/organiz/modify")
    @RequiresPermissions("system:setting:orgaiz:operator")
    public ModelAndView modify(Long id, Long parentId) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("boss/system/organiz/modify");
        Organization organiz = new Organization();
        if (null != parentId) organiz.setParentId(parentId);
        if (null != id) organiz = organizationService.selectByPrimaryKey(id);
        mav.addObject("organiz", organiz);
        return mav;
    }
    
    /**
     * 返回以TREEMODEL对象的所有数据
     * @return {@link List}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/organiz/tree")
    public List<TreeModel> tree(Organization organiz) throws BusinessException
    {
        if (null == organiz) organiz = new Organization();
        organiz.setUid(OnLineUserUtils.getId());
        return organizationService.findByOrganization(organiz);
    }
    
    /**
     * 操作数据
     * @param info
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @CSRFToken
    @ResponseBody
    @RequiresPermissions("system:setting:orgaiz:operator")
    @RequestMapping(value = "/organiz/save", method = RequestMethod.POST)
    public JsonMessage save(Organization info) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        UserPrincipal principal = OnLineUserUtils.getPrincipal();
        if (null == info.getId())
        {
            info.setId(SerialnoUtils.buildPrimaryKey());
            info.setCreateBy(principal.getId());
            info.setCreateDate(CalendarUtils.getCurrentLong());
            processPathInfo(principal, info);
            organizationService.insert(info);
            // 处理用户与机构的权限
            List<UserData> dataList = userDataService.findByOrgId(info.getParentId());
            for (UserData data : dataList)
            {
                data.setId(SerialnoUtils.buildPrimaryKey());
                data.setOrgId(info.getId());
            }
            userDataService.insertBatch(dataList);
        }
        else
        {
            processPathInfo(principal, info);
            organizationService.updateByPrimaryKey(info);
        }
        return json;
    }

    /**
     * 处理上下级关系
     * @param principal
     * @param info
     */
    private void processPathInfo(UserPrincipal principal, Organization info)
    {
        long currentDate = CalendarUtils.getCurrentLong();
        if (null == info.getParentId())
        {// 如果未指定上级机构，自动添加当前操作人员所在机构的上级机构
            Organization organization = organizationService.selectByPrimaryKey(principal.getOrgId());
            if (null != organization)
            {
                info.setParentId(organization.getParentId());
                info.setPathInfo(organization.getPathInfo() + UamsConst.SEPARATOR + info.getId());
            }
        }
        else
        {
            Organization organization = organizationService.selectByPrimaryKey(info.getParentId());
            if (null != organization)
            {
                info.setPathInfo(organization.getPathInfo() + UamsConst.SEPARATOR + info.getId());
            }
        }
        info.setUpdateBy(principal.getId());
        info.setUpdateDate(currentDate);
    }
    
    /**
     * 查询数据
     * @param entity
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequiresPermissions("system:setting:orgaiz:data")
    @RequestMapping(value = "/organiz/data", method = RequestMethod.POST)
    public List<Organization> data(Organization entity) throws BusinessException
    {
        if (null == entity) entity = new Organization();
        entity.setUid(OnLineUserUtils.getId());
        return organizationService.findList(entity);
    }
    
    /**
     * 根据指定ID删除
     * @param ids
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @CSRFToken
    @ResponseBody
    @RequiresPermissions("system:setting:orgaiz:operator")
    @RequestMapping(value = "/organiz/del", method = RequestMethod.POST)
    public JsonMessage del(String ids) throws BusinessException
    {
        organizationService.deleteBatch(ids.split(","));
        return getJsonMessage(CommonEnums.SUCCESS);
    }
}
