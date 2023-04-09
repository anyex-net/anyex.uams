<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#belongOrgId').combotree({
            url : '${ctx}/system/organiz/tree',
            parentField : 'pid',
            lines : true,
            panelHeight : 'auto',
            value : '${model.belongOrgId}'
        });
        $('#editAccountManageForm').form({
            url : '${ctx}/account/account/save',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success : function(result) {
                progressClose();
                var result = $.parseJSON(result);
                if (result.code == ajax_result_success_code) {
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');
                    parent.$.modalDialog.handler.dialog('close');
                } else {
                    parent.$.messager.alert('错误', result.message, 'error');
                    $('#editAccountManageForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        }); 
        
        $("#accountTypeEditTd").html(dictDropDownOptions('accountTypeEdit','accountType', 'accountType','${model.accountType}', 'required:true,', 'width:142px'));
        $("#accountTypeEdit").combobox({
            valueField:'code',
            textField:'name'
        });
        $("#langEditTd").html(dictDropDownOptions('langEdit', 'lang','langType','${model.lang}', 'required:true,', 'width:142px'));
        $("#langEdit").combobox({
            valueField:'code',
            textField:'name'
        });
        $("#certificateTypeEditTd").html(dictDropDownOptions('certificateTypeEdit', 'certificateType','certificateType','${model.certificateType}', 'required:true,', 'width:142px'));
        $("#certificateTypeEdit").combobox({
            valueField:'code',
            textField:'name'
        });
        $("#riskLevelEditTd").html(dictDropDownOptions('riskLevelEdit', 'riskLevel','riskLevel','${model.riskLevel}', 'required:true,', 'width:142px'));
        $("#riskLevelEdit").combobox({
            valueField:'code',
            textField:'name'
        });
        $("#countryEditTd").html(dictDropDownOptions('countryEdit', 'country','region','${model.country}', 'required:true,', 'width:142px'));
        $("#countryEdit").combobox({
            valueField:'code',
            textField:'name'
        });
        $("#operatorCertificateTypeEditTd").html(dictDropDownOptions('operatorCertificateTypeEdit', 'operatorCertificateType','certificateType','${model.operatorCertificateType}', 'required:true,', 'width:142px'));
        $("#operatorCertificateTypeEdit").combobox({
            valueField:'code',
            textField:'name'
        });
        $("#accountStatusEditTd").html(dictDropDownOptions('accountStatusEdit','accountStatus', 'accountStatus','${model.accountStatus}', '',  'width:142px,'));
        $("#accountStatusEdit").combobox({
            valueField:'code',
            textField:'name'
        });


        $("#editAccountManageForm").parent().css("overflow-y","scroll");

    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editAccountManageForm" method="post">
        	<input id="id" name="id" type="hidden" value="${model.id}"/>
            <table class="grid">
                <tr>
                    <td>账户类型</td>
                    <td id="accountTypeEditTd">
                    </td>
                    <td>账户名</td>
                    <td>
                        <input name="accountName" type="text" placeholder="请输入账户名" style="width:142px;" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,64]']" value="${model.accountName}">
                    </td>
                    <td>证件类型</td>
                    <td id="certificateTypeEditTd">
                    </td>
                    <td>证件号码</td>
                    <td>
                        <input name="certificateNumber" type="text" placeholder="请输入证件号码" style="width:142px;" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,30]']" value="${model.certificateNumber}">
                    </td>
                </tr>
                <tr>
                    <td>出生年月</td>
                    <td>
                        <input name="dateBirth" type="text" placeholder="请输入出生年月" style="width:142px;" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,min:0,precision:0" value="${model.dateBirth}">
                    </td>
                    <td>联系电话</td>
                    <td>
                        <input name="contactNumber" type="text" placeholder="请输入联系电话" style="width:142px;" class="easyui-numberbox"
                               data-options="required:true,validType:['length[0,30]']" value="${model.contactNumber}">
                    </td>
                    <td>手机号</td>
                    <td>
                        <input name="mobilePhone" type="text" placeholder="请输入手机号" style="width:142px;" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,25]']" value="${model.mobilePhone}">
                    </td>
                    <td>电子邮箱</td>
                    <td>
                        <input name="email" type="text" placeholder="请输入电子邮箱" style="width:142px;" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,127]']" value="${model.email}">
                    </td>
                </tr>
                <tr>
                    <td>邮政编码</td>
                    <td>
                        <input name="postCode"  type="text" placeholder="请输入邮政编码" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,10]']" value="${model.postCode}"  style="width:142px;">
                    </td>
                    <td>联系地址</td>
                    <td>
                        <input name="contactAddress"  type="text" placeholder="请输入联系地址" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,64]']" value="${model.contactAddress}"  style="width:142px;">
                    </td>
                    <td>证件正面照</td>
                    <td>
                        <input name="frontSideIDPhoto"  type="text" placeholder="请上传证件正面照" class="easyui-validatebox easyui-textbox"
                               data-options="required:true" value="${model.frontSideIDPhoto}"  style="width:142px;">
                    </td>
                    <td>证件背面照</td>
                    <td>
                        <input name="backSideIDPhoto" type="text" placeholder="请上传证件背面照" style="width:142px;" class="easyui-validatebox easyui-textbox"
                               data-options="required:true" value="${model.backSideIDPhoto}">
                    </td>
                </tr>
                <tr>
                    <td>手持证件照</td>
                    <td>
                        <input name="handWithIDPhoto"  type="text" placeholder="请上传手持证件照" class="easyui-validatebox easyui-textbox"
                               data-options="required:true" value="${model.handWithIDPhoto}"  style="width:142px;">
                    </td>
                    <td>风险等级</td>
                    <td id="riskLevelEditTd">
                    </td>
                    <td>语言类型</td>
                    <td id="langEditTd">
                    </td>
                   <td>国家地区</td>
                   <td id="countryEditTd">
                   </td>
                </tr>
                <tr>
                   <td>省</td>
                    <td>
                        <input name="province"  type="text" placeholder="请输入省" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,64]']" value="${model.province}"  style="width:142px;">
                    </td>
                    <td>市</td>
                    <td>
                        <input name="city" type="text" placeholder="请输入市" style="width:142px;" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,64]']" value="${model.city}">
                    </td>

                    <td>县</td>
                    <td>
                        <input name="district"  type="text" placeholder="请输入县" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,64]']" value="${model.district}"  style="width:142px;">
                    </td>
                    <td>登录密码</td>
                    <td>
                        <c:choose>
                            <c:when test="${empty model.id}">
                                <input name="loginPwd" type="password" placeholder="请输入登录密码" style="width:142px;" class="easyui-validatebox easyui-textbox"
                                       data-options="required:true,validType:['length[0,127]']" value="${model.loginPwd}">

                            </c:when>
                            <c:otherwise>
                                无修改权限
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td>企业营业执照代码</td>
                    <td>
                        <input name="companyLicenseCode"  type="text" placeholder="请输入企业营业执照代码" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,64]']" value="${model.companyLicenseCode}"  style="width:142px;">
                    </td>
                    <td>企业营业执照照片</td>
                    <td>
                        <input name="companyLicensePhoto"  type="text" placeholder="请上传企业营业执照照片" class="easyui-validatebox easyui-textbox"
                               data-options="required:true" value="${model.companyLicensePhoto}"  style="width:142px;">
                    </td>
                    <td>经办人姓名</td>
                    <td>
                        <input name="operatorName"  type="text" placeholder="请输入经办人姓名" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,32]']" value="${model.operatorName}"  style="width:142px;">
                    </td>
                    <td>经办人证件类型</td>
                    <td id="operatorCertificateTypeEditTd">
                    </td>
                </tr>
                <tr>
                    <td>经办人证件号码</td>
                    <td>
                        <input name="operatorCertificateNumber"  type="text" placeholder="请输入经办人证件号码" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,64]']" value="${model.operatorCertificateNumber}"  style="width:142px;">
                    </td>
                    <td>经办人证件正面照</td>
                    <td>
                        <input name="operatorFrontSideIDPhoto"  type="text" placeholder="请上传经办人证件正面照" class="easyui-validatebox easyui-textbox"
                               data-options="required:true" value="${model.operatorFrontSideIDPhoto}"  style="width:142px;">
                    </td>
                    <td>经办人证件背面照</td>
                    <td>
                        <input name="operatorBackSideIDPhoto"  type="text" placeholder="请上传经办人证件背面照" class="easyui-validatebox easyui-textbox"
                               data-options="required:true" value="${model.operatorBackSideIDPhoto}"  style="width:142px;">
                    </td>
                    <td>经办人联系电话</td>
                    <td>
                        <input name="operatorContactNumber"  type="text" placeholder="请输入经办人联系电话" class="easyui-validatebox easyui-textbox"
                               data-options="required:true" value="${model.operatorContactNumber}"  style="width:142px;">
                    </td>
                </tr>
                <tr>
                    <td>经办人手机号码</td>
                    <td>
                        <input name="operatorMobilePhone"  type="text" placeholder="请输入经办人手机号码" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,64]']" value="${model.operatorMobilePhone}"  style="width:142px;">
                    </td>
                    <td>所属机构</td>
                    <td>
                        <select id="belongOrgId" name="belongOrgId" style="width: 140px; height: 29px;"
                                data-options="required:true"  class="easyui-validatebox easyui-textbox" data-options="required:true"></select>
                    </td>
                    <td>状态</td>
                    <td id="accountStatusEditTd">
                    </td>
                    <td>备注</td>
                    <td>
                        <input name="remark"  type="text" placeholder="请输入备注" class="easyui-validatebox easyui-textbox"
                               data-options="" value="${model.operatorContactNumber}"  style="width:142px;">
                    </td>
                </tr>
                <tr>
                    <td>开户时间</td>
                    <td>
                        <input id="openAccountTime"  name="openAccountTimeStr"  type="text" placeholder="请输入开户时间" class="easyui-datebox"
                               data-options="required:true" value="<fmt:formatDate value="${model.openAccountTime}" pattern="yyyy-MM-dd"/>"  style="width:142px;">
                    </td>
                    <td>销户时间</td>
                    <td colspan="5">
                        <input id="closeAccountTime"  name="closeAccountTimeStr"  type="text" placeholder="请输入销户时间" class="easyui-datebox"
                               data-options="required:true" value="<fmt:formatDate value="${model.closeAccountTime}" pattern="yyyy-MM-dd"/>"  style="width:142px;">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>