<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>综合成绩表</title>
<style type="text/css">
	h2,h4{text-align:center;}
	.span{text-align:right;float:right;}
	table{margin:auto;}
	table tr td{width:80px;height:32px;border:1px solid black;margin-right:auto;}
</style>
</head>
<body>
<h2>河南大学2015届毕业论文成绩表</h2>
<h4>学院名称：软件学院</h4>
<div>
<br/>
		<table border="1px" cellspacing="0">
		<!-- 第一行 -->
			<tr>
				<td colspan="2">学号</td>
				<!-- <td></td> -->
				<td>${score.fno }</td>
				<td>姓名</td>
				<td>${score.fname }</td>
				<td colspan="2">专业</td>
				<!-- <td></td> -->
				<td colspan="2">${score.fmajor }</td>
				<!-- <td></td> -->
			</tr>
			<!-- 第二行 -->
			<tr height="40px">
				<td colspan="2" rowspan="2">指导教师</td>
				<!-- <td></td> -->
				<td colspan="3" rowspan="2">${score.ftutorName }</td>
				<!-- <td></td>
				<td></td> -->
				<td colspan="2" rowspan="2">教师评阅平均得分</td>
				<!-- <td></td> -->
				<td colspan="2" rowspan="2">${score.faverage }</td>
				<!-- <td></td> -->
			</tr>
			
			<tr>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td> 
				<td></td>
				<td></td>
				<td></td> 
				<td></td> 
				<td></td> -->
			</tr>
			<!-- 第三行 -->
			<tr>
				<td colspan="2">论文题目</td>
				<!-- <td></td> -->
				<td colspan="7">${score.ftitle }</td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			<!-- 指导教师 -->
			<!-- 第四行 -->
			<tr height="60px">
				<td rowspan="5">指导教师评语以及得分</td>
				<td >指导教师评语</td>
				<td colspan="7">${score.fcoach }</td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			<!-- 第六行 -->
			<tr>
				<!-- <td></td> -->
				<td rowspan="2">评分项目分值</td>
				<td colspan="7">指导教师对毕业论文（设计、创作）评分</td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			<!-- 第六行 -->
			<tr height="80px">
				<!-- <td></td> -->
				<!-- <td></td> -->
				<td>撰写开题报告、文献综述（15分）</td>
				<td>调查研究查阅整理资料（10分）</td>
				<td>学习态度与规范要求（10分）</td>
				<td>数据处理、文字表达（10分）</td>
				<td colspan="2">论文（设计、创作）质量和创新意识（55分）</td>
				<!-- <td></td> -->
				<td>合计</td>
				
			</tr>
			<!-- 第七行 -->
			<tr height="30px">
				<!-- <td></td> -->
				<td>得分</td>
				<td>${score.fopenReportScore }</td>
				<td>${score.fvarcharScore }</td>
				<td>${score.fattitude }</td>
				<td>${score.fshowScore }</td>
				<td colspan="2">${score.fqualityScore }</td>
				<!-- <td></td> -->
				<td>${score.fscoreSum }</td>
			</tr>
			<!-- 第八行 -->
			<tr height="40px">
				<!-- <td></td> -->
				<td colspan="8">指导教师签名:<div class="span"><span >&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</span></div></td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			
			
			<!-- 评阅教师 -->
			
			<!-- 第四行 -->
			<tr height="60px">
				<td rowspan="5">评阅教师评语以及得分</td>
				<td >评阅教师评语</td>
				<td colspan="7">${score.fcommentTeacher }</td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			<!-- 第六行 -->
			<tr>
				<!-- <td></td> -->
				<td rowspan="2">评分项目分值</td>
				<td colspan="7">评阅教师对毕业论文（设计、创作）评分</td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			<!-- 第六行 -->
			<tr height="80px">
				<!-- <td></td> -->
				<!-- <td></td> -->
				<td>撰写开题报告、文献综述（15分）</td>
				<td>调查研究查阅整理资料（10分）</td>
				<td>学习态度与规范要求（10分）</td>
				<td>数据处理、文字表达（10分）</td>
				<td colspan="2">论文（设计、创作）质量和创新意识（55分）</td>
				<!-- <td></td> -->
				<td>合计</td>
				
			</tr>
			<!-- 第七行 -->
			<tr height="30px">
				<!-- <td></td> -->
				<td>得分</td>
				<td>${score.fcommentReportScore }</td>
				<td>${score.fcommentVarcharScore }</td>
				<td>${score.fcommentAttitude }</td>
				<td>${score.fcommentShowScore }</td>
				<td colspan="2">${score.fcommentQualityScore }</td>
				<!-- <td></td> -->
				<td>${score.fcommentScoreSum }</td>
			</tr>
			<!-- 第八行 -->
			<tr height="40px">
				<!-- <td></td> -->
				<td colspan="8">评阅教师签名:<div class="span"><span >&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</span></div></td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			</table>
			<br/><br/><br/><br/><br/><br/>
			
			
			<h2>河南大学2015届毕业论文成绩表</h2>
			<h4>学院名称：软件学院</h4>
			<table border="1px" cellspacing="0">
			<!-- 答辩评委 -->
			<tr>
				<td colspan="2">学号</td>
				<!-- <td></td> -->
				<td>${score.fno }</td>
				<td>姓名</td>
				<td>${score.fname }</td>
				<td colspan="2">专业</td>
				<!-- <td></td> -->
				<td colspan="2">${score.fmajor }</td>
				<!-- <td></td> -->
			</tr>
			
			<!-- 第四行 -->
			<tr height="200px">
				<td rowspan="6">答辩委员会评语以及得分</td>
				<td >答辩委员会评语</td>
				<td colspan="7">${review.fcomment }</td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			<!-- 第六行 -->
			<tr>
				<!-- <td></td> -->
				<td rowspan="3">评分项目分值</td>
				<td colspan="7">论文答辩小组评分</td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			
			<tr>
				<!-- <td></td> -->
				<td colspan="2">答辩情况</td>
				<td colspan="4">论文质量</td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
				<td rowspan="2">合计</td>
			</tr>
			<!-- 第六行 -->
			<tr height="80px">
				<!-- <td></td> -->
				<!-- <td></td> -->
				<td>内容表达情况（15分）</td>
				<td>答辩问题情况（25分）</td>
				<td colspan="2">规范要求与文字表达（20分）</td>
				<td colspan="2">论文（设计、创作）质量和创新意识（40分）</td>
				<!-- <td></td> -->
				<!-- <td></td> -->
				<!-- <td></td> -->
				
			</tr>
			<!-- 第七行 -->
			<tr height="30px">
				<!-- <td></td> -->
				<td>得分</td>
				<td>${review.fcontentScore }</td>
				<td>${review.fscoreDefense }</td>
				<td colspan="2">${review.fwordScore }</td>
				<!-- <td></td> -->
				<td colspan="2">${review.fqualityScore }</td>
				<!-- <td></td> -->
				<td>${sum }</td>
			</tr>
			<!-- 第八行 -->
			<tr height="40px">
				<!-- <td></td> -->
				<td colspan="8">答辩主任签名:<div class="span"><span >&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</span></div></td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			<tr height="60px">
				<td colspan="9">毕业论文（设计、创作）成绩评定（百分制）：&nbsp;${review.fcomprehensiveScore }&nbsp;(分)<br/>（教师表成绩占40%，答辩成绩占60%）</td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
			<tr height="40px">
				<td colspan="9">综合评定等级（优、良、中、差）：&nbsp;${review.frating }&nbsp;</td>
				<!-- <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
		</table>
	
	</div>

</body>
</html>