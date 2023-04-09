--账户资金调整记录表
DROP TABLE accountFundAdjust;
CREATE TABLE accountFundAdjust
(
  id           NUMBER(20)                     NOT NULL,
  accountId    NUMBER(20)                     NOT NULL,
  currency 	   VARCHAR2(16)                   NOT NULL,
  adjustType   VARCHAR2(16)                   NOT NULL,
  adjustAmt    NUMBER(20, 8)                  NOT NULL,
  remark       VARCHAR2(256),
  createBy     NUMBER(20),
  createDate   DATE DEFAULT sysdate NOT NULL,
  CONSTRAINT accountFundAdjust_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN accountFundAdjust.id IS '主键';
COMMENT ON COLUMN accountFundAdjust.accountId IS '账户ID';
COMMENT ON COLUMN accountFundAdjust.currency IS '币种(数据字典)';
COMMENT ON COLUMN accountFundAdjust.adjustType IS '调整类型(数据字典:入金调增、出金调减、授信调增、授信调减)';
COMMENT ON COLUMN accountFundAdjust.adjustAmt IS '调整金额数量';
COMMENT ON COLUMN accountFundAdjust.remark IS '备注';
COMMENT ON COLUMN accountFundAdjust.createBy IS '创建人';
COMMENT ON COLUMN accountFundAdjust.createDate IS '创建时间';
COMMENT ON TABLE accountFundAdjust IS '账户资金调整记录表';

--账户资金表
DROP TABLE accountFund;
CREATE TABLE accountFund(
   id NUMBER(20) NOT NULL,
   accountId NUMBER(20) NOT NULL,
   currency VARCHAR2(16) NOT NULL,
   currentAmount NUMBER(20, 8) DEFAULT 0 NOT NULL,
   frozenAmt NUMBER(20, 8) DEFAULT 0 NOT NULL,
   creditAmt NUMBER(20, 8) DEFAULT 0 NOT NULL,
   initAmt NUMBER(20, 8) DEFAULT 0 NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT accountFund_pk PRIMARY KEY(id),
   CONSTRAINT accountFund_uniques UNIQUE (accountId, currency)
);
COMMENT ON COLUMN accountFund.id IS '主键';
COMMENT ON COLUMN accountFund.accountId IS '账户ID';
COMMENT ON COLUMN accountFund.currency IS '币种(数据字典)';
COMMENT ON COLUMN accountFund.currentAmount IS '当前金额数量';
COMMENT ON COLUMN accountFund.frozenAmt IS '冻结金额数量';
COMMENT ON COLUMN accountFund.creditAmt IS '授信金额数量(配资)';
COMMENT ON COLUMN accountFund.initAmt IS '期初金额数量';
COMMENT ON COLUMN accountFund.updateDate IS '更新时间';
COMMENT ON TABLE accountFund IS '账户资金表';

--账户持仓表
DROP TABLE accountAsset;
CREATE TABLE accountAsset(
   id NUMBER(20) NOT NULL,
   accountId NUMBER(20) NOT NULL,
   stockinfoId NUMBER(20) NOT NULL,
   direction VARCHAR2(32) DEFAULT 'Long' NOT NULL,
   currentAmount NUMBER(20, 8) DEFAULT 0 NOT NULL,
   frozenAmt NUMBER(20, 8) DEFAULT 0 NOT NULL,
   initAmt NUMBER(20, 8) DEFAULT 0 NOT NULL,
   price NUMBER(20, 8) DEFAULT 0 NOT NULL,
   updateDate DATE DEFAULT sysdate NOT NULL,
   CONSTRAINT accountAsset_pk PRIMARY KEY(id),
   CONSTRAINT accountAsset_uniques UNIQUE (stockinfoId, accountId, direction)
);
COMMENT ON COLUMN accountAsset.id IS '主键';
COMMENT ON COLUMN accountAsset.accountId IS '账户ID';
COMMENT ON COLUMN accountAsset.stockinfoId IS '证券信息id,对应Stockinfo表中的ID字段';
COMMENT ON COLUMN accountAsset.direction IS '持仓方向(多头Long,空头Short)';
COMMENT ON COLUMN accountAsset.currentAmount IS '当前金额数量';
COMMENT ON COLUMN accountAsset.frozenAmt IS '冻结金额数量';
COMMENT ON COLUMN accountAsset.initAmt IS '期初金额数量';
COMMENT ON COLUMN accountAsset.price IS '加权成本价格';
COMMENT ON COLUMN accountAsset.updateDate IS '更新时间';
COMMENT ON TABLE accountAsset IS '账户持仓表';

--账户资产流水表
DROP TABLE accountFundCurrent;
CREATE TABLE accountFundCurrent
(
  id                 	NUMBER(20)                        NOT NULL,
  accountId          	NUMBER(20)                        NOT NULL,
  currency 		     	VARCHAR2(16)                      NOT NULL,
  currentDate        	TIMESTAMP DEFAULT systimestamp    NOT NULL,
  businessFlag       	VARCHAR2(64)                      NOT NULL,
  stockinfoId        	NUMBER(20)                        NOT NULL,
  occurDirect        	VARCHAR2(16)                      NOT NULL,
  orgAmt             	NUMBER(20, 8) DEFAULT 0           NOT NULL,
  occurAmt           	NUMBER(20, 8) DEFAULT 0           NOT NULL,
  lastAmt            	NUMBER(20, 8) DEFAULT 0           NOT NULL,
  forzenOrgAmt       	NUMBER(20, 8) DEFAULT 0           NOT NULL,
  occurForzenAmt     	NUMBER(20, 8) DEFAULT 0           NOT NULL,
  forzenLastAmt      	NUMBER(20, 8) DEFAULT 0           NOT NULL,
  transId            	VARCHAR2(64),
  sourceAccountBankId   NUMBER(20),
  targetAccountBankId   NUMBER(20),
  fee                	NUMBER(20, 8) DEFAULT 0           NOT NULL,
  netFee             	NUMBER(20, 8) DEFAULT 0,
  originalBusinessId 	NUMBER(20)                        NOT NULL,
  remark             	VARCHAR2(256),
  CONSTRAINT accountFundCurrent_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN accountFundCurrent.id IS '主键';
COMMENT ON COLUMN accountFundCurrent.accountId IS '账户ID';
COMMENT ON COLUMN accountFundCurrent.currency IS '币种(数据字典)';
COMMENT ON COLUMN accountFundCurrent.currentDate IS '流水时间戳';
COMMENT ON COLUMN accountFundCurrent.businessFlag IS '业务类别(数据字典)';
COMMENT ON COLUMN accountFundCurrent.stockinfoId IS '证券信息id,对应Stockinfo表中的ID字段';
COMMENT ON COLUMN accountFundCurrent.occurDirect IS '资产发生方向(增加increase、减少decrease、冻结frozen、解冻unfrozen、解冻并减少frozenDecrease)';
COMMENT ON COLUMN accountFundCurrent.orgAmt IS '原资产当前数量余额';
COMMENT ON COLUMN accountFundCurrent.occurAmt IS '资产增加减少发生数量';
COMMENT ON COLUMN accountFundCurrent.lastAmt IS '最新资产当前数量余额';
COMMENT ON COLUMN accountFundCurrent.forzenOrgAmt IS '原冻结资产数量余额';
COMMENT ON COLUMN accountFundCurrent.occurForzenAmt IS '冻结解冻发生数量';
COMMENT ON COLUMN accountFundCurrent.forzenLastAmt IS '最新冻结资产数量余额';
COMMENT ON COLUMN accountFundCurrent.transId IS '支付交易ID';
COMMENT ON COLUMN accountFundCurrent.sourceAccountBankId IS '源账户银行ID';
COMMENT ON COLUMN accountFundCurrent.targetAccountBankId IS '目标账户银行ID';
COMMENT ON COLUMN accountFundCurrent.fee IS '费用';
COMMENT ON COLUMN accountFundCurrent.netFee IS '转账费用';
COMMENT ON COLUMN accountFundCurrent.originalBusinessId IS '原始业务ID';
COMMENT ON COLUMN accountFundCurrent.remark IS '备注';
COMMENT ON TABLE accountFundCurrent IS '账户资金流水表';