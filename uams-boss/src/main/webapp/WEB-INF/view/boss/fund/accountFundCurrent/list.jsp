<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var accountFundCurrentDataGrid;
    $(function () {
        accountFundCurrentDataGrid = $('#accountFundCurrentDataGrid').datagrid({
            url: '${ctx}/fund/accountFundCurrent/data',
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
                    title: '账户',
                    field: 'accountName',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '100',
                    title: '币种',
                    field: 'currency',
                    formatter: function (value, row, index) {
                        return getDictValueByCode(value);
                    }
                },
                {
                    width: '100',
                    title: '流水时间戳',
                    field: 'currentDate',
                    sortable: true
                },
                {
                    width: '100',
                    title: '业务类别',
                    field: 'businessFlag',
                    sortable: true
                },
                {
                    width: '100',
                    title: '证券信息',
                    field: 'stockCode',
                    sortable: true
                },
                {
                    width: '100',
                    title: '资产发生方向',
                    field: 'occurDirect',
                    sortable: true
                },
                {
                    width: '150',
                    title: '原资产当前数量余额',
                    field: 'orgAmt',
                    sortable: true
                },
                {
                    width: '150',
                    title: '资产增加减少发生数量',
                    field: 'occurAmt',
                    sortable: true
                },
                {
                    width: '150',
                    title: '最新资产当前数量余额',
                    field: 'lastAmt',
                    sortable: true
                },
                {
                    width: '150',
                    title: '原冻结资产数量余额',
                    field: 'forzenOrgAmt',
                    sortable: true
                },
                {
                    width: '150',
                    title: '冻结解冻发生数量',
                    field: 'occurForzenAmt',
                    sortable: true
                },
                {
                    width: '150',
                    title: '最新冻结资产数量余额',
                    field: 'forzenLastAmt',
                    sortable: true
                },
                {
                    width: '75',
                    title: '费用',
                    field: 'forzenLastAmt',
                    sortable: true
                },
                {
                    width: '75',
                    title: '转账费用',
                    field: 'netFee',
                    sortable: true
                },
                {
                    width: '100',
                    title: '备注',
                    field: 'remark',
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

        $("#currencyListAccountFundCurrentTd").html(dictDropDownOptionsList('currencyList','currency', 'currency','', 'required:true,',  'width:142px,'));
        $("#currencyListAccountFundCurrent").combobox({
            valueField:'code',
            textField:'name'
        });

    });

    function searchAccountFundCurrentFun() {
        accountFundCurrentDataGrid.datagrid('load', $.serializeObject($('#searchAccountFundCurrentForm')));
    }
    function cleanAccountFundCurrentFun() {
        $('#searchAccountFundCurrentForm input').val('');
        accountFundCurrentDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchAccountFundCurrentForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>账户</th>
                    <td><input name="accountName" placeholder="请输入账户" style="width:100px;"/></td>
                    <th>币种:</th>
                    <td id="currencyListAccountFundCurrentTd"></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchAccountFundCurrentFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanAccountFundCurrentFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="accountFundCurrentDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

