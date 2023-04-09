package com.uams.boss.common.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uams.orm.core.GenericController;
import com.uams.security.OnLineUserUtils;
import com.uams.tools.annotation.CSRFToken;
import com.uams.tools.bean.JsonMessage;
import com.uams.tools.consts.UamsConst;
import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.AliyunOSS;
import com.uams.tools.utils.StringUtils;

/**
 * 公共文件上传控制器
 * <p>File：UploadController.java</p>
 * <p>Title: UploadController</p>
 * <p>Description: UploadController</p>
 * <p>Copyright: Copyright (c) 2017/8/3</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
@Controller
@RequestMapping(UamsConst.COMMON)
public class UploadController extends GenericController
{
    /**
     * 获取文件上传策略
     * @param dir 上传的模拟地址
     * @return {@link Map}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/upload/policy")
    public Map<String, Object> getPostPolicy(String dir) throws BusinessException
    {
        if (null == OnLineUserUtils.getPrincipal())
        {// 加入用户登陆限制
            throw new BusinessException(CommonEnums.USER_NOT_LOGIN);
        }
        if (StringUtils.isBlank(dir)) dir = "";
        return AliyunOSS.getPostPolicy(dir, UamsConst.BUCKET_TEMP_URL);
    }
    
    /**
     * 转移文件存储空间
     * @param fileName 文件名
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @CSRFToken
    @ResponseBody
    @RequestMapping(value = "/upload/transferObject", method = RequestMethod.POST)
    public JsonMessage transferObject(String fileName) throws BusinessException
    {
        if (null == OnLineUserUtils.getPrincipal())
        {// 加入用户登陆限制
            throw new BusinessException(CommonEnums.USER_NOT_LOGIN);
        }
        boolean flag = AliyunOSS.transferObject(fileName);
        return getJsonMessage(flag ? CommonEnums.SUCCESS : CommonEnums.FAIL);
    }
    
    /**
     * 删除临时空间中的文件
     * @param fileName 文件名
     * @return {@link JsonMessage}
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping(value = "/upload/deleteObject", method = RequestMethod.GET)
    public JsonMessage deleteObject(String fileName) throws BusinessException
    {
        if (null == OnLineUserUtils.getPrincipal())
        {// 加入用户登陆限制
            throw new BusinessException(CommonEnums.USER_NOT_LOGIN);
        }
        boolean flag = AliyunOSS.deleteObject(fileName);
        return getJsonMessage(flag ? CommonEnums.SUCCESS : CommonEnums.FAIL);
    }
}
