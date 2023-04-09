package com.uams.esunny.trade;

import com.alibaba.fastjson.JSON;
import com.uams.orm.utils.SpringContext;
import com.uams.rpc.api.model.*;
import com.uams.rpc.api.service.*;
import com.uams.tools.utils.SerialnoUtils;
import esunny.futures.wp.trade.api.EsunnyWPTradeAPINotify;
import esunny.futures.wp.trade.struct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class TradeAPINotifyCapital extends EsunnyWPTradeAPINotify {


	/**
	 * 平台资金账户
	 */
    @Autowired(required = false)
    private SysAccountService sysAccountService;

	/**
	 * 平台资金信息
	 */
    @Autowired(required = false)
    private SysAccountFundService sysAccountFundService;
	/**
	 * 平台资金变化
	 */
    @Autowired(required = false)
    private SysAccountFundChangeService sysAccountFundChangeService;

	/**
	 * 资金费率
	 */
    @Autowired(required = false)
    private SysAccountFeeRentService sysAccountFeeRentService;
	/**
	 * 保证金
	 */
    @Autowired(required = false)
    private SysAccountMarginRentService sysAccountMarginRentService;

	/**
	 * 历史成交
	 */
	@Autowired(required = false)
    private SysHisMatchService sysHisMatchService;

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

		sysAccountService= SpringContext.getBean(SysAccountService.class);
		SysAccountModel sysAccountModel=new SysAccountModel();
		sysAccountModel.setAccountEnShortName(info.getAccountEnShortName());
		sysAccountModel.setAccountNo(info.getAccountNo());
		sysAccountModel.setAccountShortName(info.getAccountShortName());
		//sysAccountModel.setAccountState(String.valueOf(info.getAccountState()));
		sysAccountModel.setAccountTradeRight(String.valueOf(info.getAccountTradeRight()));
		sysAccountModel.setAccountType(String.valueOf(info.getAccountType()));
		sysAccountModel.setCommodityGroupNo(info.getCommodityGroupNo());
		sysAccountModel.setId(SerialnoUtils.buildPrimaryKey());
		sysAccountService.saveSysAccount(sysAccountModel);

	}

	@Override
	public void onRspQryFund(int sessionID, int errorCode, byte isLast, TapAPIFundData info) {

		sysAccountFundService=SpringContext.getBean(SysAccountFundService.class);
		SysAccountFundModel sysAccountFundModel=new SysAccountFundModel();
		sysAccountFundModel.setAccountMaintenanceMargin(BigDecimal.valueOf(info.getAccountMaintenanceMargin()));
		sysAccountFundModel.setAccountDeliveryFee(BigDecimal.valueOf(info.getAccountDeliveryFee()));
		sysAccountFundModel.setAccountFee(BigDecimal.valueOf(info.getAccountFee()));
		sysAccountFundModel.setAccountIntialMargin(BigDecimal.valueOf(info.getAccountIntialMargin()));
		sysAccountFundModel.setAccountNo(info.getAccountNo());
		sysAccountFundModel.setAuthMoney(BigDecimal.valueOf(info.getAuthMoney()));
		sysAccountFundModel.setAvailable(BigDecimal.valueOf(info.getAvailable()));
		sysAccountFundModel.setBalance(BigDecimal.valueOf(info.getBalance()));
		sysAccountFundModel.setCanDraw(BigDecimal.valueOf(info.getCanDraw()));
		sysAccountFundModel.setCashAdjustValue(BigDecimal.valueOf(info.getCashAdjustValue()));
		sysAccountFundModel.setCashInValue(BigDecimal.valueOf(info.getCashInValue()));
		sysAccountFundModel.setCashOutValue(BigDecimal.valueOf(info.getCashOutValue()));
		sysAccountFundModel.setCashPledged(BigDecimal.valueOf(info.getCashPledged()));
		sysAccountFundModel.setCloseProfit(BigDecimal.valueOf(info.getCloseProfit()));
		sysAccountFundModel.setCurrencyGroupNo(info.getCurrencyGroupNo());
		sysAccountFundModel.setCurrencyNo(info.getCurrencyNo());
		sysAccountFundModel.setDeliveryProfit(BigDecimal.valueOf(info.getDeliveryProfit()));
		sysAccountFundModel.setDiscount(BigDecimal.valueOf(info.getDiscount()));
		sysAccountFundModel.setEquity(BigDecimal.valueOf(info.getEquity()));
		sysAccountFundModel.setExchangeFee(BigDecimal.valueOf(info.getExchangeFee()));
		sysAccountFundModel.setExpProfit(BigDecimal.valueOf(info.getExpProfit()));
		sysAccountFundModel.setFrozenDeposit(BigDecimal.valueOf(info.getFrozenDeposit()));
		sysAccountFundModel.setFrozenFee(BigDecimal.valueOf(info.getFrozenFee()));
		sysAccountFundModel.setFutureAlg(String.valueOf(info.getFutureAlg()));
		sysAccountFundModel.setLmePositionProfit(BigDecimal.valueOf(info.getLmePositionProfit()));
		sysAccountFundModel.setMarketEquity(BigDecimal.valueOf(info.getMarketEquity()));
		sysAccountFundModel.setOptionAlg(String.valueOf(info.getOptionAlg()));
		sysAccountFundModel.setOptionMarketValue(BigDecimal.valueOf(info.getOptionMarketValue()));
		sysAccountFundModel.setPositionProfit(BigDecimal.valueOf(info.getPositionProfit()));
		sysAccountFundModel.setPreAvailable1(BigDecimal.valueOf(info.getPreAvailable1()));
		sysAccountFundModel.setPreBalance(BigDecimal.valueOf(info.getPreBalance()));
		sysAccountFundModel.setPreEquity(BigDecimal.valueOf(info.getPreEquity()));
		sysAccountFundModel.setPreLMEPositionProfit(BigDecimal.valueOf(info.getPreLMEPositionProfit()));
		sysAccountFundModel.setPreMarketEquity(BigDecimal.valueOf(info.getPreMarketEquity()));
		sysAccountFundModel.setPremiumIncome(BigDecimal.valueOf(info.getPremiumIncome()));
		sysAccountFundModel.setPremiumPay(BigDecimal.valueOf(info.getPremiumPay()));
		sysAccountFundModel.setPreUnExpProfit(BigDecimal.valueOf(info.getPreUnExpProfit()));
		sysAccountFundModel.setTradeRate(BigDecimal.valueOf(info.getTradeRate()));
		sysAccountFundModel.setUnExpProfit(BigDecimal.valueOf(info.getUnExpProfit()));
		sysAccountFundModel.setUpperInitalMargin(BigDecimal.valueOf(info.getUpperInitalMargin()));
		sysAccountFundModel.setUpperMaintenanceMargin(BigDecimal.valueOf(info.getUpperMaintenanceMargin()));
		sysAccountFundService.saveSysAccountFund(sysAccountFundModel);
	}

	@Override
	public void onRtnFund(TapAPIFundData info) {

		sysAccountFundChangeService=SpringContext.getBean(SysAccountFundChangeService.class);
		SysAccountFundChangeModel sysAccountFundChangeModel=new SysAccountFundChangeModel();
		sysAccountFundChangeModel.setAccountDeliveryFee(BigDecimal.valueOf(info.getAccountDeliveryFee()));
		sysAccountFundChangeModel.setAccountMaintenanceMargin(BigDecimal.valueOf(info.getAccountMaintenanceMargin()));
		sysAccountFundChangeModel.setAccountFee(BigDecimal.valueOf(info.getAccountFee()));
		sysAccountFundChangeModel.setAccountIntialMargin(BigDecimal.valueOf(info.getAccountIntialMargin()));
		sysAccountFundChangeModel.setAccountNo(info.getAccountNo());
		sysAccountFundChangeModel.setAuthMoney(BigDecimal.valueOf(info.getAuthMoney()));
		sysAccountFundChangeModel.setAvailable(BigDecimal.valueOf(info.getAvailable()));
		sysAccountFundChangeModel.setBalance(BigDecimal.valueOf(info.getBalance()));
		sysAccountFundChangeModel.setCanDraw(BigDecimal.valueOf(info.getCanDraw()));
		sysAccountFundChangeModel.setCashAdjustValue(BigDecimal.valueOf(info.getCashAdjustValue()));
		sysAccountFundChangeModel.setCashInValue(BigDecimal.valueOf(info.getCashInValue()));
		sysAccountFundChangeModel.setCashOutValue(BigDecimal.valueOf(info.getCashOutValue()));
		sysAccountFundChangeModel.setCashPledged(BigDecimal.valueOf(info.getCashPledged()));
		sysAccountFundChangeModel.setCloseProfit(BigDecimal.valueOf(info.getCloseProfit()));
		sysAccountFundChangeModel.setCurrencyGroupNo(info.getCurrencyGroupNo());
		sysAccountFundChangeModel.setCurrencyNo(info.getCurrencyNo());
		sysAccountFundChangeModel.setDeliveryProfit(BigDecimal.valueOf(info.getDeliveryProfit()));
		sysAccountFundChangeModel.setDiscount(BigDecimal.valueOf(info.getDiscount()));
		sysAccountFundChangeModel.setEquity(BigDecimal.valueOf(info.getEquity()));
		sysAccountFundChangeModel.setExchangeFee(BigDecimal.valueOf(info.getExchangeFee()));
		sysAccountFundChangeModel.setExpProfit(BigDecimal.valueOf(info.getExpProfit()));
		sysAccountFundChangeModel.setFrozenDeposit(BigDecimal.valueOf(info.getFrozenDeposit()));
		sysAccountFundChangeModel.setFrozenFee(BigDecimal.valueOf(info.getFrozenFee()));
		sysAccountFundChangeModel.setFutureAlg(String.valueOf(info.getFutureAlg()));
		sysAccountFundChangeModel.setLmePositionProfit(BigDecimal.valueOf(info.getLmePositionProfit()));
		sysAccountFundChangeModel.setMarketEquity(BigDecimal.valueOf(info.getMarketEquity()));
		sysAccountFundChangeModel.setOptionAlg(String.valueOf(info.getOptionAlg()));
		sysAccountFundChangeModel.setOptionMarketValue(BigDecimal.valueOf(info.getOptionMarketValue()));
		sysAccountFundChangeModel.setPositionProfit(BigDecimal.valueOf(info.getPositionProfit()));
		sysAccountFundChangeModel.setPreAvailable1(BigDecimal.valueOf(info.getPreAvailable1()));
		sysAccountFundChangeModel.setPreBalance(BigDecimal.valueOf(info.getPreBalance()));
		sysAccountFundChangeModel.setPreEquity(BigDecimal.valueOf(info.getPreEquity()));
		sysAccountFundChangeModel.setPreLMEPositionProfit(BigDecimal.valueOf(info.getPreLMEPositionProfit()));
		sysAccountFundChangeModel.setPreMarketEquity(BigDecimal.valueOf(info.getPreMarketEquity()));
		sysAccountFundChangeModel.setPremiumIncome(BigDecimal.valueOf(info.getPremiumIncome()));
		sysAccountFundChangeModel.setPremiumPay(BigDecimal.valueOf(info.getPremiumPay()));
		sysAccountFundChangeModel.setPreUnExpProfit(BigDecimal.valueOf(info.getPreUnExpProfit()));
		sysAccountFundChangeModel.setTradeRate(BigDecimal.valueOf(info.getTradeRate()));
		sysAccountFundChangeModel.setUnExpProfit(BigDecimal.valueOf(info.getUnExpProfit()));
		sysAccountFundChangeModel.setUpperInitalMargin(BigDecimal.valueOf(info.getUpperInitalMargin()));
		sysAccountFundChangeModel.setUpperMaintenanceMargin(BigDecimal.valueOf(info.getUpperMaintenanceMargin()));
		sysAccountFundChangeService.saveSysAccountFundChange(sysAccountFundChangeModel);

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
		System.out.println("onRspQryContract 合约查询"+JSON.toJSONString(info));
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

		sysHisMatchService=SpringContext.getBean(SysHisMatchService.class);
		SysHisMatchModel sysHisMatchModel=new SysHisMatchModel();
		sysHisMatchModel.setAccountFee(BigDecimal.valueOf(info.getAccountFee()));
		sysHisMatchModel.setAccountFeeCurrency(info.getAccountFeeCurrency());
		sysHisMatchModel.setAccountFeeCurrencyGroup(info.getAccountFeeCurrencyGroup());
		sysHisMatchModel.setAccountNo(info.getAccountNo());
		sysHisMatchModel.setAccountOtherFee(BigDecimal.valueOf(info.getAccountOtherFee()));
		sysHisMatchModel.setCallOrPutFlag(String.valueOf(info.getCallOrPutFlag()));
		sysHisMatchModel.setClosePrice(BigDecimal.valueOf(info.getClosePrice()));
		sysHisMatchModel.setCloseProfit(BigDecimal.valueOf(info.getCloseProfit()));
		sysHisMatchModel.setCloseQty((long) info.getCloseQty());
		sysHisMatchModel.setCommodityCurrency(info.getCommodityCurrency());
		sysHisMatchModel.setCommodityCurrencyGroup(info.getCommodityCurrencyGroup());
		sysHisMatchModel.setCommodityNo(info.getCommodityNo());
		sysHisMatchModel.setCommodityType(String.valueOf(info.getCommodityType()));
		sysHisMatchModel.setContractNo(info.getContractNo());
		sysHisMatchModel.setExchangeMatchNo(info.getExchangeMatchNo());
		sysHisMatchModel.setExchangeNo(info.getExchangeNo());
		sysHisMatchModel.setHedgeFlag(String.valueOf(info.getHedgeFlag()));
		sysHisMatchModel.setIsManualFee(String.valueOf(info.getIsManualFee()));
		sysHisMatchModel.setIsUpperManualFee(String.valueOf(info.getIsUpperManualFee()));
		sysHisMatchModel.setMatchCmbNo(info.getMatchCmbNo());
		sysHisMatchModel.setMatchDateTime(info.getMatchDateTime());
		sysHisMatchModel.setMatchNo(info.getMatchNo());
		sysHisMatchModel.setMatchPrice(BigDecimal.valueOf(info.getMatchPrice()));
		sysHisMatchModel.setMatchQty(Long.valueOf(info.getMatchQty()));
		sysHisMatchModel.setMatchSide(String.valueOf(info.getMatchSide()));
		sysHisMatchModel.setMatchSource(String.valueOf(info.getMatchSource()));
		sysHisMatchModel.setMatchStreamID((long) info.getMatchStreamID());
		sysHisMatchModel.setMatchUpperStreamID((long) info.getMatchUpperStreamID());
		sysHisMatchModel.setOperateTime(info.getOperateTime());
		sysHisMatchModel.setOperatorNo(info.getOperatorNo());
		sysHisMatchModel.setOrderNo(info.getOrderNo());
		sysHisMatchModel.setPositionEffect(String.valueOf(info.getPositionEffect()));
		sysHisMatchModel.setPremiumIncome(BigDecimal.valueOf(info.getPremiumIncome()));
		sysHisMatchModel.setPremiumPay(BigDecimal.valueOf(info.getPremiumPay()));
		sysHisMatchModel.setSettleDate(info.getSettleDate());
		sysHisMatchModel.setSettleGroupNo(info.getSettleGroupNo());
		sysHisMatchModel.setStrikePrice(info.getStrikePrice());
		sysHisMatchModel.setTradeDate(info.getTradeDate());
		sysHisMatchModel.setTurnover(BigDecimal.valueOf(info.getTurnover()));
		sysHisMatchModel.setUpperFee(BigDecimal.valueOf(info.getUpperFee()));
		sysHisMatchModel.setUpperFeeCurrency(info.getUpperFeeCurrency());
		sysHisMatchModel.setUpperFeeCurrencyGroup(info.getUpperFeeCurrencyGroup());
		sysHisMatchModel.setUpperMatchDateTime(info.getUpperMatchDateTime());
		sysHisMatchModel.setUpperNo(info.getUpperNo());
		sysHisMatchModel.setUpperOtherFee(BigDecimal.valueOf(info.getUpperOtherFee()));
		sysHisMatchService.saveSysHisMatch(sysHisMatchModel);
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

		sysAccountFeeRentService =SpringContext.getBean(SysAccountFeeRentService.class);
		SysAccountFeeRentModel sysAccountFeeRentModel=new SysAccountFeeRentModel();
		sysAccountFeeRentModel.setAccountNo(info.getAccountNo());
		sysAccountFeeRentModel.setCalculateMode(String.valueOf(info.getCalculateMode()));
		sysAccountFeeRentModel.setCloseTodayFee(BigDecimal.valueOf(info.getCloseTodayFee()));
		sysAccountFeeRentModel.setCommodityNo(info.getCommodityNo());
		sysAccountFeeRentModel.setCommodityType(String.valueOf(info.getCommodityType()));
		sysAccountFeeRentModel.setCurrencyGroupNo(info.getCurrencyGroupNo());
		sysAccountFeeRentModel.setCurrencyNo(info.getCurrencyNo());
		sysAccountFeeRentModel.setExchangeNo(info.getExchangeNo());
		sysAccountFeeRentModel.setMatchSource(String.valueOf(info.getMatchSource()));
		sysAccountFeeRentModel.setOpenCloseFee(BigDecimal.valueOf(info.getOpenCloseFee()));
		sysAccountFeeRentService.saveSysAccountFeeRent(sysAccountFeeRentModel);

	}

	@Override
	public void onRspQryAccountMarginRent(int sessionID, int errorCode, byte isLast, TapAPIAccountMarginRentQryRsp info) {

		sysAccountMarginRentService=SpringContext.getBean(SysAccountMarginRentService.class);
		SysAccountMarginRentModel sysAccountMarginRentModel=new SysAccountMarginRentModel();
		sysAccountMarginRentModel.setAccountNo(info.getAccountNo());
		sysAccountMarginRentModel.setCalculateMode(String.valueOf(info.getCalculateMode()));
		sysAccountMarginRentModel.setCallOrPutFlag(String.valueOf(info.getCallOrPutFlag()));
		sysAccountMarginRentModel.setCommodityNo(info.getCommodityNo());
		sysAccountMarginRentModel.setCommodityType(String.valueOf(info.getCommodityType()));
		sysAccountMarginRentModel.setContractNo(info.getContractNo());
		sysAccountMarginRentModel.setCurrencyGroupNo(info.getCurrencyGroupNo());
		sysAccountMarginRentModel.setCurrencyNo(info.getCurrencyNo());
		sysAccountMarginRentModel.setExchangeNo(info.getExchangeNo());
		sysAccountMarginRentModel.setInitialMargin(BigDecimal.valueOf(info.getInitialMargin()));
		sysAccountMarginRentModel.setLockMargin(BigDecimal.valueOf(info.getLockMargin()));
		sysAccountMarginRentModel.setMaintenanceMargin(BigDecimal.valueOf(info.getMaintenanceMargin()));
		sysAccountMarginRentModel.setSellInitialMargin(BigDecimal.valueOf(info.getSellInitialMargin()));
		sysAccountMarginRentModel.setSellMaintenanceMargin(BigDecimal.valueOf(info.getSellMaintenanceMargin()));
		sysAccountMarginRentModel.setStrikePrice("0");
		sysAccountMarginRentService.saveSysAccountMarginRent(sysAccountMarginRentModel);


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
