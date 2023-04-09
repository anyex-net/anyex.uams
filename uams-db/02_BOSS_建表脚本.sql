DROP TABLE Organization;
CREATE TABLE Organization 
(  id NUMBER(20) NOT NULL, 
   parentId NUMBER(20),
   pathInfo VARCHAR2(4000),
   orgCode VARCHAR2(64) NOT NULL, 
   orgName VARCHAR2(128) NOT NULL, 
   orgDest VARCHAR2(256), 
   createBy VARCHAR2(18), 
   createDate NUMBER(13,0), 
   updateBy VARCHAR2(18), 
   updateDate NUMBER(13,0), 
   sortNum NUMBER(10,0), 
   delFlag NUMBER(1,0) DEFAULT 0, 
   CONSTRAINT organization_pk PRIMARY KEY (id)
 );
COMMENT ON COLUMN Organization.id IS '主键';
COMMENT ON COLUMN Organization.parentId IS '上级编码';
COMMENT ON COLUMN Organization.pathInfo IS '层级信息';
COMMENT ON COLUMN Organization.orgCode IS '机构编码';
COMMENT ON COLUMN Organization.orgName IS '机构名称';
COMMENT ON COLUMN Organization.createBy IS '创建人';
COMMENT ON COLUMN Organization.createDate IS '创建时间';
COMMENT ON COLUMN Organization.updateBy IS '修改人';
COMMENT ON COLUMN Organization.updateDate IS '修改时间';
COMMENT ON COLUMN Organization.delFlag IS '删除标识';
COMMENT ON COLUMN Organization.orgDest IS '机构描述';
COMMENT ON COLUMN Organization.parentId IS '上级编号';
COMMENT ON COLUMN Organization.sortNum IS '排序号';
COMMENT ON TABLE Organization  IS '机构信息';

DROP TABLE Resources;
CREATE TABLE Resources 
(  id NUMBER(20) NOT NULL, 
   parentId NUMBER(20), 
   resCode VARCHAR2(64) NOT NULL, 
   resName VARCHAR2(128) NOT NULL, 
   resDest VARCHAR2(256), 
   type NUMBER(1,0) DEFAULT 0, 
   icon VARCHAR2(64), 
   sortNum NUMBER(10,0), 
   resUrl VARCHAR2(128) NOT NULL, 
   createBy NUMBER(20), 
   createDate NUMBER(13,0), 
   updateBy NUMBER(20), 
   updateDate NUMBER(13,0), 
   delFlag NUMBER(1,0) DEFAULT 0, 
   CONSTRAINT resources_pk PRIMARY KEY (id)
 );
COMMENT ON COLUMN Resources.id IS '主键';
COMMENT ON COLUMN Resources.parentId IS '上级编号';
COMMENT ON COLUMN Resources.resCode IS '资源编码';
COMMENT ON COLUMN Resources.resName IS '资源名称';
COMMENT ON COLUMN Resources.resDest IS '资源描述';
COMMENT ON COLUMN Resources.type IS '类型（菜单、权限）';
COMMENT ON COLUMN Resources.icon IS '图标';
COMMENT ON COLUMN Resources.sortNum IS '排序号';
COMMENT ON COLUMN Resources.resUrl IS '资源地址';
COMMENT ON COLUMN Resources.createBy IS '创建人';
COMMENT ON COLUMN Resources.createDate IS '创建时间';
COMMENT ON COLUMN Resources.updateBy IS '修改人';
COMMENT ON COLUMN Resources.updateDate IS '修改时间';
COMMENT ON COLUMN Resources.delFlag IS '删除状态';
COMMENT ON TABLE Resources  IS '资源菜单信息';

DROP TABLE RoleInfo;
CREATE TABLE RoleInfo 
(  id NUMBER(20) NOT NULL, 
   orgId NUMBER(20) NOT NULL, 
   roleCode VARCHAR2(32) NOT NULL, 
   roleName VARCHAR2(64) NOT NULL, 
   roleDest VARCHAR2(256), 
   createBy NUMBER(20), 
   createDate NUMBER(13,0), 
   updateBy NUMBER(20), 
   updateDate NUMBER(13,0), 
  needGa NUMBER(1,0) DEFAULT 0,  
   delFlag NUMBER(1,0) DEFAULT 0, 
   CONSTRAINT role_info_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN RoleInfo.id IS '主键';
COMMENT ON COLUMN RoleInfo.orgId IS '机构ID';
COMMENT ON COLUMN RoleInfo.roleCode IS '角色编码';
COMMENT ON COLUMN RoleInfo.roleName IS '角色名称';
COMMENT ON COLUMN RoleInfo.roleDest IS '角色描述';
COMMENT ON COLUMN RoleInfo.createBy IS '创建人';
COMMENT ON COLUMN RoleInfo.createDate IS '创建时间';
COMMENT ON COLUMN RoleInfo.updateBy IS '修改人';
COMMENT ON COLUMN RoleInfo.updateDate IS '修改时间';
COMMENT ON COLUMN RoleInfo.needGa IS '需要GA验证 1需要 0不需要';
COMMENT ON COLUMN RoleInfo.delFlag IS '删除标识'; 
COMMENT ON TABLE RoleInfo  IS '角色信息';

DROP TABLE UserInfo;
CREATE TABLE UserInfo 
(  id NUMBER(20) NOT NULL, 
   orgId NUMBER(20) NOT NULL, 
   userName VARCHAR2(32) NOT NULL, 
   trueName VARCHAR2(64), 
   passWord VARCHAR2(64) NOT NULL, 
   gender NUMBER(1,0) DEFAULT 0, 
   active NUMBER(1,0) DEFAULT 0, 
   idCard VARCHAR2(18), 
   sign VARCHAR2(50) NOT NULL, 
   randomKey VARCHAR2(8) NOT NULL, 
   authKey VARCHAR2(32), 
   userLogo VARCHAR2(256), 
   userDest VARCHAR2(256), 
   jobTitle VARCHAR2(32), 
   address VARCHAR2(16), 
   createDate NUMBER(13,0), 
   updateDate NUMBER(13,0), 
   delFlag NUMBER(1,0) DEFAULT 0, 
   CONSTRAINT user_info_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN UserInfo.id IS '主键';
COMMENT ON COLUMN UserInfo.orgId IS '机构ID';
COMMENT ON COLUMN UserInfo.userName IS '用户名';
COMMENT ON COLUMN UserInfo.trueName IS '真实姓名';
COMMENT ON COLUMN UserInfo.passWord IS '密码';
COMMENT ON COLUMN UserInfo.gender IS '性别';
COMMENT ON COLUMN UserInfo.active IS '激活状态';
COMMENT ON COLUMN UserInfo.idCard IS '身份证号';
COMMENT ON COLUMN UserInfo.sign IS '签名';
COMMENT ON COLUMN UserInfo.randomKey IS 'key';
COMMENT ON COLUMN UserInfo.authKey IS 'google验证器私钥';
COMMENT ON COLUMN UserInfo.userLogo IS '头像';
COMMENT ON COLUMN UserInfo.jobTitle IS '职称';
COMMENT ON COLUMN UserInfo.address IS '所在地址';
COMMENT ON COLUMN UserInfo.createDate IS '创建时间';
COMMENT ON COLUMN UserInfo.updateDate IS '修改时间';
COMMENT ON COLUMN UserInfo.userDest IS '描述';
COMMENT ON COLUMN UserInfo.delFlag IS '删除标记';
COMMENT ON TABLE UserInfo  IS '用户基础信息';

DROP TABLE RoleRes;
CREATE TABLE RoleRes 
(  id NUMBER(20) NOT NULL, 
   roleId NUMBER(20) NOT NULL, 
   resId NUMBER(20) NOT NULL,
   CONSTRAINT role_res_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN RoleRes.id IS '主键';
COMMENT ON COLUMN RoleRes.roleId IS '角色ID';
COMMENT ON COLUMN RoleRes.resId IS '资源ID';
COMMENT ON TABLE RoleRes  IS '角色权限信息';

DROP TABLE UserRole;
CREATE TABLE UserRole 
(  id NUMBER(20) NOT NULL, 
   roleId NUMBER(20) NOT NULL, 
   userId NUMBER(20) NOT NULL, 
   CONSTRAINT user_role_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN UserRole.id IS '主键';
COMMENT ON COLUMN UserRole.roleId IS '角色ID';
COMMENT ON COLUMN UserRole.userId IS '用户ID';
COMMENT ON TABLE UserRole  IS '用户角色权限';

DROP TABLE UserData;
CREATE TABLE UserData
(  id NUMBER(20) NOT NULL,
   userId NUMBER(20) NOT NULL,
   orgId NUMBER(20) NOT NULL,
   CONSTRAINT user_data_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN UserData.id IS '主键';
COMMENT ON COLUMN UserData.userId IS '用户ID';
COMMENT ON COLUMN UserData.orgId IS '机构ID';
COMMENT ON TABLE UserData  IS '数据权限信息';