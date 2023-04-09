<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#orgTradeStockKindCfgOrganizId').combotree({
            url: '${ctx}/system/organiz/tree',
            parentField: 'pid',
            lines: true,
            panelHeight: 'auto',
            value: '${model.orgId}'
        });

        $('#editOrgTradeStockKindCfgForm').form({
            url: '${ctx}/base/orgTradeStockKindCfg/save',
            onSubmit: function () {
                progressLoad();
                var isValid = $(this).form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success: function (result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.code == 200) {
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');
                    parent.$.modalDialog.handler.dialog('close');
                    parent.$.messager.alert('提示', result.message, 'info');
                } else {
                    parent.$.messager.alert('错误', result.message, 'error');
                    $('#editOrgTradeStockKindCfgForm').find('input[name="csrf"]').val(result.csrf);

                }
            }
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editOrgTradeStockKindCfgForm" method="post">
            <input name="id" type="hidden" value="${model.id}">
            <table class="grid">
                <tr>
                    <td>机构</td>
                    <td colspan="3">
                        <select id="orgTradeStockKindCfgOrganizId" name="orgId" style="width: 185px;"
                                class="easyui-validatebox easyui-textbox" data-options="required:true"></select>
                    </td>
                </tr>
                <tr>
                    <td>交易市场</td>
                    <td colspan="3">
                        <input id="marketIdEditOTSK" name="marketId" class="easyui-combobox" name="language"
                               style="width: 185px;"
                               placeholder="请选择交易市场" value="${model.marketId}" data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group',required:true">
                    </td>
                </tr>
                <tr>
                    <td>货期品种</td>
                    <td colspan="3">
                        <input id="futureKindIdEditOTSK" name="futureKindId" class="easyui-combobox" name="language"
                               style="width: 185px;"
                               placeholder="请选择货期品种" value="${model.futureKindId}" data-options="
								url: '${ctx}/base/futureKind/all', method: 'get', valueField:'id',
								textField:'kindName', groupField:'group',required:true">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>