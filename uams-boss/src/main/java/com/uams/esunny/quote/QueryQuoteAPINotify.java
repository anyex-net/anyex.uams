package com.uams.esunny.quote;

import com.alibaba.fastjson.JSON;
import com.uams.orm.utils.SpringContext;
import com.uams.rpc.quotation.model.QuotationModel;
import com.uams.rpc.quotation.service.QuotationService;
import com.uams.tools.bean.Pagination;
import com.uams.tools.utils.SerialnoUtils;
import esunny.futures.wp.quote.api.EsunnyWPQuoteAPINotify;
import esunny.futures.wp.quote.struct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class QueryQuoteAPINotify extends EsunnyWPQuoteAPINotify {

    @Autowired(required = false)
    private QuotationService quotationService;

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
        //解析交易合约
        //得到ServiceBean
        quotationService = SpringContext.getBean(QuotationService.class);

        QuotationModel quotationModel=new QuotationModel();
        quotationModel.setInterCode(info.getContract().getCommodity().getExchangeNo()+info.getContract().getCommodity().getCommodityNo()+info.getContract().getContractNo1());//证券内码
        quotationModel.setMarketCode(info.getContract().getCommodity().getExchangeNo());//交易市场代码
        quotationModel.setKindCode(info.getContract().getCommodity().getCommodityNo());//品种代码
        quotationModel.setCurrencyNo("bizhong"+info.getCurrencyNo());//币种代码
        quotationModel.setFiveDayAvgQty(BigDecimal.valueOf(info.getQ5DAvgQty()));//五日均量
        quotationModel.setAveragePrice(BigDecimal.valueOf(info.getQAveragePrice()));//均价
        quotationModel.setChangeRate(BigDecimal.valueOf(info.getQChangeRate()));//涨幅
        quotationModel.setChangeSpeed(BigDecimal.valueOf(info.getQChangeSpeed()));//涨速
        quotationModel.setChangeValue(BigDecimal.valueOf(info.getQChangeValue()));//涨跌值
        quotationModel.setClosingPrice(BigDecimal.valueOf(info.getQClosingPrice()));//收盘价
        quotationModel.setCurrDelta(BigDecimal.valueOf(info.getQCurrDelta()));//今虚实度
        //quotationModel.setPreDelta(BigDecimal.valueOf(info.getQPreDelta()));//昨虚实度
        quotationModel.setHighPrice(BigDecimal.valueOf(info.getQHisHighPrice()));//最高价
        quotationModel.setLowPrice(BigDecimal.valueOf(info.getQLowPrice()));//最低价
        quotationModel.setHisHighPrice(BigDecimal.valueOf(info.getQHisHighPrice()));//历史最高价
        quotationModel.setHisLowPrice(BigDecimal.valueOf(info.getQHisLowPrice()));//历史最低价
        quotationModel.setInsideQty(BigDecimal.valueOf(info.getQInsideQty()));//内盘量
        quotationModel.setOutsideQty(BigDecimal.valueOf(info.getQOutsideQty()));//外盘量
        quotationModel.setLastPrice(BigDecimal.valueOf(info.getQLastPrice()));//最新价
        quotationModel.setLastQty(BigDecimal.valueOf(info.getQLastQty()));//最新成交量
        quotationModel.setLimitDownPrice(BigDecimal.valueOf(info.getQLimitDownPrice()));//跌停价
        quotationModel.setLimitUpPrice(BigDecimal.valueOf(info.getQLimitUpPrice()));//涨停价
        quotationModel.setNegotiableValue(BigDecimal.valueOf(info.getQNegotiableValue()));//流通市值
        quotationModel.setOpeningPrice(BigDecimal.valueOf(info.getQOpeningPrice()));//开盘价
        quotationModel.setPERatio(BigDecimal.valueOf(info.getQPERatio()));//市盈率
        quotationModel.setPositionTrend(BigDecimal.valueOf(info.getQPositionTrend()));//持仓走势
        quotationModel.setPreClosingPrice(BigDecimal.valueOf(info.getQPreClosingPrice()));//昨收盘价
        quotationModel.setPrePositionQty(BigDecimal.valueOf(info.getQPrePositionQty()));//昨持仓量
        quotationModel.setPreSettlePrice(BigDecimal.valueOf(info.getQPreSettlePrice()));//昨结算价
        quotationModel.setSettlePrice(BigDecimal.valueOf(info.getQSettlePrice()));//结算价
        quotationModel.setSwing(BigDecimal.valueOf(info.getQSwing()));//振幅
        quotationModel.setTotalAskQty(BigDecimal.valueOf(info.getQTotalAskQty()));//委卖总量
        quotationModel.setTotalBidQty(BigDecimal.valueOf(info.getQTotalBidQty()));//委买总量
        quotationModel.setTotalQty(BigDecimal.valueOf(info.getQTotalQty()));//当日总成交量
        quotationModel.setTotalTurnover(BigDecimal.valueOf(info.getQTotalTurnover()));//当日成交金额
        quotationModel.setTotalValue(BigDecimal.valueOf(info.getQTotalValue()));//总市值
        quotationModel.setTurnoverRate(BigDecimal.valueOf(info.getQTurnoverRate()));//换手率
        quotationModel.setTradingState(BigDecimal.valueOf(info.getTradingState()));//交易状态
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            quotationModel.setQuotationTime(simpleDateFormat.parse(info.getDateTimeStamp()));//行情实时时间
        } catch (ParseException e) {
            e.printStackTrace();
        }
        quotationModel.setAskPrice1(BigDecimal.valueOf(info.getQAskPrice()[0]));
        quotationModel.setAskPrice2(BigDecimal.valueOf(info.getQAskPrice()[1]));
        quotationModel.setAskPrice3(BigDecimal.valueOf(info.getQAskPrice()[2]));
        quotationModel.setAskPrice4(BigDecimal.valueOf(info.getQAskPrice()[3]));
        quotationModel.setAskPrice5(BigDecimal.valueOf(info.getQAskPrice()[4]));
        quotationModel.setAskPrice6(BigDecimal.valueOf(info.getQAskPrice()[5]));
        quotationModel.setAskPrice7(BigDecimal.valueOf(info.getQAskPrice()[6]));
        quotationModel.setAskPrice8(BigDecimal.valueOf(info.getQAskPrice()[7]));
        quotationModel.setAskPrice9(BigDecimal.valueOf(info.getQAskPrice()[8]));
        quotationModel.setAskPrice10(BigDecimal.valueOf(info.getQAskPrice()[9]));
        quotationModel.setAskPrice11(BigDecimal.valueOf(info.getQAskPrice()[10]));
        quotationModel.setAskPrice12(BigDecimal.valueOf(info.getQAskPrice()[11]));
        quotationModel.setAskPrice13(BigDecimal.valueOf(info.getQAskPrice()[12]));
        quotationModel.setAskPrice14(BigDecimal.valueOf(info.getQAskPrice()[13]));
        quotationModel.setAskPrice15(BigDecimal.valueOf(info.getQAskPrice()[14]));
        quotationModel.setAskPrice16(BigDecimal.valueOf(info.getQAskPrice()[15]));
        quotationModel.setAskPrice17(BigDecimal.valueOf(info.getQAskPrice()[16]));
        quotationModel.setAskPrice18(BigDecimal.valueOf(info.getQAskPrice()[17]));
        quotationModel.setAskPrice19(BigDecimal.valueOf(info.getQAskPrice()[18]));
        quotationModel.setAskPrice20(BigDecimal.valueOf(info.getQAskPrice()[19]));
        quotationModel.setAskQty1(BigDecimal.valueOf(info.getQAskQty()[0]));
        quotationModel.setAskQty2(BigDecimal.valueOf(info.getQAskQty()[1]));
        quotationModel.setAskQty3(BigDecimal.valueOf(info.getQAskQty()[2]));
        quotationModel.setAskQty4(BigDecimal.valueOf(info.getQAskQty()[3]));
        quotationModel.setAskQty5(BigDecimal.valueOf(info.getQAskQty()[4]));
        quotationModel.setAskQty6(BigDecimal.valueOf(info.getQAskQty()[5]));
        quotationModel.setAskQty7(BigDecimal.valueOf(info.getQAskQty()[6]));
        quotationModel.setAskQty8(BigDecimal.valueOf(info.getQAskQty()[7]));
        quotationModel.setAskQty9(BigDecimal.valueOf(info.getQAskQty()[8]));
        quotationModel.setAskQty10(BigDecimal.valueOf(info.getQAskQty()[9]));
        quotationModel.setAskQty11(BigDecimal.valueOf(info.getQAskQty()[10]));
        quotationModel.setAskQty12(BigDecimal.valueOf(info.getQAskQty()[11]));
        quotationModel.setAskQty13(BigDecimal.valueOf(info.getQAskQty()[12]));
        quotationModel.setAskQty14(BigDecimal.valueOf(info.getQAskQty()[13]));
        quotationModel.setAskQty15(BigDecimal.valueOf(info.getQAskQty()[14]));
        quotationModel.setAskQty16(BigDecimal.valueOf(info.getQAskQty()[15]));
        quotationModel.setAskQty17(BigDecimal.valueOf(info.getQAskQty()[16]));
        quotationModel.setAskQty18(BigDecimal.valueOf(info.getQAskQty()[17]));
        quotationModel.setAskQty19(BigDecimal.valueOf(info.getQAskQty()[18]));
        quotationModel.setAskQty20(BigDecimal.valueOf(info.getQAskQty()[19]));
        quotationModel.setBidPrice1(BigDecimal.valueOf(info.getQBidPrice()[0]));
        quotationModel.setBidPrice2(BigDecimal.valueOf(info.getQBidPrice()[1]));
        quotationModel.setBidPrice3(BigDecimal.valueOf(info.getQBidPrice()[2]));
        quotationModel.setBidPrice4(BigDecimal.valueOf(info.getQBidPrice()[3]));
        quotationModel.setBidPrice5(BigDecimal.valueOf(info.getQBidPrice()[4]));
        quotationModel.setBidPrice6(BigDecimal.valueOf(info.getQBidPrice()[5]));
        quotationModel.setBidPrice7(BigDecimal.valueOf(info.getQBidPrice()[6]));
        quotationModel.setBidPrice8(BigDecimal.valueOf(info.getQBidPrice()[7]));
        quotationModel.setBidPrice9(BigDecimal.valueOf(info.getQBidPrice()[8]));
        quotationModel.setBidPrice10(BigDecimal.valueOf(info.getQBidPrice()[9]));
        quotationModel.setBidPrice11(BigDecimal.valueOf(info.getQBidPrice()[10]));
        quotationModel.setBidPrice12(BigDecimal.valueOf(info.getQBidPrice()[11]));
        quotationModel.setBidPrice13(BigDecimal.valueOf(info.getQBidPrice()[12]));
        quotationModel.setBidPrice14(BigDecimal.valueOf(info.getQBidPrice()[13]));
        quotationModel.setBidPrice15(BigDecimal.valueOf(info.getQBidPrice()[14]));
        quotationModel.setBidPrice16(BigDecimal.valueOf(info.getQBidPrice()[15]));
        quotationModel.setBidPrice17(BigDecimal.valueOf(info.getQBidPrice()[16]));
        quotationModel.setBidPrice18(BigDecimal.valueOf(info.getQBidPrice()[17]));
        quotationModel.setBidPrice19(BigDecimal.valueOf(info.getQBidPrice()[18]));
        quotationModel.setBidPrice20(BigDecimal.valueOf(info.getQBidPrice()[19]));
        quotationModel.setBidQty1(BigDecimal.valueOf(info.getQBidQty()[0]));
        quotationModel.setBidQty2(BigDecimal.valueOf(info.getQBidQty()[1]));
        quotationModel.setBidQty3(BigDecimal.valueOf(info.getQBidQty()[2]));
        quotationModel.setBidQty4(BigDecimal.valueOf(info.getQBidQty()[3]));
        quotationModel.setBidQty5(BigDecimal.valueOf(info.getQBidQty()[4]));
        quotationModel.setBidQty6(BigDecimal.valueOf(info.getQBidQty()[5]));
        quotationModel.setBidQty7(BigDecimal.valueOf(info.getQBidQty()[6]));
        quotationModel.setBidQty8(BigDecimal.valueOf(info.getQBidQty()[7]));
        quotationModel.setBidQty9(BigDecimal.valueOf(info.getQBidQty()[8]));
        quotationModel.setBidQty10(BigDecimal.valueOf(info.getQBidQty()[9]));
        quotationModel.setBidQty11(BigDecimal.valueOf(info.getQBidQty()[10]));
        quotationModel.setBidQty12(BigDecimal.valueOf(info.getQBidQty()[11]));
        quotationModel.setBidQty13(BigDecimal.valueOf(info.getQBidQty()[12]));
        quotationModel.setBidQty14(BigDecimal.valueOf(info.getQBidQty()[13]));
        quotationModel.setBidQty15(BigDecimal.valueOf(info.getQBidQty()[14]));
        quotationModel.setBidQty16(BigDecimal.valueOf(info.getQBidQty()[15]));
        quotationModel.setBidQty17(BigDecimal.valueOf(info.getQBidQty()[16]));
        quotationModel.setBidQty18(BigDecimal.valueOf(info.getQBidQty()[17]));
        quotationModel.setBidQty19(BigDecimal.valueOf(info.getQBidQty()[18]));
        quotationModel.setBidQty20(BigDecimal.valueOf(info.getQBidQty()[19]));
        quotationModel.setId(SerialnoUtils.buildPrimaryKey());


        /*quotationModel.setInterCode(info.getContract().getCommodity().getExchangeNo()+info.getContract().getCommodity().getCommodityNo()+info.getContract().getContractNo1());//证券内码
        quotationModel.setMarketCode(info.getContract().getCommodity().getExchangeNo());//交易市场代码
        quotationModel.setKindCode(info.getContract().getCommodity().getCommodityNo());//品种代码
        //quotationModel.setCurrencyNo(info.getCurrencyNo());//币种代码
        quotationModel.setCurrencyNo("bizhong"+info.getCurrencyNo());//币种代码
        quotationModel.setFiveDayAvgQty(BigDecimal.valueOf(0));//五日均量
        quotationModel.setAveragePrice(BigDecimal.valueOf(0));//均价
        quotationModel.setChangeRate(BigDecimal.valueOf(0));//涨幅
        quotationModel.setChangeSpeed(BigDecimal.valueOf(0));//涨速
        quotationModel.setChangeValue(BigDecimal.valueOf(0));//涨跌值
        quotationModel.setClosingPrice(BigDecimal.valueOf(0));//收盘价
        quotationModel.setCurrDelta(BigDecimal.valueOf(info.getQCurrDelta()));//今虚实度
        //quotationModel.setPreDelta(BigDecimal.valueOf(info.getQPreDelta()));//昨虚实度
        quotationModel.setHighPrice(BigDecimal.valueOf(0));//最高价
        quotationModel.setLowPrice(BigDecimal.valueOf(0));//最低价
        quotationModel.setHisHighPrice(BigDecimal.valueOf(0));//历史最高价
        quotationModel.setHisLowPrice(BigDecimal.valueOf(0));//历史最低价
        quotationModel.setInsideQty(BigDecimal.valueOf(0));//内盘量
        quotationModel.setOutsideQty(BigDecimal.valueOf(0));//外盘量
        quotationModel.setLastPrice(BigDecimal.valueOf(0));//最新价
        quotationModel.setLastQty(BigDecimal.valueOf(0));//最新成交量
        quotationModel.setLimitDownPrice(BigDecimal.valueOf(0));//跌停价
        quotationModel.setLimitUpPrice(BigDecimal.valueOf(0));//涨停价
        quotationModel.setNegotiableValue(BigDecimal.valueOf(0));//流通市值
        quotationModel.setOpeningPrice(BigDecimal.valueOf(0));//开盘价
        quotationModel.setPERatio(BigDecimal.valueOf(0));//市盈率
        quotationModel.setPositionTrend(BigDecimal.valueOf(0));//持仓走势
        quotationModel.setPreClosingPrice(BigDecimal.valueOf(0));//昨收盘价
        quotationModel.setPrePositionQty(BigDecimal.valueOf(0));//昨持仓量
        quotationModel.setPreSettlePrice(BigDecimal.valueOf(0));//昨结算价
        quotationModel.setSettlePrice(BigDecimal.valueOf(0));//结算价
        quotationModel.setSwing(BigDecimal.valueOf(0));//振幅
        quotationModel.setTotalAskQty(BigDecimal.valueOf(0));//委卖总量
        quotationModel.setTotalBidQty(BigDecimal.valueOf(0));//委买总量
        quotationModel.setTotalQty(BigDecimal.valueOf(0));//当日总成交量
        quotationModel.setTotalTurnover(BigDecimal.valueOf(0));//当日成交金额
        quotationModel.setTotalValue(BigDecimal.valueOf(0));//总市值
        quotationModel.setTurnoverRate(BigDecimal.valueOf(0));//换手率
        quotationModel.setTradingState(BigDecimal.valueOf(0));//交易状态
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            quotationModel.setQuotationTime(simpleDateFormat.parse(info.getDateTimeStamp()));//行情实时时间
        } catch (ParseException e) {
            e.printStackTrace();
        }
        quotationModel.setAskPrice1(BigDecimal.valueOf(0));
        quotationModel.setAskPrice2(BigDecimal.valueOf(0));
        quotationModel.setAskPrice3(BigDecimal.valueOf(0));
        quotationModel.setAskPrice4(BigDecimal.valueOf(0));
        quotationModel.setAskPrice5(BigDecimal.valueOf(0));
        quotationModel.setAskPrice6(BigDecimal.valueOf(0));
        quotationModel.setAskPrice7(BigDecimal.valueOf(0));
        quotationModel.setAskPrice8(BigDecimal.valueOf(0));
        quotationModel.setAskPrice9(BigDecimal.valueOf(0));
        quotationModel.setAskPrice10(BigDecimal.valueOf(0));
        quotationModel.setAskPrice11(BigDecimal.valueOf(0));
        quotationModel.setAskPrice12(BigDecimal.valueOf(0));
        quotationModel.setAskPrice13(BigDecimal.valueOf(0));
        quotationModel.setAskPrice14(BigDecimal.valueOf(0));
        quotationModel.setAskPrice15(BigDecimal.valueOf(0));
        quotationModel.setAskPrice16(BigDecimal.valueOf(0));
        quotationModel.setAskPrice17(BigDecimal.valueOf(0));
        quotationModel.setAskPrice18(BigDecimal.valueOf(0));
        quotationModel.setAskPrice19(BigDecimal.valueOf(0));
        quotationModel.setAskPrice20(BigDecimal.valueOf(0));
        quotationModel.setAskQty1(BigDecimal.valueOf(0));
        quotationModel.setAskQty2(BigDecimal.valueOf(0));
        quotationModel.setAskQty3(BigDecimal.valueOf(0));
        quotationModel.setAskQty4(BigDecimal.valueOf(0));
        quotationModel.setAskQty5(BigDecimal.valueOf(0));
        quotationModel.setAskQty6(BigDecimal.valueOf(0));
        quotationModel.setAskQty7(BigDecimal.valueOf(0));
        quotationModel.setAskQty8(BigDecimal.valueOf(0));
        quotationModel.setAskQty9(BigDecimal.valueOf(0));
        quotationModel.setAskQty10(BigDecimal.valueOf(0));
        quotationModel.setAskQty11(BigDecimal.valueOf(0));
        quotationModel.setAskQty12(BigDecimal.valueOf(0));
        quotationModel.setAskQty13(BigDecimal.valueOf(0));
        quotationModel.setAskQty14(BigDecimal.valueOf(0));
        quotationModel.setAskQty15(BigDecimal.valueOf(0));
        quotationModel.setAskQty16(BigDecimal.valueOf(0));
        quotationModel.setAskQty17(BigDecimal.valueOf(0));
        quotationModel.setAskQty18(BigDecimal.valueOf(0));
        quotationModel.setAskQty19(BigDecimal.valueOf(0));
        quotationModel.setAskQty20(BigDecimal.valueOf(0));
        quotationModel.setBidPrice1(BigDecimal.valueOf(0));
        quotationModel.setBidPrice2(BigDecimal.valueOf(0));
        quotationModel.setBidPrice3(BigDecimal.valueOf(0));
        quotationModel.setBidPrice4(BigDecimal.valueOf(0));
        quotationModel.setBidPrice5(BigDecimal.valueOf(0));
        quotationModel.setBidPrice6(BigDecimal.valueOf(0));
        quotationModel.setBidPrice7(BigDecimal.valueOf(0));
        quotationModel.setBidPrice8(BigDecimal.valueOf(0));
        quotationModel.setBidPrice9(BigDecimal.valueOf(0));
        quotationModel.setBidPrice10(BigDecimal.valueOf(0));
        quotationModel.setBidPrice11(BigDecimal.valueOf(0));
        quotationModel.setBidPrice12(BigDecimal.valueOf(0));
        quotationModel.setBidPrice13(BigDecimal.valueOf(0));
        quotationModel.setBidPrice14(BigDecimal.valueOf(0));
        quotationModel.setBidPrice15(BigDecimal.valueOf(0));
        quotationModel.setBidPrice16(BigDecimal.valueOf(0));
        quotationModel.setBidPrice17(BigDecimal.valueOf(0));
        quotationModel.setBidPrice18(BigDecimal.valueOf(0));
        quotationModel.setBidPrice19(BigDecimal.valueOf(0));
        quotationModel.setBidPrice20(BigDecimal.valueOf(0));
        quotationModel.setBidQty1(BigDecimal.valueOf(0));
        quotationModel.setBidQty2(BigDecimal.valueOf(0));
        quotationModel.setBidQty3(BigDecimal.valueOf(0));
        quotationModel.setBidQty4(BigDecimal.valueOf(0));
        quotationModel.setBidQty5(BigDecimal.valueOf(0));
        quotationModel.setBidQty6(BigDecimal.valueOf(0));
        quotationModel.setBidQty7(BigDecimal.valueOf(0));
        quotationModel.setBidQty8(BigDecimal.valueOf(0));
        quotationModel.setBidQty9(BigDecimal.valueOf(0));
        quotationModel.setBidQty10(BigDecimal.valueOf(0));
        quotationModel.setBidQty11(BigDecimal.valueOf(0));
        quotationModel.setBidQty12(BigDecimal.valueOf(0));
        quotationModel.setBidQty13(BigDecimal.valueOf(0));
        quotationModel.setBidQty14(BigDecimal.valueOf(0));
        quotationModel.setBidQty15(BigDecimal.valueOf(0));
        quotationModel.setBidQty16(BigDecimal.valueOf(0));
        quotationModel.setBidQty17(BigDecimal.valueOf(0));
        quotationModel.setBidQty18(BigDecimal.valueOf(0));
        quotationModel.setBidQty19(BigDecimal.valueOf(0));
        quotationModel.setBidQty20(BigDecimal.valueOf(0));
        quotationModel.setId(SerialnoUtils.buildPrimaryKey());
*/

        //解析合约最新交易行情
        System.out.println("onRspQryCommodity解析合约最新交易行情...");

        quotationService.saveRtnQuote(quotationModel);
    }

    @Override
    public void onRspUnSubscribeQuote(int sessionID, int errorCode, byte isLast, TapAPIContract info) {
        System.out.println("OnRspUnSubscribeQuote取消行情订阅:"+JSON.toJSONString(info));
    }

    @Override
    public void onRtnQuote(TapAPIQuoteWhole info) {
        /*System.out.println("onRtnQuote:"+JSON.toJSONString(info));

        System.out.println("合约代码1:"+info.getContract().getContractNo1());
        System.out.println("合约代码2:"+info.getContract().getContractNo2());
        System.out.println("品种编号:"+info.getContract().getCommodity().getCommodityNo());
        System.out.println("交易所编号:"+info.getContract().getCommodity().getExchangeNo());
        System.out.println("币种编号:"+info.getCurrencyNo());
        System.out.println("时间戳:"+info.getDateTimeStamp());
        System.out.println("五日均量:"+info.getQ5DAvgQty());

        System.out.println("卖1价:"+info.getQAskPrice()[0]);
        System.out.println("卖2价:"+info.getQAskPrice()[1]);
        System.out.println("卖3价:"+info.getQAskPrice()[2]);
        System.out.println("卖4价:"+info.getQAskPrice()[3]);
        System.out.println("卖5价:"+info.getQAskPrice()[4]);
        System.out.println("卖6价:"+info.getQAskPrice()[5]);
        System.out.println("卖7价:"+info.getQAskPrice()[6]);
        System.out.println("卖8价:"+info.getQAskPrice()[7]);
        System.out.println("卖9价:"+info.getQAskPrice()[8]);
        System.out.println("卖10价:"+info.getQAskPrice()[9]);
        System.out.println("卖11价:"+info.getQAskPrice()[10]);
        System.out.println("卖12价:"+info.getQAskPrice()[11]);
        System.out.println("卖13价:"+info.getQAskPrice()[12]);
        System.out.println("卖14价:"+info.getQAskPrice()[13]);
        System.out.println("卖15价:"+info.getQAskPrice()[14]);
        System.out.println("卖16价:"+info.getQAskPrice()[15]);
        System.out.println("卖17价:"+info.getQAskPrice()[16]);
        System.out.println("卖18价:"+info.getQAskPrice()[17]);
        System.out.println("卖19价:"+info.getQAskPrice()[18]);
        System.out.println("卖20价:"+info.getQAskPrice()[19]);

        System.out.println("卖1量:"+info.getQAskQty()[0]);
        System.out.println("卖2量:"+info.getQAskQty()[1]);
        System.out.println("卖3量:"+info.getQAskQty()[2]);
        System.out.println("卖4量:"+info.getQAskQty()[3]);
        System.out.println("卖5量:"+info.getQAskQty()[4]);
        System.out.println("卖6量:"+info.getQAskQty()[5]);
        System.out.println("卖7量:"+info.getQAskQty()[6]);
        System.out.println("卖8量:"+info.getQAskQty()[7]);
        System.out.println("卖9量:"+info.getQAskQty()[8]);
        System.out.println("卖10量:"+info.getQAskQty()[9]);
        System.out.println("卖11量:"+info.getQAskQty()[10]);
        System.out.println("卖12量:"+info.getQAskQty()[11]);
        System.out.println("卖13量:"+info.getQAskQty()[12]);
        System.out.println("卖14量:"+info.getQAskQty()[13]);
        System.out.println("卖15量:"+info.getQAskQty()[14]);
        System.out.println("卖16量:"+info.getQAskQty()[15]);
        System.out.println("卖17量:"+info.getQAskQty()[16]);
        System.out.println("卖18量:"+info.getQAskQty()[17]);
        System.out.println("卖19量:"+info.getQAskQty()[18]);
        System.out.println("卖20量:"+info.getQAskQty()[19]);

        System.out.println("均价:"+info.getQAveragePrice());

        System.out.println("买1价:"+info.getQBidPrice()[0]);
        System.out.println("买2价:"+info.getQBidPrice()[1]);
        System.out.println("买3价:"+info.getQBidPrice()[2]);
        System.out.println("买4价:"+info.getQBidPrice()[3]);
        System.out.println("买5价:"+info.getQBidPrice()[4]);
        System.out.println("买6价:"+info.getQBidPrice()[5]);
        System.out.println("买7价:"+info.getQBidPrice()[6]);
        System.out.println("买8价:"+info.getQBidPrice()[7]);
        System.out.println("买9价:"+info.getQBidPrice()[8]);
        System.out.println("买10价:"+info.getQBidPrice()[9]);
        System.out.println("买11价:"+info.getQBidPrice()[10]);
        System.out.println("买12价:"+info.getQBidPrice()[11]);
        System.out.println("买13价:"+info.getQBidPrice()[12]);
        System.out.println("买14价:"+info.getQBidPrice()[13]);
        System.out.println("买15价:"+info.getQBidPrice()[14]);
        System.out.println("买16价:"+info.getQBidPrice()[15]);
        System.out.println("买17价:"+info.getQBidPrice()[16]);
        System.out.println("买18价:"+info.getQBidPrice()[17]);
        System.out.println("买19价:"+info.getQBidPrice()[18]);
        System.out.println("买20价:"+info.getQBidPrice()[19]);




        System.out.println("买1量:"+info.getQBidQty()[0]);
        System.out.println("买2量:"+info.getQBidQty()[1]);
        System.out.println("买3量:"+info.getQBidQty()[2]);
        System.out.println("买4量:"+info.getQBidQty()[3]);
        System.out.println("买5量:"+info.getQBidQty()[4]);
        System.out.println("买6量:"+info.getQBidQty()[5]);
        System.out.println("买7量:"+info.getQBidQty()[6]);
        System.out.println("买8量:"+info.getQBidQty()[7]);
        System.out.println("买9量:"+info.getQBidQty()[8]);
        System.out.println("买10量:"+info.getQBidQty()[9]);
        System.out.println("买11量:"+info.getQBidQty()[10]);
        System.out.println("买12量:"+info.getQBidQty()[11]);
        System.out.println("买13量:"+info.getQBidQty()[12]);
        System.out.println("买14量:"+info.getQBidQty()[13]);
        System.out.println("买15量:"+info.getQBidQty()[14]);
        System.out.println("买16量:"+info.getQBidQty()[15]);
        System.out.println("买17量:"+info.getQBidQty()[16]);
        System.out.println("买18量:"+info.getQBidQty()[17]);
        System.out.println("买19量:"+info.getQBidQty()[18]);
        System.out.println("买20量:"+info.getQBidQty()[19]);
        System.out.println("涨幅:"+info.getQChangeRate());
        System.out.println("涨速:"+info.getQChangeSpeed());
        System.out.println("涨跌值:"+info.getQChangeValue());
        System.out.println("收盘价:"+info.getQClosingPrice());
        System.out.println("今虚实度:"+info.getQCurrDelta());
        System.out.println("最高价:"+info.getQHighPrice());
        System.out.println("最低价:"+info.getQLowPrice());
        System.out.println("历史最高价:"+info.getQHisHighPrice());
        System.out.println("历史最低价:"+info.getQHisLowPrice());
        System.out.println("隐含卖价:"+info.getQImpliedAskPrice());
        System.out.println("隐含卖量:"+info.getQImpliedAskQty());
        System.out.println("隐含买价:"+info.getQImpliedBidPrice());
        System.out.println("隐含买量:"+info.getQImpliedBidQty());
        System.out.println("内盘量:"+info.getQInsideQty());
        System.out.println("外盘量:"+info.getQOutsideQty());
        System.out.println("最新价:"+info.getQLastPrice());
        System.out.println("最新成交量:"+info.getQLastQty());
        System.out.println("跌停价:"+info.getQLimitDownPrice());
        System.out.println("涨停价:"+info.getQLimitUpPrice());
        System.out.println("流通市值:"+info.getQNegotiableValue());
        System.out.println("开盘价:"+info.getQOpeningPrice());
        System.out.println("市盈率:"+info.getQPERatio());
        System.out.println("持仓走势:"+info.getQPositionTrend());
        System.out.println("昨收盘价:"+info.getQPreClosingPrice());
        System.out.println("昨虚实度:"+info.getQPreDelta());
        System.out.println("昨持仓量:"+info.getQPrePositionQty());
        System.out.println("昨结算价:"+info.getQPreSettlePrice());
        System.out.println("结算价:"+info.getQSettlePrice());
        System.out.println("振幅:"+info.getQSwing());
        System.out.println("委卖总量:"+info.getQTotalAskQty());
        System.out.println("委买总量:"+info.getQTotalBidQty());
        System.out.println("当日总成交量:"+info.getQTotalQty());
        System.out.println("当日成交金额:"+info.getQTotalTurnover());
        System.out.println("总市值:"+info.getQTotalValue());
        System.out.println("换手率:"+info.getQTurnoverRate());
        System.out.println("交易状态:"+info.getTradingState());
        System.out.println("虚拟合约对应的真实合约代码1:"+info.getUnderlyContract().getContractNo1());
        System.out.println("虚拟合约对应的真实合约代码2:"+info.getUnderlyContract().getContractNo2());
        System.out.println("虚拟合约对应的真实合约品种编号:"+info.getUnderlyContract().getCommodity().getCommodityNo());
        System.out.println("虚拟合约对应的真实合约交易所编号:"+info.getUnderlyContract().getCommodity().getExchangeNo());
*/


    }

}
