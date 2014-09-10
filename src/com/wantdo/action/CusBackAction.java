package com.wantdo.action;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.domain.CusOrderback;
import com.wantdo.service.ICusOrderbackService;
import com.wantdo.utils.ExcelUtil;


//采购-->物流
public class CusBackAction extends ActionSupport {
	
	private String variable;
	private File temp;
	private File upload;
	private String uploadFileName;
	private List<String> list;
	private CusOrderback cusOrderback;
	private ICusOrderbackService cusOrderbackService;
	private SimpleDateFormat sdf;
	private List<CusOrderback> orderList;
	private String cusRowID;
	private File tempimg;
	private File imgwuliu;
	private String imgwuliuFileName;
	private String imgpath;
	private String search;
	
	public CusBackAction() {
		super();
		list = new ArrayList<String>();
		sdf = new SimpleDateFormat("yyyy_MM_dd");
		orderList = new ArrayList<CusOrderback>();
	}
	@Override
	public String execute() throws Exception {
		System.out.println(search);
		//System.out.println("*********************");
		System.out.println(variable);
		//快递单号搜索
		if(search !=null){
			if(!search.equals("")){
				variable = "orderlist";
				orderList.clear();
				orderList = cusOrderbackService.findBySearch(search);
				search = null;
				return "orderlist";
			}
		}
		//采购-->上传Excel页面
		if(variable.equals("purchase")){
			variable = null;
			return "upload";
		}
		if(variable.equals("upload")){
			variable = null;
			//解析上传Excel文件
			InputStream in=null;
			OutputStream out=null;
			try {
				System.out.println(upload);
				String uploadDir=ServletActionContext.getServletContext().getRealPath("/")+"upload";
				System.out.println(uploadFileName);
				if (!(new File(uploadDir).isDirectory())) {
					new File(uploadDir).mkdirs();
					uploadDir=ServletActionContext.getServletContext().getRealPath("upload");
				}
				temp=new File(uploadDir+File.separator+uploadFileName);
				if (!temp.exists()) {
					temp.createNewFile();
				}
				in=new BufferedInputStream(new FileInputStream(upload));
				out=new FileOutputStream(temp);
				byte[] b=new byte[1024];
				int len=0;
				while ((len=in.read(b))!=-1) {
					out.write(b,0,len);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if (out!=null) {
						out.close();
					}
					if (in!=null) {
						in.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ExcelUtil excelUtil=null;
			try {
				excelUtil = new ExcelUtil(new BufferedInputStream(new FileInputStream(temp)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//把解析得到的数据放入list中
			List<String[]> list = excelUtil.getAllData(1);
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			//循环插入对象属性中，并存入数据库
			for(int i = 2;i < list.size();i++){
				CusOrderback cusOrderback = new CusOrderback();
				cusOrderback.setOrderdate(sdf.parse(list.get(i)[0]));
				cusOrderback.setPurid(list.get(i)[1]);
				cusOrderback.setSupplier(list.get(i)[2]);
				cusOrderback.setGoodsname(list.get(i)[3]);
				cusOrderback.setBarcode(list.get(i)[4]);
				cusOrderback.setGoodsid(list.get(i)[5]);
				cusOrderback.setGoodsproperty(list.get(i)[6]);
				cusOrderback.setNum(list.get(i)[7]);
				cusOrderback.setPrice(list.get(i)[8]);
				cusOrderback.setFare(list.get(i)[9]);
				cusOrderback.setTotal(list.get(i)[10]);
				cusOrderback.setRemark1(list.get(i)[11]);
				cusOrderback.setExpress(list.get(i)[12]);
				cusOrderback.setWaybill(list.get(i)[13]);
//				cusOrderback.setArrivalnum(list.get(i)[14]);
//				cusOrderback.setMistake(list.get(i)[15]);
//				cusOrderback.setCondition(list.get(i)[16]);
//				cusOrderback.setArrivaltime(sdf.parse(list.get(i)[17]));
//				cusOrderback.setOpenman(list.get(i)[18]);
//				cusOrderback.setSignman(list.get(i)[19]);
//				cusOrderback.setRemark2(list.get(i)[20]);
				cusOrderbackService.save(cusOrderback);
			}
			return "wait";
		}
		if(variable.equals("orderlist")){
			variable = null;
			orderList = cusOrderbackService.findLogIntact();
			return "orderlist";
		}
		//显示对应id的订单详情
		if(variable.equals("orderdetail")){
			variable=null;
			orderList.clear();
			System.out.println(cusRowID);
			cusOrderback = cusOrderbackService.findById(Integer.parseInt(cusRowID));
			orderList.add(getCusOrderback());
			return "orderdetail";
		}
		//物流-->收货判断商品破损情况并添加信息
		if(variable.equals("inspection")){
			variable=null;
			orderList.clear();
			InputStream in=null;
			OutputStream out=null;
			//上传图片
			if(imgwuliu != null){
				try {
					String uploadDir=ServletActionContext.getServletContext().getRealPath("/")+"uploadimg";
					if (!(new File(uploadDir).isDirectory())) {
						new File(uploadDir).mkdirs();
						uploadDir=ServletActionContext.getServletContext().getRealPath("uploadimg");
					}
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
					
					imgwuliuFileName = sdf.format(new Date())+imgwuliuFileName;
					tempimg=new File(uploadDir+File.separator+imgwuliuFileName);
					if (!tempimg.exists()) {
						tempimg.createNewFile();
					}
					imgpath = "uploadimg/" + imgwuliuFileName;
					in=new BufferedInputStream(new FileInputStream(imgwuliu));
					out=new FileOutputStream(tempimg);
					byte[] b=new byte[1024];
					int len=0;
					while ((len=in.read(b))!=-1) {
						out.write(b,0,len);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						if (out!=null) {
							out.close();
						}
						if (in!=null) {
							in.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				cusOrderback.setImgorder(imgpath);
			}
			cusOrderback.setArrivaltime(new Date());
			cusOrderbackService.update(cusOrderback);
			orderList = cusOrderbackService.findLogIntact();
			imgwuliu = null;
			return "orderlist"; 
		}
		//物流-->操作历史记录，列表
		if(variable.equals("history")){
			variable = null;
			orderList.clear();
			orderList = cusOrderbackService.findLogHistory();
			return "historylist";
		}
		//物流-->操作历史记录，详情
		if(variable.equals("historydetail")){
			variable = null;
			orderList.clear();
			cusOrderback = cusOrderbackService.findById(Integer.parseInt(cusRowID));
			orderList.add(getCusOrderback());
			return "historydetail";
		}
		//物流-->操作历史记录，更新
		if(variable.equals("historyupdate")){
			variable = null;
			orderList.clear();
			InputStream in=null;
			OutputStream out=null;
			//上传图片
			if(imgwuliu != null){
				try {
					String uploadDir=ServletActionContext.getServletContext().getRealPath("/")+"uploadimg";
					if (!(new File(uploadDir).isDirectory())) {
						new File(uploadDir).mkdirs();
						uploadDir=ServletActionContext.getServletContext().getRealPath("uploadimg");
					}
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
					
					imgwuliuFileName = sdf.format(new Date())+imgwuliuFileName;
					tempimg=new File(uploadDir+File.separator+imgwuliuFileName);
					if (!tempimg.exists()) {
						tempimg.createNewFile();
					}
					imgpath = "uploadimg/" + imgwuliuFileName;
					in=new BufferedInputStream(new FileInputStream(imgwuliu));
					out=new FileOutputStream(tempimg);
					byte[] b=new byte[1024];
					int len=0;
					while ((len=in.read(b))!=-1) {
						out.write(b,0,len);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						if (out!=null) {
							out.close();
						}
						if (in!=null) {
							in.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				cusOrderback.setImgorder(imgpath);
			}
			//cusOrderback.setArrivaltime(new Date());
			cusOrderbackService.update(cusOrderback);
			orderList = cusOrderbackService.findLogHistory();
			imgwuliu = null;
			return "historylist";
		}
		//采购-->显示破损商品列表
		if(variable.equals("intact")){
			variable = null;
			orderList.clear();
			orderList = cusOrderbackService.findIntact();
			return "intact";
		}
		//采购-->破损商品详情
		if(variable.equals("intactdetail")){
			variable = null;
			orderList.clear();
			cusOrderback = cusOrderbackService.findById(Integer.parseInt(cusRowID));
			orderList.add(getCusOrderback());
			return "intactdetail";
		}
		//采购-->添加处理意见
		if(variable.equals("purresult")){
			variable = null;
			orderList.clear();
			//System.out.println(cusOrderback.getPurresult());
			cusOrderbackService.update(cusOrderback);
			orderList = cusOrderbackService.findIntact();
			return "intact";
		}
		//物流-->查询采购处理意见
		if(variable.equals("purcomment")){
			variable = null;
			orderList.clear();
			orderList = cusOrderbackService.findPurresult();
			return "purcomment";
		}
		//物流-->确认商品完好
		if(variable.equals("goodsintact")){
			variable = null;
			orderList.clear();
			String openman = cusOrderback.getOpenman();
			String signman = cusOrderback.getSignman();
			cusOrderback = cusOrderbackService.findById(Integer.parseInt(cusRowID));
			cusOrderback.setArrivalnum("1");
			cusOrderback.setMistake("否");
			cusOrderback.setCondition("已收到");
			cusOrderback.setArrivaltime(new Date());
			cusOrderback.setOpenman(openman);
			cusOrderback.setSignman(signman);
			cusOrderback.setIntact("101");
			cusOrderbackService.update(cusOrderback);
			orderList = cusOrderbackService.findLogIntact();
			return "orderlist";
		}

		return SUCCESS;
	}
	
	
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public File getTemp() {
		return temp;
	}
	public void setTemp(File temp) {
		this.temp = temp;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public CusOrderback getCusOrderback() {
		return cusOrderback;
	}
	public void setCusOrderback(CusOrderback cusOrderback) {
		this.cusOrderback = cusOrderback;
	}
	public ICusOrderbackService getCusOrderbackService() {
		return cusOrderbackService;
	}
	public void setCusOrderbackService(ICusOrderbackService cusOrderbackService) {
		this.cusOrderbackService = cusOrderbackService;
	}
	public List<CusOrderback> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<CusOrderback> orderList) {
		this.orderList = orderList;
	}
	public String getCusRowID() {
		return cusRowID;
	}
	public void setCusRowID(String cusRowID) {
		this.cusRowID = cusRowID;
	}
	public File getTempimg() {
		return tempimg;
	}
	public void setTempimg(File tempimg) {
		this.tempimg = tempimg;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public File getImgwuliu() {
		return imgwuliu;
	}
	public void setImgwuliu(File imgwuliu) {
		this.imgwuliu = imgwuliu;
	}
	public String getImgwuliuFileName() {
		return imgwuliuFileName;
	}
	public void setImgwuliuFileName(String imgwuliuFileName) {
		this.imgwuliuFileName = imgwuliuFileName;
	}
	public SimpleDateFormat getSdf() {
		return sdf;
	}
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
}
