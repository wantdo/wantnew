package com.wantdo.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.wantdo.utils.ExcelUtil;

public class ExcelTest {
	
	private static String[] excelHeader={
		"序号","日期","订单状态","店铺编号","店铺名称",
		"所属行业","订单号","订单情况","退换货反馈","问题细化分类","发货情况",
		"商品名称","姓名","手机号","商品数量","商品货号",
		"备注","处理人员","店铺负责人"
	};

	@Test
	public void test() {
		String downloadDir="G:\\MyEclipse Professional\\Workspace\\.metadata\\.me_tcat7\\webapps\\want\\download";
		if (!(new File(downloadDir).isDirectory())) {
			new File(downloadDir).mkdirs();
		}
		File excelFile=new File(downloadDir+File.separator+"customer.xls");
		try {
			if (!excelFile.exists()) {
				excelFile.createNewFile();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		ExcelUtil excelUtil=new ExcelUtil();
		List<String[]> list=new ArrayList<String[]>();
		excelUtil.writeExpExcel(list, excelHeader, excelFile);
	}

}
