<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var sysHisOrderDataGrid;
    $(function () {
        sysHisOrderDataGrid = $('#sysHisOrderDataGrid').datagrid({
            url: '${ctx}/api/sysHisOrder/data',
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
                    width: '100',
                    title: '是否T+1有效',
                    field: 'addOneIsValid',
                    formatter: function (value, row, index) {
                        if(value=="N"){
                            return "否"
                        }else{
                            return "是"
                        }
                    }
                },
                {
                    width: '100',
                    title: '看涨看跌1',
                    field: 'callOrPutFlag',
                    formatter: function (value, row, index) {
                        if(value=="C"){
                            return "买权"
                        }else if(value=="P"){
                            return "卖权"
                        }else{
                            return "无"
                        }
                    }
                },
                {
                    width: '100',
                    title: '看涨看跌2',
                    field: 'callOrPutFlag2',
                    formatter: function (value, row, index) {
                        if(value=="C"){
                            return "买权"
                        }else if(value=="P"){
                            return "卖权"
                        }else{
                            return "无"
                        }
                    }
                },
                {
                    width: '100',
                    title: '品种编号',
                    field: 'commodityNo',
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
                    title: '合约2',
                    field: 'contractNo2',
                    sortable: true
                },
                {
                    width: '100',
                    title: '日期',
                    field: 'date1',
                    sortable: true
                },
                {
                    width: '100',
                    title: '错误信息码',
                    field: 'errorCode',
                    sortable: true
                },
                {
                    width: '100',
                    title: '错误信息',
                    field: 'errorText',
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
                    title: '有效日期',
                    field: 'expireTime',
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
                    title: '询价号',
                    field: 'inquiryNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '是否为T+1单',
                    field: 'isAddOne',
                    formatter: function (value, row, index) {
                        if(value=="N"){
                            return "否"
                        }else{
                            return "是"
                        }
                    }
                },
                {
                    width: '100',
                    title: '是否为录入委托单',
                    field: 'isBackInput',
                    formatter: function (value, row, index) {
                        if(value=="N"){
                            return "否"
                        }else{
                            return "是"
                        }
                    }
                },
                {
                    width: '100',
                    title: '委托成交删除标志',
                    field: 'isDeleted',
                    sortable: true
                },
                {
                    width: '100',
                    title: '是否风险报单',
                    field: 'isRiskOrder',
                    formatter: function (value, row, index) {
                        if(value=="N"){
                            return "否"
                        }else{
                            return "是"
                        }
                    }
                },
                {
                    width: '100',
                    title: '软件授权号',
                    field: 'licenseNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '冰山单最大随机量',
                    field: 'maxClipSize',
                    sortable: true
                },
                {
                    width: '100',
                    title: '冰山单最小随机量',
                    field: 'minClipSize',
                    sortable: true
                },
                {
                    width: '100',
                    title: '撤单数量',
                    field: 'orderCanceledQty',
                    sortable: true
                },
                {
                    width: '100',
                    title: '录单操作人',
                    field: 'orderCommandUserNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '交易所系统号',
                    field: 'orderExchangeSystemNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '下单时间',
                    field: 'orderInsertTime',
                    sortable: true
                },
                {
                    width: '100',
                    title: '下单人',
                    field: 'orderInsertUserNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '本地号',
                    field: 'orderLocalNo',
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

        $("#currencyListsysHisOrderTd").html(dictDropDownOptionsList('currencyList','currency', 'currency','', 'required:true,',  'width:142px,'));
        $("#currencyListsysHisOrder").combobox({
            valueField:'code',
            textField:'name'
        });

    });

    function searchsysHisOrderFun() {
        sysHisOrderDataGrid.datagrid('load', $.serializeObject($('#searchsysHisOrderForm')));
    }
    function cleansysHisOrderFun() {
        $('#searchsysHisOrderForm input').val('');
        sysHisOrderDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchsysHisOrderForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>账户</th>
                    <td><input name="accountNo" placeholder="请输入账户" style="width:100px;"/></td>
                    <th>币种:</th>
                    <td id="currencyListsysHisOrderTd"></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchsysHisOrderFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleansysHisOrderFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="sysHisOrderDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

