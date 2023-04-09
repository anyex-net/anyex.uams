<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#editMsgTemplateForm').form({
            url : '${ctx}/common/msgTemplate/save',
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
                    $('#editMsgTemplateForm').find('input[name="csrf"]').val(result.csrf);
                }
            }
        }); 
        
        $("#typeEditTd").html(dictDropDownOptions('typeEdit','type', 'msgTemplateType','${template.type}', 'required:true,', 'width:142px'));
        $("#typeEdit").combobox({
            valueField:'code',
            textField:'name'
        });
        $("#langEditTd").html(dictDropDownOptions('langEdit', 'lang','langType','${template.lang}', 'required:true,', 'width:142px'));
        $("#langEdit").combobox({
            valueField:'code',
            textField:'name'
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form:form id="editMsgTemplateForm" method="post">
        	<input id="id" name="id" type="hidden" value="${template.id}"/>
            <table class="grid">
                <tr>
                    <td>模板类型</td>
                    <td id="typeEditTd">
                    </td>
                    <td>语言类型</td>
                    <td id="langEditTd">
                    </td>
                </tr>
                <tr>
                    <td>模板KEY</td>
                    <td colspan="3">
                    	<input id="publicDate2"  name="tplKey"  type="text" placeholder="请输入模板KEY" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,64]']" value="${template.tplKey}"  style="width:474px;"></td>
                </tr>
                <tr>
                    <td>标题</td>
                    <td colspan="3"><input name="title" type="text" placeholder="请输入邮件标题" style="width:474px;" class="easyui-validatebox easyui-textbox"
                               data-options="required:true,validType:['length[0,127]']" value="${template.title}"> 
                    </td>
                </tr>
                <tr>
                    <td>内容</td>
                    <td colspan="3">
                        <textarea  name="content" ex-id="content" style=" width:474px;height: 100px;">${template.content}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>描述</td>
                    <td colspan="3" >
                        <textarea  name="content" ex-id="content" style=" width:474px;height: 90px;">${template.dest}</textarea>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>