<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#editStockInfoForm').form({
            url: '${ctx}/base/stockInfo/save',
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
                    $('#editStockInfoForm').find('input[name="csrf"]').val(result.csrf);

                }
            }
        });
        $("#stockTypeEditTd").html(dictDropDownOptions('stockType', 'stockType', 'stockType', '${model.stockType}', 'required:true,', 'width:142px'));
        $("#stockType").combobox({
            valueField: 'code',
            textField: 'name'
        });

        $("#canAssetClassTd").html(dictDropDownOptions('assetClass', 'assetClass', 'assetClass', '${model.assetClass}', 'required:true,', 'width:142px'));
        $("#assetClass").combobox({
            valueField: 'code',
            textField: 'name'
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editStockInfoForm" method="post">
            <input name="id" type="hidden" value="${model.id}">
            <table class="grid">
                <tr>
                    <td>交易市场</td>
                    <td>
                        <input  id="marketIdEditStockInfo" name="marketId"  class="easyui-combobox" name="language" style="width: 140px;"
                                placeholder="请选择交易市场"  value="${model.marketId}" data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group',required:true"  >
                    </td>
                    <td>证券内码</td>
                    <td>
                        <input name="interCode" type="text" placeholder="请输入证券内码" class="easyui-validatebox easyui-textbox" style="width: 140px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.interCode}">
                    </td>
                </tr>
                <tr>
                    <td>证券代码</td>
                    <td>
                        <input name="stockCode" type="text" placeholder="请输入证券代码" class="easyui-validatebox easyui-textbox" style="width: 140px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.stockCode}">
                    </td>
                    <td>证券简称</td>
                    <td>
                        <input name="stockName" type="text" placeholder="请输入证券简称" class="easyui-validatebox easyui-textbox" style="width: 140px;"
                                           data-options="required:true,validType:['length[0,16]']" value="${model.stockName}">
                    </td>
                </tr>
                <tr>
                    <td>证券全称</td>
                    <td>
                        <input name="stockFullName" type="text" placeholder="请输入证券全称" class="easyui-validatebox easyui-textbox" style="width: 140px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.stockFullName}"></td>
                    </td>
                    <td>证券拼音码</td>
                    <td>
                        <input name="stockSpell" type="text" placeholder="请输入证券拼音码" class="easyui-validatebox easyui-textbox" style="width: 140px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.stockSpell}">
                    </td>
                </tr>
                <tr>
                    <td>证券类型</td>
                    <td id="stockTypeEditTd">
                    </td>
                    <td>资产类别</td>
                    <td id="canAssetClassTd">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>