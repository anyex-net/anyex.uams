package com.uams.esunny.trade;

import esunny.futures.wp.trade.api.EsunnyWPTradeAPI;
import esunny.futures.wp.trade.api.EsunnyWPTradeAPINotify;
import esunny.futures.wp.trade.struct.*;

public class TradeAPISG {
    private static String userNo = "Q1321749630";//资金账号
    private static String password = "974974";//资金密码

    // 联通交易：123.15.58.28:8383
    // 电信交易：222.88.40.171:8383
    private static String tradeIp = "222.88.40.171";
    private static int tradePort = 8383;

    public static void main(String[] args) {

        System.out.println(EsunnyWPTradeAPI.getTradeAPIVersion());
        TapAPIApplicationInfo appInfo = new TapAPIApplicationInfo();
        appInfo.setAuthCode("67EA896065459BECDFDB924B29CB7DF1946CED32E26C1EAC946CED32E26C1EAC946CED32E26C1EAC946CED32E26C1EAC5211AF9FEE541DDE41BCBAB68D525B0D111A0884D847D57163FF7F329FA574E7946CED32E26C1EAC946CED32E26C1EAC733827B0CE853869ABD9B8F170E14F8847D3EA0BF4E191F5D97B3DFE4CCB1F01842DD2B3EA2F4B20CAD19B8347719B7E20EA1FA7A3D1BFEFF22290F4B5C43E6C520ED5A40EC1D50ACDF342F46A92CCF87AEE6D73542C42EC17818349C7DEDAB0E4DB16977714F873D505029E27B3D57EB92D5BEDA0A710197EB67F94BB1892B30F58A3F211D9C3B3839BE2D73FD08DD776B9188654853DDA57675EBB7D6FBBFC");
        EsunnyWPTradeAPI tradeApi = EsunnyWPTradeAPI.CreateEsunnyWPTradeAPI(appInfo);

        EsunnyWPTradeAPINotify apiNotify = new TradeAPINotify();
        tradeApi.setHostAddress(tradeIp, tradePort);
        tradeApi.setAPINotify(apiNotify);

        //登录
        TapAPITradeLoginAuth loginAuth = new TapAPITradeLoginAuth();
        loginAuth.setUserNo(userNo);
        loginAuth.setPassword(password);
        loginAuth.setISModifyPassword(TapAPIConstants.APIYNFLAG_NO);
        tradeApi.login(loginAuth);

        //需等待API就绪后再进行后续操作
        try {Thread.sleep(15000);} catch (InterruptedException e) {e.printStackTrace();}

        //查询系统品种信息
//		System.out.println("qryCommodity:"+tradeApi.qryCommodity());
//
//		//查询系统中指定品种的合约信息
//		TapAPICommodity contractReq = new TapAPICommodity();
//		contractReq.setExchangeNo("SGX");
//		contractReq.setCommodityType(TapAPIConstants.TAPI_COMMODITY_TYPE_FUTURES);
//		contractReq.setCommodityNo("CN");
//
//		System.out.println("qryContract:"+tradeApi.qryContract(contractReq));
//
//		//资金账号查询
//		TapAPIAccQryReq accountReq = new TapAPIAccQryReq();
//		System.out.println("qryAccount:"+tradeApi.qryAccount(accountReq));
//
//		//资金查询
//		TapAPIFundReq fundReq = new TapAPIFundReq();
//		fundReq.setAccountNo("");
//		System.out.println("qryFund:"+tradeApi.qryFund(fundReq));
//
//		//持仓查询
//		TapAPIPositionQryReq positionReq = new TapAPIPositionQryReq();
//		positionReq.setAccountNo("");
//		System.out.println("qryPosition:"+tradeApi.qryPosition(positionReq));

        //下单 SGX CN 1802
 		TapAPINewOrder order = new TapAPINewOrder();
 		String clientOrderNo = "23";
 		order.setAccountNo(userNo);
 		order.setExchangeNo("SGX");
 		order.setCommodityType(TapAPIConstants.TAPI_COMMODITY_TYPE_FUTURES);
 		order.setCommodityNo("CN");
 		order.setContractNo("1802");
 		order.setCallOrPutFlag(TapAPIConstants.TAPI_CALLPUT_FLAG_NONE);
 		order.setCallOrPutFlag2(TapAPIConstants.TAPI_CALLPUT_FLAG_NONE);
 		order.setOrderType(TapAPIConstants.TAPI_ORDER_TYPE_LIMIT);//市价
 		order.setOrderSource(TapAPIConstants.TAPI_ORDER_SOURCE_ESUNNY_API);
 		order.setTimeInForce(TapAPIConstants.TAPI_ORDER_TIMEINFORCE_GFD);
 		order.setOrderSide(TapAPIConstants.TAPI_SIDE_BUY);
 		order.setOrderPrice(2);
 		order.setOrderQty(22);//委托数量
 		System.out.println("insertOrder:"+tradeApi.insertOrder(clientOrderNo, order));


        //撤单OrderCancelReq
        TapAPIOrderCancelReq orderCancelReq = new TapAPIOrderCancelReq();
        orderCancelReq.setServerFlag(TapAPIConstants.TAPI_ORDER_SOURCE_ESUNNY_API);//服务器标识
        orderCancelReq.setOrderNo("OA201801290000049370");//委托编码
        System.out.println("OrderCancel:"+tradeApi.cancelOrder(orderCancelReq));

        //查询委托信息
//		TapAPIOrderQryReq orderReq = new TapAPIOrderQryReq();
//		orderReq.setAccountNo(userNo);
//		System.out.println("qryOrder:"+tradeApi.qryOrder(orderReq));

        //委托状态查询onRspQryOrderProcess
//		TapAPIOrderProcessQryReq or derProcessReq = new TapAPIOrderProcessQryReq();
//		orderProcessReq.setOrderNo("");//委托编码
//		System.out.println("OrderProcess:"+tradeApi.qryOrderProcess(orderProcessReq));

        //查询成交信息
//        TapAPIFillQryReq fillReq = new TapAPIFillQryReq();
//        fillReq.setAccountNo(userNo);
//		System.out.println("qryFill:"+tradeApi.qryFill(fillReq));

        //查询历史成交信息onRspQryHisMatch
//		TapAPIHisMatchQryReq hisMatchReq = new TapAPIHisMatchQryReq();
//		hisMatchReq.setAccountNo(userNo);
//		hisMatchReq.setBeginDate("2018-1-17");
//		hisMatchReq.setEndDate("2018-1-31");
//		System.out.println("hisMatchReq:"+tradeApi.qryHisMatch(hisMatchReq));

        //查询历史持仓信息onRspQryHisMatch
//		TapAPIHisOrderQryReq hisOrderReq = new TapAPIHisOrderQryReq();
//		hisOrderReq.setAccountNo(userNo);
//		hisOrderReq.setBeginDate("2018-1-17");
//		hisOrderReq.setEndDate("2018-1-31");
//		System.out.println("hisOrderReq:"+tradeApi.qryHisOrder(hisOrderReq));

//		查询历史委托处理状态
//		TapAPIHisOrderProcessQryReq hisOrderProcessReq = new TapAPIHisOrderProcessQryReq();
//		hisOrderProcessReq.setOrderNo("OA201801300000000368");//委托编码
//		hisOrderProcessReq.setDate("2018-1-31");
//		System.out.println("hisOrderProcessReq:"+tradeApi.qryHisOrderProcess(hisOrderProcessReq));

//		查询历史结算
//		TapAPIHisDeliveryQryReq hisDeliveryReq = new TapAPIHisDeliveryQryReq();
//		hisDeliveryReq.setAccountNo(userNo);
//		hisDeliveryReq.setBeginDate("2018-1-17");
//		hisDeliveryReq.setEndDate("2018-1-31");
//		System.out.println("hisDeliveryReq:"+tradeApi.qryHisDelivery(hisDeliveryReq));

        //查询账户费用
//		TapAPIAccountFeeRentQryReq accountFeeRentQryReq = new TapAPIAccountFeeRentQryReq();
//		accountFeeRentQryReq.setAccountNo(userNo);
//		System.out.println("qryAccountFeeRent:"+tradeApi.qryAccountFeeRent(accountFeeRentQryReq));

        //查询账户保证金
//        TapAPIAccountMarginRentQryReq accountMarginRentReq = new TapAPIAccountMarginRentQryReq();
//        accountMarginRentReq.setAccountNo(userNo);
//		accountMarginRentReq.setCommodityType('F');
//		System.out.println("qryAccountMarginRent:"+tradeApi.qryAccountMarginRent(accountMarginRentReq));

        try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}
    }
}
