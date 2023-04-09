--平台资金账户信息表(onRspQryAccount)
DROP TABLE sysAccount;
CREATE TABLE sysAccount
(
  id             			NUMBER(20)             NOT NULL,
  accountNo   		        VARCHAR2(32)           NOT NULL,
  accountShortName 		    VARCHAR2(64)           NOT NULL,
  accountEnShortName        VARCHAR2(64)           NOT NULL,
  accountType               VARCHAR2(32)           NOT NULL,
  accountState			    VARCHAR2(32)           NOT NULL,
  accountTradeRight         VARCHAR2(32)           NOT NULL,
  commodityGroupNo          VARCHAR2(32)           NOT NULL,
  remark         			VARCHAR2(64),
  createDate     			DATE                   NOT NULL,
  updateDate     			DATE,
  CONSTRAINT sysAccount_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysAccount.id IS '主键';
COMMENT ON COLUMN sysAccount.accountNo IS '资金账号';
COMMENT ON COLUMN sysAccount.accountShortName IS '账号简称';
COMMENT ON COLUMN sysAccount.accountEnShortName IS '账号英文简称';
COMMENT ON COLUMN sysAccount.accountType IS '账号类型';
COMMENT ON COLUMN sysAccount.accountState IS '账号状态';
COMMENT ON COLUMN sysAccount.accountTradeRight IS '交易状态';
COMMENT ON COLUMN sysAccount.commodityGroupNo IS '可交易品种组';
COMMENT ON COLUMN sysAccount.remark IS '备注';
COMMENT ON COLUMN sysAccount.createDate IS '创建时间';
COMMENT ON COLUMN sysAccount.updateDate IS '修改时间';
COMMENT ON TABLE sysAccount IS '平台资金账户信息表';


--平台资金账户资金信息表(onRspQryFund)
DROP TABLE sysAccountFund;
CREATE TABLE sysAccountFund
(
  id             			NUMBER(20)              NOT NULL,
  accountDeliveryFee        NUMBER(20,2)  DEFAULT 0 NOT NULL,
  accountFee                NUMBER(20,2)  DEFAULT 0 NOT NULL,
  accountIntialMargin       NUMBER(20,2)  DEFAULT 0 NOT NULL,
  accountMaintenanceMargin  NUMBER(20,2)  DEFAULT 0 NOT NULL,
  accountNo   		        VARCHAR2(32)            NOT NULL,
  authMoney                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  available                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  balance                   NUMBER(20,2)  DEFAULT 0 NOT NULL,
  canDraw                   NUMBER(20,2)  DEFAULT 0 NOT NULL,
  cashAdjustValue           NUMBER(20,2)  DEFAULT 0 NOT NULL,
  cashInValue               NUMBER(20,2)  DEFAULT 0 NOT NULL,
  cashOutValue              NUMBER(20,2)  DEFAULT 0 NOT NULL,
  cashPledged               NUMBER(20,2)  DEFAULT 0 NOT NULL,
  closeProfit               NUMBER(20,2)  DEFAULT 0 NOT NULL,
  currencyGroupNo   		VARCHAR2(32)            NOT NULL,
  currencyNo   		        VARCHAR2(32),
  deliveryProfit            NUMBER(20,2)  DEFAULT 0 NOT NULL,
  discount                  NUMBER(20,2)  DEFAULT 0 NOT NULL,
  equity                    NUMBER(20,2)  DEFAULT 0 NOT NULL,
  exchangeFee               NUMBER(20,2)  DEFAULT 0 NOT NULL,
  expProfit                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  frozenDeposit             NUMBER(20,2)  DEFAULT 0 NOT NULL,
  frozenFee                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  futureAlg   		        VARCHAR2(32),
  lmePositionProfit         NUMBER(20,2)  DEFAULT 0 NOT NULL,
  marketEquity              NUMBER(20,2)  DEFAULT 0 NOT NULL,
  optionAlg   		        VARCHAR2(32),
  optionMarketValue         NUMBER(20,2)  DEFAULT 0 NOT NULL,
  positionProfit            NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preAvailable1             NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preBalance                NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preEquity                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preLMEPositionProfit      NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preMarketEquity           NUMBER(20,2)  DEFAULT 0 NOT NULL,
  premiumIncome             NUMBER(20,2)  DEFAULT 0 NOT NULL,
  premiumPay                NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preUnExpProfit            NUMBER(20,2)  DEFAULT 0 NOT NULL,
  tradeRate                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  unExpProfit               NUMBER(20,2)  DEFAULT 0 NOT NULL,
  upperInitalMargin         NUMBER(20,2)  DEFAULT 0 NOT NULL,
  upperMaintenanceMargin    NUMBER(20,2)  DEFAULT 0 NOT NULL,
  remark         			VARCHAR2(64),
  createDate     			DATE                   NOT NULL,
  updateDate     			DATE,
  CONSTRAINT sysAccountFund_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysAccountFund.id IS '主键';
COMMENT ON COLUMN sysAccountFund.accountDeliveryFee IS '客户交割手续费';
COMMENT ON COLUMN sysAccountFund.accountFee IS '客户手续费包含交割手续费';
COMMENT ON COLUMN sysAccountFund.accountIntialMargin IS '客户初始保证金';
COMMENT ON COLUMN sysAccountFund.accountMaintenanceMargin IS '客户维持保证金';
COMMENT ON COLUMN sysAccountFund.accountNo IS '客户资金账号';
COMMENT ON COLUMN sysAccountFund.authMoney IS '授信资金';
COMMENT ON COLUMN sysAccountFund.available IS '当日可用';
COMMENT ON COLUMN sysAccountFund.balance IS '当日结存';
COMMENT ON COLUMN sysAccountFund.canDraw IS '可提取';
COMMENT ON COLUMN sysAccountFund.cashAdjustValue IS '资金调整';
COMMENT ON COLUMN sysAccountFund.cashInValue IS '入金';
COMMENT ON COLUMN sysAccountFund.cashOutValue IS '出金';
COMMENT ON COLUMN sysAccountFund.cashPledged IS '质押资金';
COMMENT ON COLUMN sysAccountFund.closeProfit IS '平仓盈亏';
COMMENT ON COLUMN sysAccountFund.currencyGroupNo IS '币种组号';
COMMENT ON COLUMN sysAccountFund.currencyNo IS '币种号';
COMMENT ON COLUMN sysAccountFund.deliveryProfit IS '交割盈亏';
COMMENT ON COLUMN sysAccountFund.discount IS 'LME贴现';
COMMENT ON COLUMN sysAccountFund.equity IS '当日权益';
COMMENT ON COLUMN sysAccountFund.exchangeFee IS '汇兑手续费';
COMMENT ON COLUMN sysAccountFund.expProfit IS '到期平仓盈亏';
COMMENT ON COLUMN sysAccountFund.frozenDeposit IS '冻结保证金';
COMMENT ON COLUMN sysAccountFund.frozenFee IS '冻结手续费';
COMMENT ON COLUMN sysAccountFund.futureAlg IS '期货算法';
COMMENT ON COLUMN sysAccountFund.lmePositionProfit IS 'ME持仓盈亏';
COMMENT ON COLUMN sysAccountFund.marketEquity IS '账户市值';
COMMENT ON COLUMN sysAccountFund.optionAlg IS '期权算法';
COMMENT ON COLUMN sysAccountFund.optionMarketValue IS '期权市值';
COMMENT ON COLUMN sysAccountFund.positionProfit IS '不含LME持仓盈亏';
COMMENT ON COLUMN sysAccountFund.preAvailable1 IS '上日可用';
COMMENT ON COLUMN sysAccountFund.preBalance IS '上日结存';
COMMENT ON COLUMN sysAccountFund.preEquity IS '上日权益';
COMMENT ON COLUMN sysAccountFund.preLMEPositionProfit IS '上日LME持仓平盈';
COMMENT ON COLUMN sysAccountFund.preMarketEquity IS '上日市值权益';
COMMENT ON COLUMN sysAccountFund.premiumIncome IS '权利金收取';
COMMENT ON COLUMN sysAccountFund.premiumPay IS '利金支付';
COMMENT ON COLUMN sysAccountFund.preUnExpProfit IS '上日未到期平盈';
COMMENT ON COLUMN sysAccountFund.tradeRate IS '交易汇率';
COMMENT ON COLUMN sysAccountFund.unExpProfit IS '未到期平盈';
COMMENT ON COLUMN sysAccountFund.upperInitalMargin IS '上手初始保证金';
COMMENT ON COLUMN sysAccountFund.upperMaintenanceMargin IS '上手维持保证金';
COMMENT ON COLUMN sysAccountFund.remark IS '备注';
COMMENT ON COLUMN sysAccountFund.createDate IS '创建时间';
COMMENT ON COLUMN sysAccountFund.updateDate IS '修改时间';
COMMENT ON TABLE sysAccountFund IS '平台资金账户资金信息表';


--平台资金账户资金变化记录表(onRtnFund)
DROP TABLE sysAccountFundChange;
CREATE TABLE sysAccountFundChange
(
    id             			NUMBER(20)              NOT NULL,
  accountDeliveryFee        NUMBER(20,2)  DEFAULT 0 NOT NULL,
  accountFee                NUMBER(20,2)  DEFAULT 0 NOT NULL,
  accountIntialMargin       NUMBER(20,2)  DEFAULT 0 NOT NULL,
  accountMaintenanceMargin  NUMBER(20,2)  DEFAULT 0 NOT NULL,
  accountNo   		        VARCHAR2(32)            NOT NULL,
  authMoney                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  available                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  balance                   NUMBER(20,2)  DEFAULT 0 NOT NULL,
  canDraw                   NUMBER(20,2)  DEFAULT 0 NOT NULL,
  cashAdjustValue           NUMBER(20,2)  DEFAULT 0 NOT NULL,
  cashInValue               NUMBER(20,2)  DEFAULT 0 NOT NULL,
  cashOutValue              NUMBER(20,2)  DEFAULT 0 NOT NULL,
  cashPledged               NUMBER(20,2)  DEFAULT 0 NOT NULL,
  closeProfit               NUMBER(20,2)  DEFAULT 0 NOT NULL,
  currencyGroupNo   		VARCHAR2(32)            NOT NULL,
  currencyNo   		        VARCHAR2(32),
  deliveryProfit            NUMBER(20,2)  DEFAULT 0 NOT NULL,
  discount                  NUMBER(20,2)  DEFAULT 0 NOT NULL,
  equity                    NUMBER(20,2)  DEFAULT 0 NOT NULL,
  exchangeFee               NUMBER(20,2)  DEFAULT 0 NOT NULL,
  expProfit                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  frozenDeposit             NUMBER(20,2)  DEFAULT 0 NOT NULL,
  frozenFee                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  futureAlg   		        VARCHAR2(32),
  lmePositionProfit         NUMBER(20,2)  DEFAULT 0 NOT NULL,
  marketEquity              NUMBER(20,2)  DEFAULT 0 NOT NULL,
  optionAlg   		        VARCHAR2(32),
  optionMarketValue         NUMBER(20,2)  DEFAULT 0 NOT NULL,
  positionProfit            NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preAvailable1             NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preBalance                NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preEquity                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preLMEPositionProfit      NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preMarketEquity           NUMBER(20,2)  DEFAULT 0 NOT NULL,
  premiumIncome             NUMBER(20,2)  DEFAULT 0 NOT NULL,
  premiumPay                NUMBER(20,2)  DEFAULT 0 NOT NULL,
  preUnExpProfit            NUMBER(20,2)  DEFAULT 0 NOT NULL,
  tradeRate                 NUMBER(20,2)  DEFAULT 0 NOT NULL,
  unExpProfit               NUMBER(20,2)  DEFAULT 0 NOT NULL,
  upperInitalMargin         NUMBER(20,2)  DEFAULT 0 NOT NULL,
  upperMaintenanceMargin    NUMBER(20,2)  DEFAULT 0 NOT NULL,
  remark         			VARCHAR2(64),
  createDate     			DATE                   NOT NULL,
  updateDate     			DATE,
  CONSTRAINT sysAccountFundChange_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysAccountFundChange.id IS '主键';
COMMENT ON COLUMN sysAccountFundChange.accountDeliveryFee IS '客户交割手续费';
COMMENT ON COLUMN sysAccountFundChange.accountFee IS '客户手续费包含交割手续费';
COMMENT ON COLUMN sysAccountFundChange.accountIntialMargin IS '客户初始保证金';
COMMENT ON COLUMN sysAccountFundChange.accountMaintenanceMargin IS '客户维持保证金';
COMMENT ON COLUMN sysAccountFundChange.accountNo IS '客户资金账号';
COMMENT ON COLUMN sysAccountFundChange.authMoney IS '授信资金';
COMMENT ON COLUMN sysAccountFundChange.available IS '当日可用';
COMMENT ON COLUMN sysAccountFundChange.balance IS '当日结存';
COMMENT ON COLUMN sysAccountFundChange.canDraw IS '可提取';
COMMENT ON COLUMN sysAccountFundChange.cashAdjustValue IS '资金调整';
COMMENT ON COLUMN sysAccountFundChange.cashInValue IS '入金';
COMMENT ON COLUMN sysAccountFundChange.cashOutValue IS '出金';
COMMENT ON COLUMN sysAccountFundChange.cashPledged IS '质押资金';
COMMENT ON COLUMN sysAccountFundChange.closeProfit IS '平仓盈亏';
COMMENT ON COLUMN sysAccountFundChange.currencyGroupNo IS '币种组号';
COMMENT ON COLUMN sysAccountFundChange.currencyNo IS '币种号';
COMMENT ON COLUMN sysAccountFundChange.deliveryProfit IS '交割盈亏';
COMMENT ON COLUMN sysAccountFundChange.discount IS 'LME贴现';
COMMENT ON COLUMN sysAccountFundChange.equity IS '当日权益';
COMMENT ON COLUMN sysAccountFundChange.exchangeFee IS '汇兑手续费';
COMMENT ON COLUMN sysAccountFundChange.expProfit IS '到期平仓盈亏';
COMMENT ON COLUMN sysAccountFundChange.frozenDeposit IS '冻结保证金';
COMMENT ON COLUMN sysAccountFundChange.frozenFee IS '冻结手续费';
COMMENT ON COLUMN sysAccountFundChange.futureAlg IS '期货算法';
COMMENT ON COLUMN sysAccountFundChange.lmePositionProfit IS 'ME持仓盈亏';
COMMENT ON COLUMN sysAccountFundChange.marketEquity IS '账户市值';
COMMENT ON COLUMN sysAccountFundChange.optionAlg IS '期权算法';
COMMENT ON COLUMN sysAccountFundChange.optionMarketValue IS '期权市值';
COMMENT ON COLUMN sysAccountFundChange.positionProfit IS '不含LME持仓盈亏';
COMMENT ON COLUMN sysAccountFundChange.preAvailable1 IS '上日可用';
COMMENT ON COLUMN sysAccountFundChange.preBalance IS '上日结存';
COMMENT ON COLUMN sysAccountFundChange.preEquity IS '上日权益';
COMMENT ON COLUMN sysAccountFundChange.preLMEPositionProfit IS '上日LME持仓平盈';
COMMENT ON COLUMN sysAccountFundChange.preMarketEquity IS '上日市值权益';
COMMENT ON COLUMN sysAccountFundChange.premiumIncome IS '权利金收取';
COMMENT ON COLUMN sysAccountFundChange.premiumPay IS '利金支付';
COMMENT ON COLUMN sysAccountFundChange.preUnExpProfit IS '上日未到期平盈';
COMMENT ON COLUMN sysAccountFundChange.tradeRate IS '交易汇率';
COMMENT ON COLUMN sysAccountFundChange.unExpProfit IS '未到期平盈';
COMMENT ON COLUMN sysAccountFundChange.upperInitalMargin IS '上手初始保证金';
COMMENT ON COLUMN sysAccountFundChange.upperMaintenanceMargin IS '上手维持保证金';
COMMENT ON COLUMN sysAccountFundChange.remark IS '备注';
COMMENT ON COLUMN sysAccountFundChange.createDate IS '创建时间';
COMMENT ON COLUMN sysAccountFundChange.updateDate IS '修改时间';
COMMENT ON TABLE sysAccountFundChange IS '平台资金账户资金变化记录表';

--平台资金账户费率(保证金费率等)信息表(onRspQryAccountFeeRent)
DROP TABLE sysAccountFeeRent;
CREATE TABLE sysAccountFeeRent
(
  id             			NUMBER(20)             NOT NULL,
  accountNo   		        VARCHAR2(32)           NOT NULL,
  calculateMode   		    VARCHAR2(32),
  closeTodayFee             NUMBER(20,2) DEFAULT 0 NOT NULL,
  commodityNo   		    VARCHAR2(32)           NOT NULL,
  commodityType   		    VARCHAR2(32)           NOT NULL,
  currencyGroupNo   		VARCHAR2(32)           NOT NULL,
  currencyNo   		        VARCHAR2(32),
  exchangeNo   		        VARCHAR2(32)           NOT NULL,
  matchSource   		    VARCHAR2(32)           NOT NULL,
  openCloseFee              NUMBER(20,2) DEFAULT 0 NOT NULL,
  remark         			VARCHAR2(64),
  createDate     			DATE                   NOT NULL,
  updateDate     			DATE,
  CONSTRAINT sysAccountFeeRent_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysAccountFeeRent.id IS '主键';
COMMENT ON COLUMN sysAccountFeeRent.accountNo IS '资金账号';
COMMENT ON COLUMN sysAccountFeeRent.calculateMode IS '计算方式';
COMMENT ON COLUMN sysAccountFeeRent.closeTodayFee IS '平今费用';
COMMENT ON COLUMN sysAccountFeeRent.commodityNo IS '品种编号';
COMMENT ON COLUMN sysAccountFeeRent.commodityType IS '品种类型';
COMMENT ON COLUMN sysAccountFeeRent.currencyGroupNo IS '币种组';
COMMENT ON COLUMN sysAccountFeeRent.currencyNo IS '币种';
COMMENT ON COLUMN sysAccountFeeRent.exchangeNo IS '市场号';
COMMENT ON COLUMN sysAccountFeeRent.matchSource IS '成交来源';
COMMENT ON COLUMN sysAccountFeeRent.openCloseFee IS '开平仓费用';
COMMENT ON COLUMN sysAccountFeeRent.remark IS '备注';
COMMENT ON COLUMN sysAccountFeeRent.createDate IS '创建时间';
COMMENT ON COLUMN sysAccountFeeRent.updateDate IS '修改时间';
COMMENT ON TABLE sysAccountFeeRent IS '平台资金账户费率(保证金费率等)信息表';


--平台资金账户保证金信息表(onRspQryAccountMarginRent)
DROP TABLE sysAccountMarginRent;
CREATE TABLE sysAccountMarginRent
(
  id             			NUMBER(20)             NOT NULL,
  accountNo   		        VARCHAR2(32)           NOT NULL,
  calculateMode   		    VARCHAR2(32),
  callOrPutFlag   		    VARCHAR2(32)           NOT NULL,
  commodityNo   		    VARCHAR2(32)           NOT NULL,
  commodityType   		    VARCHAR2(32)           NOT NULL,
  contractNo   		        VARCHAR2(32),
  currencyGroupNo   		VARCHAR2(32)           NOT NULL,
  currencyNo   		        VARCHAR2(32)           NOT NULL,
  exchangeNo   		        VARCHAR2(32)           NOT NULL,
  initialMargin             NUMBER(20,2) DEFAULT 0 NOT NULL,
  lockMargin                NUMBER(20,2) DEFAULT 0 NOT NULL,
  maintenanceMargin         NUMBER(20,2) DEFAULT 0 NOT NULL,
  sellInitialMargin         NUMBER(20,2) DEFAULT 0 NOT NULL,
  sellMaintenanceMargin     NUMBER(20,2) DEFAULT 0 NOT NULL,
  strikePrice   		    VARCHAR2(32)           NOT NULL,
  remark         			VARCHAR2(64),
  createDate     			DATE                   NOT NULL,
  updateDate     			DATE,
  CONSTRAINT sysAccountMarginRent_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysAccountMarginRent.id IS '主键';
COMMENT ON COLUMN sysAccountMarginRent.accountNo IS '资金账号';
COMMENT ON COLUMN sysAccountMarginRent.calculateMode IS '计算方式';
COMMENT ON COLUMN sysAccountMarginRent.callOrPutFlag IS '看涨看跌标示';
COMMENT ON COLUMN sysAccountMarginRent.commodityNo IS '品种编号';
COMMENT ON COLUMN sysAccountMarginRent.commodityType IS '品种类型';
COMMENT ON COLUMN sysAccountMarginRent.contractNo IS '合约代码';
COMMENT ON COLUMN sysAccountMarginRent.currencyGroupNo IS '币种组';
COMMENT ON COLUMN sysAccountMarginRent.currencyNo IS '币种';
COMMENT ON COLUMN sysAccountMarginRent.exchangeNo IS '市场号';
COMMENT ON COLUMN sysAccountMarginRent.initialMargin IS '初始保证金';
COMMENT ON COLUMN sysAccountMarginRent.lockMargin IS '锁仓保证金';
COMMENT ON COLUMN sysAccountMarginRent.maintenanceMargin IS '维持保证金';
COMMENT ON COLUMN sysAccountMarginRent.sellInitialMargin IS '卖出初始保证金';
COMMENT ON COLUMN sysAccountMarginRent.sellMaintenanceMargin IS '卖出维持保证金';
COMMENT ON COLUMN sysAccountMarginRent.strikePrice IS '执行价';
COMMENT ON COLUMN sysAccountMarginRent.remark IS '备注';
COMMENT ON COLUMN sysAccountMarginRent.createDate IS '创建时间';
COMMENT ON COLUMN sysAccountMarginRent.updateDate IS '修改时间';
COMMENT ON TABLE sysAccountMarginRent IS '平台资金账户保证金信息表';
