<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var sysAccountDataGrid;
    $(function () {
        sysAccountDataGrid = $('#sysAccountDataGrid').datagrid({
            url: '${ctx}/api/sysAccount/data',
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
                    title: '资金账号',
                    field: 'accountNo',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '200',
                    title: '账号简称',
                    field: 'accountShortName',
                    sortable: true
                },
                {
                    width: '200',
                    title: '账号英文简称',
                    field: 'accountEnShortName',
                    sortable: true
                },
                {
                    width: '200',
                    title: '账号类型',
                    field: 'accountType',
                    formatter: function (value, row, index) {
                        if(value=="P"){
                            return "个人客户"
                        }else if(value=="O") {
                            return "机构客户"
                        }else {
                            return "OOOO"
                        }

                    }
                },
                {
                    width: '200',
                    title: '账号状态',
                    field: 'accountState',
                    formatter: function (value, row, index) {
                        if(value=="N"){
                            return "正常"
                        }else if(value=="C") {
                            return "销户"
                        }else if(value=="S"){
                            return "休眠"
                        }else {
                            return "OOOO"
                        }

                    }
                },
                {
                    width: '200',
                    title: '交易状态',
                    field: 'accountTradeRight',
                    formatter: function (value, row, index) {
                        if(value=="1"){
                            return "集合竞价"
                        }else if(value=="2") {
                            return "集合竞价撮合"
                        }else if(value=="3"){
                            return "连续交易"
                        }else if(value=="4"){
                            return "交易暂停"
                        }else if(value=="5"){
                            return "闭市"
                        }else if(value=="6"){
                            return "闭市处理时间"
                        }else if(value=="0"){
                            return "网关未连"
                        }else if(value=="N"){
                            return "未知状态"
                        }else if(value=="I"){
                            return "正初始化"
                        }else if(value=="R"){
                            return "准备就绪"
                        }else {
                            return"0000"
                        }

                    }
                },
                {
                    width: '200',
                    title: '可交易品种组',
                    field: 'commodityGroupNo',
                    sortable: true
                },
                {
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

    function searchSysAccountFun() {
        sysAccountDataGrid.datagrid('load', $.serializeObject($('#searchSysAccountForm')));
    }
    function cleanSysAccountFun() {
        $('#searchSysAccountForm input').val('');
        sysAccountDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchSysAccountForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>资金账号</th>
                    <td><input name="accountNo" placeholder="请输入资金账号" style="width:100px;"/></td>

                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchSysAccountFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanSysAccountFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="sysAccountDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

