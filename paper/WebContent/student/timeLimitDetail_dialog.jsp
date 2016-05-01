 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>提醒内容：</label>
				<input name="sn" type="text" size="30" value="${timeLimit.fremindContent }" readonly="readonly"/>
			</p>
			<p>
				<label>时间要求：</label>
				<input name="sn" type="text" size="30" value="${timeLimit.ftimeRequirement }" readonly="readonly"/>
			</p>
			<p>
				<label>工作任务：</label>
				<textarea name="sn" rows="10" cols="100" readonly="readonly">${timeLimit.fjobTasks }</textarea>
			</p>
			
		</div>
	</form>
</div>
