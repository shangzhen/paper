<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="pageContent">
	<form method="post" action="/paper/student/Reply_add" class="pageForm required-validate" onsubmit="return validateCallback(this)">
		<div class="pageFormContent nowrap" layoutH="97">

			<dl>
				<dt>学号：</dt>
				<dd>
					<input type="text" name="reg.fNo" maxlength="20" class="required" />
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>姓名：</dt>
				<dd>
					<input type="text" name="reg.fName" class="required" />
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>论文题目：</dt>
				<dd>
					<input type="text" name="reg.fThesisTopic"  size="30"/>
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>答辩时间：</dt>
				<dd>
					<input type="text" name="reg.fReleaseTime" class="date" size="30" />
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>答辩地点：</dt>
				<dd>
					<input type="text" name="reg.fDefencePlace" size="40"/>
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>指导老师</dt>
				<dd>
					<input type="text" name="reg.fGuideTeacher" />
					<span class="info"></span>
				</dd>

		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">预约</button></div></div></li>
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
