<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#editStockHolderForm').form({
            url: '${ctx}/base/stockHolder/save',
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
                    $('#editStockHolderForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        });

    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editStockHolderForm" method="post">
            <input type="hidden" id="id" name="id" value="${model.id}"/>
            <table class="grid">
                <tr>
                    <td>交易市场</td>
                    <td>
                        <input id="marketIdEditStockHolder" name="marketId" class="easyui-combobox" name="language"
                               style="width: 160px;"
                               placeholder="请选择交易市场" value="${model.marketId}" data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group',required:true">
                    </td>
                    <td>经纪商</td>
                    <td>
                        <input id="brokerIdEditStockHolder" name="brokerId" class="easyui-combobox" name="language"
                               style="width: 160px;"
                               placeholder="请选择经纪商期货" value="${model.brokerId}" data-options="
								url: '${ctx}/base/brokerInfo/all', method: 'get', valueField:'id',
								textField:'brokerName', groupField:'group',required:true">
                    </td>

                </tr>
                <tr>
                    <td>股东代码</td>
                    <td colspan="3"><input name="stockHolderName" type="text" placeholder="请输入股东代码名称"
                                           class="easyui-validatebox easyui-textbox" style="width: 385px;"
                                           data-options="required:true,validType:['length[0,32]']"
                                           value="${model.stockHolderName}"></td>
                    </td>
                </tr>

                <tr>
                    <td>交易账号</td>
                    <td colspan="3"><input name="tradeAcount" type="text" placeholder="请输入交易账号"
                                           class="easyui-validatebox easyui-textbox" style="width: 385px;"
                                           data-options="required:true,validType:['length[0,32]']"
                                           value="${model.tradeAcount}"></td>
                    </td>
                </tr>
                <tr>
                    <td>资金帐号</td>
                    <td colspan="3"><input name="fundAccout" type="text" placeholder="请输入资金帐号"
                                           class="easyui-validatebox easyui-textbox" style="width: 385px;"
                                           data-options="required:true,validType:['length[0,32]']"
                                           value="${model.fundAccout}"></td>
                    </td>
                </tr>

                <tr>
                    <td>开户日期</td>
                    <td colspan="3"><input name="openDate" type="text" placeholder="请输入开户日期" class="easyui-numberbox"
                                           style="width: 390px;"
                                           data-options="required:true,min:0,precision:0" value="${model.openDate}">
                    </td>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>