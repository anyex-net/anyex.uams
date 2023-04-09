package com.uams.boss.common.controller;

import com.uams.rpc.common.service.MsgRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uams.rpc.common.entity.MsgRecord;
import com.uams.orm.core.GenericController;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.bean.PaginateResult;
import com.uams.tools.bean.Pagination;
import com.uams.tools.consts.UamsConst;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 消息发送记录 介绍
 * <p>File：MsgRecordController.java </p>
 * <p>Title: MsgRecordController </p>
 * <p>Description:MsgRecordController </p>
 * <p>Copyright: Copyright (c) 2017/7/20 </p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping(UamsConst.COMMON)
@Api(description = "消息发送记录")
public class MsgRecordController extends GenericController
{
    @Autowired(required = false)
    private MsgRecordService msgRecordService;

    /**
     * 消息记录查询页面导航
     * @return
     */
    @RequestMapping("/msgRecord")
    @ApiOperation(value = "消息记录查询页面导航", httpMethod = "get")
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView();
        return mav;
    }
    
    /**
     * 查询消息记录
     *
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/msgRecord/data")
    @ApiOperation(value = "查询消息记录", httpMethod = "POST")
    public JsonMessage data(@ModelAttribute MsgRecord entity, @ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<MsgRecord> data = msgRecordService.search(pagin, entity);
        return getJsonMessage(CommonEnums.SUCCESS, data);
    }
    
}
