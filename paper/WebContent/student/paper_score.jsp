<%@page import="henu.bean.Review"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="henu.bean.Score"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论文成绩</title>
<style type="text/css">
	.label {width:350px; line-height:30px;}
	table tr td{width:250px;}
	.table1{ border-collapse:collapse;}
	.table1 tr td{width:200px;}
	.span{color:red}
	.pageFormContent p input{border:0px;}
	.table input{border:0px;}
	.unit textarea{border:0px;}
</style>
</head>
<body>
	<div class="pageFormContent" layoutH="58">
<%-- <%
     Score score = (Score)ServletActionContext.getRequest().getSession().getAttribute("score");
     Review review = (Review)ServletActionContext.getRequest().getSession().getAttribute("review");
%> --%>
				<label><b>学生信息</b></label>
			
			<div class="divider">divider</div>
			
			<table class="table1">
				<tr height="30px" >
					<td>学&nbsp;&nbsp;号:</td>
					<td>${score.fno } </td>
					<td>姓&nbsp;&nbsp;名： </td>
					<td>${score.fname } </td>
					<td>专&nbsp;&nbsp;业： </td>
					<td>${score.fmajor } </td>
				</tr>
				
				<tr  height="30px">
					<td>指&nbsp;导&nbsp;老&nbsp;师：</td>
					<td>${score.ftutorName } </td>
					
					<td>论&nbsp;文&nbsp;题&nbsp;目：</td>
					<td colspan="3">${score.ftitle } </td>
				</tr>
				
			</table>
			
			<!-- <p>
				<label></label>
				<input disabled="true" size="20" name="" value=/>
			</p> -->
<!-- 指导教师 -->
			<div class="divider">divider</div>
			
				<b>指导教师（指导教师对毕业论文设计、创作评分）</b>
			
			<div class="divider">divider</div>
			<table class="table">
				<tr height="38px">
					<td>撰写开题报告、文献综述（15分）：</td>
					<td>${score.fopenReportScore } </td>
					
					<td>调查研究查阅整理资料（10分）：</td>
					<td>${score.fvarcharScore } </td>
				</tr>
				
				<tr  height="38px">
					<td>学习态度与规范要求（10分）：</td>
					<td>${score.fattitude } </td>
					
					<td>数据处理与文字表达（10分）：</td>
					<td>${score.fshowScore }</td>
				</tr>
				<tr  height="38px">
					<td>论文质量和创新意识（55分）：</td>
					<td>${score.fqualityScore } </td>
					
					<td>合计（共100分）：</td>
					<td>${score.fscoreSum } </td>
				</tr>
				
				
			</table>
			
			<div class="unit">
				<label>指导教师评语：</label>
				<textarea disabled="true" style="width:50%;height:30px" name="" >
					${score.fcoach }
				</textarea> 
            <br/>
			</div>
			 
<!-- 评阅教师 -->
			<div class="divider">divider</div>
			<b>评阅教师（评阅教师对毕业论文设计、创作评分）</b>
			<div class="divider">divider</div>
					
				<table class="table">
				<tr height="38px">
					<td>撰写开题报告、文献综述（15分）：</td>
					<td>${score.fcommentReportScore } </td>
					
					<td>调查研究查阅整理资料（10分）：</td>
					<td>${score.fcommentVarcharScore } </td>
				</tr>
				
				<tr  height="38px">
					<td>学习态度与规范要求（10分）：</td>
					<td>${score.fcommentAttitude } </td>
					
					<td>数据处理与文字表达（10分）：</td>
					<td>${score.fcommentShowScore } </td>
				</tr>
				<tr  height="38px">
					<td>论文质量和创新意识（55分）：</td>
					<td>${score.fcommentQualityScore } </td>
					
					<td>合计（共100分）：</td>
					<td>${score.fcommentScoreSum } </td>
				</tr>
			</table>
			
			<div class="unit">
				<label>评阅教师评语：</label>
				<textarea disabled="true" style="width:50%;height:30px" name="">
					${score.fcommentTeacher }
				</textarea> 
            <br/>
			</div>
			<br>
			<br>
			<table class="table">
				<tr height="38px">
					<td>教&nbsp;师&nbsp;平&nbsp;均&nbsp;得分：</td>
					<td>80</td>
				</tr>
				
			</table>
			 
<!-- 答辩老师评分 -->
			<div class="divider">divider</div>
			<b>答辩委员会评语及评分</b>
			<div class="divider">divider</div>
			
			<table>
				
				<tr  height="38px">
					<td>内容表达情况（15分）：</td>
					<td>${review.fcontentScore } </td>
					
					<td>答辩问题情况（25分）：</td>
					<td>${review.fscoreDefense } </td>
				</tr>
				<tr  height="38px">
					<td>规范要求与文字表达（20分）：</td>
					<td>${review.fwordScore } </td>
					
					<td>论文（设计、质量）质量和创新意识：</td>
					<td>${review.fqualityScore } </td>
				</tr>
			</table>
			
			<div class="unit">
				<label>答辩委员会评语：</label>
				<textarea disabled="true" style="width:50%;height:30px" name="">
					${review.fcomment }
				</textarea> 
            <br/>
			</div>
			<div class="divider">divider</div>
			<table widht="800px">
				<tr height="38px">
					<td>论文成绩综合评定：</td>
					<td>${review.fcomprehensiveScore } </td>
				</tr>
			</table>
			<p>
				<label>综合评定等级</label>
				<input disabled="true"  name="" value=${review.frating } />
				
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="beizhu.jsp"  target="dialog" mask="true" 
				title="备注"  width="750" height="500"><span class="span">备注</span></a>
			</p>
			
				
			
	</div>
	
</body>
</html>