<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告添加</title>
</head>
<body>
<form method="post" action="/paper/announce/announce_add"  target="navTab" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>标题：</dt>
				<dd>
					<input type="text" name="ac.ftitle" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>发布人：</dt>
				<dd>
					<input type="text" name="ac.fpublisher" value=<%= session.getAttribute("user")%> readonly="readonly" size="30" >
				</dd>
			</dl>
			<dl>
				<dt>类型：</dt>
				<dd>
					<select name="ac.ftype" class="required combox" >
					<option value="">请选择</option>
					<option value="导师可见">导师可见</option>
					<option value="学生可见">学生可见</option>
					<option value="所有可见">所有可见</option>
					<option value="仅自己学生可见">仅自己学生可见</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dd>
					<input type="hidden" name="ac.fbrowseTime" value="1">
				</dd>
			</dl>
			<dl>
				<dt>内容：</dt>
				<dd height="50"colspan="6" >
					<textarea class="editor" name="ac.fcontent" rows="15" cols="100"></textarea>
				</dd>
			</dl>	
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
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