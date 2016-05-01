<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中期检查</title>
</head>
<body>
<form>
          <!-- 中期检查表内容 -->
            <div>
					
				<div class="pageContent">
					<div class="panelBar"><!-- papers_Upload.jsp -->
						<ul class="toolBar">
							<li><a class="add" href="/paper/student/che_findname" target="navTab"><span>添加</span></a></li>
							<li class="line">line</li>
							<li><a class="delete" href="/paper/student/che_findAlll?fno={sid_user}"  target="navTab"><span>修改</span></a></li>
							<li class="line">line</li><!-- papers_View.jsp -->
							<li><a class="edit" href="/paper/student/che_findfnno?fno={sid_user}"  target="navTab"><span>查看</span></a></li>
							<li class="line">line</li>
						</ul>
					</div>
					<table class="list" width="100%" layoutH="120" style="border: 1px solid #786;">
						<thead>
							<tr>
							
								<th width="100" align="center">学号</th>
								<th width="200" align="center">提交时间</th>
								<th width="150" align="center">课题题目</th>
								<th width="200" align="center">导师意见</th>
								<th width="200" align="center">导师评阅时间</th><!-- fReviewTime -->
								<th width="200" align="center">状态</th>
								
							</tr>
						</thead>
						   <tbody>
							<tr align="center" target="sid_user" rel="${check.fno }">
							    <td>${check.fno }</td>
								<td>${check.ftime }</td>
								<td>${check.ftitle }</td><!-- fThesisAdjunct -->
								<td>${check.ftutorEvaluation }</td>
								<td>${check.ftutorTime }</td>
								<td>${check.fmemo }</td>
							</tr>
						</tbody>	
					</table>
				</div>
	        </div>
	   </form> 
</body>
</html>