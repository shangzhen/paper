 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息</title>
<style type="text/css">
	table tr td{width:195px; height:40px;}
	.table{ border-collapse:collapse;}
	.table tr td{width:100px;}
	.span{color:red}
</style>
</head>
<body>
<div class="pageContent">
	<form method="post" action="/paper/StudentManageAction_update?uid=" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56" style="position: relative;">
		
			<table class="table">
			<tr>
				<td>学&nbsp;&nbsp;号:</td>
				<td>${s.fno }</td>
				
				<td>姓&nbsp;&nbsp;名:</td>
				<td>${s.fsName}</td>
				
				<td>专&nbsp;&nbsp;业</td>
				<td>${s.fprofessional}</td>
			</tr>
			<tr>
				<td>指&nbsp;导&nbsp;老&nbsp;师：</td>
				<td>${s.ftName}</td>
				
				<td>学&nbsp;生&nbsp;状&nbsp;态：</td>
				<td>${s.fstate}</td>
				
				<td>初&nbsp;次&nbsp;工&nbsp;作&nbsp;状&nbsp;态：</td>
				<td>${s.fprimaryWork}</td>
			</tr>
			<tr>
				<td>初&nbsp;次&nbsp;月&nbsp;薪：</td>
				<td>${s.fprimaryPay}</td>
				
				<td>离&nbsp;校&nbsp;工&nbsp;作&nbsp;单&nbsp;位：</td>
				<td>${s.fleaveSchoolWork}</td>
				
				<td>月&nbsp;&nbsp;薪：</td>
				<td>${s.fpay}</td>
			</tr>
			<tr>
				<td>系&nbsp;&nbsp;别：</td>
				<td>${s.fdepartment}</td>
			</tr>
			</table>
			<dl>
			
				<dt>备&nbsp;&nbsp;注：</dt>
				<dd><textarea rows="10" cols="42" name="s.fmemo" class="memo" readonly="readonly">${s.fmemo}</textarea></dd>
			</dl>
			<%-- <p>
				<label>学号</label>
				<input name="s.fno" class="name" type="text" value="${s.fno}" readonly="readonly"/>
			</p>  
			
			
			<p>
				<label>姓名</label>
				<input type="text" name="s.fsName" value="${s.fsName}" readonly="readonly"/>
			</p>
			
			<p>
				<label>专业</label>
				<input type="text" name="s.fprofessional" value="${s.fprofessional}" readonly="readonly"/>
			</p>
			      
			<p>
				<label>指导老师</label>
				<input type="text" name="s.ftname" value="${s.ftName}" readonly="readonly"/>
			</p>     
			<p>
				<label>学生状态</label>
				<input type="text" name="s.fstate" value="${s.fstate}" readonly="readonly">
			</p>
		    <p>
				<label>初次工作状态</label>
				<input type="text" name="s.fprimarywork" class="pType" value="${s.fprimaryWork}" readonly="readonly"/>
			</p>
			<p>
				<label>初次月薪</label>
				<input type="text" name="s.fprimaryPay" class="gSchool" value="${s.fprimaryPay}" readonly="readonly"/>
			</p>
			<p>
				<label>离校工作单位</label>
				<input type="text" name="s.fleaveSchoolWork" class="uName" value="${s.fleaveSchoolWork}" readonly="readonly"/>
			</p>   
			<p>
				<label>月薪</label>
				<input type="text" name="s.fpay" class="asd" value="${s.fpay}"  readonly="readonly"/>
			</p>

			<p>
				<label>系别</label>
				<input type="text" name="s.fdepartment" class="asd" value="${s.fdepartment}" readonly="readonly"/>
			</p>
			<br/>
			<p>
			
				<label>备注</label>
				<textarea rows="5" cols="50" name="s.fmemo" class="memo" readonly="readonly" value="${s.fmemo}"></textarea>
			</p>
		</div>
		 <div class="formBar">
			<ul>
				<li>
				<a class="buttonActive" href="student_messageUpdate.jsp" target="navTab" rel="page1"><span>修改</span></a>
				</li>
 			</ul> --%>
		</div>
	</form>
</div>
</body>
</html>