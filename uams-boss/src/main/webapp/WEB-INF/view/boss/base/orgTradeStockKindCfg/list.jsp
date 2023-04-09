<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var orgTradeStockKindCfgDataGrid;
    var orgTree;

    $(function () {
        orgTree = $('#orgTree').tree({
            url: '${ctx}/system/organiz/tree',
            parentField: 'pid',
            lines: true,
            onClick: function (node) {
                orgTradeStockKindCfgDataGrid.datagrid('load', {
                    orgId: node.id
                });
            },
            onLoadSuccess: function (node, data) {
                orgTradeStockKindCfgDataGrid = $('#orgTradeStockKindCfgDataGrid').datagrid({
                    url: '${ctx}/base/orgTradeStockKindCfg/data',
                    fit: true,
                    striped: true,
                    rownumbers: true,
                    pagination: true,
                    singleSelect: true,
                    idField: 'id',
                    pageSize: 20,
                    pageList: [10, 20, 30, 40, 50, 100],
                    columns: [[{
                        width: '140',
                        title: '机构',
                        field: 'orgName'
                    }, {
                        width: '100',
                        title: '交易市场',
                        field: 'marketName'
                    }, {
                        width: '100',
                        title: '期货品种',
                        field: 'kindName',
                    }<shiro:hasPermission name="system:setting:baseorgTradeStockKindCfg:operator">
                        , {
                            field: 'action',
                            title: '操作',
                            width: 250,
                            formatter: function (value, row, index) {
                                var str = '';
                                str += $.formatString('<a href="javascript:void(0)" class="orgTradeStockKindCfg-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editOrgTradeStockKindCfgFun(\'{0}\');" >编辑</a>', row.id);
                                str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                                str += $.formatString('<a href="javascript:void(0)" class="orgTradeStockKindCfg-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteOrgTradeStockKindCfgFun(\'{0}\');" >删除</a>', row.id);
                                return str;
                            }
                        }
                        </shiro:hasPermission>
                    ]],
                    onLoadSuccess: function (data) {
                        <shiro:hasPermission name="system:setting:baseorgTradeStockKindCfg:operator">

                        $('.orgTradeStockKindCfg-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                        $('.orgTradeStockKindCfg-easyui-linkbutton-del').linkbutton({text: '删除'});
                        </shiro:hasPermission>
                    },
                    toolbar: '#orgTradeStockKindCfgToolbar'
                });
            }
        });
    });

    function addOrgTradeStockKindCfgFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 300,
            height: 200,
            href: '${ctx}/base/orgTradeStockKindCfg/modify',
            buttons: [{
                text: '添加',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = orgTradeStockKindCfgDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editOrgTradeStockKindCfgForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteOrgTradeStockKindCfgFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = orgTradeStockKindCfgDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            orgTradeStockKindCfgDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前机构交易品种配置信息吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/base/orgTradeStockKindCfg/del', {
                    ids: id
                }, function (result) {
                    if (result.code = 200) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        orgTradeStockKindCfgDataGrid.datagrid('reload');
                    } else {
                        parent.$.messager.alert('错误', result.object, 'error');
                    }
                    $('#csrf-form').find('input[name="csrf"]').val(result.csrf);
                    setCsrfToken("csrf-form");
                    progressClose();
                }, 'JSON');
            }
        });
    }

    function editOrgTradeStockKindCfgFun(id) {
        if (id == undefined) {
            var rows = orgTradeStockKindCfgDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            orgTradeStockKindCfgDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 300,
            height: 200,
            href: '${ctx}/base/orgTradeStockKindCfg/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = orgTradeStockKindCfgDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editOrgTradeStockKindCfgForm');
                    f.submit();
                }
            }]
        });
    }

    function searchOrgTradeStockKindCfgFun() {
        orgTradeStockKindCfgDataGrid.datagrid('load', $.serializeObject($('#searchOrgTradeStockKindCfgForm')));
    }

    function cleanOrgTradeStockKindCfgFun() {
        $('#searchOrgTradeStockKindCfgForm input').val('');
        orgTradeStockKindCfgDataGrid.datagrid('load', {});
    }
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchOrgTradeStockKindCfgForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>交易市场:</th>
                    <td><input id="marketIdListOrgTradeStockKindCfg" name="marketId" class="easyui-combobox"
                               name="language" style="width: 185px;"
                               placeholder="请选择交易市场" data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group'"></td>
                    <th>期货品种:</th>
                    <td><input id="futureKindIdListOrgTradeStockKindCfg" name="futureKindId" class="easyui-combobox"
                               name="language" style="width: 185px;"
                               placeholder="请选择期货品种" data-options="
								url: '${ctx}/base/futureKind/all', method: 'get', valueField:'id',
								textField:'kindName', groupField:'group'"></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true"
                           onclick="searchOrgTradeStockKindCfgFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true"
                           onclick="cleanOrgTradeStockKindCfgFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'交易品种'">
        <table id="orgTradeStockKindCfgDataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div data-options="region:'west',border:true,split:false,title:'组织机构'" style="width:150px;overflow: hidden; ">
        <ul id="orgTree" style="width:160px;margin: 10px 10px 10px 10px"></ul>
    </div>
</div>
<div id="orgTradeStockKindCfgToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:baseorgTradeStockKindCfg:operator">
        <a onclick="addOrgTradeStockKindCfgFun();" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    </shiro:hasPermission>
</div>
<jsp:include page="/commons/setup_ajax.jsp"></jsp:include>