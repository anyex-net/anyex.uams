<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var orgTradeFeeCfgDataGrid;
    var ctfTree;
    $(function () {
        ctfTree = $('#ctfTree').tree({
            url: '${ctx}/system/organiz/tree',
            parentField: 'pid',
            lines: true,
            onClick: function (node) {
                orgTradeFeeCfgDataGrid.datagrid('load', {
                    orgId: node.id
                });
            },
            onLoadSuccess:function (node, data) {
                orgTradeFeeCfgDataGrid = $('#orgTradeFeeCfgDataGrid').datagrid({
                    url: '${ctx}/base/orgTradeFeeCfg/data',
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
                        title: '费用类型',
                        field: 'feeType',
                        formatter: function (value, row, index) {
                            return getDictValueByCode(value);
                        }
                    }, {
                        width: '120',
                        title: '费率类型',
                        field: 'feeRateType',
                        formatter: function (value, row, index) {
                            return getDictValueByCode(value);
                        }
                    }, {
                        width: '120',
                        title: '费率',
                        field: 'feeRate'
                    }<shiro:hasPermission name="system:setting:baseorgTradeFeeCfg:operator">
                        , {
                            field: 'action',
                            title: '操作',
                            width: 250,
                            formatter: function (value, row, index) {
                                var str = '';
                                str += $.formatString('<a href="javascript:void(0)" class="orgTradeFeeCfg-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editOrgTradeFeeCfgFun(\'{0}\');" >编辑</a>', row.id);
                                str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                                str += $.formatString('<a href="javascript:void(0)" class="orgTradeFeeCfg-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteOrgTradeFeeCfgFun(\'{0}\');" >删除</a>', row.id);
                                return str;
                            }
                        }
                        </shiro:hasPermission>
                    ]],
                    onLoadSuccess: function (data) {
                        <shiro:hasPermission name="system:setting:baseorgTradeFeeCfg:operator">

                        $('.orgTradeFeeCfg-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                        $('.orgTradeFeeCfg-easyui-linkbutton-del').linkbutton({text: '删除'});
                        </shiro:hasPermission>
                    },
                    toolbar: '#orgTradeFeeCfgToolbar'
                });
            }
        });

        $("#feeTypeListTd").html(dictDropDownOptionsList('feeTypeList', 'feeType', 'feeType', '${model.feeType}', 'required:true,', 'width:142px'));
        $("#feeTypeList").combobox({
            valueField: 'code',
            textField: 'name'
        });
        $("#feeRateTypeListTd").html(dictDropDownOptionsList('feeRateTypeList', 'feeRateType', 'feeRateType', '${model.feeRateType}', 'required:true,', 'width:142px'));
        $("#feeRateTypeList").combobox({
            valueField: 'code',
            textField: 'name'
        });
    });

    function addOrgTradeFeeCfgFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 400,
            height: 350,
            href: '${ctx}/base/orgTradeFeeCfg/modify',
            buttons: [{
                text: '添加',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = orgTradeFeeCfgDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editOrgTradeFeeCfgForm');
                    f.submit();
                }
            }]
        });
    }

    function deleteOrgTradeFeeCfgFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = orgTradeFeeCfgDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            orgTradeFeeCfgDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前交易费率信息吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${ctx}/base/orgTradeFeeCfg/del', {
                    ids: id
                }, function (result) {
                    if (result.code = 200) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        orgTradeFeeCfgDataGrid.datagrid('reload');
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

    function editOrgTradeFeeCfgFun(id) {
        if (id == undefined) {
            var rows = orgTradeFeeCfgDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            orgTradeFeeCfgDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 400,
            height: 350,
            href: '${ctx}/base/orgTradeFeeCfg/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = orgTradeFeeCfgDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#editOrgTradeFeeCfgForm');
                    f.submit();
                }
            }]
        });
    }

    function searchOrgTradeFeeCfgFun() {
        orgTradeFeeCfgDataGrid.datagrid('load', $.serializeObject($('#searchOrgTradeFeeCfgForm')));
    }
    function cleanOrgTradeFeeCfgFun() {
        $('#searchOrgTradeFeeCfgForm input').val('');
        orgTradeFeeCfgDataGrid.datagrid('load', {});
    }
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchOrgTradeFeeCfgForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>交易市场:</th>
                    <td><input  id="marketIdListOrgTradeFeeCfg" name="marketId"  class="easyui-combobox" name="language" style="width: 185px;"
                                placeholder="请选择交易市场"  data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group'"  ></td>

                    <td>费用类型</td>
                    <td id="feeTypeListTd">
                    </td>

                    <td>费率类型</td>
                    <td id="feeRateTypeListTd">
                    </td>

                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchOrgTradeFeeCfgFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanOrgTradeFeeCfgFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'交易费率'">
        <table id="orgTradeFeeCfgDataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div data-options="region:'west',border:true,split:false,title:'组织机构'" style="width:150px;overflow: hidden; ">
        <ul id="ctfTree" style="width:160px;margin: 10px 10px 10px 10px"></ul>
    </div>
</div>
<div id="orgTradeFeeCfgToolbar" style="display: none;">
    <shiro:hasPermission name="system:setting:baseorgTradeFeeCfg:operator">
        <a onclick="addOrgTradeFeeCfgFun();" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>

    </shiro:hasPermission>
</div>
<jsp:include page="/commons/setup_ajax.jsp"></jsp:include>