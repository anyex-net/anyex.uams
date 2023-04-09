<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var accountFundAdjustDataGrid;
    $(function () {
        accountFundAdjustDataGrid = $('#accountFundAdjustDataGrid').datagrid({
            url: '${ctx}/fund/accountFundAdjust/data',
            striped: true,
            rownumbers: true,
            pagination: true,
            singleSelect: true,
            idField: 'id',
            sortName: 'id',
            sortOrder: 'asc',
            pageSize: 20,
            pageList: [10, 20, 30, 40, 50, 100],
            columns:[[
                {
                    width: '100',
                    title: '账户名',
                    field: 'accountName',
                    sortable: true
                },{
                    width: '100',
                    title: '币种',
                    field: 'currency',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },{
                    width: '100',
                    title: '调整类型',
                    field: 'adjustType',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },{
                    width: '100',
                    title: '调整金额数量',
                    field: 'adjustAmt'
                },{
                    width: '100',
                    title: '创建人',
                    field: 'createBy'
                },{
                    width: '200',
                    title: '创建时间',
                    field: 'createDate',
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
                },{
                    width: '100',
                    title: '备注',
                    field: 'remark'
                }
            ]],

            toolbar: '#accountFundAdjustManageToolbar'
        });

        $("#currencyListTd").html(dictDropDownOptionsList('currencyList','currency', 'currency','', 'required:true,',  'width:142px,'));
        $("#currencyList").combobox({
            valueField:'code',
            textField:'name'
        });
        $("#adjustTypeListTd").html(dictDropDownOptionsList('adjustTypeList','adjustType', 'adjustType','', 'required:true,',  'width:142px,'));
        $("#adjustTypeList").combobox({
            valueField:'code',
            textField:'name'
        });
    });

    function addAccountFundAdjustManageFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 480,
            height: 300,
            href: '${ctx}/fund/accountFundAdjust/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = accountFundAdjustDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editAccountFundAdjustForm');
                    f.submit();
                }
            }],
        });
    }

    function searchAccountFundAdjustFun() {
        accountFundAdjustDataGrid.datagrid('load', $.serializeObject($('#searchAccountFundAdjustForm')));
    }
    function cleanAccountFundAdjustFun() {
        $('#searchAccountFundAdjustForm input').val('');
        accountFundAdjustDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchAccountFundAdjustForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>账户</th>
                    <td><input name="accountName" placeholder="请输入账户" style="width:100px;"/></td>

                    <th>币种:</th>
                    <td id="currencyListTd"></td>
                    <th>调整类型:</th>
                    <td id="adjustTypeListTd">
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchAccountFundAdjustFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanAccountFundAdjustFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="accountFundAdjustDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

<div id="accountFundAdjustManageToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:fundAccountFundAdjust:operator">
        <a onclick="addAccountFundAdjustManageFun();" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'fi-plus icon-green'">新增</a>
    </shiro:hasPermission>
</div>

