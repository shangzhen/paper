<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>指导老师评语</title>
</head>
<body>
	<div class="pageContent" style="padding: 5px">

		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:;"><span>指导老师评语</span></a></li>
						<%-- <li><a href="javascript:;"><span>任务书</span></a></li>
						<li><a href="javascript:;"><span>中期检查表</span></a></li>
						<li><a href="javascript:;"><span>学生论文</span></a></li> --%>
					</ul>
				</div>
			</div>
			<div class="tabsContent">
				<!-- 开题报告内容 -->
				<div>
					<!-- 左边学生名单 -->
					<div layoutH="50"
						style="float: left; display: block; overflow: auto; width: 150px; border: solid 1px #CCC; line-height: 21px; background: #fff">
						<ul class="tree treeFolder">

							<li><a target="navTab" href="javascript">评语列表</a>
								<ul>

									<c:forEach var="acclaims" items="${acclaimlist }">
										<!-- href="fopen_report1.jsp" -->
										<li><a href="findmessage1?fnumber=${acclaims.fnumber}&&fno=${score.fno }"
											target="ajax" rel="jbsxBox">编号:${acclaims.fnumber}</a></li>
									</c:forEach>
								</ul></li>
						</ul>
						
					</div>
					<!-- 右边选项卡内容 -->
					<div id="jbsxBox" class="unitBox" style="margin-left: 246px;">
						<form method="post" action="addpingyu?fno=${score.fno }"
							class="pageForm"
							onsubmit="return validateCallback(this, navTabAjaxDone);">
							<div class="pageFormContent" layoutH="100">
								<div class="unit">
									<textarea style="width: 95%; height: 150px" name="score.fcoach">
										&nbsp;&nbsp;${acclaim.famessage }
									</textarea>
								</div>
							</div>
							<div class="formBar">
								<ul>
									<li><div class="buttonActive">
											<div class="buttonContent">
												<button type="submit">提交</button>
											</div>
										</div></li>
									<li><div class="buttonActive">
											<div class="buttonContent">
												<button type="reset">清空重输</button>
											</div>
										</div></li>
								</ul>
							</div>
						</form>
					</div> 
				
			</div>
		</div>


	</div>

</body>
</html>