package com.uams.esunny.quote;

import esunny.futures.wp.quote.api.EsunnyWPQuoteAPI;
import esunny.futures.wp.quote.api.EsunnyWPQuoteAPINotify;
import esunny.futures.wp.quote.struct.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("quoteapi/queryQuote")
public class QueryQuoteAPI {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Scheduled(fixedRate=5000)
    public  void QueryQuoteAPI() {

        TapAPIApplicationInfo appInfo = new TapAPIApplicationInfo();
        appInfo.setAuthCode("B112F916FE7D27BCE7B97EB620206457946CED32E26C1EAC946CED32E26C1EAC946CED32E26C1EAC946CED32E26C1EAC5211AF9FEE541DDE9D6F622F72E25D5DEF7F47AA93A738EF5A51B81D8526AB6A9D19E65B41F59D6A946CED32E26C1EACCAF8D4C61E28E2B1ABD9B8F170E14F8847D3EA0BF4E191F5DCB1B791E63DC196D1576DEAF5EC563CA3E560313C0C3411B45076795F550EB050A62C4F74D5892D2D14892E812723FAC858DEBD8D4AF9410729FB849D5D8D6EA48A1B8DC67E037381A279CE9426070929D5DA085659772E24A6F5EA52CF92A4D403F9E46083F27B19A88AD99812DADA44100324759F9FD1964EBD4F2F0FB50B51CD31C0B02BB437");

        //行情回调
        EsunnyWPQuoteAPINotify queryQuoteAPINotify = new QueryQuoteAPINotify();
        //quoteApi
        EsunnyWPQuoteAPI quoteApi = EsunnyWPQuoteAPI.createEsunnyWPQuoteAPI(appInfo);
        quoteApi.setHostAddress("123.15.58.21", 7171);

        //注册行情回调
        quoteApi.setAPINotify(queryQuoteAPINotify);

        //登陆
        TapAPIQuoteLoginAuth loginAuth = new TapAPIQuoteLoginAuth();
        loginAuth.setUserNo("ES");
        loginAuth.setPassword("123456");
        loginAuth.setISModifyPassword(TapAPIConstants.APIYNFLAG_NO);
        loginAuth.setISDDA(TapAPIConstants.APIYNFLAG_NO);
        quoteApi.login(loginAuth);

        //需等待API就绪后再进行后续操作
        try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}

        //行情订阅
        TapAPIContract contract = new TapAPIContract();
        contract.setCallOrPutFlag1(TapAPIConstants.TAPI_CALLPUT_FLAG_NONE);
        contract.setCallOrPutFlag2(TapAPIConstants.TAPI_CALLPUT_FLAG_NONE);

        TapAPICommodity Commodity = new TapAPICommodity();
        Commodity.setExchangeNo("HKEX");
        Commodity.setCommodityNo("HSI");
        Commodity.setCommodityType(TapAPIConstants.TAPI_COMMODITY_TYPE_FUTURES);
        //
        contract.setCommodity(Commodity);
        contract.setContractNo1("1803");
        //
        quoteApi.subscribeQuote(contract);

        //
        TapAPIContract contract2 = new TapAPIContract();
        contract2.setCallOrPutFlag1(TapAPIConstants.TAPI_CALLPUT_FLAG_NONE);
        contract2.setCallOrPutFlag2(TapAPIConstants.TAPI_CALLPUT_FLAG_NONE);

        TapAPICommodity Commodity2 = new TapAPICommodity();
        Commodity2.setExchangeNo("HKEX");
        Commodity2.setCommodityNo("MCH");
        Commodity2.setCommodityType(TapAPIConstants.TAPI_COMMODITY_TYPE_FUTURES);
        //
        contract2.setCommodity(Commodity2);
        contract2.setContractNo1("1801");
        //
        quoteApi.subscribeQuote(contract2);

        try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}

        // 取消行情订阅
        // 暂时没开放

        // 断开
        quoteApi.disconnect();

        //
        quoteApi.freeEsunnyWPQuoteAPI();
    }
}
