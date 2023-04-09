<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var marketInfoDataGrid;
    $(function () {
        marketInfoDataGrid = $('#marketInfoDataGrid').datagrid({
            url: '${ctx}/base/marketInfo/data',
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
                    width: '100',
                    title: '交易市场编码',
                    field: 'marketCode',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '200',
                    title: '交易市场简称',
                    field: 'marketName',
                    sortable: true
                }, {
                    width: '200',
                    title: '交易市场全称',
                    field: 'marketFullName',
                    sortable: true
                },{
                    width: '100',
                    title: '市场代码',
                    field: 'exchangeCode',
                    sortable: true
                },{
                    width: '70',
                    title: '国家或地区',
                    field: 'countryNo',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
            },{
                    width: '70',
                    title: '停市标志',
                    field: 'isStop',
                    formatter: function (value, row, index) {
                        if(value == true) value='1';
                        if(value == false) value='0';
                        return getDictValueByCode(value);
                    }
                }, {
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    hidden:true,
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
            }<shiro:hasPermission name="system:setting:basemarketInfo:operator">
                , {
                    field: 'action',
                    title: '操作',
                    width: 200,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editMarketInfoFun(\'{0}\');" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteMarketInfoFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </shiro:hasPermission>
                ]],
            onLoadSuccess: function (data) {
                <shiro:hasPermission name="system:setting:basemarketInfo:operator">
                $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.role-easyui-linkbutton-del').linkbutton({text: '删除'});
                </shiro:hasPermission>
            },
            toolbar: '#marketInfoToolbar' 
        });
        $("#countryNoListTd").html(dictDropDownOptionsList('countryNoList', 'countryNo', 'region', '', 'required:true,', 'width:142px'));
        $("#countryNoList").combobox({
            valueField: 'code',
            textField: 'name'
        });
    });

    function addMarketInfoFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 500,
            height: 300,
            href: '${ctx}/base/marketInfo/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = marketInfoDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editMarketInfoForm');
                    f.submit();
                }
            }]
        });
    }

    function editMarketInfoFun(id) {
        if (id == undefined) {
            var rows = marketInfoDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            marketInfoDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 500,
            height: 300,
            href: '${ctx}/base/marketInfo/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = marketInfoDataGrid;
                    var f = parent.$.modalDialog.handler.find('#editMarketInfoForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteMarketInfoFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = marketInfoDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            marketInfoDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前交易市场信息吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/base/marketInfo/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        marketInfoDataGrid.datagrid('reload');
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
    
    function searchMarketInfoFun() {
    	marketInfoDataGrid.datagrid('load', $.serializeObject($('#searchMarketInfoForm')));
    }
    function cleanMarketInfoFun() {
        $('#searchMarketInfoForm input').val('');
        marketInfoDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchMarketInfoForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
            <tr>
                    <th>交易市场编码:</th>
                    <td><input name="marketCode" placeholder="请输入交易市场编码"/></td>
                    <th>交易市场简称:</th>
                    <td><input name="marketName" placeholder="请输入交易市场简称"/></td>
                    <th>国家或地区:</th>
                    <td id="countryNoListTd">
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchMarketInfoFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanMarketInfoFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
	<div data-options="region:'center',border:true">
        <table id="marketInfoDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>	
<div id="marketInfoToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:basemarketInfo:operator">
    <a onclick="addMarketInfoFun();" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    </shiro:hasPermission>
</div>