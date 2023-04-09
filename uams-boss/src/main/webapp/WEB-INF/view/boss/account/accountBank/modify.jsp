<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#editAccountBankForm').form({
            url: '${ctx}/account/accountBank/save',
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
                    $('#editAccountBankForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        });
        $("#bankDepositEditTd").html(dictDropDownOptions('bankDeposit', 'bankDeposit', 'bankDeposit', '${model.bankDeposit}', 'required:true,', 'width:142px'));
        $("#bankDeposit").combobox({
            valueField: 'code',
            textField: 'name'
        });

        $("#statusEditTd").html(dictDropDownOptions('status', 'status', 'accountStatus', '${model.status}', 'required:true,', 'width:142px'));
        $("#status").combobox({
            valueField: 'code',
            textField: 'name'
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editAccountBankForm" method="post">
            <input name="id" type="hidden" value="${model.id}">
            <table class="grid">
                <tr>
                    <td>账户</td>
                    <td><input name="accountName" type="text" placeholder="请输入账户名" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,16]']" value="${model.accountName}">
                    </td>
                    <td>开户银行</td>
                    <td id="bankDepositEditTd">
                    </td>
                </tr>
                <tr>
                    <td>开户名</td>
                    <td><input name="bankAccountName" type="text" placeholder="请输入开户名" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,16]']" value="${model.bankAccountName}">
                    </td>
                    <td>银行帐号</td>
                    <td><input name="bankAccountNumber" type="text" placeholder="请输入银行帐号" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,32]']"
                               value="${model.bankAccountNumber}"></td>
                </tr>

                <tr>
                    <td>联行号</td>
                    <td><input name="branchBankNo" type="text" placeholder="请输入联行号" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.branchBankNo}">
                    </td>
                    <td>手机号码</td>
                    <td><input name="mobilePhone" type="text" placeholder="请输入手机号码" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,16]']" value="${model.mobilePhone}">
                    </td>
                </tr>

                <tr>
                    <td>银行卡正面照</td>
                    <td><input name="frontSideBankCardPhoto" type="text" placeholder="请输入银行卡正面照"
                               class="easyui-validatebox" style="width: 185px;"
                               data-options="required:true,validType:['length[0,32]']"
                               value="${model.frontSideBankCardPhoto}"></td>
                    <td>银行卡背面照</td>
                    <td><input name="backSideBankCardPhoto" type="text" placeholder="请输入银行卡背面照"
                               class="easyui-validatebox" style="width: 185px;"
                               data-options="required:true,validType:['length[0,32]']"
                               value="${model.backSideBankCardPhoto}"></td>

                </tr>
                <tr>
                    <td>状态</td>
                    <td id="statusEditTd"></td>
                    <td>省</td>
                    <td><input name="province" type="text" placeholder="请输入省" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,16]']" value="${model.province}"></td>
                </tr>
                <tr>

                    <td>市</td>
                    <td><input name="city" type="text" placeholder="请输入市" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,16]']" value="${model.city}"></td>
                    <td>县区</td>
                    <td><input name="district" type="text" placeholder="请输入县区" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,16]']" value="${model.district}"></td>
                </tr>

                <tr>
                    <td>开户银行地址</td>
                    <td><input name="bankAddress" type="text" placeholder="请输入开户银行地址" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.bankAddress}">
                    </td>
                    <td>备注</td>
                    <td><input name="remark" type="text" placeholder="请输入备注" class="easyui-validatebox"
                               style="width: 185px;"
                               data-options="required:true,validType:['length[0,32]']" value="${model.remark}"></td>
                </tr>

            </table>
        </form:form>
    </div>
</div>