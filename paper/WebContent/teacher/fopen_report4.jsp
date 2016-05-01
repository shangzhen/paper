<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生论文</title>
</head>
<body>

	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="demo_page1.html"
			method="post">
			<div class="searchBar"></div>
		</form>
	</div>
	<div class="pageContent">
		<!-- <div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="announce_add.jsp" target="navTab"><span>添加</span></a></li>
				<li class="line">line</li>
				<li><a class="delete"
					href="paperdelete?fid={sid_user}"
					target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li class="line">line</li>
				<li><a class="edit"
					href="/paper/announce/announce_findDetail?fId={sid_user}"
					target="navTab"><span>查看</span></a></li>
				<li class="line">line</li>
			</ul>
		</div> -->
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="30" align="center">版次</th>
					<th width="300" align="center">标题</th>
					<th width="350" align="center">评阅意见</th>
					<th width="150" align="center">上传时间</th>
					<th width="80" align="center">状态</th>
					<th width="100" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list }">
					<tr target="sid_user" rel="2" align="center" >
						<td><c:out value="${list.frevision }"></c:out></td>
						<td><c:out value="${list.ftitle }"></c:out></td>
						<td><c:out value="${list.freviewComment }"></c:out></td>
						<td><c:out value="${list.fuploadTime }"></c:out></td>
						<td><c:out value="${list.fidentification }"></c:out></td>
						<td>
							<a href="papersearch?fid=${list.fid }" rel="paperadd" target="dialog" mask="true" title="查看"  width="800" height="630">查看</a>&nbsp;
							<%-- <a href="paperdelete?fid=${list.fid }" target="ajaxTodo" title="确定要删除吗?">删除</a> --%>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>