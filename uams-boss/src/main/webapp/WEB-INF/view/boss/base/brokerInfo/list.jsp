<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var brokerInfoDataGrid;
    $(function () {
        brokerInfoDataGrid = $('#brokerInfoDataGrid').datagrid({
            url: '${ctx}/base/brokerInfo/data',
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
				    width: '300',
				    title: '经纪商编码',
				    field: 'brokerCode',
				    sortable: true
				}
            ]],
            columns: [[
                {
                    width: '300',
                    title: '经纪商名称',
                    field: 'brokerName',
                    sortable: true
                },{
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    formatter: function (value, row, index) {
                        return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                    }
            }<shiro:hasPermission name="system:setting:basebrokerInfo:operator">
                , {
                    field: 'action',
                    title: '操作',
                    width: 200,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editBrokerInfoFun(\'{0}\');" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteBrokerInfoFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </shiro:hasPermission>
                ]],
            onLoadSuccess: function (data) {
                <shiro:hasPermission name="system:setting:basebrokerInfo:operator">
                $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.role-easyui-linkbutton-del').linkbutton({text: '删除'});
                </shiro:hasPermission>
            },
            toolbar: '#brokerInfoToolbar' 
        });
    });

    function addBrokerInfoFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 300,
            height: 200,
            href: '${ctx}/base/brokerInfo/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = brokerInfoDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editBrokerInfoForm');
                    f.submit();
                }
            }]
        });
    }

    function editBrokerInfoFun(id) {
        if (id == undefined) {
            var rows = brokerInfoDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            brokerInfoDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 300,
            height: 200,
            href: '${ctx}/base/brokerInfo/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = brokerInfoDataGrid;
                    var f = parent.$.modalDialog.handler.find('#editBrokerInfoForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteBrokerInfoFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = brokerInfoDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            brokerInfoDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前经纪商信息吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/base/brokerInfo/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        brokerInfoDataGrid.datagrid('reload');
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
    
    function searchBrokerInfoFun() {
    	brokerInfoDataGrid.datagrid('load', $.serializeObject($('#searchBrokerInfoForm')));
    }
    function cleanBrokerInfoFun() {
        $('#searchBrokerInfoForm input').val('');
        brokerInfoDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchBrokerInfoForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
            <tr>
                    <th>经纪商编码:</th>
                    <td><input name="brokerCode" placeholder="请输入经纪商编码"/></td>
                    <th>经纪商名称:</th>
                    <td><input name="brokerName" placeholder="请输入经纪商名称"/></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchBrokerInfoFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanBrokerInfoFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
	<div data-options="region:'center',border:true">
        <table id="brokerInfoDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>	
<div id="brokerInfoToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:basebrokerInfo:operator">
    <a onclick="addBrokerInfoFun();" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    </shiro:hasPermission>
</div>