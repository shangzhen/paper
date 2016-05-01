
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生论文</title>
</head>
<body>

	<form action="/student/paper_save" method="post">
		<!-- 学生论文内容 -->
		<div>

			<div class="pageContent">
				<div class="panelBar">
					<!-- papers_Upload.jsp -->
					<ul class="toolBar">
						<li><a class="add" href="/paper/student/paper_findfno"
							target="navTab"><span>添加</span></a></li>
						<li class="line">line</li>
						<li><a class="delete"
							href="/paper/student/paper_delete?id={sid_user}"
							target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
						<li class="line">line</li>
						<!-- papers_View.jsp -->
						<li><a class="edit"
							href="/paper/student/paper_findByid?id={sid_user}"
							target="navTab"><span>查看</span></a></li>
						<li class="line">line</li>
					</ul>
				</div>
				<table class="list" width="100%" layoutH="120"
					style="border: 1px solid #786;">
					<thead>
						<tr>

							<th width="100" align="center">id</th>
							<th width="100" align="center">版次</th>
							<th width="300" align="center">标题</th>
							<th width="200" align="center">论文附件</th>
							<th width="200" align="center">PPT附件</th>
							<th width="200" align="center">源程序附件</th>
							<th width="200" align="center">查重附件</th>
							<th width="450" align="center">评阅意见</th>
							<th width="100" align="center">状态</th>
						</tr>
					</thead>
					<c:forEach items="${paperDatails }" var="list">
						<tbody>
							<tr align="center" target="sid_user" rel="${list.fid }">
								<td>${list.fid }</td>
								<td>${list.frevision }</td>
								<td>${list.ftitle }</td>
								<td><c:if test="${empty list.fthesisAdjunct}">
										<a class="button"
											href="/paper/student/paper_upload11?id=${list.fid }"
											target="dialog" rel="dlg_page1"><span>上传</span></a>
									</c:if> <c:if test="${not empty  list.fthesisAdjunct }">
										<a class="button"><span style="color: red;">已经上传</span></a>
									</c:if></td>
								<td><c:if test="${empty list.fpptAdjunct}">
										<a class="button"
											href="/paper/student/paper_upload12?id=${list.fid }"
											target="dialog" rel="dlg_page2"><span>上传</span></a>
									</c:if> <c:if test="${not empty  list.fpptAdjunct }">
										<a class="button"><span style="color: red;">已经上传</span></a>
									</c:if></td>
								<td><c:if test="${empty list.fsourceCodeAdjunct}">
										<a class="button"
											href="/paper/student/paper_upload14?id=${list.fid }"
											target="dialog" rel="dlg_page3"><span>上传</span></a>
									</c:if> <c:if test="${not empty  list.fsourceCodeAdjunct }">
										<a class="button"><span style="color: red;">已经上传</span></a>
									</c:if></td>
								<td><c:if test="${empty list.fcheckAdjunct}">
										<a class="button"
											href="/paper/student/paper_upload13?id=${list.fid }"
											. target="dialog" rel="dlg_page4"><span>上传</span></a>
									</c:if> <c:if test="${not empty  list.fcheckAdjunct }">
										<a class="button"><span style="color: red;">已经上传</span></a>
									</c:if></td>
								<td>${list.freviewComment }</td>
								<td>${list.fidentification }</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>

		</div>
	</form>
</body>
</html>