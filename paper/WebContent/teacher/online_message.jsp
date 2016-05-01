<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已回复咨询</title>
<style type="text/css">
#main {
	height: 435px; :
	color: #2e3231;
	font-size: 13px;
	overflow: auto;
}

#main div {
	font-size: 13px;
}

.total {
	width: 800px;
	border: 2px solid #e9f8fb;
	margin-bottom: 5px;
	margin-top: 10px;
}

.top {
	width: 800px;
	height: 30px;
	background-color: #e9f8fb;
	line-height: 30px;
}

.top div {
	height: 30px;
	line-height: 30px;
}

.flag1 {
	color: #888888;
	float: left;
}

.flag2 {
	
	float: left;
}

.name {
	float: left;
	margin-left: 20px;
}



.isTop {
	color: #fc6e6d;
	float: right;
	margin-right: 10px;
}

.qTime {
	float: right;
	margin-right: 5px;
}

.title {
	width: 800px;
	margin-top: 20px;
	margin-left: 30px;
}

.qContents {
	width: 700px;
	margin-top: 20px;
	margin-left: 60px;
	border-bottom: 1px solid #cecece;
	padding-bottom: 30px;
}

.rContents {
	width: 700px;
	background-color: #e9f7fa;
	margin-left: 50px;
	margin-bottom: 20px;
}

.rContents1 {
	width: 700px;
	margin-top: 20px;
	margin-left: 10px;
	padding-top: 30px;
}

.rContents2 {
	width: 700px;
	margin-top: 20px;
	margin-left: 10px;
	padding-top: 30px;
	color: red
}

.rTime {
	margin-left: 500px;
	margin-top: 20px;
	color: #888888;
	padding-bottom: 20px;
	height: 20px;
}

.manage {
	width: 800px;
	height: 30px;
	background-color: #fafafa;
}

.manage div {
	height: 20px;
	background-color: #e3e1e2;
	width: 30px;
	float: right;
	margin-right: 20px;
	margin-top: 5px;
	text-align: center;
}

.manage div a {
	line-height: 20px;
	color: #848283;
}

.manage div a:hover {
	line-height: 20px;
	color: red;
}
</style>
</head>

<form id="pagerForm" method="post"	action="/paper/teacher/consultation_findTeacherAllOut">
	<input type="hidden" name="status" value="${param.status}"> 
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" /> 
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" /> 
	<input type="hidden" name="orderField" value="${param.orderField}" /> 
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" /> 
	<input type="hidden" name="property" value="${property}"> 
	<input type="hidden" name="key" value="${key}">
</form>
<div id="main">
	<c:if test="${empty list }">
		<div
			style="text-align: center; font-size: 16px; height: 435px; line-height: 435px; color: red">您还没有进行回复,或者还没有同学咨询</div>
	</c:if>
	<c:if test="${not empty list }">
		<c:forEach var="m" items="${list }">
			<div class="total">
				<div class="manage">
						<div class="delete"><a href="/paper/teacher/noticeInformation_deleteMessageAlready?fid=${m.fid }" target="ajaxTodo" title="确实要删除该咨询吗？">删除</a></div>
						<div class="edit"><a href="/paper/teacher/noticeInformation_findByTeacherFidAlready?fid=${m.fid }" target="navTab">修改</a></div>
				</div>
				<div class="top">
					<div class="name"><div class="flag1">咨询者：</div>${m.fstudentName}</div>
					<div class="qTime"><div class="flag1">${m.fqueryTime }</div></div>
					<c:if test="${m.fisTop==1 }"><div class="isTop">置顶</div></c:if>
				</div>
				<div class="title"><div class="flag2">问题：</div>${m.ftitle }</div>
				<div class="qContents">${m.fcontent }</div>
				<div class="rContents">
					<div class="rContents1"><div class="flag2">答复：</div>${m.freply }</div>
					<div class="rTime">${m.freplyTime }</div>
				</div>
			</div>
	</c:forEach>
	</c:if>
</div>

<div class="panelBar">
	<div class="pages">
		<span>显示</span> <select class="combox" name="numPerPage"
			onchange="navTabPageBreak({numPerPage:this.value})">
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

	<div class="pagination" targetType="navTab"
		totalCount="${page.totalCount}" numPerPage="${page.numPerPage}"
		pageNumShown="${page.pageNumShown}" currentPage="${page.pageNum }"></div>
</div>
