<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#editFutureInfoForm').form({
            url: '${ctx}/base/futureInfo/save',
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
                    $('#editFutureInfoForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        });

        $("#statusEditTd").html(dictDropDownOptions('status', 'status', 'futuresContractStatus', '${model.status}', 'required:true,', 'width:142px'));
        $("#status").combobox({
            valueField: 'code',
            textField: 'name'
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editFutureInfoForm" method="post">
            <input name="id" type="hidden" value="${model.id}">
            <table class="grid">
                <tr>
                    <td>证券内码</td>
                    <td colspan="3">
                        <input   id="interCodeEditOTCC" name="interCode"  class="easyui-combobox" name="language" style="width: 185px;"
                                 placeholder="请选择证券内码"  value="${model.interCode}" data-options="
								url: '${ctx}/base/stockInfo/all', method: 'get', valueField:'interCode',
								textField:'interCode', groupField:'group',required:true"  >
                    </td>
                    <td>期货品种</td>
                    <td colspan="3">
                        <input   id="futureKindIdEditOTCC" name="futureKindId"  class="easyui-combobox" name="language" style="width: 185px;"
                                 placeholder="请选择期货品种"  value="${model.futureKindId}" data-options="
								url: '${ctx}/base/futureKind/all', method: 'get', valueField:'id',
								textField:'kindName', groupField:'group',required:true"  >
                    </td>
                </tr>
                <tr>
                    <td>交易市场</td>
                    <td colspan="3">
                        <input  id="marketIdEditFutureKind" name="marketId"  class="easyui-combobox" name="language" style="width: 185px;"
                                placeholder="请选择交易市场"  value="${model.marketId}" data-options="
								url: '${ctx}/base/marketInfo/all', method: 'get', valueField:'id',
								textField:'marketName', groupField:'group',required:true"  >
                    </td>
                    <td>合约月份</td>
                    <td colspan="3"><input name="contractMonth" type="text" placeholder="请输入合约月份YYYYMM" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:0" value="${model.contractMonth}"></td>
                </tr>

                <tr>
                    <td>是否主力合约</td>
                    <td>
                        <select id="isMainContract" class="easyui-combobox" required name="isMainContract" style="width:142px;" value="${model.isMainContract?'1':"0"}">
                            <option ${model.isMainContract?'selected':""} value="1">是</option>
                            <option  ${model.isMainContract?'':"selected"} value="0">否</option>
                        </select>
                    </td>

                </tr>
                <tr>
                    <td>标的物市场</td>
                    <td colspan="3"><input name="targetMarketId" type="text" placeholder="请输入标的物市场" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:0" value="${model.targetMarketId}"></td>

                    <td>标的物证券代码</td>
                    <td colspan="3"><input name="targetStockCode" type="text" placeholder="请输入标的物证券代码" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,validType:['length[0,32]']" value="${model.targetStockCode}"></td>
                </tr>
                <tr>


                    <td>合约乘数</td>
                    <td colspan="3"><input name="multiple" type="text" placeholder="请输入合约乘数" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:0" value="${model.multiple}"></td>
                    <td>最后交易日</td>
                    <td colspan="3"><input name="lastTradeDate" type="text" placeholder="请输入最后交易日YYYYMMDD" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:0" value="${model.lastTradeDate}"></td>
                </tr>
                <tr>


                    <td>交割日</td>
                    <td colspan="3"><input name="lastSettlementDate" type="text" placeholder="请输入交割日YYYYMMDD" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:0" value="${model.lastSettlementDate}"></td>
                    <td>最后交易日时间</td>
                    <td colspan="3"><input name="lastTradeTime" type="text" placeholder="请输入最后交易日时间HHMMSS" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:0" value="${model.lastTradeTime}"></td>
                </tr>
                <tr>


                    <td>结算价</td>
                    <td colspan="3"><input name="price" type="text" placeholder="请输入结算价" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:2" value="${model.price}"></td>

                    <td>实时行情的结算价</td>
                    <td colspan="3"><input name="realPrice" type="text" placeholder="请输入实时行情的结算价" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:2" value="${model.realPrice}"></td>
                </tr>
                <tr>


                    <td>前结算价</td>
                    <td colspan="3"><input name="prePrice" type="text" placeholder="请输入前结算价" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:2" value="${model.prePrice}"></td>
                    <td>持仓量</td>
                    <td colspan="3"><input name="positionAmount" type="text" placeholder="请输入持仓量" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:0" value="${model.positionAmount}"></td>
                </tr>
                <tr>

                    <td>前持仓量</td>
                    <td colspan="3"><input name="prePositionAmount" type="text" placeholder="请输入前持仓量" class="easyui-validatebox easyui-textbox" style="width: 185px;"
                                           data-options="required:true,min:0,precision:0" value="${model.prePositionAmount}"></td>

                    <td>期货合约状态</td>
                    <td id="statusEditTd">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>