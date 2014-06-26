<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    <title>操作成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="customer feedback">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		html,body{background:none no-repeat scroll center top #F2F9F6;color:#262C26;
			font-family:'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;font-size:16px;height:auto;}
		html,body,div,span,h1,h2,h3,tbody,ul,ol,tr,th,td{margin:0px;padding:0px;border:0px none;
			font-weight:inherit;font-style:inherit;font-size:100%;font-family:inherit;vertical-align:baseline;}	
		h1{font-size:28px;font-weight:bold;color:#333;}
		h2{margin-bottom:40px;font-size:28px;font-weight:bold;color:#333;}
		div#main{height:auto;backgrond-image:-moz-linear-gradient(center top,#DEEFE9,#F2F9F6);}
		div#wrapper{margin:0px auto;width:950px;}
		div#pageHeader{position:relative;margin-bottom:15px;padding-top:35px;height:65px;
			font:bold 2.5em 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;letter-spacing:-1px;text-align:center;}
		#pageHeader a{color:#111;text-decoration:none;}	
		#pageHeader a:hover{color:#237FA1;text-decoration:none;}
		div#pageBody{width:690px;vertical-align:baseline;margin:auto;}
		div#pageContent{min-height:330px;background-color:#FFF;box-shadow:1px 3px 8px rgba(0,0,0,0.2);height:100%;}
		div#pBody{display:block;background-color:#FFF;position:relative;padding:43px 50px 50px;min-height:330px;}
		#pBody h1{margin-bottom:40px;}
		#pColumn{margin-top:40px;display:inline-block;width:500px;}
		ul,ol{list-style:none outside none;}
		li{height:80px;}
		input{font-weight:normal;margin:0px;}
		:focus{outline:medium none;}
		#pColumn label{font-size:16px;font-weight:bold;color:#333;display:block;padding-bottom:5px;height:30px;}
		#pColumn input[type="text"]:focus,#pColumn input[type="text"]:focus{
			border-color:#999;}
		#pColumn input[type="text"]:hover,#pColumn input[type="text"]:hover{
			border-color:#BBB;}	
		#pColumn input[type="text"],#pColumn input[type="passsword"]{
			border-color:#C70307;border-style:solid;width:400px;height:35px;box-shadow:0px 1px 1px rgba(0,0,0,0.1) inset;
			border-radius:5px;border:1px solid #CCC;font-family:'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;color:#666;
			padding:2px;}
		#pColumn .icon {float:left;margin:5px 15px;width:70px;height:70px;background-image:url(img/icon.png);}
		#pColumn #opinfo{float:left;margin:10px 20px;font:bold 2.6em 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;color:#7ABD54;}
		#pColumn #relid{float:left;margin:10px 20px;font:bold 1.2em 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;color:#3C8DE9;}
		.redirectDiv {margin-top:15px;margin-bottom:5px;display:inline-block;width:500px;}
		.redirectDiv .rediv{margin:10px 15px;margin-bottom:10px;display:inline-block;width:500px;
			font:bold 1.5em 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		.rediv a:link{color:#0073C3;}
		.rediv a:visited{color:#4D187E;}
		.rediv a:hover{color:#F60;}
		#date_menu{width:500px;height:60px;margin:10px 15px;float:left;display:none;}
		.time_menu{padding:2px;float:left;width:160px;text-align:left;}
		.timeSub{width:380px;height:30px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;margin:3px;
				padding:2px 15px;float:left;}
		.timeSubmit {text-decoration:none;color:#FFF;background:none repeat scroll 0% 0% #05606D;border-radius:4px;
			padding:0.3em 0.5em;font-size:14px;font-weight:500;font-family:'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;
			text-transform:uppercase;position:relative;border:medium none;transition:all 0.5s ease 0s;
			margin-left:10px;cursor:pointer;}
		.dt{width:100px;height:24px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
	</style>
	
	<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"  type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/ZeroClipboard.js"  type="text/javascript"></script>
	<script type="text/javascript">
	function timeQuery(){
    	if (document.getElementById("startTime").value==""||document.getElementById("endTime")=="") {
			alert("请选择日期后查询");
		}else {
			var startTime=document.getElementById("startTime").value.replace(/\-/g,"");
	    	var endTime=document.getElementById("endTime").value.replace(/\-/g,"");
	    	if (parseInt(startTime)>parseInt(endTime)) {
				alert("开始日期必须小于或等于结束日期");
			}else {
				window.open("<%=basePath%>ProcessedAction.action?startTime="+startTime+
		    			"&endTime="+endTime);
			}
		}
    	
    }
	
	function timeDownload(){
		if (document.getElementById("startTime").value==""||document.getElementById("endTime").value=="") {
			alert("请选择日期后下载");
		}else {
			var startTime=document.getElementById("startTime").value.replace(/\-/g,"");
	    	var endTime=document.getElementById("endTime").value.replace(/\-/g,"");
	    	if (parseInt(startTime)>parseInt(endTime)) {
				alert("开始日期必须小于或等于结束日期");
			}else {
				window.open("<%=basePath%>DownloadAction.action?startTime="+startTime+
		    			"&endTime="+endTime);
			}
		}
    }
	
		function proLinkOver(){
			document.getElementById("date_menu").style.display="block";
		}
	</script>

  </head>
  
  <body>
  	<div id="main">
  		<div id="wrapper">
  			<div id="pageBody" >
  				<div id="pageHeader">
  				</div>
  				<div id="pageContent">
  					<div id="pBody">
  						<div id="pColumn">
  							<img class="icon"></img>
  							<div id="opinfo">操作成功</div>
  							<div id="relid">订单编号：
  								<a href="http://192.168.0.150/ishop/admin/ord/POrderDetail.aspx?Orderid=<s:property value='cusOrdermst.ecid'/>"
  									target="_blank">
  									<s:property value="cusOrdermst.relid"/>
  								</a>
  								</div>
  						</div>
  						<div id="pHome" class="redirectDiv">
  							<div id="home" class="rediv">
  								<a href="<%=basePath%>">&lt;&lt;&nbsp;&nbsp;返回主页</a>
  							</div>
  						</div>
  						<div id="pDownload"  class="redirectDiv">
  							<div id="download" class="rediv" onmouseover="proLinkOver()">
  								<a href="<%=basePath%>ProcessedAction.action?startTime=
								<%SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");%>
								<%=sdf.format(new Date()) %>&&endTime=<%=sdf.format(new Date()) %>" 
								class="orderProcessed" target="_blank">&lt;&lt;&nbsp;&nbsp;下载报表</a>
  							</div>
  							<div id="date_menu">
								<div class="time_menu">
									从&nbsp;<input id="startTime"  class="dt"  type="text"/>
									<img onclick="WdatePicker({el:'startTime'})" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" 
										width="14" height="24" align="absmiddle">
								</div>
								<div class="time_menu">
									&nbsp;到&nbsp;<input id="endTime" class="dt"  type="text"/>
									<img onclick="WdatePicker({el:'endTime'})" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" 
										width="12" height="24" align="absmiddle">
								</div>
							<div class="timeSub">
								<input type="button" value="查询" name="timeSubmit" class="timeSubmit" onclick="timeQuery()" />
								<input type="button" value="下载" name="timeSubmit" class="timeSubmit" onclick="timeDownload()" />
							</div>
					</div>
  						</div>
  					</div>
  				</div>
  			</div>
  		</div>
  	</div>
  </body>
</html>
