<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>河南大学毕业设计管理系统</title>
   
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/announcementStyle.css"/>

    <!--Luara样式文件-->
    <!--渐隐样式-->
    <link rel="stylesheet" href="css/luara.css"/>
   

</head>
<script language="javascript" type="text/javascript">

</script>
<body class="bgc" onload="draw('canvas')">  <!-- 打开网页调用canvas函数，生成验证码 -->
    <div class="head">
    	
    	
    	
    	<div class="holder">
    		
    		
    		<div class="heda">
    		
    	    </div>
			<div class="logo">
			
			
			
			<h1 class="h">河南大学毕业设计管理系统</h1>
				
	    	</div>
		    
		    <div class="help">
		      <ul>
		      	<li><a href="http://www.henu.edu.cn/html/So/1.html">网站导航</a></li>
			    <li><a href="#">关于我们</a></li>
			    <li><a href="#">帮助</a></li>
			    <li><a href="#">论坛</a></li>
			  </ul>
		    </div>
		</div>		
	</div>

<div class="center" id="announcement">
<!-- 公告详细信息显示 -->
<div class="title">${login_announcement.ftitle}</div>
<div class="infomation">
	<span>[发布人：${login_announcement.fpublisher}</span>
	<span>浏览次数：${login_announcement.fbrowseTime}</span>
	<span>发布时间：${login_announcement.fpublishMessage}]</span>
</div>
<div class="content">
	<span>${login_announcement.fcontent}</span>
</div>
</div>
   
    <div class="last_intr">
    	<p>
    	   <span>快速访问：</span>
		   <span><a href="http://software.henu.edu.cn/">河南大学软件学院</a></span>
		   <span><a href="http://jwc.henu.edu.cn/">教务处</a></span>
		   <span><a href="http://www.gocheck.net/">gocheck</a></span>
		   <span><a href="http://lib.henu.edu.cn/">图书馆</a></span>
           <span><a href="#">蒲公英工作室</a></span>
           <span><a href="#">蒲公英工作室贴吧</a></span>
		  </p>
          
		  <p>&copy; 2015 www.henu.edu.cn 版权所有 ICP证：豫fyq-20151102</p>
    </div>
   
</body>
</html>