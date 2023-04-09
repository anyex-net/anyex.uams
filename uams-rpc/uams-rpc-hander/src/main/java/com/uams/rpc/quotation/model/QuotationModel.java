/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.quotation.model;

import com.uams.rpc.quotation.entity.QuotationEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.uams.orm.core.GenericEntity;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 外部实时行情表 实体对象
 * <p>File：Quotation.java</p>
 * <p>Title: Quotation</p>
 * <p>Description:Quotation</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "外部实时行情表")
public class QuotationModel extends QuotationEntity
{
    private static final long serialVersionUID = 1L;
    
    /**
     * 动态表名 不能从界面传入
     */
    private String            tableName;
    
    public String getTableName()
    {
        return tableName;
    }
    
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("QuotationModel{");
        sb.append("id=").append(id);
        sb.append(", tableName='").append(tableName).append('\'');
        sb.append(", interCode='").append(interCode).append('\'');
        sb.append(", marketCode='").append(marketCode).append('\'');
        sb.append(", kindCode='").append(kindCode).append('\'');
        sb.append(", currencyNo='").append(currencyNo).append('\'');
        sb.append(", fiveDayAvgQty=").append(fiveDayAvgQty);
        sb.append(", averagePrice=").append(averagePrice);
        sb.append(", changeRate=").append(changeRate);
        sb.append(", changeSpeed=").append(changeSpeed);
        sb.append(", changeValue=").append(changeValue);
        sb.append(", closingPrice=").append(closingPrice);
        sb.append(", currDelta=").append(currDelta);
        sb.append(", highPrice=").append(highPrice);
        sb.append(", lowPrice=").append(lowPrice);
        sb.append(", hisHighPrice=").append(hisHighPrice);
        sb.append(", hisLowPrice=").append(hisLowPrice);
        sb.append(", insideQty=").append(insideQty);
        sb.append(", outsideQty=").append(outsideQty);
        sb.append(", lastPrice=").append(lastPrice);
        sb.append(", lastQty=").append(lastQty);
        sb.append(", limitDownPrice=").append(limitDownPrice);
        sb.append(", limitUpPrice=").append(limitUpPrice);
        sb.append(", negotiableValue=").append(negotiableValue);
        sb.append(", openingPrice=").append(openingPrice);
        sb.append(", pERatio=").append(pERatio);
        sb.append(", positionTrend=").append(positionTrend);
        sb.append(", preClosingPrice=").append(preClosingPrice);
        sb.append(", prePositionQty=").append(prePositionQty);
        sb.append(", preSettlePrice=").append(preSettlePrice);
        sb.append(", settlePrice=").append(settlePrice);
        sb.append(", swing=").append(swing);
        sb.append(", totalAskQty=").append(totalAskQty);
        sb.append(", totalBidQty=").append(totalBidQty);
        sb.append(", totalQty=").append(totalQty);
        sb.append(", totalTurnover=").append(totalTurnover);
        sb.append(", totalValue=").append(totalValue);
        sb.append(", turnoverRate=").append(turnoverRate);
        sb.append(", tradingState=").append(tradingState);
        sb.append(", askPrice1=").append(askPrice1);
        sb.append(", askPrice2=").append(askPrice2);
        sb.append(", askPrice3=").append(askPrice3);
        sb.append(", askPrice4=").append(askPrice4);
        sb.append(", askPrice5=").append(askPrice5);
        sb.append(", askPrice6=").append(askPrice6);
        sb.append(", askPrice7=").append(askPrice7);
        sb.append(", askPrice8=").append(askPrice8);
        sb.append(", askPrice9=").append(askPrice9);
        sb.append(", askPrice10=").append(askPrice10);
        sb.append(", askPrice11=").append(askPrice11);
        sb.append(", askPrice12=").append(askPrice12);
        sb.append(", askPrice13=").append(askPrice13);
        sb.append(", askPrice14=").append(askPrice14);
        sb.append(", askPrice15=").append(askPrice15);
        sb.append(", askPrice16=").append(askPrice16);
        sb.append(", askPrice17=").append(askPrice17);
        sb.append(", askPrice18=").append(askPrice18);
        sb.append(", askPrice19=").append(askPrice19);
        sb.append(", askPrice20=").append(askPrice20);
        sb.append(", askQty1=").append(askQty1);
        sb.append(", askQty2=").append(askQty2);
        sb.append(", askQty3=").append(askQty3);
        sb.append(", askQty4=").append(askQty4);
        sb.append(", askQty5=").append(askQty5);
        sb.append(", askQty6=").append(askQty6);
        sb.append(", askQty7=").append(askQty7);
        sb.append(", askQty8=").append(askQty8);
        sb.append(", askQty9=").append(askQty9);
        sb.append(", askQty10=").append(askQty10);
        sb.append(", askQty11=").append(askQty11);
        sb.append(", askQty12=").append(askQty12);
        sb.append(", askQty13=").append(askQty13);
        sb.append(", askQty14=").append(askQty14);
        sb.append(", askQty15=").append(askQty15);
        sb.append(", askQty16=").append(askQty16);
        sb.append(", askQty17=").append(askQty17);
        sb.append(", askQty18=").append(askQty18);
        sb.append(", askQty19=").append(askQty19);
        sb.append(", askQty20=").append(askQty20);
        sb.append(", bidPrice1=").append(bidPrice1);
        sb.append(", bidPrice2=").append(bidPrice2);
        sb.append(", bidPrice3=").append(bidPrice3);
        sb.append(", bidPrice4=").append(bidPrice4);
        sb.append(", bidPrice5=").append(bidPrice5);
        sb.append(", bidPrice6=").append(bidPrice6);
        sb.append(", bidPrice7=").append(bidPrice7);
        sb.append(", bidPrice8=").append(bidPrice8);
        sb.append(", bidPrice9=").append(bidPrice9);
        sb.append(", bidPrice10=").append(bidPrice10);
        sb.append(", bidPrice11=").append(bidPrice11);
        sb.append(", bidPrice12=").append(bidPrice12);
        sb.append(", bidPrice13=").append(bidPrice13);
        sb.append(", bidPrice14=").append(bidPrice14);
        sb.append(", bidPrice15=").append(bidPrice15);
        sb.append(", bidPrice16=").append(bidPrice16);
        sb.append(", bidPrice17=").append(bidPrice17);
        sb.append(", bidPrice18=").append(bidPrice18);
        sb.append(", bidPrice19=").append(bidPrice19);
        sb.append(", bidPrice20=").append(bidPrice20);
        sb.append(", bidQty1=").append(bidQty1);
        sb.append(", bidQty2=").append(bidQty2);
        sb.append(", bidQty3=").append(bidQty3);
        sb.append(", bidQty4=").append(bidQty4);
        sb.append(", bidQty5=").append(bidQty5);
        sb.append(", bidQty6=").append(bidQty6);
        sb.append(", bidQty7=").append(bidQty7);
        sb.append(", bidQty8=").append(bidQty8);
        sb.append(", bidQty9=").append(bidQty9);
        sb.append(", bidQty10=").append(bidQty10);
        sb.append(", bidQty11=").append(bidQty11);
        sb.append(", bidQty12=").append(bidQty12);
        sb.append(", bidQty13=").append(bidQty13);
        sb.append(", bidQty14=").append(bidQty14);
        sb.append(", bidQty15=").append(bidQty15);
        sb.append(", bidQty16=").append(bidQty16);
        sb.append(", bidQty17=").append(bidQty17);
        sb.append(", bidQty18=").append(bidQty18);
        sb.append(", bidQty19=").append(bidQty19);
        sb.append(", bidQty20=").append(bidQty20);
        sb.append(", quotationTime=").append(quotationTime);
        sb.append('}');
        return sb.toString();
    }
}
