<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var sysFillDataGrid;
    $(function () {
        sysFillDataGrid = $('#sysFillDataGrid').datagrid({
            url: '${ctx}/api/sysFill/data',
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
                    title: '客户资金帐号',
                    field: 'accountNo',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '150',
                    title: '看涨看跌',
                    field: 'callOrPutFlag',
//                    sortable: true,
                    formatter: function (value, row, index) {
                        if(value.trim()=="C"){
                            return "买权"
                        }else if(value.trim()=="P"){
                            return "卖权"
                        }else{
                            return "无"
                        }
                    }
                },
                {
                    width: '150',
                    title: '指定价格平仓',
                    field: 'closePrositionPrice',
                    sortable: true
                },
                {
                    width: '150',
                    title: '品种编号',
                    field: 'commodityNo',
                    sortable: true
                },
                {
                    width: '150',
                    title: '品种类型',
                    field: 'commodityType',
                    sortable: true
                },
                {
                    width: '150',
                    title: '合约1',
                    field: 'contractNo',
                    sortable: true
                },
                {
                    width: '150',
                    title: '交易所编号',
                    field: 'exchangeNo',
                    sortable: true
                },
                {
                    width: '150',
                    title: '手续费币种',
                    field: 'feeCurrency',
                    sortable: true
                },
                {
                    width: '150',
                    title: '手续费币种组',
                    field: 'feeCurrencyGroup',
                    sortable: true
                },
                {
                    width: '150',
                    title: '手续费',
                    field: 'feeValue',
                    sortable: true
                },
                {
                    width: '150',
                    title: '是否为T+1单',
                    field: 'isAddOne',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim()=="N"){
                            return "否"
                        }else{
                            return "是"
                        }
                    }
                },
                {
                    width: '150',
                    title: '委托成交删除标',
                    field: 'isDeleted',
                    sortable: true,
                    hidden: true
                },
                {
                    width: '150',
                    title: '人工客户手续费标记',
                    field: 'isManualFee',
                    sortable: true,
                    hidden: true
                },
                {
                    width: '150',
                    title: '成交时间',
                    field: 'matchDateTime',
                    sortable: true
                },
                {
                    width: '150',
                    title: '本地成交号',
                    field: 'matchNo',
                    sortable: true
                },
                {
                    width: '150',
                    title: '成交价',
                    field: 'matchPrice',
                    sortable: true
                },
                {
                    width: '150',
                    title: '成交量',
                    field: 'matchQty',
                    sortable: true
                },
                {
                    width: '150',
                    title: '买入卖出',
                    field: 'matchSide',
//                    sortable: true,
                    formatter: function (value, row, index) {
                        if(value.trim() =="S"){
                            return "卖出";
                        }else if(value.trim() =="B"){
                            return "买入";
                        }else {
                            return "无";
                        }
                    }
                },
                {
                    width: '150',
                    title: '委托来源',
                    field: 'matchSource',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim() ==1){
                            return "自助电子单 ";
                        }else if(value.trim() ==2){
                            return "代理电子单 ";
                        }else if(value.trim() ==3){
                            return "外部电子单";
                        }else if(value.trim() ==4){
                            return "人工录入单";
                        }else if(value.trim() ==5){
                            return "carry单";
                        }else if(value.trim() ==6){
                            return "程式化报单 ";
                        }else if(value.trim() ==7){
                            return "交割行权 ";
                        }else if(value.trim() ==8){
                            return "期权放弃 ";
                        }else if(value.trim() ==9){
                            return "通道费";
                        }else {
                            return "易盛API ";
                        }
                    }
                },
                {
                    width: '150',
                    title: '委托编码',
                    field: 'orderNo',
                    sortable: true
                },
                {
                    width: '150',
                    title: '系统号',
                    field: 'orderSystemNo',
                    sortable: true
                },
                {
                    width: '150',
                    title: '开平标志1',
                    field: 'positionEffect',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim() =="C"){
                            return "平仓";
                        }else if(value.trim() =="T"){
                            return "平当日";
                        }else if(value.trim() =="N"){
                            return "不分开平";
                        }else {
                            return "开仓";
                        }
                    }
                },
                {
                    width: '150',
                    title: '服务器标识',
                    field: 'serverFlag',
                    sortable: true
                },
                {
                    width: '150',
                    title: '执行价格',
                    field: 'strikePrice',
                    sortable: true
                },
                {
                    width: '150',
                    title: '上手成交时间',
                    field: 'upperMatchDateTime',
                    sortable: true
                },
                {
                    width: '150',
                    title: '上手成交号',
                    field: 'upperMatchNo',
                    sortable: true,
                },
                {
                    width: '150',
                    title: '上手号',
                    field: 'upperNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '备注',
                    field: 'remark',
                    sortable: true
                },
                {
                    width: '75',
                    title: '创建时间',
                    field: 'createDate',
                    sortable: true,
                    formatter: function (value, row, index) {
                        if(value!=null){
                            return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                        }else {
                            return "";
                        }
                    }
                },
                {
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    sortable: true,
                    //hidden: true,
                    formatter: function (value, row, index) {
                        if(value!=null){
                            return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                        }else {
                            return "";
                        }
                    }
                }
            ]]
        });

        $("#currencyListSysFillTd").html(dictDropDownOptionsList('currencyList','currency', 'currency','', 'required:true,',  'width:142px,'));
        $("#currencyListSysFill").combobox({
            valueField:'code',
            textField:'name'
        });

    });

    function searchSysFillFun() {
        sysFillDataGrid.datagrid('load', $.serializeObject($('#searchSysFillForm')));
    }
    function cleanSysFillFun() {
        $('#searchSysFillForm input').val('');
        sysFillDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchSysFillForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>品种编码</th>
                    <td><input name="commodityNo" placeholder="请输入品种编码" style="width:100px;"/></td>
                    <th>币种:</th>
                    <td id="currencyListSysFillTd"></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchSysFillFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanSysFillFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="sysFillDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

