--平台委托实时响应表(onRspOrderAction)
DROP TABLE sysOrderAction;
CREATE TABLE sysOrderAction
(
  id             	       NUMBER(20)        NOT NULL,
  actionType               Char(8)           NOT NULL,
  accountNo                Varchar2(64)      NOT NULL,
  addOneIsValid            Char(8)           NOT NULL,
  callOrPutFlag            Char(8)           NOT NULL,
  callOrPutFlag2           Char(8)           NOT NULL,
  clientID                 Varchar2(64)      ,
  clientIP                 Varchar2(64)      NOT NULL,
  clientLocalIP            Varchar2(64)      NOT NULL,
  clientMac                Varchar2(64)      NOT NULL,
  clientOrderNo            Varchar2(64)      NOT NULL,
  commodityNo              Varchar2(64)      NOT NULL,
  commodityType            Char(8)           NOT NULL,
  contractNo               Varchar2(64)      NOT NULL,
  contractNo2              Varchar2(64)      ,
  errorCode                Varchar2(64)      NOT NULL,
  errorText                Varchar2(64)      ,
  exchangeNo               Varchar2(64)      NOT NULL,
  expireTime               DATE,
  hedgeFlag                Char(8)           NOT NULL,
  inquiryNo                Varchar2(64)      ,
  isAddOne                 Char(8)           NOT NULL,
  isBackInput              Char(8)           NOT NULL,
  isDeleted                Char(8)           NOT NULL,
  isRiskOrder              Char(8)           NOT NULL,
  licenseNo                Varchar2(64)      ,
  maxClipSize              number(20)        NOT NULL,
  minClipSize              number(20)        NOT NULL,
  orderCommandUserNo       Varchar2(64)      ,
  orderExchangeSystemNo    Varchar2(64)      ,
  orderInsertTime          DATE,
  orderInsertUserNo        Varchar2(64)      NOT NULL,
  orderLocalNo             Varchar2(64)      ,
  orderMatchPrice          number(18,2)      NOT NULL,
  orderMatchPrice2         number(18,2)      NOT NULL,
  orderMatchQty            number(8)         NOT NULL,
  orderMatchQty2           number(8)         NOT NULL,
  orderMinQty              number(8)         NOT NULL,
  orderNo                  Varchar2(64)      NOT NULL,
  orderParentSystemNo      Varchar2(64)       ,
  orderPrice               number(18,9)      NOT NULL,
  orderPrice2              number(18,9)      NOT NULL,
  orderQty                 number(20)        NOT NULL,
  orderSide                Char(8)           NOT NULL,
  orderSource              Char(8)           NOT NULL,
  orderState               Char(8)           NOT NULL,
  orderStreamID            number(20)         NOT NULL,
  orderSystemNo            Varchar2(64)       ,
  orderType                Char(8)           NOT NULL,
  orderUpdateTime          DATE,
  orderUpdateUserNo        Varchar2(64)      ,
  positionEffect           Char(8)           NOT NULL,
  positionEffect2          Char(8)           NOT NULL,
  refDouble                number(18,9)      NOT NULL,
  refInt                   number(20)         NOT NULL,
  refString                Varchar2(64)      ,
  serverFlag               Char(8)           NOT NULL,
  stopPrice                number(18,9)      NOT NULL,
  strikePrice              number(18,9)      NOT NULL,
  strikePrice2             number(18,9)      NOT NULL,
  tacticsType              Char(8)           NOT NULL,
  timeInForce              Char(8)           NOT NULL,
  triggerCondition         Char(8)           NOT NULL,
  triggerPriceType         Char(8)           NOT NULL,
  upperChannelNo           Varchar2(64)      NOT NULL,
  upperNo                  Varchar2(64)      NOT NULL,
  upperStreamID            number(20)         NOT NULL,
  remark         		   VARCHAR2(64),
  createDate     		   DATE,
  updateDate     		   DATE,
  CONSTRAINT sysOrderAction_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysOrderAction.id                        IS '主键';
COMMENT ON COLUMN sysOrderAction.actionType                IS '操作类型';
COMMENT ON COLUMN sysOrderAction.accountNo                 IS '客户资金帐号';
COMMENT ON COLUMN sysOrderAction.addOneIsValid             IS '是否T+1有效';
COMMENT ON COLUMN sysOrderAction.callOrPutFlag             IS '看涨看跌1';
COMMENT ON COLUMN sysOrderAction.callOrPutFlag2            IS '看涨看跌2';
COMMENT ON COLUMN sysOrderAction.clientID                  IS '客户子账号.';
COMMENT ON COLUMN sysOrderAction.clientIP                  IS '终端网络地址.';
COMMENT ON COLUMN sysOrderAction.clientLocalIP             IS '终端本地IP';
COMMENT ON COLUMN sysOrderAction.clientMac                 IS '终端本地Mac地址';
COMMENT ON COLUMN sysOrderAction.clientOrderNo             IS '客户端本地委托编号';
COMMENT ON COLUMN sysOrderAction.commodityNo               IS '品种编号';
COMMENT ON COLUMN sysOrderAction.commodityType             IS '品种类型';
COMMENT ON COLUMN sysOrderAction.contractNo                IS '合约1';
COMMENT ON COLUMN sysOrderAction.contractNo2               IS '合约2';
COMMENT ON COLUMN sysOrderAction.errorCode                 IS '错误信息码';
COMMENT ON COLUMN sysOrderAction.errorText                 IS '错误信息';
COMMENT ON COLUMN sysOrderAction.exchangeNo                IS '交易所编号';
COMMENT ON COLUMN sysOrderAction.expireTime                IS '有效日期(GTD情况下使用)';
COMMENT ON COLUMN sysOrderAction.hedgeFlag                 IS '投机保值';
COMMENT ON COLUMN sysOrderAction.inquiryNo                 IS '询价号';
COMMENT ON COLUMN sysOrderAction.isAddOne                  IS '是否为T+1单';
COMMENT ON COLUMN sysOrderAction.isBackInput               IS '是否为录入委托单';
COMMENT ON COLUMN sysOrderAction.isDeleted                 IS '委托成交删除标志';
COMMENT ON COLUMN sysOrderAction.isRiskOrder               IS '是否风险报单';
COMMENT ON COLUMN sysOrderAction.licenseNo                 IS '软件授权号';
COMMENT ON COLUMN sysOrderAction.maxClipSize               IS '冰山单最大随机量';
COMMENT ON COLUMN sysOrderAction.minClipSize               IS '冰山单最小随机量';
COMMENT ON COLUMN sysOrderAction.orderCommandUserNo        IS '录单操作人';
COMMENT ON COLUMN sysOrderAction.orderExchangeSystemNo     IS '交易所系统号';
COMMENT ON COLUMN sysOrderAction.orderInsertTime           IS '下单时间';
COMMENT ON COLUMN sysOrderAction.orderInsertUserNo         IS '下单人';
COMMENT ON COLUMN sysOrderAction.orderLocalNo              IS '本地号';
COMMENT ON COLUMN sysOrderAction.orderMatchPrice           IS '成交价1';
COMMENT ON COLUMN sysOrderAction.orderMatchPrice2          IS '成交价2';
COMMENT ON COLUMN sysOrderAction.orderMatchQty             IS '成交量1';
COMMENT ON COLUMN sysOrderAction.orderMatchQty2            IS '成交量2';
COMMENT ON COLUMN sysOrderAction.orderMinQty               IS '最小成交量';
COMMENT ON COLUMN sysOrderAction.orderNo                   IS '委托编码';
COMMENT ON COLUMN sysOrderAction.orderParentSystemNo       IS '父单系统号';
COMMENT ON COLUMN sysOrderAction.orderPrice                IS '委托价格1';
COMMENT ON COLUMN sysOrderAction.orderPrice2               IS '委托价格2';
COMMENT ON COLUMN sysOrderAction.orderQty                  IS '委托数量';
COMMENT ON COLUMN sysOrderAction.orderSide                 IS '买入卖出';
COMMENT ON COLUMN sysOrderAction.orderSource               IS '委托来源';
COMMENT ON COLUMN sysOrderAction.orderState                IS '委托状态';
COMMENT ON COLUMN sysOrderAction.orderStreamID             IS '委托流水号';
COMMENT ON COLUMN sysOrderAction.orderSystemNo             IS '系统号';
COMMENT ON COLUMN sysOrderAction.orderType                 IS '委托类型';
COMMENT ON COLUMN sysOrderAction.orderUpdateTime           IS '委托更新时间';
COMMENT ON COLUMN sysOrderAction.orderUpdateUserNo         IS '委托更新人';
COMMENT ON COLUMN sysOrderAction.positionEffect            IS '开平标志1';
COMMENT ON COLUMN sysOrderAction.positionEffect2           IS '开平标志2';
COMMENT ON COLUMN sysOrderAction.refDouble                 IS '浮点参考值';
COMMENT ON COLUMN sysOrderAction.refInt                    IS '整型参考值';
COMMENT ON COLUMN sysOrderAction.refString                 IS '字符串参考值';
COMMENT ON COLUMN sysOrderAction.serverFlag                IS '服务器标识';
COMMENT ON COLUMN sysOrderAction.stopPrice                 IS '触发价格';
COMMENT ON COLUMN sysOrderAction.strikePrice               IS '执行价格1';
COMMENT ON COLUMN sysOrderAction.strikePrice2              IS '执行价格2';
COMMENT ON COLUMN sysOrderAction.tacticsType               IS '策略单类型';
COMMENT ON COLUMN sysOrderAction.timeInForce               IS '委托有效类型';
COMMENT ON COLUMN sysOrderAction.triggerCondition          IS '触发条件';
COMMENT ON COLUMN sysOrderAction.triggerPriceType          IS '触发价格类型';
COMMENT ON COLUMN sysOrderAction.upperChannelNo            IS '上手通道号';
COMMENT ON COLUMN sysOrderAction.upperNo                   IS '上手号';
COMMENT ON COLUMN sysOrderAction.upperStreamID             IS '上手流号';
COMMENT ON COLUMN sysOrderAction.remark                    IS '备注';
COMMENT ON COLUMN sysOrderAction.createDate                IS '创建时间';
COMMENT ON COLUMN sysOrderAction.updateDate                IS '修改时间';
COMMENT ON TABLE sysOrderAction IS '平台委托实时响应表';


--平台委托变化记录表(onRtnOrder)
DROP TABLE sysOrderChange;
CREATE TABLE sysOrderChange
(
  id             		            NUMBER(20)            NOT NULL,
  errorCode1                        Number(20)             NOT NULL,
  accountNo                         Varchar2(64)          NOT NULL,
  addOneIsValid                     Char(8)               NOT NULL,
  callOrPutFlag                     Char(8)               NOT NULL,
  callOrPutFlag2                    Char(8)               NOT NULL,
  clientID                          Varchar2(64)          ,
  clientIP                          Varchar2(64)          NOT NULL,
  clientLocalIP                     Varchar2(64)          NOT NULL,
  clientMac                         Varchar2(64)          NOT NULL,
  clientOrderNo                     Varchar2(64)          NOT NULL,
  commodityNo                       Varchar2(64)          NOT NULL,
  commodityType                     Char(8)               NOT NULL,
  contractNo                        Varchar2(64)          NOT NULL,
  contractNo2                       Varchar2(64)          ,
  errorCode                         Varchar2(64)          NOT NULL,
  errorText                         Varchar2(64)          ,
  exchangeNo                        Varchar2(64)          NOT NULL,
  expireTime                        DATE,
  hedgeFlag                         Char(8)               NOT NULL,
  inquiryNo                         Varchar2(64)          ,
  isAddOne                          Char(8)               NOT NULL,
  isBackInput                       Char(8)               NOT NULL,
  isDeleted                         Char(8)               NOT NULL,
  isRiskOrder                       Char(8)               NOT NULL,
  licenseNo                         Varchar2(64)          ,
  maxClipSize                       number(20)            NOT NULL,
  minClipSize                       number(20)            NOT NULL,
  orderCommandUserNo                Varchar2(64)          ,
  orderExchangeSystemNo             Varchar2(64)          ,
  orderInsertTime                   DATE,
  orderInsertUserNo                 Varchar2(64)          NOT NULL,
  orderLocalNo                      Varchar2(64)          ,
  orderMatchPrice                   number(18,9)          NOT NULL,
  orderMatchPrice2                  number(18,9)          NOT NULL,
  orderMatchQty                     number(20)             NOT NULL,
  orderMatchQty2                    number(20)             NOT NULL,
  orderMinQty                       number(20)             NOT NULL,
  orderNo                           Varchar2(64)          NOT NULL,
  orderParentSystemNo               Varchar2(64)          ,
  orderPrice                        number(18,9)          NOT NULL,
  orderPrice2                       number(18,9)          NOT NULL,
  orderQty                          number(20)            NOT NULL,
  orderSide                         Char(8)               NOT NULL,
  orderSource                       Char(8)               NOT NULL,
  orderState                        Char(8)               NOT NULL,
  orderStreamID                     number(20)             NOT NULL,
  orderSystemNo                     Varchar2(64)          ,
  orderType                         Char(8)               NOT NULL,
  orderUpdateTime                   DATE,
  orderUpdateUserNo                 Varchar2(64)          ,
  positionEffect                    Char(8)               NOT NULL,
  positionEffect2                   Char(8)               NOT NULL,
  refDouble                         number(18,9)          NOT NULL,
  refInt                            number(20)             NOT NULL,
  refString                         Varchar2(51)          ,
  serverFlag                        Char(8)               NOT NULL,
  stopPrice                         number(18,9)          NOT NULL,
  strikePrice                       number(18,9)          NOT NULL,
  strikePrice2                      number(18,9)          NOT NULL,
  tacticsType                       Char(8)               NOT NULL,
  timeInForce                       Char(8)               NOT NULL,
  triggerCondition                  Char(8)               NOT NULL,
  triggerPriceType                  Char(8)               NOT NULL,
  upperChannelNo                    Varchar2(64)          NOT NULL,
  upperNo                           Varchar2(64)          NOT NULL,
  upperStreamID                     number(20)             NOT NULL,
  sessionID                         Number(20)             NOT NULL,
  remark         		           	VARCHAR2(64),
  createDate     	           		DATE ,
  updateDate     		           	DATE,
  CONSTRAINT sysOrderChange_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysOrderChange.id                               IS '主键';
COMMENT ON COLUMN sysOrderChange.errorCode1                       IS '外层错误码';
COMMENT ON COLUMN sysOrderChange.accountNo                        IS '客户资金帐号';
COMMENT ON COLUMN sysOrderChange.addOneIsValid                    IS '是否T+1有效';
COMMENT ON COLUMN sysOrderChange.callOrPutFlag                    IS '看涨看跌1';
COMMENT ON COLUMN sysOrderChange.callOrPutFlag2                   IS '看涨看跌2';
COMMENT ON COLUMN sysOrderChange.clientID                         IS '客户子账号.';
COMMENT ON COLUMN sysOrderChange.clientIP                         IS '终端网络地址.';
COMMENT ON COLUMN sysOrderChange.clientLocalIP                    IS '终端本地IP';
COMMENT ON COLUMN sysOrderChange.clientMac                        IS '终端本地Mac地址';
COMMENT ON COLUMN sysOrderChange.clientOrderNo                    IS '客户端本地委托编号';
COMMENT ON COLUMN sysOrderChange.commodityNo                      IS '品种编号';
COMMENT ON COLUMN sysOrderChange.commodityType                    IS '品种类型';
COMMENT ON COLUMN sysOrderChange.contractNo                       IS '合约1';
COMMENT ON COLUMN sysOrderChange.contractNo2                      IS '合约2';
COMMENT ON COLUMN sysOrderChange.errorCode                        IS '里层错误码';
COMMENT ON COLUMN sysOrderChange.errorText                        IS '错误信息';
COMMENT ON COLUMN sysOrderChange.exchangeNo                       IS '交易所编号';
COMMENT ON COLUMN sysOrderChange.expireTime                       IS '有效日期(GTD情况下使用)';
COMMENT ON COLUMN sysOrderChange.hedgeFlag                        IS '投机保值';
COMMENT ON COLUMN sysOrderChange.inquiryNo                        IS '询价号';
COMMENT ON COLUMN sysOrderChange.isAddOne                         IS '是否为T+1单';
COMMENT ON COLUMN sysOrderChange.isBackInput                      IS '是否为录入委托单';
COMMENT ON COLUMN sysOrderChange.isDeleted                        IS '委托成交删除标志';
COMMENT ON COLUMN sysOrderChange.isRiskOrder                      IS '是否风险报单';
COMMENT ON COLUMN sysOrderChange.licenseNo                        IS '软件授权号';
COMMENT ON COLUMN sysOrderChange.maxClipSize                      IS '冰山单最大随机量';
COMMENT ON COLUMN sysOrderChange.minClipSize                      IS '冰山单最小随机量';
COMMENT ON COLUMN sysOrderChange.orderCommandUserNo               IS '录单操作人';
COMMENT ON COLUMN sysOrderChange.orderExchangeSystemNo            IS '交易所系统号';
COMMENT ON COLUMN sysOrderChange.orderInsertTime                  IS '下单时间';
COMMENT ON COLUMN sysOrderChange.orderInsertUserNo                IS '下单人';
COMMENT ON COLUMN sysOrderChange.orderLocalNo                     IS '本地号';
COMMENT ON COLUMN sysOrderChange.orderMatchPrice                  IS '成交价1';
COMMENT ON COLUMN sysOrderChange.orderMatchPrice2                 IS '成交价2';
COMMENT ON COLUMN sysOrderChange.orderMatchQty                    IS '成交量1';
COMMENT ON COLUMN sysOrderChange.orderMatchQty2                   IS '成交量2';
COMMENT ON COLUMN sysOrderChange.orderMinQty                      IS '最小成交量';
COMMENT ON COLUMN sysOrderChange.orderNo                          IS '委托编码';
COMMENT ON COLUMN sysOrderChange.orderParentSystemNo              IS '父单系统号';
COMMENT ON COLUMN sysOrderChange.orderPrice                       IS '委托价格1';
COMMENT ON COLUMN sysOrderChange.orderPrice2                      IS '委托价格2';
COMMENT ON COLUMN sysOrderChange.orderQty                         IS '委托数量';
COMMENT ON COLUMN sysOrderChange.orderSide                        IS '买入卖出';
COMMENT ON COLUMN sysOrderChange.orderSource                      IS '委托来源';
COMMENT ON COLUMN sysOrderChange.orderState                       IS '委托状态';
COMMENT ON COLUMN sysOrderChange.orderStreamID                    IS '委托流水号';
COMMENT ON COLUMN sysOrderChange.orderSystemNo                    IS '系统号';
COMMENT ON COLUMN sysOrderChange.orderType                        IS '委托类型';
COMMENT ON COLUMN sysOrderChange.orderUpdateTime                  IS '委托更新时间';
COMMENT ON COLUMN sysOrderChange.orderUpdateUserNo                IS '委托更新人';
COMMENT ON COLUMN sysOrderChange.positionEffect                   IS '开平标志1';
COMMENT ON COLUMN sysOrderChange.positionEffect2                  IS '开平标志2';
COMMENT ON COLUMN sysOrderChange.refDouble                        IS '浮点参考值';
COMMENT ON COLUMN sysOrderChange.refInt                           IS '整型参考值';
COMMENT ON COLUMN sysOrderChange.refString                        IS '字符串参考值';
COMMENT ON COLUMN sysOrderChange.serverFlag                       IS '服务器标识';
COMMENT ON COLUMN sysOrderChange.stopPrice                        IS '触发价格';
COMMENT ON COLUMN sysOrderChange.strikePrice                      IS '执行价格1';
COMMENT ON COLUMN sysOrderChange.strikePrice2                     IS '执行价格2';
COMMENT ON COLUMN sysOrderChange.tacticsType                      IS '策略单类型';
COMMENT ON COLUMN sysOrderChange.timeInForce                      IS '委托有效类型';
COMMENT ON COLUMN sysOrderChange.triggerCondition                 IS '触发条件';
COMMENT ON COLUMN sysOrderChange.triggerPriceType                 IS '触发价格类型';
COMMENT ON COLUMN sysOrderChange.upperChannelNo                   IS '上手通道号';
COMMENT ON COLUMN sysOrderChange.upperNo                          IS '上手号';
COMMENT ON COLUMN sysOrderChange.upperStreamID                    IS '上手流号';
COMMENT ON COLUMN sysOrderChange.sessionID                        IS '会话ID';
COMMENT ON COLUMN sysOrderChange.remark                           IS '备注';
COMMENT ON COLUMN sysOrderChange.createDate                       IS '创建时间';
COMMENT ON COLUMN sysOrderChange.updateDate                       IS '修改时间';
COMMENT ON TABLE sysOrderChange IS '平台委托变化记录表';


--平台委托信息表(onRspQryOrder)1
DROP TABLE sysOrder;
CREATE TABLE sysOrder
(
  id             			    NUMBER(20)                    NOT NULL,
  accountNo                     Varchar2(64)                  NOT NULL,
  addOneIsValid                 Char(8)                       NOT NULL,
  callOrPutFlag                 Char(8)                       NOT NULL,
  callOrPutFlag2                Char(8)                       NOT NULL,
  clientID                      Varchar2(64)                  ,
  clientIP                      Varchar2(64)                  NOT NULL,
  clientLocalIP                 Varchar2(64)                  NOT NULL,
  clientMac                     Varchar2(64)                  NOT NULL,
  clientOrderNo                 Varchar2(64)                  NOT NULL,
  commodityNo                   Varchar2(64)                  NOT NULL,
  commodityType                 Char(8)                       NOT NULL,
  contractNo                    Varchar2(64)                  NOT NULL,
  contractNo2                   Varchar2(64)                  ,
  errorCode                     Varchar2(64)                  NOT NULL,
  errorText                     Varchar2(64)                  ,
  exchangeNo                    Varchar2(64)                  NOT NULL,
  expireTime                    Date ,
  hedgeFlag                     Char(8)                       NOT NULL,
  inquiryNo                     Varchar2(64)                  ,
  isAddOne                      Char(8)                       NOT NULL,
  isBackInput                   Char(8)                       NOT NULL,
  isDeleted                     Char(8)                       NOT NULL,
  isRiskOrder                   Char(8)                       NOT NULL,
  licenseNo                     Varchar2(64)                  ,
  maxClipSize                   number(20)                    NOT NULL,
  minClipSize                   number(20)                    NOT NULL,
  orderCommandUserNo            Varchar2(64)                  ,
  orderExchangeSystemNo         Varchar2(64)                  ,
  orderInsertTime               Date ,
  orderInsertUserNo             Varchar2(64)                  NOT NULL,
  orderLocalNo                  Varchar2(64)                  ,
  orderMatchPrice               number(18,9)                  NOT NULL,
  orderMatchPrice2              number(18,9)                  NOT NULL,
  orderMatchQty                 Varchar2(64)                  NOT NULL,
  orderMatchQty2                Varchar2(64)                  NOT NULL,
  orderMinQty                   number(20)                    NOT NULL,
  orderNo                       Varchar2(64)                  NOT NULL,
  orderParentSystemNo           Varchar2(64)                  ,
  orderPrice                    number(18,9)                  NOT NULL,
  orderPrice2                   number(18,9)                  NOT NULL,
  orderQty                      number(20)                    NOT NULL,
  orderSide                     Char(8)                       NOT NULL,
  orderSource                   Char(8)                       NOT NULL,
  orderState                    Char(8)                       NOT NULL,
  orderStreamID                 number(20)                    NOT NULL,
  orderSystemNo                 Varchar2(64)                  ,
  orderType                     Char(8)                       NOT NULL,
  orderUpdateTime               Varchar2(64)                  ,
  orderUpdateUserNo             Varchar2(64)                  ,
  positionEffect                Char(8)                       NOT NULL,
  positionEffect2               Char(8)                       NOT NULL,
  refDouble                     number(18,9)                  NOT NULL,
  refInt                        number(20)                     NOT NULL,
  refString                     Varchar2(64)                  ,
  serverFlag                    Char(8)                       NOT NULL,
  stopPrice                     number(18,9)                  NOT NULL,
  strikePrice                   number(18,9)       DEFAULT 0  NOT NULL,
  strikePrice2                  number(18,9)       DEFAULT 0  NOT NULL,
  tacticsType                   Char(8)                       NOT NULL,
  timeInForce                   Char(8)                       NOT NULL,
  triggerCondition              Char(8)                       NOT NULL,
  triggerPriceType              Char(8)                       NOT NULL,
  upperChannelNo                Varchar2(64)                  NOT NULL,
  upperNo                       Varchar2(64)                  NOT NULL,
  upperStreamID                 number(20)                     NOT NULL,
  remark         		     	VARCHAR2(64),
  createDate     	     		  DATE                          ,
  updateDate     	         	DATE,
  CONSTRAINT sysOrder_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysOrder.id                      IS '主键';
COMMENT ON COLUMN sysOrder.accountNo               IS '客户资金帐号';
COMMENT ON COLUMN sysOrder.addOneIsValid           IS '是否T+1有效';
COMMENT ON COLUMN sysOrder.callOrPutFlag           IS '看涨看跌1';
COMMENT ON COLUMN sysOrder.callOrPutFlag2          IS '看涨看跌2';
COMMENT ON COLUMN sysOrder.clientID                IS '客户子账号 .';
COMMENT ON COLUMN sysOrder.clientIP                IS '终端网络地址.';
COMMENT ON COLUMN sysOrder.clientLocalIP           IS '终端本地IP';
COMMENT ON COLUMN sysOrder.clientMac               IS '终端本地Mac地址';
COMMENT ON COLUMN sysOrder.clientOrderNo           IS '客户端本地委托编号';
COMMENT ON COLUMN sysOrder.commodityNo             IS '品种编号';
COMMENT ON COLUMN sysOrder.commodityType           IS '品种类型';
COMMENT ON COLUMN sysOrder.contractNo              IS '合约1';
COMMENT ON COLUMN sysOrder.contractNo2             IS '合约2';
COMMENT ON COLUMN sysOrder.errorCode               IS '错误信息码';
COMMENT ON COLUMN sysOrder.errorText               IS '错误信息';
COMMENT ON COLUMN sysOrder.exchangeNo              IS '交易所编号';
COMMENT ON COLUMN sysOrder.expireTime              IS '有效日期(GTD情况下使用)';
COMMENT ON COLUMN sysOrder.hedgeFlag               IS '投机保值';
COMMENT ON COLUMN sysOrder.inquiryNo               IS '询价号';
COMMENT ON COLUMN sysOrder.isAddOne                IS '是否为T+1单';
COMMENT ON COLUMN sysOrder.isBackInput             IS '是否为录入委托单';
COMMENT ON COLUMN sysOrder.isDeleted               IS '委托成交删除标志';
COMMENT ON COLUMN sysOrder.isRiskOrder             IS '是否风险报单';
COMMENT ON COLUMN sysOrder.licenseNo               IS '软件授权号';
COMMENT ON COLUMN sysOrder.maxClipSize             IS '冰山单最大随机量';
COMMENT ON COLUMN sysOrder.minClipSize             IS '冰山单最小随机量';
COMMENT ON COLUMN sysOrder.orderCommandUserNo      IS '录单操作人';
COMMENT ON COLUMN sysOrder.orderExchangeSystemNo   IS '交易所系统号';
COMMENT ON COLUMN sysOrder.orderInsertTime         IS '下单时间';
COMMENT ON COLUMN sysOrder.orderInsertUserNo       IS '下单人';
COMMENT ON COLUMN sysOrder.orderLocalNo            IS '本地号';
COMMENT ON COLUMN sysOrder.orderMatchPrice         IS '成交价1';
COMMENT ON COLUMN sysOrder.orderMatchPrice2        IS '成交价2';
COMMENT ON COLUMN sysOrder.orderMatchQty           IS '成交量1';
COMMENT ON COLUMN sysOrder.orderMatchQty2          IS '成交量2';
COMMENT ON COLUMN sysOrder.orderMinQty             IS '最小成交量';
COMMENT ON COLUMN sysOrder.orderNo                 IS '委托编码';
COMMENT ON COLUMN sysOrder.orderParentSystemNo     IS '父单系统号';
COMMENT ON COLUMN sysOrder.orderPrice              IS '委托价格1';
COMMENT ON COLUMN sysOrder.orderPrice2             IS '委托价格2';
COMMENT ON COLUMN sysOrder.orderQty                IS '委托数量';
COMMENT ON COLUMN sysOrder.orderSide               IS '买入卖出';
COMMENT ON COLUMN sysOrder.orderSource             IS '委托来源';
COMMENT ON COLUMN sysOrder.orderState              IS '委托状态';
COMMENT ON COLUMN sysOrder.orderStreamID           IS '委托流水号';
COMMENT ON COLUMN sysOrder.orderSystemNo           IS '系统号';
COMMENT ON COLUMN sysOrder.orderType               IS '委托类型';
COMMENT ON COLUMN sysOrder.orderUpdateTime         IS '委托更新时间';
COMMENT ON COLUMN sysOrder.orderUpdateUserNo       IS '委托更新人';
COMMENT ON COLUMN sysOrder.positionEffect          IS '开平标志1';
COMMENT ON COLUMN sysOrder.positionEffect2         IS '开平标志2';
COMMENT ON COLUMN sysOrder.refDouble               IS '浮点参考值';
COMMENT ON COLUMN sysOrder.refInt                  IS '整型参考值';
COMMENT ON COLUMN sysOrder.refString               IS '字符串参考值';
COMMENT ON COLUMN sysOrder.serverFlag              IS '服务器标识';
COMMENT ON COLUMN sysOrder.stopPrice               IS '触发价格';
COMMENT ON COLUMN sysOrder.strikePrice             IS '执行价格1';
COMMENT ON COLUMN sysOrder.strikePrice2            IS '执行价格2';
COMMENT ON COLUMN sysOrder.tacticsType             IS '策略单类型';
COMMENT ON COLUMN sysOrder.timeInForce             IS '委托有效类型';
COMMENT ON COLUMN sysOrder.triggerCondition        IS '触发条件';
COMMENT ON COLUMN sysOrder.triggerPriceType        IS '触发价格类型';
COMMENT ON COLUMN sysOrder.upperChannelNo          IS '上手通道号';
COMMENT ON COLUMN sysOrder.upperNo                 IS '上手号';
COMMENT ON COLUMN sysOrder.upperStreamID           IS '上手流号';
COMMENT ON COLUMN sysOrder.remark                  IS '备注';
COMMENT ON COLUMN sysOrder.createDate              IS '创建时间';
COMMENT ON COLUMN sysOrder.updateDate              IS '修改时间';
COMMENT ON TABLE sysOrder IS '平台委托信息表';


--平台成交信息表(onRspQryFill)
DROP TABLE sysFill;
CREATE TABLE sysFill
(
  id             	    		NUMBER(20)              NOT NULL,
  accountNo                     Varchar2(21)            NOT NULL,
  callOrPutFlag                 Char(4)                 NOT NULL,
  closePrositionPrice           number(18,9)            NOT NULL,
  commodityNo                   Varchar2(11)            NOT NULL,
  commodityType                 Char(4)                 NOT NULL,
  contractNo                    Varchar2(11)            NOT NULL,
  exchangeNo                    Varchar2(11)            NOT NULL,
  feeCurrency                   Varchar2(11)            NOT NULL,
  feeCurrencyGroup              Varchar2(11)            NOT NULL,
  feeValue                      number(18,9)            NOT NULL,
  isAddOne                      Char(4)                 NOT NULL,
  isDeleted                     Char(4)                 NOT NULL,
  isManualFee                   Char(4)                 NOT NULL,
  matchDateTime                 DATE,
  matchNo                       Varchar2(21)            NOT NULL,
  matchPrice                    number(18,9)            NOT NULL,
  matchQty                      number(8)               NOT NULL,
  matchSide                     Char(4)                 NOT NULL,
  matchSource                   Char(4)                 NOT NULL,
  orderNo                       Varchar2(21)            NOT NULL,
  orderSystemNo                 Varchar2(51)            ,
  positionEffect                Char(4)                 NOT NULL,
  serverFlag                    Char(4)                 NOT NULL,
  strikePrice                   Varchar2(11)            NOT NULL,
  upperMatchDateTime            DATE,
  upperMatchNo                  Varchar2(71)            NOT NULL,
  upperNo                       Varchar2(11)            NOT NULL,
  remark         		       	VARCHAR2(64),
  createDate     		       	DATE,
  updateDate     		       	DATE,
  CONSTRAINT sysFill_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysFill.id                  IS '主键';
COMMENT ON COLUMN sysFill.accountNo           IS '客户资金帐号';
COMMENT ON COLUMN sysFill.callOrPutFlag       IS '看涨看跌';
COMMENT ON COLUMN sysFill.closePrositionPrice IS '指定价格平仓';
COMMENT ON COLUMN sysFill.commodityNo         IS '品种编号';
COMMENT ON COLUMN sysFill.commodityType       IS '品种类型';
COMMENT ON COLUMN sysFill.contractNo          IS '合约1';
COMMENT ON COLUMN sysFill.exchangeNo          IS '交易所编号';
COMMENT ON COLUMN sysFill.feeCurrency         IS '手续费币种';
COMMENT ON COLUMN sysFill.feeCurrencyGroup    IS '手续费币种组';
COMMENT ON COLUMN sysFill.feeValue            IS '手续费';
COMMENT ON COLUMN sysFill.isAddOne            IS '是否为T+1单';
COMMENT ON COLUMN sysFill.isDeleted           IS '委托成交删除标';
COMMENT ON COLUMN sysFill.isManualFee         IS '人工客户手续费标记';
COMMENT ON COLUMN sysFill.matchDateTime       IS '成交时间';
COMMENT ON COLUMN sysFill.matchNo             IS '本地成交号';
COMMENT ON COLUMN sysFill.matchPrice          IS '成交价';
COMMENT ON COLUMN sysFill.matchQty            IS '成交量';
COMMENT ON COLUMN sysFill.matchSide           IS '买入卖出';
COMMENT ON COLUMN sysFill.matchSource         IS '委托来源';
COMMENT ON COLUMN sysFill.orderNo             IS '委托编码';
COMMENT ON COLUMN sysFill.orderSystemNo       IS '系统号';
COMMENT ON COLUMN sysFill.positionEffect      IS '开平标志1';
COMMENT ON COLUMN sysFill.serverFlag          IS '服务器标识';
COMMENT ON COLUMN sysFill.strikePrice         IS '执行价格';
COMMENT ON COLUMN sysFill.upperMatchDateTime  IS '上手成交时间';
COMMENT ON COLUMN sysFill.upperMatchNo        IS '上手成交号';
COMMENT ON COLUMN sysFill.upperNo             IS '上手号';
COMMENT ON COLUMN sysFill.remark              IS '备注';
COMMENT ON COLUMN sysFill.createDate          IS '创建时间';
COMMENT ON COLUMN sysFill.updateDate          IS '修改时间';
COMMENT ON TABLE sysFill IS '平台成交信息表';


--平台委托处理状态表(onRspQryOrderProcess)
DROP TABLE sysOrderProcess;
CREATE TABLE sysOrderProcess
(
  id             			         NUMBER(20)                       NOT NULL,
  accountNo                          Varchar2(64)                     NOT NULL,
  addOneIsValid                      Char(8)                          NOT NULL,
  callOrPutFlag                      Char(8)                          NOT NULL,
  callOrPutFlag2                     Char(8)                          NOT NULL,
  clientID                           Varchar2(64)                     ,
  clientIP                           Varchar2(64)                     NOT NULL,
  clientLocalIP                      Varchar2(64)                     NOT NULL,
  clientMac                          Varchar2(64)                     NOT NULL,
  clientOrderNo                      Varchar2(64)                     NOT NULL,
  commodityNo                        Varchar2(64)                     NOT NULL,
  commodityType                      Char(8)                          NOT NULL,
  contractNo                         Varchar2(64)                     NOT NULL,
  contractNo2                        Varchar2(64)                     ,
  errorCode                          Varchar2(64)                     NOT NULL,
  errorText                          Varchar2(64)                     ,
  exchangeNo                         Varchar2(64)                     NOT NULL,
  expireTime                         DATE                             ,
  hedgeFlag                          Char(8)                          NOT NULL,
  inquiryNo                          Varchar2(64)                     ,
  isAddOne                           Char(8)                          NOT NULL,
  isBackInput                        Char(8)                          NOT NULL,
  isDeleted                          Char(8)                          NOT NULL,
  isRiskOrder                        Char(8)                          NOT NULL,
  licenseNo                          Varchar2(64)                     ,
  maxClipSize                        number(20)                       NOT NULL,
  minClipSize                        number(20)                       NOT NULL,
  orderCommandUserNo                 Varchar2(64)                     ,
  orderExchangeSystemNo              Varchar2(64)                     ,
  orderInsertTime                    DATE                             NOT NULL,
  orderInsertUserNo                  Varchar2(64)                     NOT NULL,
  orderLocalNo                       Varchar2(64)                     ,
  orderMatchPrice                    number(18,9)                     NOT NULL,
  orderMatchPrice2                   number(18,9)                     NOT NULL,
  orderMatchQty                      number(20)                       NOT NULL,
  orderMatchQty2                     number(20)                       NOT NULL,
  orderMinQty                        number(20)                       NOT NULL,
  orderNo                            Varchar2(64)                     NOT NULL,
  orderParentSystemNo                Varchar2(64)                     ,
  orderPrice                         number(18,9)                     NOT NULL,
  orderPrice2                        number(18,9)                     NOT NULL,
  orderQty                           number(20)                       NOT NULL,
  orderSide                          Char(8)                          NOT NULL,
  orderSource                        Char(8)                          NOT NULL,
  orderState                         Char(8)                          NOT NULL,
  orderStreamID                      number(20)                        NOT NULL,
  orderSystemNo                      Varchar2(64)                     ,
  orderType                          Char(8)                          NOT NULL,
  orderUpdateTime                    DATE                              ,
  orderUpdateUserNo                  Varchar2(64)                      ,
  positionEffect                     Char(8)                          NOT NULL,
  positionEffect2                    Char(8)                          NOT NULL,
  refDouble                          number(18,9)                     NOT NULL,
  refInt                             number(20)                        NOT NULL,
  refString                          Varchar2(64)                     ,
  serverFlag                         Char(8)                          NOT NULL,
  stopPrice                          number(18,9)                     NOT NULL,
  strikePrice                        number(18,9)                     NOT NULL,
  strikePrice2                       number(18,9)                     NOT NULL,
  tacticsType                        Char(8)                          NOT NULL,
  timeInForce                        Char(8)                          NOT NULL,
  triggerCondition                   Char(8)                          NOT NULL,
  triggerPriceType                   Char(8)                          NOT NULL,
  upperChannelNo                     Varchar2(64)                     NOT NULL,
  upperNo                            Varchar2(64)                     NOT NULL,
  upperStreamID                      number(20)                        NOT NULL,
  remark         			         VARCHAR2(64),
  createDate     			         DATE                           ,
  updateDate                         DATE,
  CONSTRAINT sysOrderProcess_PK PRIMARY KEY (id)
);
COMMENT ON COLUMN sysOrderProcess.id                     IS '主键';
COMMENT ON COLUMN sysOrderProcess.accountNo              IS '客户资金帐号';
COMMENT ON COLUMN sysOrderProcess.addOneIsValid          IS '是否T+1有效';
COMMENT ON COLUMN sysOrderProcess.callOrPutFlag          IS '看涨看跌1';
COMMENT ON COLUMN sysOrderProcess.callOrPutFlag2         IS '看涨看跌2';
COMMENT ON COLUMN sysOrderProcess.clientID               IS '客户子账号.';
COMMENT ON COLUMN sysOrderProcess.clientIP               IS '终端网络地址.';
COMMENT ON COLUMN sysOrderProcess.clientLocalIP          IS '终端本地IP';
COMMENT ON COLUMN sysOrderProcess.clientMac              IS '终端本地Mac地址';
COMMENT ON COLUMN sysOrderProcess.clientOrderNo          IS '客户端本地委托编号';
COMMENT ON COLUMN sysOrderProcess.commodityNo            IS '品种编号';
COMMENT ON COLUMN sysOrderProcess.commodityType          IS '品种类型';
COMMENT ON COLUMN sysOrderProcess.contractNo             IS '合约1';
COMMENT ON COLUMN sysOrderProcess.contractNo2            IS '合约2';
COMMENT ON COLUMN sysOrderProcess.errorCode              IS '错误信息码';
COMMENT ON COLUMN sysOrderProcess.errorText              IS '错误信息';
COMMENT ON COLUMN sysOrderProcess.exchangeNo             IS '交易所编号';
COMMENT ON COLUMN sysOrderProcess.expireTime             IS '有效日期(GTD情况下使用)';
COMMENT ON COLUMN sysOrderProcess.hedgeFlag              IS '投机保值';
COMMENT ON COLUMN sysOrderProcess.inquiryNo              IS '询价号';
COMMENT ON COLUMN sysOrderProcess.isAddOne               IS '是否为T+1单';
COMMENT ON COLUMN sysOrderProcess.isBackInput            IS '是否为录入委托单';
COMMENT ON COLUMN sysOrderProcess.isDeleted              IS '委托成交删除标志';
COMMENT ON COLUMN sysOrderProcess.isRiskOrder            IS '是否风险报单';
COMMENT ON COLUMN sysOrderProcess.licenseNo              IS '软件授权号';
COMMENT ON COLUMN sysOrderProcess.maxClipSize            IS '冰山单最大随机量';
COMMENT ON COLUMN sysOrderProcess.minClipSize            IS '冰山单最小随机量';
COMMENT ON COLUMN sysOrderProcess.orderCommandUserNo     IS '录单操作人';
COMMENT ON COLUMN sysOrderProcess.orderExchangeSystemNo  IS '交易所系统号';
COMMENT ON COLUMN sysOrderProcess.orderInsertTime        IS '下单时间';
COMMENT ON COLUMN sysOrderProcess.orderInsertUserNo      IS '下单人';
COMMENT ON COLUMN sysOrderProcess.orderLocalNo           IS '本地号';
COMMENT ON COLUMN sysOrderProcess.orderMatchPrice        IS '成交价1';
COMMENT ON COLUMN sysOrderProcess.orderMatchPrice2       IS '成交价2';
COMMENT ON COLUMN sysOrderProcess.orderMatchQty          IS '成交量1';
COMMENT ON COLUMN sysOrderProcess.orderMatchQty2         IS '成交量2';
COMMENT ON COLUMN sysOrderProcess.orderMinQty            IS '最小成交量';
COMMENT ON COLUMN sysOrderProcess.orderNo                IS '委托编码';
COMMENT ON COLUMN sysOrderProcess.orderParentSystemNo    IS '父单系统号';
COMMENT ON COLUMN sysOrderProcess.orderPrice             IS '委托价格1';
COMMENT ON COLUMN sysOrderProcess.orderPrice2            IS '委托价格2';
COMMENT ON COLUMN sysOrderProcess.orderQty               IS '委托数量';
COMMENT ON COLUMN sysOrderProcess.orderSide              IS '买入卖出';
COMMENT ON COLUMN sysOrderProcess.orderSource            IS '委托来源';
COMMENT ON COLUMN sysOrderProcess.orderState             IS '委托状态';
COMMENT ON COLUMN sysOrderProcess.orderStreamID          IS '委托流水号';
COMMENT ON COLUMN sysOrderProcess.orderSystemNo          IS '系统号';
COMMENT ON COLUMN sysOrderProcess.orderType              IS '委托类型';
COMMENT ON COLUMN sysOrderProcess.orderUpdateTime        IS '委托更新时间';
COMMENT ON COLUMN sysOrderProcess.orderUpdateUserNo      IS '委托更新人';
COMMENT ON COLUMN sysOrderProcess.positionEffect         IS '开平标志1';
COMMENT ON COLUMN sysOrderProcess.positionEffect2        IS '开平标志2';
COMMENT ON COLUMN sysOrderProcess.refDouble              IS '浮点参考值';
COMMENT ON COLUMN sysOrderProcess.refInt                 IS '整型参考值';
COMMENT ON COLUMN sysOrderProcess.refString              IS '字符串参考值';
COMMENT ON COLUMN sysOrderProcess.serverFlag             IS '服务器标识';
COMMENT ON COLUMN sysOrderProcess.stopPrice              IS '触发价格';
COMMENT ON COLUMN sysOrderProcess.strikePrice            IS '执行价格1';
COMMENT ON COLUMN sysOrderProcess.strikePrice2           IS '执行价格2';
COMMENT ON COLUMN sysOrderProcess.tacticsType            IS '策略单类型';
COMMENT ON COLUMN sysOrderProcess.timeInForce            IS '委托有效类型';
COMMENT ON COLUMN sysOrderProcess.triggerCondition       IS '触发条件';
COMMENT ON COLUMN sysOrderProcess.triggerPriceType       IS '触发价格类型';
COMMENT ON COLUMN sysOrderProcess.upperChannelNo         IS '上手通道号';
COMMENT ON COLUMN sysOrderProcess.upperNo                IS '上手号';
COMMENT ON COLUMN sysOrderProcess.upperStreamID          IS '上手流号';
COMMENT ON COLUMN sysOrderProcess.remark                 IS '备注';
COMMENT ON COLUMN sysOrderProcess.createDate             IS '创建时间';
COMMENT ON COLUMN sysOrderProcess.updateDate             IS '修改时间';
COMMENT ON TABLE sysOrderProcess IS '平台委托处理状态表';
