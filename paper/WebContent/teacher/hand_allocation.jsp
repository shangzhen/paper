<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手动分配</title>
</head>
<body>
<form id="pagerForm" method="post" action="/paper/stu/hand_findAll">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="property"  value="${property}">
    <input type="hidden" name="key"  value="${key}">
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="/paper/stu/hand_findAll" method="post">
	<div class="searchBar">
		<!--<ul class="searchContent">
			<li>
				<label>我的客户：</label>
			</li>
			<li>
			<select class="combox" name="province">
				<option value="">所有省市</option>
				<option value="北京">北京</option>
				<option value="上海">上海</option>
				<option value="天津">天津</option>
				<option value="重庆">重庆</option>
				<option value="广东">广东</option>
			</select>
			</li>
		</ul>
		-->
		<table class="searchContent">
			<tr>
				<td>
					查询:
				</td>
				<td>
					<select class="combox" name="property">
						<option value="">请选择查询方式</option>
						<option value="fgreade">按年级</option>
						<option value="fNo">按学号</option>
						<option value="fSname">按姓名</option>
						<!-- <option value="theme">按主题查询</option> -->
					</select>
				</td>
				<td>
					要查询的值：<input type="text" name="key" />
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
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" href="/paper/stu/hand_find?fno={sid_user}" target="navTab"><span>分配导师</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120" align="center">学号</th>
				<th width="120" align="center">姓名</th>
				<th width="100" align="center">专业</th>
				
				<th width="150" align="center">年级</th>
				<th width="150" align="center">籍贯</th>
				<th width="150" align="center">方向</th>
				
				<th width="150" align="center">辅导员姓名</th>
				<th width="150" align="center">辅导员工号</th>
				<th width="100" align="center">电话</th>
				<th width="130" align="center">邮箱</th>
				
				<th width="100" align="center">QQ号</th>
				<th width="100" align="center">实习单位</th>
				<th width="100" align="center">工作单位</th>
				
				<th width="100" align="center">状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${list }">
				<tr target="sid_user" rel="${c.fno }">
					<td>${c.fno }</td>
					<td>${c.fsname }</td>
					<td>${c.fmarjor }</td>
					
					<td>${c.fgreade }</td>
					<td>${c.fplace }</td>
					<td>${c.fclass }</td>
					
					<td>${c.fcnmae }</td>
					<td>${c.fcid }</td>
					<td>${c.fphone }</td>					
					
					<td>${c.femail }</td>
					<td>${c.fqq }</td>
					<td>${c.ftranning }</td>
					
					<td>${c.fwork }</td>
					<td>${c.fstate }</td>					
					
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
		
		<div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="${page.pageNumShown}" currentPage="${page.pageNum }"></div>

	</div>
</div>

</body>
</html>