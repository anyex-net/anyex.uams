<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var accountBankManageDataGrid;
    $(function () {
        accountBankManageDataGrid = $('#accountBankManageDataGrid').datagrid({
            url: '${ctx}/account/accountBank/data',
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
            frozenColumns: [[
                {
                    width: '200',
                    title: '账户名',
                    field: 'accountName'
                }
            ]],
            columns: [[
                {
                    width: '200',
                    title: '开户银行',
                    field: 'bankDeposit',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                }, {
                    width: '200',
                    title: '手机号码',
                    field: 'mobilePhone'

                },{
                    width: '150',
                    title: '开户名',
                    field: 'bankAccountName'
                }, {
                    width: '200',
                    title: '开户银行地址',
                    field: 'bankAddress'
                }, {
                    width: '150',
                    title: '银行帐号',
                    field: 'bankAccountNumber'
                }, {
                    width: '100',
                    title: '联行号',
                    field: 'branchBankNo'
                }, {
                    width: '150',
                    title: '银行卡正面照',
                    field: 'frontSideBankCardPhoto'
                }, {
                    width: '100',
                    title: '银行卡背面照',
                    field: 'backSideBankCardPhoto'
                }, {
                    width: '200',
                    title: '省市',
                    field: 'province'
                }, {
                    width: '100',
                    title: '地市',
                    field: 'city'
                }, {
                    width: '100',
                    title: '县市',
                    field: 'district'
                }, {
                    width: '70',
                    title: '状态',
                    field: 'status',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                }, {
                    width: '70',
                    title: '备注',
                    field: 'remark'

                }, {
                    width: '150',
                    title: '创建时间',
                    field: 'createDate',
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
                }<shiro:hasPermission name="system:setting:accountAccountBank:operator">
                , {
                    field: 'action',
                    title: '操作',
                    width: 280,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editAccountBankManageFun(\'{0}\',\'{1}\');" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteAccountBankManageFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </shiro:hasPermission>
            ]],
            onLoadSuccess: function (data) {
                <shiro:hasPermission name="system:setting:accountAccountBank:operator">
                $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.role-easyui-linkbutton-del').linkbutton({text: '删除'});

                </shiro:hasPermission>
            },
            toolbar: '#accountBankManageToolbar'
        });

        $("#statusListTd").html(dictDropDownOptionsList('statusList','status', 'accountStatus','', 'required:true,',  'width:142px,'));
        $("#statusList").combobox({
            valueField:'code',
            textField:'name'
        });

        $("#bankDepositListTd").html(dictDropDownOptionsList('bankDepositList', 'bankDeposit', 'bankDeposit', '', 'required:true,', 'width:142px'));
        $("#bankDepositList").combobox({
            valueField: 'code',
            textField: 'name'
        });
    });

    function addAccountBankManageFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 600,
            height: 350,
            href: '${ctx}/account/accountBank/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = accountBankManageDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editAccountBankForm');
                    f.submit();
                }
            }],
        });
    }

    function editAccountBankManageFun(id, status) {
        if (id == undefined) {
            var rows = accountBankManageDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            accountBankManageDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 600,
            height: 350,
            href: '${ctx}/account/accountBank/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = accountBankManageDataGrid;
                    var f = parent.$.modalDialog.handler.find('#editAccountBankForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteAccountBankManageFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = accountBankManageDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            accountBankManageDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前账户银行数据吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/account/accountBank/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        accountBankManageDataGrid.datagrid('reload');
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

    function searchAccountBankManageFun() {
        accountBankManageDataGrid.datagrid('load', $.serializeObject($('#searchAccountBankManageForm')));
    }

    function cleanAccountBankManageFun() {
        $('#searchAccountBankManageForm input').val('');
        accountBankManageDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchAccountBankManageForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>账户</th>
                    <td><input name="accountName" placeholder="请输入账户" style="width:100px;"/></td>
                    <th>开户银行:</th>
                    <td id="bankDepositListTd"></td>
                    <th>银行帐号:</th>
                    <td><input name="bankAccountNumber" placeholder="请输入银行帐号" style="width:100px;"/></td>
                    <th>手机号码:</th>
                    <td><input name="mobilePhone" placeholder="请输入手机号码" style="width:100px;"/></td>
                    <th>状态:</th>
                    <td id="statusListTd"></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true"
                           onclick="searchAccountBankManageFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanAccountBankManageFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="accountBankManageDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>
<div id="accountBankManageToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:accountAccountBank:operator">
        <a onclick="addAccountBankManageFun();" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'fi-plus icon-green'">新增</a>
    </shiro:hasPermission>
</div>