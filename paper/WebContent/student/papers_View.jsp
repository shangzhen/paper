<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论文上传页面</title>
</head>
<body>
	<div class="pageContent">
	
		<form method="post" action="/yxxt/student/StudentAction_update?uid=" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56" style="position: relative;">
				<h2 class="contentTitle">学生基本信息</h2>
				<div class="unit">
				<p>
					<label>学号：</label>
					<input type="text" name="paperDetails.fno" value="${paperDetails.fno}" size="30" readonly="readonly"/>
				</p>  
				<p>
					<label>标题：</label>
					<input type="text" name="paperDetails.ftitle" value="${paperDetails.ftitle}" size="30" readonly="readonly"/>
				</p>
				</div>
				<div class="unit">
				<p>
					<label>重复率：</label>
					<input type="text" name="paperDetails.frepetitionRate" value="${paperDetails.ftitle}" size="30" readonly="readonly"/>
				</p>
				<p>
					<label>版次：</label>
					<input type="text" name="paperDetails.frevision" value="${paperDetails.frevision}" size="30" readonly="readonly"/>
				</p>
				<p>
					<label>修改后的论文下载：</label>
					<a href="${paperDetails.fthesisAdjunct }" >下载</a>
					<%-- <input type="file" name="paperDetails.fthesisAdjunct" value="${paperDetails.fthesisAdjunct }"/> --%>
				</p>
				
				</div>
				<div class="divider">divider</div>
				<div class="divider">divider</div>
				<textarea class="editor" name="paperDetails.fmodifyContent"
					style="float: none; width: 90%; height: 200px" readonly="readonly">${paperDetails.fmodifyContent }</textarea>
				
				<div class="divider">divider</div>
				<textarea class="editor" name="paperDetails.freviewComment"
					style="float: none; width: 90%; height: 200px">${paperDetails.freviewComment }</textarea>
				
				<div class="divider">divider</div>
				
			</div>
		</form>
	</div>
</body>
</html>