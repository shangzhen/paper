<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务书</title>
</head>
<body>
   <div class="tabs">
		<form action="/paper/student/ta_save.action" method="post" enctype="multipart/form-data" >
		
		      <div class="tabsHeader">
		            <div class="tabsHeaderContent">
		                  <ul>
		                        <li class="selected"><a href="#"><span style="color: red;">第一页</span></a></li>
		                  </ul>
		            </div>
		      </div>
		     <div class="tabsContent" style="height:100%;">
		      <!--  第一页 -->
		       
					<div class="pageContent"
						style="border: 1px #B8D0D6 solid; background-color: #fff;">
		
						<div class="pageFormContent" layoutH="90">
						    <p>
								<label>学号:</label> 
							   <c:if test="${empty sessionScope.zby}">
						           <input name="task.fno" value="<%=session.getAttribute("user") %>" readonly="readonly" type="text" size="30" />
						       </c:if>
						       <c:if test="${not empty sessionScope.zby}">
								    <input  type="text" size="30" value="任务书已提交，你只能修改" readonly="readonly" style="color:red;"/>
							   </c:if> 
							</p>
							<p>
								<label>题目名称:</label> <input name="task.ftitle" type="text" size="30"
									/>
							</p>
							<p>
								<label>题目名称:</label> <input name="task.ftime" type="text" size="30"
									/>
							</p>
							<p>
								<label>学院:</label> <input name="task.fcollege" type="text" size="30"
									 />
							</p>
							<p>
								<label>学生姓名:</label> <input name="task.fname" type="text" size="30"
									 />
							</p>
							
							<p>
								<label>所学专业:</label> <input name="task.fmajor" type="text" size="30"
									/>
							</p>
							<p>
								<label>导师姓名:</label> <input name="task.ftutorName" type="text" size="30"
									 />
							</p>
							<!--  <p>
							    <label>任务书上传:</label>
								<input type="file" name="image" ></input>
							</p> -->
							<div class="divider">divider</div>
							<textarea class="editor" name="task.frequire"
								style="float: none; width: 90%; height: 450px"><b>毕业论文(设计，创作)要求:</b></textarea>
							<div class="divider">divider</div>
						</div>
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
		</form>
   </div>
</body>
</html>
