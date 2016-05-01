<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>答辩委员会评语及得分</title>
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
	 if((/^[.0-9]+$/).test(number) && number2>=0 && number2<=25)
	  return;
	 else
	  obj.value = number.substring(0,number.length-1);
}
function check2(obj)
{
	 var number = obj.value;
	 var number2 = parseInt(number);
	 if((/^[.0-9]+$/).test(number) && number2>=0 && number2<=20)
	  return;
	 else
	  obj.value = number.substring(0,number.length-1);
}
function check3(obj)
{
	 var number = obj.value;
	 var number2 = parseInt(number);
	 if((/^[.0-9]+$/).test(number) && number2>=0 && number2<=40)
	  return;
	 else
	  obj.value = number.substring(0,number.length-1);
}

function cal() {
	document.getElementById("sum").value = (parseInt(document
			.getElementById("text1").value)
			+ parseInt(document.getElementById("text2").value)
			+ parseInt(document.getElementById("text3").value)
			+ parseInt(document.getElementById("text4").value));
}

function cals() {
	document.getElementById("sum").value = (parseInt(document
			.getElementById("text1").value)
			+ parseInt(document.getElementById("text2").value)
			+ parseInt(document.getElementById("text3").value)
			+ parseInt(document.getElementById("text4").value));
}
function calall() {
	document.getElementById("sumall").value = 
		/* 答辩成绩*60% */
			(parseInt(document.getElementById("sum").value)*0.6
		/* 导师评定成绩*20% */
			+ (parseInt(document.getElementById("s1").value)
			+ parseInt(document.getElementById("s2").value)
			+ parseInt(document.getElementById("s3").value)
			+ parseInt(document.getElementById("s4").value)
			+ parseInt(document.getElementById("s5").value))*0.2
		/* 评阅老师评定成绩*20% */
			+ (parseInt(document.getElementById("s6").value)
			+ parseInt(document.getElementById("s7").value)
			+ parseInt(document.getElementById("s8").value)
			+ parseInt(document.getElementById("s9").value)
			+ parseInt(document.getElementById("s10").value))*0.2);
}

</script>
</head>
<body>
<div class="pageContent">


	<form method="post" action="/paper/teacher/add2" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
	
		<div class="divider">divider</div>
		<s:iterator value="score" var="score">
			<p>
				<label>学&nbsp;&nbsp;号:</label>
				<input type="text"  readonly="readonly"  size="20" name="review.fno" value="<s:property value="#score.fno"/>" />
			</p>
			<p>
				<label>姓&nbsp;&nbsp;名：</label>
				<input type="text"  readonly="readonly"  size="20" name="" value="<s:property value="#score.fname"/>" />
			</p>
			<p>
				<label>所&nbsp;在&nbsp;学&nbsp;院&nbsp;&nbsp;：</label>
				<input type="text"  readonly="readonly"  size="20" name="" value="<s:property value="#score.fmajor"/>" />
			</p>
			<p>
				<label>指&nbsp;导&nbsp;教&nbsp;师：&nbsp;&nbsp;</label>
				<input type="text" readonly="readonly" size="20" name="" value="<s:property value="#score.ftutorName"/>" />
				<input type="hidden" name="" id="" value="<s:property value="#score.fshowScore"/>" />
			</p>
			<!-- 获取指导老师评定成绩 -->
			<!-- 开题报告分值 -->
				<input type="hidden" name="" id="s1" value="<s:property value="#score.fopenReportScore"/>" />
			<!-- 整理资料分值 -->
				<input type="hidden" name="" id="s2" value="<s:property value="#score.fvarcharScore"/>" />
			<!-- 学习态度与规范要求 -->
				<input type="hidden" name="" id="s3" value="<s:property value="#score.fattitude"/>" />
			<!-- 文字表达分值 -->
				<input type="hidden" name="" id="s4" value="<s:property value="#score.fshowScore"/>" />
			<!-- 论文质量分值 -->
				<input type="hidden" name="" id="s5" value="<s:property value="#score.fqualityScore"/>" />
			<!-- 获取指导老师评定成绩 -->
			<!-- 评阅教师开题报名分值 -->
				<input type="hidden" name="" id="s6" value="<s:property value="#score.fcommentReportScore"/>" />
			<!-- 评阅教师整理资料分值 -->
				<input type="hidden" name="" id="s7" value="<s:property value="#score.fcommentVarcharScore"/>" />
			<!-- 评阅教师学习态读分值 -->
				<input type="hidden" name="" id="s8" value="<s:property value="#score.fcommentAttitude"/>" />
			<!-- 评阅教师文字表达分值 -->
				<input type="hidden" name="" id="s9" value="<s:property value="#score.fcommentShowScore"/>" />
			<!-- 评阅教师论文质量分值 -->
				<input type="hidden" name="" id="s10" value="<s:property value="#score.fcommentQualityScore"/>" />
				
			</s:iterator>
			<br />
			<div class="divider">divider</div>
			<div class="unit">
				<label><b>论文答辩小组评分:</b></label>
				<br />
			</div>
			<br />
			<p>
				<label>内容表达情况：</label>
				<input type="text" size="20" name="review.fcontentScore" id="text1" onkeyup="check(this)" />(15分)
			</p>
			<p>
				<label>答辩问题情况：</label>
				<input type="text" size="20" name="review.fscoreDefense" id="text2" onkeyup="check1(this)" />(25分)
			</p>
			<p>
				<label>规范要求.文字表达：</label>
				<input type="text" size="20" name="review.fwordScore" id="text3" onkeyup="check2(this)" />(20分)
			</p>
			<p>
				<label>论文质量.创新意识：</label>
				<input type="text" size="20" name="review.fqualityScore" id="text4" onkeyup="check3(this)" />(40分)
			</p>
			<p>
				<label>合计：(共100分)</label>
				<input disabled="true" size="20" name="" id="sum" />
				<input type="button" value="合计" onclick="cal();"/>
			</p>
			<br/>
			<!-- 获取当前时间 -->
			<%
				Date date = new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
			%>
			
			<input type="hidden" name="review.fdefenceTime" value=<%=time %> />
			
			<div class="divider">divider</div>
			<div class="unit">
				<label>论文成绩综合评定:(100分)</label>
				<input type="text" size="20" name="review.fcomprehensiveScore" id="sumall" readonly/>&nbsp;
				<input type="button" value="总分合计" onclick="calall();"/>
				<br></br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				（教师评阅表平均成绩占40%,答辩成绩占60%；90-100分（优），76-89（良），60-75（中），少于60（差））
			</div>
			<br/>
			<div class="divider">divider</div>
			<p>
				<label>综合评定等级</label>
				<input type="radio"  name="review.frating" value="优"/>优
				<input type="radio"  name="review.frating" value="良"/>良
				<input type="radio"  name="review.frating" value="中"/>中
				<input type="radio"  name="review.frating" value="差"/>差
				
			</p>
			<div class="divider">divider</div>
			<!-- <div class="divider">divider</div> -->
			
		</div>
		
		
		
		<div class="formBar">
			<ul>
				<li>
				   <div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div>
				</li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form> 
</div>
</body>