<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var sysAccountFeeRentDataGrid;
    $(function () {
        sysAccountFeeRentDataGrid = $('#sysAccountFeeRentDataGrid').datagrid({
            url: '${ctx}/api/sysAccountFeeRent/data',
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
                    width: '200',
                    title: '客户资金账号',
                    field: 'accountNo',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '200',
                    title: '计算方式',
                    field: 'calculateMode',
                    sortable: true
                },
                {
                    width: '200',
                    title: '平今费用',
                    field: 'closeTodayFee',
                    sortable: true
                },
                {
                    width: '200',
                    title: '品种编号',
                    field: 'commodityNo',
                    sortable: true
                },
                {
                    width: '200',
                    title: '品种类型',
                    field: 'commodityType',
                    sortable: true
                },
                {
                    width: '200',
                    title: '币种组',
                    field: 'currencyGroupNo',
                    sortable: true
                },
                {
                    width: '200',
                    title: '币种',
                    field: 'currencyNo',
                    sortable: true
                },
                {
                    width: '200',
                    title: '市场号',
                    field: 'exchangeNo',
                    sortable: true
                },
                {
                    width: '200',
                    title: '成交来源',
                    field: 'matchSource',
                    sortable: true
                },{
                    width: '200',
                    title: '开平仓费用',
                    field: 'openCloseFee',
                    sortable: true
                },{
                    width: '200',
                    title: '备注',
                    field: 'remark',
                    sortable: true
                },
                {
                    width: '200',
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

    function searchSysAccountFeeRent() {
        sysAccountFeeRentDataGrid.datagrid('load', $.serializeObject($('#searchSysAccountFeeRentForm')));
    }
    function cleanSysAccountFeeRent() {
        $('#searchSysAccountFeeRentForm input').val('');
        sysAccountFeeRentDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchSysAccountFeeRentForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>资金账号</th>
                    <td><input name="accountNo" placeholder="请输入资金账号" style="width:100px;"/></td>

                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchSysAccountFeeRent();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanSysAccountFeeRent();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="sysAccountFeeRentDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

