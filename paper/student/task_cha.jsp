<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
	   <div class="pageContent">
			<div class="pageFormContent" layoutH="56" style="position: relative;">
				<h2 class="contentTitle">查看任务书</h2>
				<div class="unit">
					<label>学号：</label>
					<input type="text" name="task.fno" value="${task.fno}" readonly="readonly" size="30"/>
				</div> 
				<div class="unit">
					<label>课题题目：</label>
					<input type="text" name="task.fitle" value="${task.ftitle }" size="30" readonly="readonly"/>
				</div>
				<div class="unit">
					<label>开题时间：</label>
					 <input type="text" name="task.ftime" class="date" value="${task.ftime}"  readonly="readonly" size="30"/>
				</div>
				<div class="unit">
					<label>教师评阅时间：</label>
					 <input type="text" name="task.freviewTime" class="date" value="${task.freviewTime}"  readonly="readonly" size="30"/>
				</div>
				<div class="unit">
					<label>状态：</label>
					<input type="text" name="task.fmemo" value="${task.fmemo }" size="30" readonly="readonly"/>
				</div>
				<div class="divider">divider</div>
				<label>导师意见：</label>
				<textarea class="editor" name="task.fmentorOpinion"
					style="float: none; width: 90%; height: 200px" readonly="readonly">${task.fmentorOpinion }</textarea>
				
	           <div class="divider">divider</div>
              
				
			</div>
	   </div>
	</form>







</body>
</html>