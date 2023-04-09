--平台历史成交表(onRspQryHisMatch)
DROP TABLE sysHisMatch;
CREATE TABLE sysHisMatch
(
  id             		  	NUMBER(20)             	NOT NULL,
  accountFee    			NUMBER(20,2)  DEFAULT 0 NOT NULL,
  accountFeeCurrency 		VARCHAR2(64)           	NOT NULL,
  accountFeeCurrencyGroup   VARCHAR2(64)           	NOT NULL,
  accountNo               	VARCHAR2(32)           	NOT NULL,
  accountOtherFee    		NUMBER(20,2)  DEFAULT 0 NOT NULL,
  callOrPutFlag             VARCHAR2(32)           	NOT NULL,
  closePrice    			NUMBER(20,2)  DEFAULT 0 NOT NULL,
  closeProfit    			NUMBER(20,2)  DEFAULT 0 NOT NULL,
  closeQty   			 	NUMBER(20)    DEFAULT 0 NOT NULL,
  commodityCurrency         VARCHAR2(32)           	NOT NULL,
  commodityCurrencyGroup    VARCHAR2(32)           	NOT NULL,
  commodityNo               VARCHAR2(32)           	NOT NULL,
  commodityType             VARCHAR2(32)           	NOT NULL,
  contractNo               	VARCHAR2(32)           	NOT NULL,
  exchangeMatchNo           VARCHAR2(32)           	NOT NULL,
  exchangeNo               	VARCHAR2(32)           	NOT NULL,
  hedgeFlag               	VARCHAR2(32)           	NOT NULL,
  isManualFee               VARCHAR2(32)           	NOT NULL,
  isUpperManualFee          VARCHAR2(32)           	NOT NULL,
  matchCmbNo               	VARCHAR2(32)           	NOT NULL,
  matchDateTime             VARCHAR2(32)          	NOT NULL,
  matchNo               	VARCHAR2(32)           	NOT NULL,
  matchPrice    			NUMBER(20,2)  DEFAULT 0 NOT NULL,
  matchQty    				NUMBER(20) 	  DEFAULT 0 NOT NULL,
  matchSide               	VARCHAR2(32)           	NOT NULL,
  matchSource               VARCHAR2(32)           	NOT NULL,
  matchStreamID    			NUMBER(20)    DEFAULT 0 NOT NULL,
  matchUpperStreamID    	NUMBER(20)    DEFAULT 0 NOT NULL,
  operateTime               VARCHAR2(32)           	NOT NULL,
  operatorNo               	VARCHAR2(32)           	NOT NULL,
  orderNo               	VARCHAR2(32)           	NOT NULL,
  positionEffect            VARCHAR2(32)           	NOT NULL,
  premiumIncome    			NUMBER(20,2)  DEFAULT 0 NOT NULL,
  premiumPay    			NUMBER(20,2)  DEFAULT 0 NOT NULL,
  settleDate               	VARCHAR2(32)           	NOT NULL,
  settleGroupNo             VARCHAR2(32)           	NOT NULL,
  strikePrice               VARCHAR2(32)           	NOT NULL,
  tradeDate               	VARCHAR2(32)           	NOT NULL,
  turnover    				NUMBER(20,2)  DEFAULT 0 NOT NULL,
  upperFee    				NUMBER(20,2)  DEFAULT 0 NOT NULL,
  upperFeeCurrency          VARCHAR2(32)           	NOT NULL,
  upperFeeCurrencyGroup     VARCHAR2(32)           	NOT NULL,
  upperMatchDateTime        VARCHAR2(32)           	NOT NULL,
  upperNo               	VARCHAR2(32)           	NOT NULL,
  upperOtherFee    			NUMBER(20,2)  DEFAULT 0 NOT NULL,
  remark         			VARCHAR2(64),
  createDate     			DATE                   NOT NULL,
  updateDate     			DATE,
  CONSTRAINT sysHisMatch_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysHisMatch.id IS '主键';
COMMENT ON COLUMN sysHisMatch.accountFee IS '客户手续费';
COMMENT ON COLUMN sysHisMatch.accountFeeCurrency IS '客户手续费币种';
COMMENT ON COLUMN sysHisMatch.accountFeeCurrencyGroup IS '客户手续费币种组';
COMMENT ON COLUMN sysHisMatch.accountNo IS '客户资金帐号';
COMMENT ON COLUMN sysHisMatch.accountOtherFee IS '其他费用';
COMMENT ON COLUMN sysHisMatch.callOrPutFlag IS '看涨看跌';
COMMENT ON COLUMN sysHisMatch.closePrice IS '指定平仓价格';
COMMENT ON COLUMN sysHisMatch.closeProfit IS '平仓盈亏';
COMMENT ON COLUMN sysHisMatch.closeQty IS '平仓量';
COMMENT ON COLUMN sysHisMatch.commodityCurrency IS '品种币种';
COMMENT ON COLUMN sysHisMatch.commodityCurrencyGroup IS '品种币种组';
COMMENT ON COLUMN sysHisMatch.commodityNo IS '品种编号';
COMMENT ON COLUMN sysHisMatch.commodityType IS '品种类型';
COMMENT ON COLUMN sysHisMatch.contractNo IS '合约号';
COMMENT ON COLUMN sysHisMatch.exchangeMatchNo IS '交易所成交号';
COMMENT ON COLUMN sysHisMatch.exchangeNo IS '交易所编号';
COMMENT ON COLUMN sysHisMatch.hedgeFlag IS '投机保值';
COMMENT ON COLUMN sysHisMatch.isManualFee IS '人工客户手续费标记';
COMMENT ON COLUMN sysHisMatch.isUpperManualFee IS '人工上手手续费标记';
COMMENT ON COLUMN sysHisMatch.matchCmbNo IS '组合号';
COMMENT ON COLUMN sysHisMatch.matchDateTime IS '成交时间';
COMMENT ON COLUMN sysHisMatch.matchNo IS '成交序号';
COMMENT ON COLUMN sysHisMatch.matchPrice IS '成交价';
COMMENT ON COLUMN sysHisMatch.matchQty IS '成交量';
COMMENT ON COLUMN sysHisMatch.matchSide IS '买入卖出';
COMMENT ON COLUMN sysHisMatch.matchSource IS '委托来源';
COMMENT ON COLUMN sysHisMatch.matchStreamID IS '成交流水号';
COMMENT ON COLUMN sysHisMatch.matchUpperStreamID IS '上手流水号';
COMMENT ON COLUMN sysHisMatch.operateTime IS '操作时间';
COMMENT ON COLUMN sysHisMatch.operatorNo IS '操作员';
COMMENT ON COLUMN sysHisMatch.orderNo IS '委托号';
COMMENT ON COLUMN sysHisMatch.positionEffect IS '开平标志';
COMMENT ON COLUMN sysHisMatch.premiumIncome IS '权利金收入';
COMMENT ON COLUMN sysHisMatch.premiumPay IS '权利金支出';
COMMENT ON COLUMN sysHisMatch.settleDate IS '结算日期';
COMMENT ON COLUMN sysHisMatch.settleGroupNo IS '结算分组';
COMMENT ON COLUMN sysHisMatch.strikePrice IS '执行价';
COMMENT ON COLUMN sysHisMatch.tradeDate IS '交易日期';
COMMENT ON COLUMN sysHisMatch.turnover IS '成交金额';
COMMENT ON COLUMN sysHisMatch.upperFee IS '上手手续费';
COMMENT ON COLUMN sysHisMatch.upperFeeCurrency IS '上手手续费币种';
COMMENT ON COLUMN sysHisMatch.upperFeeCurrencyGroup IS '上手手续费币种组';
COMMENT ON COLUMN sysHisMatch.upperMatchDateTime IS '上手成交时间';
COMMENT ON COLUMN sysHisMatch.upperNo IS '上手号';
COMMENT ON COLUMN sysHisMatch.upperOtherFee IS '上手其他手续费';
COMMENT ON COLUMN sysHisMatch.remark IS '备注';
COMMENT ON COLUMN sysHisMatch.createDate IS '添加时间';
COMMENT ON COLUMN sysHisMatch.updateDate IS '更新时间';
COMMENT ON TABLE sysHisMatch IS '平台历史成交表';


--平台历史委托表(onRspQryHisOrder)
DROP TABLE sysHisOrder;
CREATE TABLE sysHisOrder
(
  id             			NUMBER(20)             NOT NULL,
  accountNo         		Varchar2(21),
  addOneIsValid     		Char(3),
  callOrPutFlag     	    Char(3),
  callOrPutFlag2     	    Char(3),
  commodityNo     			Varchar2(11),
  commodityType             Char(3),
  contractNo     			Varchar2(11),
  contractNo2     			Varchar2(11),
  date1     			    Varchar2(12),
  errorCode     			Varchar2(51),
  errorText     			Varchar2(51),
  exchangeNo     			Varchar2(11),
  expireTime     			Varchar2(21),
  hedgeFlag     			Char(3),
  inquiryNo     			Varchar2(51),
  isAddOne     			    Char(3),
  isBackInput     			Char(3),
  isDeleted     			Char(3),
  isRiskOrder     			Char(3),
  licenseNo     			Varchar2(51),
  maxClipSize     			number(20)           DEFAULT 0 NOT NULL,
  minClipSize     			number(20)           DEFAULT 0 NOT NULL,
  orderCanceledQty     	    number(8)            DEFAULT 0 NOT NULL,
  orderCommandUserNo     	Varchar2(21),
  orderExchangeSystemNo     Varchar2(51),
  orderInsertTime     		Varchar2(21),
  orderInsertUserNo     	Varchar2(21),
  orderLocalNo     			Varchar2(21),
  orderMatchPrice     		number(18,9)          DEFAULT 0 NOT NULL,
  orderMatchPrice2     		number(18,9)          DEFAULT 0 NOT NULL,
  orderMatchQty     		number(8)             DEFAULT 0 NOT NULL,
  orderMatchQty2     		number(8)             DEFAULT 0 NOT NULL,
  orderMinQty     			number(8)             DEFAULT 0 NOT NULL,
  orderNo     			    Varchar2(21),
  orderParentSystemNo     	Varchar2(51),
  orderPrice     			number(18,9)          DEFAULT 0 NOT NULL,
  orderPrice2     			number(18,9)          DEFAULT 0 NOT NULL,
  orderQty     			    number(20)            DEFAULT 0 NOT NULL,
  orderSide     			Char(3),
  orderSource     			Char(3),
  orderState     			Char(3),
  orderStreamID     		number(8),
  orderSystemNo     		Varchar2(51),
  orderType     			Char(3),
  orderUpdateTime     		Varchar2(21),
  orderUpdateUserNo     	Varchar2(21),
  positionEffect     		Char(3),
  positionEffect2     		Char(3),
  refDouble     			number(18,9)          DEFAULT 0 NOT NULL,
  refInt     			    number(8)             DEFAULT 0 NOT NULL,
  refString     			Varchar2(51)          DEFAULT 0 NOT NULL,
  serverFlag     			Char(3),
  stopPrice     			number(25,25)          DEFAULT 0 NOT NULL,
  strikePrice     			number(25,25)          DEFAULT 0 NOT NULL,
  strikePrice2     			number(25,25)          DEFAULT 0 NOT NULL,
  tacticsType     			Char(3),
  timeInForce     			Char(3),
  triggerCondition     		Char(3),
  triggerPriceType     		Char(3),
  upperChannelNo     		Varchar2(11),
  upperNo     			    Varchar2(11),
  upperStreamID     		number(8)             DEFAULT 0 NOT NULL,
  remark         			VARCHAR2(64),
  createDate     			DATE                   NOT NULL,
  updateDate     			DATE,
  CONSTRAINT sysHisOrder_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysHisOrder.id IS '主键';
COMMENT ON COLUMN sysHisOrder.accountNo IS '客户资金帐号';
COMMENT ON COLUMN sysHisOrder.addOneIsValid IS '是否T+1有效';
COMMENT ON COLUMN sysHisOrder.callOrPutFlag IS '看涨看跌1';
COMMENT ON COLUMN sysHisOrder.callOrPutFlag2 IS '看涨看跌2';
COMMENT ON COLUMN sysHisOrder.commodityNo IS '品种编号';
COMMENT ON COLUMN sysHisOrder.commodityType IS '品种类型';
COMMENT ON COLUMN sysHisOrder.contractNo IS '合约1';
COMMENT ON COLUMN sysHisOrder.contractNo2 IS '合约2';
COMMENT ON COLUMN sysHisOrder.date1 IS '日期';
COMMENT ON COLUMN sysHisOrder.errorCode IS '错误信息码';
COMMENT ON COLUMN sysHisOrder.errorText IS '错误信息';
COMMENT ON COLUMN sysHisOrder.exchangeNo IS '交易所编号';
COMMENT ON COLUMN sysHisOrder.expireTime IS '有效日期(GTD情况下使用)';
COMMENT ON COLUMN sysHisOrder.hedgeFlag IS '投机保值';
COMMENT ON COLUMN sysHisOrder.inquiryNo IS '询价号';
COMMENT ON COLUMN sysHisOrder.isAddOne IS '是否为T+1单';
COMMENT ON COLUMN sysHisOrder.isBackInput IS '是否为录入委托单';
COMMENT ON COLUMN sysHisOrder.isDeleted IS '委托成交删除标志';
COMMENT ON COLUMN sysHisOrder.isRiskOrder IS '是否风险报单';
COMMENT ON COLUMN sysHisOrder.licenseNo IS '软件授权号';
COMMENT ON COLUMN sysHisOrder.maxClipSize IS '冰山单最大随机量';
COMMENT ON COLUMN sysHisOrder.minClipSize IS '冰山单最小随机量';
COMMENT ON COLUMN sysHisOrder.orderCanceledQty IS '撤单数量';
COMMENT ON COLUMN sysHisOrder.orderCommandUserNo IS '录单操作人';
COMMENT ON COLUMN sysHisOrder.orderExchangeSystemNo IS '交易所系统号';
COMMENT ON COLUMN sysHisOrder.orderInsertTime IS '下单时间';
COMMENT ON COLUMN sysHisOrder.orderInsertUserNo IS '下单人';
COMMENT ON COLUMN sysHisOrder.orderLocalNo IS '本地号';
COMMENT ON COLUMN sysHisOrder.orderMatchPrice IS '成交价1';
COMMENT ON COLUMN sysHisOrder.orderMatchPrice2 IS '成交价2';
COMMENT ON COLUMN sysHisOrder.orderMatchQty IS '成交量1';
COMMENT ON COLUMN sysHisOrder.orderMatchQty2 IS '成交量2';
COMMENT ON COLUMN sysHisOrder.orderMinQty IS '最小成交量';
COMMENT ON COLUMN sysHisOrder.orderNo IS '委托编码';
COMMENT ON COLUMN sysHisOrder.orderParentSystemNo IS '父单系统号';
COMMENT ON COLUMN sysHisOrder.orderPrice IS '委托价格1';
COMMENT ON COLUMN sysHisOrder.orderPrice2 IS '委托价格2';
COMMENT ON COLUMN sysHisOrder.orderQty IS '委托数量';
COMMENT ON COLUMN sysHisOrder.orderSide IS '买入卖出';
COMMENT ON COLUMN sysHisOrder.orderSource IS '委托来源';
COMMENT ON COLUMN sysHisOrder.orderState IS '委托状态';
COMMENT ON COLUMN sysHisOrder.orderStreamID IS '委托流水号';
COMMENT ON COLUMN sysHisOrder.orderSystemNo IS '系统号';
COMMENT ON COLUMN sysHisOrder.orderType IS '委托类型';
COMMENT ON COLUMN sysHisOrder.orderUpdateTime IS '委托更新时间';
COMMENT ON COLUMN sysHisOrder.orderUpdateUserNo IS '委托更新人';
COMMENT ON COLUMN sysHisOrder.positionEffect IS '开平标志1';
COMMENT ON COLUMN sysHisOrder.positionEffect2 IS '开平标志2';
COMMENT ON COLUMN sysHisOrder.refDouble IS '浮点参考值';
COMMENT ON COLUMN sysHisOrder.refInt IS '整型参考值';
COMMENT ON COLUMN sysHisOrder.refString IS '字符串参考值';
COMMENT ON COLUMN sysHisOrder.serverFlag IS '服务器标识';
COMMENT ON COLUMN sysHisOrder.stopPrice IS '触发价格';
COMMENT ON COLUMN sysHisOrder.strikePrice IS '执行价格1';
COMMENT ON COLUMN sysHisOrder.strikePrice2 IS '执行价格12';
COMMENT ON COLUMN sysHisOrder.tacticsType IS '策略单类型';
COMMENT ON COLUMN sysHisOrder.timeInForce IS '委托有效类型';
COMMENT ON COLUMN sysHisOrder.triggerCondition IS '触发条件';
COMMENT ON COLUMN sysHisOrder.triggerPriceType IS '触发价格类型';
COMMENT ON COLUMN sysHisOrder.upperChannelNo IS '上手通道号';
COMMENT ON COLUMN sysHisOrder.upperNo IS '上手号';
COMMENT ON COLUMN sysHisOrder.upperStreamID IS '上手流号';
COMMENT ON TABLE sysHisOrder IS '平台历史委托表';
