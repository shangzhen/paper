<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>常用文件</title>
</head>

<body>
<form id="pagerForm" method="post" action="/paper/student/student_findByProperty">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="property"  value="${property}">
    <input type="hidden" name="key"  value="${key}">
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="/paper/student/student_findByProperty" method="post">
	<div class="searchBar">		
		<table class="searchContent">
			<tr>
			<td>
				<select class="combox" name="property">
						<option value="fPublisher" >上传人查询</option>
					
					</select>
					</td>
				<td>
					文件：<input type="text" name="key" />
				</td>
				<td>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div>
				</td>
			</table>
			</div>		
		</form>
	</div>	


<div class="pageContent">
<!-- 	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="demo_page4.html" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div> -->
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				
				<th width="120" align="center">标题</th>
				<th width="80"align="center">上传人</th>
				<th width="100" align="center">上传时间</th>
				<th width="80" align="center">备注</th>
				<th width="50" align="center">下载</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="c"  items="${list }">
				<tr target="sid_user" rel="${c.ftitle }">
				<td align="center" >${c.ftitle }</td>
				<td align="center">${c.fpublisher }</td>
				<td align="center">${c.fupTime }</td>
				<td align="center">${c.fremark }</td>
				<td align="center"><a href="/paper/downFile?res=${c.ffilePath }" style="color:red">下载</a></td>
	
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
