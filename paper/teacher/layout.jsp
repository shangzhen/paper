<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="pageContent" style="padding: 5px">

		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:;"><span>开题报告</span></a></li>
						<li><a href="javascript:;"><span>任务书</span></a></li>
						<li><a href="javascript:;"><span>中期检查表</span></a></li>
						<li><a href="javascript:;"><span>学生论文</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent">
				<!-- 开题报告内容 -->
				<div>
					<!-- 左边学生名单 -->
					<div layoutH="50"
						style="float: left; display: block; overflow: auto; width: 240px; border: solid 1px #CCC; line-height: 21px; background: #fff">
						<ul class="tree treeFolder">

							<li><a target="navTab" href="javascript">学生名单</a>
								<ul>

									<c:forEach var="aa" items="${list }">
										<!-- href="fopen_report1.jsp" -->
										<li><a href="open_findByFno?fno=${aa.fno}" target="ajax"
											rel="jbsxBox">${aa.fno}</a></li>
									</c:forEach>
								</ul></li>
						</ul>
					</div>
					<!-- 右边选项卡内容 -->
					<div id="jbsxBox" class="unitBox" style="margin-left: 246px;">
						<!--#include virtual="list1.html" -->
					</div>

				</div>
				<!-- 任务书内容 -->
				  <div>
					<!-- 左边学生名单 -->
					<div layoutH="50"
						style="float: left; display: block; overflow: auto; width: 240px; border: solid 1px #CCC; line-height: 21px; background: #fff">
						<ul class="tree treeFolder">
							<li><a href="javascript">学生名单</a>
								<ul>
									<c:forEach var="aa" items="${list }">
										<li><a href="task_findByfid?fno=${aa.fno}" target="ajax"
											rel="jbsxBox1">${aa.fno}</a></li>
									</c:forEach>

								</ul></li>
						</ul>
					</div>
					<!--   右边选项卡的内容 -->
					<div id="jbsxBox1" class="unitBox" style="margin-left: 246px;">
						<!--#include virtual="list1.html" -->
					</div>

				</div>
				<!-- 中期检查表内容 -->
				<div>
					<div>
						<!-- 左边学生名单 -->
						<div layoutH="50"
							style="float: left; display: block; overflow: auto; width: 240px; border: solid 1px #CCC; line-height: 21px; background: #fff">
							<ul class="tree treeFolder">
								<li><a href="javascript">学生名单</a>
									<ul>
										<c:forEach var="aa" items="${list }">
											<!-- href="fopen_report3.jsp" -->
											<li><a href="check_findByfNo?fno=${aa.fno}"
												target="ajax" rel="jbsxBox2">${aa.fno}</a></li>
										</c:forEach>
									</ul></li>
							</ul>
						</div>
						<!--   右边选项卡的内容 -->
						<div id="jbsxBox2" class="unitBox" style="margin-left: 246px;">
							<!--#include virtual="list1.html" -->
						</div>
					</div>
				</div>
            <!-- 学生论文内容 -->
                       <!-- 学生论文内容 -->
            <div>
					<div>
						<!-- 左边学生名单 -->
						<div layoutH="50"
							style="float: left; display: block; overflow: auto; width: 240px; border: solid 1px #CCC; line-height: 21px; background: #fff">
							<ul class="tree treeFolder">
								<li><a href="javascript">学生名单</a>
									<ul>
										<c:forEach var="aa" items="${list }">
											<!-- href="fopen_report3.jsp" -->
											<li><a href="paper_findByfNo?fno=${aa.fno}"
												target="ajax" rel="jbsxBox3">${aa.fno}</a></li>
										</c:forEach>
									</ul></li>
							</ul>
						</div>
						<!--   右边选项卡的内容 -->
						<div id="jbsxBox3" class="unitBox" style="margin-left: 246px;">
							<!--#include virtual="list1.html" -->
						</div>
					</div>
				</div>
				
		
	     </div>

</body>
</html>