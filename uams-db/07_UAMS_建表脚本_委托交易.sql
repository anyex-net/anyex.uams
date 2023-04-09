--委托表
DROP TABLE Entrust;
CREATE TABLE Entrust
(
  id                        NUMBER(20)                        NOT NULL,
  accountId                 NUMBER(20)                        NOT NULL,
  entrustTime               TIMESTAMP DEFAULT systimestamp    NOT NULL,
  entrustSource             VARCHAR2(32) DEFAULT 'web'        NOT NULL,
  businessFlag              VARCHAR2(64)                      NOT NULL,
  tradeType                 VARCHAR2(32)					  NOT NULL,
  entrustType               VARCHAR2(32)                      NOT NULL,
  entrustDirect             VARCHAR2(32)                      NOT NULL,
  entrustStockinfoId        NUMBER(20)   					  NOT NULL,
  entrustAmt                NUMBER(20, 8) DEFAULT 0           NOT NULL,
  entrustPrice              NUMBER(20, 8) DEFAULT 0           NOT NULL,
  entrustRemark             VARCHAR2(64),
  entrustAccountType        NUMBER(1) DEFAULT 0               NOT NULL,
  feeType                   NUMBER(20)                        NOT NULL,
  feeRate                   NUMBER(20, 8)                     NOT NULL,
  dealAmt                   NUMBER(20, 8) DEFAULT 0           NOT NULL,
  dealBalance               NUMBER(20, 8) DEFAULT 0           NOT NULL,
  dealFee                   NUMBER(20, 8) DEFAULT 0           NOT NULL,
  status                    VARCHAR2(32) DEFAULT 'init'       NOT NULL,
  updateTime                TIMESTAMP DEFAULT systimestamp    NOT NULL,
  remark                    VARCHAR2(128),
  CONSTRAINT Entrust_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN Entrust.id IS '主键';
COMMENT ON COLUMN Entrust.accountId IS '账户ID';
COMMENT ON COLUMN Entrust.entrustTime IS '委托时间';
COMMENT ON COLUMN Entrust.entrustSource IS '委托来源(web,app,api,agent)';
COMMENT ON COLUMN Entrust.businessFlag IS '业务类别(数据字典)';
COMMENT ON COLUMN Entrust.tradeType IS '交易类型(数据字典)';
COMMENT ON COLUMN Entrust.entrustType IS '委托类型(限价limitPrice、市价marketPrice)';
COMMENT ON COLUMN Entrust.entrustDirect IS '委托方向(数据字典)';
COMMENT ON COLUMN Entrust.entrustStockinfoId IS '委托证券ID';
COMMENT ON COLUMN Entrust.entrustAmt IS '委托数量(对于买入就是委托金额)';
COMMENT ON COLUMN Entrust.entrustPrice IS '委托价格';
COMMENT ON COLUMN Entrust.entrustRemark IS '委托备注';
COMMENT ON COLUMN Entrust.entrustAccountType IS '委托账户类型(0用户委托、1平台委托)';
COMMENT ON COLUMN Entrust.feeType IS '手续费类型';
COMMENT ON COLUMN Entrust.feeRate IS '手续费率';
COMMENT ON COLUMN Entrust.dealAmt IS '成交数量';
COMMENT ON COLUMN Entrust.dealBalance IS '成交金额';
COMMENT ON COLUMN Entrust.dealFee IS '成交手续费';
COMMENT ON COLUMN Entrust.status IS '状态(初始化init、未成交noDeal、部分成交partialDeal、全部成交allDeal、已撤单withDrawed、异常委托abnormal)';
COMMENT ON COLUMN Entrust.updateTime IS '最后更新时间';
COMMENT ON COLUMN Entrust.remark IS '备注';
COMMENT ON TABLE Entrust IS '委托表';


--成交表
DROP TABLE RealDeal;
CREATE TABLE RealDeal
(
  id              NUMBER(20)                        NOT NULL,
  accountId       NUMBER(20)                        NOT NULL,
  entrustId       NUMBER(20)                        NOT NULL,
  tradeType       VARCHAR2(32)                      NOT NULL,
  businessFlag    VARCHAR2(64)                      NOT NULL,
  dealDirect      VARCHAR2(32)                      NOT NULL,
  dealStockInfoId NUMBER(20)                        NOT NULL,
  dealAmt         NUMBER(20, 8) DEFAULT 0           NOT NULL,
  dealPrice       NUMBER(20, 8) DEFAULT 0           NOT NULL,
  dealBalance     NUMBER(20, 8) DEFAULT 0           NOT NULL,
  dealTime        TIMESTAMP DEFAULT systimestamp    NOT NULL,
  feeType         NUMBER(20)                        NOT NULL,
  fee             NUMBER(20, 8) DEFAULT 0           NOT NULL,
  remark          VARCHAR2(128),
  CONSTRAINT RealDeal_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN RealDeal.id IS '主键';
COMMENT ON COLUMN RealDeal.accountId IS '账户ID';
COMMENT ON COLUMN RealDeal.entrustId IS '委托ID';
COMMENT ON COLUMN RealDeal.tradeType IS '交易类型(数据字典)';
COMMENT ON COLUMN RealDeal.businessFlag IS '业务类别(数据字典)';
COMMENT ON COLUMN RealDeal.dealDirect IS '成交方向(数据字典),同委托方向';
COMMENT ON COLUMN RealDeal.dealStockInfoId IS '成交证券ID';
COMMENT ON COLUMN RealDeal.dealAmt IS '成交数量(数量)';
COMMENT ON COLUMN RealDeal.dealPrice IS '成交价格';
COMMENT ON COLUMN RealDeal.dealBalance IS '成交金额(金额)';
COMMENT ON COLUMN RealDeal.dealTime IS '成交时间';
COMMENT ON COLUMN RealDeal.feeType IS '手续费对应证券ID';
COMMENT ON COLUMN RealDeal.fee IS '手续费';
COMMENT ON COLUMN RealDeal.remark IS '备注';
COMMENT ON TABLE RealDeal IS '成交表';
