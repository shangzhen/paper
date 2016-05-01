<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评审论文</title>
<style>
  table tbody a{
    border:1px solid Silver;
    padding:1px;
    margin:0px auto;
    border-radius:4px;
    margin-right:8px;
    margin-left: 5px;
  }
   
  table tbody a:HOVER {
	/* border:1px solid CadetBlue; */
	text-decoration:none;
	background-color: LightSkyBlue;
}
  
</style>
</head>
<body>
<form id="pagerForm" method="post" action="/paper/teacher/ShowStuPaperList">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" /><!-- 当前页参数 -->
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" /><!-- 每页显示多少条 -->
	<input type="hidden" name="orderField" value="${param.orderField}" /> 
    <input type="hidden" name="orderDirection"  value="${param.orderDirection}" />  
    <input type="hidden" name="property"  value="${property}">
   
</form>
<div class="pageContent">
	  <form onsubmit="return navTabSearch(this);" action="" method="post">
	  <h2 class="contentTitle">成绩评定</h2>
	　      <table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="300" align="center">姓名</th>
					<th align="center">题目</th>
					<th width="100" align="center">状态|分数</th>
					<th width="250" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="scoreList" var="student">
				
				<tr>
					<td><s:property value="#student.fname"/></td>
					<td><s:property value="#student.fno"/></td>
					<td><s:property value="#student.fstate"/>&nbsp;&nbsp;<s:property value="#student.fscoreSum"/></td>
					<td>
					<a  href="searchscore?review.fno=<s:property value="#student.fno"/>" target="dialog" mask="true" title="成绩评定" width="800" height="500"><span><b>答辩成绩评定</b></span></a>
					
						<%-- 
						<a  href="pingding3.jsp?sno=<s:property value="#student.fNo"/>&&
								sname=<s:property value="#student.fName"/>&&
								smajor=<s:property value="#student.fMajor"/>&&
								sftutorName=<s:property value="#student.fTutorName"/>" 
								target="dialog" mask="true" title="成绩评定" width="800" height="500"><span><b>成绩评定</b></span></a>
								 --%>
					<a  href="pingyu3?sno=<s:property value="#student.fno"/>"
								 target="dialog" mask="true" title="成绩评定"  width="600" height="300"><span><b>评语</b></span></a>
					</td>
				</tr>
				</s:iterator>
				
	　　　　　</tbody>
		</table>
	
	 </form>
	  <!-- 分页 -->
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

		<div class="pagination" targetType="navTab"	  totalCount="${page.totalCount}" numPerPage="${page.numPerPage}"	pageNumShown="${page.pageNumShown}"  currentPage="${page.pageNum}"></div>

	</div>
</div>

</body>
</html>