<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% %>
<form action="/paper/student/paper_upload2" method="post" enctype="multipart/form-data" >
	<h3>PPT上传</h3>
	<br/>
	<s:file name="file" label="上传路径"/><br/>
	<br/>
	<h1 style="color:red">特别注意：PPT附件应不大于5M</h1>
	<s:submit value="开始上传"/>
</form>
</body>
</html>