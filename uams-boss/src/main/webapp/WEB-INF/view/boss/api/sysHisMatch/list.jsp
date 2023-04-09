<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var sysHisMatchDataGrid;
    $(function () {
        sysHisMatchDataGrid = $('#sysHisMatchDataGrid').datagrid({
            url: '${ctx}/api/sysHisMatch/data',
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
                    title: '客户资金账号',
                    field: 'accountNo',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '100',
                    title: '客户手续费',
                    field: 'accountFee',
                    sortable: true
                },
                {
                    width: '100',
                    title: '客户手续费币种',
                    field: 'accountFeeCurrency',
                    sortable: true
                },
                {
                    width: '100',
                    title: '客户手续费币种组',
                    field: 'accountFeeCurrencyGroup',
                    sortable: true
                },
                {
                    width: '100',
                    title: '其他费用',
                    field: 'accountOtherFee',
                    sortable: true
                },
                {
                    width: '100',
                    title: '看涨看跌',
                    field: 'callOrPutFlag',
                    sortable: true
                },
                {
                    width: '100',
                    title: '指定平仓价格',
                    field: 'closePrice',
                    sortable: true
                },
                {
                    width: '100',
                    title: '平仓盈亏',
                    field: 'closeProfit',
                    sortable: true
                },
                {
                    width: '100',
                    title: '平仓量',
                    field: 'closeQty',
                    sortable: true
                },{
                    width: '100',
                    title: '品种币种',
                    field: 'commodityCurrency',
                    sortable: true
                },{
                    width: '100',
                    title: '品种币种组',
                    field: 'commodityCurrencyGroup',
                    sortable: true
                },{
                    width: '100',
                    title: '品种编号',
                    field: 'commodityNo',
                    sortable: true
                },{
                    width: '100',
                    title: '品种类型',
                    field: 'commodityType',
                    sortable: true
                },{
                    width: '100',
                    title: '合约号',
                    field: 'contractNo',
                    sortable: true
                },{
                    width: '100',
                    title: '交易所成交号',
                    field: 'exchangeMatchNo',
                    sortable: true
                },{
                    width: '100',
                    title: '交易所编号',
                    field: 'exchangeNo',
                    sortable: true
                },{
                    width: '100',
                    title: '投机保值',
                    field: 'hedgeFlag',
                    sortable: true
                },{
                    width: '100',
                    title: '人工客户手续费标记',
                    field: 'isManualFee',
                    sortable: true
                },{
                    width: '100',
                    title: '人工上手手续费标记',
                    field: 'isUpperManualFee',
                    sortable: true
                },{
                    width: '100',
                    title: '组合号',
                    field: 'matchCmbNo',
                    sortable: true
                },

                {
                    width: '100',
                    title: '成交时间',
                    field: 'matchDateTime',
                    sortable: true
                },
                {
                    width: '100',
                    title: '成交序号',
                    field: 'matchNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '成交价',
                    field: 'matchPrice',
                    sortable: true
                },
                {
                    width: '100',
                    title: '成交量',
                    field: 'matchQty',
                    sortable: true
                },
                {
                    width: '100',
                    title: '买入卖出',
                    field: 'matchSide',
                    sortable: true
                },
                {
                    width: '100',
                    title: '委托来源',
                    field: 'matchSource',
                    sortable: true
                },
                {
                    width: '100',
                    title: '成交流水号',
                    field: 'matchStreamID',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手流水号',
                    field: 'matchUpperStreamID',
                    sortable: true
                },
                {
                    width: '100',
                    title: '操作时间',
                    field: 'operateTime',
                    sortable: true
                },

                {
                    width: '100',
                    title: '操作员',
                    field: 'operatorNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '委托号',
                    field: 'orderNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '开平标志',
                    field: 'positionEffect',
                    sortable: true
                },
                {
                    width: '100',
                    title: '权利金收入',
                    field: 'premiumIncome',
                    sortable: true
                },
                {
                    width: '100',
                    title: '权利金支出',
                    field: 'premiumPay',
                    sortable: true
                },
                {
                    width: '100',
                    title: '结算日期',
                    field: 'settleDate',
                    sortable: true
                },
                {
                    width: '100',
                    title: '结算分组',
                    field: 'settleGroupNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '执行价',
                    field: 'strikePrice',
                    sortable: true
                },
                {
                    width: '100',
                    title: '交易日期',
                    field: 'tradeDate',
                    sortable: true
                },
                {
                    width: '100',
                    title: '成交金额',
                    field: 'turnover',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手手续费',
                    field: 'upperFee',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手手续费币种',
                    field: 'upperFeeCurrency',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手手续费币种组',
                    field: 'upperFeeCurrencyGroup',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手成交时间',
                    field: 'upperMatchDateTime',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手号',
                    field: 'upperNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手其他手续费',
                    field: 'upperOtherFee',
                    sortable: true
                },
                {
                    width: '100',
                    title: '备注',
                    field: 'remark',
                    sortable: true
                },

                {
                    width: '100',
                    title: '创建',
                    field: 'createDate',
                    hidden: true,
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
                }
            ]]
        });
    });

    function searchSysHisMatch() {
        sysHisMatchDataGrid.datagrid('load', $.serializeObject($('#searchSysHisMatchForm')));
    }
    function cleanSysHisMatch() {
        $('#searchSysHisMatchForm input').val('');
        sysHisMatchDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchSysHisMatchForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>资金账号</th>
                    <td><input name="accountNo" placeholder="请输入资金账号" style="width:100px;"/></td>

                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchSysHisMatch();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanSysHisMatch();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="sysHisMatchDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

