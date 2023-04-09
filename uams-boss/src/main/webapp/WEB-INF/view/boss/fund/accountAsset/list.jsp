<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var accountAssetDataGrid;
    $(function () {
        accountAssetDataGrid = $('#accountAssetDataGrid').datagrid({
            url: '${ctx}/fund/accountAsset/data',
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
                    title: '证券信息',
                    field: 'stockCode',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '100',
                    title: '账户',
                    field: 'accountName',
                    sortable: true
                },{
                    width: '100',
                    title: '当前金额数量',
                    field: 'currentAmount',
                    sortable: true
                },{
                    width: '100',
                    title: '冻结金额数量',
                    field: 'frozenAmt',
                    sortable: true
                },{
                    width: '100',
                    title: '期初金额数量',
                    field: 'initAmt',
                    sortable: true
                },{
                    width: '100',
                    title: '加权成本价格',
                    field: 'price',
                    sortable: true
                },{
                    width: '100',
                    title: '更新时间',
                    field: 'updateDate',
                    sortable: true
                }
            ]]
        });

        $("#currencyListAccountAssetTd").html(dictDropDownOptionsList('currencyList','currency', 'currency','', 'required:true,',  'width:142px,'));
        $("#currencyListAccountAsset").combobox({
            valueField:'code',
            textField:'name'
        });

    });

    function searchAccountAssetFun() {
        accountAssetDataGrid.datagrid('load', $.serializeObject($('#searchAccountAssetForm')));
    }
    function cleanAccountAssetFun() {
        $('#searchAccountAssetForm input').val('');
        accountAssetDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchAccountAssetForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>账户</th>
                    <td><input name="accountName" placeholder="请输入账户" style="width:100px;"/></td>
                    <th>币种:</th>
                    <td id="currencyListAccountAssetTd"></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchAccountAssetFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanAccountAssetFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="accountAssetDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

