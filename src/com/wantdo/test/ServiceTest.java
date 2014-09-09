package com.wantdo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.wantdo.domain.CusDesc;
import com.wantdo.domain.CusOrderback;
import com.wantdo.domain.CusOrderdtl;
import com.wantdo.domain.Email;
import com.wantdo.service.ICusOrderbackService;
import com.wantdo.service.ICusOrderdtlService;
import com.wantdo.service.ICusOrdermstService;
import com.wantdo.service.ICusPurchaseService;
import com.wantdo.service.IEcEordermstService;
import com.wantdo.service.impl.MailService;

public class ServiceTest {

	@Test
	public void testGetByMap() {
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		IEcEordermstService service=(IEcEordermstService)factory.getBean("EcEordermstService");
		Map<String, String> map=new HashMap<String, String>();
		map.put("relid", "423112666209624");
		map.put("handset", "15931360810");
		map.put("memberid", "������С��");
		List list=service.getByMap(map);
		System.out.println(list.size());
	}
	
	@Test
	public void testGetByOrderid() {
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		IEcEordermstService service=(IEcEordermstService)factory.getBean("EcEordermstService");
		List list=service.getByOrderid("EO00113091301221");
		System.out.println(list.size());
	}
	
	@Test
	public void testGetAllProblems() {
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		IEcEordermstService service=(IEcEordermstService)factory.getBean("EcEordermstService");
		List<CusDesc> list=service.getAllProblems();
		Set set=list.get(0).getCusDetails();
		System.out.println(set);
	}
	
	/*@Test
	public void testMstSave(){
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICusOrdermstService service=(ICusOrdermstService)factory.getBean("CusOrdermstService");
		CusOrdermst cusOrdermst=new CusOrdermst(
				"3_1_423112666209625", "WAIT_SELLER_SEND_GOODS", "EO00113091301221", "�Ա�ƽ̨", 
				"(��è)��������רӪ��", "xx",
				"81.9", new Timestamp(new Date().getTime()), "������", "15931360810", 
				"�ӱ�ʡ��ˮ�������غӱ�������ѧ������",new Timestamp(new Date().getTime()),
				"��Ʒ��������","�ߴ�ƫ��,���ʲ���","�˻�","yy","","13659862546","423112666209625",
				"0","1","����","20.00","5.0","10.00","luanx@wantdo.com");
		service.save(cusOrdermst);
	}*/
	
	@Test
	public void testDtlSave(){
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICusOrderdtlService service=(ICusOrderdtlService)factory.getBean("CusOrderdtlService");
		CusOrderdtl cusOrderdtl=new CusOrderdtl(
				1, "������άƽ�ǿ�", "��ɫ|XL","1","SQL-8882");
		service.save(cusOrderdtl);
	}
	
	@Test
	public void testGetByOpDate() throws Exception{
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICusOrdermstService service=(ICusOrdermstService)factory.getBean("CusOrdermstService");
		List list=service.getByOpDate("2014-03-24 00:00", "2014-03-24 23:59");
		System.out.println(list.size());
	}
	
	@Test
	public void testGetAllByOpDate() throws Exception{
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICusOrdermstService service=(ICusOrdermstService)factory.getBean("CusOrdermstService");
		List list=service.getAllByOpDate("2014-03-24 00:00", "2014-03-24 23:59");
		System.out.println(list.size());
	}
	
	@Test
	public void testGetMessage() throws Exception{
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("springMail.xml"));
		MailService service=(MailService)factory.getBean("MailService");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("shopname", "(��è)��������רӪ��");
		map.put("shopmanager", "xx");
		map.put("relid", "423112666209625");
		map.put("cusdesc", "��Ʒ��������");
		map.put("cusdetail", "�ߴ�ƫ��,���ʲ���");
		map.put("url", "http://www.wantdo.com");
		System.out.println(service.getMessage(map));
	}
	
	@Test
	public void testsendMessage() throws Exception{
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("springMail.xml"));
		MailService service=(MailService)factory.getBean("MailService");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("shopname", "(��è)��������רӪ��");
		map.put("shopmanager", "xx");
		map.put("relid", "423112666209625");
		map.put("cusdesc", "��Ʒ��������");
		map.put("cusdetail", "�ߴ�ƫ��,���ʲ���");
		map.put("url", "http://www.wantdo.com");
		Email email=new Email("sw@wantdo.cn", "luanx@wantdo.com;826141705@qq.com", 
				"�ͻ�����", service.getMessage(map));
		service.sendMessage(email);
	}
	@Test
	public void testCusPurchaseService() throws Exception{
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICusPurchaseService service=(ICusPurchaseService)factory.getBean("CusPurchaseService");
		List list=service.findAll();
		System.out.println(list.size());
	}
	@Test
	public void testCusOrderbackService() throws Exception{
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICusOrderbackService service=(ICusOrderbackService)factory.getBean("CusOrderbackService");
		CusOrderback cusOrderback = new CusOrderback();
		cusOrderback.setId(37);
		service.update(cusOrderback);
		//System.out.println(list.size());
	}
	
}
