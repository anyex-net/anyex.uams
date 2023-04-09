package com.uams.esunny.quote;

import com.alibaba.fastjson.JSON;
import com.uams.orm.utils.SpringContext;
import com.uams.rpc.base.model.FutureKindModel;
import com.uams.rpc.base.model.MarketInfoModel;
import com.uams.rpc.base.service.FutureKindService;
import com.uams.rpc.base.service.MarketInfoService;
import esunny.futures.wp.quote.api.EsunnyWPQuoteAPINotify;
import esunny.futures.wp.quote.struct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QueryCommodityAPINotify extends EsunnyWPQuoteAPINotify {

    @Autowired(required = false)
    private MarketInfoService marketInfoService;

    @Autowired(required = false)
    private FutureKindService futureKindService;

    @Override
    public void onRspLogin(int errorCode, TapAPIQuotLoginRspInfo info) {
        if (errorCode == 0) {
            System.out.println("登陆成功:" + JSON.toJSONString(info));
        }
    }

    @Override
    public void onApiReady() {
        System.out.println("API连接就绪");
    }

    @Override
    public void onDisconnect(int reasonCode) {
        System.out.println("API断开连接." + reasonCode);
    }

    @Override
    public void onRspQryCommodity(int sessionID, int errorCode, byte isLast, TapAPIQuoteCommodityInfo info) {
        System.out.println("onRspQryCommodity全球交易所各大期货品种查询:" + JSON.toJSONString(info));
        //解析交易所
        System.out.println("onRspQryCommodity解析交易所...");
        //得到ServiceBean
        marketInfoService = SpringContext.getBean(MarketInfoService.class);

        //交易所入库
        MarketInfoModel marketInfoModel = new MarketInfoModel();
        marketInfoModel.setExchangeCode(info.getCommodity().getExchangeNo());
        marketInfoService.saveQuoteExchange(marketInfoModel);

        //解析交易所期货品种
        System.out.println("onRspQryCommodity解析交易所期货品种...");
        //得到ServiceBean
        futureKindService = SpringContext.getBean(FutureKindService.class);

        //交易所品种信息入库
        FutureKindModel futureKindModel = new FutureKindModel();
        futureKindModel.setKindCode(info.getCommodity().getCommodityNo());
        futureKindModel.setKindName(info.getCommodityName());
        futureKindService.saveQuoteCommodity(marketInfoModel, futureKindModel);
    }

    @Override
    public void onRspQryContract(int sessionID, int errorCode, byte isLast, TapAPIQuoteContractInfo info) {
        System.out.println("onRspQryContract合约查询:" + sessionID + JSON.toJSONString(info));
    }

    @Override
    public void onRspSubscribeQuote(int sessionID, int errorCode, byte isLast, TapAPIQuoteWhole info) {
        System.out.println("OnRspSubscribeQuote行情订阅:" + JSON.toJSONString(info));
    }

    @Override
    public void onRspUnSubscribeQuote(int sessionID, int errorCode, byte isLast, TapAPIContract info) {
        System.out.println("OnRspUnSubscribeQuote取消行情订阅:" + JSON.toJSONString(info));
    }

    @Override
    public void onRtnQuote(TapAPIQuoteWhole info) {
        System.out.println("onRtnQuote:" + JSON.toJSONString(info));
    }

}
