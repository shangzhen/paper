<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<script type="text/javascript">
	function showResult(){
		var xmlHttp = createXMLHttpRequest();
		//2.状态监听器绑定一个回调函数     状态监听器onreadystatechange
		xmlHttp.onreadystatechange = function() {
			//5.回调函数处理服务器响应的结果
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					//处理的代码
					var result = xmlHttp.responseText;
					document.getElementById('myInput').value = result;
				}
			}
		};
		//3.建立与服务器的连接
		//4.发送数据给服务器
		//xmlHttp.send(null);

		//post方式 发送数据
		//3.建立与服务器的连接

		//此处可能要写全路径
		xmlHttp.open("POST", "/paper/stu/hand_getTeacherName");
		//4.发送数据给服务器
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		var ftid = document.getElementById('ftid').value;
		xmlHttp.send("ftid="+ftid);
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
	function showResult1() {
		var xmlHttp = createXMLHttpRequest();
		//2.状态监听器绑定一个回调函数     状态监听器onreadystatechange
		xmlHttp.onreadystatechange = function() {
			//5.回调函数处理服务器响应的结果
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					//处理的代码
					var result = xmlHttp.responseText;
					document.getElementById('myInput1').value = result;
				}
			}
		};
		//3.建立与服务器的连接
		//4.发送数据给服务器
		//xmlHttp.send(null);

		//post方式 发送数据
		//3.建立与服务器的连接

		//此处可能要写全路径
		xmlHttp.open("POST", "/paper/stu/hand_getTeacherFdepartment");
		//4.发送数据给服务器
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		var ftid = document.getElementById('ftid').value;
		xmlHttp.send("ftid=" + ftid);
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
<body>
	<!-- class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);" -->

	<form method="post" action="/paper/stu/hand_add"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageContent">
			<div class="pageFormContent nowrap" layoutH="97">
				<dl>
					<dt>学号：</dt>
					<dd>
						<input type="text" name="stu.fno" class="digits"
							readonly="readonly" value="${student.fno }" />
					</dd>
				</dl>
				<dl>
					<dt>姓名：</dt>
					<dd>
						<input readonly="readonly" type="text" name="stu.fsName"
							maxlength="20" value="${student.fsname }" />
					</dd>
				</dl>
				<dl>
					<dt>年级：</dt>
					<dd>
						<input readonly="readonly" type="text" name="stu.fgrade" value="${student.fgreade }" />
					</dd>
				</dl>
				<dl>
					<dt>专业：</dt>
					<dd>
						<c:if test="${student.fmarjor=='计算机科学与技术' }">
							<select name="stu.fprofessional" class="required combox">
								<option value="">请选择</option>
								<option value="软件工程">软件工程</option>
								<option value="计算机科学与技术" selected="selected">计算机科学与技术</option>
								<option value="网络工程">网络工程</option>
							</select>
						</c:if>
						<c:if test="${student.fmarjor=='网络工程' }">
							<select name="stu.fprofessional" class="required combox">
								<option value="">请选择</option>
								<option value="软件工程">软件工程</option>
								<option value="计算机科学与技术">计算机科学与技术</option>
								<option value="网络工程" selected="selected">网络工程</option>
							</select>
						</c:if>
						<c:if test="${student.fmarjor=='软件工程' }">
							<select name="stu.fprofessional" class="required combox">
								<option value="">请选择</option>
								<option value="软件工程" selected="selected">软件工程</option>
								<option value="计算机科学与技术">计算机科学与技术</option>
								<option value="网络工程">网络工程</option>
							</select>
						</c:if>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>指导教师工号：</dt>
					<dd>
						<input id="ftid" class="required" name="stu.ftid" type="text" onBlur="showResult();showResult1();"/>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>指导教师姓名：</dt>
					<dd>
						<input id="myInput" class="readonly" name="stu.ftName" readonly="readonly" type="text" />
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>系别：</dt>
					<dd>
						<input id="myInput1" class="readonly" name="stu.fdepartment"
							readonly="readonly" type="text" />
					</dd>
				</dl>
				<dl>
					<dt>备注：</dt>
					<dd>
						<input type="text" name="stu.fmemo" />
					</dd>
				</dl>
				<dl>
					<dd>
						<input name="stu.fState" readonly="readonly" type="hidden" value="应届" />
					</dd>
				</dl>
				


			</div>

			<div class="formBar">
				<ul>
					<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">提交</button>
							</div>
						</div></li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="button" class="close">取消</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</form>


</body>
</html>