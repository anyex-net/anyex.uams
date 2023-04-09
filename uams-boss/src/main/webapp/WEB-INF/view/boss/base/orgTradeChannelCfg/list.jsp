<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var orgTradeChannelCfgDataGrid;
    var cgfTree;
    $(function () {
        cgfTree = $('#cgfTree').tree({
            url: '${ctx}/system/organiz/tree',
            parentField: 'pid',
            lines: true,
            onClick: function (node) {
                orgTradeChannelCfgDataGrid.datagrid('load', {
                    orgId: node.id
                });
            },
            onLoadSuccess:function (node, data) {
                orgTradeChannelCfgDataGrid = $('#orgTradeChannelCfgDataGrid').datagrid({
                    url: '${ctx}/base/orgTradeChannelCfg/data',
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
                        field: 'kindName'
                    }, {
                        width: '120',
                        title: '股东代码',
                        field: 'stockHolderName'
                    }, {
                        width: '160',
                        title: '股东代码对应交易帐号',
                        field: 'tradeAcount'
                    }, {
                        width: '160',
                        title: '股东代码对应资金帐号',
                        field: 'fundAccout'
                    }<shiro:hasPermission name="system:setting:baseorgTradeChannelCfg:operator">
                        , {
                            field: 'action',
                            title: '操作',
                            width: 250,
                            formatter: function (value, row, index) {
                                var str = '';
                                str += $.formatString('<a href="javascript:void(0)" class="orgTradeChannelCfg-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editOrgTradeChannelCfgFun(\'{0}\');" >编辑</a>', row.id);
                                str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                                str += $.formatString('<a href="javascript:void(0)" class="orgTradeChannelCfg-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteOrgTradeChannelCfgFun(\'{0}\');" >删除</a>', row.id);
                                return str;
                            }
                        }
                        </shiro:hasPermission>
                    ]],
                    onLoadSuccess: function (data) {
                        <shiro:hasPermission name="system:setting:baseorgTradeChannelCfg:operator">

                        $('.orgTradeChannelCfg-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                        $('.orgTradeChannelCfg-easyui-linkbutton-del').linkbutton({text: '删除'});
                        </shiro:hasPermission>
                    },
                    toolbar: '#orgTradeChannelCfgToolbar'
                });
            }
        });
    });

    function addOrgTradeChannelCfgFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 400,
            height: 250,
            href: '${ctx}/base/orgTradeChannelCfg/modify',
            buttons: [{
                text: '添加',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = orgTradeChannelCfgDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editOrgTradeChannelCfgForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteOrgTradeChannelCfgFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = orgTradeChannelCfgDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            orgTradeChannelCfgDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前机构交易通道配置信息吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/base/orgTradeChannelCfg/del', {
                    ids: id
                }, function (result) {
                    if (result.code = 200) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        orgTradeChannelCfgDataGrid.datagrid('reload');
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

    function editOrgTradeChannelCfgFun(id) {
        if (id == undefined) {
            var rows = orgTradeChannelCfgDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            orgTradeChannelCfgDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 350,
            height: 250,
            href: '${ctx}/base/orgTradeChannelCfg/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = orgTradeChannelCfgDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editOrgTradeChannelCfgForm');
                    f.submit();
                }
            }]
        });
    }

    function searchOrgTradeChannelCfgFun() {
        orgTradeChannelCfgDataGrid.datagrid('load', $.serializeObject($('#searchOrgTradeChannelCfgForm')));
    }
    function cleanOrgTradeChannelCfgFun() {
        $('#searchOrgTradeChannelCfgForm input').val('');
        orgTradeChannelCfgDataGrid.datagrid('load', {});
    }
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchOrgTradeChannelCfgForm">
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
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchOrgTradeChannelCfgFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanOrgTradeChannelCfgFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'交易通道'">
        <table id="orgTradeChannelCfgDataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div data-options="region:'west',border:true,split:false,title:'组织机构'" style="width:150px;overflow: hidden; ">
        <ul id="cgfTree" style="width:160px;margin: 10px 10px 10px 10px"></ul>
    </div>
</div>
<div id="orgTradeChannelCfgToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:baseorgTradeChannelCfg:operator">
        <a onclick="addOrgTradeChannelCfgFun();" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>

    </shiro:hasPermission>
</div>
<jsp:include page="/commons/setup_ajax.jsp"></jsp:include>