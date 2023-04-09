package com.uams.orm.core;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONException;
import com.uams.tools.bean.AppsJsonMessage;
import com.uams.tools.bean.BeanValidators;
import com.uams.tools.bean.EnumDescribable;
import com.uams.tools.bean.PaginateResult;
import com.uams.tools.editor.*;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.LoggerUtils;

/**
 * <p>File：AppsController.java</p>
 * <p>Title:AppsController </p>
 * <p>Description:AppsController</p>
 * <p>Copyright: Copyright (c) 2015 2015-4-21 下午1:46:45</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public abstract class AppsController
{
    protected static final Logger logger     = LoggerFactory.getLogger(AppsController.class);
    
    /**
     * 验证Bean实例对象
     */
    @Autowired
    protected Validator           validator;
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView handleException(Exception ex)
    {
        ModelAndView mav = new ModelAndView();
        if (ex instanceof BusinessException)
        { // 自定义业务异常
            BusinessException bex = (BusinessException) ex;
            AppsJsonMessage json = getJsonMessage(bex.getErrorCode());
            mav.addObject("code", json.getCode());
            mav.addObject("message", json.getMessage());
            mav.addObject("data", bex.getObject());
            LoggerUtils.logError(logger, json.toString());
        }
        else if (ex instanceof JSONException)
        { // 自定义业务异常
            AppsJsonMessage json = getJsonMessage(CommonEnums.ERROR_PARSE_JSON);
            mav.addObject("code", json.getCode());
            mav.addObject("message", json.getMessage());
        }
        else
        {
            AppsJsonMessage json = getJsonMessage(CommonEnums.FAIL);
            mav.addObject("code", json.getCode());
            mav.addObject("message", json.getMessage());
            LoggerUtils.logError(logger, json.toString());
        }
        return mav;
    }
    
    /**
     * 初始化数据绑定
     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
     * 2. 将字段中Date类型转换为String类型
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
        // Byte
        binder.registerCustomEditor(Byte.class, new ByteEditorSupport());
        // Float
        binder.registerCustomEditor(Float.class, new FloatEditorSupport());
        // Double
        binder.registerCustomEditor(Double.class, new DoubleEditorSupport());
        // Long
        binder.registerCustomEditor(Long.class, new LongEditorSupport());
        // Integer
        binder.registerCustomEditor(Integer.class, new IntegerEditorSupport());
        // Boolean
        binder.registerCustomEditor(Boolean.class, new BooleanEditorSupport());
        // Short
        binder.registerCustomEditor(Short.class, new ShortEditorSupport());
        // String
        binder.registerCustomEditor(String.class, new StringEditorSupport());
    }
    
    /**
     * 服务端参数有效性验证
     *
     * @param AppsJsonMessage 错误信息（不能为null）
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；严重失败：将错误信息添加到 AppsJsonMessage rows 中
     */
    protected boolean beanValidator(AppsJsonMessage AppsJsonMessage, Object object, Class<?> ... groups)
    {
        try
        {
            BeanValidators.validateWithException(validator, object, groups);
        }
        catch (ConstraintViolationException ex)
        {
            List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
            AppsJsonMessage.setCode(CommonEnums.FAIL.getCode());
            AppsJsonMessage.setMessage(CommonEnums.FAIL.getMessage());
            AppsJsonMessage.setData(list);
            return false;
        }
        return true;
    }
    
    /**
     * 分页查询记录集：API接口返回分页及记录集的JSON处理，不返回状态码描述
     * @param describable 异常码
     * @param result 结果集及Pagination对象
     * @return AppsJsonMessage AppsJsonMessage
     */
    protected <T extends Object> AppsJsonMessage getJsonMessage(EnumDescribable describable, PaginateResult<T> result)
    {
        AppsJsonMessage json = getJsonMessage(describable);
        if (null != result)
        {
            json.setData(result);
            json.setMessage(json.getMessage());
        }
        return json;
    }
    
    /**
     * 接口处理结果反馈 : ：API接口返回数据或交易处理结果的JSON处理
     * @param describable 异常代码描述
     * @param object 单结果返回对象
     * @return
     * @author Playguy
     */
    protected AppsJsonMessage getJsonMessage(EnumDescribable describable, Object object)
    {
        AppsJsonMessage AppsJsonMessage = new AppsJsonMessage();
        AppsJsonMessage.setCode(describable.getCode());
        AppsJsonMessage.setMessage(describable.getMessage());
        AppsJsonMessage.setData(object);
        return AppsJsonMessage;
    }
    
    /**
     * 接口处理结果反馈 : ：API接口返回数据或交易处理结果的JSON处理
     * @param describable 异常代码描述
     * @return AppsJsonMessage AppsJsonMessage
     * @author Playguy
     */
    public AppsJsonMessage getJsonMessage(EnumDescribable describable)
    {
        AppsJsonMessage AppsJsonMessage = new AppsJsonMessage();
        AppsJsonMessage.setCode(describable.getCode());
        AppsJsonMessage.setMessage(describable.getMessage());
        return AppsJsonMessage;
    }
}
