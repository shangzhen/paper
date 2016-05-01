<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function showResult(){
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					var result = xmlHttp.responseText;
					document.getElementById('stuNumber').value = result;
				}
			}
		};
		xmlHttp.open("POST","/paper/Automatic/Automatic_findStuNumber");
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		var stufgreade = document.getElementById('stufgreade').value;
		xmlHttp.send("stufgreade="+stufgreade);
	}
	

	function createXMLHttpRequest() {
		try {
			xmlHttp = new XMLHttpRequest();
		} catch (tryMS) {
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (otherMS) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (failed) {
					xmlHttp = null;
					// 这里可以报一个错误，无法获得 XMLHttpRequest对象	
				}
			}
		}
		return xmlHttp;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自动分配</title>
</head>
<body>
<form method="post" action="/paper/Automatic/Automatic_predistribution" enctype="multipart/form-data"  target="navTab" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>请输入要分配的年级：</dt>
				<dd>
					<input type="text" id="stufgreade" name="fgreade"   class="required" value="" onBlur="showResult();"/>
				</dd>
			</dl>					
			<p style="color:red;">提示：例如要分配2013级学生，则输入“2013级”。</p>
			<dl>
				<dt>待分配人数：</dt>
				<dd>
					<input type="text" id="stuNumber" class="required"  name="number" readonly="readonly" value=""/>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>选择指导教师：</dt>
				<dd>				
					<c:forEach var="c" items="${listTeacher }">				
						<label><input type="checkbox" name="teacher" value="${c.ftid}" />${c.fname}</label>				
					</c:forEach>
				</dd>
			</dl>		
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent" ><button type="submit">下一步</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="checkboxCtrl" group="teacher" selectType="invert">反选</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</div>
</form>
</body>
</html>