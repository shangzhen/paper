 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	table tr td{width:195px; height:40px;}
	.table{ border-collapse:collapse;}
	.table tr td{width:100px;}
	.span{color:red}
</style>
<title>导师信息</title>
</head>
<body>
<div class="pageContent">
	<form method="post" action="/yxxt/student/StudentAction_update?uid=" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56" style="position: relative;">
			<table class="table">
			<tr>
				<td>工&nbsp;&nbsp;号:</td>
				<td>${teacher.ftid }</td>
				
				<td>姓&nbsp;&nbsp;名:</td>
				<td>${teacher.fname }</td>
				
				<td>系 &nbsp;&nbsp;别:</td>
				<td>${teacher.fdepartment }</td>
			</tr>
			<tr>
				<td>职&nbsp;&nbsp;称：</td>
				<td>${teacher.fposition }</td>
				
				<td>电&nbsp;&nbsp;话：</td>
				<td>${teacher.fphone }</td>
				
				<td>邮&nbsp;&nbsp;箱：</td>
				<td>${teacher.femail }</td>
			</tr>
			<tr>
				<td>QQ&nbsp;&nbsp;号：</td>
				<td>${teacher.fqq }</td>
				
				<td>QQ&nbsp;&nbsp;群：</td>
				<td>${teacher.fqgno }</td>
				
				<td>学&nbsp;&nbsp;院：</td>
				<td>${teacher.fcollege }</td>
			</tr>
			</table>
			<dl>			
				<dt>备&nbsp;&nbsp;注：</dt>
				<dd><textarea rows="10" cols="42" name="s.fmemo" class="memo" readonly="readonly">${teacher.fmemo}</textarea></dd>
			</dl>
	
			<!-- <p>
				<label>å·¥å·ï¼</label>
				<input name="s.name" class="name" type="text" value="123456789" readonly="readonly"/>
			</p>  
			<p>
				<label>å§åï¼</label>
				<input type="text" name="s.gender" value="å¼ ä¸" readonly="readonly"/>
			</p>
			<p>
				<label>ç³»å«ï¼</label>
				<input type="text" name="s.college" value="è½¯ä»¶å·¥ç¨" readonly="readonly"/>
			</p>
			      
			<p>
				<label>èç§°ï¼</label>
				<input type="text" name="s.major" value="ææ" readonly="readonly"/>
			</p>
			<p>
				<label>çµè¯ï¼</label>
				<input type="text" name="s.idCard" value="13423456789" readonly="readonly"/>
			</p>     
			<p>
				<label>é®ç®±ï¼</label>
				<input type="text" name="s.nation" class="nation" value="186289572@qq.com" readonly="readonly"/>
			</p>
		    <p>
				<label>QQå·ï¼</label>
				<input type="text" name="pType" class="pType" value="186289572" readonly="readonly"/>
			</p>
			<p>
				<label>QQç¾¤ï¼</label>
				<input type="text" name="gSchool" class="gSchool" value="46782723" readonly="readonly"/>
			</p>
	 
			<p>
				<label>ç¨æ·ç±»åï¼</label>
				<input type="text" name="s.phone" class="digits" value="ç¥"  readonly="readonly"/>
			</p>

			<p>
				<label>å­¦é¢ï¼</label>
				<input type="text" name="s.qq" class="qq" value="è½¯ä»¶å­¦é¢" readonly="readonly"/>
			</p>
		
			
			<p>
				<label>å¤æ³¨ï¼</label>
				<textarea rows="5" cols="50" name="s.memo" class="memo" readonly="readonly">ç¥</textarea>
			</p> -->
		</div>
		<!-- <div class="formBar">
			<ul>
				<li><a class="buttonActive" href="javascript:;"><span>ä¿å­</span></a></li>
 				<li><div class="submit"><a href="studentList.jsp" target=main onclick ="javascript:history.go(-1);"><input type="submit" value="è¿å" class="button"/></a></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">åæ¶</button></div></div>
				</li>
			</ul>
		</div> -->
	</form>
</div>
</body>
</html>