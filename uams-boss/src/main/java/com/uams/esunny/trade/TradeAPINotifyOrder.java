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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TradeAPINotifyOrder extends EsunnyWPTradeAPINotify {

	@Autowired(required = false)
	private SysOrderChangeService sysOrderChangeService;

	@Autowired(required = false)
	private SysFillService sysFillService;

	@Autowired(required = false)
	private SysOrderProcessService sysOrderProcessService;

	@Autowired(required = false)
	private SysOrderService sysOrderService;

	@Autowired(required = false)
	private SysOrderActionService sysOrderActionService;


	//DecimalFormat myDecimalformat=new DecimalFormat("0.00");

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
		System.out.println("查询资金账户信息:onRspQryAccount "+JSON.toJSONString(info));
	}

	@Override
	public void onRspQryFund(int sessionID, int errorCode, byte isLast, TapAPIFundData info) {
		System.out.println("查询资金账号资金信息:onRspQryFund "+JSON.toJSONString(info));
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
		System.out.println("onRspQryContract 合约查询"+JSON.toJSONString(info));
	}

	@Override
	public void onRtnContract(TapAPITradeContractInfo info) {
		System.out.println("onRtnContract "+JSON.toJSONString(info));
	}

	@Override
	public void onRspOrderAction(int sessionID, int errorCode, TapAPIOrderActionRsp info) {
		System.out.println("委托实时响应:onRspOrderAction "+JSON.toJSONString(info));
		SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		//解析委托变化
		//得到ServiceBean
		sysOrderActionService = SpringContext.getBean(SysOrderActionService.class);
		SysOrderActionModel soam=new SysOrderActionModel();
		soam.setActionType(info.getActionType()+"");//操作类型
		soam.setAccountNo(info.getOrderInfo().getAccountNo());//客户资金帐号
		soam.setAddOneIsValid(info.getOrderInfo().getAddOneIsValid()+"");//是否T+1有效
		soam.setCallOrPutFlag(info.getOrderInfo().getCallOrPutFlag()+"");//看涨看跌1
		soam.setCallOrPutFlag2(info.getOrderInfo().getCallOrPutFlag2()+"");//看涨看跌2
		soam.setClientID(info.getOrderInfo().getClientID());//客户子账号.
		soam.setClientIP(info.getOrderInfo().getClientIP());//终端网络地址.
		soam.setClientLocalIP(info.getOrderInfo().getClientLocalIP());//终端本地IP
		soam.setClientMac(info.getOrderInfo().getClientMac());//终端本地Mac地址
		soam.setClientOrderNo(info.getOrderInfo().getClientOrderNo());//客户端本地委托编号
		soam.setCommodityNo(info.getOrderInfo().getCommodityNo());//品种编号
		soam.setCommodityType(info.getOrderInfo().getCommodityType()+"");//品种类型
		soam.setContractNo(info.getOrderInfo().getContractNo());//合约1
		soam.setContractNo2(info.getOrderInfo().getContractNo2());//合约2
		soam.setErrorCode(info.getOrderInfo().getErrorCode()+"");//错误信息码
		soam.setErrorText(info.getOrderInfo().getErrorText());//错误信息
		soam.setExchangeNo(info.getOrderInfo().getExchangeNo()+"");//交易所编号
		if(!"".equals(info.getOrderInfo().getExpireTime())) {
			try {
				soam.setExpireTime(simpleDateFormat2.parse(info.getOrderInfo().getExpireTime()));//有效日期(GTD情况下使用)
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		soam.setHedgeFlag(info.getOrderInfo().getHedgeFlag()+"");//投机保值
		soam.setInquiryNo(info.getOrderInfo().getInquiryNo());//询价号
		soam.setIsAddOne(info.getOrderInfo().getIsAddOne()+"");//是否为T+1单
		soam.setIsBackInput(info.getOrderInfo().getIsBackInput()+"");//是否为录入委托单
		soam.setIsDeleted(info.getOrderInfo().getIsDeleted()+"");//委托成交删除标志
		soam.setIsRiskOrder(info.getOrderInfo().getIsRiskOrder()+"");//是否风险报单
		soam.setLicenseNo(info.getOrderInfo().getLicenseNo());//软件授权号
		soam.setMaxClipSize(Long.valueOf(info.getOrderInfo().getMaxClipSize()));//冰山单最大随机量
		soam.setMinClipSize(Long.valueOf(info.getOrderInfo().getMinClipSize()));//冰山单最小随机量
		soam.setOrderCommandUserNo(info.getOrderInfo().getOrderCommandUserNo());//录单操作人
		soam.setOrderExchangeSystemNo(info.getOrderInfo().getOrderExchangeSystemNo());//交易所系统号
//		try {
//			soam.setOrderInsertTime(simpleDateFormat.parse(info.getOrderInfo().getOrderInsertTime()));//下单时间
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		try {
			String tt=info.getOrderInfo().getOrderInsertTime();
			String y=tt.substring(0,2);
			String m=tt.substring(2,4);
			String d=tt.substring(4,6);
			String h=tt.substring(6,8);
			String f=tt.substring(8,10);
			String s=tt.substring(10,12);
			soam.setOrderInsertTime(simpleDateFormat.parse(y+"/"+m+"/"+d+" "+h+":"+f+":"+s));//下单时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		soam.setOrderInsertUserNo(info.getOrderInfo().getOrderInsertUserNo());//下单人
		soam.setOrderLocalNo(info.getOrderInfo().getOrderLocalNo());//本地号

		soam.setOrderMatchPrice(BigDecimal.ZERO);
		soam.setOrderMatchPrice2(BigDecimal.ZERO);//成交价2
//		soam.setOrderMatchPrice(BigDecimal.valueOf(info.getOrderInfo().getOrderMatchPrice()));//成交价1
//		soam.setOrderMatchPrice2(BigDecimal.valueOf(info.getOrderInfo().getOrderMatchPrice2()));//成交价2

		soam.setOrderMatchQty(info.getOrderInfo().getOrderMatchQty());//成交量1
		soam.setOrderMatchQty2(info.getOrderInfo().getOrderMatchQty2());//成交量2
		soam.setOrderMinQty(info.getOrderInfo().getOrderMinQty());//最小成交量
		soam.setOrderNo(info.getOrderInfo().getOrderNo());//委托编码
		soam.setOrderParentSystemNo(info.getOrderInfo().getOrderParentSystemNo());//父单系统号
		soam.setOrderPrice(BigDecimal.valueOf(info.getOrderInfo().getOrderPrice()));//委托价格1
		soam.setOrderPrice2(BigDecimal.valueOf(info.getOrderInfo().getOrderPrice2()));//委托价格2
		soam.setOrderQty(Long.valueOf(info.getOrderInfo().getOrderQty()));//委托数量
		soam.setOrderSide(info.getOrderInfo().getOrderSide()+"");//买入卖出
		soam.setOrderSource(info.getOrderInfo().getOrderSource()+"");//委托来源
		soam.setOrderState(info.getOrderInfo().getOrderState()+"");//委托状态
		soam.setOrderStreamID(info.getOrderInfo().getOrderStreamID());//委托流水号
		soam.setOrderSystemNo(info.getOrderInfo().getOrderSystemNo());//系统号
		soam.setOrderType(info.getOrderInfo().getOrderType()+"");//委托类型
//		try {
//			soam.setOrderUpdateTime(simpleDateFormat.parse(info.getOrderInfo().getOrderUpdateTime()));//委托更新时间
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		if(!"".equals(info.getOrderInfo().getOrderUpdateTime())){
		try {
			String tt=info.getOrderInfo().getOrderUpdateTime();
			String y=tt.substring(0,2);
			String m=tt.substring(2,4);
			String d=tt.substring(4,6);
			String h=tt.substring(6,8);
			String f=tt.substring(8,10);
			String s=tt.substring(10,12);
			soam.setOrderUpdateTime(simpleDateFormat.parse(y+"/"+m+"/"+d+" "+h+":"+f+":"+s));//委托更新时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		soam.setOrderUpdateUserNo(info.getOrderInfo().getOrderUpdateUserNo());//委托更新人
		soam.setPositionEffect(info.getOrderInfo().getPositionEffect()+"");//开平标志1
		soam.setPositionEffect2(info.getOrderInfo().getPositionEffect2()+"");//开平标志2
		soam.setRefDouble(BigDecimal.valueOf(info.getOrderInfo().getRefDouble()));//浮点参考值
		soam.setRefInt(info.getOrderInfo().getRefInt());//整型参考值
		soam.setRefString(info.getOrderInfo().getRefString());//字符串参考值
		soam.setServerFlag(info.getOrderInfo().getServerFlag()+"");//服务器标识
		soam.setStopPrice(BigDecimal.valueOf(info.getOrderInfo().getStopPrice()));//触发价格

		if("".equals(info.getOrderInfo().getStrikePrice())){
//			soam.setStrikePrice(BigDecimal.ZERO);//执行价格1
		}else {
			soam.setStrikePrice(BigDecimal.valueOf(Double.parseDouble(info.getOrderInfo().getStrikePrice())));//执行价格1
		}
		if("".equals(info.getOrderInfo().getStrikePrice2())){
//			soam.setStrikePrice2(BigDecimal.ZERO);//执行价格1
		}else {
			soam.setStrikePrice2(BigDecimal.valueOf(Double.valueOf(info.getOrderInfo().getStrikePrice2())));//执行价格2
		}


		soam.setTacticsType(info.getOrderInfo().getTacticsType()+"");//策略单类型
		soam.setTimeInForce(info.getOrderInfo().getTimeInForce()+"");//委托有效类型
		soam.setTriggerCondition(info.getOrderInfo().getTriggerCondition()+"");//触发条件
		soam.setTriggerPriceType(info.getOrderInfo().getTriggerPriceType()+"");//触发价格类型
		soam.setUpperChannelNo(info.getOrderInfo().getUpperChannelNo());//上手通道号
		soam.setUpperNo(info.getOrderInfo().getUpperNo());//上手号
		soam.setUpperStreamID(info.getOrderInfo().getUpperStreamID());//上手流号
		soam.setRemark("");//备注
		soam.setId(SerialnoUtils.buildPrimaryKey());

		sysOrderActionService.saveRspOrderAction(soam);

	}

	@Override
	public void onRtnOrder(TapAPIOrderInfoNotice info) {
		System.out.println("委托变化通知:onRtnOrder "+JSON.toJSONString(info));
		SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		//解析委托变化
		//得到ServiceBean
		sysOrderChangeService = SpringContext.getBean(SysOrderChangeService.class);
		SysOrderChangeModel socm=new SysOrderChangeModel();
		socm.setErrorCode1(info.getErrorCode()+"");//错误码
		socm.setAccountNo(info.getOrderInfo().getAccountNo());//客户资金帐号
		socm.setAddOneIsValid(info.getOrderInfo().getAddOneIsValid()+"");//是否T+1有效
		socm.setCallOrPutFlag(info.getOrderInfo().getCallOrPutFlag()+"");//看涨看跌1
		socm.setCallOrPutFlag2(info.getOrderInfo().getCallOrPutFlag2()+"");//看涨看跌2
		socm.setClientID(info.getOrderInfo().getClientID());//客户子账号.
		socm.setClientIP(info.getOrderInfo().getClientIP());//终端网络地址.
		socm.setClientLocalIP(info.getOrderInfo().getClientLocalIP());//终端本地IP
		socm.setClientMac(info.getOrderInfo().getClientMac());//终端本地Mac地址
		socm.setClientOrderNo(info.getOrderInfo().getClientOrderNo());//客户端本地委托编号
		socm.setCommodityNo(info.getOrderInfo().getCommodityNo());//品种编号
		socm.setCommodityType(info.getOrderInfo().getCommodityType()+"");//品种类型
		socm.setContractNo(info.getOrderInfo().getContractNo());//合约1
		socm.setContractNo2(info.getOrderInfo().getContractNo2());//合约2
		socm.setErrorCode(info.getOrderInfo().getErrorCode()+"");//错误信息码
		socm.setErrorText(info.getOrderInfo().getErrorText());//错误信息
		socm.setExchangeNo(info.getOrderInfo().getExchangeNo());//交易所编号
		if(!"".equals(info.getOrderInfo().getExpireTime())) {
			try {
				socm.setExpireTime(simpleDateFormat2.parse(info.getOrderInfo().getExpireTime()));//有效日期(GTD情况下使用)
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		socm.setHedgeFlag(info.getOrderInfo().getHedgeFlag()+"");//投机保值
		socm.setInquiryNo(info.getOrderInfo().getInquiryNo());//询价号
		socm.setIsAddOne(info.getOrderInfo().getIsAddOne()+"");//是否为T+1单
		socm.setIsBackInput(info.getOrderInfo().getIsBackInput()+"");//是否为录入委托单
		socm.setIsDeleted(info.getOrderInfo().getIsDeleted()+"");//委托成交删除标志
		socm.setIsRiskOrder(info.getOrderInfo().getIsRiskOrder()+"");//是否风险报单
		socm.setLicenseNo(info.getOrderInfo().getLicenseNo());//软件授权号
		socm.setMaxClipSize(Long.valueOf(info.getOrderInfo().getMaxClipSize()));//冰山单最大随机量
		socm.setMinClipSize(Long.valueOf(info.getOrderInfo().getMinClipSize()));//冰山单最小随机量
		socm.setOrderCommandUserNo(info.getOrderInfo().getOrderCommandUserNo());//录单操作人
		socm.setOrderExchangeSystemNo(info.getOrderInfo().getOrderExchangeSystemNo());//交易所系统号


//		try {
//			socm.setOrderInsertTime(simpleDateFormat.parse(info.getOrderInfo().getOrderInsertTime()));//下单时间
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		if(!"".equals(info.getOrderInfo().getOrderInsertTime())) {
			try {
				String tt = info.getOrderInfo().getOrderInsertTime();
				String y = tt.substring(0, 2);
				String m = tt.substring(2, 4);
				String d = tt.substring(4, 6);
				String h = tt.substring(6, 8);
				String f = tt.substring(8, 10);
				String s = tt.substring(10, 12);
				socm.setOrderInsertTime(simpleDateFormat.parse(y + "/" + m + "/" + d + " " + h + ":" + f + ":" + s));//下单时间
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		socm.setOrderInsertUserNo(info.getOrderInfo().getOrderInsertUserNo());//下单人
		socm.setOrderLocalNo(info.getOrderInfo().getOrderLocalNo());//本地号

		//----------------------------------------------
		socm.setOrderMatchPrice(BigDecimal.ZERO);
		socm.setOrderMatchPrice2(BigDecimal.ZERO);//成交价2
//		socm.setOrderMatchPrice(BigDecimal.valueOf(info.getOrderInfo().getOrderMatchPrice()));//成交价1
//		socm.setOrderMatchPrice2(BigDecimal.valueOf(info.getOrderInfo().getOrderMatchPrice2()));//成交价2
		//----------------------------------------------

		socm.setOrderMatchQty(info.getOrderInfo().getOrderMatchQty());//成交量1
		socm.setOrderMatchQty2(info.getOrderInfo().getOrderMatchQty2());//成交量2
		socm.setOrderMinQty(info.getOrderInfo().getOrderMinQty());//最小成交量
		socm.setOrderNo(info.getOrderInfo().getOrderNo());//委托编码
		socm.setOrderParentSystemNo(info.getOrderInfo().getOrderParentSystemNo());//父单系统号
		socm.setOrderPrice(BigDecimal.valueOf(info.getOrderInfo().getOrderPrice()));//委托价格1
		socm.setOrderPrice2(BigDecimal.valueOf(info.getOrderInfo().getOrderPrice2()));//委托价格2
		socm.setOrderQty(Long.valueOf(info.getOrderInfo().getOrderQty()));//委托数量
		socm.setOrderSide(info.getOrderInfo().getOrderSide()+"");//买入卖出
		socm.setOrderSource(info.getOrderInfo().getOrderSource()+"");//委托来源
		socm.setOrderState(info.getOrderInfo().getOrderState()+"");//委托状态
		socm.setOrderStreamID(info.getOrderInfo().getOrderStreamID());//委托流水号
		socm.setOrderSystemNo(info.getOrderInfo().getOrderSystemNo());//系统号
		socm.setOrderType(info.getOrderInfo().getOrderType()+"");//委托类型
//		try {
//			socm.setOrderUpdateTime(simpleDateFormat.parse(info.getOrderInfo().getOrderUpdateTime()));//委托更新时间
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		if(!"".equals(info.getOrderInfo().getOrderUpdateTime())) {
			try {
				String tt = info.getOrderInfo().getOrderUpdateTime();
				String y = tt.substring(0, 2);
				String m = tt.substring(2, 4);
				String d = tt.substring(4, 6);
				String h = tt.substring(6, 8);
				String f = tt.substring(8, 10);
				String s = tt.substring(10, 12);
				socm.setOrderUpdateTime(simpleDateFormat.parse(y + "/" + m + "/" + d + " " + h + ":" + f + ":" + s));//委托更新时间
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		socm.setOrderUpdateUserNo(info.getOrderInfo().getOrderUpdateUserNo());//委托更新人
		socm.setPositionEffect(info.getOrderInfo().getPositionEffect()+"");//开平标志1
		socm.setPositionEffect2(info.getOrderInfo().getPositionEffect2()+"");//开平标志2
		socm.setRefDouble(BigDecimal.valueOf(info.getOrderInfo().getRefDouble()));//浮点参考值
		socm.setRefInt(info.getOrderInfo().getRefInt());//整型参考值
		socm.setRefString(info.getOrderInfo().getRefString());//字符串参考值
		socm.setServerFlag(info.getOrderInfo().getServerFlag()+"");//服务器标识
		socm.setStopPrice(BigDecimal.valueOf(info.getOrderInfo().getStopPrice()));//触发价格
		if("".equals(info.getOrderInfo().getStrikePrice())){
//			socm.setStrikePrice(BigDecimal.ZERO);//执行价格1
		}else {
			socm.setStrikePrice(BigDecimal.valueOf(Double.parseDouble(info.getOrderInfo().getStrikePrice())));//执行价格1
		}
		if("".equals(info.getOrderInfo().getStrikePrice2())){
//			socm.setStrikePrice2(BigDecimal.ZERO);//执行价格1
		}else {
			socm.setStrikePrice2(BigDecimal.valueOf(Double.valueOf(info.getOrderInfo().getStrikePrice2())));//执行价格2
		}
		socm.setTacticsType(info.getOrderInfo().getTacticsType()+"");//策略单类型
		socm.setTimeInForce(info.getOrderInfo().getTimeInForce()+"");//委托有效类型
		socm.setTriggerCondition(info.getOrderInfo().getTriggerCondition()+"");//触发条件
		socm.setTriggerPriceType(info.getOrderInfo().getTriggerPriceType()+"");//触发价格类型
		socm.setUpperChannelNo(info.getOrderInfo().getUpperChannelNo());//上手通道号
		socm.setUpperNo(info.getOrderInfo().getUpperNo());//上手号
		socm.setUpperStreamID(info.getOrderInfo().getUpperStreamID());//上手流号
        socm.setSessionID(info.getSessionID());//会话ID
		socm.setRemark("");//备注
		socm.setId(SerialnoUtils.buildPrimaryKey());
		sysOrderChangeService.saveRtnOrderChange(socm);

	}

	@Override
	public void onRspQryOrder(int sessionID, int errorCode, byte isLast, TapAPIOrderInfo info) {
		System.out.println("查询委托信息:onRspQryOrder "+JSON.toJSONString(info));
		//解析成交信息
		//得到ServiceBean
		sysOrderService = SpringContext.getBean(SysOrderService.class);
		SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		SysOrderModel som=new SysOrderModel();
		som.setAccountNo(info.getAccountNo());//客户资金帐号
		som.setAddOneIsValid(info.getAddOneIsValid()+"");//是否T+1有效
		som.setCallOrPutFlag(info.getCallOrPutFlag()+"");//看涨看跌1
		som.setCallOrPutFlag2(info.getCallOrPutFlag2()+"");//看涨看跌2
		som.setClientID(info.getClientID());//客户子账号.
		som.setClientIP(info.getClientIP());//终端网络地址.
		som.setClientLocalIP(info.getClientLocalIP());//终端本地IP
		som.setClientMac(info.getClientMac());//终端本地Mac地址
		som.setClientOrderNo(info.getClientOrderNo());//客户端本地委托编号
		som.setCommodityNo(info.getCommodityNo());//品种编号
		som.setCommodityType(info.getCommodityType()+"");//品种类型
		som.setContractNo(info.getContractNo());//合约1
		som.setContractNo2("0");//合约2
		som.setErrorCode(info.getErrorCode()+"");//错误信息码
		som.setErrorText(info.getErrorText());//错误信息
		som.setExchangeNo(info.getExchangeNo());//交易所编号
		if(!"".equals(info.getExpireTime())) {
			try {
				som.setExpireTime(simpleDateFormat2.parse(info.getExpireTime()));//有效日期(GTD情况下使用)
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		som.setHedgeFlag(info.getHedgeFlag()+"");//投机保值
		som.setInquiryNo(info.getInquiryNo());//询价号
		som.setIsAddOne(info.getIsAddOne()+"");//是否为T+1单
		som.setIsBackInput(info.getIsBackInput()+"");//是否为录入委托单
		som.setIsDeleted(info.getIsDeleted()+"");//委托成交删除标志
		som.setIsRiskOrder(info.getIsRiskOrder()+"");//是否风险报单
		som.setLicenseNo(info.getLicenseNo());//软件授权号
		som.setMaxClipSize(Long.valueOf(info.getMaxClipSize()));//冰山单最大随机量
		som.setMinClipSize(Long.valueOf(info.getMinClipSize()));//冰山单最小随机量
		som.setOrderCommandUserNo(info.getOrderCommandUserNo());//录单操作人
		som.setOrderExchangeSystemNo(info.getOrderExchangeSystemNo());//交易所系统号
		if(!"".equals(info.getOrderInsertTime())) {
			try {
				String tt = info.getOrderInsertTime();
				String y = tt.substring(0, 2);
				String m = tt.substring(2, 4);
				String d = tt.substring(4, 6);
				String h = tt.substring(6, 8);
				String f = tt.substring(8, 10);
				String s = tt.substring(10, 12);
				som.setOrderInsertTime(simpleDateFormat.parse(y + "/" + m + "/" + d + " " + h + ":" + f + ":" + s));//下单时间
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		//som.setOrderInsertTime(new Date());//下单时间

		som.setOrderInsertUserNo(info.getOrderInsertUserNo());//下单人
		som.setOrderLocalNo(info.getOrderLocalNo());//本地号

		//----------------------------------------------
		if("".equals(info.getOrderMatchPrice())) {
//			som.setOrderMatchPrice(BigDecimal.ZERO);//成交价1
		}else {
			som.setOrderMatchPrice(BigDecimal.valueOf(info.getOrderMatchPrice()));//成交价1
		}
		if("".equals(info.getOrderMatchPrice2())) {
//			som.setOrderMatchPrice2(BigDecimal.ZERO);//成交价2
		}else {
			som.setOrderMatchPrice2(BigDecimal.valueOf(info.getOrderMatchPrice2()));//成交价2
		}
		//----------------------------------------------

		som.setOrderMatchQty(info.getOrderMatchQty());//成交量1
		som.setOrderMatchQty2(info.getOrderMatchQty2());//成交量2
		som.setOrderMinQty(info.getOrderMinQty());//最小成交量
		som.setOrderNo(info.getOrderNo());//委托编码
		som.setOrderParentSystemNo(info.getOrderParentSystemNo());//父单系统号
		som.setOrderPrice(BigDecimal.valueOf(info.getOrderPrice()));//委托价格1
		som.setOrderPrice2(BigDecimal.valueOf(info.getOrderPrice2()));//委托价格2
		som.setOrderQty(Long.valueOf(info.getOrderQty()));//委托数量
		som.setOrderSide(info.getOrderSide()+"");//买入卖出
		som.setOrderSource(info.getOrderSource()+"");//委托来源
		som.setOrderState(info.getOrderState()+"");//委托状态
		som.setOrderStreamID(info.getOrderStreamID());//委托流水号
		som.setOrderSystemNo(info.getOrderSystemNo());//系统号
		som.setOrderType(info.getOrderType()+"");//委托类型

		//------------------------------------------------------------------
		if(!"".equals(info.getOrderUpdateTime())){
		try {
			String tt=info.getOrderUpdateTime();
			String y=tt.substring(0,2);
			String m=tt.substring(2,4);
			String d=tt.substring(4,6);
			String h=tt.substring(6,8);
			String f=tt.substring(8,10);
			String s=tt.substring(10,12);
			som.setOrderUpdateTime(simpleDateFormat.parse(y+"/"+m+"/"+d+" "+h+":"+f+":"+s)+"");//委托更新时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		//------------------------------------------------------------------
		//som.setOrderUpdateTime(new Date()+"");

		som.setOrderUpdateUserNo(info.getOrderUpdateUserNo());//委托更新人
		som.setPositionEffect(info.getPositionEffect()+"");//开平标志1
		som.setPositionEffect2(info.getPositionEffect2()+"");//开平标志2
		som.setRefDouble(BigDecimal.valueOf(info.getRefDouble()));//浮点参考值
		som.setRefInt(info.getRefInt());//整型参考值
		som.setRefString(info.getRefString());//字符串参考值
		som.setServerFlag(info.getServerFlag()+"");//服务器标识
		som.setStopPrice(BigDecimal.valueOf(info.getStopPrice()));//触发价格

		if("".equals(info.getStrikePrice())){
//			som.setStrikePrice(BigDecimal.ZERO);//执行价格1
		}else {
			som.setStrikePrice(BigDecimal.valueOf(Double.parseDouble(info.getStrikePrice())));//执行价格1
		}
		if("".equals(info.getStrikePrice2())){
//			som.setStrikePrice2(BigDecimal.ZERO);//执行价格2
		}else {
			som.setStrikePrice2(BigDecimal.valueOf(Double.valueOf(info.getStrikePrice2())));//执行价格2
		}
		som.setTacticsType(info.getTacticsType()+"");//策略单类型
		som.setTimeInForce(info.getTimeInForce()+"");//委托有效类型
		som.setTriggerCondition(info.getTriggerCondition()+"");//触发条件
		som.setTriggerPriceType(info.getTriggerPriceType()+"");//触发价格类型
		som.setUpperChannelNo(info.getUpperChannelNo());//上手通道号
		som.setUpperNo(info.getUpperNo());//上手号
		som.setUpperStreamID(info.getUpperStreamID());//上手流号
		som.setRemark("");//备注
		som.setId(SerialnoUtils.buildPrimaryKey());

		sysOrderService.saveRspQryOrder(som);

	}

	@Override
	public void onRspQryOrderProcess(int sessionID, int errorCode, byte isLast, TapAPIOrderInfo info) {
		System.out.println("查询委托处理状态:onRspQryOrderProcess "+JSON.toJSONString(info));
		//解析成交信息
		//得到ServiceBean
		sysOrderProcessService = SpringContext.getBean(SysOrderProcessService.class);
		SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		SysOrderProcessModel sopm=new SysOrderProcessModel();
		sopm.setAccountNo(info.getAccountNo());//客户资金帐号
		sopm.setAddOneIsValid(info.getAddOneIsValid()+"");//是否T+1有效
		sopm.setCallOrPutFlag(info.getCallOrPutFlag()+"");//看涨看跌1
		sopm.setCallOrPutFlag2(info.getCallOrPutFlag2()+"");//看涨看跌2
		sopm.setClientID(info.getClientID());//客户子账号.
		sopm.setClientIP(info.getClientIP());//终端网络地址.
		sopm.setClientLocalIP(info.getClientLocalIP());//终端本地IP
		sopm.setClientMac(info.getClientMac());//终端本地Mac地址
		sopm.setClientOrderNo(info.getClientOrderNo());//客户端本地委托编号
		sopm.setCommodityNo(info.getCommodityNo());//品种编号
		sopm.setCommodityType(info.getCommodityType()+"");//品种类型
		sopm.setContractNo(info.getContractNo());//合约1
		sopm.setContractNo2(info.getContractNo2());//合约2
		sopm.setErrorCode(info.getErrorCode()+"");//错误信息码
		sopm.setErrorText(info.getErrorText());//错误信息
		sopm.setExchangeNo(info.getExchangeNo());//交易所编号
		if(!"".equals(info.getExpireTime())) {
			try {
				sopm.setExpireTime(simpleDateFormat2.parse(info.getExpireTime()));//有效日期(GTD情况下使用)
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		sopm.setHedgeFlag(info.getHedgeFlag()+"");//投机保值
		sopm.setInquiryNo(info.getInquiryNo());//询价号
		sopm.setIsAddOne(info.getIsAddOne()+"");//是否为T+1单
		sopm.setIsBackInput(info.getIsBackInput()+"");//是否为录入委托单
		sopm.setIsDeleted(info.getIsDeleted()+"");//委托成交删除标志
		sopm.setIsRiskOrder(info.getIsRiskOrder()+"");//是否风险报单
		sopm.setLicenseNo(info.getLicenseNo());//软件授权号
		sopm.setMaxClipSize(Long.valueOf(info.getMaxClipSize()));//冰山单最大随机量
		sopm.setMinClipSize(Long.valueOf(info.getMinClipSize()));//冰山单最小随机量
		sopm.setOrderCommandUserNo(info.getOrderCommandUserNo());//录单操作人
		sopm.setOrderExchangeSystemNo(info.getOrderExchangeSystemNo());//交易所系统号
//		try {
//			sopm.setOrderInsertTime(simpleDateFormat.parse(info.getOrderInsertTime()));//下单时间
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		if(!"".equals(info.getOrderInsertTime())) {
			try {
				String tt = info.getOrderInsertTime();
				String y = tt.substring(0, 2);
				String m = tt.substring(2, 4);
				String d = tt.substring(4, 6);
				String h = tt.substring(6, 8);
				String f = tt.substring(8, 10);
				String s = tt.substring(10, 12);
				sopm.setOrderInsertTime(simpleDateFormat.parse(y + "/" + m + "/" + d + " " + h + ":" + f + ":" + s));//下单时间
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		sopm.setOrderInsertUserNo(info.getOrderInsertUserNo());//下单人
		sopm.setOrderLocalNo(info.getOrderLocalNo());//本地号
		sopm.setOrderMatchPrice(BigDecimal.valueOf(info.getOrderMatchPrice()));//成交价1
		sopm.setOrderMatchPrice2(BigDecimal.valueOf(info.getOrderMatchPrice2()));//成交价2
		sopm.setOrderMatchQty(info.getOrderMatchQty());//成交量1
		sopm.setOrderMatchQty2(info.getOrderMatchQty2());//成交量2
		sopm.setOrderMinQty(info.getOrderMinQty());//最小成交量
		sopm.setOrderNo(info.getOrderNo());//委托编码
		sopm.setOrderParentSystemNo(info.getOrderParentSystemNo());//父单系统号
		sopm.setOrderPrice(BigDecimal.valueOf(info.getOrderPrice()));//委托价格1
		sopm.setOrderPrice2(BigDecimal.valueOf(info.getOrderPrice2()));//委托价格2
		sopm.setOrderQty(Long.valueOf(info.getOrderQty()));//委托数量
		sopm.setOrderSide(info.getOrderSide()+"");//买入卖出
		sopm.setOrderSource(info.getOrderSource()+"");//委托来源
		sopm.setOrderState(info.getOrderState()+"");//委托状态
		sopm.setOrderStreamID(info.getOrderStreamID());//委托流水号
		sopm.setOrderSystemNo(info.getOrderSystemNo());//系统号
		sopm.setOrderType(info.getOrderType()+"");//委托类型
// 		try {
// 			sopm.setOrderUpdateTime(simpleDateFormat.parse(info.getOrderUpdateTime()));//委托更新时间
// 		} catch (ParseException e) {
// 			e.printStackTrace();
// 		}
		if(!"".equals(info.getOrderUpdateTime())) {
			try {
				String tt = info.getOrderUpdateTime();
				String y = tt.substring(0, 2);
				String m = tt.substring(2, 4);
				String d = tt.substring(4, 6);
				String h = tt.substring(6, 8);
				String f = tt.substring(8, 10);
				String s = tt.substring(10, 12);
				sopm.setOrderUpdateTime(simpleDateFormat.parse(y + "/" + m + "/" + d + " " + h + ":" + f + ":" + s));//委托更新时间
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		//sopm.setOrderUpdateTime(new Date());

		sopm.setOrderUpdateUserNo(info.getOrderUpdateUserNo());//委托更新人
		sopm.setPositionEffect(info.getPositionEffect()+"");//开平标志1
		sopm.setPositionEffect2(info.getPositionEffect2()+"");//开平标志2
		sopm.setRefDouble(BigDecimal.valueOf(info.getRefDouble()));//浮点参考值
		sopm.setRefInt(info.getRefInt());//整型参考值
		sopm.setRefString(info.getRefString());//字符串参考值
		sopm.setServerFlag(info.getServerFlag()+"");//服务器标识
		sopm.setStopPrice(BigDecimal.valueOf(info.getStopPrice()));//触发价格
 		if("".equals(info.getStrikePrice())){
// 			sopm.setStrikePrice(BigDecimal.ZERO);//执行价格1
 		}else {
 			sopm.setStrikePrice(BigDecimal.valueOf(Double.parseDouble(info.getStrikePrice())));//执行价格1
 		}
 		if("".equals(info.getStrikePrice2())){
// 			sopm.setStrikePrice2(BigDecimal.ZERO);//执行价格2
 		}else {
			sopm.setStrikePrice2(BigDecimal.valueOf(Double.valueOf(info.getStrikePrice2())));//执行价格2
		}
//		sopm.setStrikePrice(BigDecimal.valueOf(Double.parseDouble(info.getStrikePrice())));//执行价格1
//		sopm.setStrikePrice2(BigDecimal.valueOf(Double.parseDouble(info.getStrikePrice2())));//执行价格2
		sopm.setTacticsType(info.getTacticsType()+"");//策略单类型
		sopm.setTimeInForce(info.getTimeInForce()+"");//委托有效类型
		sopm.setTriggerCondition(info.getTriggerCondition()+"");//触发条件
		sopm.setTriggerPriceType(info.getTriggerPriceType()+"");//触发价格类型
		sopm.setUpperChannelNo(info.getUpperChannelNo());//上手通道号
		sopm.setUpperNo(info.getUpperNo());//上手号
		sopm.setUpperStreamID(info.getUpperStreamID());//上手流号
		sopm.setRemark("");//备注
		sopm.setId(SerialnoUtils.buildPrimaryKey());

		sysOrderProcessService.saveRspQryOrderProcess(sopm);
	}

	@Override
	public void onRspQryFill(int sessionID, int errorCode, byte isLast, TapAPIFillInfo info) {
		System.out.println("查询成交信息:onRspQryFill "+JSON.toJSONString(info));
        //解析成交信息
		//得到ServiceBean
		sysFillService = SpringContext.getBean(SysFillService.class);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SysFillModel sfm=new SysFillModel();
		sfm.setAccountNo(info.getAccountNo());//客户资金帐号
		sfm.setCallOrPutFlag(info.getCallOrPutFlag()+"");//看涨看跌
		sfm.setClosePrositionPrice(BigDecimal.valueOf(info.getClosePrositionPrice()));//指定价格平仓
		sfm.setCommodityNo(info.getCommodityNo());//品种编号
		sfm.setCommodityType(info.getCommodityType()+"");//品种类型
		sfm.setContractNo(info.getContractNo());//合约1
		sfm.setExchangeNo(info.getExchangeNo());//交易所编号
		sfm.setFeeCurrency(info.getFeeCurrency());//手续费币种
		sfm.setFeeCurrencyGroup(info.getFeeCurrencyGroup());//手续费币种组
		sfm.setFeeValue(BigDecimal.valueOf(info.getFeeValue()));//手续费
		sfm.setIsAddOne(info.getIsAddOne()+"");//是否为T+1单
		sfm.setIsDeleted(info.getIsDeleted()+"");//委托成交删除标
		sfm.setIsManualFee(info.getIsManualFee()+"");//人工客户手续费标记
		try {
			sfm.setMatchDateTime(simpleDateFormat.parse(info.getMatchDateTime()));//成交时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sfm.setMatchNo(info.getMatchNo());//本地成交号
		sfm.setMatchPrice(BigDecimal.valueOf(info.getMatchPrice()));//成交价
		sfm.setMatchQty(info.getMatchQty());//成交量
		sfm.setMatchSide(info.getMatchSide()+"");//买入卖出
		sfm.setMatchSource(info.getMatchSource()+"");//委托来源
		sfm.setOrderNo(info.getOrderNo());//委托编码
		sfm.setOrderSystemNo(info.getOrderSystemNo());//系统号
		sfm.setPositionEffect(info.getPositionEffect()+"");//开平标志1
		sfm.setServerFlag(String.valueOf(info.getServerFlag()));//服务器标识
		if("".equals(info.getStrikePrice())){
			sfm.setStrikePrice("0.0");//执行价格
		}else {
			sfm.setStrikePrice(info.getStrikePrice());//执行价格
		}
		try {
			sfm.setUpperMatchDateTime(simpleDateFormat.parse(info.getUpperMatchDateTime()));//上手成交时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sfm.setUpperMatchNo(info.getUpperMatchNo());//上手成交号
		sfm.setUpperNo(info.getUpperNo());//上手号
        sfm.setRemark("");//备注
		sfm.setId(SerialnoUtils.buildPrimaryKey());

		sysFillService.saveRspQryFill(sfm);
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
