<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开题报告</title>
</head>
<body>
<form>
          <!-- 学生论文内容 -->
            <div>
					
				<div class="pageContent">
					<div class="panelBar"><!-- papers_Upload.jsp -->
						<ul class="toolBar">
							<li><a class="add" href="/paper/student/op_findname" target="navTab"><span>添加</span></a></li>
							<li class="line">line</li>
							<li><a class="delete" href="/paper/student/op_findAlll?fno={sid_user}"  target="navTab"><span>修改</span></a></li>
							<li class="line">line</li><!-- papers_View.jsp -->
							<li><a class="edit" href="/paper/student/op_findByid?fno={sid_user}"  target="navTab"><span>查看</span></a></li>
							<li class="line">line</li>
						</ul>
					</div>
					<table class="list" width="100%" layoutH="120" style="border: 1px solid #786;">
						<thead>
							<tr>
							
								<th width="100" align="center">学号</th>
								<th width="200" align="center">开题时间</th>
								<th width="150" align="center">课题题目</th>
								<th width="200" align="center">导师意见</th>
								<th width="200" align="center">导师评阅时间</th><!-- fReviewTime -->
								<th width="200" align="center">状态</th>
								
							</tr>
						</thead>
						   <tbody>
							<tr align="center" target="sid_user" rel="${opening.fno }">
							    <td>${opening.fno }</td>
								<td>${opening.fopeningTime }</td>
								<td>${opening.ftopicTitle }</td><!-- fThesisAdjunct -->
								<td>${opening.fmentorOpinion }</td>
								<td>${opening.freviewTime }</td>
								<td>${opening.fmemo }</td>
							</tr>
						</tbody>	
					</table>
				</div>
	        </div>
	   </form> 


</body>
</html>