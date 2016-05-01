<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

	<div class="pageContent">				
	<form method="post" action="/paper/stu/consultation_add" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>学号：</dt>
				<dd>
					<input type="text" name="online.fno"  value="${student.fno }" readonly="readonly" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>姓名：</dt>
				<dd>
					<input type="text" name="online.fstudentName" value="${student.fsName }" readonly="readonly" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>咨询主题：</dt>
				<dd>
					<input type="text" name="online.ftitle"  class="required" style="width:300px;" maxlength="25"/>
				</dd>
			</dl>
			<dl>
				<dt>咨询内容：</dt>
				<dd><textarea name="fContent" cols="50" rows="4" maxlength="500"></textarea></dd>
			</dl>
			<div class="formBar" style="margin-bottom: 0">
				<ul>
					<li ><div class="buttonActive"><div class="buttonContent" ><button type="submit">咨询</button></div></div></li>
					<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
				</ul>
			</div>
		</div>
	</form>
	
</div>
<script>

</script>