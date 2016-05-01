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
	
	<form method="post" action="/paper/stu/student_addstumessage" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="97">

		<dl>
				<dt>学号：</dt>
				<dd>
					<input type="text" class="number" name="student.fno" />
				</dd>
			</dl>
			<dl>
				<dt>姓名：</dt>
				<dd>
					<input type="text"  name="student.fsname"/>
				</dd>
			</dl>
			
			<dl>
				<dt>专业：</dt>
				<dd>
				    <select  class="required combox" name="student.fmarjor">
					<option value="请选择"selected>请选择</option>
					<option value="计算机科学与技术">计算机科学与技术</option>
					<option value="网络工程">网络工程</option>
					<option value="软件工程">软件工程</option>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>年级：</dt>
				<dd>
					<input type="text"  name="student.fgreade"/>
				</dd>
			</dl>
			<dl>
				<dt>籍贯：</dt>
				<dd>
					<input type="text"  name="student.fplace"/>
				</dd>
			</dl>
			<dl>
				<dt>方向：</dt>
				<dd>
					<input type="text"  name="student.fclass"/>
				</dd>
			</dl>
			<dl>
				<dt>辅导员姓名：</dt>
				<dd>
					<input type="text"  name="student.fcnmae"/>
				</dd>
			</dl>
			<dl>
				<dt>辅导员工号：</dt>
				<dd>
					<input type="text"  name="student.fcid"/>
				</dd>
			</dl>
			<dl>
				<dt>电话：</dt>
				<dd>
					<input type="text"  name="student.fphone"/>
				</dd>
			</dl>
			<dl>
				<dt>邮箱：</dt>
				<dd>
					<input type="text"  name="student.femail"/>
				</dd>
			</dl>
			<dl>
				<dt>QQ：</dt>
				<dd>
					<input type="text"  name="student.fqq"/>
				</dd>
			</dl>
			<dl>
				<dt>实习单位：</dt>
				<dd>
					<input type="text"  name="student.ftranning"/>
				</dd>
			</dl>
			<dl>
				<dt>工作单位：</dt>
				<dd>
					<input type="text"  name="student.fwork"/>
				</dd>
			</dl>
			<dl>
				<dt>学生状态：</dt>
				<dd>
				    <select name="student.fstate" class="required combox">
					<option value="请选择"selected>请选择</option>
					<option value="在学">在学</option>
					<option value="毕业">毕业</option>
					</select>
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