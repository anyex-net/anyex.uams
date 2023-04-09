<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#editMarketInfoForm').form({
            url: '${ctx}/base/marketInfo/save',
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
                    $('#editMarketInfoForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        });

        $("#countryNoEditTd").html(dictDropDownOptions('countryNo', 'countryNo', 'region', '${model.countryNo}', 'required:true,', 'width:142px'));
        $("#countryNo").combobox({
            valueField: 'code',
            textField: 'name'
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editMarketInfoForm" method="post">
            <table class="grid">
                <tr>
                    <td>交易市场编码</td>
                    <td colspan="3">
                        <input name="id" type="hidden" value="${model.id}">
                        <input name="marketCode" type="text" placeholder="请输入交易市场编码" class="easyui-validatebox easyui-textbox" style="width: 385px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.marketCode}">
                    </td>
                </tr>
                <tr>
                    <td>交易市场简称</td>
                    <td colspan="3"><input name="marketName" type="text" placeholder="请输入交易市场简称" class="easyui-validatebox easyui-textbox" style="width: 385px;"
                                           data-options="required:true,validType:['length[0,16]']" value="${model.marketName}"></td>
                </tr>
                <tr>
                    <td>交易市场全称</td>
                    <td colspan="3"><input name="marketFullName" type="text" placeholder="请输入交易市场全称" class="easyui-validatebox easyui-textbox" style="width: 385px;"
                                           data-options="required:true,validType:['length[0,32]']" value="${model.marketFullName}"></td>
                </tr>
                <tr>
                    <td>市场代码</td>
                    <td colspan="3">
                        <input name="exchangeCode" type="text" placeholder="请输入市场代码" class="easyui-validatebox easyui-textbox" style="width: 385px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.exchangeCode}"></td>
                    </td>
                </tr>
                <tr>
                    <td>国家或地区</td>
                    <td id="countryNoEditTd">
                    </td>
                    <td>停市标志</td>
                    <td>
                        <select id="isStop" class="easyui-combobox" required name="isStop" style="width:142px;" value="${model.isStop?'1':"0"}">
                            <option ${model.isStop?'selected':""} value="1">是</option>
                            <option  ${model.isStop?'':"selected"} value="0">否</option>
                        </select>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>