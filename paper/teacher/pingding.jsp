<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>指导教师评价</title>

<script type="text/javascript">
function check(obj)
{
	 var number = obj.value;
	 var number2 = parseInt(number);
	 if((/^[.0-9]+$/).test(number) && number2>=0 && number2<=15)
	  return;
	 else
	  obj.value = number.substring(0,number.length-1);
}
function check1(obj)
{
	 var number = obj.value;
	 var number2 = parseInt(number);
	 if((/^[.0-9]+$/).test(number) && number2>=0 && number2<=10)
	  return;
	 else
	  obj.value = number.substring(0,number.length-1);
}
function check2(obj)
{
	 var number = obj.value;
	 var number2 = parseInt(number);
	 if((/^[.0-9]+$/).test(number) && number2>=0 && number2<=55)
	  return;
	 else
	  obj.value = number.substring(0,number.length-1);
}

	function cal() {
		document.getElementById("sum").value = (parseInt(document
				.getElementById("text1").value)
				+ parseInt(document.getElementById("text2").value)
				+ parseInt(document.getElementById("text3").value)
				+ parseInt(document.getElementById("text4").value) + parseInt(document
				.getElementById("text5").value));
	}
</script>
<style type="text/css">
	.pageFormContent label {margin-left:0px; width:250px; padding:0 5px; line-height:30px;}
</style>
</head>
<body>
<div class="pageContent">
<!--demo_page1.html  -->
<%
	String sno = request.getParameter("sno");
	String sname = request.getParameter("sname");
	String smajor = request.getParameter("smajor");
	String stutorname = request.getParameter("sftutorName");
	String sftitle = request.getParameter("sftitle");
%>


	<form method="post" action="user_add" class="pageForm" onsubmit="return validateCallback(this, navTabAjaxDone);">
		
		<div class="pageFormContent" layoutH="58">
			
			<div class="divider">divider</div>
			
			<div class="unit">
				<label>学&nbsp;&nbsp;号:</label>
				<input type="text" size="20" name="score.fno" value=<%=sno %> />
				
			</div>
			<div class="unit">
				<label>姓&nbsp;&nbsp;名：</label>
				<input type="text" size="20" name="score.fname" value=<%=sname %> />
				
			</div>
			<div class="unit">
				<label>专&nbsp;&nbsp;业：</label>
				<input type="text" size="20" name="score.fmajor" value=<%=smajor %> />
				
			</div>
			<div class="unit">
				<label>指&nbsp;导&nbsp;教&nbsp;师：&nbsp;&nbsp;</label>
				<input type="text" size="20" name="score.ftutorName" value=<%=stutorname %> />
				
			</div>
			<div class="unit">
				<label>论文题目：</label>
				<input type="text" size="20" name="score.ftitle"  value=<%=sftitle %> />
				
			</div>
			
			
			<!--教师评阅平均得分：?????  -->
			<!-- 用代码实现平均分功能 -->
			<!-- <div class="unit">
				<label>教师评阅平均得分：</label>
				<input type="text" size="20" name="score.fAverage"/>
				
			</div> -->
			
			
			
			<div class="divider">divider</div>
			<div class="divider">divider</div>
			<div class="unit">
				<label><b>评分项目分值</b></label>
				
			</div>
			<br>
			<br>
			<div class="unit">
				<label>开题报告.文献综述(15分)：</label>
				<input type="text" size="20" name="score.fopenReportScore"  id="text1" onkeyup="check(this)"/>
				
			</div>
			<div class="unit">
				<label>调查研究.整理资料(10分)：</label>
				<input type="text" size="20" name="score.fvarcharScore" id="text2" onkeyup="check1(this)" />
				
			</div>
			
		
			<!-- 数据库中没有这个字段 -->
			<div class="unit">
				<label>学习态度.规范要求(10分)：</label>
				<input type="text" size="20" name="score.fattitude"  id="text3" onkeyup="check1(this)" />
				
			</div> 
			
			<div class="unit">
				<label>数据处理.文字表达(10分)：</label>
				<input type="text" size="20" name="score.fshowScore" id="text4" onkeyup="check1(this)" />
				
			</div>
			<div class="unit">
				<label>论文质量.创新意识(55分)：</label>
				<input type="text" size="20" name="score.fqualityScore" id="text5"  onkeyup="check2(this)"/>
				
			</div>
			<%
				Date date = new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
			%>
			<input type="hidden" name="score.freviewTime" value=<%=time %>/>
			
			
			<div class="unit">
				<label>合计(100分)：</label>
				<input id="sum" name="sum" disabled="true" size="20" />&nbsp;
				<input type="button" value="合计" onclick="cal();"/>
			</div> 
		
			
			
			  
			 
			<!-- <div class="unit">
				<label>整理资料分值：</label>
				<input type="text" size="20" name="certNo"/>
				
			</div>
			<div class="unit">
				<label>文字表达分值：</label>
				<input type="text" size="20" name="certNo"/>
				
			</div>
			
			<div class="unit">
				<label>论文质量分值：</label>
				<input type="text" size="20" name="certNo"/>
				
			</div> -->
			<div class="divider">divider</div>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="reset">清空重输</button></div></div></li>
			</ul>
		</div>
		
	</form>
</div>
</body>
</html>