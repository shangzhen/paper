<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预览页面</title>
</head>
<body>
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					确认分配请单击“分配”按钮，取消分配请直接关闭此选项卡！
				</td>
			</tr>
		</table>
	</div>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" href="/paper/Automatic/Automatic_distribution?fserialNo=${thesisList}" target="ajaxTodo" title="确定要分配吗?"><span>分配</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="150" align="center">学号</th>
				<th width="90" align="center">姓名</th>
				<th width="80" align="center">年级</th>
				<th width="90" align="center">专业</th>
				<th width="100" align="center">系别</th>
				<th width="80" align="center">指导老师工号</th>
				<th width="80" align="center">指导老师姓名</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${thesisList}">
				<tr >
					<td align="center">${c.fno}</td>
					<td align="center">${c.fsName}</td>
					<td align="center">${c.fgrade}</td>
					<td align="center">${c.fprofessional}</td>
					<td align="center">${c.fdepartment}</td>
					<td align="center">${c.ftid}</td>
					<td align="center">${c.ftName}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages"> 
			<!-- <span>共${page.totalCount}条</span> -->
		</div>
	</div>
</div>
</body>
</html>
