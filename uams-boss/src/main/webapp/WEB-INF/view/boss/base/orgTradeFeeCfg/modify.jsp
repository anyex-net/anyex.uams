<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#orgTradeFeeCfgOrganizId').combotree({
            url : '${ctx}/system/organiz/tree',
            parentField : 'pid',
            lines : true,
            panelHeight : 'auto',
            value : '${model.orgId}'
        });

        $('#editOrgTradeFeeCfgForm').form({
            url : '${ctx}/base/orgTradeFeeCfg/save',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success : function(result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.code == 200) {
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');
                    parent.$.modalDialog.handler.dialog('close');
                    parent.$.messager.alert('提示', result.message, 'info');
                } else {
                    parent.$.messager.alert('错误', result.message, 'error');
                    $('#editOrgTradeFeeCfgForm').find('input[name="csrf"]').val(result.csrf);

                }
            }
        });

        $("#feeTypeEditTd").html(dictDropDownOptions('feeType', 'feeType', 'feeType', '${model.feeType}', 'required:true,', 'width:142px'));
        $("#feeType").combobox({
            valueField: 'code',
            textField: 'name'
        });

        $("#feeRateTypeEditTd").html(dictDropDownOptions('feeRateType', 'feeRateType', 'feeRateType', '${model.feeRateType}', 'required:true,', 'width:142px'));
        $("#feeRateType").combobox({
            valueField: 'code',
            textField: 'name'
        });

    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editOrgTradeFeeCfgForm" method="post">
            <input type="hidden" id="id" name="id" value="${model.id}"/>
            <table class="grid">
                <tr>
                    <td>机构</td>
                    <td colspan="3">
                        <select id="orgTradeFeeCfgOrganizId" name="orgId" style="width: 185px;"
                                class="easyui-validatebox easyui-textbox" data-options="required:true"></select>
                    </td>
                </tr>
                <tr>
                    <td>交易市场</td>
                    <td colspan="3">
                        <input   id="marketIdEditOTCC" name="marketId"  class="easyui-combobox" name="language" style="width: 185px;"
                                placeholder="请选择交易市场"  value="${model.marketId}" data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group',required:true"  >
                    </td>
                </tr>
                <tr>
                    <td>期货品种</td>
                    <td colspan="3">
                        <input   id="futureKindIdEditOTCC" name="futureKindId"  class="easyui-combobox" name="language" style="width: 185px;"
                                placeholder="请选择期货品种"  value="${model.futureKindId}" data-options="
								url: '${ctx}/base/futureKind/all', method: 'get', valueField:'id',
								textField:'kindName', groupField:'group',required:true"  >
                    </td>
                </tr>
                <tr>
                    <td>费用类型</td>
                    <td id="feeTypeEditTd">
                    </td>
                </tr>
                <tr>
                    <td>费率类型</td>
                    <td id="feeRateTypeEditTd">
                    </td>
                </tr>

                <tr>
                    <td>费率</td>
                    <td>
                        <input id="feeRate"  name="feeRate"  type="text" placeholder="请输入费率" class="easyui-numberbox"
                               data-options="required:true,min:0,precision:0" value="${model.feeRate}"  style="width:142px;">
                    </td>
                </tr>

            </table>
        </form:form>
    </div>
</div>