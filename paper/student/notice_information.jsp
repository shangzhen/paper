<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<form id="pagerForm" method="post" action="/paper/stu/noticeInformation_findProperty">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" /> 
    <input type="hidden" name="orderDirection"  value="${param.orderDirection}" />  
    <input type="hidden" name="property"  value="${property}">
    <input type="hidden" name="key"  value="${key}">
</form>
<div class="pageContent">
	 	
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th align="left" width="150">标题</th>
				<th align="center" width="35">发布人</th>
				<th align="center" width="35">发布时间</th>
				<th align="center" width="15" style="color: red;">操作</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach  var="n"  items="${noticeList }">
				<tr target="sid_notice" rel="${n.fserialNo}">
					<td>${n.ftitle}</td>
					<td>${n.fpublisher}</td>
					<td>${n.fpublishMessage}</td>
					<td><a title="点击查看详情" target="navTab" href="/paper/stu/noticeInformation_find?fSerialNo=${n.fserialNo}" class="btnEdit"></a></td>			
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