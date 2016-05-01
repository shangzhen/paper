<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>学生状态管理</title>  
   

<form id="pagerForm" method="post" action="/paper/paperstate/paperstate_findAll">
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
	<form onsubmit="return navTabSearch(this);" action="/paper/paperstate/paperstate_findByProperty" method="post">
	<div class="searchBar">

		<table class="searchContent">
			<tr>
				<td>
					查询：
				</td>
				<td>
					<select class="combox" name="property">
						<option value="">请选择查询方式</option>
						<option value="fNo">按学生学号精确查找</option>						
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
			<li><a class="edit" href="/paper/paperstate/paperstate_findByfno?fno={stu_id}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>学号</th>
				<th>开题报告</th>
				<th>任务书</th>
				<th>中期检查</th>
				<th>初稿</th>
				<th>终稿</th>
				<th>查重</th>
				<th>参加答辩</th>
				<th>成绩评定</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach  var="n"  items="${list }">
				<tr target="stu_id" rel="${n.fno}">
					<td align="center">${n.fno}</td>
					<td align="center">${n.fopenReport }</td>
					<td align="center">${n.ftaskBook }</td>
					<td align="center">${n.fmidInspect }</td>
					<td align="center">${n.ffirstDraft }</td>
					<td align="center">${n.ffinalDraft }</td>
					<td align="center">${n.fcheck }</td>
					<td align="center">${n.fjoinDefence }</td>
					<td align="center">${n.fscoreJudge }</td>
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