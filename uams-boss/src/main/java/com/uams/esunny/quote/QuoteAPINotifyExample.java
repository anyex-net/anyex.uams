package com.uams.esunny.quote;

import com.alibaba.fastjson.JSON;
import esunny.futures.wp.quote.api.EsunnyWPQuoteAPINotify;
import esunny.futures.wp.quote.struct.*;

public class QuoteAPINotifyExample extends EsunnyWPQuoteAPINotify {

    @Override
    public void onRspLogin(int errorCode, TapAPIQuotLoginRspInfo info) {
        if(errorCode == 0) {
            System.out.println("登陆成功:"+ JSON.toJSONString(info));
        }
    }

    @Override
    public void onApiReady() {
        System.out.println("API连接就绪");
    }

    @Override
    public void onDisconnect(int reasonCode) {
        System.out.println("API断开连接."+reasonCode);
    }

    @Override
    public void onRspQryCommodity(int sessionID, int errorCode, byte isLast, TapAPIQuoteCommodityInfo info) {
        System.out.println("onRspQryCommodity全球交易所各大期货品种查询:"+JSON.toJSONString(info));
    }

    @Override
    public void onRspQryContract(int sessionID, int errorCode, byte isLast, TapAPIQuoteContractInfo info) {
        System.out.println("onRspQryContract合约查询:"+sessionID+JSON.toJSONString(info));
    }

    @Override
    public void onRspSubscribeQuote(int sessionID, int errorCode, byte isLast, TapAPIQuoteWhole info) {
        System.out.println("OnRspSubscribeQuote行情订阅:"+JSON.toJSONString(info));
    }

    @Override
    public void onRspUnSubscribeQuote(int sessionID, int errorCode, byte isLast, TapAPIContract info) {
        System.out.println("OnRspUnSubscribeQuote取消行情订阅:"+JSON.toJSONString(info));
    }

    @Override
    public void onRtnQuote(TapAPIQuoteWhole info) {
        System.out.println("onRtnQuote:"+JSON.toJSONString(info));
    }

}
