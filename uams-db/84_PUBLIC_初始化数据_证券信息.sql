-- 初始化证券信息;
--TRUNCATE table stockInfo;

insert into stockInfo (ID, INTERCODE, MARKETID, STOCKCODE, STOCKNAME, STOCKSPELL, STOCKFULLNAME, STOCKTYPE, ASSETCLASS, UPDATEDATE, LASTPRICE, QUOTATIONTABLE)
values (210000000002, 'CNY', 1, 'CNY', 'CNY', 'CNY', 'CNY', 'indexFutures', 'stockAsset', to_date('04-02-2018 15:48:01', 'dd-mm-yyyy hh24:mi:ss'), 0.00000000, '');

insert into stockInfo (ID, INTERCODE, MARKETID, STOCKCODE, STOCKNAME, STOCKSPELL, STOCKFULLNAME, STOCKTYPE, ASSETCLASS, UPDATEDATE, LASTPRICE, QUOTATIONTABLE)
values (210000000003, 'USD', 1, 'USD', 'USD', 'USD', 'USD', 'indexFutures', 'stockAsset', to_date('04-02-2018 15:48:01', 'dd-mm-yyyy hh24:mi:ss'), 0.00000000, '');

commit;
