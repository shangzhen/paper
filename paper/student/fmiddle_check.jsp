<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中期检查表</title>
</head>
<body>
<h2 class="contentTitle" align="center">中期检查表</h2>
<div style="padding:0 10px;">
<table width="733" border="0" cellspacing="0">
  <tr>
    <td colspan="6">题目名称：
      <label for="textfield"></label>
    <input type="text" size="50"/></td>
  </tr>
  <tr>
    <td width="72" rowspan="2">学院</td>   
    <td width="95" rowspan="2">
					<select name="type" class="required combox">
						<option value="">请选择</option>
						<option value="个人">计算机学院</option>
						<option value="个人">哲学与公共管理学院</option>
						<option value="个人">外语学院</option>
						<option value="公司" selected>软件学院</option>
				    </select>
	</td>
    <td width="45">学生姓名</td>
    <td width="183"><input type="text"></td>
    <td width="83" rowspan="2">所学专业</td>
    <td width="229" rowspan="2">
	                <select name="type" class="required combox">
						<option value="">请选择</option>
						<option value="个人">软件工程</option>
						<option value="个人">计算机科学</option>
						<option value="个人">网络工程</option>
						<option value="公司" selected>数字媒体</option>
				    </select>
	</td>
  </tr>
  <tr>
    <td>学号</td>
    <td><input type="text"></td>
  </tr>
  <tr>
    <td height="173" colspan="6">一、毕业设计（论文、设计）进展情况
    <textarea class="editor" name="description"cols="100" rows="10"></textarea></td>
  </tr>
  <tr>
    <td height="169" colspan="6">二、毕业设计（论文、设计）存在的问题及解决方案<textarea class="editor" name="description" rows="8" cols="100"></textarea></td>
  </tr>
  <tr>
  <td colspan="6"align="center"><a href="fmiddle_check1.jsp"target="navTab">下一步</a></td>
  </tr>
</table>
</div>
</body>
</html>
