<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
</head>
<body>
<form id="pagerForm" method="post" action="/paper/stu/student_findProperty">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="key" value="${key}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="property"  value="${property}">
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="/paper/stu/student_findProperty" method="post">
	<div class="searchBar">
		 <table class="searchContent">
			<tr>
				
				<td>
					查询类型:
				</td>
				<td>
					<select class="combox" name="property">
						<option value="fno">学生学号</option>
						<option value="fname">学生姓名</option>
						<option value="ftutorName">导师姓名</option>
					</select>
				</td>
				<td>
					查询的值：<input type="text" name="key" />
				</td>
			</tr>
		</table> 
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
<!-- 添加   删除  修改 -->

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="../teacher/student_add.jsp" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="/paper/stu/student_delete?fno={sno_task}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="/paper/stu/student_find?fno={sno_task}" target="navTab"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120" align="center">学生学号</th>
				<th width="120" align="center">题目名称</th>
				<th width="120" align="center">学院</th>
				<th width="120" align="center">姓名</th>
				<th width="120" align="center">专业</th>
				<th width="120" align="center">导师姓名</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="t" items="${taskList}">
				<tr target="sno_task" rel="${t.fno}">
					<td>${t.fno}</td>
					<td>${t.ftitle }</td>
					<td>${t.fcollege}</td>
					<td>${t.fname }</td>
					<td>${t.fmajor }</td>
					<td>${t.ftutorName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<c:if test="${page.numPerPage eq '10' }">
					<option value="10" selected="selected">10</option>
					<option value="50">50</option>
					<option value="100">100</option>
					<option value="500">500</option>
				</c:if>
				<c:if test="${page.numPerPage eq '50' }">
					<option value="10" >10</option>
					<option value="50" selected="selected">50</option>
					<option value="100">100</option>
					<option value="500">500</option>
				</c:if>
				<c:if test="${page.numPerPage eq '100' }">
					<option value="10" >10</option>
					<option value="50" >50</option>
					<option value="100" selected="selected">100</option>
					<option value="500">500</option>
				</c:if>
				<c:if test="${page.numPerPage eq '500' }">
					<option value="10" >10</option>
					<option value="50" >50</option>
					<option value="100" >100</option>
					<option value="500" selected="selected">500</option>
				</c:if>
			</select>
			<span>条，共${page.totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="10" currentPage="${page.pageNum }"></div>

	</div>
</div>

</body>
</html>