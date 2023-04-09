-- 初始化消息模版数据;
TRUNCATE table MSGTEMPLATE;
insert into MSGTEMPLATE (id, tplKey, lang, type, title, content, dest, createby, createdate, delflag)
values (200000000004, 'sms_send_valid_code', 'en_US', 'sms', 'Send mobile phone verification code', 'Your verification code is:%s', '发送手机验证码', 200000000000, 1501467844534, 0);
insert into MSGTEMPLATE (id, tplKey, lang, type, title, content, dest, createby, createdate, delflag)
values (200000000005, 'sms_send_valid_code', 'zh_CN', 'sms', '发送手机验证码', 'Your verification code is:%s', '发送手机验证码', 200000000000, 1501467844534, 0);
insert into MSGTEMPLATE (id, tplKey, lang, type, title, content, dest, createby, createdate, delflag)
values (200000000006, 'sms_send_valid_code', 'zh_HK', 'sms', '發送手機驗證碼', 'Your verification code is:%s', '发送手机验证码', 200000000000, 1501467844534, 0);

commit;
