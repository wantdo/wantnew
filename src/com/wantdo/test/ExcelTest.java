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
		"���","����","����״̬","���̱��","��������",
		"������ҵ","������","�������","�˻�������","����ϸ������","�������",
		"��Ʒ����","����","�ֻ���","��Ʒ����","��Ʒ����",
		"��ע","������Ա","���̸�����"
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
