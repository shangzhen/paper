<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进度管理</title>
</head>
<body>
<form id="pagerForm" method="post" action="/paper/time/time_findProperty">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"  value="${param.orderDirection}" />  
	<input type="hidden" name="property"  value="${property}">
    <input type="hidden" name="key"  value="${key}">
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="/paper/time/time_findProperty" method="post">
	<div class="searchBar">
		 <table class="searchContent">
			<tr>
				
				<td>
					查询类型:
				</td>
				<td>
					<select class="combox" name="property">
						<option value="ftid">教师工号</option>
						<option value="fremindContent">提醒内容</option>
						<option value="fremindTime">提醒时间</option>
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
					<li><a class="add" href="../teacher/timelimit_add.jsp" target="navTab"><span>添加</span></a></li>
					<li><a class="delete" href="/paper/time/time_delete?fid={sid_schedule}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
					<li><a class="edit" href="/paper/time/time_updateBegin?fid={sid_schedule}" target="navTab"><span>修改</span></a></li>
					<li><a class="edit" href="/paper/time/time_find?fid={sid_schedule}" target="navTab"><span>查看</span></a></li>
					<li class="line">line</li>
				</ul>
	</div>
		<table class="table" width="100%" layoutH="138">
				<thead>
					<tr>
						<th width="120" align="center">工作任务</th>
						<th width="120" align="center">时间要求</th>
						<th width="150" align="center">提醒内容</th>
						<th width="150" align="center">提醒时间</th>
						<th width="150" align="center">教师工号</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="time" items="${timelimitlist }">
						<tr target="sid_schedule" rel="${time.fid }">
							<td>${time.fjobTasks }</td>
							<td>${time.ftimeRequirement }</td>
							<td>${time.fremindContent }</td>
							<td>${time.fremindTime }</td>
							<td>${time.ftid }</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
<div class="panelBar">
		<div class="pages">
			<span>显示</span> <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<c:if test="${page.numPerPage eq '10' }">
					<option value="10" selected="selected">10</option>
					<option value="50">50</option>
					<option value="100">100</option>
					<option value="500">500</option>
				</c:if>
				<c:if test="${page.numPerPage eq '50' }">
					<option value="10">10</option>
					<option value="50" selected="selected">50</option>
					<option value="100">100</option>
					<option value="500">500</option>
				</c:if>
				<c:if test="${page.numPerPage eq '100' }">
					<option value="10">10</option>
					<option value="50">50</option>
					<option value="100" selected="selected">100</option>
					<option value="500">500</option>
				</c:if>
				<c:if test="${page.numPerPage eq '500' }">
					<option value="10">10</option>
					<option value="50">50</option>
					<option value="100">100</option>
					<option value="500" selected="selected">500</option>
				</c:if>
			</select> <span>条，共${page.totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab"	totalCount="${page.totalCount}" numPerPage="${page.numPerPage}"	pageNumShown="${page.pageNumShown}" currentPage="${page.pageNum}"></div>

	</div>
</div>

</body>
</html>