<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#editFutureKindForm').form({
            url: '${ctx}/base/futureKind/save',
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
                    $('#editFutureKindForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editFutureKindForm" method="post">
            <input name="id" type="hidden" value="${model.id}">
            <table class="grid">
                <tr>
                    <td>交易市场</td>
                    <td colspan="3">
                        <input  id="marketIdEditFutureKind" name="marketId"  class="easyui-combobox" name="language" style="width: 185px;"
                                placeholder="请选择交易市场"  value="${model.marketId}" data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group',required:true"  >
                    </td>
                </tr>
                <tr>
                    <td>期货品种编码</td>
                    <td colspan="3">
                        <input name="kindCode" type="text" placeholder="请输入期货品种编码" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.kindCode}">
                    </td>
                </tr>
                <tr>
                    <td>期货品种名称</td>
                    <td colspan="3"><input name="kindName" type="text" placeholder="请输入期货品种名称" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,validType:['length[0,16]']" value="${model.kindName}"></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>