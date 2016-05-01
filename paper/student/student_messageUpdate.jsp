 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息</title>
</head>
<body>
<div class="pageContent">
	<form method="post" action="/paper/student/student_update" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56" style="position: relative;">
			
			<div style="position: absolute;top:10px;right:20px;">
				
				
					
				
			</div>
			<p>
				<label>学号</label>
				<input name="s.fno" class="name" type="text" value="${sessionScope.user}"  readonly="readonly"/>
			</p>  
			
			
			<p>
				<label>姓名</label>
				<input type="text" name="s.fsName" value="${s.fsName}" />
			</p>
			
			<p>
				<label>专业</label>
				<input type="text" name="s.fprofessional" value="${s.fprofessional}" />
			</p>
			      
			<p>
				<label>指导老师</label>
				<input type="text" name="s.ftname" value="${s.ftName}" />
			</p>     
			<p>
				<label>学生状态</label>
				<input type="text" name="s.fstate" value="${s.fstate}" >
			</p>
		    <p>
				<label>初次工作状态</label>
				<input type="text" name="s.fprimarywork" class="pType" value="${s.fprimaryWork}" />
			</p>
			<p>
				<label>初次月薪</label>
				<input type="text" name="s.fprimaryPay" class="gSchool" value="${s.fprimaryPay}" />
			</p>
			<p>
				<label>离校工作单位</label>
				<input type="text" name="s.fleaveSchoolWork" class="uName" value="${s.fleaveSchoolWork}" />
			</p>   
			<p>
				<label>月薪</label>
				<input type="text" name="s.fpay" class="asd" value="${s.fpay}"  />
			</p>

			<p>
				<label>系别</label>
				<input type="text" name="s.fdepartment" class="asd" value="${s.fdepartment}" />
			</p>
			<br/>
			<p>
			
				<label>备注</label>
				<textarea rows="5" cols="50" name="s.fmemo" class="memo"  value="${s.fmemo}"></textarea>
			</p>
		</div>
		 <div class="formBar">
			<ul>
				<li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit" >保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
				</li>
 			</ul>
		</div>
	</form>
</div>
</body>
</html>