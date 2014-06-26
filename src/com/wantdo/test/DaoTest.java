package com.wantdo.test;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.wantdo.dao.ICusOrderdtlDAO;
import com.wantdo.dao.ICusOrdermstDAO;
import com.wantdo.dao.IEcEordermstDAO;
import com.wantdo.domain.CusDesc;
import com.wantdo.domain.CusDetail;
import com.wantdo.domain.CusOrderdtl;
import com.wantdo.domain.CusOrdermst;

public class DaoTest {

	@Test
	public void testFindByMap() {
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		IEcEordermstDAO dao=(IEcEordermstDAO)factory.getBean("EcEordermstDAO");
		Map<String, String> map=new HashMap<String, String>();
		map.put("relid", "14040915121924 ");
		/*
		map.put("handset", "15931360810");
		map.put("memberid", "张艳美小语");
		*/
		List list=dao.findByMap(map);
		System.out.println(list.size());
	}
	
	@Test
	public void testFindByOrderid() {
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		IEcEordermstDAO dao=(IEcEordermstDAO)factory.getBean("EcEordermstDAO");
		List list=dao.findByOrderid("EO00113091301221");
		System.out.println(list.size());
	}
	
	@Test
	public void testFindAllProblems(){
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		IEcEordermstDAO dao=(IEcEordermstDAO)factory.getBean("EcEordermstDAO");
		List<CusDesc> list=dao.findAllProblems();
		Set<CusDetail> set=list.get(0).getCusDetails();
		for(CusDetail object:set){
			System.out.println(object.getDetail());
		}
	}
	
	/*@Test
	public void testMstSave(){
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICusOrdermstDAO dao=(ICusOrdermstDAO)factory.getBean("CusOrdermstDAO");
		CusOrdermst cusOrdermst=new CusOrdermst(
				"3_1_423112666209625", "WAIT_SELLER_SEND_GOODS", "EO00113091301221", "淘宝平台", 
				"(天猫)王道服饰专营店", "xx",
				"81.9", new Timestamp(new Date().getTime()), "张艳美", "15931360810", 
				"河北省衡水市武邑县河北武邑中学物理组",new Timestamp(new Date().getTime()),
				"产品描述问题","尺寸偏大,材质不符","退货","yy","","13659862546","423112666209625",
				"0","1","线上","20.00","5.0","10.00","luanx@wantdo.com");
		dao.save(cusOrdermst);
	}*/
	
	@Test
	public void testDtlSave(){
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICusOrderdtlDAO dao=(ICusOrderdtlDAO)factory.getBean("CusOrderdtlDAO");
		CusOrderdtl cusOrderdtl=new CusOrderdtl(
				1, "天竹纤维平角裤", "黑色|XL","1.0","SQL-8882");
		dao.save(cusOrderdtl);
	}
	
	@Test
	public void testFindByOpTime()  throws Exception{
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICusOrdermstDAO dao=(ICusOrdermstDAO)factory.getBean("CusOrdermstDAO");
		List list=dao.findByOpDate("2014-03-21 00:00","2014-03-24 23:59");
		System.out.println(list.size());
	}
	
	@Test
	public void testFindAllByOpTime()  throws Exception{
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICusOrdermstDAO dao=(ICusOrdermstDAO)factory.getBean("CusOrdermstDAO");
		List list=dao.findAllByOpDate("2014-03-21 00:00","2014-03-24 23:59");
		System.out.println(list.size());
	}
	
	
}
