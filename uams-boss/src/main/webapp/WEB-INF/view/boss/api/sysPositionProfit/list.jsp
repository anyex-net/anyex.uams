<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var sysPositionProfitDataGrid;
    $(function () {
        sysPositionProfitDataGrid = $('#sysPositionProfitDataGrid').datagrid({
            url: '${ctx}/api/sysPositionProfit/data',
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
                    title: '计算价格',
                    field: 'calculatePrice',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '100',
                    title: 'LME持仓盈亏',
                    field: 'lMEPositionProfit',
                    sortable: true
                },
                {
                    width: '100',
                    title: '期权市值',
                    field: 'optionMarketValue',
                    sortable: true
                },
                {
                    width: '100',
                    title: '本地持仓号',
                    field: 'positionNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '持仓盈亏',
                    field: 'positionProfit',
                    sortable: true
                },
                {
                    width: '100',
                    title: '持仓流号',
                    field: 'positionStreamId',
                    sortable: true
                },
                {
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    hidden: true,
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
                }
            ]]
        });

        $("#currencyListsysPositionProfitTd").html(dictDropDownOptionsList('currencyList','currency', 'currency','', 'required:true,',  'width:142px,'));
        $("#currencyListsysPositionProfit").combobox({
            valueField:'code',
            textField:'name'
        });

    });

    function searchsysPositionProfitFun() {
        sysPositionProfitDataGrid.datagrid('load', $.serializeObject($('#searchsysPositionProfitForm')));
    }
    function cleansysPositionProfitFun() {
        $('#searchsysPositionProfitForm input').val('');
        sysPositionProfitDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchsysPositionProfitForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>本地持仓号</th>
                    <td><input name="positionNo" placeholder="请输入本地持仓号" style="width:100px;"/></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchsysPositionProfitFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleansysPositionProfitFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="sysPositionProfitDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

