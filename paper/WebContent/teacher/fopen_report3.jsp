<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>开题报告</title>

<!-- 中期检查表 -->

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
						<li><a href="#"><span>第二页</span></a></li>
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
								<label>题目名称:</label> <input name="check.ftitle" type="text" size="30"
									value="${check.ftitle }" readonly="readonly" />
							</p>
							<p>
								<label>学院</label> <input name="check.fcollege" type="text" size="30"
									value="${check.fcollege }" readonly="readonly" />
							</p>
							<p>
								<label>学生姓名:</label> <input name="check.fname" type="text" size="30"
									value="${check.fname }" readonly="readonly" />
							</p>
							<p>
								<label>学号:</label> <input name="check.fno" type="text" size="30"
									value="${check.fno }" readonly="readonly" />
							</p>
							<p>
								<label>所学专业:</label> <input name="check.fmajor" type="text" size="30"
									value="${check.fmajor }" readonly="readonly" />
							</p>
							 <p>
							     <label>中期检查表下载:</label>
								<b><a href="${check.fadjunct}" style="font-size: 16px;color: red;">下载</a></b>
							</p>
							<div class="divider">divider</div>
							<textarea class="editor" name="check.ffare"
								style="float: none; width: 90%; height: 200px"><b>${check.ffare }</b></textarea>
							<div class="divider">divider</div>
							<textarea class="editor" name="check.fproblem"
								style="float: none; width: 90%; height: 200px"><b>${check.fproblem }</b></textarea>
							<div class="divider">divider</div>
						</div>
					</div>
				</div>
				<!--  第二页 -->
				<div>
					<div class="pageContent"
						style="border: 1px #B8D0D6 solid; background-color: #fff;">
						<div class="pageFormContent" layoutH="110">
							<div class="divider">divider</div>
							<textarea class="editor" name="check.fselfEvaluation"
								style="float: none; width: 90%; height: 150px"><b>${check.fselfEvaluation }</b></textarea>
							<div class="divider">divider</div>
							<textarea class="editor" name="check.ftutorEvaluation"
								style="float: none; width: 90%; height: 150px"><b>${check.ftutorEvaluation }</b></textarea>
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
