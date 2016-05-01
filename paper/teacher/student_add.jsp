<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生添加</title>
</head>
<body>

<div class="pageContent">
	
	<form method="post" action="/paper/stu/student_add" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="97">

		<dl>
				<dt>学号：</dt>
				<dd>
					<input type="text" class="number" name="task.fno" />
				</dd>
			</dl>
			<dl>
				<dt>姓名：</dt>
				<dd>
					<input type="text"  name="task.fname"/>
				</dd>
			</dl>
			<dl>
				<dt>题目名称：</dt>
				<dd>
					<input type="text"  name="task.ftitle"/>
				</dd>
			</dl>
			<dl>
				<dt>学院：</dt>
				<dd>
				<select  class="required combox" name="task.fcollege">
					<option value=""selected>请选择</option>
					<option value="软件学院">软件学院</option>
					<option value="计算机学院">计算机学院</option>
					<option value="土木学院">土木学院</option>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>专业：</dt>
				<dd>
				    <select  class="required combox" name="task.fmajor">
					<option value="请选择"selected>请选择</option>
					<option value="计算机科学与技术">计算机科学与技术</option>
					<option value="网络工程">网络工程</option>
					<option value="软件工程">软件工程</option>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>指导教师姓名：</dt>
				<dd>
					<input type="text"  name="task.ftutorName"/>
				</dd>
			</dl>
			<dl>
				<dt>备注：</dt>
				<dd>
					<input type="text"  name="task.memo"/>
				</dd>
			</dl>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">添加</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>
</html>