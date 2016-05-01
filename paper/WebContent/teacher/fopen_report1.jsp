<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>开题报告</title>

<!-- 开题报告 -->

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
						<li><a href="#"><span>第三页</span></a></li>
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
								<label>学号:</label> <input name="opening.fno" type="text" size="30"
									value="${opening.fno}" readonly="readonly" />
							</p>
							<p>
								<label>姓名:</label> <input name="ThesisList.fsName" type="text"
									size="30" value="<%=session.getAttribute("fname") %>"
									readonly="readonly" />
							</p>
							<p>
								<label>导师姓名职称:</label> <input name="opening.ftid" type="text"
									size="30" value="${opening.ftid}" />
							</p>
							<p>
								<label>开题时间:</label> <input name="opening.fopeningTime"
									type="text" size="30" value="${opening.fopeningTime}" />
							</p>
							<p>
								<label>课题题目:</label> <input name="opening.ftopicTitle"
									type="text" size="30" value="${opening.ftopicTitle}" />
							</p>
							<p>

								<label>课题来源:</label> <input type="radio"
									name="opening.ftopicSource" value="导师指定"
									<% if((session.getAttribute("list")).equals("导师指定"))
										out.print("checked='checked'"); 
									%> />导师指定
								<input type="radio" name="opening.ftopicSource" value="自定"
									<% if((session.getAttribute("list")).equals("自定"))
															out.print("checked='checked'"); %> />自定
								<input type="radio" name="opening.ftopicSource" value="其他来源"
									<% if((session.getAttribute("list")).equals("其他来源"))
															out.print("checked='checked'"); %> />其他来源
							</p>
							 <p>
							     <label>开题报告下载:</label><!-- "/paper/downFile?res= " -->
								<b><a href="${opening.fadjunct}" style="font-size: 16px;color: red;">下载</a></b>
							</p>

							<div class="divider">divider</div>
							<textarea class="editor" name="opening.fsubjectPurpose"
								style="float: none; width: 90%; height: 200px"><b>${opening.fsubjectPurpose}</b></textarea>
							<div class="divider">divider</div>
							<textarea class="editor" name="opening.fresearchObject"
								style="float: none; width: 90%; height: 200px"><b>${opening.fresearchObject}</b></textarea>
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
							<textarea class="editor" name="opening.fuseWay"
								style="float: none; width: 90%; height: 150px" value=""><b>${opening.fuseWay}</b></textarea>
							<div class="divider">divider</div>
							<textarea class="editor" name="opening.fexpectedResults"
								style="float: none; width: 90%; height: 150px" value=""><b>${opening.fexpectedResults}</b></textarea>
							<div class="divider">divider</div>
							<textarea class="editor" name="opening.fprogressPlan"
								style="float: none; width: 90%; height: 150px" value=""><b>${opening.fprogressPlan}</b></textarea>
						</div>
					</div>
				</div>
				<!--  第三页 -->
				<div>
					<div class="pageContent"
						style="border: 1px #B8D0D6 solid; background-color: #fff;">
						<div class="pageFormContent" layoutH="110">
							<textarea class="editor" name="opening.freference"
								style="float: none; width: 90%; height: 120px" value=""><b>${opening.freference}</b></textarea>
							<div class="divider">divider</div>
							<textarea class="editor" name="opening.fmentorOpinion"
								style="float: none; width: 90%; height: 120px" value=""><b>${opening.fmentorOpinion}</b></textarea>
						
					<br /><br />
						<!-- 按钮 -->
					<div class="button" style="float: right;margin-right: 5px;padding-right: 10px;"><div class="buttonContent"><button>不通过</button>&nbsp;</div></div>
					
					<div class="button" style="float: right;margin-right: 5px;padding-right: 10px;"><div class="buttonContent"><button>通过</button></div></div>
						
						
						
						
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
