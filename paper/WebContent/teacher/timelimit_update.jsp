<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进度管理修改</title>
</head>
<body>
<form method="post" action="/paper/time/time_update" enctype="multipart/form-data"  target="navTab" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="97">
			<input type="hidden" name="fid" value="${fid}">
			<dl>
				<dt>教师工号：</dt>
				<dd>
					<input type="text" name="timeLimit.ftid"  value="${timeLimit.ftid }" readonly="readonly" size="30" >
				</dd>
			</dl>
			<dl>
				<dt>提醒内容：</dt>
				<dd height="50" colspan="6" >
					<input class="text" name="timeLimit.fremindContent"  rows="5" cols="100" value="${timeLimit.fremindContent}"/>
				</dd>
			</dl>
			<dl>
			<dt>时间要求：</dt>
				<dd height="50" colspan="6" >
					<p>
						<input type="text" name="timeLimit.ftimeRequirement" class="date" readonly="true" value="${timeLimit.ftimeRequirement }" />
						<a class="inputDateButton" href="javascript:;">选择</a>
						<span class="info">yyyy-MM-dd</span>
					</p>
					<!-- <textarea class="editor" name="timeLimit.ftimeRequirement"  rows="5" cols="100"></textarea> -->
				</dd>
			</dl>
			<dl>
				<dt>提醒时间（提前多少天提醒）</dt>
				<dd>
					<input type="text" name="timeLimit.fremindTime" value="${timeLimit.fremindTime}" />
				</dd>
			</dl>
			<dl>
				<dt>工作任务：</dt>
				<dd height="50" colspan="6" >
					<textarea class="editor" name="timeLimit.fjobTasks"  rows="10" cols="100">${timeLimit.fjobTasks }</textarea>
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