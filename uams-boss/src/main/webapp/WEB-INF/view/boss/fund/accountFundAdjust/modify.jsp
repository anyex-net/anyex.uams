<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#editAccountFundAdjustForm').form({
            url: '${ctx}/fund/accountFundAdjust/save',
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
                var result = $.parseJSON(result);
                if (result.code == ajax_result_success_code) {
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');
                    parent.$.modalDialog.handler.dialog('close');
                    parent.$.messager.alert('提示', result.message, 'info');
                } else {
                    parent.$.messager.alert('错误', result.message, 'error');
                    $('#editAccountFundAdjustForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        });
        $("#currencyEditTd").html(dictDropDownOptions('currency', 'currency', 'currency', '${model.currency}', 'required:true,', 'width:185px,'));
        $("#currency").combobox({
            valueField: 'code',
            textField: 'name'
        });
        $("#adjustTypeEditTd").html(dictDropDownOptions('adjustType', 'adjustType', 'adjustType', '${model.adjustType}', 'required:true,', 'width:185px,'));
        $("#adjustType").combobox({
            valueField: 'code',
            textField: 'name'
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editAccountFundAdjustForm" method="post">
            <input name="id" type="hidden" value="${model.id}">
            <table class="grid">
                <tr>
                    <td>账户</td>
                    <td>
                        <input id="accountIdEditAccountBank" name="accountId" class="easyui-combobox" name="language"
                               style="width: 185px;"
                               placeholder="请选择账户" value="${model.accountId}" data-options="
								url: '${ctx}/account/account/all', method: 'get', valueField:'id',
								textField:'accountName', groupField:'group',required:true">
                    </td>
                </tr>
                <tr>
                    <td>币种</td>
                    <td id="currencyEditTd">
                    </td>
                </tr>
                <tr>
                    <td>调整类型</td>
                    <td id="adjustTypeEditTd">
                    </td>
                </tr>
                <tr>

                    <td>调整金额数量</td>
                    <td><input name="adjustAmt" type="text" placeholder="请输入调整金额数量" class="easyui-numberbox"
                               style="width: 185px;"
                               data-options="required:true,min:0,precision:0"
                               value="${model.adjustAmt}"></td>
                </tr>
                <tr>

                    <td>备注</td>
                    <td><input name="remark" type="text" placeholder="请输入备注" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.remark}">
                    </td>

                </tr>


            </table>
        </form:form>
    </div>
</div>