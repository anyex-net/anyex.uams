<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var stockInfoDataGrid;
    $(function () {
        stockInfoDataGrid = $('#stockInfoDataGrid').datagrid({
            url: '${ctx}/base/stockInfo/data',
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
                    width: '100',
                    title: '交易市场',
                    field: 'marketName'
                }
            ]],
            columns: [[
                {
                    width: '100',
                    title: '证券内码',
                    field: 'interCode',
                    sortable: true
                }, {
                    width: '100',
                    title: '证券代码',
                    field: 'stockCode',
                    sortable: true
                }, {
                    width: '140',
                    title: '证券简称',
                    field: 'stockName',
                    sortable: true
                },{
                    width: '100',
                    title: '证券全称',
                    field: 'stockFullName',
                    sortable: true
                }, {
                    width: '100',
                    title: '证券拼音码',
                    field: 'stockSpell',
                    sortable: true
                }, {
                    width: '70',
                    title: '证券类型',
                    field: 'stockType',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                }, {
                    width: '70',
                    title: '资产类别',
                    field: 'assetClass',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                }, {
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    hidden: true,
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
                }<shiro:hasPermission name="system:setting:basestockInfo:operator">
                , {
                    field: 'action',
                    title: '操作',
                    width: 200,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editStockInfoFun(\'{0}\');" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteStockInfoFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </shiro:hasPermission>
            ]],
            onLoadSuccess: function (data) {
                <shiro:hasPermission name="system:setting:basestockInfo:operator">
                $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.role-easyui-linkbutton-del').linkbutton({text: '删除'});
                </shiro:hasPermission>
            },
            toolbar: '#stockInfoToolbar'
        });
    });

    function addStockInfoFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 500,
            height: 300,
            href: '${ctx}/base/stockInfo/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = stockInfoDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editStockInfoForm');
                    f.submit();
                }
            }]
        });
    }

    function editStockInfoFun(id) {
        if (id == undefined) {
            var rows = stockInfoDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            stockInfoDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 500,
            height: 300,
            href: '${ctx}/base/stockInfo/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = stockInfoDataGrid;
                    var f = parent.$.modalDialog.handler.find('#editStockInfoForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteStockInfoFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = stockInfoDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            stockInfoDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前证券信息吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/base/stockInfo/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        stockInfoDataGrid.datagrid('reload');
                    } else {
                        parent.$.messager.alert('错误', result.message, 'error');
                    }
                    $('#csrf-form').find('input[name="csrf"]').val(result.csrf);
                    setCsrfToken("csrf-form");
                    progressClose();
                }, 'JSON');
            }
        });
    }

    function searchStockInfoFun() {
        stockInfoDataGrid.datagrid('load', $.serializeObject($('#searchStockInfoForm')));
    }

    function cleanStockInfoFun() {
        $('#searchStockInfoForm input').val('');
        stockInfoDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchStockInfoForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>交易市场:</th>
                    <td><input id="marketIdListStockInfo" name="marketId" class="easyui-combobox" name="language"
                               style="width: 185px;"
                               placeholder="请选择交易市场" data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group'">
                    </td>
                    <th>证券内码</th>
                    <td>
                        <input name="interCode" type="text" placeholder="请输入证券内码" class="easyui-validatebox easyui-textbox"
                               style="width: 140px;">
                    </td>
                    <th>证券代码:</th>
                    <td><input name="stockCode" placeholder="请输入证券代码"/></td>
                    <th>证券简称:</th>
                    <td><input name="stockName" placeholder="请输入证券简称"/></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true"
                           onclick="searchStockInfoFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanStockInfoFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="stockInfoDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>
<div id="stockInfoToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:basestockInfo:operator">
        <a onclick="addStockInfoFun();" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    </shiro:hasPermission>
</div>