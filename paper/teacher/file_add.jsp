<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<h2 class="contentTitle">常用文件添加</h2>

<div class="pageContent">
	<form method="post" action="/paper/file/uploadFile_add" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="507">
			<dl>
				<dt>标题:</dt>
				<dd>
					<input type="text" name="file.ftitle" maxlength="50"  class="required" />
				</dd>
			</dl>
			<dl>
				<dt>备注:</dt>
				<dd>
					<textarea name="file.fremark" cols="50" rows="5" maxlength="500"></textarea>
				</dd>
			</dl>
			<!-- 			
			<div class="divider"></div>
			<p>自定义扩展请参照：dwz.validate.method.js</p>
			<p>错误提示信息国际化请参照：dwz.regional.zh.js</p> -->
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>

