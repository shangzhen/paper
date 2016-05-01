<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>河南大学毕业设计管理系统</title>
   
    <link rel="stylesheet" href="css/style.css"/>

    <!--Luara样式文件-->
    <!--渐隐样式-->
    <link rel="stylesheet" href="css/luara.css"/>
   

</head>
<script language="javascript" type="text/javascript">

	var xmlHttp= createXMLHttpRequest();
	//2.状态监听器绑定一个回调函数     状态监听器onreadystatechange
	xmlHttp.onreadystatechange = function(){
	    //5.回调函数处理服务器响应的结果
	    if(xmlHttp.readyState==4){
	         if(xmlHttp.status==200){
	            //处理的代码
	            var result = xmlHttp.responseText;
	        	document.getElementById('newsDiv').innerHTML=result;
	         }
	    }
	    
	};
	//3.建立与服务器的连接
	//4.发送数据给服务器
	//xmlHttp.send(null);
	
	//post方式 发送数据
	//3.建立与服务器的连接
	
	//此处可能要写全路径
	xmlHttp.open("POST","/paper/loginPage/news_getNews");
	//4.发送数据给服务器
	xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xmlHttp.send();

function createXMLHttpRequest() {
    try {
         xmlHttp = new XMLHttpRequest();
    } catch (tryMS) {
        try {
             xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (otherMS) {
            try {
                 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
           } catch (failed) {
                 xmlHttp = null;
	        // 这里可以报一个错误，无法获得 XMLHttpRequest对象	
           }
        }
     }
     return xmlHttp;
}







var code  //在全局 定义验证码 
function createCode(){ 
code = "";  
var codeLength = 4;//验证码的长度  
var checkCode = document.getElementById("canvas");
checkCode.value = ""; 
var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
  for(var i=0;i<codeLength;i++) 
    {  
	  var charIndex = Math.floor(Math.random()*32);   
	  code +=selectChar[charIndex];
    }
  if(code.length != codeLength)
    {    
	  createCode(); 
    }
checkCode.value = code; 
}
//canvas创建
function draw(id)
{
	var canvas=document.getElementById(id);
	var a,b,c,color;
	var d=-10;
	if(canvas==null)
	return false;
	var context=canvas.getContext("2d");
	createCode();//调用函数生成验证码
	context.fillStyle="#eeffff";   //填充颜色，背景颜色
	context.fillRect(0,0,100,35);//画矩形
	for(i=0;i<4;i++)//通过循环实现各个字体颜色和格式设置
	{ 
		a = Math.floor(Math.random()*256);
		b = Math.floor(Math.random()*256);
		c = Math.floor(Math.random()*256);
		d = d + 20;//设置文字坐标，左上角为坐标原点
		color = "rgb(" + ''+ a +","+ b +"," + c +")";//拼接字符串,"rgb(a,b,c)";
	    context.fillStyle=color;     //字体颜色  "rgb(a,b,c)";
	    context.strokeStyle=color;   //字体阴影颜色
	    context.font="italic 23px sans-serif"; //字体样式设置 样式和大小
	    context.textBaseline="top";     //对齐方式
	    context.fillText(code[i],d,10);//填充字符创
	    context.strokeText(code[i],d,10);//轮廓字符串
    }
}
//验证方法，登录时调用
function validate () 
{  
	var inputCode = document.getElementById("input").value.toUpperCase(); //中间名字为输入验证码框的id
	if(inputCode.length <=0)
	{    alert("请输入验证码！"); 
       return false; }  
	else if(inputCode != code )
	{    alert("验证码输入错误！"); 
	//createCode(); 
	 draw('canvas');
	} 
	else {     
		 
		$("#submitForm").attr("action", "login").submit(); 
	
	}
	} 
	
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

  <div class="center">
   <div class="left_part">
    <!--Luara图片切换骨架begin-->
        <div class="example">
            <ul>
	            <li><img src="images/1.jpg" alt="1"/></li>
	            <li><img src="images/2.jpg" alt="2"/></li>
	            <li><img src="images/3.jpg" alt="3"/></li>
	            <li><img src="images/4.jpg" alt="4"/></li>
        	</ul>
        	<ol>
	            <li></li>
	            <li></li>
	            <li></li>
	            <li></li>
        	</ol>
        </div>
        <div class="left_down" id="newsDiv">
				<ul class="news3">
				 <li id="x1">
				 	<a href="http://news.henu.edu.cn/html/xxzy/hdsp/2015/09/25/038dea16-fcb1-4be1-a74b-ee1f6f82b54d.html" id="n1">>> 河南大学校歌--2002年同一首歌走进校园
				 	<span>2015-11-02</span></a>
				 	
				 </li>
				 <li id="x1">
				 	<a href="http://news.henu.edu.cn/html/xxxw/2015/09/07/d25f3aca-0bea-41bb-af93-e7c9682c9713.html" id="n2">>> 关爱和：弘扬抗战精神 建设一流大学
				 	<span>2015-11-02</span></a>
				 	
				 </li>
				 <li id="x1">
				 	<a href="http://news.henu.edu.cn/html/xxxw/2015/11/02/6284fb9f-86fa-4fc5-8b32-77f84d431ef0.html" id="n1">>> 我校召开2015年科研工作暨国家基金申报动员会
				 	<span>2015-11-02</span></a>
				 	
				 </li>
				 <li id="x1">
				 	<a href="http://news.henu.edu.cn/html/gg/xxgg/2015/10/29/ee33bc95-fac5-453f-9aca-fe6337d04d2b.html" id="n2">>> 河南大学2016届毕业生秋季双选会
				 	<span>2015-11-02</span></a>
				 	
				 </li>
				 <li id="x1">
				 	<a href="http://news.henu.edu.cn/html/mthd/2015/10/21/95de32d8-4b40-4650-a6db-ab163df035aa.html" id="n1">>> 《新华网》河大校园刮起“创业风”
				 	<span>2015-11-02</span></a>
				 	
				 </li>
				 <li id="x1">
				 	<a href="http://news.henu.edu.cn/html/ycmw/2015/06/18/67a07200-688c-4f8c-9410-70d803a593b2.html" id="n2">>> 我与河南大学
				 	<span>2015-11-02</span></a>
				 	
				 </li>
				 <li id="x1">
				 	<a href="http://news.henu.edu.cn/html/xxzy/yxfc/2015/11/02/f02f4a0f-9b0d-45ec-9e9f-ed753dcbea32.html" id="n1">>> 历史文化学院举行2015年第二期党课开班典礼
				 	<span>2015-11-02</span></a>				 	
				 </li>
				 
			</ul>	
		</div>
    </div>
    
    
     <div class="login">
            <div class="loginmain">
                <h2 class="biaoti">登录毕业设计系统</h2>
                <form id="submitForm" action="/" method="get">
                   
                    <ul>
                    	
                    	<li class="leibie">
                    		<span>类&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
						    <input type="radio" name="act" value="学生" checked="checked"/>学生
						    <input type="radio" name="act" value="教师"/>教师
		                    <input type="radio" name="act" value="管理员"/>管理员
                   		</li>
                    	
                        <li>
                            <span>账&nbsp;&nbsp;&nbsp;&nbsp;号：</span>
                            <input type="text" name="username" placeholder="用户账号" value="">
                        </li>
                        <li>
                            <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
                            <input type="password" name="password" placeholder="用户密码" value="">
                        </li>
                        <li>
                            <span>验证码：</span>
                            <input type="text" id="input" name="verify" placeholder="验证码呢" value=""> 
                          
                        </li>
                        <li>
                            <div class="verifyimg">
                            <canvas id="canvas" width="100px" height="40px">
                            	
                            </canvas>
                            <div class="yz">
                            <a id="" href="javascript:draw('canvas')">再来一个</a>
                            </div>
                            <!-- canvas 可以修改大小 --> 
                             <!-- <img src="#" height="40" width="215">  -->
                             <!-- 更换验证码 -->
                            </div>
                        </li>
                        <li>
                            <input type="submit" name="loginbtn" id="login_sub" value="登&nbsp &nbsp录">
                           
                           <p><a href="#">重置密码</a></p>
                        <!--   <span id="text"></span>  --> 
                          
                           
                        </li>
                        
                        
                        
                    </ul>
                
                </form>
            <!--    <p>需要重置密吗？点击重置：<a href="#">轻轻松松重置密码！</a></p>   --> 
            </div>
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
   
   
    
   
  
    <script src="js/jquery-1.8.3.min.js"></script>
    <!--Luara js文件-->
    <script src="js/jquery.luara.0.0.1.min.js"></script>
    <script>
    $(function(){
        <!--调用Luara示例-->
        $(".example").luara({width:"650",height:"240",interval:4000,selected:"seleted"});

    });
    </script>
    
    
    <script>
            $(function () {
                
                //表单验证
                $('input[name="loginbtn"]').click(function(event) {
                    var $name = $('input[name="username"]');
                    var $password = $('input[name="password"]');
                    var $verify = $('input[name="verify"]');
                    var $text = $('#text');
                    var _name = $.trim($name.val());
                    var _password = $.trim($password.val());
                    var _verify = $.trim($verify.val());

                    if('' == _name){
                       // $text.text('请输入用户名！');
                        $name.focus();
                        return false;
                    }
                    if('' == _password){
                        //$text.text('请输入密码！');
                        $password.focus();
                        return false;
                    }
                    if('' == _verify){
                       // $text.text('请输入验证码！');
                        $verify.focus();
                        return false;
                    }

                   
                    
                    $("#submitForm").attr("action", "JavaScript:validate();").submit();
                   
					
                });
            });
        </script>      
    
    
    

    
</body>
</html>