<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#editExchangeRateForm').form({
            url: '${ctx}/base/exchangeRate/save',
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
                    $('#editExchangeRateForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        });
        $("#currencySourceEditTd").html(dictDropDownOptions('currencySource', 'currencySource', 'currency', '${model.currencySource}', 'required:true,', 'width:142px'));
        $("#currencySource").combobox({
            valueField: 'code',
            textField: 'name'
        });
        $("#currencyTargetEditTd").html(dictDropDownOptions('currencyTarget', 'currencyTarget', 'currency', '${model.currencyTarget}', 'required:true,', 'width:142px'));
        $("#currencyTarget").combobox({
            valueField: 'code',
            textField: 'name'
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editExchangeRateForm" method="post">
            <input type="hidden" id="id" name="id" value="${model.id}" />
            <table class="grid">
                <tr>
                    <td>源币种</td>
                    <td id="currencySourceEditTd">
                    </td>
                    <td>目标币种</td>
                    <td id="currencyTargetEditTd">
                    </td>
                </tr>
                <tr>
                    <td>汇率日期</td>
                    <td>
                        <input id="exchangDate"  name="date"  type="text" placeholder="请输入汇率日期" class="easyui-datebox"
                               data-options="required:true" value="<fmt:formatDate value="${model.exchangDate}" pattern="yyyy-MM-dd"/>"  style="width:142px;">
                    </td>
                    <td>最小单位</td>
                    <td>
                        <input id="unitAmount"  name="unitAmount"  type="text" placeholder="请输入最小单位" class="easyui-numberbox"
                               data-options="required:true,min:0,precision:0" value="${model.unitAmount}"  style="width:142px;">
                    </td>
                </tr>
                <tr>
                    <td>买入价</td>
                    <td>
                        <input id="buyPrice"  name="buyPrice"  type="text" placeholder="请输入买入价" class="easyui-numberbox"
                               data-options="required:true,min:0,precision:2" value="${model.buyPrice}"  style="width:142px;">
                    </td>
                    <td>卖出价</td>
                    <td>
                        <input id="sellPrice"  name="sellPrice"  type="text" placeholder="请输入卖出价" class="easyui-numberbox"
                               data-options="required:true,min:0,precision:2" value="${model.sellPrice}"  style="width:142px;">
                    </td>
                </tr>
                <tr>
                    <td>中间价</td>
                    <td>
                        <input id="midPrice"  name="midPrice"  type="text" placeholder="请输入中间价" class="easyui-numberbox"
                               data-options="required:true,min:0,precision:2  " value="${model.midPrice}"  style="width:142px;">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>