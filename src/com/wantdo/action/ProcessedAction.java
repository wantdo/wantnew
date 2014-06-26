package com.wantdo.action;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.domain.CusOrdermst;
import com.wantdo.service.ICusOrdermstService;

public class ProcessedAction extends ActionSupport {
	
	private String[] strArray={"订单编号","电话号码","店铺名称","退换货反馈","问题细化分类","操作意见","操作人"};
	
	private String startTime;
	private String endTime;
	private Map<String, List<CusOrdermst>> map;
	private ICusOrdermstService cusOrdermstService;
	
	

	public ProcessedAction() {
		super();
		// TODO Auto-generated constructor stub
		map=new LinkedHashMap<String, List<CusOrdermst>>();
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		StringBuffer startBuffer=new StringBuffer(startTime);
		startBuffer.insert(4, "-");
		startBuffer.insert(7, "-");
		startBuffer.append(" 00:00");
		StringBuffer endBuffer=new StringBuffer(endTime);
		endBuffer.insert(4, "-");
		endBuffer.insert(7, "-");
		endBuffer.append(" 23:59");
		List<CusOrdermst> list=cusOrdermstService.getByOpDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
		boolean isBreak=false;
		if (list!=null) {
			for(int i=0;i<list.size();++i){
				if (i==0) {
					List<CusOrdermst> cusList=new ArrayList<CusOrdermst>();
					cusList.add(list.get(0));
					map.put(sdFormat.format(list.get(0).getOperatedate()), cusList);
				}else {
					isBreak=false;
					String operatedate=sdFormat.format(list.get(i).getOperatedate());
					for(Entry<String, List<CusOrdermst>> entry:map.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							List<CusOrdermst> cList=entry.getValue();
							cList.add(list.get(i));
							map.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {
						List<CusOrdermst> cList=new ArrayList<CusOrdermst>();
						cList.add(list.get(i));
						map.put(operatedate, cList);
					}
				}
			}
			System.out.println(map);
		}
		return SUCCESS;
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
	
	

	public Map<String, List<CusOrdermst>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<CusOrdermst>> map) {
		this.map = map;
	}

	public ICusOrdermstService getCusOrdermstService() {
		return cusOrdermstService;
	}

	public void setCusOrdermstService(ICusOrdermstService cusOrdermstService) {
		this.cusOrdermstService = cusOrdermstService;
	}

	public String[] getStrArray() {
		return strArray;
	}

	public void setStrArray(String[] strArray) {
		this.strArray = strArray;
	}

	
	
	
	

}
