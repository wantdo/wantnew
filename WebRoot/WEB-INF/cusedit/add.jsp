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
    
    <title>编辑售后问题</title><%=request.getSession().getAttribute("username") %>，您好
    
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
		
		
		
		<%-- function init() {
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
					}else{
						text="使用粘贴板失败，请检查输入后重试";
					}
	        		clip.setText(text);
				}
	        });
	        //绑定触发对象按钮ID
	      clip.glue("btn");
	    } --%>
	    
	    function check(){
	    	if(confirm("确定要新增吗？")){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
	    function opinionChange(){
	    	if(document.getElementById("leibie").value==""){
	    		document.getElementById("cusDesc.description").style.display="none";
	    		document.getElementById("cusDesc.description").disabled=true;
	    		document.getElementById("cusDetail.cusDesc.id").style.display="none";
	    		document.getElementById("cusDetail.cusDesc.id").value="";
	    		document.getElementById("cusDetail.cusDesc.id").disabled=true;
	    		document.getElementById("cusDetail.detail").style.display="none";
	    		document.getElementById("cusDetail.detail").disabled=true;
	    	}else if(document.getElementById("leibie").value=="小类别"){
	    		document.getElementById("cusDetail.cusDesc.id").style.display="block";
	    		document.getElementById("cusDetail.cusDesc.id").disabled=false;
	    		document.getElementById("cusDetail.cusDesc.id").options[0].selected=true;
	    		document.getElementById("cusDesc.description").style.display="none";
	    		document.getElementById("cusDesc.description").disabled=true;
	    		document.getElementById("cusDetail.detail").style.display="block";
	    		document.getElementById("cusDetail.detail").disabled=false;
	    	}else if(document.getElementById("leibie").value=="大类别"){
	    		document.getElementById("cusDetail.cusDesc.id").style.display="none";
	    		document.getElementById("cusDetail.cusDesc.id").disabled=true;
	    		document.getElementById("cusDesc.description").style.display="block";
	    		document.getElementById("cusDesc.description").disabled=false;
	    		document.getElementById("cusDetail.detail").style.display="none";
	    		document.getElementById("cusDetail.detail").disabled=true;
	    	}
	    }
		
	</script>

  </head>
  
  <body >
  		<div id="main">
  			<div id="pageHeader">
  				<div id="header">
  					<div id="home">
  						<a href="<%=basePath%>">主页</a>
  					</div>
  				</div>
  			</div>
  			<div id="body_wrapper">
  				<form action="CusEditAction" method="post"  >
  					<div id="op">
  						<div class="noavatar">
  							<h3>售后问题</h3>
  						</div>
  						<ol id="option">
  							<s:iterator value="proList" id="proDesc" status="S">
  								<li class="option_b" >
  									<h4 id="desc_<s:property value='#S.index'/>">
  									<input id="checkradio1" class="form-checkbox" type="radio"
										name="cusDesc.id" value="<s:property value="#proDesc.id"/>" disabled/>
  										<s:property value="#proDesc.description"/>
  									</h4>
  									<div id="desc_<s:property value='#S.index'/>">
  										<div class="form-special-wrap">
  										<s:if test="#proDesc.description=='其他'" >
  													<input class="form-input" type="text" name="inStr" id="inStr" disabled/>
  												</s:if>
  												<s:else>
  													<s:iterator value="#proDesc.cusDetails" id="proDetail" status="T">
  													<input class="form-checkbox" type="radio" name="check_<s:property value='#S.index'/>"  
  														value="<s:property value="#proDetail.detail"/>" disabled/>
  													<s:property value="#proDetail.detail"/>	
  													<s:property value="#proDetail.descid"/>	
  													</s:iterator>
  												</s:else>
  										</div>
  									</div>
  								</li>
  							</s:iterator>
  						</ol>
  						<span class="label">类别：</span>
  							<select id = "leibie" name = "leibie" onchange="opinionChange()">
  								<option selected value="">请选择:</option>
  								<option value= "大类别">大类别</option>
  								<option value= "小类别">小类别</option>
  							</select>
  							<span id = "cusDesc.description" class="labelDis" style="display:none;">添加大类：<input type = "text" name = "cusDesc.description" id = "cusDesc.description"/></span>
  							<select name = "cusDetail.cusDesc.id" id = "cusDetail.cusDesc.id" style="display:none;" >
  							<s:iterator value="proList" id="proDesc" status="S">
  									<option value="<s:property value='#proDesc.id'/>">
  										<s:property value="#proDesc.description"/>
  									</option>
  							</s:iterator>
  							</select>
  						<span id = "cusDetail.detail" class="labelDis" style="display:none;">添加小类：<input type = "text" name = "cusDetail.detail" id = "cusDetail.detail"/></span>
  						<div class="opa">
  							<input type="hidden" name="edit" value = "addimpl"/>
  							<input id="btn" class="btn" type="submit" value="确认" onclick = "return check()"></input>
  							<input type="button" class="btn" onclick="history.go(-1)" value="返回"></input>
  						</div>
  					</div> 					
  				</form>
  			</div>
  		</div>
  </body>
</html>

