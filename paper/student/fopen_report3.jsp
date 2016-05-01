<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中期检查</title>
</head>
<body>
   <div class="tabs">
		<form action="/paper/student/che_save.action" method="post" enctype="multipart/form-data" >
		
		      <div class="tabsHeader">
		            <div class="tabsHeaderContent">
		                  <ul>
		                        <li class="selected"><a href="#"><span style="color: red;">第一页</span></a></li>
                                <li class="selected"><a href="#"><span style="color: red;">第二页</span></a></li>		                 
		                  </ul>
		            </div>
		      </div>
		     <div class="tabsContent" style="height:100%;">
		      <!--  第一页 -->
		       
					<div class="pageContent"
						style="border: 1px #B8D0D6 solid; background-color: #fff;">
		
						<div class="pageFormContent" layoutH="60">
						    <p>
								<label>学号:</label>
							  <c:if test="${empty sessionScope.zby}">
						           <input name="check.fno" value="<%=session.getAttribute("user") %>" readonly="readonly" type="text" size="30" />
						       </c:if>
						       <c:if test="${not empty sessionScope.zby}">
								    <input  type="text" size="30" value="中期检查已提交，你只能修改" readonly="readonly" style="color:red;"/>
							   </c:if> 
							</p>
							<p>
								<label>题目名称:</label> <input name="check.ftitle" type="text" size="30"
									/>
							</p>
							<p>
								<label>学院</label> <input name="check.fcollege" type="text" size="30"
									 />
							</p>
							<p>
								<label>学生姓名:</label> <input name="check.fname" type="text" size="30"
									/>
							</p>
							<p>
								<label>所学专业:</label> <input name="check.fmajor" type="text" size="30"
									 />
							</p>
							<p>
								<label>提交时间:</label>
						        <input type="text" name="check.ftime" class="date" readonly="true" size="30"/>
						        <a class="inputDateButton" href="javascript:;">选择</a>
							</p>
							<!-- <p>
							     <label>中期检查表上传:</label>
								<input type="file" name="image" ></input>
							</p> -->
							<div class="divider">divider</div>
							<textarea class="editor" name="check.ffare"
								style="float: none; width: 90%; height: 210px"><b>毕业设计(论文，创作)进展情况:</b></textarea>
							<div class="divider">divider</div>
							<textarea class="editor" name="check.fproblem"
								style="float: none; width: 90%; height: 210px"><b>毕业设计(论文，创作)存在的问题及解决方案:</b></textarea>
						 <div class="divider">divider</div>
						 <p>
						    <p><b style="color:black;font-size:14px;">请全部填完后再提交</b></p>
						 </p>
						
						</div>
						  
			      </div>
			 <!-- 第二页 -->
				 <div>
				 
				   <div class="pageContent"
						style="border: 1px #B8D0D6 solid; background-color: #fff;">
						<div class="pageFormContent" layoutH="60">
							<textarea class="editor" name="check.fselfEvaluation"
								style="float: none; width: 90%; height: 220px"><b>学生本人对毕业设计阶段所做工作及进展情况的评价:</b></textarea>
							<div class="divider">divider</div>
							<textarea class="editor" name="check.ftutoEvaluation"
								style="float: none; width: 90%; height: 220px"><b>指导教师对学生毕业设计(论文，创作)中期检查的评语:</b></textarea>
							<div class="divider">divider</div>
						
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
   </div>
</body>
</html>
