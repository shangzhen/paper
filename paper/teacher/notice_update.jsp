<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>答辩公告修改</title>
</head>
<body>
<form method="post" action="/paper/noti/notice_update" enctype="multipart/form-data"  target="navTab" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="97">
			<input type="hidden" name="fid" value="${fid}">
			<dl>
				<dt>答辩时间：</dt>
				<dd>
					<input type="text" name="notice.fdefencetime"  class="date" value="${notice.fdefencetime }"/>
				</dd>
			</dl>
			<dl>
				<dt>答辩地点：</dt>
				<dd>
					<input type="text" name="notice.fdefenceplace"  value="${notice.fdefenceplace }"  size="30" >
				</dd>
			</dl>
			<dl>
				<dt>路线：</dt>
				<dd height="50" colspan="6" >
					<textarea class="editor" name="notice.froute"  rows="15" cols="100">${notice.froute }</textarea>
				</dd>
			</dl>
			<dl>
				<dt>发布人：</dt>
				<dd>
					<input type="text" name="notice.freleaseperson"  value="${notice.freleaseperson }" readonly="readonly" size="30" >
				</dd>
			</dl>
			<dl>
				<dt>备注：</dt>
				<dd>
					<input type="text" name="notice.fmemo"  value="${notice.fmemo }"  size="30" >
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</div>
</form>
</body>
</html>