<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
	table tr td{width:198px; height:40px;}
	.table{ border-collapse:collapse;}
	.table tr td{width:80px;}
	.span{color:red}
</style>
<title>学生端</title>

<link href="themes/default/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="themes/css/core.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="themes/css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<link href="uploadify/css/uploadify.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="themes/css/MyPage.css" rel="stylesheet" />
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="uploadify/scripts/jquery.uploadify.js"
	type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="chart/raphael.js"></script>
<script type="text/javascript" src="chart/g.raphael.js"></script>
<script type="text/javascript" src="chart/g.bar.js"></script>
<script type="text/javascript" src="chart/g.line.js"></script>
<script type="text/javascript" src="chart/g.pie.js"></script>
<script type="text/javascript" src="chart/g.dot.js"></script>

<script src="js/dwz.core.js" type="text/javascript"></script>
<script src="js/dwz.util.date.js" type="text/javascript"></script>
<script src="js/dwz.validate.method.js" type="text/javascript"></script>
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="js/dwz.barDrag.js" type="text/javascript"></script>
<script src="js/dwz.drag.js" type="text/javascript"></script>
<script src="js/dwz.tree.js" type="text/javascript"></script>
<script src="js/dwz.accordion.js" type="text/javascript"></script>
<script src="js/dwz.ui.js" type="text/javascript"></script>
<script src="js/dwz.theme.js" type="text/javascript"></script>
<script src="js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="js/dwz.navTab.js" type="text/javascript"></script>
<script src="js/dwz.tab.js" type="text/javascript"></script>
<script src="js/dwz.resize.js" type="text/javascript"></script>
<script src="js/dwz.dialog.js" type="text/javascript"></script>
<script src="js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="js/dwz.cssTable.js" type="text/javascript"></script>
<script src="js/dwz.stable.js" type="text/javascript"></script>
<script src="js/dwz.taskBar.js" type="text/javascript"></script>
<script src="js/dwz.ajax.js" type="text/javascript"></script>
<script src="js/dwz.pagination.js" type="text/javascript"></script>
<script src="js/dwz.database.js" type="text/javascript"></script>
<script src="js/dwz.datepicker.js" type="text/javascript"></script>
<script src="js/dwz.effects.js" type="text/javascript"></script>
<script src="js/dwz.panel.js" type="text/javascript"></script>
<script src="js/dwz.checkbox.js" type="text/javascript"></script>
<script src="js/dwz.history.js" type="text/javascript"></script>
<script src="js/dwz.combox.js" type="text/javascript"></script>
<script src="js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		DWZ.init("dwz.frag.xml", {
			loginUrl : "login_dialog.html",
			loginTitle : "登录", // 弹出登录对话框
			//		loginUrl:"login.html",	// 跳到登录页面
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",
				orderDirection : "orderDirection"
			}, //【可选】
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "themes"
				}); // themeBase 相对于index页面的主题base路径
			}
		});
	});
</script>
<style>




.zebra td, .zebra th {
    padding: 5px;
    border-bottom: 1px solid #f2f2f2;    
}

.zebra tbody tr:nth-child(even) {
    background: #f5f5f5;
    -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
    -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
    box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
}

.zebra th {
    text-align: left;
    text-shadow: 0 1px 0 rgba(255,255,255,.5); 
    border-bottom: 1px solid #ccc;
    background-color: #eee;
    background-image: -webkit-gradient(linear, left top, left bottom, from(#f5f5f5), to(#eee));
    background-image: -webkit-linear-gradient(top, #f5f5f5, #eee);
    background-image:    -moz-linear-gradient(top, #f5f5f5, #eee);
    background-image:     -ms-linear-gradient(top, #f5f5f5, #eee);
    background-image:      -o-linear-gradient(top, #f5f5f5, #eee); 
    background-image:         linear-gradient(top, #f5f5f5, #eee);
}

.zebra th:first-child {
    -moz-border-radius: 6px 0 0 0;
    -webkit-border-radius: 6px 0 0 0;
    border-radius: 6px 0 0 0;  
}

.zebra th:last-child {
    -moz-border-radius: 0 6px 0 0;
    -webkit-border-radius: 0 6px 0 0;
    border-radius: 0 6px 0 0;
}

.zebra th:only-child{
    -moz-border-radius: 6px 6px 0 0;
    -webkit-border-radius: 6px 6px 0 0;
    border-radius: 6px 6px 0 0;
}

.zebra tfoot td {
    border-bottom: 0;
    border-top: 1px solid #fff;
    background-color: #f1f1f1;  
}

.zebra tfoot td:first-child {
    -moz-border-radius: 0 0 0 6px;
    -webkit-border-radius: 0 0 0 6px;
    border-radius: 0 0 0 6px;
}

.zebra tfoot td:last-child {
    -moz-border-radius: 0 0 6px 0;
    -webkit-border-radius: 0 0 6px 0;
    border-radius: 0 0 6px 0;
}

.zebra tfoot td:only-child{
    -moz-border-radius: 0 0 6px 6px;
    -webkit-border-radius: 0 0 6px 6px
    border-radius: 0 0 6px 6px
}
  
</style>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://j-ui.com">标志</a>
				<ul class="nav">

					<li><a href="changepwd.jsp" target="dialog" width="600">密码重置</a></li>

					<li><a href="/paper/login.jsp">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->

		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>毕业设计
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="tabsPage.html" target="navTab">基本信息</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">我的主页</a></li>
									<li><a href="/paper/student/students_find" target="navTab"
										rel="page1">个人信息</a></li>
									<li><a href="/paper/student/students_findTeacher"
										target="navTab" rel="external">导师信息</a></li>
									<li><a href="/paper/student/student_findAll"
										target="navTab" rel="page200" fresh="false">常用文件</a></li>
								</ul></li>

							<li><a>论文信息</a>
								<ul>
									<li><a href="/paper/student/op_findfno" target="navTab"
										rel="w_5">开题报告</a></li>
									<li><a href="/paper/student/ta_findByfid" target="navTab"
										rel="w_6">任务书</a></li>
									<li><a href="/paper/student/che_findfno" target="navTab"
										rel="w_7">中期检查</a></li>
									<li><a href="/paper/student/paper_findByFno"
										target="navTab" rel="w_alert">毕业论文</a></li>
								</ul></li>

							<li><a>答辩信息</a>
								<ul>
									<li><a href="w_validation.html" target="navTab"
										rel="w_validation">答辩预约</a></li>
									<li><a href="student/student_paperscore" target="navTab"
										rel="w_button">成绩查询</a></li>
									<li><a href="student/student_papermessage" target="_blank"
										rel="w_button1">综合成绩表</a></li>
								</ul></li>
							<li><a>在线交互</a>
								<ul>
									<li><a href="/paper/stu/noticeInformation_findProperty"
										target="navTab" rel="page11">公告信息</a></li>
									<li><a href="/paper/stu/consultation_findListBySid"
										target="navTab" rel="page12">在线咨询</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>






				<div class="navTab-panel tabsPageContent layoutBox"
					style="overflow: auto;">

					<div class="mypage">

						<div class="myteacher">
							我的导师
							<div class="in"  style="overflow: auto;">
								<table class="table">
									<tr>
										<td>工&nbsp;&nbsp;号:</td>
										<td>${myteacher.ftid }</td>
									</tr>
									<tr>	
										<td>姓&nbsp;&nbsp;名:</td>
										<td>${myteacher.fname }</td>
									</tr>
									<tr>	
										<td>系 &nbsp;&nbsp;别:</td>
										<td>${myteacher.fdepartment }</td>
									</tr>
									
									<tr>
										<td>职&nbsp;&nbsp;称：</td>
										<td>${myteacher.fposition }</td>
									</tr>
									<tr>	
										<td>电&nbsp;&nbsp;话：</td>
										<td>${myteacher.fphone }</td>
									</tr>
									<tr>	
										<td>邮&nbsp;&nbsp;箱：</td>
										<td>${myteacher.femail }</td>
									</tr>
									<tr>
										<td>QQ&nbsp;&nbsp;号：</td>
										<td>${myteacher.fqq }</td>
									</tr>
									<tr>	
										<td>QQ&nbsp;&nbsp;群：</td>
										<td>${myteacher.fqgno }</td>
									</tr>
									<tr>	
										<td>学&nbsp;&nbsp;院：</td>
										<td>${myteacher.fcollege }</td>
									</tr>
									</table>
							</div>

							
						</div>



						<div class="mypaper" >
							我的论文
							<div class="in"  style="overflow: auto;">
								<table class="table">
									<tr>
										<td>开题报告：</td>
										<td>${paperstate.fopenReport}</td>
									</tr>
									<tr>	
										<td>任务书：</td>
										<td>${paperstate.ftaskBook}</td>
									</tr>
									<tr>	
										<td> 中期检查：</td>
										<td>${paperstate.fmidInspect}</td>
									</tr>
									
									<tr>
										<td>初稿：</td>
										<td>${paperstate.ffirstDraft}</td>
									</tr>
									<tr>	
										<td>终稿：</td>
										<td>${paperstate.ffirstDraft}</td>
									</tr>
									<tr>	
										<td>查重：</td>
										<td>${paperstate.fcheck}</td>
									</tr>
									<tr>
										<td>参加答辩：</td>
										<td>${paperstate.fjoinDefence}</td>
									</tr>
									<tr>	
										<td>成绩评定：</td>
										<td>${paperstate.fscoreJudge}</td>
									</tr>
									
								</table>
							</div>
						</div>
						<div class="clear">
						
						</div>

						<div class="myresults" >
							我的成绩
							<div class="in"  style="overflow: auto;">
								<table class="table">
									<tr>
										<td>指导教师评分合计:</td>
										<td>${score.fshowScore }</td>
									</tr>
									<tr>	
										<td>评阅教师评分合计:</td>
										<td>${score.fcommentScoreSum }</td>
									</tr>
									<tr>	
										<td>教 师 平 均 得分:</td>
										<td>${score.faverage }</td>
									</tr>
									<tr>	
										<td>答辩委员会评分合计:</td>
										<td>${sum}</td>
									</tr>
									
									<tr>
										<td>论文成绩综合评定：</td>
										<td>${review.fcomprehensiveScore }</td>
									</tr>
									<tr>	
										<td>综合评定等级：</td>
										<td>${review.frating }</td>
									</tr>
								</table>
							</div>
						</div>




						<div class="others" >
							待办事项
							<div class="in"  style="overflow: auto;">
								<table class="zebra">
									<thead>
										<tr>
											<th>序号</th>
											<th>提醒内容</th>
											<th>时间要求</th>
											<th>操作</th>
										</tr>
									</thead>
									
									
									<!-- <tfoot>
										<tr>
											<td>&nbsp;</td>
											<td></td>
											<td></td>
										</tr>
									</tfoot> -->
									<%int number = 0; %>
									<c:forEach var="time" items="${timeLimitList}">
										<tr target="timeLimit_Id" rel="${time.fid }">
											<td><%= ++number %></td>
											<td>${time.fremindContent }</td>
											<td>${time.ftimeRequirement }</td>
											<td><a class="button" resizable="false" drawable="false" mixable="false" height="350" width="650" href="/paper/time/time_findSingleTimeLimit?fid=${time.fid }" target="dialog" rel="tl_detail"><span>详情</span></a></td>
										</tr>
									</c:forEach>
								</table>

							</div>
						</div>





					</div>


				</div>

			</div>
		</div>

	</div>

	<div id="footer">
		Copyright &copy; 2016 <a href="demo_page2.html" target="dialog">蒲公英工作室</a>
		豫ICP备02292357号-FYQ
	</div>

















	<!--  
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<h2><a href="doc/dwz-user-guide.pdf" target="_blank">DWZ框架使用手册(PDF)</a></h2>
								<a href="doc/dwz-user-guide.swf" target="_blank">DWZ框架演示视频</a>
							</div>
							<div class="right">
								<p><a href="doc/dwz-user-guide.zip" target="_blank" style="line-height:19px">DWZ框架使用手册(CHM)</a></p>
								<p><a href="doc/dwz-ajax-develop.swf" target="_blank" style="line-height:19px">DWZ框架Ajax开发视频教材</a></p>
							</div>
							<p><span>DWZ富客户端框架</span></p>
							<p>DWZ官方微博:<a href="http://weibo.com/dwzui" target="_blank">http://weibo.com/dwzui</a></p>
						</div>
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
							
							<p style="color:red">DWZ官方微博 <a href="http://weibo.com/dwzui" target="_blank">http://weibo.com/dwzui</a></p>
							<p style="color:red">DWZ官方微群 <a href="http://q.weibo.com/587328/invitation=11TGXSt-148c2" target="_blank">http://q.weibo.com/587328/invitation=11TGXSt-148c2</a></p>

<div class="divider"></div>
<h2>dwz v1.2视频教程:</h2>
<p><a href="http://www.u-training.com/thread-57-1-1.html" target="_blank">http://www.u-training.com/thread-57-1-1.html</a></p>

<div class="divider"></div>
<h2>DWZ系列开源项目:</h2>
<div class="unit"><a href="http://code.google.com/p/dwz/" target="_blank">dwz富客户端框架 - jUI</a></div>
<div class="unit"><a href="http://code.google.com/p/dwz4j" target="_blank">dwz4j(Java Web)快速开发框架 + jUI整合应用</a></div>
<div class="unit"><a href="http://code.google.com/p/dwz4php" target="_blank">ThinkPHP + jUI整合应用</a></div>
<div class="unit"><a href="http://code.google.com/p/dwz4php" target="_blank">Zend Framework + jUI整合应用</a></div>
<div class="unit"><a href="http://www.yiiframework.com/extension/dwzinterface/" target="_blank">YII + jUI整合应用</a></div>

<div class="divider"></div>
<h2>常见问题及解决:</h2>
<pre style="margin:5px;line-height:1.4em">
Error loading XML document: dwz.frag.xml
直接用IE打开index.html弹出一个对话框：Error loading XML document: dwz.frag.xml
原因：没有加载成功dwz.frag.xml。IE ajax laod本地文件有限制, 是ie安全级别的问题, 不是框架的问题。
解决方法：部署到apache 等 Web容器下。
</pre>

<div class="divider"></div>
<h2>有偿服务请联系:</h2>
<pre style="margin:5px;line-height:1.4em;">
定制化开发，公司培训，技术支持
合作电话：010-52897073
邮箱：support@dwzjs.com
</pre>
						</div>
						
						<div style="width:230px;position: absolute;top:60px;right:0" layoutH="80">
							<iframe width="100%" height="430" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?width=0&height=430&fansRow=2&ptype=1&skin=1&isTitle=0&noborder=1&isWeibo=1&isFans=0&uid=1739071261&verifier=c683dfe7"></iframe>
						</div>
					</div>
					
				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">DWZ团队</a> 京ICP备05019125号-10</div>
-->














	<!-- 注意此处js代码用于google站点统计，非DWZ代码，请删除 -->
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-16716654-1' ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? ' https://ssl'
					: ' http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>

</body>
</html>
