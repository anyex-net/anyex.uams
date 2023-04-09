<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#editMarketTradeDayForm').form({
            url: '${ctx}/base/marketTradeDay/save',
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
                    $('#editMarketTradeDayForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editMarketTradeDayForm" method="post">
            <input type="hidden" id="id" name="id" value="${model.id}"/>
            <table class="grid">
                <tr>
                    <td>交易市场</td>
                    <td>
                        <input id="marketIdEditFutureKind" name="marketId" class="easyui-combobox" name="language"
                               style="width: 330px;"
                               placeholder="请选择交易市场" value="${model.marketId}" data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group',required:true">
                    </td>
                </tr>
                <tr>
                    <td>货期品种</td>
                    <td>
                        <input id="futureKindIdEditMarketTradeDay" name="futureKindId" class="easyui-combobox"
                               name="language" style="width: 330px;"
                               placeholder="请选择货期品种" value="${model.futureKindId}" data-options="
								url: '${ctx}/base/futureKind/all', method: 'get', valueField:'id',
								textField:'kindName', groupField:'group',required:true">
                    </td>
                </tr>
                <tr>
                    <td>是否交易日</td>
                    <td>
                        <select id="isTradeDay" class="easyui-combobox" required name="isTradeDay" style="width:330px;"
                                value="${model.isTradeDay?'1':"0"}">
                            <option ${model.isTradeDay?'selected':""} value="1">是</option>
                            <option  ${model.isTradeDay?'':"selected"} value="0">否</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    </td>
                    <td>自然日</td>
                    <td>
                        <input name="natureDay" type="text" placeholder="请输入自然日" class="easyui-numberbox"
                               data-options="required:true,min:0,precision:0" value="${model.natureDay}"
                               style="width:330px;">
                    </td>
                </tr>
                <tr>
                    <td>星期几</td>
                    <td>
                        <input name="week" type="text" placeholder="请输入星期" class="easyui-numberbox"
                               data-options="required:true,min:0,precision:0" value="${model.week}"
                               style="width:330px;">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>