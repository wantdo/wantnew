<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <%if(null == request.getSession().getAttribute("username")){  
           response.getWriter().write("<script>window.location.href = 'index.jsp'</script>");  
       }  
     %> --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    <title>编辑</title><%=request.getSession().getAttribute("username") %>，您好
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		html{background:none repeat scroll 0% 0% #E1E1E1;color:#000;}
		body,legend{font-family:'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		body,div,dl,dt,ul,li,h1,h2,h3,h4,h5,fieldset,legend,input,button,p,th,td{margin:0px;padding:0px;}
		body{width:auto;min-width:650px;margin:0px 35px;font-size:16px;color:#3E3E3E;line-height:1.5;}
		div#pageHeader{backgrond-image:-moz-linear-gradient(center top,#DEEFE9,#F2F9F6);
			position:relative;margin-bottom:15px;padding:0px;height:90px;
			font:'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;letter-spacing:-1px;text-align:center;}
		div #oDetail{margin-top:20px;text-align:center;float:left;width:100%;}
		div#pageHeader .orderDetail{font:bold 2.5em 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		div#pageHeader .orderProcessed{font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;float:right;
			color:#00C;text-decoration:underline;margin:0px 5px;padding-right:11px;cursor:pointer;}
		#pageHeader a{color:#111;text-decoration:none;}	
		#pageHeader a:hover{color:#237FA1;text-decoration:none;}
		div#pageBody{width:690px;vertical-align:baseline;margin:auto;}
		#body_wrapper{padding:10px 20px;background:none repeat scroll 0% 0% #E7EAF7;border-radius:5px;}
		#page_title{padding:5px 0px 0px;clear:both;background: none repeat scroll 0% 0% #FFEB90;;color:#3E3E3E;
			font-size:16px;padding:5px;margin-bottom:5px;box-shadow:-2px 2px 2px #C8C8C8;text-align:left;width:100%;}
		#page_title h2{color:inherit;font:bold 16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		tr .posthead {background:none repeat-x scroll 0% 0% #5E70A7;border:1px solid #5A7F97;
			clear:both;display:block;float:left;width:100%;height:15px;color:#FFF;margin:-1px -1px 0px;
			font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;padding:4px 0px;}
		td .od_panel{text-align:center;background-color:#FBEC88;font-size:larger;}
		table,td,th{vertical-align:middle;}
		span .label{float:left;margin:0px 2px;}
		span .labelDis{float:left;margin:0px 2px;display:none;}
		.od_table {clear:both;margin-top:5px;margin-bottom:5px;position:relative;width:100%;border:1px solid #069;}
		.od_table tr{width:100%;}
		.od_th{width:15%;border:1px solid #CCC;background-color:#FFFFE0;text-align:right;padding:3px;}
		.od_table td{width:32%;background-color:#FFF;border:1px solid #CCC;padding-left:5px;text-align:left;}
		#op {clear:both;margin-top:5px;margin-bottom:5px;position:relative;width:100%;border:1px solid #069;}
		#option {clear:both;margin-top:5px;margin-bottom:5px;position:relative;width:100%;}
		.noavatar{background:none repeat scroll 0% 0% #F2F6F8;clear:both;height:auto !important;
			border-bottom:1px solid #069;padding:0.5em 0.5em;float:left;color:#22229C;width:100%;}
		#option .option_b{margin:0px;padding:5px 10px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;display:block;}
		ol,ul{margin:0px;padding-left:10px;}
		input,select,label{cursor: pointer;vertical-align:middle;}
		.form-special-wrap{display:inline-block;margin:5px 0px;}
		.form-special-wrap label{font-weight:normal;}
		.form-checkbox{vertical-align:middle;margin:0px 5px 0px 0px;padding:0px;width:20px;height:16px;}
		.form-input {vertical-align:middle;margin:0px 5px 0px 0px;padding:0px;min-width:600px;height:30px;
			font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		.form-opp {vertical-align:middle;margin:0px 5px 0px 0px;padding:0px;min-width:50px;height:25px;width:100px;
			font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		.form-remark {vertical-align:middle;margin:0px 5px 0px 0px;padding:0px;width:420px;min-width:300px;height:25px;
			font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		.opadv{padding:5px 5px;overflow:auto;margin:5px 2px;text-align:center;}
		#opastep {margin:3px 5px;padding:2px;text-align:left;}
		#opastep .stepdiv{float:left;padding:5px 0px;overflow:hidden;} 
		.opadv .opa{margin:10px 2px;padding:1px;overflow:hidden}
		.opa select {height:25px;font:14px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;float:left;margin:0px 5px;}
		.opa .btn{text-decoration:none;color:#FFF;background:none repeat scroll 0% 0% #05606D;border-radius:4px;
			padding:0.1em 0.75em;font-size:15px;font-weight:500;font-family:'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;
			text-transform:uppercase;position:relative;border:medium none;transition:all 0.5s ease 0s;
			margin-left:2px;}
		.shopManager{vertical-align:middle;margin:1px;padding:0px;width:380px;height:26px;line-height:25px;
			font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		.od_readonly{vertical-align:middle;margin:1px;padding:0px;width:98%;height:26px;line-height:25px;
			font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		input:readonly{border: 1px solid #DDD;background-color: #F5F5F5;color:#3E3E3E;}
		.dt{width:100px;height:24px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		#orderProcessed {float:right;width:400px;height:85px;text-align:right;float:right;}
		#proLink{width:380px;height:20px;text-align:right;float:right;margin:2px;}
		#proLink{vertical-align:middle;}
		#date_menu{width:380px;height:60px;margin-top:2px;float:right;display:none;}
		.time_menu{padding:2px;float:right;width:150px;}
		.timeSub{width:380px;height:30px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;margin:3px;
				padding:2px 15px;float:right;}
		.timeSubmit {text-decoration:none;color:#FFF;background:none repeat scroll 0% 0% #05606D;border-radius:4px;
			padding:0.1em 0.5em;font-size:12px;font-weight:500;font-family:'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;
			text-transform:uppercase;position:relative;border:medium none;transition:all 0.5s ease 0s;
			margin-left:20px;cursor:pointer;}
		#header{padding:4px 10px 5px 0px;height:20px;float:left;width:100%;border-bottom: 1px solid #069;}
		#home{float:left;font:16px #036 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		/* #desc_8{display:none;position:relative;} */
	</style>
	

  </head>
  
  <body onload="load()">
  		<div id="main">
  			<div id="pageHeader">
  				<div id="header">
  					<div id="home">
  						<a href="<%=basePath%>">主页</a>
  					</div>
  				</div>
  			</div>
  			<div id="body_wrapper">
  				<a href = "CusEditAction.action">编辑售后问题</a>
  			</div>
  			<div id="body_wrapper">
  				<a href = "CusShopsAction.action">编辑店铺信息</a>
  			</div>
  			<div class="opa">
				<input type="button" class="btn" onclick="history.go(-1)" value="返回"></input>
			</div>
  		</div>
  </body>
</html>

