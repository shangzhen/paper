<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告修改</title>
</head>
<body>
<form method="post" action="/paper/announce/announce_update" enctype="multipart/form-data"  target="navTab" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="97">
			<input type="hidden" name="fserialNo" value="${fserialNo}">
			<dl>
				<dt>标题：</dt>
				<dd>
					<input type="text" name="ac.ftitle" value="${announcement.ftitle }"/>
				</dd>
			</dl>
			<dl>
				<dt>发布人：</dt>
				<dd>
					<input type="text" name="ac.fpublisher"  value="${announcement.fpublisher }" readonly="readonly" size="30" >
				</dd>
			</dl>
			<dl>
				<dt>发布日期：</dt>
				<dd>
					<input type="text" name="ac.fpublishMessage" value="${announcement.fpublishMessage }" readonly="readonly"  size="30">
				</dd>
			</dl>
			<dl>
				<dt>类型：</dt>
				<dd>
					<c:if test="${announcement.ftype=='导师可见' }">
					<select name="ac.ftype" class="required combox" >
					<option value="">请选择</option>
					<option value="导师可见" selected="selected">导师可见</option>
					<option value="学生可见">学生可见</option>
					<option value="所有可见">所有可见</option>
					</select>	
					</c:if>
					<c:if test="${announcement.ftype=='学生可见' }">
					<select name="ac.ftype" class="required combox" >
					<option value="">请选择</option>
					<option value="导师可见">导师可见</option>
					<option value="学生可见" selected="selected">学生可见</option>
					<option value="所有可见">所有可见</option>
					</select>	
					</c:if>
					<c:if test="${announcement.ftype=='所有可见' }">
					<select name="ac.ftype" class="required combox" >
					<option value="">请选择</option>
					<option value="导师可见">导师可见</option>
					<option value="学生可见">学生可见</option>
					<option value="所有可见" selected="selected">所有可见</option>
					</select>	
					</c:if>
				</dd>
			</dl>
			<%-- <dl>
				<dt>内容：</dt>
				<dd>
					<textarea rows="5" cols="50" name="ac.fcontent" value="${announcement.fcontent }"></textarea>
				</dd>
			</dl> --%>
			<dl>
				<dd>
					<input type="hidden" name="ac.fbrowseTime" value="${announcement.fbrowseTime }">
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
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</div>
</form>
</body>
</html>