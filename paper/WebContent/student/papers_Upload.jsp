<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论文上传页面</title>
</head>
<body>

	<form method="post" action="/paper/student/paper_save" enctype="multipart/form-data" onsubmit="return navTabSearch(this)">
	   <div class="pageContent">
			<div class="pageFormContent" layoutH="56" style="position: relative;">
				<h2 class="contentTitle">学生基本信息</h2>
				<div class="unit">
					<label>学号：</label>
					<input type="text" name="paperDetails.fno" value="<%=session.getAttribute("fff") %>" readonly="readonly" size="30"/>
				</div> 
				<div class="unit">
					<label>标题：</label>
					<input type="text" name="paperDetails.ftitle"  size="30"/>
				</div>
				<div class="unit">
					<label>上传时间：</label>
					 <input type="text" name="paperDetails.fuploadTime" class="date" readonly="true" size="30"/>
					 <a class="inputDateButton" href="javascript:;">选择</a>
				</div>
				<div class="unit">
					<label>重复率：</label>
					<input type="text" name="paperDetails.frepetitionRate"  size="30"/>
				</div>
				<div class="divider">divider</div>
				<textarea class="editor" name="paperDetails.fmodifyContent"
					style="float: none; width: 90%; height: 200px"><b>请输入留言：</b></textarea>
				
	          <div class="divider">divider</div>
              <br><br>
	            <!--   提交按钮 -->
	            <div class="button" style="float: right;margin-right: 10%">
	               <div class="buttonContent">
	               <button>&nbsp;&nbsp;提&nbsp;&nbsp;交 &nbsp;&nbsp;</button>
	               </div>
	            </div>
	           
				
			</div>
	   </div>
	</form>
</body>
</html>