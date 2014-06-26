<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询为空</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		div#main{height:auto;backgrond-image:-moz-linear-gradient(center top,#DEEFE9,#F2F9F6);}
		div #navigation{margin:5px 10px;padding:4px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;height:20px;border-bottom:1px solid #069;}
		#home{float:left;font:16px #036 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		div #content{margin:10px;padding:4px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;height:20px;}
	</style>

  </head>
  
  <body>
  	<div id="main">
  		<div id="navigation">
  			<div id="home">
  				<a href="<%=basePath%>">主页</a>
  			</div>
  		</div>
  		<div id="content">
  			ERP中未查询到该订单，请重试或联系管理员. <br>
  		</div>
  	</div>
  </body>
</html>
