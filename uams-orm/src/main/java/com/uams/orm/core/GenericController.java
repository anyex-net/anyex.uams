package com.uams.orm.core;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
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

import com.uams.orm.utils.ServletsUtils;
import com.uams.tools.bean.*;
import com.uams.tools.editor.*;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.LoggerUtils;
import com.uams.tools.utils.StringUtils;

/**
 * <p>File：GenericController.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-4-21 下午1:46:45</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public abstract class GenericController
{
    protected static final Logger logger = LoggerFactory.getLogger(GenericController.class);
    
    /**
     * 验证Bean实例对象
     */
    @Autowired
    protected Validator           validator;
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView handleException(Exception ex)
    {
        LoggerUtils.logError(logger, ex.getLocalizedMessage());
        ModelAndView mav = new ModelAndView();
        HttpServletResponse response = ServletsUtils.getResponse();
        if (StringUtils.isNotBlank(response.getHeader("csrf")))
        {// 将CSRF放到返回对象中
            mav.addObject("csrf", response.getHeader("csrf"));
        }
        if (ex instanceof BusinessException)
        { // 自定义业务异常
            BusinessException bex = (BusinessException) ex;
            JsonMessage json = getJsonMessage(bex.getErrorCode());
            mav.addObject("code", json.getCode());
            mav.addObject("message", json.getMessage());
            mav.addObject("object", bex.getObject());
        }
        else
        {
            JsonMessage json = getJsonMessage(CommonEnums.FAIL);
            mav.addObject("code", json.getCode());
            mav.addObject("message", json.getMessage());
            mav.addObject("object", "Business Exception");
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
     * @param jsonMessage 错误信息（不能为null）
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；严重失败：将错误信息添加到 jsonMessage rows 中
     */
    protected boolean beanValidator(JsonMessage jsonMessage, Object object, Class<?> ... groups)
    {
        try
        {
            BeanValidators.validateWithException(validator, object, groups);
        }
        catch (ConstraintViolationException ex)
        {
            List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
            jsonMessage.setCode(CommonEnums.FAIL.getCode());
            jsonMessage.setMessage(CommonEnums.FAIL.getMessage());
            jsonMessage.setObject(list);
            return false;
        }
        return true;
    }
    
    /**
     * 分页查询记录集：API接口返回分页及记录集的JSON处理，不返回状态码描述
     * @param describable 异常码
     * @param result 结果集及Pagination对象
     * @return JsonMessage JsonMessage
     */
    protected <T extends Object> JsonMessage getJsonMessage(EnumDescribable describable, PaginateResult<T> result)
    {
        JsonMessage json = getJsonMessage(describable);
        if (null != result)
        {
            Pagination page = result.getPage();
            json.setRows(result.getList());
            json.setTotal(result.getPage().getTotalRows());
            json.setHasNext(page.getHasNextPage());
            json.setHasPrevious(page.getHasPreviousPage());
            json.setPages(page.getPage());
            json.setTotalPage(page.getTotalPage());
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
    protected JsonMessage getJsonMessage(EnumDescribable describable, Object object)
    {
        JsonMessage jsonMessage = new JsonMessage();
        jsonMessage.setCode(describable.getCode());
        jsonMessage.setMessage(describable.getMessage());
        jsonMessage.setObject(object);
        return setCsrf(jsonMessage);
    }
    
    /**
     * 接口处理结果反馈 : ：API接口返回数据或交易处理结果的JSON处理
     * @param describable 异常代码描述
     * @return JsonMessage JsonMessage
     * @author Playguy
     */
    public JsonMessage getJsonMessage(EnumDescribable describable)
    {
        JsonMessage jsonMessage = new JsonMessage();
        jsonMessage.setCode(describable.getCode());
        jsonMessage.setMessage(describable.getMessage());
        return setCsrf(jsonMessage);
    }
    
    /**
     * 放置CSRF到返回对象中
     * @param json
     * @return
     */
    public JsonMessage setCsrf(JsonMessage json)
    {
        HttpServletResponse response = ServletsUtils.getResponse();
        String csrf = response.getHeader("csrf");
        if (StringUtils.isNotBlank(csrf))
        {// 将CSRF放到返回对象中
            json.setCsrf(csrf);
        }
        return json;
    }
}
