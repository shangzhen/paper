<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传</title>
</head>
<body>
<form action="/paper/file/uploadFile_uploadFile" method="post" enctype="multipart/form-data" >	
	<br/>
	<input type="hidden" name="fid" value="${fid}">
	<s:file name="upload" label="上传路径"/><br/>
	<br/>
	<h1 style="color:red">特别注意：文件应不大于5M</h1>
	<s:submit value="开始上传"/>
<form>
</body>
</html>    