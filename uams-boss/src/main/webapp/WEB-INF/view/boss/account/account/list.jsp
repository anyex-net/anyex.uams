<%@ page import="com.uams.rpc.account.consts.AccountConsts" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var accountManageDataGrid;
    $(function () {
        accountManageDataGrid = $('#accountManageDataGrid').datagrid({
            url: '${ctx}/account/account/data',
            fit: true,
            striped: true,
            rownumbers: true,
            pagination: true,
            singleSelect: true,
            idField: 'id',
            sortName: 'id',
            sortOrder: 'asc',
            pageSize: 20,
            pageList: [10, 20, 30, 40, 50, 100],
            frozenColumns:[[
                {
                    width: '80',
                    title: '用户编号',
                    field: 'unid',
                    sortable: true
                }

             ]],
            columns: [[
                {
                    width: '200',
                    title: '账户名',
                    field: 'accountName',
                    sortable: true
                },{
                    width: '100',
                    title: '账户类型',
                    field: 'accountType',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },{
                    width: '100',
                    title: '证件类型',
                    field: 'certificateType',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },{
                    width: '150',
                    title: '证件号码',
                    field: 'certificateNumber'
                },{
                    width: '70',
                    title: '出生年月',
                    field: 'dateBirth'
                },{
                    width: '100',
                    title: '联系电话',
                    field: 'contactNumber'
                },{
                    width: '100',
                    title: '手机号',
                    field: 'mobilePhone'
                },{
                    width: '150',
                    title: '电子邮箱',
                    field: 'email'
                },{
                    width: '100',
                    title: '邮政编码',
                    field: 'postCode'
                },{
                    width: '200',
                    title: '联系地址',
                    field: 'contactAddress'
                },{
                    width: '100',
                    title: '风险等级',
                    field: 'riskLevel',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },{
                    width: '100',
                    title: '国家地区',
                    field: 'country',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },{
                    width: '100',
                    title: '省',
                    field: 'province'
                },{
                    width: '100',
                    title: '市',
                    field: 'city'
                },{
                    width: '100',
                    title: '区县',
                    field: 'district'
                },{
                    width: '150',
                    title: '开户时间',
                    field: 'openAccountTime',
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
                },{
                    width: '150',
                    title: '销户时间',
                    field: 'closeAccountTime',
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
                },{
                    width: '100',
                    title: '企业营业执照代码',
                    field: 'companyLicenseCode'
                },{
                    width: '100',
                    title: '经办人姓名',
                    field: 'operatorName'
                },{
                    width: '100',
                    title: '经办人证件类型',
                    field: 'operatorCertificateType',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },{
                    width: '100',
                    title: '经办人证件号码',
                    field: 'operatorCertificateNumber'
                },{
                    width: '100',
                    title: '经办人联系电话',
                    field: 'operatorContactNumber'
                },{
                    width: '100',
                    title: '经办人手机号码',
                    field: 'operatorMobilePhone'
                },{
                    width: '100',
                    title: '经纪人',
                    field: 'salesBrokerName'
                },{
                    width: '100',
                    title: '所属机构',
                    field: 'belongOrgName'
                },{
                    width: '100',
                    title: '账户状态',
                    field: 'accountStatus',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },{
                    width: '150',
                    title: '创建时间',
                    field: 'createDate',
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
            },{
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
                }<shiro:hasPermission name="system:setting:accountAccount:operator">
                , {
                    field: 'action',
                    title: '操作',
                    width: 280,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="user-easyui-linkbutton-mima" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="initLoginPassFun(\'{0}\');" >重置密码</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editAccountManageFun(\'{0}\',\'{1}\');" >编辑</a>', row.id, row.accountStatus);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        if( row.accountStatus == '<%=AccountConsts.ACCOUNT_STATUS_NORMAL%>'){
                            str += $.formatString('<a href="javascript:void(0)" id="status_1" class="user-easyui-linkbutton-dongjie" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editAccountFun(\'{0}\',\'{1}\');" >冻结</a>', row.id,row.accountStatus);
                        }
                        if( row.accountStatus  == '<%=AccountConsts.ACCOUNT_STATUS_FROZEN%>'){
                            str += $.formatString('<a href="javascript:void(0)" id="status_0" class="user-easyui-linkbutton-jiedong" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="editAccountFun(\'{0}\',\'{1}\');" >解冻</a>', row.id,row.accountStatus);
                        }
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteAccountManageFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </shiro:hasPermission>
                ]],
            onLoadSuccess: function (data) {
                <shiro:hasPermission name="system:setting:accountAccount:operator">
                $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.role-easyui-linkbutton-del').linkbutton({text: '注销'});
                $('.user-easyui-linkbutton-dongjie').linkbutton({text: '冻结'});
                $('.user-easyui-linkbutton-jiedong').linkbutton({text: '解冻'});
                $('.user-easyui-linkbutton-mima').linkbutton({text: '重置密码'});
                </shiro:hasPermission>
            },
            toolbar: '#accountManageToolbar'
        });
        $("#accountStatusListTd").html(dictDropDownOptionsList('accountStatusList','accountStatus', 'accountStatus','', '',  'width:142px,'));
        $("#accountStatusList").combobox({
            valueField:'code',
            textField:'name'
        });

    });
    //冻结或解冻用户
    function editAccountFun(id,status) {
        alert(status);
        var url='${ctx}/account/account/pass';
        var msg="你是否要解冻当前账户吗?";
        if(status == '<%=AccountConsts.ACCOUNT_STATUS_NORMAL%>'){
            url='${ctx}/account/account/nopass';
            msg="你是否要冻结当前账户吗?";
        }

        parent.$.messager.confirm('询问', msg, function (b) {
            if (b) {
                progressLoad();
                $.post(url, {
                    id: id
                }, function (result) {
                    progressClose();
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        accountManageDataGrid.datagrid('load', $.serializeObject($('#searchAccountForm')));
                    }else{
                        parent.$.messager.alert('提示', result.message, 'info');
                    }
                    $('#csrf-form').find('input[name="csrf"]').val(result.csrf);
                    setCsrfToken("csrf-form");
                }, 'JSON');
            }
        });

    }
    function addAccountManageFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 1000,
            height: 480,
            href: '${ctx}/account/account/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = accountManageDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editAccountManageForm');
                    f.submit();
                }
            }],
        });
    }
    function editAccountManageFun(id,status) {
        if (id == undefined) {
            var rows = accountManageDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            accountManageDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 1000,
            height: 480,
            href: '${ctx}/account/account/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = accountManageDataGrid;
                    var f = parent.$.modalDialog.handler.find('#editAccountManageForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteAccountManageFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = accountManageDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            accountManageDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要注销当前数据吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/account/account/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        accountManageDataGrid.datagrid('reload');
                    }else{
                        parent.$.messager.alert('错误', result.message, 'error');
                    }
                    $('#csrf-form').find('input[name="csrf"]').val(result.csrf);
                    setCsrfToken("csrf-form");
                    progressClose();
                }, 'JSON');
            }
        });
    }

    function initLoginPassFun(id) {
        parent.$.messager.confirm('询问', '您是否要初始化当前用户密码吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/account/account/initLoginPass', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        accountManageDataGrid.datagrid('reload');
                    }else{
                        parent.$.messager.alert('错误', result.message, 'error');
                    }
                    $('#csrf-form').find('input[name="csrf"]').val(result.csrf);
                    setCsrfToken("csrf-form");
                    progressClose();
                }, 'JSON');
            }
        });
    }
    
    function searchAccountManageFun() {
    	accountManageDataGrid.datagrid('load', $.serializeObject($('#searchAccountManageForm')));
    }
    function cleanAccountManageFun() {
        $('#searchAccountManageForm input').val('');
        accountManageDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 60px; overflow: hidden;background-color: #fff">
        <form id="searchAccountManageForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                	<th>用户编号:</th>
                    <td><input name="unid" placeholder="请输入用户编号" style="width:100px;"/></td>
                    <th>账户名:</th>
                    <td><input name="accountName" placeholder="请输入账户名" style="width:100px;"/></td>
                    <th>开户名:</th>
                    <td><input name="bankAccountName" placeholder="请输入开户名" style="width:100px;"/></td>

                </tr>
                <tr>
                    <th>企业营业执照代码:</th>
                    <td><input name="companyLicenseCode" placeholder="请输入企业营业执照代码" style="width:100px;"/></td>
                    <th>经办人姓名:</th>
                    <td><input name="operatorName" placeholder="请输入经办人姓名" style="width:100px;"/></td>
                    <th>账户状态:</th>
                    <td id="accountStatusListTd"></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchAccountManageFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanAccountManageFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
	<div data-options="region:'center',border:true">
     	<table id="accountManageDataGrid"  data-options="fit:true,border:false"></table>
    </div>
</div>	
<div id="accountManageToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:accountAccount:operator">
    <a onclick="addAccountManageFun();" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'fi-plus icon-green'">开户</a>
    </shiro:hasPermission>
</div>