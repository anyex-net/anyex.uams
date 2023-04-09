--账户表
DROP TABLE account;
CREATE TABLE account
(
  id             			NUMBER(20)             NOT NULL,
  unid           			NUMBER(20)             NOT NULL,
  accountType    			VARCHAR2(16)           NOT NULL,
  accountName    			VARCHAR2(64)           NOT NULL,
  certificateType   		VARCHAR2(16)           NOT NULL,
  certificateNumber 		VARCHAR2(16)           NOT NULL,
  dateBirth					NUMBER(8)              NOT NULL,
  contactNumber             VARCHAR2(16)           NOT NULL,
  mobilePhone               VARCHAR2(16)           NOT NULL,
  email          			VARCHAR2(32)           NOT NULL,
  postCode                  VARCHAR2(16)           NOT NULL,
  contactAddress            VARCHAR2(128)          NOT NULL,
  frontSideIDPhoto          VARCHAR2(128)          NOT NULL,
  backSideIDPhoto           VARCHAR2(128)          NOT NULL,
  handWithIDPhoto           VARCHAR2(128)          NOT NULL,
  riskLevel                 VARCHAR2(16)           NOT NULL,
  lang           			VARCHAR2(16)           NOT NULL,
  country        			VARCHAR2(32)           NOT NULL,
  province					VARCHAR2(32)           NOT NULL,
  city						VARCHAR2(32)           NOT NULL,
  district					VARCHAR2(32)           NOT NULL,
  openAccountTime			DATE				   NOT NULL,
  closeAccountTime			DATE,
  loginPwd       			VARCHAR2(64)           NOT NULL,
  fundPwd      				VARCHAR2(64),
  companyLicenseCode        VARCHAR2(64),
  companyLicensePhoto       VARCHAR2(128),
  operatorName              VARCHAR2(32),
  operatorCertificateType   VARCHAR2(16),
  operatorCertificateNumber VARCHAR2(16),
  operatorFrontSideIDPhoto  VARCHAR2(128),
  operatorBackSideIDPhoto   VARCHAR2(128),
  operatorContactNumber     VARCHAR2(16),
  operatorMobilePhone       VARCHAR2(16),
  salesBrokerId             NUMBER(20)             NOT NULL,
  belongOrgId               NUMBER(20)             NOT NULL,
  accountStatus         	VARCHAR2(32)           NOT NULL,
  remark         			VARCHAR2(64),
  createDate     			DATE                   NOT NULL,
  updateDate     			DATE,
  CONSTRAINT account_PK PRIMARY KEY (id),
  CONSTRAINT account_Uniques_unid UNIQUE (unid),
  CONSTRAINT account_Uniques_accountName UNIQUE (accountName)
);
COMMENT ON COLUMN account.id IS '主键';
COMMENT ON COLUMN account.unid IS '用户编号';
COMMENT ON COLUMN account.accountType IS '账户类型(数据字典)';
COMMENT ON COLUMN account.accountName IS '账户名(个人或者法人姓名)';
COMMENT ON COLUMN account.certificateType IS '证件类型(数据字典)';
COMMENT ON COLUMN account.certificateNumber IS '证件号码';
COMMENT ON COLUMN account.dateBirth IS '出生年月';
COMMENT ON COLUMN account.contactNumber IS '联系电话';
COMMENT ON COLUMN account.mobilePhone IS '手机号';
COMMENT ON COLUMN account.email IS '电子邮箱';
COMMENT ON COLUMN account.postCode IS '邮政编码';
COMMENT ON COLUMN account.contactAddress IS '联系地址';
COMMENT ON COLUMN account.frontSideIDPhoto IS '证件正面照';
COMMENT ON COLUMN account.backSideIDPhoto IS '证件背面照';
COMMENT ON COLUMN account.handWithIDPhoto IS '手持证件照';
COMMENT ON COLUMN account.riskLevel IS '风险等级(数据字典)';
COMMENT ON COLUMN account.lang IS '语言(数据字典)';
COMMENT ON COLUMN account.country IS '国家地区(数据字典)';
COMMENT ON COLUMN account.province IS '省市';
COMMENT ON COLUMN account.city IS '地市';
COMMENT ON COLUMN account.district IS '县市';
COMMENT ON COLUMN account.openAccountTime IS '开户时间';
COMMENT ON COLUMN account.closeAccountTime IS '销户时间';
COMMENT ON COLUMN account.loginPwd IS '登录密码';
COMMENT ON COLUMN account.fundPwd IS '资金密码';
COMMENT ON COLUMN account.companyLicenseCode IS '企业营业执照代码';
COMMENT ON COLUMN account.companyLicensePhoto IS '企业营业执照照片';
COMMENT ON COLUMN account.operatorName IS '经办人姓名';
COMMENT ON COLUMN account.operatorCertificateType IS '经办人证件类型(数据字典)';
COMMENT ON COLUMN account.operatorCertificateNumber IS '经办人证件号码';
COMMENT ON COLUMN account.operatorFrontSideIDPhoto IS '经办人证件正面照';
COMMENT ON COLUMN account.operatorBackSideIDPhoto IS '经办人证件背面照';
COMMENT ON COLUMN account.operatorContactNumber IS '经办人联系电话';
COMMENT ON COLUMN account.operatorMobilePhone IS '经办人手机号码';
COMMENT ON COLUMN account.salesBrokerId IS '经纪人ID(userinfo用户表ID)';
COMMENT ON COLUMN account.belongOrgId IS '所属机构ID';
COMMENT ON COLUMN account.accountStatus IS '账户状态(数据字典:正常、冻结、注销)';
COMMENT ON COLUMN account.remark IS '语言标识';
COMMENT ON COLUMN account.createDate IS '创建时间';
COMMENT ON COLUMN account.updateDate IS '修改时间';
COMMENT ON TABLE account IS '账户表';

--账户银行表
DROP TABLE accountBank;
CREATE TABLE accountBank
(
  id           				NUMBER(20)             NOT NULL,
  accountId    				NUMBER(20)             NOT NULL,
  bankDeposit               VARCHAR2(32)           NOT NULL,
  bankAccountName           VARCHAR2(16)           NOT NULL,
  bankAddress               VARCHAR2(64)           NOT NULL,
  bankAccountNumber         VARCHAR2(16)           NOT NULL,
  branchBankNo              VARCHAR2(12),
  frontSideBankCardPhoto    VARCHAR2(128)          NOT NULL,
  backSideBankCardPhoto     VARCHAR2(128)          NOT NULL,
  province					VARCHAR2(32)           NOT NULL,
  city						VARCHAR2(32)           NOT NULL,
  district					VARCHAR2(32)           NOT NULL,
  mobilePhone               VARCHAR2(16)           NOT NULL,
  status         			VARCHAR2(32)           NOT NULL,
  remark       				VARCHAR2(256),
  createDate   				DATE DEFAULT sysdate NOT NULL,
  CONSTRAINT accountBank_pk PRIMARY KEY (id),
  CONSTRAINT accountBank_uniques UNIQUE (accountId, bankDeposit)
);
COMMENT ON COLUMN accountBank.id IS '主键';
COMMENT ON COLUMN accountBank.accountId IS '账户ID';
COMMENT ON COLUMN accountBank.bankDeposit IS '开户银行(数据字典)';
COMMENT ON COLUMN accountBank.bankAccountName IS '开户名';
COMMENT ON COLUMN accountBank.bankAddress IS '开户银行地址';
COMMENT ON COLUMN accountBank.bankAccountNumber IS '银行帐号';
COMMENT ON COLUMN accountBank.branchBankNo IS '联行号';
COMMENT ON COLUMN accountBank.frontSideBankCardPhoto IS '银行卡正面照';
COMMENT ON COLUMN accountBank.backSideBankCardPhoto IS '银行卡背面照';
COMMENT ON COLUMN accountBank.province IS '省市';
COMMENT ON COLUMN accountBank.city IS '地市';
COMMENT ON COLUMN accountBank.district IS '县市';
COMMENT ON COLUMN accountBank.mobilePhone IS '手机号码';
COMMENT ON COLUMN accountBank.status IS '状态';
COMMENT ON COLUMN accountBank.remark IS '备注';
COMMENT ON COLUMN accountBank.createDate IS '创建时间';
COMMENT ON TABLE accountBank IS '账户银行表';

--账户日志表
