<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#editBrokerInfoForm').form({
            url: '${ctx}/base/brokerInfo/save',
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
                    $('#editBrokerInfoForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editBrokerInfoForm" method="post">
            <input name="id" type="hidden" value="${model.id}">
            <table class="grid">
                <tr>
                    <td>经纪商编码</td>
                    <td colspan="3">
                        <input name="brokerCode" type="text" placeholder="请输入经纪商编码" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.brokerCode}">
                    </td>
                </tr>
                <tr>
                    <td>经纪商名称</td>
                    <td colspan="3"><input name="brokerName" type="text" placeholder="请输入经纪商名称" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,validType:['length[0,16]']" value="${model.brokerName}"></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>