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
 
<form action="/paper/student/op_update?fno=${opening.fno }" method="post" enctype="multipart/form-data" ><!-- target="ajax" -->
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
						           <input name="opening.fno" type="text" size="30" value="${opening.fno }" readonly="readonly"/>
							 </p>
							 <p>
								<label>导师姓名职称:</label> <input name="opening.ftid" type="text" value="${opening.ftid }"
									size="30"/>
							 </p>
							 <p>
							      <label>开题时间:</label>
							      <input type="text" name="opening.fopeningTime" class="date" value="${opening.fopeningTime }" readonly="true" size="30"/>
							      <a class="inputDateButton" href="javascript:;">选择</a>
							 </p>
							 <p>
								<label>课题题目:</label> <input name="opening.ftopicTitle"
									type="text" size="30"  value="${opening.ftopicTitle }"/>
							 </p>
							 <p>

								<label>课题来源:</label> <input type="radio"
									name="opening.ftopicSource" value="导师指定"
								    <%String source = (String) session.getAttribute("source");
									System.out.print("课题来源=" + source);
									if (source.equals("导师指定"))
										out.print("checked='checked'");%> />导师指定
								<input type="radio" name="opening.ftopicSource" value="自定"
									<%//String source1 =(String) session.getAttribute("source");

									if (source.equals("自定"))
										out.print("checked='checked'");%> />自定
								<input type="radio" name="opening.ftopicSource" value="其他来源"
									<%//String source2 =(String) session.getAttribute("source");
									if (source.equals("其他来源"))
										out.print("checked='checked'");%> />其他来源
							</p> 
							<%--  <p> 
							  <label>开题报告上传</label>
							     <a class="button" href="/paper/student/op_upload1?fno=${opening.fno }" target="dialog" rel="zby1"><span>上传</span></a>
							</p> --%>
						    <div class="divider">divider</div>
							<textarea class="editor" name="opening.fsubjectPurpose"
								style="float: none; width: 90%; height: 190px">${opening.fsubjectPurpose }</textarea>
							<div class="divider">divider</div>
						 	<textarea class="editor" name="opening.fresearchObject"
								style="float: none; width: 90%; height: 190px">${opening.fresearchObject }</textarea>
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
							style="float: none; width: 90%; height: 150px">${opening.fuseWay }</textarea>
							
						<div class="divider">divider</div>
						<textarea class="editor" name="opening.fexpectedResults"
							style="float: none; width: 90%; height: 150px">${opening.fexpectedResults }</textarea>
						<div class="divider">divider</div>
						<textarea class="editor" name="opening.fprogressPlan"
							style="float: none; width: 90%; height: 150px" >${opening.fprogressPlan }</textarea>
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
			             <textarea class="editor" name="opening.freference"
							style="float: none; width: 90%; height: 220px">${opening.freference }</textarea>
						<div class="divider">divider</div>
						<textarea class="editor" name="opening.fmentorOpinion"
							style="float: none; width: 90%; height: 220px">${opening.fmentorOpinion }</textarea>
						 <div class="divider">divider</div>	
						<!--   提交按钮 -->
				      
			          <div class="button" style="float: right;margin-right: 10%">
			               <div class="buttonContent">
			               <button>&nbsp;确&nbsp;认&nbsp;修&nbsp; 改&nbsp;</button>
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
 
 