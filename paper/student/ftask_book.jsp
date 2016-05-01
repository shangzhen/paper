<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报告书</title>
</head>
<body >
		<h2 class="contentTitle" align="center">论文报告书</h2>
		<table  width="758"  border="0" align="center" cellpadding="10">
			<tr>
				<td>论文题目</td>
				<td>
					<input name="snumber" type="text" size="30" value="" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>学院</td>
				<td>
					<select name="type" class="required combox">
					<option value="">请选择</option>
					<option value="个人">计算机学院</option>
					<option value="个人">哲学与公共管理学院</option>
					<option value="个人">外语学院</option>
					<option value="公司" selected>软件学院</option>
				    </select>	
				</td>
				<td>专业</td>
				<td>
					<select name="type" class="required combox">
					<option value="">请选择</option>
					<option value="net">网络工程</option>
					<option value="software" selected>软件工程</option>
					<option value="comp">计算机科学</option>
					<option value="math">数字媒体</option>
				</td>
			</tr>
			<tr>
				<td>学生姓名</td>
				<td>
					<input name="snumber" type="text" size="30" value="" readonly="readonly"/>
				</td>
				<td>学号</td>
				<td>
					<input name="snumber" type="text" size="30" value="" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				 <td height="50"colspan="6">毕业论文的（设计、创作）要求
      				<textarea class="editor" name="description"cols="105" rows="20"></textarea></textarea>
  				</td>
			</tr>
			<tr>
    <td align="center">
    <input type="submit" name="submit" value="保存"/>
  </td> 
  </tr>
		</table>
	
	</body>
</html>
