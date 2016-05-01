<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开题报告</title>
</head>
<body>
 
<form action="/paper/student/op_save" method="post" enctype="multipart/form-data">
<div class="tabs">
 
      <div class="tabsHeader">

            <div class="tabsHeaderContent">

                  <ul>

                        <li><a href="#"><span style="color: red;">第一页</span></a></li>

                        <li><a href="#"><span style="color: red;">第二页</span></a></li>
                        
                        <li><a href="#"><span style="color: red;">第三页</span></a></li>
                  </ul>

            </div>

      </div>
      
      <div class="tabsContent" style="height:100%;">
 <!-- 第一页内容 -->
            <div>
			     <div class="pageContent"
						style="border: 1px #B8D0D6 solid; background-color: #fff;padding-top: 10px">
						
					<div class="pageFormContent" layoutH="60">
					         <p>
					          <label>学号:</label>
						       <c:if test="${empty sessionScope.zby}">
						           <input name="opening.fno" value="<%=session.getAttribute("user") %>" readonly="readonly" type="text" size="30" />
						       </c:if>
						       <c:if test="${not empty sessionScope.zby}">
								    <input  type="text" size="30" value="开题报告已提交，你只能修改" readonly="readonly" style="color:red;"/>
							   </c:if>
							</p>
							<p>
								<label>导师姓名职称:</label> <input name="opening.ftid" type="text"
									size="30"/>
							</p>
							<p>
							      <label>开题时间:</label>
							      <input type="text" name="opening.fopeningTime" class="date" readonly="true" size="30"/>
							      <a class="inputDateButton" href="javascript:;">选择</a>
							</p>
							<p>
								<label>课题题目:</label> <input name="opening.ftopicTitle"
									type="text" size="30" />
							</p>
							<p>

								<label>课题来源:</label> <input type="radio"
									name="opening.ftopicSource" value="导师指定"
									 />导师指定
								<input type="radio" name="opening.ftopicSource" value="自定"
									/>自定
								<input type="radio" name="opening.ftopicSource" value="其他来源"
									 />其他来源
							</p> 
							 <!-- <p>
							     <label>开题报告上传:</label>opening.fadjunct
                                 <input type="file" name="img" ></input>
							</p> -->
						    <div class="divider">divider</div>
							<textarea class="editor" name="opening.fsubjectPurpose"
								style="float: none; width: 90%; height: 190px"><b>课题的题目、意义以及本课题有关的国外现状分析:</b></textarea>
							<div class="divider">divider</div>
							<textarea class="editor" name="opening.fresearchObject"
								style="float: none; width: 90%; height: 190px"><b>研究目标、研究内容和准备解决的问题:</b></textarea>
							<div class="divider">divider</div>
						    
					        <p>
							    <p><b style="color:black;font-size:14px;">请全部填完后再提交</b></p>
							</p>
					</div>			
				 </div>
			</div>
<!-- 第二页 -->
            <div>
                <div class="pageContent"
					style="border: 1px #B8D0D6 solid; background-color: #fff; adding-top: 10px">
					<div class="pageFormContent" layoutH="60">
						<textarea class="editor" name="opening.fuseWay"
							style="float: none; width: 90%; height: 150px" ><b>拟采取的方法、技术或设计(开发)工具:</b></textarea>
							
						<div class="divider">divider</div>
						<textarea class="editor" name="opening.fexpectedResults"
							style="float: none; width: 90%; height: 150px"><b>预期成果:</b></textarea>
						<div class="divider">divider</div>
						<textarea class="editor" name="opening.fprogressPlan"
							style="float: none; width: 90%; height: 150px" ><b>进度计划与阶段要求:</b></textarea>
						<div class="divider">divider</div>
						    
				        <p>
						    <p><b style="color:black;font-size:14px;">请全部填完后再提交</b></p>
						</p>
					</div>
			   </div>
            
            </div>
<!-- 第三页 -->

			<div>
			    <div class="pageContent" style="border: 1px #B8D0D6 solid; background-color: #fff; padding-top: 10px">
					  <div class="pageFormContent" layoutH="70">
			             <textarea class="editor" name="opening.fReference"
							style="float: none; width: 90%; height: 220px" value=""><b>开题前收紧的资料和参考文献(5-8种):</b></textarea>
						<div class="divider">divider</div>
						<!-- <textarea class="editor" name="opening.fMentorOpinion"
							style="float: none; width: 90%; height: 220px" value=""><b>指导教师对开题报告的意见:</b></textarea>
						 <div class="divider">divider</div>	 -->
						
						
						<!--   提交按钮 -->
				      
			          <div class="button" style="float: right;margin-right: 10%">
			               <div class="buttonContent">
			               <button>&nbsp;&nbsp;提&nbsp;&nbsp; 交&nbsp;&nbsp;</button>
			               </div>
			            </div>
				          <br>
				          &nbsp;&nbsp; 
				         <br>
				          <div class="divider">divider</div>
				         <br>  
			           </div>
			          
			         
			         
			        
			     </div>
			</div>

     </div>
</div>
</form>
      

</body>
</html>
 
 