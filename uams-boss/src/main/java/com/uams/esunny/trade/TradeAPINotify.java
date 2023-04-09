package com.uams.esunny.trade;

import com.alibaba.fastjson.JSON;
import esunny.futures.wp.trade.api.EsunnyWPTradeAPINotify;
import esunny.futures.wp.trade.struct.*;

public class TradeAPINotify extends EsunnyWPTradeAPINotify {

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
		// System.out.println("查询资金账户信息:onRspQryAccount "+JSON.toJSONString(info));
		System.out.println("查询资金账户信息:onRspQryAccount-------------------------------------------------开始");
		System.out.println("账号英文简称:"+info.getAccountEnShortName());
		System.out.println("资金账号:"+info.getAccountNo());
		System.out.println("账号简称:"+info.getAccountShortName());
		System.out.println("账号状态:"+info.getAccountState());
		System.out.println("交易状态:"+info.getAccountTradeRight());
		System.out.println("账号类型:"+info.getAccountType());
		System.out.println("可交易品种组:"+info.getCommodityGroupNo());
		System.out.println("查询资金账户信息:onRspQryAccount-------------------------------------------------------结束");
	}

	@Override
	public void onRspQryFund(int sessionID, int errorCode, byte isLast, TapAPIFundData info) {
		// System.out.println("查询资金账号资金信息:onRspQryFund "+JSON.toJSONString(info));
		System.out.println("查询资金账号资金信息:onRspQryFund--------------------------------------------------开始");
		System.out.println("客户交割手续费:"+info.getAccountDeliveryFee());
		System.out.println("客户手续费包含交割手续费:"+info.getAccountFee());
		System.out.println("客户初始保证金:"+info.getAccountIntialMargin());
		System.out.println("客户维持保证金:"+info.getAccountMaintenanceMargin());
		System.out.println("客户资金账号:"+info.getAccountNo());
		System.out.println("授信资金:"+info.getAuthMoney());
		System.out.println("当日可用:"+info.getAvailable());
		System.out.println("当日结存:"+info.getBalance());
		System.out.println("可提取:"+info.getCanDraw());
		System.out.println("资金调整:"+info.getCashAdjustValue());
		System.out.println("入金:"+info.getCashInValue());
		System.out.println("出金:"+info.getCashOutValue());
		System.out.println("质押资金:"+info.getCashPledged());
		System.out.println("平仓盈亏:"+info.getCloseProfit());
		System.out.println("币种组号:"+info.getCurrencyGroupNo());
		System.out.println("币种号:"+info.getCurrencyNo());
		System.out.println("交割盈亏:"+info.getDeliveryProfit());
		System.out.println("LME贴现:"+info.getDiscount());
		System.out.println("当日权益:"+info.getEquity());
		System.out.println("汇兑手续费:"+info.getExchangeFee());
		System.out.println("到期平仓盈亏:"+info.getExpProfit());
		System.out.println("冻结保证金:"+info.getFrozenDeposit());
		System.out.println("冻结手续费:"+info.getFrozenFee());
		System.out.println("期货算法:"+info.getFutureAlg());
		System.out.println("ME持仓盈亏:"+info.getLmePositionProfit());
		System.out.println("账户市值:"+info.getMarketEquity());
		System.out.println("期权算法:"+info.getOptionAlg());
		System.out.println("期权市值:"+info.getOptionMarketValue());
		System.out.println("不含LME持仓盈亏:"+info.getPositionProfit());
		System.out.println("上日可用:"+info.getPreAvailable1());
		System.out.println("上日结存:"+info.getPreBalance());
		System.out.println("上日权益:"+info.getPreEquity());
		System.out.println("上日LME持仓平盈:"+info.getPreLMEPositionProfit());
		System.out.println("上日市值权益:"+info.getPreMarketEquity());
		System.out.println("权利金收取:"+info.getPremiumIncome());
		System.out.println("利金支付:"+info.getPremiumPay());
		System.out.println("上日未到期平盈:"+info.getPreUnExpProfit());
		System.out.println("交易汇率:"+info.getTradeRate());
		System.out.println("未到期平盈:"+info.getUnExpProfit());
		System.out.println("上手初始保证金:"+info.getUpperInitalMargin());
		System.out.println("上手维持保证金:"+info.getUpperMaintenanceMargin());
		System.out.println("查询资金账号资金信息:onRspQryFund----------------------------------------结束");
	}

	@Override
	public void onRtnFund(TapAPIFundData info) {
		// System.out.println("资金变化通知:onRtnFund "+JSON.toJSONString(info));
		System.out.println("资金变化通知:onRtnFund------------------------------------------------开始");
		System.out.println("客户交割手续费:"+info.getAccountDeliveryFee());
		System.out.println("客户手续费包含交割手续费:"+info.getAccountFee());
		System.out.println("客户初始保证金:"+info.getAccountIntialMargin());
		System.out.println("客户维持保证金:"+info.getAccountMaintenanceMargin());
		System.out.println("客户资金账号:"+info.getAccountNo());
		System.out.println("授信资金:"+info.getAuthMoney());
		System.out.println("当日可用:"+info.getAvailable());
		System.out.println("当日结存:"+info.getBalance());
		System.out.println("资金调整:"+info.getCashAdjustValue());
		System.out.println("入金:"+info.getCashInValue());
		System.out.println("出金:"+info.getCashOutValue());
		System.out.println("质押资金:"+info.getCashOutValue());
		System.out.println("平仓盈亏:"+info.getCloseProfit());
		System.out.println("币种组号:"+info.getCurrencyGroupNo());
		System.out.println("币种号:"+info.getCurrencyNo());
		System.out.println("交割盈亏:"+info.getDeliveryProfit());
		System.out.println("LME贴现:"+info.getEquity());
		System.out.println("当日权益:"+info.getEquity());
		System.out.println("汇兑手续费:"+info.getExchangeFee());
		System.out.println("到期平仓盈亏:"+info.getExpProfit());
		System.out.println("冻结保证金:"+info.getFrozenDeposit());
		System.out.println("冻结手续费:"+info.getFrozenFee());
		System.out.println("期货算法:"+info.getFutureAlg());
		System.out.println("ME持仓盈亏:"+info.getLmePositionProfit());
		System.out.println("账户市值:"+info.getMarketEquity());
		System.out.println("期权算法:"+info.getOptionAlg());
		System.out.println("期权市值:"+info.getOptionMarketValue());
		System.out.println("资金变化通知:onRtnFund------------------------------------------------结束");
	}

	@Override
	public void onRspQryExchange(int sessionID, int errorCode, byte isLast, TapAPIExchangeInfo info) {
		System.out.println("onRspQryExchange "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryCommodity(int sessionID, int errorCode, byte isLast, TapAPICommodityInfo info) {
		// System.out.println("onRspQryCommodity "+JSON.toJSONString(info));
		System.out.println("onRspQryCommodity 合约品种查询------------------------------------------------------------------------------------------------------------------开始");
		System.out.println("新增时间:"+info.getAddOneTime());
		System.out.println("组合方向"+info.getCmbDirect());
		System.out.println("报价分母:"+info.getCommodityDenominator());
		System.out.println("品种英文名称:"+info.getCommodityEngName());
		System.out.println("品种名称:"+info.getCommodityName());
		System.out.println("品种编号:"+info.getCommodityNo());
		System.out.println("最小变动价位:"+info.getCommodityTickSize());
		System.out.println("时区:"+info.getCommodityTimeZone());
		System.out.println("合约乘数:"+info.getContractSize());
		System.out.println("币种组:"+info.getCurrencyGroupNo());
		System.out.println("交割天数:"+info.getDeliveryDays());
		System.out.println("交割方式:"+info.getDeliveryMode());
		System.out.println("交易所编号:"+info.getExchangeNo());
		System.out.println("开平方式:"+info.getOpenCloseMode());
		System.out.println("关联品种编号1:"+info.getRelateCommodityNo());
		System.out.println("关联品种编号2:"+info.getRelateCommodityNo2());
		System.out.println("关联品种类型1:"+info.getRelateCommodityType());
		System.out.println("关联交易所编号1:"+info.getRelateCommodityNo());
		System.out.println("关联交易所编号2:"+info.getRelateExchangeNo2());
		System.out.println("执行价格倍数:"+info.getStrikePriceTimes());
		System.out.println("交易币种:"+info.getTradeCurrency());
		System.out.println("onRspQryCommodity 合约品种查询------------------------------------------------------------------------------------------------------------------结束");
	}

	@Override
	public void onRspQryContract(int sessionID, int errorCode, byte isLast, TapAPITradeContractInfo info) {
		//System.out.println("onRspQryContract 合约查询"+JSON.toJSONString(info));
		System.out.println("onRspQryContract 合约查询------------------------------------------------------------------------------------------------------------------开始");
		System.out.println("看涨看跌标示1："+info.getCallOrPutFlag1());
		System.out.println("看涨看跌标示2："+info.getCallOrPutFlag2());
		System.out.println("品种编号："+info.getCommodityNo());
		System.out.println("品种类型："+info.getCommodityType());
		System.out.println("合约到期日："+info.getContractExpDate());
		System.out.println("合约名称："+info.getContractName());
		System.out.println("合约代码1："+info.getContractNo1());
		System.out.println("合约代码2："+info.getContractNo2());
		System.out.println("合约类型："+info.getContractType());
		System.out.println("交易所编码："+info.getExchangeNo());
		System.out.println("首次通知日："+info.getFirstNoticeDate());
		System.out.println("最后交易日："+info.getLastTradeDate());
		System.out.println("行情真实合约："+info.getQuoteUnderlyingContract());
		System.out.println("执行价1："+info.getStrikePrice1());
		System.out.println("执行价2："+info.getStrikePrice2());
		System.out.println("onRspQryContract 合约查询------------------------------------------------------------------------------------------------------------------结束");
	}

	@Override
	public void onRtnContract(TapAPITradeContractInfo info) {
		System.out.println("onRtnContract "+JSON.toJSONString(info));
	}

	@Override
	public void onRspOrderAction(int sessionID, int errorCode, TapAPIOrderActionRsp info) {
		// System.out.println("委托实时响应:onRspOrderAction "+JSON.toJSONString(info));
		System.out.println("委托实时响应:onRspOrderAction-----------------------------------------开始");
		System.out.println("操作类型"+info.getActionType());
		System.out.println("客户资金帐号"+info.getOrderInfo().getAccountNo());
		System.out.println("是否T+1有效"+info.getOrderInfo().getAddOneIsValid());
		System.out.println("看涨看跌1"+info.getOrderInfo().getCallOrPutFlag());
		System.out.println("看涨看跌2"+info.getOrderInfo().getCallOrPutFlag2());
		System.out.println("客户子账号."+info.getOrderInfo().getClientID());
		System.out.println("终端网络地址."+info.getOrderInfo().getClientIP());
		System.out.println("终端本地IP"+info.getOrderInfo().getClientLocalIP());
		System.out.println("终端本地Mac地址"+info.getOrderInfo().getClientMac());
		System.out.println("客户端本地委托编号"+info.getOrderInfo().getClientOrderNo());
		System.out.println("品种编号"+info.getOrderInfo().getCommodityNo());
		System.out.println("品种类型"+info.getOrderInfo().getCommodityType());
		System.out.println("合约1"+info.getOrderInfo().getContractNo());
		System.out.println("合约2"+info.getOrderInfo().getContractNo2());
		System.out.println("错误信息码"+info.getOrderInfo().getErrorCode());
		System.out.println("错误信息"+info.getOrderInfo().getErrorText());
		System.out.println("交易所编号"+info.getOrderInfo().getExchangeNo());
		System.out.println("有效日期(GTD情况下使用)"+info.getOrderInfo().getExpireTime());
		System.out.println("投机保值"+info.getOrderInfo().getHedgeFlag());
		System.out.println("询价号"+info.getOrderInfo().getInquiryNo());
		System.out.println("是否为T+1单"+info.getOrderInfo().getIsAddOne());
		System.out.println("是否为录入委托单"+info.getOrderInfo().getIsBackInput());
		System.out.println("委托成交删除标志"+info.getOrderInfo().getIsDeleted());
		System.out.println("是否风险报单"+info.getOrderInfo().getIsRiskOrder());
		System.out.println("软件授权号"+info.getOrderInfo().getLicenseNo());
		System.out.println("冰山单最大随机量"+info.getOrderInfo().getMaxClipSize());
		System.out.println("冰山单最小随机量"+info.getOrderInfo().getMinClipSize());
		System.out.println("录单操作人"+info.getOrderInfo().getOrderCommandUserNo());
		System.out.println("交易所系统号"+info.getOrderInfo().getOrderExchangeSystemNo());
		System.out.println("下单时间"+info.getOrderInfo().getOrderInsertTime());
		System.out.println("下单人"+info.getOrderInfo().getOrderInsertUserNo());
		System.out.println("本地号"+info.getOrderInfo().getOrderLocalNo());
		System.out.println("成交价1"+info.getOrderInfo().getOrderMatchPrice());
		System.out.println("成交价2"+info.getOrderInfo().getOrderMatchPrice2());
		System.out.println("成交量1"+info.getOrderInfo().getOrderMatchQty());
		System.out.println("成交量2"+info.getOrderInfo().getOrderMatchQty2());
		System.out.println("最小成交量"+info.getOrderInfo().getOrderMinQty());
		System.out.println("委托编码"+info.getOrderInfo().getOrderNo());
		System.out.println("父单系统号"+info.getOrderInfo().getOrderParentSystemNo());
		System.out.println("委托价格1"+info.getOrderInfo().getOrderPrice());
		System.out.println("委托价格2"+info.getOrderInfo().getOrderPrice2());
		System.out.println("委托数量"+info.getOrderInfo().getOrderQty());
		System.out.println("买入卖出"+info.getOrderInfo().getOrderSide());
		System.out.println("委托来源"+info.getOrderInfo().getOrderSource());
		System.out.println("委托状态"+info.getOrderInfo().getOrderState());
		System.out.println("委托流水号"+info.getOrderInfo().getOrderStreamID());
		System.out.println("系统号"+info.getOrderInfo().getOrderSystemNo());
		System.out.println("委托类型"+info.getOrderInfo().getOrderType());
		System.out.println("委托更新时间"+info.getOrderInfo().getOrderUpdateTime());
		System.out.println("委托更新人"+info.getOrderInfo().getOrderUpdateUserNo());
		System.out.println("开平标志1"+info.getOrderInfo().getPositionEffect());
		System.out.println("开平标志2"+info.getOrderInfo().getPositionEffect2());
		System.out.println("浮点参考值"+info.getOrderInfo().getRefDouble());
		System.out.println("整型参考值"+info.getOrderInfo().getRefInt());
		System.out.println("字符串参考值"+info.getOrderInfo().getRefString());
		System.out.println("服务器标识"+info.getOrderInfo().getServerFlag());
		System.out.println("触发价格"+info.getOrderInfo().getStopPrice());
		System.out.println("执行价格1"+info.getOrderInfo().getStrikePrice());
		System.out.println("执行价格2"+info.getOrderInfo().getStrikePrice2());
		System.out.println("策略单类型"+info.getOrderInfo().getTacticsType());
		System.out.println("委托有效类型"+info.getOrderInfo().getTimeInForce());
		System.out.println("触发条件"+info.getOrderInfo().getTriggerCondition());
		System.out.println("触发价格类型"+info.getOrderInfo().getTriggerPriceType());
		System.out.println("上手通道号"+info.getOrderInfo().getUpperChannelNo());
		System.out.println("上手号"+info.getOrderInfo().getUpperNo());
		System.out.println("上手流号"+info.getOrderInfo().getUpperStreamID());
		System.out.println("委托实时响应:onRspOrderAction-----------------------------------------结束");
	}

	@Override
	public void onRtnOrder(TapAPIOrderInfoNotice info) {
        // System.out.println("委托变化通知:onRtnOrder "+JSON.toJSONString(info));
		System.out.println("委托变化通知:onRtnOrder----------------------------------------开始");
		System.out.println("错误码:"+info.getErrorCode());
		System.out.println("客户资金帐号:"+info.getOrderInfo().getAccountNo());
		System.out.println("是否T+1有效:"+info.getOrderInfo().getAddOneIsValid());
		System.out.println("看涨看跌1:"+info.getOrderInfo().getCallOrPutFlag());
		System.out.println("看涨看跌2:"+info.getOrderInfo().getCallOrPutFlag2());
		System.out.println("客户子账号.:"+info.getOrderInfo().getClientID());
		System.out.println("终端网络地址.:"+info.getOrderInfo().getClientIP());
		System.out.println("终端本地IP:"+info.getOrderInfo().getClientLocalIP());
		System.out.println("终端本地Mac地址:"+info.getOrderInfo().getClientMac());
		System.out.println("客户端本地委托编号:"+info.getOrderInfo().getClientOrderNo());
		System.out.println("品种编号:"+info.getOrderInfo().getCommodityNo());
		System.out.println("品种类型:"+info.getOrderInfo().getCommodityType());
		System.out.println("合约1:"+info.getOrderInfo().getContractNo());
		System.out.println("合约2:"+info.getOrderInfo().getContractNo2());
		System.out.println("错误信息码:"+info.getOrderInfo().getErrorCode());
		System.out.println("错误信息:"+info.getOrderInfo().getErrorText());
		System.out.println("交易所编号:"+info.getOrderInfo().getExchangeNo());
		System.out.println("有效日期(GTD情况下使用):"+info.getOrderInfo().getExpireTime());
		System.out.println("投机保值:"+info.getOrderInfo().getHedgeFlag());
		System.out.println("询价号:"+info.getOrderInfo().getInquiryNo());
		System.out.println("是否为T+1单:"+info.getOrderInfo().getIsAddOne());
		System.out.println("是否为录入委托单:"+info.getOrderInfo().getIsBackInput());
		System.out.println("委托成交删除标志:"+info.getOrderInfo().getIsDeleted());
		System.out.println("是否风险报单:"+info.getOrderInfo().getIsRiskOrder());
		System.out.println("软件授权号:"+info.getOrderInfo().getLicenseNo());
		System.out.println("冰山单最大随机量:"+info.getOrderInfo().getMaxClipSize());
		System.out.println("冰山单最小随机量:"+info.getOrderInfo().getMinClipSize());
		System.out.println("录单操作人:"+info.getOrderInfo().getOrderCommandUserNo());
		System.out.println("交易所系统号:"+info.getOrderInfo().getOrderExchangeSystemNo());
		System.out.println("下单时间:"+info.getOrderInfo().getOrderInsertTime());
		System.out.println("下单人:"+info.getOrderInfo().getOrderInsertUserNo());
		System.out.println("本地号:"+info.getOrderInfo().getOrderLocalNo());
		System.out.println("成交价1:"+info.getOrderInfo().getOrderMatchPrice());
		System.out.println("成交价2:"+info.getOrderInfo().getOrderMatchPrice2());
		System.out.println("成交量1:"+info.getOrderInfo().getOrderMatchQty());
		System.out.println("成交量2:"+info.getOrderInfo().getOrderMatchQty2());
		System.out.println("最小成交量:"+info.getOrderInfo().getOrderMinQty());
		System.out.println("委托编码:"+info.getOrderInfo().getOrderNo());
		System.out.println("父单系统号:"+info.getOrderInfo().getOrderParentSystemNo());
		System.out.println("委托价格1:"+info.getOrderInfo().getOrderPrice());
		System.out.println("委托价格2:"+info.getOrderInfo().getOrderPrice2());
		System.out.println("委托数量:"+info.getOrderInfo().getOrderQty());
		System.out.println("买入卖出:"+info.getOrderInfo().getOrderSide());
		System.out.println("委托来源:"+info.getOrderInfo().getOrderSource());
		System.out.println("委托状态:"+info.getOrderInfo().getOrderState());
		System.out.println("委托流水号:"+info.getOrderInfo().getOrderStreamID());
		System.out.println("系统号:"+info.getOrderInfo().getOrderSystemNo());
		System.out.println("委托类型:"+info.getOrderInfo().getOrderType());
		System.out.println("委托更新时间:"+info.getOrderInfo().getOrderUpdateTime());
		System.out.println("委托更新人:"+info.getOrderInfo().getOrderUpdateUserNo());
		System.out.println("开平标志1:"+info.getOrderInfo().getPositionEffect());
		System.out.println("开平标志2:"+info.getOrderInfo().getPositionEffect2());
		System.out.println("浮点参考值:"+info.getOrderInfo().getRefDouble());
		System.out.println("整型参考值:"+info.getOrderInfo().getRefInt());
		System.out.println("字符串参考值:"+info.getOrderInfo().getRefString());
		System.out.println("服务器标识:"+info.getOrderInfo().getServerFlag());
		System.out.println("触发价格:"+info.getOrderInfo().getStopPrice());
		System.out.println("执行价格1:"+info.getOrderInfo().getStrikePrice());
		System.out.println("执行价格2:"+info.getOrderInfo().getStrikePrice2());
		System.out.println("策略单类型:"+info.getOrderInfo().getTacticsType());
		System.out.println("委托有效类型:"+info.getOrderInfo().getTimeInForce());
		System.out.println("触发条件:"+info.getOrderInfo().getTriggerCondition());
		System.out.println("触发价格类型:"+info.getOrderInfo().getTriggerPriceType());
		System.out.println("上手通道号:"+info.getOrderInfo().getUpperChannelNo());
		System.out.println("上手号:"+info.getOrderInfo().getUpperNo());
		System.out.println("上手流号:"+info.getOrderInfo().getUpperStreamID());
		System.out.println("会话ID:"+info.getSessionID());
		System.out.println("委托变化通知:onRtnOrder----------------------------------------结束");
	}

	@Override
	public void onRspQryOrder(int sessionID, int errorCode, byte isLast, TapAPIOrderInfo info) {
		// System.out.println("查询委托信息:onRspQryOrder "+JSON.toJSONString(info));
		System.out.println("查询委托信息:onRspQryOrder--------------------------------------开始");
		System.out.println("客户资金帐号:"+info.getAccountNo());
		System.out.println("是否T+1有效:"+info.getAddOneIsValid());
		System.out.println("看涨看跌1:"+info.getCallOrPutFlag());
		System.out.println("看涨看跌2:"+info.getCallOrPutFlag2());
		System.out.println("客户子账号.:"+info.getClientID());
		System.out.println("终端网络地址.:"+info.getClientIP());
		System.out.println("终端本地IP:"+info.getClientLocalIP());
		System.out.println("终端本地Mac地址:"+info.getClientMac());
		System.out.println("客户端本地委托编号:"+info.getClientOrderNo());
		System.out.println("品种编号:"+info.getCommodityNo());
		System.out.println("品种类型:"+info.getCommodityType());
		System.out.println("合约1:"+info.getContractNo());
		System.out.println("合约2:"+info.getContractNo2());
		System.out.println("错误信息码:"+info.getErrorCode());
		System.out.println("错误信息:"+info.getErrorText());
		System.out.println("交易所编号:"+info.getExchangeNo());
		System.out.println("有效日期(GTD情况下使用):"+info.getExpireTime());
		System.out.println("投机保值:"+info.getHedgeFlag());
		System.out.println("询价号:"+info.getInquiryNo());
		System.out.println("是否为T+1单:"+info.getIsAddOne());
		System.out.println("是否为录入委托单:"+info.getIsBackInput());
		System.out.println("委托成交删除标志:"+info.getIsDeleted());
		System.out.println("是否风险报单:"+info.getIsRiskOrder());
		System.out.println("软件授权号:"+info.getLicenseNo());
		System.out.println("冰山单最大随机量:"+info.getMaxClipSize());
		System.out.println("冰山单最小随机量:"+info.getMinClipSize());
		System.out.println("录单操作人:"+info.getOrderCommandUserNo());
		System.out.println("交易所系统号:"+info.getOrderExchangeSystemNo());
		System.out.println("下单时间:"+info.getOrderInsertTime());
		System.out.println("下单人:"+info.getOrderInsertUserNo());
		System.out.println("本地号:"+info.getOrderLocalNo());
		System.out.println("成交价1:"+info.getOrderMatchPrice());
		System.out.println("成交价2:"+info.getOrderMatchPrice2());
		System.out.println("成交量1:"+info.getOrderMatchQty());
		System.out.println("成交量2:"+info.getOrderMatchQty2());
		System.out.println("最小成交量:"+info.getOrderMinQty());
		System.out.println("委托编码:"+info.getOrderNo());
		System.out.println("父单系统号:"+info.getOrderParentSystemNo());
		System.out.println("委托价格1:"+info.getOrderPrice());
		System.out.println("委托价格2:"+info.getOrderPrice2());
		System.out.println("委托数量:"+info.getOrderQty());
		System.out.println("买入卖出:"+info.getOrderSide());
		System.out.println("委托来源:"+info.getOrderSource());
		System.out.println("委托状态:"+info.getOrderState());
		System.out.println("委托流水号:"+info.getOrderStreamID());
		System.out.println("系统号:"+info.getOrderSystemNo());
		System.out.println("委托类型:"+info.getOrderType());
		System.out.println("委托更新时间:"+info.getOrderUpdateTime());
		System.out.println("委托更新人:"+info.getOrderUpdateUserNo());
		System.out.println("开平标志1:"+info.getPositionEffect());
		System.out.println("开平标志2:"+info.getPositionEffect2());
		System.out.println("浮点参考值:"+info.getRefDouble());
		System.out.println("整型参考值:"+info.getRefInt());
		System.out.println("字符串参考值:"+info.getRefString());
		System.out.println("服务器标识:"+info.getServerFlag());
		System.out.println("触发价格:"+info.getStopPrice());
		System.out.println("执行价格1:"+info.getStrikePrice());
		System.out.println("执行价格2:"+info.getStrikePrice2());
		System.out.println("策略单类型:"+info.getTacticsType());
		System.out.println("委托有效类型:"+info.getTimeInForce());
		System.out.println("触发条件:"+info.getTriggerCondition());
		System.out.println("触发价格类型:"+info.getTriggerPriceType());
		System.out.println("上手通道号:"+info.getUpperChannelNo());
		System.out.println("上手号:"+info.getUpperNo());
		System.out.println("上手流号:"+info.getUpperStreamID());
		System.out.println("查询委托信息:onRspQryOrder--------------------------------------结束");
	}

	@Override
	public void onRspQryOrderProcess(int sessionID, int errorCode, byte isLast, TapAPIOrderInfo info) {
		System.out.println("查询委托处理状态:onRspQryOrderProcess "+JSON.toJSONString(info));

		System.out.println("客户资金帐号:"+info.getAccountNo());
		System.out.println("是否T+1有效:"+info.getAddOneIsValid());
		System.out.println("看涨看跌1:"+info.getCallOrPutFlag());
		System.out.println("看涨看跌2:"+info.getCallOrPutFlag2());
		System.out.println("客户子账号.:"+info.getClientID());
		System.out.println("终端网络地址.:"+info.getClientIP());
		System.out.println("终端本地IP:"+info.getClientLocalIP());
		System.out.println("终端本地Mac地址:"+info.getClientMac());
		System.out.println("客户端本地委托编号:"+info.getClientOrderNo());
		System.out.println("品种编号:"+info.getCommodityNo());
		System.out.println("品种类型:"+info.getCommodityType());
		System.out.println("合约1:"+info.getContractNo());
		System.out.println("合约2:"+info.getContractNo2());
		System.out.println("错误信息码:"+info.getErrorCode());
		System.out.println("错误信息:"+info.getErrorText());
		System.out.println("交易所编号:"+info.getExchangeNo());
		System.out.println("有效日期(GTD情况下使用):"+info.getExpireTime());
		System.out.println("投机保值:"+info.getHedgeFlag());
		System.out.println("询价号:"+info.getInquiryNo());
		System.out.println("是否为T+1单:"+info.getIsAddOne());
		System.out.println("是否为录入委托单:"+info.getIsBackInput());
		System.out.println("委托成交删除标志:"+info.getIsDeleted());
		System.out.println("是否风险报单:"+info.getIsRiskOrder());
		System.out.println("软件授权号:"+info.getLicenseNo());
		System.out.println("冰山单最大随机量:"+info.getMaxClipSize());
		System.out.println("冰山单最小随机量:"+info.getMinClipSize());
		System.out.println("录单操作人:"+info.getOrderCommandUserNo());
		System.out.println("交易所系统号:"+info.getOrderExchangeSystemNo());
		System.out.println("下单时间:"+info.getOrderInsertTime());
		System.out.println("下单人:"+info.getOrderInsertUserNo());
		System.out.println("本地号:"+info.getOrderLocalNo());
		System.out.println("成交价1:"+info.getOrderMatchPrice());
		System.out.println("成交价2:"+info.getOrderMatchPrice2());
		System.out.println("成交量1:"+info.getOrderMatchQty());
		System.out.println("成交量2:"+info.getOrderMatchQty2());
		System.out.println("最小成交量:"+info.getOrderMinQty());
		System.out.println("委托编码:"+info.getOrderNo());
		System.out.println("父单系统号:"+info.getOrderParentSystemNo());
		System.out.println("委托价格1:"+info.getOrderPrice());
		System.out.println("委托价格2:"+info.getOrderPrice2());
		System.out.println("委托数量:"+info.getOrderQty());
		System.out.println("买入卖出:"+info.getOrderSide());
		System.out.println("委托来源:"+info.getOrderSource());
		System.out.println("委托状态:"+info.getOrderState());
		System.out.println("委托流水号:"+info.getOrderStreamID());
		System.out.println("系统号:"+info.getOrderSystemNo());
		System.out.println("委托类型:"+info.getOrderType());
		System.out.println("委托更新时间:"+info.getOrderUpdateTime());
		System.out.println("委托更新人:"+info.getOrderUpdateUserNo());
		System.out.println("开平标志1:"+info.getPositionEffect());
		System.out.println("开平标志2:"+info.getPositionEffect2());
		System.out.println("浮点参考值:"+info.getRefDouble());
		System.out.println("整型参考值:"+info.getRefInt());
		System.out.println("字符串参考值:"+info.getRefString());
		System.out.println("服务器标识:"+info.getServerFlag());
		System.out.println("触发价格:"+info.getStopPrice());
		System.out.println("执行价格1:"+info.getStrikePrice());
		System.out.println("执行价格2:"+info.getStrikePrice2());
		System.out.println("策略单类型:"+info.getTacticsType());
		System.out.println("委托有效类型:"+info.getTimeInForce());
		System.out.println("触发条件:"+info.getTriggerCondition());
		System.out.println("触发价格类型:"+info.getTriggerPriceType());
		System.out.println("上手通道号:"+info.getUpperChannelNo());
		System.out.println("上手号:"+info.getUpperNo());
		System.out.println("上手流号:"+info.getUpperStreamID());
	}

	@Override
	public void onRspQryFill(int sessionID, int errorCode, byte isLast, TapAPIFillInfo info) {
		System.out.println("查询成交信息:onRspQryFill "+JSON.toJSONString(info));

		System.out.println("客户资金帐号"+info.getAccountNo());
		System.out.println("看涨看跌"+info.getCallOrPutFlag());
		System.out.println("指定价格平仓"+info.getClosePrositionPrice());

		System.out.println("品种编号"+info.getCommodityNo());
		System.out.println("品种类型"+info.getCommodityType());
		System.out.println("合约1"+info.getContractNo());
		System.out.println("交易所编号"+info.getExchangeNo());
		System.out.println("手续费币种"+info.getFeeCurrency());
		System.out.println("手续费币种组"+info.getFeeCurrencyGroup());
		System.out.println("手续费"+info.getFeeValue());
		System.out.println("是否为T+1单"+info.getIsAddOne());
		System.out.println("委托成交删除标"+info.getIsDeleted());

		System.out.println("人工客户手续费标记"+info.getIsManualFee());
		System.out.println("成交时间"+info.getMatchDateTime());
		System.out.println("本地成交号"+info.getMatchNo());
		System.out.println("成交价"+info.getMatchPrice());
		System.out.println("成交量"+info.getMatchQty());
		System.out.println("买入卖出"+info.getMatchSide());
		System.out.println("委托来源"+info.getMatchSource());
		System.out.println("委托编码"+info.getOrderNo());
		System.out.println("系统号"+info.getOrderSystemNo());

		System.out.println("开平标志1"+info.getPositionEffect());
		System.out.println("服务器标识"+info.getServerFlag());
		System.out.println("执行价格"+info.getStrikePrice());
		System.out.println("上手成交时间"+info.getUpperMatchDateTime());

		System.out.println("上手成交号"+info.getUpperMatchNo());
		System.out.println("上手号"+info.getUpperNo());
	}

	@Override
	public void onRtnFill(TapAPIFillInfo info) {
		System.out.println("成交变化通知:onRtnFill "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryPosition(int sessionID, int errorCode, byte isLast, TapAPIPositionInfo info) {
		// System.out.println("查询期货持仓:onRspQryPosition "+JSON.toJSONString(info));
		System.out.println("查询期货持仓:onRspQryPosition--------------------------------------开始");
		System.out.println("客户初始保证金:"+info.getAccountInitialMargin());
		System.out.println("客户维持保证金:"+info.getAccountMaintenanceMargin());
		System.out.println("客户资金账号:"+info.getAccountNo());
		System.out.println("当前计算价格:"+info.getCalculatePrice());
		System.out.println("看张看跌:"+info.getCallOrPutFlag());
		System.out.println("品种币种:"+info.getCommodityCurrency());
		System.out.println("品种币种组:"+info.getCommodityCurrencyGroup());
		System.out.println("品种编码:"+info.getCommodityNo());
		System.out.println("品种类型:"+info.getCommodityType());
		System.out.println("合约1:"+info.getContractNo());
		System.out.println("交易所编号:"+info.getExchangeNo());
		System.out.println("投机保值:"+info.getHedgeFlag());
		System.out.println("LME持仓盈亏:"+info.getLMEPositionProfit());
		System.out.println("本地成交号:"+info.getMatchNo());
		System.out.println("买入卖出:"+info.getMatchSide());
		System.out.println("期权市值:"+info.getOptionMarketValue());
		System.out.println("委托编码:"+info.getOrderNo());
		System.out.println("本地持仓号:"+info.getPositionNo());
		System.out.println("持仓价:"+info.getPositionPrice());
		System.out.println("持仓盈亏:"+info.getPositionProfit());
		System.out.println("持仓流号:"+info.getPositionStreamId());
		System.out.println("服务器标识:"+info.getServerFlag());
		System.out.println("执行价格:"+info.getStrikePrice());
		System.out.println("上手初始保证金:"+info.getUpperInitialMargin());
		System.out.println("上手维持保证金:"+info.getUpperMaintenanceMargin());
		System.out.println("上手号:"+info.getUpperNo());
		System.out.println("查询期货持仓:onRspQryPosition--------------------------------------结束");
	}

	@Override
	public void onRtnPosition(TapAPIPositionInfo info) {
		System.out.println("持仓变化通知:onRtnPosition "+JSON.toJSONString(info));
	}

	@Override
	public void onRtnPositionProfit(TapAPIPositionProfitNotice info) {
		// System.out.println("持仓损益通知:onRtnPosition "+JSON.toJSONString(info));
		System.out.println("持仓损益通知:onRtnPosition--------------------------------------开始");
		if(null != info){
			System.out.println("当前计算价格:"+info.getOrderInfo().getCalculatePrice());
			System.out.println("LME持仓盈亏:"+info.getOrderInfo().getLMEPositionProfit());
			System.out.println("期权市值:"+info.getOrderInfo().getOptionMarketValue());
			System.out.println("本地持仓号:"+info.getOrderInfo().getPositionNo());
			System.out.println("持仓价:"+info.getOrderInfo().getPositionProfit());
			System.out.println("持仓盈亏:"+info.getOrderInfo().getCalculatePrice());
		}
		System.out.println("持仓损益通知:onRtnPosition--------------------------------------结束");
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

		System.out.println("客户资金账号"+info.getAccountNo());
		System.out.println("计算方式"+info.getCalculateMode());
		System.out.println("平今费用"+info.getCloseTodayFee());
		System.out.println("品种编号"+info.getCommodityNo());
		System.out.println("品种类型"+info.getCommodityType());
		System.out.println("币种组"+info.getCurrencyGroupNo());
		System.out.println("币种"+info.getCurrencyNo());
		System.out.println("市场号"+info.getExchangeNo());
		System.out.println("成交来源"+info.getMatchSource());
		System.out.println("开平仓费用"+info.getOpenCloseFee());
	}

	@Override
	public void onRspQryAccountMarginRent(int sessionID, int errorCode, byte isLast, TapAPIAccountMarginRentQryRsp info) {
		System.out.println("查询账户保证金:onRspQryAccountMarginRent "+JSON.toJSONString(info));

		System.out.println("客户资金账号"+info.getAccountNo());

		System.out.println("计算方式"+info.getCalculateMode());
		System.out.println("看涨看跌标示"+info.getCallOrPutFlag());
		System.out.println("品种编号"+info.getCommodityNo());
		System.out.println("品种类型"+info.getCommodityType());
		System.out.println("合约代码"+info.getContractNo());
		System.out.println("币种组"+info.getCurrencyGroupNo());
		System.out.println("币种"+info.getCurrencyNo());
		System.out.println("市场号"+info.getExchangeNo());
		System.out.println("初始保证金"+info.getInitialMargin());

		System.out.println("锁仓保证金"+info.getLockMargin());
		System.out.println("维持保证金"+info.getMaintenanceMargin());
		System.out.println("卖出初始保证金"+info.getSellInitialMargin());
		System.out.println("卖出维持保证金"+info.getSellMaintenanceMargin());
		System.out.println("执行价"+info.getStrikePrice());
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
