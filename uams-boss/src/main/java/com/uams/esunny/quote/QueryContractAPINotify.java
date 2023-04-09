package com.uams.esunny.quote;

import com.alibaba.fastjson.JSON;
import com.uams.orm.utils.SpringContext;
import com.uams.rpc.base.model.FutureInfoModel;
import com.uams.rpc.base.model.FutureKindModel;
import com.uams.rpc.base.model.MarketInfoModel;
import com.uams.rpc.base.model.StockInfoModel;
import com.uams.rpc.base.service.FutureInfoService;
import esunny.futures.wp.quote.api.EsunnyWPQuoteAPINotify;
import esunny.futures.wp.quote.struct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QueryContractAPINotify extends EsunnyWPQuoteAPINotify {

    @Autowired(required = false)
    private FutureInfoService futureInfoService;

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
        //解析交易合约
        //得到ServiceBean
        futureInfoService = SpringContext.getBean(FutureInfoService.class);
        //交易所编码
        String ExchangeNo=info.getContract().getCommodity().getExchangeNo();
        MarketInfoModel marketInfo = new MarketInfoModel();
        marketInfo.setExchangeCode(ExchangeNo);
        //品种编号
        String CommodityNo=info.getContract().getCommodity().getCommodityNo();
        FutureKindModel futureKind = new FutureKindModel();
        futureKind.setKindCode(CommodityNo);

        StockInfoModel stockInfo = new StockInfoModel();
        stockInfo.setInterCode(info.getContract().getCommodity().getExchangeNo()+info.getContract().getCommodity().getCommodityNo()+info.getContract().getContractNo1());
        stockInfo.setStockCode(stockInfo.getInterCode());
        stockInfo.setStockName(stockInfo.getInterCode());
        stockInfo.setStockSpell(stockInfo.getInterCode());
        stockInfo.setStockFullName(stockInfo.getInterCode());

        FutureInfoModel futureInfo = new FutureInfoModel();
        futureInfo.setMultiple(1l);
        futureInfo.setContractMonth(Integer.valueOf(info.getContract().getContractNo1()));

        futureInfoService.saveQuoteContract(stockInfo, futureInfo, marketInfo, futureKind);
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
