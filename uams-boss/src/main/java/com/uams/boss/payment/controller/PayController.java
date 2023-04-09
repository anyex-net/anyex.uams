package com.uams.boss.payment.controller;

import com.uams.orm.core.GenericController;
import com.uams.rpc.account.model.AccountBankModel;
import com.uams.rpc.account.model.AccountModel;
import com.uams.tools.consts.UamsConst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wubin on 2017/11/28.
 */

@Controller
@RequestMapping(UamsConst.COMMON)
public class PayController extends GenericController {

    @RequestMapping(value = "/pay")
    @ResponseBody
    public Map<String, String> productTestSub(@ModelAttribute AccountBankModel info) throws Exception {


        // 生成订单号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String orderId = "order_" + sdf.format(new Date());
        // 生成交易时间
        sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String tranTime = sdf.format(new Date());

        // 生成签名串
        StringBuffer str = new StringBuffer();
        String total_fee= "";//支付金额
        Map<String,Object> sendParams =new HashMap<>();

        String merId = "1000000702";

        Long accountId =info.getAccountId();//账户ID

        String pay_type ="qkpay";//支付类型

        String notifyurl ="http://www.baidu.com";//异步通知地址

        String merchant_no ="168666999001451";//公司商户号

        String pay_num ="111111";//商户系统订单号

        String card_no="6228480318285070476";//卡号

        String card_name="庄武斌";//银行卡或存折上的所有人姓名

        String phone="15757174361";//预留手机号

        String id_no="330283199312201418";//身份证号

        String check_type="4";//校验类型

        String key ="xu2l5os4vcxkef4g";

        String today="20171127";

//        必填，sign = MD5(merchant_no+total_fee+today+key)；today= (yyyyMMdd),当天日期，比如20160823

        String sign= cryptoWithMD5(merchant_no+total_fee+today+key);

        sendParams.put("merchant_no", merchant_no);
        sendParams.put("total_fee",total_fee);
        sendParams.put("pay_type",pay_type);
        sendParams.put("notifyurl",notifyurl);

        sendParams.put("pay_num", pay_num);
        sendParams.put("sign", sign);
        sendParams.put("card_no", card_no);
        // 传入参数
        sendParams.put("card_name", card_name);
        sendParams.put("phone", phone);
        sendParams.put("id_no",id_no);
        sendParams.put("check_type", check_type);


//        http://域名:端口/hmpay/online/createWxOrder.do

        String url ="http://api.zhongnanpay.com:3022/hmpay/online/createWxOrder.do";

        //发送post + http 请求

        String test = HttpClientUtil.sendPost(url,sendParams);

        Map<String, String> resultMap = new HashMap<>();

        return resultMap;
    }

    /**
     * MD5加密 - 先MD5，之后转为小写
     *
     * @param data 待加密数据
     * @return 加密完成结果
     */
    private static String cryptoWithMD5(String data)
            throws Exception {
        MessageDigest MD5 = MessageDigest.getInstance("MD5");
        byte[] bytes;
        if (MD5 == null) {
            throw new NoSuchAlgorithmException();
        }
        MD5.update(data.getBytes("UTF-8"));
        bytes = MD5.digest();
        MD5.reset();
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            int i = b;
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                builder.append("0");
            }
            builder.append(Integer.toHexString(i));
        }
        return builder.toString();// 32位的加密
    }


}
