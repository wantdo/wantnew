package com.wantdo.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.domain.CusOrderdtl;
import com.wantdo.domain.CusOrdermst;
import com.wantdo.domain.CusShops;
import com.wantdo.service.ICusOrdermstService;
import com.wantdo.utils.ExcelUtil;

public class DownloadAction extends ActionSupport {
	
	private static String[] excelHeader={
		"序号","日期","订单状态","店铺编号","店铺名称",
		"所属行业","订单号","订单情况","退换货反馈","问题细化分类","线上线下","金额",
		"运费","差价","发货情况","商品名称","姓名","手机号","商品数量","商品货号",
		"运单号","备注","处理人员","店铺负责人" 
	};
	
	private String startTime;
	private String endTime;
	private ICusOrdermstService cusOrdermstService;
	private List<String[]> list=new ArrayList<String[]>();
	
	public InputStream getDownloadFile() throws Exception{
		// TODO Auto-generated method stub
		StringBuffer startBuffer=new StringBuffer(startTime);
		startBuffer.insert(4, "-");
		startBuffer.insert(7, "-");
		startBuffer.append(" 00:00");
		StringBuffer endBuffer=new StringBuffer(endTime);
		endBuffer.insert(4, "-");
		endBuffer.insert(7, "-");
		endBuffer.append(" 23:59");
		List<Object[]> cusMstDtlList=cusOrdermstService.getAllByOpDate(startBuffer.toString(), endBuffer.toString());
		
		Map<CusOrdermst, List<CusOrderdtl>> map=new LinkedHashMap<CusOrdermst, List<CusOrderdtl>>();
		boolean isBreak=false;
		for(int i=0;i<cusMstDtlList.size();++i){
			CusOrdermst cusOrdermst=(CusOrdermst)cusMstDtlList.get(i)[0];
			CusOrderdtl cusOrderdtl=(CusOrderdtl)cusMstDtlList.get(i)[1];
			CusShops cusShops=(CusShops)cusMstDtlList.get(i)[2];
			if(cusOrdermst.getWspshopid().equals(cusShops.getWspshopid())){
				cusOrdermst.setShopindustry(cusShops.getShopindustry());
				cusOrdermst.setShopno(cusShops.getShopno());
			}
			if (i==0) {
				List<CusOrderdtl> cusList=new ArrayList<CusOrderdtl>();
				cusList.add(cusOrderdtl);
				map.put(cusOrdermst, cusList);
			}else {
				isBreak=false;
				for(Entry<CusOrdermst, List<CusOrderdtl>> entry:map.entrySet()){
					if (cusOrdermst.getCusid()==entry.getKey().getCusid()) {
						List<CusOrderdtl> cusList=entry.getValue();
						cusList.add(cusOrderdtl);
						map.put(cusOrdermst, cusList);
						isBreak=true;
						break;
					}
				}
				if (isBreak==false) {
					List<CusOrderdtl> cusList=new ArrayList<CusOrderdtl>();
					cusList.add(cusOrderdtl);
					map.put(cusOrdermst, cusList);
				}
			}
		}
		int index=1;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for(Entry<CusOrdermst, List<CusOrderdtl>> entry:map.entrySet()){
			CusOrdermst cusOrdermst=entry.getKey();
			List<CusOrderdtl> cusDtlList=entry.getValue();
			String[] strArr=null;
			for(int i=0;i<cusDtlList.size();++i){
				if (i==0) {
					strArr=new String[]{
						String.valueOf(index),sdf.format(cusOrdermst.getOperatedate()),cusOrdermst.getSendflg(),
						cusOrdermst.getShopno(),cusOrdermst.getShopname(),cusOrdermst.getShopindustry(),cusOrdermst.getRelid(),cusOrdermst.getCusdesc(),
						cusOrdermst.getOperateopinion(),cusOrdermst.getCusdetail(),cusOrdermst.getOnlineflag(),
						cusOrdermst.getRefamount(),cusOrdermst.getFreight(),cusOrdermst.getPricedisparity(),
						cusOrdermst.getSendflg(),cusDtlList.get(0).getProname(),cusOrdermst.getLinkman(),
						cusOrdermst.getHandset(),cusDtlList.get(0).getProqty(),
						cusDtlList.get(0).getItemno(),cusOrdermst.getWaybill(),cusOrdermst.getOperateremark(),
						cusOrdermst.getOperateman(),cusOrdermst.getShopmanager()
					};
				}else {
					strArr[15]+=","+cusDtlList.get(i).getProname();
					strArr[18]+=","+cusDtlList.get(i).getProqty();
					strArr[19]+=","+cusDtlList.get(i).getItemno();
				}
			}
			++index;
			list.add(strArr);
		}
		//保存信息到Excel文件，路径为\download\customer.xls
		String downloadDir=ServletActionContext.getServletContext().getRealPath("download");
		if (!(new File(downloadDir).isDirectory())) {
			new File(downloadDir).mkdirs();
			downloadDir=ServletActionContext.getServletContext().getRealPath("download");
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
		excelUtil.writeExpExcel(list, excelHeader, excelFile);
		return new FileInputStream(downloadDir+File.separator+"customer.xls");
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ICusOrdermstService getCusOrdermstService() {
		return cusOrdermstService;
	}

	public void setCusOrdermstService(ICusOrdermstService cusOrdermstService) {
		this.cusOrdermstService = cusOrdermstService;
	}

	public static String[] getExcelHeader() {
		return excelHeader;
	}

	public static void setExcelHeader(String[] excelHeader) {
		DownloadAction.excelHeader = excelHeader;
	}

	public List<String[]> getList() {
		return list;
	}

	public void setList(List<String[]> list) {
		this.list = list;
	}
	
	


}
