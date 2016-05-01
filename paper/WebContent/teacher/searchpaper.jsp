<%@page import="henu.bean.PaperDetails"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看论文</title>
</head>
<body>
	<%
		PaperDetails paper = (PaperDetails)request.getAttribute("paperDetails");
	%>
		<!-- <form method="post" action="user_add1" class="pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);"> -->
		<div class="pageFormContent" layoutH="58">
			<div>
				<label><b>学生信息</b></label>
			</div>
			<div class="divider">divider</div>
			<p>
				<label>学&nbsp;&nbsp;号:</label>
				<input type="text" size="20" name="" value=<%=paper.getFno()%> />
			</p>
			<p>
				<label>标&nbsp;&nbsp;题：</label>
				<input type="text" size="20" name="" value=<%=paper.getFtitle() %> />
			</p>
			<p>
				<label>版&nbsp;&nbsp;次：</label>
				<input type="text" size="20" name="" value=<%=paper.getFrevision() %> />
			</p>
			<p>
				<label>重&nbsp;复&nbsp;率：&nbsp;&nbsp;</label>
				<input type="text" size="20" name="" value=<%=paper.getFrepetitionRate() %> />
				
			</p>
			<p>
				<label>上&nbsp;传&nbsp;时&nbsp;间：</label>
				<input type="text" size="20" name="" value=<%=paper.getFuploadTime() %> />
			</p>
			<p>
				<label>标&nbsp;示：</label>
				<input type="text" size="20" name=""  value=<%=paper.getFidentification() %> />
			</p>
			<div class="unit">
				<label>修&nbsp;改&nbsp;内&nbsp;容：</label>
				<textarea style="width:50%;height:50px" name="PaperDetails.fmodifyContent">
				</textarea>
            <br/>
			</div>
			<div class="divider">divider</div>
				
			<div>
				<label><b>论文下载</b></label>
			</div>
			<div class="divider">divider</div>
				
			<form action="downFile?res=<%=paper.getFthesisAdjunct() %>" method="post">
				<label>论文附件下载：</label>
				<input type="submit" value="下载" />
			</form>
			<br/>
			<form action="downFile?res=<%=paper.getFpptAdjunct() %>" method="post">
				<label>PPT附件下载：</label>
				<input type="submit" value="下载" />
			</form>
			<br/>
			<form action="downFile?res=<%=paper.getFsourceCodeAdjunct() %>" method="post">
				<label>源程序附件下载：</label>
				<input type="submit" value="下载" />
			</form>
			<br/>
				
			<div class="divider">divider</div>
			<div>
				<label><b>论文评阅</b></label>
			</div>
			
			<div class="divider">divider</div>
			<br/>
			
			
			
			
			
		<div>
				<div>
					<label>上传教师评阅论文：</label>
					<form action="paperupload?fid=<%=paper.getFid() %>" method="post"  class="pageForm" 
						  enctype="multipart/form-data" >
						<input type="file" name="upload" />
						<input type="submit" value="开始上传"/>
							<%
								Date date1 = new Date();
								DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String time1=format1.format(date1);
							 %>
							
						<input type="hidden" name="paperdetail.freviewTime" value=<%=time1 %> />
					</form>
				
				</div>
				<br/>
				<br/>
				<br/>
				<form method="post" action="paperadd?fid=<%=paper.getFid() %>" method="post" enctype="multipart/form-data"
				  class="pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
				<label>教师评阅论文评语：</label>
				<textarea style="width:50%;height:50px" name="paperdetail.freviewComment">
				
				</textarea>
				<%
				Date date = new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				 %>
			<input type="hidden" name="paperdetail.freviewTime" value=<%=time %> />
			
            <br/>
					<div class="formBar">
						<ul>
							<li><div class="buttonActive">
									<div class="buttonContent">
										<button type="submit">提交</button>
									</div>
								</div></li>
							<li><div class="buttonActive">
									<div class="buttonContent">
										<button type="reset">清空重输</button>
									</div>
								</div></li>
						</ul>
					</div>
				</form>
		</div>
		</div>
	
</body>
</html>