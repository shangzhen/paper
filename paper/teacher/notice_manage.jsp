<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>答辩公告</title>
</head>
<body>
<form id="pagerForm" method="post" action="/paper/noti/notice_findProperty">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="key" value="${key}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="property"  value="${property}">
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="/paper/noti/notice_findProperty" method="post">
	<div class="searchBar">
		 <table class="searchContent">
			<tr>
				
				<td>
					查询类型:
				</td>
				<td>
					<select class="combox" name="property">
						<option value="fdefencetime">答辩时间</option>
						<option value="freleaseperson">发布人</option>
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
			<li><a class="add" href="../teacher/notice_add.jsp" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="/paper/noti/notice_delete?fid={sid_notice}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="/paper/noti/notice_find?fid={sid_notice}" target="navTab"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120" align="center">答辩时间</th>
				<th width="120" align="center">答辩地点</th>
				<th width="120" align="center">路线</th>
				<th width="120" align="center">发布时间</th>
				<th width="120" align="center">发布人</th>
				<th width="120" align="center">备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="n" items="${noticeList}">
				<tr target="sid_notice" rel="${n.fid}">
					<td>${n.fdefencetime }</td>
					<td>${n.fdefenceplace }</td>
					<td>${n.froute }</td>
					<td>${n.freleasetime }</td>
					<td>${n.freleaseperson }</td>
					<td>${n.fmemo }</td>
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