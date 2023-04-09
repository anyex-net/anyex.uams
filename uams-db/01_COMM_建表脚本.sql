DROP TABLE MsgTemplate;
CREATE TABLE MsgTemplate(
   id NUMBER(20) NOT NULL ,
   tplKey VARCHAR2(64) NOT NULL ,
   lang VARCHAR2(8) ,
   type VARCHAR2(16) NOT NULL ,
   title VARCHAR2(256) NOT NULL ,
   content VARCHAR2(2000) NOT NULL ,
   dest VARCHAR2(256) ,
   createBy NUMBER(20) ,
   createDate NUMBER(13 , 0) ,
   delFlag NUMBER(1 , 0) DEFAULT 0 NOT NULL ,
   CONSTRAINT sms_template_pk PRIMARY KEY(id) ,
   CONSTRAINT sms_template_casuniques UNIQUE(lang , type , tplKey)
);
COMMENT ON COLUMN MsgTemplate.id IS '主键';
COMMENT ON COLUMN MsgTemplate.tplKey IS '模版KEY';
COMMENT ON COLUMN MsgTemplate.lang IS '语言编码（en_US,zh_CN,zh_HK)';
COMMENT ON COLUMN MsgTemplate.type IS '模版类型(email:邮件、sms:短信)';
COMMENT ON COLUMN MsgTemplate.title IS '标题（邮件用）';
COMMENT ON COLUMN MsgTemplate.content IS '模版内容';
COMMENT ON COLUMN MsgTemplate.dest IS '描述';
COMMENT ON COLUMN MsgTemplate.createBy IS '创建人';
COMMENT ON COLUMN MsgTemplate.createDate IS '创建时间';
COMMENT ON COLUMN MsgTemplate.delFlag IS '删除标识';
COMMENT ON TABLE MsgTemplate IS '消息模版';

DROP TABLE MsgRecord;
CREATE TABLE MsgRecord(
   id NUMBER(20) NOT NULL ,
   orgId NUMBER(20) NOT NULL ,
   type VARCHAR2(10) NOT NULL ,
   object VARCHAR2(64) NOT NULL ,
   content clob NOT NULL ,
   createDate NUMBER(13 , 0) NOT NULL ,
   status NUMBER(1 , 0) NOT NULL ,
   CONSTRAINT MsgRecord_PK PRIMARY KEY(id)
);
COMMENT ON COLUMN MsgRecord.id IS '主键';
COMMENT ON COLUMN MsgRecord.orgId IS '机构ID';
COMMENT ON COLUMN MsgRecord.type IS '消息类型(email:邮件、sms:短信)';
COMMENT ON COLUMN MsgRecord.object IS ' 发送对象';
COMMENT ON COLUMN MsgRecord.content IS '内容';
COMMENT ON COLUMN MsgRecord.createDate IS '创建时间';
COMMENT ON COLUMN MsgRecord.status IS '发送状态（0：成功，1：失败）';
COMMENT ON TABLE MsgRecord IS '消息发送记录';

DROP TABLE Dictionary;
CREATE TABLE Dictionary(
   id NUMBER(20) NOT NULL ,
   parentId VARCHAR2(18) ,
   code VARCHAR2(64) NOT NULL ,
   name VARCHAR2(128) NOT NULL ,
   lang VARCHAR2(32) ,
   dest VARCHAR2(256) ,
   sortNum NUMBER(10 , 0) ,
   active NUMBER(1 , 0) NOT NULL ,
   createBy NUMBER(20) ,
   createDate TIMESTAMP DEFAULT systimestamp ,
   delFlag NUMBER(1 , 0) DEFAULT 0 NOT NULL ,
   CONSTRAINT dictionary_pk PRIMARY KEY(id) ,
   CONSTRAINT dictionary_casuniques UNIQUE(lang , code)
);
COMMENT ON COLUMN Dictionary.id IS '主键';
COMMENT ON COLUMN Dictionary.parentId IS '上级编码';
COMMENT ON COLUMN Dictionary.code IS '编码';
COMMENT ON COLUMN Dictionary.name IS '名称';
COMMENT ON COLUMN Dictionary.lang IS '语言类型';
COMMENT ON COLUMN Dictionary.dest IS '描述';
COMMENT ON COLUMN Dictionary.createBy IS '创建人';
COMMENT ON COLUMN Dictionary.createDate IS '创建时间';
COMMENT ON COLUMN Dictionary.active IS '启用标识';
COMMENT ON COLUMN Dictionary.delFlag IS '删除标识';
COMMENT ON COLUMN Dictionary.sortNum IS '排序号';
COMMENT ON TABLE Dictionary IS '数据典';

DROP TABLE Region;
CREATE TABLE Region(
   id NUMBER(20) NOT NULL ,
   sCode VARCHAR2(64) ,
   lCode VARCHAR2(64) ,
   enName VARCHAR2(128) ,
   cnName VARCHAR2(128) ,
   area VARCHAR2(256) ,
   sortNum NUMBER(10 , 0) ,
   CONSTRAINT Region_PK PRIMARY KEY(id)
);
COMMENT ON COLUMN Region.id IS '主键';
COMMENT ON COLUMN Region.sCode IS '国际简码';
COMMENT ON COLUMN Region.lCode IS '国际代码';
COMMENT ON COLUMN Region.enName IS '英文名称';
COMMENT ON COLUMN Region.cnName IS '中文名称';
COMMENT ON COLUMN Region.area IS '区域(亚洲、非洲)';
COMMENT ON COLUMN Region.sortNum IS '排序号';
COMMENT ON TABLE Region IS '区域代码';

DROP TABLE SysParameter;
CREATE TABLE SysParameter
(
  id            NUMBER(18)                     NOT NULL,
  systemName    VARCHAR2(32)                   NOT NULL,
  parameterName VARCHAR2(32)                   NOT NULL,
  describe      VARCHAR2(128)                  NOT NULL,
  division      VARCHAR2(32)                   NOT NULL,
  type          VARCHAR2(32)                   NOT NULL,
  valueBound    VARCHAR2(128),
  value         VARCHAR2(128)                  NOT NULL,
  remark        VARCHAR2(128),
  createBy      NUMBER(18)                     NOT NULL,
  createDate    TIMESTAMP DEFAULT systimestamp NOT NULL,
  updateBy      NUMBER(18),
  updateDate    TIMESTAMP DEFAULT systimestamp NOT NULL,
  CONSTRAINT SysParameter_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN SysParameter.id IS '主键';
COMMENT ON COLUMN SysParameter.systemName IS '系统名称';
COMMENT ON COLUMN SysParameter.parameterName IS '参数名称';
COMMENT ON COLUMN SysParameter.describe IS '参数描述';
COMMENT ON COLUMN SysParameter.division IS '参数大类';
COMMENT ON COLUMN SysParameter.type IS '参数类型(文本、单选、多选)';
COMMENT ON COLUMN SysParameter.valueBound IS '参数值值域';
COMMENT ON COLUMN SysParameter.value IS ' 参数值';
COMMENT ON COLUMN SysParameter.remark IS '备注';
COMMENT ON COLUMN SysParameter.createBy IS '创建人';
COMMENT ON COLUMN SysParameter.createDate IS '创建时间';
COMMENT ON COLUMN SysParameter.updateBy IS '修改人';
COMMENT ON COLUMN SysParameter.updateDate IS '修改时间';
COMMENT ON TABLE SysParameter IS '系统参数表';