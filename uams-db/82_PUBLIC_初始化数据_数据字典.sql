-- 初始化数据;
TRUNCATE table dictionary;
--男女性别
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000001, null, 'gender_status', '男女性别', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000002, 200000000001, 'man', '男', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000003, 200000000001, 'woman', '女', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--语言类型
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000004, null, 'langType', '语言类型', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000005, 200000000004, 'zh_CN', '简体', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000006, 200000000004, 'zh_HK', '繁体', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000007, 200000000004, 'en_US', '英文', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--消息模板类型
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000008, null, 'msgTemplateType', '消息模板类型', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000009, 200000000008, 'email', '邮件', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000010, 200000000008, 'sms', '短信', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--是或否
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000011, null, 'yesOrNo', '是或否', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000012, 200000000011, '1', '是', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000013, 200000000011, '0', '否', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--期货合约状态
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000014, null, 'futuresContractStatus', '期货合约状态', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000015, 200000000014, 'trading', '交易中', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (200000000016, 200000000014, 'delivered', '已交割', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--币种
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (210000000001, null, 'currency', '币种', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (210000000002, 210000000001, 'CNY', '人民币', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (210000000003, 210000000001, 'USD', '美元', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (210000000004, 210000000001, 'EUR', '欧元', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (210000000005, 210000000001, 'HKD', '港币', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (210000000006, 210000000001, 'BP', '英镑', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (210000000007, 210000000001, 'JPY', '日元', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--国家地区
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (211000000001, null, 'region', '国家地区', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (211000000002, 211000000001, 'China', '中国', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (211000000003, 211000000001, 'HongKong', '香港', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (211000000004, 211000000001, 'UnitedStates', '美国', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (211000000005, 211000000001, 'UnitedKingdom', '英国', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (211000000006, 211000000001, 'Singapore', '新加坡', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--资产类别
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (212000000001, null, 'assetClass', '资产类别', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (212000000002, 212000000001, 'cashAsset', '现金资产', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (212000000003, 212000000001, 'stockAsset', '股票资产', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (212000000004, 212000000001, 'futuresAsset', '期货盈亏', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--证券类别
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (213000000001, null, 'stockType', '证券类别', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (213000000002, 213000000001, 'stock', '股票', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (213000000003, 213000000001, 'indexFutures', '股指期货', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--账户类型
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (214000000001, null, 'accountType', '账户类型', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (214000000002, 214000000001, 'personal', '个人客户', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (214000000003, 214000000001, 'institutional', '机构客户', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--证件类型
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (215000000001, null, 'certificateType', '证件类型', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (215000000002, 215000000001, 'identityCard', '身份证', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (215000000003, 215000000001, 'passPort', '护照', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--开户银行
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (216000000001, null, 'bankDeposit', '开户银行', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (216000000002, 216000000001, 'ICBC', '中国工商银行', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (216000000003, 216000000001, 'ABC', '中国农业银行', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (216000000004, 216000000001, 'BOC', '中国银行', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (216000000005, 216000000001, 'CCB', '中国建设银行', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--风险等级
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (217000000001, null, 'riskLevel', '风险等级', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (217000000002, 217000000001, 'lowRisk', '低风险', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (217000000003, 217000000001, 'mediumRisk', '中风险', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (217000000004, 217000000001, 'highRisk', '高风险', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--账户状态
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (218000000001, null, 'accountStatus', '账户状态', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (218000000002, 218000000001, 'accountNormal', '正常', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (218000000003, 218000000001, 'accountFrozen', '冻结', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (218000000004, 218000000001, 'accountClose', '注销', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--调整类型
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (219000000001, null, 'adjustType', '调整类型', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (219000000002, 219000000001, 'adjustFundAdd', '入金调增', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (219000000003, 219000000001, 'adjustFundSub', '出金调减', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (219000000004, 219000000001, 'adjustCreditAdd', '授信调增', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (219000000005, 219000000001, 'adjustCreditSub', '授信调减', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--持仓方向
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (220000000001, null, 'direction', '持仓方向', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (220000000002, 220000000001, 'long', '多头', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (220000000003, 220000000001, 'short', '空头', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--资产发生方向
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (221000000001, null, 'assetOccurDirect', '资产发生方向', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (221000000002, 221000000001, 'increase', '增加', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (221000000003, 221000000001, 'decrease', '减少', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (221000000004, 221000000001, 'frozen', '冻结', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (221000000005, 221000000001, 'unfrozen', '解冻', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (221000000006, 221000000001, 'frozenDecrease', '解冻并减少', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--业务类别
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (222000000001, null, 'businessFlag', '业务类别', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (222000000002, 222000000001, 'buAdjustAdd', '资金调增', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (222000000003, 222000000001, 'buAdjustSub', '资金调减', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (222000000004, 222000000001, 'buRecharge', '资金充值', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (222000000005, 222000000001, 'buWithdraw', '资金提现', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--费率类型
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (223000000001, null, 'feeRateType', '费率类型', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (223000000002, 223000000001, 'percent', '百分比', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (223000000003, 223000000001, 'absolute', '绝对值', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
--费用类型
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (224000000001, null, 'feeType', '费用类型', null, null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (224000000002, 224000000001, 'buyFee', '买入开仓费用', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);
insert into dictionary (ID, PARENTID, CODE, NAME, LANG, DEST, SORTNUM, ACTIVE, CREATEBY, CREATEDATE, DELFLAG)
values (224000000003, 224000000001, 'sellFee', '卖出开仓费用', 'zh_CN', null, 0, 1, 200000000000, systimestamp, 0);

commit;
