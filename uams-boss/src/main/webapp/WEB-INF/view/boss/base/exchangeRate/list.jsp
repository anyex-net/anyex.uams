<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var exchangeRateDataGrid;
    $(function () {
        exchangeRateDataGrid = $('#exchangeRateDataGrid').datagrid({
            url: '${ctx}/base/exchangeRate/data',
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
                    width: '150',
                    title: '汇率日期',
                    field: 'exchangDate',
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).format("yyyy-MM-dd");//.toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
                }
            ]],
            columns: [[
                {
                    width: '150',
                    title: '源币种',
                    field: 'currencySource',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },{
                    width: '150',
                    title: '目标币种',
                    field: 'currencyTarget',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },{
                    width: '100',
                    title: '买入价',
                    field: 'buyPrice',
                    sortable: true
                }, {
                    width: '100',
                    title: '卖出价',
                    field: 'sellPrice',
                    sortable: true
                }, {
                    width: '100',
                    title: '中间价',
                    field: 'midPrice',
                    sortable: true
                },{
                    width: '100',
                    title: '最小单位',
                    field: 'unitAmount',
                    sortable: true
                }, {
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    hidden:true,
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
            }<shiro:hasPermission name="system:setting:baseexchangeRate:operator">
                , {
                    field: 'action',
                    title: '操作',
                    width: 200,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editExchangeRateFun(\'{0}\');" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteExchangeRateFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </shiro:hasPermission>
                ]],
            onLoadSuccess: function (data) {
                <shiro:hasPermission name="system:setting:baseexchangeRate:operator">
                $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.role-easyui-linkbutton-del').linkbutton({text: '删除'});
                </shiro:hasPermission>
            },
            toolbar: '#exchangeRateToolbar' 
        });

        $("#currencySourceListTd").html(dictDropDownOptionsList('currencySourceList', 'currencySource', 'currency', '${model.currencySource}', 'required:true,', 'width:142px'));
        $("#currencySourceList").combobox({
            valueField: 'code',
            textField: 'name'
        });

        $("#currencyTargetListTd").html(dictDropDownOptionsList('currencyTargetList', 'currencyTarget', 'currency', '${model.currencyTarget}', 'required:true,', 'width:142px'));
        $("#currencyTargetList").combobox({
            valueField: 'code',
            textField: 'name'
        });
    });

    function addExchangeRateFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 500,
            height: 300,
            href: '${ctx}/base/exchangeRate/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = exchangeRateDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editExchangeRateForm');
                    f.submit();
                }
            }]
        });
    }

    function editExchangeRateFun(id) {
        if (id == undefined) {
            var rows = exchangeRateDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            exchangeRateDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 500,
            height: 300,
            href: '${ctx}/base/exchangeRate/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = exchangeRateDataGrid;
                    var f = parent.$.modalDialog.handler.find('#editExchangeRateForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteExchangeRateFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = exchangeRateDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            exchangeRateDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前信息吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/base/exchangeRate/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        exchangeRateDataGrid.datagrid('reload');
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
    
    function searchExchangeRateFun() {
    	exchangeRateDataGrid.datagrid('load', $.serializeObject($('#searchExchangeRateForm')));
    }
    function cleanExchangeRateFun() {
        $('#searchExchangeRateForm input').val('');
        exchangeRateDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchExchangeRateForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>源币种</th>
                    <td id="currencySourceListTd">
                    </td>
                    <th>目标币种</th>
                    <td id="currencyTargetListTd">
                    </td>
                    <th>汇率日期</th>
                    <td>
                        <input id="exchangDateList"  name="date"  type="text" placeholder="请输入汇率日期" class="easyui-datebox"
                               data-options="" value=""  style="width:142px;">
                    </td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchExchangeRateFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanExchangeRateFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
	<div data-options="region:'center',border:true">
        <table id="exchangeRateDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>	
<div id="exchangeRateToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:baseexchangeRate:operator">
    <a onclick="addExchangeRateFun();" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    </shiro:hasPermission>
</div>
