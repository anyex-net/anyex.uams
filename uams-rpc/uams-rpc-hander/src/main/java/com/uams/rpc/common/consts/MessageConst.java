package com.uams.rpc.common.consts;

/**
 * 消息模版常量
 * <p>File：MessageConst.java</p>
 * <p>Title: MessageConst</p>
 * <p>Description:MessageConst</p>
 * <p>Copyright: Copyright (c) 2017/7/21</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class MessageConst
{
    private MessageConst()
    {// 防止实例化
    }
    
    // 消息类型
    public static final String MESSAGE_EMAIL             = "email";
    
    public static final String MESSAGE_SMS               = "sms";
    
    /**
     * 发送手机验证码
     */
    public static final String TEMPLATE_SMS_SENDVALICODE = "sms_send_valid_code";
}
