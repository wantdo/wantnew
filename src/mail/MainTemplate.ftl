<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf8">
	</head>
	<body>
		�𾴵� ${cusMst.shopname} ������ ${cusMst.shopmanager}��<br><br>
		����̵� ${cusMst.relid} ��������ͻ��������������⣺ ${cusMst.cusdesc}(${cusMst.cusdetail})<br><br>
		�������飺<br><br>
		������ţ�${cusMst.relid}<br>
		����״̬��${cusMst.sendflg}<br>
		�������ԣ�${cusMst.dealerflag}<br>
		������ʽ��${cusMst.goodsendtype}<br>
		��${cusMst.orderpaysum}<br>
		����ʱ�䣺${cusMst.orderdate}<br>
		�ջ��ˣ�${cusMst.linkman}<br>
		�ֻ��ţ�${cusMst.handset}<br>
		�ջ���ַ��${cusMst.recaddr}<br><br>
		<#list cusDtl as dtl>
			���ƣ�${dtl.proname} (${dtl.prospecification})<br>
			������${dtl.proqty}&nbsp; &nbsp;��Ʒ���ţ�${dtl.itemno}
			<br><br/>
		</#list><br>
		�ͻ������յ��ͻ�������������Ӧ���������������£�<br><br>
		���������${cusMst.operateopinion}<br>
		<#if cusMst.operateopinion=="�˻�">
			${cusMst.onlineflag}&nbsp;&nbsp;��${cusMst.refamount}&nbsp;&nbsp;
			�˷ѣ�${cusMst.freight}&nbsp;&nbsp;��ۣ�${cusMst.pricedisparity}
		<#elseif cusMst.operateopinion=="����">
			��ۣ�${cusMst.pricedisparity}
		</#if><br>
		��ע��${cusMst.operateremark}<br>
		�����ˣ�${cusMst.operateman}<br>
		����ʱ�䣺${cusMst.operatedate}<br><br>
		�뼰ʱ����ö�����<br><br>
		�ͻ����������� 13588410637<br>
		�ɹ����������� 13335713333<br>
		���������� 18657196539<br><br>
		лл��<br><br>
		(����һ���Զ��������ʼ�������ظ�)<br><br>
		�������������������޹�˾<br>
		<a href="${url!''}" target="_blank">${url!''}</a><br><br>&nbsp;<br>
	</body>
</html>