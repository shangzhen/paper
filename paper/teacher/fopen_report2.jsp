<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>任务书</title>


<!-- 任务书 -->

</head>
<body>
	<form method="post" action="demo/common/ajaxDone.html"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li class="selected"><a href="#"><span>第一页</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height: 100%;">
				<!--  第一页 -->
				<div>
					<div class="pageContent"
						style="border: 1px #B8D0D6 solid; background-color: #fff;">

						<div class="pageFormContent" layoutH="110">
							<p>
								<label>题目名称:</label> <input name="task.ftitle" type="text" size="30"
									value="${task.ftitle }" readonly="readonly" />
							</p>
							<p>
								<label>学院:</label> <input name="task.fcollege" type="text" size="30"
									value="${task.fcollege }" readonly="readonly" />
							</p>
							<p>
								<label>学生姓名:</label> <input name="task.fname" type="text" size="30"
									value="${task.fname }" readonly="readonly" />
							</p>
							<p>
								<label>学号:</label> <input name="task.fno" type="text" size="30"
									value="${task.fno }" readonly="readonly" />
							</p>
							<p>
								<label>所学专业:</label> <input name="task.fmajor" type="text" size="30"
									value="${task.fmajor }" readonly="readonly" />
							</p>
							<p>
								<label>导师姓名:</label> <input name="task.ftutorName" type="text" size="30"
									value="${task.ftutorName }" readonly="readonly" />
							</p>
							 <p>
							     <label>任务书下载:</label>
								<b><a href="${task.fadjunct}" style="font-size: 16px;color: red;">下载</a></b>
							</p>
							<div class="divider">divider</div>
							<textarea class="editor" name="task.frequire"
								style="float: none; width: 90%; height: 300px">${task.frequire }</textarea>
							<div class="divider">divider</div>
						    <br /><br />	
									<!-- 按钮 -->
					<div class="button" style="float: right;margin-right: 5px;padding-right: 10px;"><div class="buttonContent"><button>不通过</button>&nbsp;</div></div>
					
					<div class="button" style="float: right;margin-right: 5px;padding-right: 10px;"><div class="buttonContent"><button>通过</button></div></div>
						
						
					
						</div>
					</div>
				</div>
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>
		</from>
</body>
</html>
