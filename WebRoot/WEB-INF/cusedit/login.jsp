 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    <title>客户问题反馈</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="customer feedback">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"  type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/ZeroClipboard.js"  type="text/javascript"></script>
	
	<script type="text/javascript">
		function validate(){
			if(document.getElementById("orderNo").value==""&&
				document.getElementById("telNo").value==""&&
				document.getElementById("userName").value==""){
				alert("订单编号、手机号码、用户名称不能全为空，需至少填入一项");
				return false;
			}else{
				return true;
			}
		}
		
		function timeQuery(){
	    	if (document.getElementById("startTime").value==""||document.getElementById("endTime").value=="") {
				alert("请选择日期后查询");
			}else {
				var startTime=document.getElementById("startTime").value.replace(/\-/g,"");
		    	var endTime=document.getElementById("endTime").value.replace(/\-/g,"");
		    	if (parseInt(startTime)>parseInt(endTime)) {
					alert("开始日期必须小于或等结束日期");
				}else {
					window.open("<%=basePath%>ProcessedAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
				}
			}
	    	
	    }
		
		function timeDownload(){
			if (document.getElementById("startTime").value==""||document.getElementById("endTime")=="") {
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
		div #navigation{margin:5px 10px;padding:4px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;height:20px;border-bottom:1px solid #069;}
		#pageHeader a{color:#111;text-decoration:none;}	
		#pageHeader a:hover{color:#237FA1;text-decoration:none;}
		div#pageBody{width:690px;vertical-align:baseline;margin:auto;}
		div#pageContent{min-height:330px;background-color:#FFF;box-shadow:1px 3px 8px rgba(0,0,0,0.2);height:100%;}
		div#pBody{display:block;background-color:#FFF;position:relative;padding:43px 50px 50px;min-height:330px;}
		#pBody h1{margin-bottom:40px;}
		#pColumn{display:inline-block;width:500px;}
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
		#submitButtonContainer{margin-top:20px;}
		.btn{border-image:none;border-radius:4px;border-style:solid;border-width:1px;
			box-shadow:0px 1px 0px rgba(255,255,255,0.2) inset,0px 1px 2px rgba(0,0,0,0,05);
			margin-bottom:0px;text-align:center;vertical-align:middle;font-size:16px;
			font-weight:500;background-color:#FBB450;background-image:-moz-linear-gradient(center top,#FBB450,#F89406);
			border-color:#F89406 #F89406 #AD6704;background-repeat:repeat-x;text-shadow:0px -1px 0px rgba(0,0,0,0.25);
			display:inline-block;padding:4px 14px;cursor:pointer;}
		.dt{width:100px;height:24px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
		#orderProcessed {float:right;width:400px;height:85px;text-align:right;float:right;}
		#proLink{width:380px;height:20px;text-align:right;float:right;margin:2px;}
		#proLink{vertical-align:middle;}
		#date_menu{width:380px;height:60px;margin-top:2px;float:right;display:none;}
		.time_menu{padding:2px;float:right;width:160px;}
		.timeSub{width:380px;height:30px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;margin:3px;
				padding:2px 15px;float:right;}
		.timeSubmit {text-decoration:none;color:#FFF;background:none repeat scroll 0% 0% #05606D;border-radius:4px;
			padding:0.1em 0.5em;font-size:12px;font-weight:500;font-family:'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;
			text-transform:uppercase;position:relative;border:medium none;transition:all 0.5s ease 0s;
			margin-left:20px;cursor:pointer;}
		#header{padding:4px 10px 5px 0px;height:20px;float:left;width:100%;border-bottom: 1px solid #069;}
		#home{float:left;font:16px #036 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
	</style>
	
  </head>
  
  <body>
  	<div id="main">
  		<div id="navigation">
  			<div id="home">
  						<a href="<%=basePath%>">主页</a>
  						<a href="CusEditAction.action?edit=editing">编辑</a>
  						<!-- <input type="hidden" name="variable" id="variable" value="logistics" /> -->
  						<!-- <a href="CusBackstageAction.action?variable=logistics">物流</a> -->
  						<a href="CusBackstageAction.action?varpage=cuscollect&&variable=a">反馈结果</a>
  					</div>
  					<div id="orderProcessed"   >
						<div id="proLink" onmouseover="proLinkOver()">
							<a href="<%=basePath%>ProcessedAction.action?startTime=
							<%SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");%>
								<%=sdf.format(new Date()) %>&&endTime=<%=sdf.format(new Date()) %>" 
								class="orderProcessed" target="_blank"  >已处理订单</a>
						</div>
						<div id="date_menu">
							<div class="time_menu">
								到&nbsp;<input id="endTime"  class="dt"  type="text"/>
									<img onclick="WdatePicker({el:'endTime'})" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" 
										width="14" height="24" align="absmiddle">
							</div>
								<div class="time_menu">
									&nbsp;从&nbsp;&nbsp;<input id="startTime" class="dt"  type="text"/>
									<img onclick="WdatePicker({el:'startTime'})" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" 
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
  		<div id="wrapper">
  			<div id="pageBody" >
  				<div id="pageHeader">
					<a href="<%=basePath%>customer.jsp">客户问题反馈</a>
  				</div>
  				<div id="pageContent">
  					<div id="pBody">
  						<h1>请填写客户相关信息</h1>
  						<div id="pColumn">
  							<form action="CusFeedbackAction" method="post" onsubmit="return validate()">
  								<ul>
  									<li>
  										<label for="orderNo">订单编号</label>
  										<input id="orderNo" type="text" value="" maxlength="400px" name="orderNo"></input>
  									</li>
  									<li>
  										<label for="telNo">手机号码</label>
  										<input id="telNo" type="text" value="" maxlength="400px" name="telNo"></input>
  									</li>
  									<li>
  										<label for="userName">用户名称</label>
  										<input id="userName" type="text" value="" maxlength="400px" name="userName"></input>
  									</li>
  								</ul>
  								<div id="submitButtonContainer">
  									<input class="btn" type="submit" value="提交"></input>
  								</div>
  							</form>
  						</div>
  					</div>
  				</div>
  			</div>
  		</div>
  	</div>
  </body>
</html>
 
<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    
    <title>登陆</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<meta name="keywords" content="keyword1,keyword2,keyword3">
	<meta name="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/font.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<script src="js/jquery.min.js"  type="text/javascript"></script>
  </head>
  
  <body>
  	<a href="<%=basePath%>">主页</a>
  	<div class="container">
  		<header>
  		</header>
  		<section>
  			<div id="container_section">
  				<a id="toregister" class="hiddenanchor"></a>
  				<a id="tologin" class="hiddenanchor"></a>
  				<div id="wrapper">
  					<div id="login" class="animate form">
  						<form action="loginaction" autocomplete="on" method="post">
  							<h1>用户登录</h1>
  							<p>
  								<label class="icon-user"  for="person.username">请输入用户名</label>
  								<input id="person.username" name="person.username" type="text"
  									placeholder="username" required="required" maxlength="20"
  									pattern="\w{4,20}" title="用户名由字母、数字、下划线组成，长度为4到20位"/>
 							</p>
 							<p>
  								<label class="icon-key"  for="person.password">请输入密码</label>
  								<input id="person.password" name="person.password" type="password"
  									placeholder="password" required="required" maxlength="20"
  									pattern="\w{5,20}" title="密码由字母、数字、下划线组成，长度为5到20位"/>
 							</p>
 							<p class="login button">
 								<input type="submit" value="登陆" />
 								<input type="button" class="btn" onclick="history.go(-1)" value="返回"></input>
 							</p>
 							<p class="change_link">
 								没有账号？
 								<a class="to_register" href="#toregister">注册</a>
 							</p>
  						</form>
  					</div>
  				</div>
  			</div>
  		</section>
  	</div>
  </body>
</html>
 --%>
