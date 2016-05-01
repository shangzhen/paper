<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>答辩公告添加</title>
</head>
<body >
    
<form method="post" action="../noti/notice_add"  class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="97">
      <dl>
				<dt>答辩时间：</dt>
				<dd>
					<input type="text" name="notice.fdefencetime" class="date" maxlength="20" />
				</dd>
			</dl>
			<dl>
				<dt>答辩地点：</dt>
				<dd>
					<input type="text" name="notice.fdefenceplace" maxlength="100" />
				</dd>
			</dl>
			<dl>
				<dt>路线：</dt>
				<dd>
					<textarea class="editor" name="notice.froute"  cols="105" rows="20" size="500"></textarea>
				</dd>
			</dl>
			<dl>
				<dt>发布人：</dt>
				<dd>
					<input type="text" name="notice.freleaseperson" maxlength="20"  value=<%= session.getAttribute("user")%> readonly="readonly"/>
				</dd>
			</dl>
      <div class="formBar">
			<ul>
				
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>

    </form>
</body>
</html>

