<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<div class="pageContent">
<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
	<div class="pageFormContent nowrap" layoutH="97">

<h2 class="contentTitle">进度管理</h2>
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>

<div class="pageContent" style="padding:5px">
	<div class="panel" defH="40">
	<h1>开题报告</h1>
	<p>
				<label>截止日期：</label>
				<input type="text" name="startDate" class="date" size="20" /><a class="inputDateButton" href="javascript:;">选择</a>                              
			</p>
	</div>

	<div class="panel" defH="40">
	<h1>论文提交</h1>
		<p>
				<label>截止日期：</label>
				<input type="text" name="startDate" class="date" size="20" /><a class="inputDateButton" href="javascript:;">选择</a>
				
	</div>
	
	<div class="panel" defH="40">
	<h1>毕业答辩</h1>
		<p>
		       <label>截止日期：</label>
		       <input type="text" name="startDate" class="date" size="20" /><a class="inputDateButton" href="javascript:;">选择</a>
                       </p>
	</div>
<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>


<script type="text/javascript">
function customvalidXxx(element){
	if ($(element).val() == "xxx") return false;
	return true;
}
</script>

    
</html>

