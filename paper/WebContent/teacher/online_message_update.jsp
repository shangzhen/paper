<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回复咨询信息</title>

</head>
<body>
<div class="pageContent">
	<form method="post" action="/paper/teacher/noticeInformation_updateMessage" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
		<input type="hidden" name="online.fid" value="${online.fid }">
		<input type="hidden" name="online.fqueryTime" value="${online.fqueryTime }">
		<input type="hidden" name="online.fstudentName" value="${online.fstudentName }">
			<dl>
				<dt>回复人姓名：</dt>
				<dd>
					<input type="text" name="online.fanswer"  value="${fanswer}" readonly="readonly" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>咨询主题：</dt>
				<dd>
					<input type="text" name="online.ftitle" value="${online.ftitle }" class="required" readonly="readonly" style="width:300px;" maxlength="25"/>
				</dd>
			</dl>
			<dl>
				<dt>咨询内容：</dt>
				<dd><textarea name="online.fcontent" cols="50" rows="4" readonly="readonly">${online.fcontent }</textarea></dd>
			</dl>
			<dl>
				<dt>是否置顶：</dt>
				<dd>
					<input type="radio" value="0" name="online.fisTop" checked="checked">否
					<input type="radio" value="1" name="online.fisTop">是
				</dd>
			</dl>
			<dl>
				<dt>回复内容：</dt>
				<dd><textarea name="rContents" cols="50" rows="4" maxlength="500"></textarea></dd>
			</dl>
		<div class="formBar" style="margin-bottom: 0">
			<ul>
				<li ><div class="buttonActive"><div class="buttonContent" ><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
	
</div>
</body>
</html>