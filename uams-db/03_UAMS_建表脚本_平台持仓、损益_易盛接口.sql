--平台期货持仓信息表(onRspQryPosition)
DROP TABLE sysPosition;
CREATE TABLE sysPosition
(
  id             			        NUMBER(20)   DEFAULT 0 NOT NULL,
  accountInitialMargin   		    NUMBER(18,9) DEFAULT 0 NOT NULL,
  accountMaintenanceMargin 		    NUMBER(18,9) DEFAULT 0 NOT NULL,
  accountNo                         Varchar2(21)           ,
  calculatePrice                    number(18,9) DEFAULT 0 NOT NULL,
  callOrPutFlag			            Char(1)                NOT NULL,
  commodityCurrency                 Varchar2(11)           ,
  commodityCurrencyGroup            Varchar2(11)           ,
  commodityNo                       Varchar2(11)           ,
  commodityType                     Char(1)                NOT NULL,
  contractNo         			    Varchar2(11)           ,
  exchangeNo     			        Varchar2(11)           ,
  hedgeFlag     			        Char(1)                NOT NULL,
  lMEPositionProfit                 number(18,9) DEFAULT 0 NOT NULL,
  matchNo                           Varchar2(21)           ,
  matchSide                         Char(1)                NOT NULL,
  optionMarketValue                 number(18,9) DEFAULT 0 NOT NULL,
  orderNo                           Varchar2(21)           ,
  positionNo                        Varchar2(71)           ,
  positionPrice                     number(18,9) DEFAULT 0 NOT NULL,
  positionProfit                    number(18,9) DEFAULT 0 NOT NULL,
  positionQty                       number(20)   DEFAULT 0 NOT NULL,
  positionStreamId                  number(8)    DEFAULT 0 NOT NULL,
  serverFlag                        Char(1)                NOT NULL,
  strikePrice                       Varchar2(11)           ,
  upperInitialMargin                number(18,9) DEFAULT 0 NOT NULL,
  upperMaintenanceMargin            number(18,9) DEFAULT 0 NOT NULL,
  upperNo                           Varchar2(11)           ,
  remark         			        VARCHAR2(64)           ,
  createDate     			        DATE                   NOT NULL,
  updateDate     			        DATE,
  CONSTRAINT sysPosition_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysPosition.id IS '主键';
COMMENT ON COLUMN sysPosition.accountInitialMargin IS '客户初始保证金';
COMMENT ON COLUMN sysPosition.accountMaintenanceMargin IS '客户维持保证金';
COMMENT ON COLUMN sysPosition.accountNo IS '客户资金账号';
COMMENT ON COLUMN sysPosition.calculatePrice IS '当前计算价格';
COMMENT ON COLUMN sysPosition.callOrPutFlag IS '看张看跌';
COMMENT ON COLUMN sysPosition.commodityCurrency IS '品种币种';
COMMENT ON COLUMN sysPosition.commodityCurrencyGroup IS '品种币种组';
COMMENT ON COLUMN sysPosition.commodityNo IS '品种编码';
COMMENT ON COLUMN sysPosition.commodityType IS '品种类型';
COMMENT ON COLUMN sysPosition.contractNo IS '合约1';
COMMENT ON COLUMN sysPosition.exchangeNo IS '交易所编号';
COMMENT ON COLUMN sysPosition.hedgeFlag IS '投机保值';
COMMENT ON COLUMN sysPosition.lMEPositionProfit IS 'LME持仓盈亏';
COMMENT ON COLUMN sysPosition.matchNo IS '本地成交号';
COMMENT ON COLUMN sysPosition.matchSide IS '买入卖出';
COMMENT ON COLUMN sysPosition.optionMarketValue IS '期权市值';
COMMENT ON COLUMN sysPosition.orderNo IS '委托编码';
COMMENT ON COLUMN sysPosition.positionNo IS '本地持仓号';
COMMENT ON COLUMN sysPosition.positionPrice IS '持仓价';
COMMENT ON COLUMN sysPosition.positionProfit IS '持仓盈亏';
COMMENT ON COLUMN sysPosition.positionQty IS '持仓量';
COMMENT ON COLUMN sysPosition.positionStreamId IS '持仓流号';
COMMENT ON COLUMN sysPosition.serverFlag IS '服务器标识';
COMMENT ON COLUMN sysPosition.strikePrice IS '执行价格';
COMMENT ON COLUMN sysPosition.upperInitialMargin IS '上手初始保证金';
COMMENT ON COLUMN sysPosition.upperMaintenanceMargin IS '上手维持保证金';
COMMENT ON COLUMN sysPosition.upperNo IS '上手号';
COMMENT ON TABLE sysPosition IS '平台期货持仓信息表onRspQryPosition';


--平台期货持仓损益信息表(onRtnPositionProfit)
DROP TABLE sysPositionProfit;
CREATE TABLE sysPositionProfit
(
  id             			        NUMBER(20)   DEFAULT 0 NOT NULL,
  calculatePrice                    number(18,9) DEFAULT 0 NOT NULL,
  lMEPositionProfit                 number(18,9) DEFAULT 0 NOT NULL,
  optionMarketValue                 number(18,9) DEFAULT 0 NOT NULL,
  positionNo                        Varchar2(71) ,
  positionProfit                    number(18,9) DEFAULT 0 NOT NULL,
  positionStreamId                  number(8)    DEFAULT 0 NOT NULL,
  remark         			        VARCHAR2(64)           ,
  createDate     			        DATE                   NOT NULL,
  updateDate     			        DATE,
  CONSTRAINT sysPositionProfit_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysPositionProfit.id IS '主键';
COMMENT ON COLUMN sysPositionProfit.calculatePrice IS '计算价格';
COMMENT ON COLUMN sysPositionProfit.lMEPositionProfit IS 'LME持仓盈亏';
COMMENT ON COLUMN sysPositionProfit.optionMarketValue IS '期权市值';
COMMENT ON COLUMN sysPositionProfit.positionNo IS '本地持仓号';
COMMENT ON COLUMN sysPositionProfit.positionProfit IS '持仓盈亏';
COMMENT ON COLUMN sysPositionProfit.positionStreamId IS '持仓流号';
COMMENT ON TABLE  sysPositionProfit IS '平台期货持仓损益信息表onRtnPositionProfit';


--以下需要确认接口数据是否能回来
--平台期货持仓变化记录表(onRtnPosition)
DROP TABLE sysPositionChange;
CREATE TABLE sysPositionChange
(
  id             			        NUMBER(20)   DEFAULT 0 NOT NULL,
  accountInitialMargin   		    NUMBER(18,9) DEFAULT 0 NOT NULL,
  accountMaintenanceMargin 		    NUMBER(18,9) DEFAULT 0 NOT NULL,
  accountNo                         Varchar2(21)           ,
  calculatePrice                    number(18,9) DEFAULT 0 NOT NULL,
  callOrPutFlag			            Char(1)                NOT NULL,
  commodityCurrency                 Varchar2(11)           ,
  commodityCurrencyGroup            Varchar2(11)           ,
  commodityNo                       Varchar2(11)           ,
  commodityType                     Char(1)                NOT NULL,
  contractNo         			    Varchar2(11)           ,
  exchangeNo     			        Varchar2(11)           ,
  hedgeFlag     			        Char(1)                NOT NULL,
  lMEPositionProfit                 number(18,9) DEFAULT 0 NOT NULL,
  matchNo                           Varchar2(21)           ,
  matchSide                              Char(1)           NOT NULL,
  optionMarketValue                 number(18,9) DEFAULT 0 NOT NULL,
  orderNo                           Varchar2(21)           ,
  positionNo                        Varchar2(71)           ,
  positionPrice                     number(18,9) DEFAULT 0 NOT NULL,
  positionProfit                    number(18,9) DEFAULT 0 NOT NULL,
  positionQty                       number(20)   DEFAULT 0 NOT NULL,
  positionStreamId                  number(8)    DEFAULT 0 NOT NULL,
  serverFlag                             Char(1)           NOT NULL,
  strikePrice                       Varchar2(11)           ,
  upperInitialMargin                number(18,9) DEFAULT 0 NOT NULL,
  upperMaintenanceMargin            number(18,9) DEFAULT 0 NOT NULL,
  upperNo                           Varchar2(11)           ,
  remark         			        VARCHAR2(64)           ,
  createDate     			        DATE                   NOT NULL,
  updateDate     			        DATE,
  CONSTRAINT sysPositionChange_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysPositionChange.id IS '主键';
COMMENT ON COLUMN sysPositionChange.accountInitialMargin IS '客户初始保证金';
COMMENT ON COLUMN sysPositionChange.accountMaintenanceMargin IS '客户维持保证金';
COMMENT ON COLUMN sysPositionChange.accountNo IS '客户资金账号';
COMMENT ON COLUMN sysPositionChange.calculatePrice IS '当前计算价格';
COMMENT ON COLUMN sysPositionChange.callOrPutFlag IS '看张看跌';
COMMENT ON COLUMN sysPositionChange.commodityCurrency IS '品种币种';
COMMENT ON COLUMN sysPositionChange.commodityCurrencyGroup IS '品种币种组';
COMMENT ON COLUMN sysPositionChange.commodityNo IS '品种编码';
COMMENT ON COLUMN sysPositionChange.commodityType IS '品种类型';
COMMENT ON COLUMN sysPositionChange.contractNo IS '合约1';
COMMENT ON COLUMN sysPositionChange.exchangeNo IS '交易所编号';
COMMENT ON COLUMN sysPositionChange.hedgeFlag IS '投机保值';
COMMENT ON COLUMN sysPositionChange.lMEPositionProfit IS 'LME持仓盈亏';
COMMENT ON COLUMN sysPositionChange.matchNo IS '本地成交号';
COMMENT ON COLUMN sysPositionChange.matchSide IS '买入卖出';
COMMENT ON COLUMN sysPositionChange.optionMarketValue IS '期权市值';
COMMENT ON COLUMN sysPositionChange.orderNo IS '委托编码';
COMMENT ON COLUMN sysPositionChange.positionNo IS '本地持仓号';
COMMENT ON COLUMN sysPositionChange.positionPrice IS '持仓价';
COMMENT ON COLUMN sysPositionChange.positionProfit IS '持仓盈亏';
COMMENT ON COLUMN sysPositionChange.positionQty IS '持仓量';
COMMENT ON COLUMN sysPositionChange.positionStreamId IS '持仓流号';
COMMENT ON COLUMN sysPositionChange.serverFlag IS '服务器标识';
COMMENT ON COLUMN sysPositionChange.strikePrice IS '执行价格';
COMMENT ON COLUMN sysPositionChange.upperInitialMargin IS '上手初始保证金';
COMMENT ON COLUMN sysPositionChange.upperMaintenanceMargin IS '上手维持保证金';
COMMENT ON COLUMN sysPositionChange.upperNo IS '上手号';
COMMENT ON TABLE sysPositionChange IS '平台期货持仓变化记录表';
