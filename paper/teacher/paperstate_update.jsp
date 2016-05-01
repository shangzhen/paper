<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论文状态修改</title>
</head>
<body>
<form method="post" action="/paper/paperstate/paperstate_update" enctype="multipart/form-data"  target="navTab" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="97">
			<input type="hidden" name="fno" value="${fno}">
			<dl>
				<dt>学号：</dt>
				<dd>
					<input type="text" name="paperstate.fno"  readonly="readonly"  value="${paperstate.fno }"/>
				</dd>
			</dl>
			<dl>
				<dt>论文目前状态：</dt>
				<dd>
					<p>开题报告：<span style="color:red;">${paperstate.fopenReport}</span>&nbsp;&nbsp;任务书：<span style="color:red;">${paperstate.ftaskBook}</span>&nbsp;&nbsp; 中期检查：<span style="color:red;">${paperstate.fmidInspect}</span>&nbsp;&nbsp;初稿：<span style="color:red;">${paperstate.ffirstDraft}</span>&nbsp;&nbsp;</p>
					<p>终稿：<span style="color:red;">${paperstate.ffirstDraft}</span>&nbsp;&nbsp;查重：<span style="color:red;">${paperstate.fcheck}</span>&nbsp;&nbsp;参加答辩：<span style="color:red;">${paperstate.fjoinDefence}</span>&nbsp;&nbsp;成绩评定：<span style="color:red;">${paperstate.fscoreJudge}</span>&nbsp;&nbsp;</p>
				</dd>
			</dl>
			<dl>
				<dt>开题报告：</dt>
				<dd>					
						<select name="paperstate.fopenReport" class="required combox">
							<option value="" selected="selected">请选择状态</option>					
							<option value="未提交" >未提交 </option>
							<option value="已提交" >已提交</option>
							<option value="已评阅" >已评阅</option>
							<option value="已通过" >已通过</option>
						</select>
				</dd>
			</dl>
			
			<dl>
				<dt>任务书：</dt>
				<dd>					
						<select name="paperstate.ftaskBook" class="required combox">
							<option value="" selected="selected">请选择状态</option>
							<option value="未提交" >未提交 </option>					
							<option value="已提交" >已提交</option>
							<option value="已评阅" >已评阅</option>
							<option value="已通过" >已通过</option>
						</select>
				</dd>
			</dl>
			<dl>
				<dt>中期检查：</dt>
				<dd>					
						<select name="paperstate.fmidInspect" class="required combox">	
							<option value="" selected="selected">请选择状态</option>
							<option value="未提交" >未提交 </option>				
							<option value="已提交" >已提交</option>
							<option value="已评阅" >已评阅</option>
							<option value="已通过" >已通过</option>
						</select>
				</dd>
			</dl>
			<dl>
				<dt>初稿：</dt>
				<dd>					
						<select name="paperstate.ffirstDraft" class="required combox">					
							<option value="" selected="selected">请选择状态</option>
							<option value="未提交">未提交</option>
							<option value="已提交" >已提交</option>
							<option value="已评阅" >已评阅</option>
							<option value="已通过" >已通过</option>
						</select>
				</dd>
			</dl>
			<dl>
				<dt>终稿：</dt>
				<dd>				
						<select name="paperstate.ffinalDraft" class="required combox">
							<option value="" selected="selected">请选择状态</option>					
							<option value="未提交" >未提交</option>
							<option value="已提交" >已提交</option>
							<option value="已评阅" >已评阅</option>
							<option value="已通过" >已通过</option>
						</select>
				</dd>
			</dl>
			<dl>
				<dt>查重：</dt>
				<dd>					
						<select name="paperstate.fcheck" class="required combox">
							<option value="" selected="selected">请选择状态</option>			
							<option value="未提交" >未提交</option>
							<option value="未通过" >未通过</option>
							<option value="已通过" >已通过</option>
						</select>
				</dd>
			</dl>
			<dl>
				<dt>参加答辩：</dt>
				<dd>					
						<select name="paperstate.fjoinDefence" class="required combox">	
							<option value="" selected="selected">请选择状态</option>				
							<option value="未答辩" >未答辩</option>
							<option value="已答辩" >已答辩</option>
							<option value="未通过" >未通过</option>
						</select>
				</dd>
			</dl>
			<dl>
				<dt>成绩评定：</dt>
				<dd>					
						<select name="paperstate.fscoreJudge" class="required combox">
							<option value="" selected="selected">请选择状态</option>					
							<option value="未评定" >未评定</option>
							<option value="已答辩" >已评定</option>
						</select>
				</dd>
			</dl>
			<dl>
				<dt>备注：</dt>
				<dd>
					<textarea rows="5" cols="50" name="paperstate.fmemo" value="${paperstate.fmemo}"></textarea>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</div>
</form>
</body>
</html>