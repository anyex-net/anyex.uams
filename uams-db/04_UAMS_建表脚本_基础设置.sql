--交易市场信息表(onRspQryCommodity)
DROP TABLE marketInfo;
CREATE TABLE marketInfo(
   id NUMBER(20) NOT NULL,
   marketCode VARCHAR2(16) NOT NULL,
   marketName VARCHAR2(32) NOT NULL,
   marketFullName VARCHAR2(64) NOT NULL,
   isStop NUMBER(1) DEFAULT 0 NOT NULL,
   exchangeCode VARCHAR2(32) NOT NULL,
   countryNo VARCHAR2(16) NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT marketInfo_pk PRIMARY KEY(id),
   CONSTRAINT marketInfo_uniques UNIQUE (marketCode)
);
COMMENT ON COLUMN marketInfo.id IS '主键';
COMMENT ON COLUMN marketInfo.marketCode IS '交易市场编码';
COMMENT ON COLUMN marketInfo.marketName IS '交易市场简称';
COMMENT ON COLUMN marketInfo.marketFullName IS '交易市场全称';
COMMENT ON COLUMN marketInfo.isStop IS '停市标志';
COMMENT ON COLUMN marketInfo.exchangeCode IS '市场代码';
COMMENT ON COLUMN marketInfo.countryNo IS '国家或地区(数据字典)';
COMMENT ON COLUMN marketInfo.updateDate IS '更新时间';
COMMENT ON TABLE marketInfo IS '交易市场信息表';

--外汇汇率表
DROP TABLE exchangeRate;
CREATE TABLE exchangeRate(
   id NUMBER(20) NOT NULL,
   exchangDate DATE DEFAULT sysdate NOT NULL,
   currencySource VARCHAR2(16) NOT NULL,
   currencyTarget VARCHAR2(16) NOT NULL,
   buyPrice NUMBER(20,8) DEFAULT 0 NOT NULL,
   sellPrice NUMBER(20,8) DEFAULT 0 NOT NULL,
   midPrice NUMBER(20,8) DEFAULT 0 NOT NULL,
   unitAmount NUMBER(10) DEFAULT 1 NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT exchangeRate_pk PRIMARY KEY(id),
   CONSTRAINT exchangeRate_uniques UNIQUE (exchangDate, currencySource, currencyTarget)
);
COMMENT ON COLUMN exchangeRate.id IS '主键';
COMMENT ON COLUMN exchangeRate.exchangDate IS '汇率日期';
COMMENT ON COLUMN exchangeRate.currencySource IS '源币种(数据字典)';
COMMENT ON COLUMN exchangeRate.currencyTarget IS '目标币种(数据字典)';
COMMENT ON COLUMN exchangeRate.buyPrice IS '买入价';
COMMENT ON COLUMN exchangeRate.sellPrice IS '卖出价';
COMMENT ON COLUMN exchangeRate.midPrice IS '中间价';
COMMENT ON COLUMN exchangeRate.unitAmount IS '最小单位';
COMMENT ON COLUMN exchangeRate.updateDate IS '更新时间';
COMMENT ON TABLE exchangeRate IS '外汇汇率表';

--期货品种表(onRspQryCommodity)
DROP TABLE futureKind;
CREATE TABLE futureKind(
   id NUMBER(20) NOT NULL,
   marketId NUMBER(20) NOT NULL,
   kindCode VARCHAR2(32) NOT NULL,
   kindName VARCHAR2(32) NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT futureKind_pk PRIMARY KEY(id),
   CONSTRAINT futureKind_uniques UNIQUE (marketId, kindCode)
);
COMMENT ON COLUMN futureKind.id IS '主键';
COMMENT ON COLUMN futureKind.marketId IS '交易市场ID';
COMMENT ON COLUMN futureKind.kindCode IS '品种编码';
COMMENT ON COLUMN futureKind.kindName IS '品种名称';
COMMENT ON COLUMN futureKind.updateDate IS '更新时间';
COMMENT ON TABLE futureKind IS '期货品种表';

--市场交易日表
DROP TABLE marketTradeDay;
CREATE TABLE marketTradeDay(
   id NUMBER(20) NOT NULL,
   marketId NUMBER(20) NOT NULL,
   futureKindId NUMBER(20) NOT NULL,
   natureDay NUMBER(8) NOT NULL,
   week NUMBER(2) NOT NULL,
   isTradeDay NUMBER(1) DEFAULT 0 NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT marketTradeDay_pk PRIMARY KEY(id),
   CONSTRAINT marketTradeDay_uniques UNIQUE (marketId, futureKindId, natureDay)
);
COMMENT ON COLUMN marketTradeDay.id IS '主键';
COMMENT ON COLUMN marketTradeDay.marketId IS '交易市场ID';
COMMENT ON COLUMN marketTradeDay.futureKindId IS '期货品种ID';
COMMENT ON COLUMN marketTradeDay.natureDay IS '自然日YYYYMMDD';
COMMENT ON COLUMN marketTradeDay.week IS '星期几';
COMMENT ON COLUMN marketTradeDay.isTradeDay IS '是否是交易日(数据字典)';
COMMENT ON COLUMN marketTradeDay.updateDate IS '更新时间';
COMMENT ON TABLE marketTradeDay IS '市场交易日表';

--期货信息表(onRspQryContract)
DROP TABLE futureInfo;
CREATE TABLE futureInfo(
   id NUMBER(20) NOT NULL,
   interCode VARCHAR2(32) NOT NULL,
   futureKindId NUMBER(20) NOT NULL,
   marketId NUMBER(20) NOT NULL,
   contractMonth NUMBER(6) NOT NULL,
   isMainContract NUMBER(1) DEFAULT 0 NOT NULL,
   targetMarketId NUMBER(20) NOT NULL,
   targetStockCode VARCHAR2(32) NOT NULL,
   multiple NUMBER(10) NOT NULL,
   lastTradeDate NUMBER(8) NOT NULL,
   lastSettlementDate NUMBER(8) NOT NULL,
   lastTradeTime NUMBER(6) NOT NULL,
   price NUMBER(20,8) DEFAULT 0 NOT NULL,
   realPrice NUMBER(20,8) DEFAULT 0 NOT NULL,
   prePrice NUMBER(20,8) DEFAULT 0 NOT NULL,
   positionAmount NUMBER(12) DEFAULT 0 NOT NULL,
   prePositionAmount NUMBER(12) DEFAULT 0 NOT NULL,
   status VARCHAR2(16) DEFAULT 'trading' NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT futureInfo_pk PRIMARY KEY(id),
   CONSTRAINT futureInfo_uniques UNIQUE (interCode, futureKindId)
);
COMMENT ON COLUMN futureInfo.id IS '主键';
COMMENT ON COLUMN futureInfo.interCode IS '证券内码';
COMMENT ON COLUMN futureInfo.futureKindId IS '期货品种ID';
COMMENT ON COLUMN futureInfo.marketId IS '交易市场ID';
COMMENT ON COLUMN futureInfo.contractMonth IS '合约月份YYYYMM';
COMMENT ON COLUMN futureInfo.isMainContract IS '是否主力合约(数据字典)';
COMMENT ON COLUMN futureInfo.targetMarketId IS '标的物市场ID';
COMMENT ON COLUMN futureInfo.targetStockCode IS '标的物证券代码';
COMMENT ON COLUMN futureInfo.multiple IS '合约乘数';
COMMENT ON COLUMN futureInfo.lastTradeDate IS '最后交易日YYYYMMDD';
COMMENT ON COLUMN futureInfo.lastSettlementDate IS '交割日YYYYMMDD';
COMMENT ON COLUMN futureInfo.lastTradeTime IS '最后交易日时间HHMMSS';
COMMENT ON COLUMN futureInfo.price IS '结算价';
COMMENT ON COLUMN futureInfo.realPrice IS '实时行情的结算价';
COMMENT ON COLUMN futureInfo.prePrice IS '前结算价';
COMMENT ON COLUMN futureInfo.positionAmount IS '持仓量';
COMMENT ON COLUMN futureInfo.prePositionAmount IS '前持仓量';
COMMENT ON COLUMN futureInfo.status IS '期货合约状态(数据字典)';
COMMENT ON COLUMN futureInfo.updateDate IS '更新时间';
COMMENT ON TABLE futureInfo IS '期货信息表';

--证券信息表(onRspQryContract)
DROP TABLE stockInfo;
CREATE TABLE stockInfo(
   id NUMBER(20) NOT NULL,
   interCode VARCHAR2(32) NOT NULL,
   marketId NUMBER(20) NOT NULL,
   stockCode VARCHAR2(32) NOT NULL,
   stockName VARCHAR2(32) NOT NULL,
   stockSpell VARCHAR2(64) NOT NULL,
   stockFullName VARCHAR2(64) NOT NULL,
   stockType VARCHAR2(16) NOT NULL,
   assetClass VARCHAR2(16) NOT NULL,
   quotationTable VARCHAR2(32) NOT NULL,
   lastPrice NUMBER(20,8) DEFAULT 0 NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT stockInfo_pk PRIMARY KEY(id),
   CONSTRAINT stockInfo_uniques UNIQUE (interCode)
);
COMMENT ON COLUMN stockInfo.id IS '主键';
COMMENT ON COLUMN stockInfo.interCode IS '证券内码';
COMMENT ON COLUMN stockInfo.marketId IS '交易市场ID';
COMMENT ON COLUMN stockInfo.stockCode IS '证券代码';
COMMENT ON COLUMN stockInfo.stockName IS '证券名称';
COMMENT ON COLUMN stockInfo.stockSpell IS '证券拼音码';
COMMENT ON COLUMN stockInfo.stockFullName IS '证券全称';
COMMENT ON COLUMN stockInfo.stockType IS '证券类别(数据字典)';
COMMENT ON COLUMN stockInfo.assetClass IS '资产类别(数据字典)';
COMMENT ON COLUMN stockInfo.quotationTable IS '外部行情表,如quotationHKEXHSI1803';
COMMENT ON COLUMN stockInfo.lastPrice IS '最新价格';
COMMENT ON COLUMN stockInfo.updateDate IS '更新时间';
COMMENT ON TABLE stockInfo IS '证券信息表';

--经纪商信息表(券商期货公司)
DROP TABLE brokerInfo;
CREATE TABLE brokerInfo(
   id NUMBER(20) NOT NULL,
   brokerCode VARCHAR2(32) NOT NULL,
   brokerName VARCHAR2(64) NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT brokerInfo_pk PRIMARY KEY(id),
   CONSTRAINT brokerInfo_uniques UNIQUE (brokerCode)
);
COMMENT ON COLUMN brokerInfo.id IS '主键';
COMMENT ON COLUMN brokerInfo.brokerCode IS '经纪商代码';
COMMENT ON COLUMN brokerInfo.brokerName IS '经纪商名称';
COMMENT ON COLUMN brokerInfo.updateDate IS '更新时间';
COMMENT ON TABLE brokerInfo IS '经纪商信息表(券商期货公司)';

--期货保证金比例设置表
DROP TABLE futureMarginRatio;
CREATE TABLE futureMarginRatio(
   id NUMBER(20) NOT NULL,
   stockInfoId NUMBER(20) NOT NULL,
   brokerId NUMBER(20) NOT NULL,
   stockHolderId VARCHAR2(32) NOT NULL,
   ratio VARCHAR2(32) NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT futureMarginRatio_pk PRIMARY KEY(id),
   CONSTRAINT futureMarginRatio_uniques UNIQUE (stockInfoId, brokerId, stockHolderId)
);
COMMENT ON COLUMN futureMarginRatio.id IS '主键';
COMMENT ON COLUMN futureMarginRatio.stockInfoId IS '证券信息ID';
COMMENT ON COLUMN futureMarginRatio.brokerId IS '经纪商ID(brokerInfo表)';
COMMENT ON COLUMN futureMarginRatio.stockHolderId IS '股东代码ID';
COMMENT ON COLUMN futureMarginRatio.ratio IS '保证金比例';
COMMENT ON COLUMN futureMarginRatio.updateDate IS '更新时间';
COMMENT ON TABLE futureMarginRatio IS '期货保证金比例设置表';

--期货交易费率信息表

--证券席位表(暂时用不到)

--代理公司在期货公司开设的交易帐号信息等设置表(股东代码表)
DROP TABLE stockHolder;
CREATE TABLE stockHolder(
   id NUMBER(20) NOT NULL,
   brokerId NUMBER(20) NOT NULL,
   stockHolderName VARCHAR2(64) NOT NULL,
   marketId NUMBER(20) NOT NULL,
   openDate NUMBER(8) NOT NULL,
   tradeAcount VARCHAR2(32) NOT NULL,
   fundAccout VARCHAR2(32) NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT stockHolder_pk PRIMARY KEY(id),
   CONSTRAINT stockHolder_uniques UNIQUE (id, brokerId, marketId)
);
COMMENT ON COLUMN stockHolder.id IS '主键';
COMMENT ON COLUMN stockHolder.brokerId IS '经纪商ID(brokerInfo表)';
COMMENT ON COLUMN stockHolder.stockHolderName IS '股东代码名称';
COMMENT ON COLUMN stockHolder.marketId IS '交易市场ID';
COMMENT ON COLUMN stockHolder.openDate IS '开户日期';
COMMENT ON COLUMN stockHolder.tradeAcount IS '交易帐号';
COMMENT ON COLUMN stockHolder.fundAccout IS '资金帐号';
COMMENT ON COLUMN stockHolder.updateDate IS '更新时间';
COMMENT ON TABLE stockHolder IS '代理公司在期货公司开设的交易帐号信息等设置表(股东代码表)';

--各分支机构期货交易所走期货公司通道配置表
DROP TABLE orgTradeChannelCfg;
CREATE TABLE orgTradeChannelCfg(
   id NUMBER(20) NOT NULL,
   orgId NUMBER(20) NOT NULL,
   marketId NUMBER(20) NOT NULL,
   futureKindId NUMBER(20) NOT NULL,
   stockHolderId NUMBER(20) NOT NULL,
   tradeAcount VARCHAR2(32) NOT NULL,
   fundAccout VARCHAR2(32) NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT orgTradeChannelCfg_pk PRIMARY KEY(id),
   CONSTRAINT orgTradeChannelCfg_uniques UNIQUE (orgId, marketId, futureKindId, stockHolderId)
);
COMMENT ON COLUMN orgTradeChannelCfg.id IS '主键';
COMMENT ON COLUMN orgTradeChannelCfg.orgId IS '机构ID';
COMMENT ON COLUMN orgTradeChannelCfg.marketId IS '交易市场ID';
COMMENT ON COLUMN orgTradeChannelCfg.futureKindId IS '期货品种ID';
COMMENT ON COLUMN orgTradeChannelCfg.stockHolderId IS '证券股东信息ID';
COMMENT ON COLUMN orgTradeChannelCfg.tradeAcount IS '证券股东信息对应交易帐号';
COMMENT ON COLUMN orgTradeChannelCfg.fundAccout IS '证券股东信息对应资金帐号';
COMMENT ON COLUMN orgTradeChannelCfg.updateDate IS '更新时间';
COMMENT ON TABLE orgTradeChannelCfg IS '各分支机构期货交易所走期货公司通道配置表';

--各分支机构可交易各大交易所期货品种配置表
DROP TABLE orgTradeStockKindCfg;
CREATE TABLE orgTradeStockKindCfg(
   id NUMBER(20) NOT NULL,
   orgId NUMBER(20) NOT NULL,
   marketId NUMBER(20) NOT NULL,
   futureKindId NUMBER(20) NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT orgTradeStockKindCfg_pk PRIMARY KEY(id),
   CONSTRAINT orgTradeStockKindCfg_uniques UNIQUE (orgId, marketId, futureKindId)
);
COMMENT ON COLUMN orgTradeStockKindCfg.id IS '主键';
COMMENT ON COLUMN orgTradeStockKindCfg.orgId IS '机构ID';
COMMENT ON COLUMN orgTradeStockKindCfg.marketId IS '交易市场ID';
COMMENT ON COLUMN orgTradeStockKindCfg.futureKindId IS '期货品种ID';
COMMENT ON COLUMN orgTradeStockKindCfg.updateDate IS '更新时间';
COMMENT ON TABLE orgTradeStockKindCfg IS '各分支机构可交易各大交易所期货品种配置表';

--各分支机构品种交易费率配置表
DROP TABLE orgTradeFeeCfg;
CREATE TABLE orgTradeFeeCfg(
   id NUMBER(20) NOT NULL,
   orgId NUMBER(20) NOT NULL,
   marketId NUMBER(20) NOT NULL,
   futureKindId NUMBER(20) NOT NULL,
   feeType VARCHAR2(16) NOT NULL,
   feeRateType VARCHAR2(16) NOT NULL,
   feeRate VARCHAR2(16) NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT orgTradeFeeCfg_pk PRIMARY KEY(id),
   CONSTRAINT orgTradeFeeCfg_uniques UNIQUE (orgId, marketId, futureKindId, feeType)
);
COMMENT ON COLUMN orgTradeFeeCfg.id IS '主键';
COMMENT ON COLUMN orgTradeFeeCfg.orgId IS '机构ID';
COMMENT ON COLUMN orgTradeFeeCfg.marketId IS '交易市场ID';
COMMENT ON COLUMN orgTradeFeeCfg.futureKindId IS '期货品种ID';
COMMENT ON COLUMN orgTradeFeeCfg.feeType IS '费用类型(数据字典)';
COMMENT ON COLUMN orgTradeFeeCfg.feeRateType IS '费率类型(数据字典)';
COMMENT ON COLUMN orgTradeFeeCfg.feeRate IS '费率';
COMMENT ON COLUMN orgTradeFeeCfg.updateDate IS '更新时间';
COMMENT ON TABLE orgTradeFeeCfg IS '各分支机构品种交易费率配置表';

--股东表 是我机构开立的在各家期货公司的交易帐号编码信息了
--资金在tassetday
--每家期货公司的交易通道就席位设置
--上次说的券商信息表和营业部表里面要设置分仓地址，结算会员编码等信息
--就是期货保证金比例表
--是的，维护的就是各项费用的收费比例


