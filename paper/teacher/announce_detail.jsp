<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告查看</title>
</head>
<body>
<form method="post" action="" enctype="multipart/form-data"  target="navTab" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="97">
			<input type="hidden" name="fserialNo" value="${fserialNo}" >
			<dl>
				<dt>标题：</dt>
				<dd>
					<input type="text" name="ac.ftitle" value="${announcement.ftitle }" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>发布人：</dt>
				<dd>
					<input type="text" name="ac.fpublisher" value="${announcement.fpublisher }" readonly="readonly" size="30" >
				</dd>
			</dl>
			<dl>
				<dt>发布日期：</dt>
				<dd>
					<input type="text" name="ac.fpublishMessage" value="${announcement.fpublishMessage }"  readonly="readonly" size="30">
				</dd>
			</dl>
			<dl>
				<dt>浏览次数：</dt>
				<dd>
					<input type="text" name="ac.fbrowseTime" value="${announcement.fbrowseTime }" readonly="readonly">
				</dd>
			</dl>
			<dl>
				<dt>内容：</dt>
				<dd height="50" colspan="6" >
					<textarea class="editor" name="ac.fcontent"  rows="15" cols="100">${announcement.fcontent }</textarea>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	</div>
</form>
</body>
</html>