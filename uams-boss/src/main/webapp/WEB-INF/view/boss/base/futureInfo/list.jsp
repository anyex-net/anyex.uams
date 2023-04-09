<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var futureInfoDataGrid;
    $(function () {
        futureInfoDataGrid = $('#futureInfoDataGrid').datagrid({

            url: '${ctx}/base/futureInfo/data',
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
				    width: '75',
				    title: '证券内码',
				    field: 'interCode',
				    sortable: true
				}
            ]],
            columns: [[
                {
                    width: '100',
                    title: '期货品种',
                    field: 'kindName',
                    sortable: true
                }
                , {
                    width: '100',
                    title: '交易市场',
                    field: 'marketName',
                    sortable: true
                }
                , {
                    width: '100',
                    title: '合约月份',
                    field: 'contractMonth',
                    sortable: true
                }
                , {
                    width: '100',
                    title: '是否主力合约',
                    field: 'isMainContract',
                    sortable: true
                }
                , {
                    width: '100',
                    title: '标的物市场',
                    field: 'targetMarketId',
                    sortable: true
                }
                , {
                    width: '100',
                    title: '标的物证券代码',
                    field: 'targetStockCode',
                    sortable: true
                },{
                    width: '100',
                    title: '合约乘数',
                    field: 'multiple',
                    sortable: true
                }
                , {
                    width: '100',
                    title: '最后交易日',
                    field: 'lastTradeDate',
                    sortable: true
                }
                , {
                    width: '100',
                    title: '交割日',
                    field: 'lastSettlementDate',
                    sortable: true
                }, {
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
            }<shiro:hasPermission name="system:setting:basefutureInfo:operator">
                , {
                    field: 'action',
                    title: '操作',
                    width: 200,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editFutureInfoFun(\'{0}\');" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteFutureInfoFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </shiro:hasPermission>
                ]],
            onLoadSuccess: function (data) {
                <shiro:hasPermission name="system:setting:basefutureInfo:operator">
                $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.role-easyui-linkbutton-del').linkbutton({text: '删除'});
                </shiro:hasPermission>
            },
            toolbar: '#futureInfoToolbar'
        });
    });

    //添加操作
    function addFutureInfoFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 700,
            height: 400,
            href: '${ctx}/base/futureInfo/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = futureInfoDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editFutureInfoForm');
                    f.submit();
                }
            }]
        });
    }

    //编辑操作
    function editFutureInfoFun(id) {
        if (id == undefined) {
            var rows = futureInfoDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            futureInfoDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 700,
            height: 400,
            href: '${ctx}/base/futureInfo/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = futureInfoDataGrid;
                    var f = parent.$.modalDialog.handler.find('#editFutureInfoForm');
                    f.submit();
                }
            }]
        });
    }

    //删除操作
    function deleteFutureInfoFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = futureInfoDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            futureInfoDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前期货信息吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/base/futureInfo/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        futureInfoDataGrid.datagrid('reload');
                    }else{
                        parent.$.messager.alert('错误', result.message, 'error');
                    }
                    $('#csrf-form').find('input[name="csrf"]').val(result.csrf);
                    setCsrfToken("csrf-form");
                    progressClose();
                }, 'JSON');
            }
        });
    }
    //查询操作
    function searchFutureInfoFun() {
        futureInfoDataGrid.datagrid('load', $.serializeObject($('#searchFutureInfoForm')));
    }
    //清空操作
    function cleanFutureInfoFun() {
        $('#searchFutureInfoForm input').val('');
        futureInfoDataGrid.datagrid('load', {});
    }
    //获取数据信息
    function getFutureInfoFun() {
        alert(111);
        $.ajax({
            type:'POST',
            url:'${ctx}/esunny/QueryContract',
            success:function(data){
            alert("成功");
        }
    });
    }

</script>
<%--<jsp:useBean id="someId" scope="session" class="com.uams.esunny.quote.QueryContractAPI"/>--%>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchFutureInfoForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>交易市场:</th>
                    <td><input  id="marketIdListOrgTradeChannelCfg" name="marketId"  class="easyui-combobox" name="language" style="width: 185px;"
                                placeholder="请选择交易市场"  data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group'"  ></td>
                    <th>期货品种:</th>
                    <td><input  id="futureKindIdListOrgTradeChannelCfg" name="futureKindId"  class="easyui-combobox" name="language" style="width: 185px;"
                                placeholder="请选择期货品种"  data-options="
								url: '${ctx}/base/futureKind/all', method: 'get', valueField:'id',
								textField:'kindName', groupField:'group'"  ></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchFutureInfoFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanFutureInfoFun();">清空</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="getFutureInfoFun();">导入合约信息</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
	<div data-options="region:'center',border:true">
        <table id="futureInfoDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

<div id="futureInfoToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:basefutureInfo:operator">
    <a onclick="addFutureInfoFun();" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    </shiro:hasPermission>
</div>