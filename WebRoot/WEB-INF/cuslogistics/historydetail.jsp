<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%if(null == request.getSession().getAttribute("username")){  
           response.getWriter().write("<script>window.location.href = 'index.jsp'</script>");  
       }  
     %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    <title>订回详情</title><%=request.getSession().getAttribute("username") %>，您好
    
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
		table.hovertable {
			text-align:center;
			font-family: verdana,arial,sans-serif;
			font-size:16px;
			color:#333333;
			border-width: 1px;
			border-color: #999999;
			border-collapse: collapse;
		}
		table.hovertable th {
			background-color:#c3dde0;
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #a9c6c9;
		}
		table.hovertable tr {
			background-color:#d4e3e5;
		}
		table.hovertable td {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #a9c6c9;
		}
	</style>
	
	<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"  type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/ZeroClipboard.js"  type="text/javascript"></script>
	<script type="text/javascript">
	
		/* function delHtmlTag (str)
		{
	          var str=str.replace (/<\/?[^>]*>/gim, "");//去掉所有的html标签
	        var result=str.replace(/(\s*)|(\s*$)/g, "");//去掉前后空格    
	        return  result.replace (/\s/g,"");//去除中间的空格
		}
	
		
		function editChange(str){
			var str;
			if(str=="add"){
				document.getElementById("edit").value="add";
			};
			if(str=="update"){
				document.getElementById("edit").value="update";
			};
		}
		function checkdelete(){
			document.getElementById("edit").value="delete";
			if(confirm("确定要删除么")){
				return true;
			}else{
				return false;
			}
		}
		function radioChange1(){
			  var arr = document.all('checkradio2');
			  for (var i = 0; i < arr.length; i++) {
			    arr[i].checked = false;
			  };
			}
		function radioChange2(){
			  var arr = document.all('checkradio1');
			  for (var i = 0; i < arr.length; i++) {
			    arr[i].checked = false;
			  };
			} */
	</script>

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
  				<form action="CusBackAction" method="post" name = "form1" enctype="multipart/form-data">
  					<div id="op">
  						<div class="noavatar">
  							<h3>订单详情</h3>
  						</div>
  						<ol id="option">
  							<table class="hovertable" >
  									<thead><tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';"><td>订货日期</td><td>采购订单号</td><td>供应商名称</td><td>商品名称</td><td>条形码</td><td>货号</td><td>事物特性</td><td>数量</td><td>单价</td><td>运费</td><td>总价</td><td>备注</td><td>快递公司</td><td>快递单号</td></tr></thead>
  									<s:iterator value="orderList" id="orderList" >
  										<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
											<td><s:property value="#orderList.orderdate"/></td>
											<td><s:property value="#orderList.purid"/></td>
											<td><s:property value="#orderList.supplier"/></td>
											<td><s:property value="#orderList.goodsname"/></td>
											<td><s:property value="#orderList.barcode"/></td>
											<td><s:property value="#orderList.goodsid"/></td>
											<td><s:property value="#orderList.goodsproperty"/></td>
											<td><s:property value="#orderList.num"/></td>
											<td><s:property value="#orderList.price"/></td>
											<td><s:property value="#orderList.fare"/></td>
											<td><s:property value="#orderList.total"/></td>
											<td><s:property value="#orderList.remark1"/></td>
											<td><s:property value="#orderList.express"/></td>
											<td><s:property value="#orderList.waybill"/></td>
  										</tr>
  										<%-- <input type="hidden" name="cusOrderback.id"  value="<s:property value='#orderList.id'/>" /> --%>
  									</s:iterator>
  								</table>
  						</ol>
  						<ol id="option">
  							<table class="hovertable" >
  									<thead><tr><td>快递公司</td><td>快递单号</td><td>实到数量</td><td>是否到错</td><td>状态</td><td>拆收人</td><td>发货组签收人</td><td>备注2</td></tr></thead>
  									<s:iterator value="orderList" id="orderList" >
  										<tr>
											<td><input type="text" name="cusOrderback.express" value="<s:property value='#orderList.express'/>"/></td>
											<td><input type="text" name="cusOrderback.waybill" value="<s:property value='#orderList.waybill'/>"/></td>
											<td><input type="text" name="cusOrderback.arrivalnum" value="<s:property value='#orderList.arrivalnum'/>" /></td>
											<td><select name="cusOrderback.mistake">
													<s:if test='#orderList.mistake=="否"'>
														<option selected value="否">否</option>
														<option value="是">是</option>
													</s:if>
													<s:if test='#orderList.mistake=="是"'>
														<option selected value="是">是</option>
														<option value="否">否</option>
													</s:if>
												</select>
											</td>
											<td><select name="cusOrderback.condition">
													<s:if test='#orderList.condition== "已收到"'>
														<option selected value="已收到">已收到</option>
														<option value="未收到">未收到</option>
													</s:if>
													<s:if test='#orderList.condition== "未收到"'>
														<option selected value="未收到">未收到</option>
														<option value="已收到">已收到</option>
													</s:if>
												</select>
											</td>
											<td><input type="text" name="cusOrderback.openman" value='<s:property value='#orderList.openman'/>' /></td>
											<td><input type="text" name="cusOrderback.signman" value='<s:property value='#orderList.signman'/>' /></td>
											<td><input type="text" name="cusOrderback.remark2" value="<s:property value='#orderList.remark2'/>" /></td>
  										</tr>
  									</s:iterator>
  								</table>
  						</ol>
  						<ol id="option">
  							<img src ='<%=request.getContextPath()%>/<s:property value ="#orderList.imgorder" /> ' />
  						</ol>
  						<ol id="option">
  							 <table class="hovertable" ><thead><tr>
			  				<s:label value="上传图片(注：仅支持以jpg,png后缀的图片文件，请按照指定格式上传)" />
			  				<s:file label="图片" name="imgwuliu" cssStyle="width:100%;" /> 
  							</tr></thead></table> 
  						</ol>
  						<ol id="option">
  							<div class="opa">
  								<s:if test='#orderList.intact == "100"'>
  									<input type="radio" name="cusOrderback.intact" checked="checked" value="100"/>破损（需上传图片）
  									<input type="radio" name="cusOrderback.intact"  value="101"/>完好（正常入库）
  								</s:if>
  								<s:if test='#orderList.intact == "101"'>
  									<input type="radio" name="cusOrderback.intact" value="100"/>破损（需上传图片）
  									<input type="radio" name="cusOrderback.intact" checked="checked" value="101"/>完好（正常入库）
  								</s:if>
  							</div>
  						</ol>
  						<ol id="option">
	  						<div class="opa">
	  							<input  class="btn" type="Submit" value="提交" ></input>
	  							<input type="button" class="btn" onclick="history.go(-1)" value="返回"></input>
	  						</div>
  						</ol>
  						<input type="hidden" name="variable" id="variable" value="historyupdate" />
  					</div>
  				</form>
  			</div>
  		</div>
  </body>
</html>

