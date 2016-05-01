<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件管理</title>
</head>
<body>
<div class="pageContent">
	<form method="post" action="demo_page1.html" class="pageForm" onsubmit="return navTabSearch(this);">
		<div class="pageFormContent" layoutH="58">
			
			<div class="divider">divider</div>
			
			<div class="unit">
				<label>编&nbsp;&nbsp;号:</label>
				<input type="text" class="number" class="number" value="1001" readonly="readonly" />
				
			</div>
			<div class="unit">
				<label>标&nbsp;&nbsp;题：</label>
				<input type="text" />
				
			</div>
			<div class="unit">
				<label>上&nbsp;传&nbsp;人：</label>
				<input type="text" name="name" />
				
			</div>
			<div class="unit">
				<label>上&nbsp;传&nbsp;时&nbsp;间：&nbsp;&nbsp;</label>
				<input type="text" class="date" /><a class="inputDateButton" href="javascript:;">选择</a>
				
			</div>
			<div class="unit">
				<label>文档路径：</label>
				<input type="file" />
				
			</div>
			<div class="unit">
				<label>备注：</label>
				<textarea rows="7" cols="70"></textarea>	
			</div>
			  
			<div class="divider">divider</div>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="reset">清空重输</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
</body>
</html>