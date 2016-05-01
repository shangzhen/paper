<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生添加</title>
</head>
<body>

<div class="pageContent">
	
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this)">
		<div class="pageFormContent nowrap" layoutH="97">

		<dl>
				<dt>学号：</dt>
				<dd>
					<input type="text" class="number" />
				</dd>
			</dl>
			<dl>
				<dt>姓名：</dt>
				<dd>
					<input type="text" />
				</dd>
			</dl>
			
			<dl>
				<dt>系别：</dt>
				<dd>
				<select name="type" class="required combox">
					<option value="请选择"selected>请选择</option>
					<option value="计算机科学与技术系">计算机科学与技术系</option>
					<option value="网络工程系">网络工程系</option>
					<option value="软件工程系">软件工程系</option>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>专业：</dt>
				<dd>
				    <select name="type" class="required combox">
					<option value="请选择"selected>请选择</option>
					<option value="计算机科学与技术1班">计算机科学与技术1班</option>
					<option value="计算机科学与技术2班">计算机科学与技术2班</option>
					<option value="网络工程1班">网络工程1班</option>
					<option value="网络工程2班">网络工程2班</option>
					<option value="软件工程1班">软件工程1班</option>
					<option value="软件工程2班">软件工程2班</option>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>指导教师工号：</dt>
				<dd>
					<input type="text" class="number" />
				</dd>
			</dl>
			<dl>
				<dt>指导教师姓名：</dt>
				<dd>
					<input type="text"  />
				</dd>
			</dl>
			<dl>
				<dt>学生状态：</dt>
				<dd>
				    <select name="type" class="required combox">
					<option value="请选择"selected>请选择</option>
					<option value="在学">在学</option>
					<option value="毕业">毕业</option>
					</select>
					</dd>
			</dl>	
			
			<dl>
				<dt>手机号码：</dt>
				<dd>
					<input type="text"  class="number" />
				</dd>
			</dl>
			<dl>
				<dt>密码：</dt>
				<dd>
					<input type="text" />
				</dd>
			</dl>
			<dl>
				<dt>备注：</dt>
				<dd>
					<input type="text" />
				</dd>
			</dl>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">添加</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>


<script type="text/javascript">
function customvalidXxx(element){
	if ($(element).val() == "xxx") return false;
	return true;
}
</script>
</html>