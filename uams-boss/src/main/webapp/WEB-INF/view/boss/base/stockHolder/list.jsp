<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var stockHolderDataGrid;
    $(function () {
        stockHolderDataGrid = $('#stockHolderDataGrid').datagrid({
            url: '${ctx}/base/stockHolder/data',
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
                    field: 'marketName',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '100',
                    title: '经纪商',
                    field: 'brokerName',
                    sortable: true
                }, {
                    width: '140',
                    title: '股东代码名称',
                    field: 'stockHolderName',
                    sortable: true
                },  {
                    width: '100',
                    title: '开户日期',
                    field: 'openDate',
                    sortable: true
                },{
                    width: '100',
                    title: '交易账号',
                    field: 'tradeAcount',
                    sortable: true
                },
                {
                    width: '100',
                    title: '资金帐号',
                    field: 'fundAccout',
                    sortable: true

                }, {
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    hidden: true,
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
                }<shiro:hasPermission name="system:setting:basestockHolder:operator">
                , {
                    field: 'action',
                    title: '操作',
                    width: 200,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editStockHolderFun(\'{0}\');" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteStockHolderFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </shiro:hasPermission>
            ]],
            onLoadSuccess: function (data) {
                <shiro:hasPermission name="system:setting:basestockHolder:operator">
                $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.role-easyui-linkbutton-del').linkbutton({text: '删除'});
                </shiro:hasPermission>
            },
            toolbar: '#stockHolderToolbar'
        });
    });


    function addStockHolderFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 500,
            height: 300,
            href: '${ctx}/base/stockHolder/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = stockHolderDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editStockHolderForm');
                    f.submit();
                }
            }]
        });
    }

    function editStockHolderFun(id) {
        if (id == undefined) {
            var rows = stockHolderDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            stockHolderDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 500,
            height: 300,
            href: '${ctx}/base/stockHolder/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = stockHolderDataGrid;
                    var f = parent.$.modalDialog.handler.find('#editStockHolderForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteStockHolderFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = stockHolderDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            stockHolderDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前股东代码信息吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/base/stockHolder/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        stockHolderDataGrid.datagrid('reload');
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

    function searchStockHolderFun() {
        stockHolderDataGrid.datagrid('load', $.serializeObject($('#searchStockHolderForm')));
    }

    function cleanStockHolderFun() {
        $('#searchStockHolderForm input').val('');
        stockHolderDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchStockHolderForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>交易市场:</th>
                    <td><input id="marketIdListStockHolder" name="marketId" class="easyui-combobox" name="language"
                               style="width: 185px;"
                               placeholder="请选择交易市场" data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group'"></td>
                    <th>经纪商:</th>
                    <td><input id="brokerIdListStockHolder" name="brokerId" class="easyui-combobox" name="language"
                               style="width: 185px;"
                               placeholder="请选择经纪商" data-options="
								url: '${ctx}/base/brokerInfo/all', method: 'get', valueField:'id',
								textField:'brokerName', groupField:'group'"></td>

                    <th>交易账号:</th>
                    <td><input name="tradeAcount" placeholder="请输入交易账号"/></td>
                    <th>资金账号:</th>
                    <td><input name="fundAccout" placeholder="请输入资金账号"/></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true"
                           onclick="searchStockHolderFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanStockHolderFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="stockHolderDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>
<div id="stockHolderToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:basestockHolder:operator">
        <a onclick="addStockHolderFun();" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    </shiro:hasPermission>
</div>