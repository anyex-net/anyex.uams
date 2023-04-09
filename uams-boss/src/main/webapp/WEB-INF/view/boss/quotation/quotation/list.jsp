<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">

    var quotationDataGrid;
    $(function () {
        quotationDataGrid = $('#quotationDataGrid').datagrid({
            url: '${ctx}/quotation/quotation/data',
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
				    title: '行情时间戳',
				    field: 'quotationTime',
				    sortable: true

				}
            ]],
            columns: [[
                {
                    width: '150',
                    title: '证券内码',
                    field: 'interCode',
                    sortable: true
                },{
                    width: '150',
                    title: '交易市场代码',
                    field: 'marketCode',
                    sortable: true
                },{
                    width: '150',
                    title: '品种代码',
                    field: 'kindCode',
                    sortable: true
                },{
                    width: '150',
                    title: '币种代码',
                    field: 'currencyNo',
                    sortable: true
                },{
                    width: '150',
                    title: '五日均量',
                    field: 'fiveDayAvgQty',
                    sortable: true
                },{
                    width: '150',
                    title: '均价',
                    field: 'averagePrice',
                    sortable: true
                },{
                    width: '150',
                    title: '涨幅',
                    field: 'changeRate',
                    sortable: true
                },{
                    width: '150',
                    title: '涨速',
                    field: 'changeSpeed',
                    sortable: true
                },{
                    width: '150',
                    title: '涨跌值',
                    field: 'changeValue',
                    sortable: true
                },{
                    width: '150',
                    title: '收盘价',
                    field: 'closingPrice',
                    sortable: true
                },{
                    width: '150',
                    title: '今虚实度',
                    field: 'currDelta',
                    sortable: true
                },{
                    width: '150',
                    title: '历史最高价',
                    field: 'hisHighPrice',
                    sortable: true
                },{
                    width: '150',
                    title: '历史最低价',
                    field: 'hisLowPrice',
                    sortable: true
                },{
                    width: '150',
                    title: '内盘量',
                    field: 'insideQty',
                    sortable: true
                },{
                    width: '150',
                    title: '最新价',
                    field: 'lastPrice',
                    sortable: true
                },{
                    width: '150',
                    title: '最新成交量',
                    field: 'lastQty',
                    sortable: true
                },{
                    width: '150',
                    title: '跌停价',
                    field: 'limitDownPrice',
                    sortable: true
                },{
                    width: '150',
                    title: '涨停价',
                    field: 'limitUpPrice',
                    sortable: true
                },{
                    width: '150',
                    title: '流通市值',
                    field: 'negotiableValue',
                    sortable: true
                },{
                    width: '150',
                    title: '开盘价',
                    field: 'openingPrice',
                    sortable: true
                },{
                    width: '150',
                    title: '市盈率',
                    field: 'pERatio',
                    sortable: true
                },{
                    width: '150',
                    title: '持仓走势',
                    field: 'positionTrend',
                    sortable: true
                },{
                    width: '150',
                    title: '昨收盘价',
                    field: 'preClosingPrice',
                    sortable: true
                },{
                    width: '150',
                    title: '昨持仓量',
                    field: 'prePositionQty',
                    sortable: true
                },{
                    width: '150',
                    title: '昨结算价',
                    field: 'preSettlePrice',
                    sortable: true
                },{
                    width: '150',
                    title: '结算价',
                    field: 'settlePrice',
                    sortable: true
                },{
                    width: '150',
                    title: '振幅',
                    field: 'swing',
                    sortable: true
                },{
                    width: '150',
                    title: '委卖总量',
                    field: 'totalAskQty',
                    sortable: true
                },{
                    width: '150',
                    title: '委买总量',
                    field: 'totalBidQty',
                    sortable: true
                },{
                    width: '150',
                    title: '当日总成交量',
                    field: 'totalQty',
                    sortable: true
                },{
                    width: '150',
                    title: '当日成交金额',
                    field: 'totalTurnover',
                    sortable: true
                },{
                    width: '150',
                    title: '总市值',
                    field: 'totalValue',
                    sortable: true
                },{
                    width: '150',
                    title: '换手率',
                    field: 'turnoverRate',
                    sortable: true
                },{
                    width: '150',
                    title: '交易状态',
                    field: 'tradingState',
                    sortable: true
                },{
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
            }
                ]],
            toolbar: '#quotationToolbar' 
        });
    });

    function searchquotationFun() {
    	quotationDataGrid.datagrid('load', $.serializeObject($('#searchquotationForm')));
    }
    function cleanquotationFun() {
        $('#searchquotationForm input').val('');
        quotationDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchquotationForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
            <tr>
                    <th>经纪商编码:</th>
                    <td><input name="interCode" placeholder="请输入证券内码"/></td>
                    <th>经纪商名称:</th>
                    <td><input name="marketCode" placeholder="请输入交易市场代码"/></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchquotationFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanquotationFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
	<div data-options="region:'center',border:true">
        <table id="quotationDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>	
