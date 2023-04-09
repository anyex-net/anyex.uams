<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var sysPositionDataGrid;
    $(function () {
        sysPositionDataGrid = $('#sysPositionDataGrid').datagrid({
            url: '${ctx}/api/sysPosition/data',
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
                    title: '客户初始保证金',
                    field: 'accountInitialMargin',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '100',
                    title: '客户维持保证金',
                    field: 'accountMaintenanceMargin',
                    sortable: true
                },
                {
                    width: '100',
                    title: '客户资金账号',
                    field: 'accountNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '当前计算价格',
                    field: 'calculatePrice',
                    sortable: true
                },
                {
                    width: '100',
                    title: '看张看跌',
                    field: 'callOrPutFlag',
                    formatter: function (value, row, index) {
                        if(value=='C'){
                            return "买权"
                        }else if(value=='P'){
                            return "卖权"
                        }else{
                            return "无"
                        }
                    }
                },
                {
                    width: '100',
                    title: '品种币种',
                    field: 'commodityCurrency',
                    sortable: true
                },
                {
                    width: '100',
                    title: '品种币种组',
                    field: 'commodityCurrencyGroup',
                    sortable: true
                },
                {
                    width: '100',
                    title: '品种编码',
                    field: 'commodityNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '客户资金账号',
                    field: 'accountNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '品种类型',
                    field: 'commodityType',
                    sortable: true
                },
                {
                    width: '100',
                    title: '合约1',
                    field: 'contractNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '交易所编号',
                    field: 'exchangeNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '投机保值',
                    field: 'hedgeFlag',
                    sortable: true
                },
                {
                    width: '100',
                    title: 'LME持仓盈亏',
                    field: 'lMEPositionProfit',
                    sortable: true
                },
                {
                    width: '100',
                    title: '本地成交号',
                    field: 'matchNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '买入卖出',
                    field: 'matchSide',
                    formatter: function (value, row, index) {
                        if(value =="S"){
                            return "卖出";
                        }else if(value =="B"){
                            return "买入";
                        }else {
                            return "无";
                        }
                    }
                },
                {
                    width: '100',
                    title: '期权市值',
                    field: 'optionMarketValue',
                    sortable: true
                },
                {
                    width: '100',
                    title: '委托编码',
                    field: 'orderNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '本地持仓号',
                    field: 'positionNo',
                    sortable: true
                },{
                    width: '100',
                    title: '持仓价',
                    field: 'positionPrice',
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
                    title: '持仓量',
                    field: 'positionQty',
                    sortable: true
                },
                {
                    width: '100',
                    title: '持仓流号',
                    field: 'positionStreamId',
                    sortable: true
                },
                {
                    width: '100',
                    title: '服务器标识',
                    field: 'serverFlag',
                    sortable: true
                },
                {
                    width: '100',
                    title: '执行价格',
                    field: 'strikePrice',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手初始保证金',
                    field: 'upperInitialMargin',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手维持保证金',
                    field: 'upperMaintenanceMargin',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手号',
                    field: 'upperNo',
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

        $("#currencyListsysPositionTd").html(dictDropDownOptionsList('currencyList','currency', 'currency','', 'required:true,',  'width:142px,'));
        $("#currencyListsysPosition").combobox({
            valueField:'code',
            textField:'name'
        });

    });

    function searchsysPositionFun() {
        sysPositionDataGrid.datagrid('load', $.serializeObject($('#searchsysPositionForm')));
    }
    function cleansysPositionFun() {
        $('#searchsysPositionForm input').val('');
        sysPositionDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchsysPositionForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>客户初始保证金</th>
                    <td><input name="accountInitialMargin" placeholder="请输入客户初始保证金" style="width:100px;"/></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchsysPositionFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleansysPositionFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="sysPositionDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

