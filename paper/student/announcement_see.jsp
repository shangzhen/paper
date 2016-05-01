<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<h2 class="contentTitle">公告信息内容</h2>
<div  align="center" style="font-weight:bold;font-size:20px">${anc.ftitle}</div><br/>
<div align="center">发布人：${anc.fpublisher}&nbsp;&nbsp;发布时间：${anc.fpublishMessage}&nbsp;&nbsp;浏览次数：${anc.fbrowseTime}</div><br/>
<div class="content" style="line-height:140%;padding-right:1%;padding-left:1%;">&nbsp;&nbsp;&nbsp;&nbsp;${anc.fcontent}</div><br/>
<c:if test="${!empty(anc.fadjunct)}">
	<a href="/paper/downFile?res=${anc.fadjunct}" style="color:red;">点击下载附件</a>
</c:if>
