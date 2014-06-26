<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf8">
	</head>
	<body>
		尊敬的 ${cusMst.shopname} 负责人 ${cusMst.shopmanager}：<br><br>
		你店铺的 ${cusMst.relid} 订单今天客户反馈有如下问题： ${cusMst.cusdesc}(${cusMst.cusdetail})<br><br>
		订单详情：<br><br>
		订单编号：${cusMst.relid}<br>
		配送状态：${cusMst.sendflg}<br>
		销售属性：${cusMst.dealerflag}<br>
		发货方式：${cusMst.goodsendtype}<br>
		金额：${cusMst.orderpaysum}<br>
		付款时间：${cusMst.orderdate}<br>
		收货人：${cusMst.linkman}<br>
		手机号：${cusMst.handset}<br>
		收货地址：${cusMst.recaddr}<br><br>
		<#list cusDtl as dtl>
			名称：${dtl.proname} (${dtl.prospecification})<br>
			数量：${dtl.proqty}&nbsp; &nbsp;商品货号：${dtl.itemno}
			<br><br/>
		</#list><br>
		客户部已收到客户反馈做出了相应处理。处理详情如下：<br><br>
		处理意见：${cusMst.operateopinion}<br>
		<#if cusMst.operateopinion=="退货">
			${cusMst.onlineflag}&nbsp;&nbsp;金额：${cusMst.refamount}&nbsp;&nbsp;
			运费：${cusMst.freight}&nbsp;&nbsp;差价：${cusMst.pricedisparity}
		<#elseif cusMst.operateopinion=="换货">
			差价：${cusMst.pricedisparity}
		</#if><br>
		备注：${cusMst.operateremark}<br>
		操作人：${cusMst.operateman}<br>
		处理时间：${cusMst.operatedate}<br><br>
		请及时处理该订单。<br><br>
		客户部：陈丽君 13588410637<br>
		采购部：黄艳秋 13335713333<br>
		物流部：沈昂 18657196539<br><br>
		谢谢！<br><br>
		(这是一封自动产生的邮件，请勿回复)<br><br>
		杭州王道电子商务有限公司<br>
		<a href="${url!''}" target="_blank">${url!''}</a><br><br>&nbsp;<br>
	</body>
</html>