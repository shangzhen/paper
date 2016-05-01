<form id="pagerForm" method="post" action="studentList.jsp">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="studentAdd.jsp" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="studentEdit.jsp?uid={sid_user}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
			    
			    <th width="120" align="center">学号</th>
				<th width="150" align="center">姓名</th>
				<th width="150" align="center">系别</th>
				<th width="150" align="center">专业</th>
				<th width="120" align="center">指导教师工号</th>
				<th width="150" align="center">指导教师姓名</th>
				<th width="100" align="center">学生状态</th>
				<th width="100" align="center">手机号码</th>
				<th width="150" align="center">密码</th>
				
				<th width="100" align="center">备注</th>
			</tr>
		</thead>
		<tbody>
			<tr target="sid_user" rel="1">
				<td>20151234001</td>
				<td>张三</td>
				<td>软件工程系</td>
				<td>软件工程</td>
				<td>2015001</td>
				<td>李四</td>
				<td>在学</td>
				<td>13012341234</td>
				<td>2015123</td>
				<td>无</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>20151234001</td>
				<td>张三</td>
				<td>软件工程系</td>
				<td>软件工程</td>
				<td>2015001</td>
				<td>李四</td>
				<td>在学</td>
				<td>13012341234</td>
				<td>2015123</td>
				<td>无</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>20151234001</td>
				<td>张三</td>
				<td>软件工程系</td>
				<td>软件工程</td>
				<td>2015001</td>
				<td>李四</td>
				<td>在学</td>
				<td>13012341234</td>
				<td>2015123</td>
				<td>无</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>20151234001</td>
				<td>张三</td>
				<td>软件工程系</td>
				<td>软件工程</td>
				<td>2015001</td>
				<td>李四</td>
					<td>在学</td>
				<td>13012341234</td>
				<td>2015123</td>
				<td>无</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>20151234001</td>
				<td>张三</td>
				<td>软件工程系</td>
				<td>软件工程</td>
				<td>2015001</td>
				<td>李四</td>
				<td>在学</td>
				<td>13012341234</td>
				<td>2015123</td>
				<td>无</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>20151234001</td>
				<td>张三</td>
				<td>软件工程系</td>
				<td>软件工程</td>
				<td>2015001</td>
				<td>李四</td>
					<td>在学</td>
				<td>13012341234</td>
				<td>2015123</td>
				<td>无</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>20151234001</td>
				<td>张三</td>
				<td>软件工程系</td>
				<td>软件工程</td>
				<td>2015001</td>
				<td>李四</td>
					<td>在学</td>
				<td>13012341234</td>
				<td>2015123</td>
				<td>无</td>
			</tr>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>

	</div>
</div>
