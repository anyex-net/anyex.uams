<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var sysAccountFundChangeDataGrid;
    $(function () {
        sysAccountFundChangeDataGrid = $('#sysAccountFundChangeDataGrid').datagrid({
            url: '${ctx}/api/sysAccountFundChange/data',
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
                    title: '客户交割手续费',
                    field: 'accountDeliveryFee',
                    sortable: true
                },
                {
                    width: '100',
                    title: '客户手续费包含交割手续费',
                    field: 'accountFee',
                    sortable: true
                },
                {
                    width: '100',
                    title: '客户初始保证金',
                    field: 'accountIntialMargin',
                    sortable: true
                },
                {
                    width: '100',
                    title: '客户维持保证金',
                    field: 'accountMaintenanceMargin',
                    sortable: true
                },
                {
                    width: '100',
                    title: '授信资金',
                    field: 'authMoney',
                    sortable: true
                },
                {
                    width: '100',
                    title: '当日可用',
                    field: 'available',
                    sortable: true
                },
                {
                    width: '100',
                    title: '当日结存',
                    field: 'balance',
                    sortable: true
                },
                {
                    width: '100',
                    title: '可提取',
                    field: 'canDraw',
                    sortable: true
                },{
                    width: '100',
                    title: '资金调整',
                    field: 'cashAdjustValue',
                    sortable: true
                },{
                    width: '100',
                    title: '入金',
                    field: 'cashInValue',
                    sortable: true
                },{
                    width: '100',
                    title: '出金',
                    field: 'cashOutValue',
                    sortable: true
                },{
                    width: '100',
                    title: '质押资金',
                    field: 'cashPledged',
                    sortable: true
                },{
                    width: '100',
                    title: '平仓盈亏',
                    field: 'closeProfit',
                    sortable: true
                },{
                    width: '100',
                    title: '币种组号',
                    field: 'currencyGroupNo',
                    sortable: true
                },{
                    width: '100',
                    title: '币种号',
                    field: 'currencyNo',
                    sortable: true
                },{
                    width: '100',
                    title: '交割盈亏',
                    field: 'deliveryProfit',
                    sortable: true
                },{
                    width: '100',
                    title: 'LME贴现',
                    field: 'discount',
                    sortable: true
                },{
                    width: '100',
                    title: '当日权益',
                    field: 'equity',
                    sortable: true
                },{
                    width: '100',
                    title: '汇兑手续费',
                    field: 'exchangeFee',
                    sortable: true
                },

                {
                    width: '100',
                    title: '到期平仓盈亏',
                    field: 'expProfit',
                    sortable: true
                },
                {
                    width: '100',
                    title: '冻结保证金',
                    field: 'frozenDeposit',
                    sortable: true
                },
                {
                    width: '100',
                    title: '冻结手续费',
                    field: 'frozenFee',
                    sortable: true
                },
                {
                    width: '100',
                    title: '期货算法',
                    field: 'futureAlg',
                    sortable: true
                },
                {
                    width: '100',
                    title: 'ME持仓盈亏',
                    field: 'lmePositionProfit',
                    sortable: true
                },
                {
                    width: '100',
                    title: '账户市值',
                    field: 'marketEquity',
                    sortable: true
                },
                {
                    width: '100',
                    title: '期权算法',
                    field: 'optionAlg',
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
                    title: '不含LME持仓盈亏',
                    field: 'positionProfit',
                    sortable: true
                },

                {
                    width: '100',
                    title: '上日可用',
                    field: 'preAvailable1',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上日结存',
                    field: 'preBalance',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上日权益',
                    field: 'preEquity',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上日LME持仓平盈',
                    field: 'preLMEPositionProfit',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上日市值权益',
                    field: 'preMarketEquity',
                    sortable: true
                },
                {
                    width: '100',
                    title: '权利金收取',
                    field: 'premiumIncome',
                    sortable: true
                },
                {
                    width: '100',
                    title: '利金支付',
                    field: 'premiumPay',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上日未到期平盈',
                    field: 'preUnExpProfit',
                    sortable: true
                },
                {
                    width: '100',
                    title: '交易汇率',
                    field: 'tradeRate',
                    sortable: true
                },
                {
                    width: '100',
                    title: '未到期平盈',
                    field: 'unExpProfit',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手初始保证金',
                    field: 'upperInitalMargin',
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

    function searchSysAccountFundChange() {
        sysAccountFundChangeDataGrid.datagrid('load', $.serializeObject($('#searchSysAccountFundChangeForm')));
    }
    function cleanSysAccountFundChange() {
        $('#searchSysAccountFundChangeForm input').val('');
        sysAccountFundChangeDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchSysAccountFundChangeForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>资金账号</th>
                    <td><input name="accountNo" placeholder="请输入资金账号" style="width:100px;"/></td>

                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchSysAccountFundChange();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanSysAccountFundChange();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="sysAccountFundChangeDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

