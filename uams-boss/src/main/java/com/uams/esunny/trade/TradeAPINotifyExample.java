package com.uams.esunny.trade;

import com.alibaba.fastjson.JSON;

import esunny.futures.wp.trade.api.EsunnyWPTradeAPINotify;
import esunny.futures.wp.trade.struct.TapAPIAccountCashAdjustQryRsp;
import esunny.futures.wp.trade.struct.TapAPIAccountFeeRentQryRsp;
import esunny.futures.wp.trade.struct.TapAPIAccountInfo;
import esunny.futures.wp.trade.struct.TapAPIAccountMarginRentQryRsp;
import esunny.futures.wp.trade.struct.TapAPIBillQryRsp;
import esunny.futures.wp.trade.struct.TapAPICommodityInfo;
import esunny.futures.wp.trade.struct.TapAPICurrencyInfo;
import esunny.futures.wp.trade.struct.TapAPIExchangeInfo;
import esunny.futures.wp.trade.struct.TapAPIFillInfo;
import esunny.futures.wp.trade.struct.TapAPIFundData;
import esunny.futures.wp.trade.struct.TapAPIHisDeliveryQryRsp;
import esunny.futures.wp.trade.struct.TapAPIHisMatchQryRsp;
import esunny.futures.wp.trade.struct.TapAPIHisOrderProcessQryRsp;
import esunny.futures.wp.trade.struct.TapAPIHisOrderQryRsp;
import esunny.futures.wp.trade.struct.TapAPIHisPositionQryRsp;
import esunny.futures.wp.trade.struct.TapAPIOrderActionRsp;
import esunny.futures.wp.trade.struct.TapAPIOrderInfo;
import esunny.futures.wp.trade.struct.TapAPIOrderInfoNotice;
import esunny.futures.wp.trade.struct.TapAPIOrderMarketDeleteRsp;
import esunny.futures.wp.trade.struct.TapAPIOrderMarketInsertRsp;
import esunny.futures.wp.trade.struct.TapAPIOrderQuoteMarketNotice;
import esunny.futures.wp.trade.struct.TapAPIPositionInfo;
import esunny.futures.wp.trade.struct.TapAPIPositionProfitNotice;
import esunny.futures.wp.trade.struct.TapAPITradeContractInfo;
import esunny.futures.wp.trade.struct.TapAPITradeLoginRspInfo;
import esunny.futures.wp.trade.struct.TapAPITradeMessage;

public class TradeAPINotifyExample extends EsunnyWPTradeAPINotify {

	@Override
	public void onConnect() {
		System.out.println("连接成功.");
	}

	@Override
	public void onRspLogin(int errorCode, TapAPITradeLoginRspInfo loginRspInfo) {
		if(errorCode == 0) {
			System.out.println("登陆成功 "+JSON.toJSONString(loginRspInfo));
		}
	}

	@Override
	public void onExpriationDate(String date, int days) {
		System.out.println("有效期:onExpriationDate:" + date+" " +days);
	}

	@Override
	public void onAPIReady() {
		System.out.println("API就绪");
	}

	@Override
	public void onDisconnect(int reasonCode) {
		System.out.println("断开连接.");
	}

	@Override
	public void onRspChangePassword(int sessionID, int errorCode) {
		System.out.println("修改密码回调:errorCode:" + errorCode+" ");
	}

	@Override
	public void onRspSetReservedInfo(int sessionID, int errorCode, String info) {
		System.out.println("setReservedInfo:errorCode:" + errorCode+" " +info);
	}

	@Override
	public void onRspQryAccount(int sessionID, int errorCode, byte isLast, TapAPIAccountInfo info) {
		System.out.println("查询账户信息:onRspQryAccount "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryFund(int sessionID, int errorCode, byte isLast, TapAPIFundData info) {
		System.out.println("查询资金信息:onRspQryFund "+JSON.toJSONString(info));
	}

	@Override
	public void onRtnFund(TapAPIFundData info) {
		System.out.println("资金变化通知:onRtnFund "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryExchange(int sessionID, int errorCode, byte isLast, TapAPIExchangeInfo info) {
		System.out.println("onRspQryExchange "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryCommodity(int sessionID, int errorCode, byte isLast, TapAPICommodityInfo info) {
		System.out.println("onRspQryCommodity "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryContract(int sessionID, int errorCode, byte isLast, TapAPITradeContractInfo info) {
		System.out.println("onRspQryContract "+JSON.toJSONString(info));
	}

	@Override
	public void onRtnContract(TapAPITradeContractInfo info) {
		System.out.println("onRtnContract "+JSON.toJSONString(info));
	}

	@Override
	public void onRspOrderAction(int sessionID, int errorCode, TapAPIOrderActionRsp info) {
		System.out.println("委托实时响应:onRspOrderAction "+JSON.toJSONString(info));
	}

	@Override
	public void onRtnOrder(TapAPIOrderInfoNotice info) {
		System.out.println("委托变化通知:onRtnOrder "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryOrder(int sessionID, int errorCode, byte isLast, TapAPIOrderInfo info) {
		System.out.println("查询委托信息:onRspQryOrder "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryOrderProcess(int sessionID, int errorCode, byte isLast, TapAPIOrderInfo info) {
		System.out.println("查询委托处理状态:onRspQryOrderProcess "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryFill(int sessionID, int errorCode, byte isLast, TapAPIFillInfo info) {
		System.out.println("查询成交信息:onRspQryFill "+JSON.toJSONString(info));
	}

	@Override
	public void onRtnFill(TapAPIFillInfo info) {
		System.out.println("成交变化通知:onRtnFill "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryPosition(int sessionID, int errorCode, byte isLast, TapAPIPositionInfo info) {
		System.out.println("查询期货持仓:onRspQryPosition "+JSON.toJSONString(info));
	}

	@Override
	public void onRtnPosition(TapAPIPositionInfo info) {
		System.out.println("持仓变化通知:onRtnPosition "+JSON.toJSONString(info));
	}

	@Override
	public void onRtnPositionProfit(TapAPIPositionProfitNotice info) {
		System.out.println("持仓损益通知:onRtnPosition "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryCurrency(int sessionID, int errorCode, byte isLast, TapAPICurrencyInfo info) {
		System.out.println("查询系统所有币种:onRspQryCurrency "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryTradeMessage(int sessionID, int errorCode, byte isLast, TapAPITradeMessage info) {
		System.out.println("onRspQryTradeMessage "+JSON.toJSONString(info));
	}

	@Override
	public void onRtnTradeMessage(TapAPITradeMessage info) {
		System.out.println("onRtnTradeMessage "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryHisOrder(int sessionID, int errorCode, byte isLast, TapAPIHisOrderQryRsp info) {
		System.out.println("查询历史委托:onRspQryHisOrder "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryHisOrderProcess(int sessionID, int errorCode, byte isLast, TapAPIHisOrderProcessQryRsp info) {
		System.out.println("查询历史委托处理状态:onRspQryHisOrderProcess "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryHisMatch(int sessionID, int errorCode, byte isLast, TapAPIHisMatchQryRsp info) {
		System.out.println("查询历史成交:onRspQryHisMatch "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryHisPosition(int sessionID, int errorCode, byte isLast, TapAPIHisPositionQryRsp info) {
		System.out.println("查询历史持仓:onRspQryHisPosition "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryHisDelivery(int sessionID, int errorCode, byte isLast, TapAPIHisDeliveryQryRsp info) {
		System.out.println("查询历史结算:onRspQryHisDelivery "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryAccountCashAdjust(int sessionID, int errorCode, byte isLast, TapAPIAccountCashAdjustQryRsp info) {
		System.out.println("查询账户资金调整:onRspQryAccountCashAdjust "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryBill(int sessionID, int errorCode, byte isLast, TapAPIBillQryRsp info) {
		System.out.println("查询账单:onRspQryBill "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryAccountFeeRent(int sessionID, int errorCode, byte isLast, TapAPIAccountFeeRentQryRsp info) {
		System.out.println("查询账户费率(保证金费率):onRspQryAccountFeeRent "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryAccountMarginRent(int sessionID, int errorCode, byte isLast, TapAPIAccountMarginRentQryRsp info) {
		System.out.println("查询账户保证金:onRspQryAccountMarginRent "+JSON.toJSONString(info));
	}

	@Override
	public void onRspHKMarketOrderInsert(int sessionID, int errorCode, TapAPIOrderMarketInsertRsp info) {
		System.out.println("HK做市:onRspHKMarketOrderInsert "+JSON.toJSONString(info));
	}

	@Override
	public void onRspHKMarketOrderDelete(int sessionID, int errorCode, TapAPIOrderMarketDeleteRsp info) {
		System.out.println("HK做市:onRspHKMarketOrderDelete "+JSON.toJSONString(info));
	}

	@Override
	public void onHKMarketQuoteNotice(TapAPIOrderQuoteMarketNotice info) {
		System.out.println("HK做市:onHKMarketQuoteNotice "+JSON.toJSONString(info));
	}
	
}
