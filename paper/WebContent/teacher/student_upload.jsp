<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br />
<h2 class="contentTitle">学生名单导入</h2>
<div class="pageContent" style="margin: 0 10px" layoutH="50">
	<form action="../stu/upload" class="pageForm required-validate" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this, navTabAjaxDone)" >
	<br/><br/>
	<fieldset>
		<legend>上传文件</legend> <br>
		<a href="demo/common/dwz-team.xls" class="excel" target="_blank" style="color:blue;font-size:18px;">点击下载Excel模板</a><br/><br/><br/>
		<p>请上传excel 97/2000/XP/2003文件（*.xls）</p><br>
		<dl>
			<dt><span style="color:red;font-size:16px;">选择XLS文件</span></dt><br>
			<dd>
				<input class="required" type="file" name="files"> 
			</dd>
		</dl><br>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</fieldset>
	<br>

	</form>
</div>
</body>
</html>