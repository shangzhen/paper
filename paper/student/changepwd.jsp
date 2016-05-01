<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div class="pageContent">
<%-- 	<script language="javascript">
            function check()
            {
               
                 if(document.formPw.rnewpsw.value != document.formPw.rnewpsw1.value)
                 {
                     alert("两次输入的密码不一致");
                     return ;
                 }
            }
            </script> --%>
	<form method="post"  name="formPw"action="/paper/student/student_resetPassword" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="58">
		<div class="unit">
				<label>旧密码：</label>
				<input  type="password" name="oldpsw" size="30" minlength="6" maxlength="20" class="required" />
			</div>
			<div class="unit">
				<label>新密码：</label>
				<input type="password" id="cp_newPassword" name="rnewpsw" size="30" minlength="6" maxlength="20" class="required alphanumeric"/>
			</div>
			<div class="unit">
				<label>重复输入新密码：</label>
				<input type="password" name="rnewpsw1" size="30"  equalto="#cp_newPassword"  class="required"/>
			</div>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit" >提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>
