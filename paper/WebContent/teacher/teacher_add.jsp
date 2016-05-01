<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师添加</title>
</head>
<body>
<!-- class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);" -->

<form method="post" action="/paper/teacher/teacher_add"  class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>工号：</dt>
				<dd>
					<input type="text" name="tc.ftid" class="digits" maxlength="20" />
				</dd>
			</dl>
			<dl>
				<dt>姓名：</dt>
				<dd>
					<input type="text" name="tc.fname" maxlength="20" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>学院：</dt>
				<dd>
					<input type="text" name="tc.fcollege" />
				</dd>
			</dl>
			<dl>
				<dt>系别：</dt>
				<dd>
				<select name="tc.fdepartment" class="required combox">
					<option value=""selected>请选择</option>
					<option value="计算机科学与技术系">计算机科学与技术</option>
					<option value="网络工程系">网络工程</option>
					<option value="软件工程系">软件工程</option>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>职称：</dt>
				<dd>
				   	<select name="tc.fposition"  class="required combox" >
						<option value="">请选择</option>
						<option value="助教">助教</option>
						<option value="讲师">讲师</option>
						<option value="副教授" >副教授</option>
						<option value="教授" >教授</option>
					</select>	
				</dd>
			</dl>
			<dl>
				<dt>电话：</dt>
				<dd>
					<input type="text" name="tc.fphone" class="phone" alt="请输入您的电话" />
				</dd>
			</dl>
			<dl>
				<dt>邮箱：</dt>
				<dd>
					<input type="text"  name="tc.femail" class="email" alt="请输入您的电子邮件"/>
				</dd>
			</dl>
			<dl>
				<dt>QQ号：</dt>
				<dd>
					<input type="text" name="tc.fqq" class="digits" minlength="6" maxlength="15"/>
				</dd>
			</dl>
			<dl>
				<dt>QQ群：</dt>
				<dd>
					<input type="text" name="tc.fqgno" class="digits" minlength="6" maxlength="15"/>
				</dd>
			</dl>
			<dl>
				<dt>密码：</dt>
				<dd>
					<input type="password" name="tc.fpsw" minlength="6" />
				</dd>
			</dl>
			<dl>
				<dt>用户类型：</dt>
				<dd>
					<select name="tc.ftype" >
					<option value="">请选择</option>
					<option value="教师">教师</option>
					<option value="管理员">管理员</option>
					</select>
				</dd>
			</dl>
			
			<dl>
				<dt>备注：</dt>
				<dd>
					<textarea rows="5" cols="50" name="tc.fmemo"></textarea>
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