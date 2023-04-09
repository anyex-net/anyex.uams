<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var futureKindDataGrid;
    $(function () {
        futureKindDataGrid = $('#futureKindDataGrid').datagrid({
            url: '${ctx}/base/futureKind/data',
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
                    width: '140',
                    title: '交易市场',
                    field: 'marketName'
                }
            ]],
            columns: [[
                {
                    width: '200',
                    title: '期货品种编码',
                    field: 'kindCode',
                    sortable: true
                }, {
                    width: '200',
                    title: '期货品种名称',
                    field: 'kindName',
                    sortable: true
                },{
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    hidden:true,
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
            }<shiro:hasPermission name="system:setting:basefutureKind:operator">
                , {
                    field: 'action',
                    title: '操作',
                    width: 200,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editFutureKindFun(\'{0}\');" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteFutureKindFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </shiro:hasPermission>
                ]],
            onLoadSuccess: function (data) {
                <shiro:hasPermission name="system:setting:basefutureKind:operator">
                $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.role-easyui-linkbutton-del').linkbutton({text: '删除'});
                </shiro:hasPermission>
            },
            toolbar: '#futureKindToolbar' 
        });
    });

    function addFutureKindFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 350,
            height: 250,
            href: '${ctx}/base/futureKind/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = futureKindDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editFutureKindForm');
                    f.submit();
                }
            }]
        });
    }

    function editFutureKindFun(id) {
        if (id == undefined) {
            var rows = futureKindDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            futureKindDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 350,
            height: 250,
            href: '${ctx}/base/futureKind/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = futureKindDataGrid;
                    var f = parent.$.modalDialog.handler.find('#editFutureKindForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteFutureKindFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = futureKindDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            futureKindDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前期货品种信息吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/base/futureKind/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        futureKindDataGrid.datagrid('reload');
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
    
    function searchFutureKindFun() {
    	futureKindDataGrid.datagrid('load', $.serializeObject($('#searchFutureKindForm')));
    }
    function cleanFutureKindFun() {
        $('#searchFutureKindForm input').val('');
        futureKindDataGrid.datagrid('load', {});
    }

    //获取数据信息
    function getFutureInfoFun() {
        alert(111);
        $.ajax({
            type:'get',
            url:'${ctx}/tradeSysOrderApi/tradeSysOrder',
            success:function(data){
                alert("成功");
            }
        });
    }

</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchFutureKindForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>交易市场:</th>
                    <td><input  id="marketIdListFutureKind" name="marketId"  class="easyui-combobox" name="language" style="width: 185px;"
                                placeholder="请选择交易市场"  data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group'"  ></td>
                    <th>期货品种编码:</th>
                    <td><input name="kindCode" placeholder="请输入期货品种编码"/></td>
                    <th>期货品种名称:</th>
                    <td><input name="kindName" placeholder="请输入期货品种名称"/></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="getFutureInfoFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanFutureKindFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
	<div data-options="region:'center',border:true">
        <table id="futureKindDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>	
<div id="futureKindToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:basefutureKind:operator">
    <a onclick="addFutureKindFun();" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    </shiro:hasPermission>
</div>