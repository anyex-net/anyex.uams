DROP TABLE "MsgTemplate";
CREATE TABLE "MsgTemplate"(
  "id" NUMBER(20) NOT NULL ,
  "tplKey" VARCHAR2(64) NOT NULL ,
  "lang" VARCHAR2(8) ,
  "type" VARCHAR2(16) NOT NULL ,
  "title" VARCHAR2(256) NOT NULL ,
  "content" VARCHAR2(2000) NOT NULL ,
  "dest" VARCHAR2(256) ,
  "createBy" NUMBER(20) ,
  "createDate" NUMBER(13 , 0) ,
  "delFlag" NUMBER(1 , 0) DEFAULT 0 NOT NULL ,
  CONSTRAINT "sms_template_pk" PRIMARY KEY("id") ,
  CONSTRAINT "sms_template_casuniques" UNIQUE("lang" , "type" , "tplKey")
);
COMMENT ON COLUMN "MsgTemplate"."id" IS '主键';
COMMENT ON COLUMN "MsgTemplate"."tplKey" IS '模版KEY';
COMMENT ON COLUMN "MsgTemplate"."lang" IS '语言编码（en_US,zh_CN,zh_HK)';
COMMENT ON COLUMN "MsgTemplate"."type" IS '模版类型(email:邮件、sms:短信)';
COMMENT ON COLUMN "MsgTemplate"."title" IS '标题（邮件用）';
COMMENT ON COLUMN "MsgTemplate"."content" IS '模版内容';
COMMENT ON COLUMN "MsgTemplate"."dest" IS '描述';
COMMENT ON COLUMN "MsgTemplate"."createBy" IS '创建人';
COMMENT ON COLUMN "MsgTemplate"."createDate" IS '创建时间';
COMMENT ON COLUMN "MsgTemplate"."delFlag" IS '删除标识';
COMMENT ON TABLE "MsgTemplate" IS '消息模版';

DROP TABLE "MsgRecord";
CREATE TABLE "MsgRecord"(
  "id" NUMBER(20) NOT NULL ,
  "orgId" NUMBER(20) NOT NULL ,
  "type" VARCHAR2(10) NOT NULL ,
  "object" VARCHAR2(64) NOT NULL ,
  "content" clob NOT NULL ,
  "createDate" NUMBER(13 , 0) NOT NULL ,
  "status" NUMBER(1 , 0) NOT NULL ,
  CONSTRAINT "MsgRecord_PK" PRIMARY KEY("id")
);
COMMENT ON COLUMN "MsgRecord"."id" IS '主键';
COMMENT ON COLUMN "MsgRecord"."orgId" IS '机构ID';
COMMENT ON COLUMN "MsgRecord"."type" IS '消息类型(email:邮件、sms:短信)';
COMMENT ON COLUMN "MsgRecord"."object" IS ' 发送对象';
COMMENT ON COLUMN "MsgRecord"."content" IS '内容';
COMMENT ON COLUMN "MsgRecord"."createDate" IS '创建时间';
COMMENT ON COLUMN "MsgRecord". "status" IS '发送状态（0：成功，1：失败）';
COMMENT ON TABLE "MsgRecord" IS '消息发送记录';

DROP TABLE "Dictionary";
CREATE TABLE "Dictionary"(
  "id" NUMBER(20) NOT NULL ,
  "parentId" VARCHAR2(18) ,
  "code" VARCHAR2(64) NOT NULL ,
  "name" VARCHAR2(128) NOT NULL ,
  "lang" VARCHAR2(32) ,
  "dest" VARCHAR2(256) ,
  "sortNum" NUMBER(10 , 0) ,
  "active" NUMBER(1 , 0) NOT NULL ,
  "createBy" NUMBER(20) ,
  "createDate" TIMESTAMP DEFAULT systimestamp ,
  "delFlag" NUMBER(1 , 0) DEFAULT 0 NOT NULL ,
  CONSTRAINT "dictionary_pk" PRIMARY KEY("id") ,
  CONSTRAINT "dictionary_casuniques" UNIQUE("lang" , "code")
);
COMMENT ON COLUMN "Dictionary"."id" IS '主键';
COMMENT ON COLUMN "Dictionary"."parentId" IS '上级编码';
COMMENT ON COLUMN "Dictionary"."code" IS '编码';
COMMENT ON COLUMN "Dictionary"."name" IS '名称';
COMMENT ON COLUMN "Dictionary"."lang" IS '语言类型';
COMMENT ON COLUMN "Dictionary"."dest" IS '描述';
COMMENT ON COLUMN "Dictionary"."createBy" IS '创建人';
COMMENT ON COLUMN "Dictionary"."createDate" IS '创建时间';
COMMENT ON COLUMN "Dictionary"."active" IS '启用标识';
COMMENT ON COLUMN "Dictionary"."delFlag" IS '删除标识';
COMMENT ON COLUMN "Dictionary"."sortNum" IS '排序号';
COMMENT ON TABLE "Dictionary" IS '数据典';

DROP TABLE "Region";
CREATE TABLE "Region"(
  "id" NUMBER(20) NOT NULL ,
  "sCode" VARCHAR2(64) ,
  "lCode" VARCHAR2(64) ,
  "enName" VARCHAR2(128) ,
  "cnName" VARCHAR2(128) ,
  "area" VARCHAR2(256) ,
  "sortNum" NUMBER(10 , 0) ,
  CONSTRAINT "Region_PK" PRIMARY KEY("id")
);
COMMENT ON COLUMN "Region"."id" IS '主键';
COMMENT ON COLUMN "Region"."sCode" IS '国际简码';
COMMENT ON COLUMN "Region"."lCode" IS '国际代码';
COMMENT ON COLUMN "Region"."enName" IS '英文名称';
COMMENT ON COLUMN "Region"."cnName" IS '中文名称';
COMMENT ON COLUMN "Region"."area" IS '区域(亚洲、非洲)';
COMMENT ON COLUMN "Region"."sortNum" IS '排序号';
COMMENT ON TABLE "Region" IS '区域代码';

DROP TABLE "Organization";
CREATE TABLE "Organization"
(  "id" NUMBER(20) NOT NULL,
   "parentId" NUMBER(20),
   "pathInfo" VARCHAR2(3000),
   "orgCode" VARCHAR2(64) NOT NULL,
   "orgName" VARCHAR2(128) NOT NULL,
   "orgDest" VARCHAR2(256),
   "createBy" VARCHAR2(18),
   "createDate" NUMBER(13,0),
   "updateBy" VARCHAR2(18),
   "updateDate" NUMBER(13,0),
   "sortNum" NUMBER(10,0),
   "delFlag" NUMBER(1,0) DEFAULT 0,
  CONSTRAINT "organization_pk" PRIMARY KEY ("id")
);
COMMENT ON COLUMN "Organization"."id" IS '主键';
COMMENT ON COLUMN "Organization"."parentId" IS '上级编码';
COMMENT ON COLUMN "Organization"."pathInfo" IS '层级信息';
COMMENT ON COLUMN "Organization"."orgCode" IS '机构编码';
COMMENT ON COLUMN "Organization"."orgName" IS '机构名称';
COMMENT ON COLUMN "Organization"."createBy" IS '创建人';
COMMENT ON COLUMN "Organization"."createDate" IS '创建时间';
COMMENT ON COLUMN "Organization"."updateBy" IS '修改人';
COMMENT ON COLUMN "Organization"."updateDate" IS '修改时间';
COMMENT ON COLUMN "Organization"."delFlag" IS '删除标识';
COMMENT ON COLUMN "Organization"."orgDest" IS '机构描述';
COMMENT ON COLUMN "Organization"."parentId" IS '上级编号';
COMMENT ON COLUMN "Organization"."sortNum" IS '排序号';
COMMENT ON TABLE "Organization"  IS '机构信息';

DROP TABLE "Resources";
CREATE TABLE "Resources"
(  "id" NUMBER(20) NOT NULL,
   "parentId" NUMBER(20),
   "resCode" VARCHAR2(64) NOT NULL,
   "resName" VARCHAR2(128) NOT NULL,
   "resDest" VARCHAR2(256),
   "type" NUMBER(1,0) DEFAULT 0,
   "icon" VARCHAR2(64),
   "sortNum" NUMBER(10,0),
   "resUrl" VARCHAR2(128) NOT NULL,
   "createBy" NUMBER(20),
   "createDate" NUMBER(13,0),
   "updateBy" NUMBER(20),
   "updateDate" NUMBER(13,0),
   "delFlag" NUMBER(1,0) DEFAULT 0,
  CONSTRAINT "resources_pk" PRIMARY KEY ("id")
);
COMMENT ON COLUMN "Resources"."id" IS '主键';
COMMENT ON COLUMN "Resources"."parentId" IS ' 上级编号';
COMMENT ON COLUMN "Resources"."resCode" IS '资源编码';
COMMENT ON COLUMN "Resources"."resName" IS '资源名称';
COMMENT ON COLUMN "Resources"."resDest" IS '资源描述';
COMMENT ON COLUMN "Resources"."type" IS '类型（菜单、权限）';
COMMENT ON COLUMN "Resources"."icon" IS '图标';
COMMENT ON COLUMN "Resources"."sortNum" IS '排序号';
COMMENT ON COLUMN "Resources"."resUrl" IS '资源地址';
COMMENT ON COLUMN "Resources"."createBy" IS '创建人';
COMMENT ON COLUMN "Resources"."createDate" IS '创建时间';
COMMENT ON COLUMN "Resources"."updateBy" IS '修改人';
COMMENT ON COLUMN "Resources"."updateDate" IS '修改时间';
COMMENT ON COLUMN "Resources"."delFlag" IS '删除状态';
COMMENT ON TABLE "Resources"  IS '资源菜单信息';

DROP TABLE "RoleInfo";
CREATE TABLE "RoleInfo"
(  "id" NUMBER(20) NOT NULL,
   "orgId" NUMBER(20) NOT NULL,
   "roleCode" VARCHAR2(32) NOT NULL,
   "roleName" VARCHAR2(64) NOT NULL,
   "roleDest" VARCHAR2(256),
   "createBy" NUMBER(20),
   "createDate" NUMBER(13,0),
   "updateBy" NUMBER(20),
   "updateDate" NUMBER(13,0),
   "delFlag" NUMBER(1,0) DEFAULT 0,
  CONSTRAINT "role_info_pk" PRIMARY KEY ("id")
);
COMMENT ON COLUMN "RoleInfo"."id" IS '主键';
COMMENT ON COLUMN "RoleInfo"."orgId" IS '机构ID';
COMMENT ON COLUMN "RoleInfo"."roleCode" IS '角色编码';
COMMENT ON COLUMN "RoleInfo"."roleName" IS '角色名称';
COMMENT ON COLUMN "RoleInfo"."roleDest" IS '角色描述';
COMMENT ON COLUMN "RoleInfo"."createBy" IS '创建人';
COMMENT ON COLUMN "RoleInfo"."createDate" IS '创建时间';
COMMENT ON COLUMN "RoleInfo"."updateBy" IS '修改人';
COMMENT ON COLUMN "RoleInfo"."updateDate" IS '修改时间';
COMMENT ON COLUMN "RoleInfo"."delFlag" IS '删除标识';
COMMENT ON TABLE "RoleInfo"  IS '角色信息';

DROP TABLE "UserInfo" ;
CREATE TABLE "UserInfo"
(  "id" NUMBER(20) NOT NULL,
   "orgId" NUMBER(20) NOT NULL,
   "userName" VARCHAR2(32) NOT NULL,
   "trueName" VARCHAR2(64),
   "passWord" VARCHAR2(64) NOT NULL,
   "gender" NUMBER(1,0) DEFAULT 0,
   "active" NUMBER(1,0) DEFAULT 0,
   "idCard" VARCHAR2(18),
   "sign" VARCHAR2(50) NOT NULL,
   "randomKey" VARCHAR2(8) NOT NULL,
   "authKey" VARCHAR2(32),
   "userLogo" VARCHAR2(256),
   "userDest" VARCHAR2(256),
   "jobTitle" VARCHAR2(32),
   "address" VARCHAR2(16),
   "createDate" NUMBER(13,0),
   "updateDate" NUMBER(13,0),
   "delFlag" NUMBER(1,0) DEFAULT 0,
  CONSTRAINT "user_info_pk" PRIMARY KEY ("id")
);
COMMENT ON COLUMN "UserInfo"."id" IS '主键';
COMMENT ON COLUMN "UserInfo"."orgId" IS '机构ID';
COMMENT ON COLUMN "UserInfo"."userName" IS '用户名';
COMMENT ON COLUMN "UserInfo"."trueName" IS '真实姓名';
COMMENT ON COLUMN "UserInfo"."passWord" IS '密码';
COMMENT ON COLUMN "UserInfo"."gender" IS '性别';
COMMENT ON COLUMN "UserInfo"."active" IS '激活状态';
COMMENT ON COLUMN "UserInfo"."idCard" IS '身份证号';
COMMENT ON COLUMN "UserInfo"."sign" IS '签名';
COMMENT ON COLUMN "UserInfo"."randomKey" IS 'key';
COMMENT ON COLUMN "UserInfo"."authKey" IS 'google验证器私钥';
COMMENT ON COLUMN "UserInfo"."userLogo" IS '头像';
COMMENT ON COLUMN "UserInfo"."jobTitle" IS '职称';
COMMENT ON COLUMN "UserInfo"."address" IS '所在地址';
COMMENT ON COLUMN "UserInfo"."createDate" IS '创建时间';
COMMENT ON COLUMN "UserInfo"."updateDate" IS '修改时间';
COMMENT ON COLUMN "UserInfo"."userDest" IS '描述';
COMMENT ON COLUMN "UserInfo"."delFlag" IS '删除标记';
COMMENT ON TABLE "UserInfo"  IS '用户基础信息';

DROP TABLE "RoleRes";
CREATE TABLE "RoleRes"
(  "id" NUMBER(20) NOT NULL,
   "roleId" NUMBER(20) NOT NULL,
   "resId" NUMBER(20) NOT NULL,
  CONSTRAINT "role_res_pk" PRIMARY KEY ("id")
);
COMMENT ON COLUMN "RoleRes"."id" IS '主键';
COMMENT ON COLUMN "RoleRes"."roleId" IS '角色ID';
COMMENT ON COLUMN "RoleRes"."resId" IS '资源ID';
COMMENT ON TABLE "RoleRes"  IS '角色权限信息';

DROP TABLE "UserRole";
CREATE TABLE "UserRole"
(  "id" NUMBER(20) NOT NULL,
   "roleId" NUMBER(20) NOT NULL,
   "userId" NUMBER(20) NOT NULL,
  CONSTRAINT "user_role_pk" PRIMARY KEY ("id")
);
COMMENT ON COLUMN "UserRole"."id" IS '主键';
COMMENT ON COLUMN "UserRole"."roleId" IS '角色ID';
COMMENT ON COLUMN "UserRole"."userId" IS '用户ID';
COMMENT ON TABLE "UserRole"  IS '用户角色权限';

DROP TABLE "UserData";
CREATE TABLE "UserData"
(  "id" NUMBER(20) NOT NULL,
   "userId" NUMBER(20) NOT NULL,
   "orgId" NUMBER(20) NOT NULL,
  CONSTRAINT "user_data_pk" PRIMARY KEY ("id")
);
COMMENT ON COLUMN "UserData"."id" IS '主键';
COMMENT ON COLUMN "UserData"."userId" IS '用户ID';
COMMENT ON COLUMN "UserData"."orgId" IS '机构ID';
COMMENT ON TABLE "UserData"  IS '数据权限信息';

