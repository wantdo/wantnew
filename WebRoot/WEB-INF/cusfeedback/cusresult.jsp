<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    <title>订单详情页</title>
    
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
		input,select,label{vertical-align:middle;}
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
	</style>
	<!--  
	<script type="text/javascript">
		function validate(){
			var products=document.getElementsByName("products");
			var prochecked=false;
			if(document.getElementById("shopManager").value.trim()==""){
				alert("请填写店铺负责人");
				return false;
			}
			if(document.getElementById("opp").value.trim()==""){
				alert("请填写操作人");
				return false;
			}
			for(var i=0;i<products.length;++i){
				if(products[i].checked){
					prochecked=true;
					return true;
				}
			}
			if(prochecked==false){
				alert("请选择至少一件商品");
				return false;
			}
		}
	</script>
	-->
	<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"  type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/ZeroClipboard.js"  type="text/javascript"></script>
	<script type="text/javascript">
	
		function delHtmlTag (str)
		{
	          var str=str.replace (/<\/?[^>]*>/gim, "");//去掉所有的html标签
	        var result=str.replace(/(\s*)|(\s*$)/g, "");//去掉前后空格    
	        return  result.replace (/\s/g,"");//去除中间的空格
		}
	
		function disableChange(index,size,object){
		if(object.checked==true){
			document.getElementById("desc").value=delHtmlTag(document.getElementById("desc_"+index).innerHTML);
			var checkDtl=document.getElementsByName(object.name);
			var hasChecked=0;
			var detail="";
			for(var  i=0;i<checkDtl.length;++i){
				if (checkDtl[i].checked==true) {
					if (hasChecked==0) {
						detail+=checkDtl[i].value;
					}else {
						detail+=","+checkDtl[i].value;
					}
					++hasChecked;
				}
			}
			document.getElementById("detail").value=detail;
			document.getElementById("inStr").disabled=true;
			for(var i=0;i<size;++i){
				if (i!=index) {
					var check=document.getElementsByName("check_"+i);
					for(var j=0;j<check.length;++j){
						check[j].disabled=true;
					}
				}
			}
		}else{
			var checkDtl=document.getElementsByName(object.name);
			var hasChecked=0;
			var detail="";
			for(var i=0;i<checkDtl.length;++i){
				if (checkDtl[i].checked==true) {
					if (hasChecked==0) {
						detail+=checkDtl[i].value;
					}else {
						detail+=","+checkDtl[i].value;
					}
					++hasChecked;
				}
			}
			if (hasChecked==0) {
				document.getElementById("desc").value="";
				document.getElementById("detail").value="";
				document.getElementById("inStr").disabled=false;
				for(var i=0;i<size;++i){
					var other=document.getElementsByName("check_"+i);
					for(var j=0;j<other.length;++j){
						other[j].disabled=false;
					}
				}
			}else{
				document.getElementById("desc").value=delHtmlTag(document.getElementById("desc_"+index).innerHTML);
				document.getElementById("detail").value=detail;
				document.getElementById("inStr").disabled=true;
				for(var i=0;i<size;++i){
					if (i!=index) {
						var other=document.getElementsByName("check_"+i);
						for(var j=0;j<other.length;++j){
							other[j].disabled=true;
						}
					}
				}
			}
		}
	}
		
		function radioClick(){
			var indexs=document.getElementsByName("radioIndex");
			var radioIndex=0;
			for(var i=0;i<indexs.length;++i){
				if (indexs[i].checked) {
					radioIndex=i;
					document.getElementById("orderNum_"+i).style.backgroundColor="#069";
				}else {
					document.getElementById("orderNum_"+i).style.backgroundColor="#E7EAF7";
				}
			}
			for(var i=0;i<indexs.length;++i){
				var dtlIndex=document.getElementsByName("dtlIndex_"+i);
				if (i==radioIndex) {
					document.getElementById("newTag").value=document.getElementById("ecid_"+i).value;
					document.getElementById("cusOrdermst.refamount").value=document.getElementById("orderpaysum_"+i).value;
					document.getElementById("wspid_"+i).disabled=false;
					document.getElementById("relid_"+i).disabled=false;
					document.getElementById("sendflg_"+i).disabled=false;
					document.getElementById("ecid_"+i).disabled=false;
					document.getElementById("sysname_"+i).disabled=false;
					document.getElementById("shopname_"+i).disabled=false;
					document.getElementById("shopmanager_"+i).disabled=false;
					document.getElementById("dealerflag_"+i).disabled=false;
					document.getElementById("goodsendtype_"+i).disabled=false;
					document.getElementById("orderpaysum_"+i).disabled=false;
					document.getElementById("orderdate_"+i).disabled=false;
					document.getElementById("linkman_"+i).disabled=false;
					document.getElementById("handset_"+i).disabled=false;
					document.getElementById("recaddr_"+i).disabled=false;
					for(var j=0;j<dtlIndex.length;++j){
						dtlIndex[j].disabled=false;
						document.getElementById("dtlname_"+i+"_"+j).disabled=false;
						document.getElementById("dtlspec_"+i+"_"+j).disabled=false;
						document.getElementById("dtlqty_"+i+"_"+j).disabled=false;
						document.getElementById("dtlitemno_"+i+"_"+j).disabled=false;
					}
				}else {
					document.getElementById("wspid_"+i).disabled=true;
					document.getElementById("relid_"+i).disabled=true;
					document.getElementById("sendflg_"+i).disabled=true;
					document.getElementById("ecid_"+i).disabled=true;
					document.getElementById("sysname_"+i).disabled=true;
					document.getElementById("shopname_"+i).disabled=true;
					document.getElementById("shopmanager_"+i).value="";
					document.getElementById("shopmanager_"+i).disabled=true;
					document.getElementById("dealerflag_"+i).disabled=true;
					document.getElementById("goodsendtype_"+i).disabled=true;
					document.getElementById("orderpaysum_"+i).disabled=true;
					document.getElementById("orderdate_"+i).disabled=true;
					document.getElementById("linkman_"+i).disabled=true;
					document.getElementById("handset_"+i).disabled=true;
					document.getElementById("recaddr_"+i).disabled=true;
					for(var j=0;j<dtlIndex.length;++j){
						dtlIndex[j].checked=false;
						dtlIndex[j].disabled=true;
						document.getElementById("dtlname_"+i+"_"+j).disabled=true;
						document.getElementById("dtlspec_"+i+"_"+j).disabled=true;
						document.getElementById("dtlqty_"+i+"_"+j).disabled=true;
						document.getElementById("dtlitemno_"+i+"_"+j).disabled=true;
					}
				}
			}
		}
		
		function init() {
	    	document.getElementById("cusOrdermst.operateopinion").options[0].selected=true;
	        //引入 Zero Clipboard flash文件
	        ZeroClipboard.setMoviePath( "<%=request.getContextPath()%>/js/ZeroClipboard.swf" );
	        //新建对象
	        clip = new ZeroClipboard.Client();
	        //设置指向光标为手型
	        clip.setHandCursor( true );
	        var text="";
	        //添加监听器，完成复制
	        clip.addEventListener("complete", function (client) {
	        	if (text!=""&&text.indexOf("操作人：")>=0) {
	        		document.getElementById("cusForm").submit();
		        	window.open("http://192.168.0.150/ishop/admin/ord/POrderDetail.aspx?Orderid="+document.getElementById("newTag").value);
				}        	
	        });
	        clip.addEventListener("mouseDown",function(client){
	        	var dtlChecked=false;
				if(document.getElementById("detail").value==""){
					if(document.getElementById("inStr").value!=""){
						document.getElementById("desc").value="其他";
						document.getElementById("detail").value=document.getElementById("inStr").value;
					}
				}else {
					dtlChecked=true;
				}
				var indexs=document.getElementsByName("radioIndex");
				var radioIndex=0;
				for(var i=0;i<indexs.length;++i){
					if (indexs[i].checked) {
						radioIndex=i;
					}
				}
				
				var radioChecked=false;
				var spmanagerChecked=false;
				var proChecked=false;
				var indexs=document.getElementsByName("radioIndex");
				var radioIndex=0;
				for(var i=0;i<indexs.length;++i){
					if (indexs[i].checked) {
						radioIndex=i;
						radioChecked=true;
					}
				}
				
				
				for(var i=0;i<indexs.length;++i){
					var dtlIndex=document.getElementsByName("dtlIndex_"+i);
					if (i!=radioIndex) {
						document.getElementById("wspid_"+i).disabled=true;
						document.getElementById("relid_"+i).disabled=true;
						document.getElementById("sendflg_"+i).disabled=true;
						document.getElementById("ecid_"+i).disabled=true;
						document.getElementById("sysname_"+i).disabled=true;
						document.getElementById("shopname_"+i).disabled=true;
						document.getElementById("shopmanager_"+i).disabled=true;
						document.getElementById("dealerflag_"+i).disabled=true;
						document.getElementById("goodsendtype_"+i).disabled=true;
						document.getElementById("orderpaysum_"+i).disabled=true;
						document.getElementById("orderdate_"+i).disabled=true;
						document.getElementById("linkman_"+i).disabled=true;
						document.getElementById("handset_"+i).disabled=true;
						document.getElementById("recaddr_"+i).disabled=true;
						for(var j=0;j<dtlIndex.length;++j){
							document.getElementById("dtlname_"+i+"_"+j).disabled=true;
							document.getElementById("dtlspec_"+i+"_"+j).disabled=true;
							document.getElementById("dtlqty_"+i+"_"+j).disabled=true;
							document.getElementById("dtlitemno_"+i+"_"+j).disabled=true;
						}
					}else {
						if (document.getElementById("shopmanager_"+i).value!="") {
							spmanagerChecked=true;
						}
						for(var j=0;j<dtlIndex.length;++j){
							if (dtlIndex[j].checked) {
								proChecked=true;
								document.getElementById("dtlname_"+i+"_"+j).disabled=false;
								document.getElementById("dtlspec_"+i+"_"+j).disabled=false;
								document.getElementById("dtlqty_"+i+"_"+j).disabled=false;
								document.getElementById("dtlitemno_"+i+"_"+j).disabled=false;	
							}else {
								document.getElementById("dtlname_"+i+"_"+j).disabled=true;
								document.getElementById("dtlspec_"+i+"_"+j).disabled=true;
								document.getElementById("dtlqty_"+i+"_"+j).disabled=true;
								document.getElementById("dtlitemno_"+i+"_"+j).disabled=true;
							}
						}
					}
				}
				text="";
	        	if (radioChecked==false) {
					alert("请选择一个订单");
				}else if (spmanagerChecked==false) {
					alert("请选择店铺负责人");
				}else if (proChecked==false) {
					alert("请至少选择一件商品");
				}else if (dtlChecked==false&&document.getElementById("inStr").value=="") {
					alert("请选择售后问题");
				}else if(document.getElementById("cusOrdermst.operateopinion").value==""){
					alert("请选择退换货问题");
				}else if(document.getElementById("cusOrdermst.operateopinion").value=="退货"
						&&document.getElementById("cusOrdermst.onlineflag").value==""){
					alert("请选择是线上退款还是线下退款");
				}else if(document.getElementById("cusOrdermst.incomingNo").value==""){
					alert("请填写来电号码");
				}else if(document.getElementById("cusOrdermst.operateman").value==""){
					alert("请填写操作人");
				}else{
					if (document.getElementById("cusOrdermst.operateopinion").value=="退货") {
						text="该订单存在："+document.getElementById("desc").value+
		        		"\n具体为："+document.getElementById("detail").value+
		        		"\n操作意见：退货"+
		        		"\t"+document.getElementById("cusOrdermst.onlineflag").value+"退款"+
		        		"\n金额："+document.getElementById("cusOrdermst.refamount").value+
		        		"\n运费："+document.getElementById("cusOrdermst.freight").value+
		        		"\n差价："+document.getElementById("cusOrdermst.pricedisparity").value+
		        		"\n来电号码："+document.getElementById("cusOrdermst.incomingNo").value+
		        		"\n备注："+document.getElementById("cusOrdermst.operateremark").value+
		        		"\n操作人："+document.getElementById("cusOrdermst.operateman").value;
					}else if (document.getElementById("cusOrdermst.operateopinion").value=="换货") {
						text="该订单存在："+document.getElementById("desc").value+
		        		"\n具体为："+document.getElementById("detail").value+
		        		"\n操作意见：换货"+
		        		"\n差价："+document.getElementById("cusOrdermst.pricedisparity").value+
		        		"\n来电号码："+document.getElementById("cusOrdermst.incomingNo").value+
		        		"\n备注："+document.getElementById("cusOrdermst.operateremark").value+
		        		"\n操作人："+document.getElementById("cusOrdermst.operateman").value;
					}else if (document.getElementById("cusOrdermst.operateopinion").value=="催货") {
						text="该订单存在："+document.getElementById("desc").value+
		        		"\n具体为："+document.getElementById("detail").value+
		        		"\n操作意见：催货"+
		        		"\n来电号码："+document.getElementById("cusOrdermst.incomingNo").value+
		        		"\n备注："+document.getElementById("cusOrdermst.operateremark").value+
		        		"\n操作人："+document.getElementById("cusOrdermst.operateman").value;
					}else if (document.getElementById("cusOrdermst.operateopinion").value=="补发") {
						text="该订单存在："+document.getElementById("desc").value+
		        		"\n具体为："+document.getElementById("detail").value+
		        		"\n操作意见：补发"+
		        		"\n来电号码："+document.getElementById("cusOrdermst.incomingNo").value+
		        		"\n备注："+document.getElementById("cusOrdermst.operateremark").value+
		        		"\n操作人："+document.getElementById("cusOrdermst.operateman").value;
					}else if (document.getElementById("cusOrdermst.operateopinion").value=="订单挽回") {
						text="该订单存在："+document.getElementById("desc").value+
		        		"\n具体为："+document.getElementById("detail").value+
		        		"\n操作意见：订单挽回"+
		        		"\n订单金额："+document.getElementById("cusOrdermst.refamount").value+
		        		"\n来电号码："+document.getElementById("cusOrdermst.incomingNo").value+
		        		"\n备注："+document.getElementById("cusOrdermst.operateremark").value+
		        		"\n操作人："+document.getElementById("cusOrdermst.operateman").value;
					}else{
						text="使用粘贴板失败，请检查输入后重试";
					}
	        		clip.setText(text);
				}
	        });
	        //绑定触发对象按钮ID
	      clip.glue("btn");
	    }
	    
	    
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
	    
	    function opinionChange(){
	    	if(document.getElementById("cusOrdermst.operateopinion").value==""){
	    		document.getElementById("cusOrdermst.onlineflag").style.display="none";
	    		document.getElementById("cusOrdermst.onlineflag").value="";
	    		document.getElementById("cusOrdermst.onlineflag").disabled=true;
	    		document.getElementById("refamount").style.display="none";
	    		document.getElementById("cusOrdermst.refamount").disabled=true;
	    		document.getElementById("freight").style.display="none";
	    		document.getElementById("cusOrdermst.freight").disabled=true;
	    		document.getElementById("pricedisparity").style.display="none";
	    		document.getElementById("cusOrdermst.pricedisparity").disabled=true;
	    		document.getElementById("orderpayshow").style.display="none";
	    		document.getElementById("cusOrdermst.orderpayshow").disabled=true;
	    	}else if(document.getElementById("cusOrdermst.operateopinion").value=="退货"){
	    		document.getElementById("cusOrdermst.onlineflag").style.display="block";
	    		document.getElementById("cusOrdermst.onlineflag").disabled=false;
	    		document.getElementById("cusOrdermst.onlineflag").options[0].selected=true;
	    		var indexs=document.getElementsByName("radioIndex");
				for(var i=0;i<indexs.length;++i){
					if (indexs[i].checked) {
						document.getElementById("cusOrdermst.refamount").value=document.getElementById("orderpaysum_"+i).value;
					}
				}
				document.getElementById("cusOrdermst.refamount").disabled=false;
	    		document.getElementById("refamount").style.display="none";
	    		document.getElementById("cusOrdermst.freight").disabled=false;
	    		document.getElementById("freight").style.display="none";
	    		document.getElementById("cusOrdermst.pricedisparity").disabled=false;
	    		document.getElementById("pricedisparity").style.display="none";
	    		document.getElementById("orderpayshow").style.display="none";
	    		document.getElementById("cusOrdermst.orderpayshow").disabled=true;
	    	}else if(document.getElementById("cusOrdermst.operateopinion").value=="换货"){
	    		document.getElementById("cusOrdermst.onlineflag").style.display="none";
	    		document.getElementById("cusOrdermst.onlineflag").disabled=true;
	    		document.getElementById("refamount").style.display="none";
	    		document.getElementById("cusOrdermst.refamount").disabled=true;
	    		document.getElementById("freight").style.display="none";
	    		document.getElementById("cusOrdermst.freight").disabled=true;
	    		document.getElementById("pricedisparity").style.display="block";
	    		document.getElementById("cusOrdermst.pricedisparity").disabled=false;
	    		document.getElementById("orderpayshow").style.display="none";
	    		document.getElementById("cusOrdermst.orderpayshow").disabled=true;
	    	}else if(document.getElementById("cusOrdermst.operateopinion").value=="订单挽回"){
	    		document.getElementById("cusOrdermst.onlineflag").style.display="none";
	    		document.getElementById("cusOrdermst.onlineflag").disabled=true;
	    		document.getElementById("refamount").style.display="none";
	    		document.getElementById("cusOrdermst.refamount").disabled=true;
	    		document.getElementById("freight").style.display="none";
	    		document.getElementById("cusOrdermst.freight").disabled=true;
	    		document.getElementById("pricedisparity").style.display="none";
	    		document.getElementById("cusOrdermst.pricedisparity").disabled=true;
	    		document.getElementById("orderpayshow").style.display="block";
	    		document.getElementById("cusOrdermst.orderpayshow").disabled=false;
	    	}else if(document.getElementById("cusOrdermst.operateopinion").value=="催货"||
	    			document.getElementById("cusOrdermst.operateopinion").value=="补发"){
	    		document.getElementById("cusOrdermst.onlineflag").style.display="none";
	    		document.getElementById("cusOrdermst.onlineflag").disabled=true;
	    		document.getElementById("refamount").style.display="none";
	    		document.getElementById("cusOrdermst.refamount").disabled=true;
	    		document.getElementById("freight").style.display="none";
	    		document.getElementById("cusOrdermst.freight").disabled=true;
	    		document.getElementById("pricedisparity").style.display="none";
	    		document.getElementById("cusOrdermst.pricedisparity").disabled=true;
	    		document.getElementById("orderpayshow").style.display="none";
	    		document.getElementById("cusOrdermst.orderpayshow").disabled=true;
	    	}
	    }
	    
	    function onlineChange(){
	    	if(document.getElementById("cusOrdermst.onlineflag").value!=""){
	    		var indexs=document.getElementsByName("radioIndex");
				for(var i=0;i<indexs.length;++i){
					if (indexs[i].checked) {
						document.getElementById("cusOrdermst.refamount").value=document.getElementById("orderpaysum_"+i).value;
					}
				}
	    		document.getElementById("refamount").style.display="block";
	    		document.getElementById("cusOrdermst.refamount").disabled=false;
	    		document.getElementById("freight").style.display="block";
	    		document.getElementById("cusOrdermst.freight").disabled=false;
	    		document.getElementById("pricedisparity").style.display="block";
	    		document.getElementById("cusOrdermst.pricedisparity").disabled=false;
	    		document.getElementById("orderpayshow").style.display="block";
	    		document.getElementById("cusOrdermst.orderpayshow").disabled=false;
	    	}else{
	    		document.getElementById("refamount").style.display="none";
	    		document.getElementById("cusOrdermst.refamount").disabled=true;
	    		document.getElementById("freight").style.display="none";
	    		document.getElementById("cusOrdermst.freight").disabled=true;
	    		document.getElementById("pricedisparity").style.display="none";
	    		document.getElementById("cusOrdermst.pricedisparity").disabled=true;
	    		document.getElementById("orderpayshow").style.display="none";
	    		document.getElementById("cusOrdermst.orderpayshow").disabled=true;
	    		
	    	}
	    }
	   
		
	</script>

  </head>
  
  <body onload="init()">
  		<div id="main">
  			<div id="pageHeader">
  				<div id="header">
  					<div id="home">
  						<a href="<%=basePath%>">主页</a>
  					</div>
  					<div id="orderProcessed" >
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
				<div id="oDetail">
					<a href="want/CusFeedbackAction.action" class="orderDetail">订单详情</a>
				</div>
  			</div>
  			<div id="body_wrapper">
  				<form action="CusSubAction" method="post"  id="cusForm" onkeydown="if(event.keyCode==13){return false;}">
  					<div id=page_title>
  						<h2>订单详情如下</h2>
  					</div>
  					<table class="od_table" id="od_table">
  						<s:iterator value="list" id="array" status="L">
  						<tr>
  							<th rowspan="<s:property value="dtlList[#L.index].size()+11"/>" 
  							   class="orderNum" width="20px" id="orderNum_<s:property value='#L.index'/>">
  								<input type="radio" name="radioIndex" value="<s:property value='#L.index'/>" 
  									onClick="radioClick()">
  							</th>
  							<td colspan="4" class="od_panel" 
  									style="text-align:center;height:30px;background-color:#FFFDF1;
  									font:bold 16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;color:#3E3E3E;">
  									基本信息
  							</td>
  						</tr>
  						<tr>
  							<th class="od_th">平台订单编号</th>
  							<td>
  								<a href="http://192.168.0.150/ishop/admin/plat/OrderDtl.aspx?Mstid=<s:property value='#array[0]'/>" 
  										target="_blank" name="cusOrdermst.wspid">
  										<s:property value='#array[12]'/>
  								</a>
  								<input type="hidden" name="cusOrdermst.wspid" 
  									id="wspid_<s:property value='#L.index'/>" value="<s:property value='#array[0]'/>"/>	
  								<input type="hidden" name="cusOrdermst.relid" 
  									id="relid_<s:property value='#L.index'/>" value="<s:property value='#array[14]'/>"/>										
  							</td>
  							<th class="od_th">配送状态</th>
  							<td>
  								<s:if test='#array[1]=="1"'>
  									已配送
  								</s:if>
  								<s:else>
  									未配送
  								</s:else>
  								<input type="hidden" name="cusOrdermst.sendflg" 
  								id="sendflg_<s:property value='#L.index'/>" class="od_readonly"  
  								<s:if test='#array[1]=="1"'>value="已配送"</s:if>
  								<s:else>value="未配送"</s:else>
  								/>
  							</td>
  						</tr>
  						<tr>
  							<th class="od_th">网上订单编号</th>
  							<td>
  								<a href="http://192.168.0.150/ishop/admin/ord/POrderDetail.aspx?Orderid=<s:property value='#array[2]'/>"
  										target="_blank" name="cusOrdermst.ecid">
  									<s:property value='#array[2]'/>
  								</a>
  								<input type="hidden" name="cusOrdermst.ecid" 
  								id="ecid_<s:property value='#L.index'/>" value="<s:property value='#array[2]'/>"/>					
  							</td>
  							<th class="od_th">所在平台</th>
  							<td>
  								<s:property value='#array[3]'/>
  								<input type="hidden" name="cusOrdermst.sysname"   id="sysname_<s:property value='#L.index'/>" 
  								class="od_readonly"  value="<s:property value='#array[3]'/>"></input>
  							</td>
  						</tr>
  						<tr>
  							<th class="od_th">所属店铺</th>
  							<td>
  								<s:property value='#array[4]'/>
  								<input type="hidden" name="cusOrdermst.shopname" class="od_readonly"  
  								id="shopname_<s:property value='#L.index'/>" value="<s:property value='#array[4]'/>"></input>
  							</td>
  							<th class="od_th">店铺负责人</th>
  							<td>
  								<s:property value='#array[5]'/>
  								<input type="hidden" name="cusOrdermst.shopmanager"   id="shopmanager_<s:property value='#L.index'/>" 
  								class="od_readonly"  value="<s:property value='#array[5]'/>"></input>
  								<input type="hidden" name="cusOrdermst.shopemail"   id="shopemail_<s:property value='#L.index'/>" 
  								class="od_readonly"  value="<s:property value='#array[6]'/>"></input>
  							</td>
  						</tr>
  						<tr>
  							<th class="od_th">销售属性</th>
  							<td>
  								<s:if test='#array[7]=="0"'>
  									自营
  								</s:if>
  								<s:elseif test='#array[7]=="1"'>
  									代销
  								</s:elseif>
  								<input type="hidden" name="cusOrdermst.dealerflag" 
  								id="dealerflag_<s:property value='#L.index'/>" class="od_readonly"  
  								<s:if test='#array[7]=="0"'>value="自营"</s:if>
  								<s:elseif test='#array[7]=="1"'>value="代销"</s:elseif>
  								/>
  							</td>
  							<th class="od_th">发货方式</th>
  							<td>
  								<s:if test='#array[8]=="1"'>
  									自发
  								</s:if>
  								<s:elseif test='#array[8]=="2"'>
  									代发
  								</s:elseif>
  								<input type="hidden" name="cusOrdermst.goodsendtype" 
  								id="goodsendtype_<s:property value='#L.index'/>" class="od_readonly"  
  								<s:if test='#array[8]=="1"'>value="自发"</s:if>
  								<s:elseif test='#array[8]=="2"'>value="代发"</s:elseif>
  								/>
  							</td>
  						</tr>
  						<tr>
  							<th class="od_th">订单金额</th>
  							<td>
  								<s:property value='#array[9]'/>
  								<input type="hidden" name="cusOrdermst.orderpaysum"  id="orderpaysum_<s:property value='#L.index'/>"
  								class="od_readonly"  value="<s:property value='#array[9]'/>"></input>
  							</td>
  							<th class="od_th">付款时间</th>
  							<td>
  								<s:property value='#array[10]'/>
  								<input type="hidden" name="cusOrdermst.orderdate"  id="orderdate_<s:property value='#L.index'/>"
  								class="od_readonly"  value="<s:property value='#array[10]'/>"></input>
  							</td>
  						</tr>
  						<tr>
  							<th class="od_th">收货人</th>
  							<td>
  								<s:property value='#array[11]'/>
  								<input type="hidden" name="cusOrdermst.linkman"  id="linkman_<s:property value='#L.index'/>"
  								class="od_readonly"  value="<s:property value='#array[11]'/>"></input>
  							</td>
  							<th class="od_th">手机号</th>
  							<td>
  								<s:property value='#array[12]'/>
  								<input type="hidden" name="cusOrdermst.handset"  id="handset_<s:property value='#L.index'/>"
  								class="od_readonly"  value="<s:property value='#array[12]'/>"></input>
  							</td>
  						</tr>
  						<tr>
  							<th class="od_th">收货地址</th>
  							<td colspan="3">
  								<s:property value='#array[13]'/>
  								<input type="hidden" name="cusOrdermst.recaddr"  id="recaddr_<s:property value='#L.index'/>"
  								class="od_readonly"  value="<s:property value='#array[13]'/>"></input>
  							</td>
  						</tr>
  						<tr>
  							<td colspan="4" class="od_panel" 
  									style="text-align:center;height:30px;background-color:#FFFDF1;
  									font:bold 16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;color:#3E3E3E;">
  									订单明细
  							</td>
  						</tr>
  						<s:iterator value="dtlList[#L.index]"  id="arr" status="TL">
  							<tr>
  								<th class="od_th">
  									<label>
  										<input class="form-checkbox" type="checkbox" name="dtlIndex_<s:property value='#L.index'/>" 
  										disabled value="<s:property value="#TL.index"/>"></input>
  									</label>
  								</th>
  								<th class="od_th">
  									<s:property value="#arr[0]"/>
  									<input type="hidden" name="cusDtlList[<s:property value='#TL.index'/>].proname" 
  									id="dtlname_<s:property value='#L.index'/>_<s:property value='#TL.index'/>"
  									value="<s:property value='#arr[0]'/>"/>
  								</th>
  								<th class="od_th">
  									<s:property value="#arr[1]"/>
  									<input type="hidden" name="cusDtlList[<s:property value='#TL.index'/>].prospecification" 
  									id="dtlspec_<s:property value='#L.index'/>_<s:property value='#TL.index'/>"
  									value="<s:property value='#arr[1]'/>"/>
  								</th>
  								<th class="od_th">
  									<s:property value="#arr[2]"/>
  									<input type="hidden" name="cusDtlList[<s:property value='#TL.index'/>].proqty"  
  									id="dtlqty_<s:property value='#L.index'/>_<s:property value='#TL.index'/>"
  									value="<s:property value='#arr[2]'/>"/>
  									<input type="hidden" name="cusDtlList[<s:property value='#TL.index'/>].itemno"  
  									id="dtlitemno_<s:property value='#L.index'/>_<s:property value='#TL.index'/>"
  									value="<s:property value='#arr[3]'/>"/>
  								</th>
  							</tr>
  						</s:iterator>
  						<tr>
  							<td colspan="4" class="od_panel" 
  									style="text-align:center;height:30px;background-color:#FFFDF1;
  									font:bold 16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;color:#3E3E3E;">
  									订单状态
  							</td>
  						</tr>
  						<tr>
  							<td colspan="4" class="od_panel" 
  									style="text-align:center;height:60px;background-color:#FFF;
  									border:1px solid #CCC；padding:3px;">
  									下单--->采购--->发货--->退货(换货)      注：此模块仅作测试用
  							</td>
  						</tr>
  						<tr>
  							<td colspan="5" style="height:3px;background-color:#069;color:#FFF;"></td>
  						</tr>
  						
  						</s:iterator>
  					</table>
  					<div id=page_title>
  					<h2>请选择售后问题，并填写你的操作意见</h2>
  					</div>
  					<div id="op">
  						<div class="noavatar">
  							<h3>售后问题</h3>
  						</div>
  						<ol id="option">
  							<s:iterator value="proList" id="proDesc" status="S">
  								<li class="option_b" >
  									<h4 id="desc_<s:property value='#S.index'/>">
  										<s:property value="#proDesc.description"/>
  									</h4>
  									<div>
  										<div class="form-special-wrap">
  												<s:if test="#proDesc.description=='其他'">
  													<input class="form-input" type="text" name="inStr" id="inStr"/>
  												</s:if>
  												<s:else>
  													<s:iterator value="#proDesc.cusDetails" id="proDetail" status="T">
  													<input class="form-checkbox" type="checkbox" name="check_<s:property value='#S.index'/>"  
  														value="<s:property value="#proDetail.detail"/>" onClick="disableChange(<s:property value='#S.index'/>,<s:property value='proList.size()' />,this)"/>
  													<s:property value="#proDetail.detail"/>				
  													</s:iterator>
  												</s:else>
  										</div>
  									</div>
  								</li>
  							</s:iterator>
  						</ol>
  						<input type="hidden" name="newTag"  id="newTag"/>
  						<input type="hidden" name="cusOrdermst.cusdesc" id="desc"/>
  						<input type="hidden" name="cusOrdermst.cusdetail" id="detail"/>
  					<div class="noavatar">
  						<h3>操作意见</h3>
  					</div>
  					<div class="opadv">
  						<div id="opastep">
  							<div class="opa">
  							<span>
  								<span class="label">操作意见：</span>
  								<select name="cusOrdermst.operateopinion" id="cusOrdermst.operateopinion"
  									onchange="opinionChange()" >
  									<option selected value="">请选择:</option>
  									<option value="换货">换货</option>
  									<option value="退货">退货</option>
  									<option value="催货">催货</option>
  									<option value="补发">补发</option>
  									<!-- <option value="订单挽回">订单挽回</option> -->
  								</select>
  								<select name="cusOrdermst.onlineflag" id="cusOrdermst.onlineflag"
  									style="display:none;" onchange="onlineChange()">
  									<option selected value="">请选择:</option>
  									<option value="线上">线上</option>
  									<option value="线下">线下</option>
  								</select>
  								<span id="refamount" class="labelDis">
  									金额：<input class="form-opp" type="text" name="cusOrdermst.refamount" id="cusOrdermst.refamount"
  										value="0"></input>
  								</span>
  								<span id="freight" class="labelDis">
  									运费：<input class="form-opp" type="text" name="cusOrdermst.freight" id="cusOrdermst.freight"
  										value="0"></input>
  								</span>
  								<span id="pricedisparity" class="labelDis">
  									差价：<input class="form-opp" type="text" name="cusOrdermst.pricedisparity" id="cusOrdermst.pricedisparity"
  										value="0"></input>
  								</span>
  								<%-- <span id="orderpayshow" class="labelDis">
  									订单金额：<input class="form-opp" type="text"  id="cusOrdermst.orderpayshow"
  										value="<s:property value='#array[9]'/>"></input>
  								</span> --%>
  											
  						</div>
  						<div class="opa">
  							<span>
  							来电号码：<input class="form-opp" type="text" name="cusOrdermst.incomingNo" id="cusOrdermst.incomingNo" value="<s:property value='#array[12]'/>"></input>
  							</span>
  							<span>
  								操作人：
  								<input class="form-opp" type="text" name="cusOrdermst.operateman" id="cusOrdermst.operateman" ></input>
  							</span>  			
  						</div>
  						<div class="opa">
  							<span>
  							备注：<input class="form-remark" type="text" name="cusOrdermst.operateremark" id="cusOrdermst.operateremark"></input>
  							</span>
  						</div>
  						<div class="opa">
  							<input id="btn" class="btn" type="button" value="提交"></input>
  						</div>
  						</div>
  					</div>
  					</div> 					
  				</form>
  			</div>
  		</div>
  </body>
</html>
