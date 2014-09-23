<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>采购</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		h2.title {margin-top:35px;margin-bottom:10px;text-align:center;
					text-transform:uppercase;letter-spacing:-0.07em;font-family:sans-serif;
					font-size:2.0em;font-weight:800;}
		.main {margin:30px 10px 30px 10px;padding:10px;}
		fieldset {padding:10px;margin:10px;width:45%;height:200px;
					border:#06c 2px groove;}
		legend {color:#06c;font-weight:800;background:#fff;}
	</style>
	<script type="text/javascript" src="http://files.cnblogs.com/wangdetian168/jquery-1.4.2.min.js"></script>  
	<script type="text/javascript">
	function CheckForm(){	
		var regex=/(.+)\.xls.*$/i;
	    //var upload=document.getElementsByName("upload").value;
	    //var ext=upload.substring(upload.lastIndexOf(".")+1,upload.length);
		if (document.getElementsByName("upload")[0].value.length == 0 ){
		  alert("请上传Excel文件!");
		  //document.getElementsByName("file").focus();
		  return false;
		 } 
	   if(regex.test(document.getElementsByName("upload")[0].value)==false){
	      alert("你上传的不是Excel文件!");
	      //document.getElementsByName("file").focus();
	      return false;
	     } 
	     return true;
	}
	</script>
  </head>
  <body>
  	<div>
  		<h2 class="title">采购</h2>
  	</div>
  	<div class="main" align="center">
  		<fieldset class="left" align="center">
  			<legend>采购</legend>
  			<s:actionerror/>
  			<s:form action="CusBackAction" method="post" enctype="multipart/form-data" 
  					cssStyle="padding:5px;" onsubmit = "return CheckForm()">
  				<s:label value="上传文件(注：仅支持以xls,xlsx后缀的excel文件，请按照指定格式上传)">
  				</s:label>
  				<s:label cssStyle="height:0px;"/>
  				<s:file label="文件" name="upload" cssStyle="width:100%;"></s:file>
  				<s:submit value="提交" cssStyle="width:70px;"/>
  				<input type="hidden" name="variable" id="variable" value="upload" />
  			</s:form>
  		</fieldset>
  	</div>
  	<div class="opa" align="center">
		<input type="button" class="btn" onclick="history.go(-1)" value="返回"></input>
	</div>
  </body>
</html>
