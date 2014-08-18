package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ICusCollectDAO;
import com.wantdo.dao.impl.CusCollectDAO;
import com.wantdo.domain.CusCollect;
import com.wantdo.domain.WspShops;
import com.wantdo.service.ICusCollectService;
import com.wantdo.utils.PageBean;
import com.wantdo.utils.PageModel;


public class CusCollectService implements ICusCollectService {
	private ICusCollectDAO cusCollectDAO;
	@Override
	public List findAll() {
		return cusCollectDAO.findAll();
	}
	@Override
	public void save(CusCollect cusCollect) {
		cusCollectDAO.save(cusCollect);
	}
	
	
	
	public ICusCollectDAO getCusCollectDAO() {
		return cusCollectDAO;
	}
	public void setCusCollectDAO(ICusCollectDAO cusCollectDAO) {
		this.cusCollectDAO = cusCollectDAO;
	}
	
	//ͨ��applicationContext.xml�����ļ�ע��CusCollectDAO��ֵ     
		public void setCusCollectDAO(CusCollectDAO cusCollectDAO) {          
			this.cusCollectDAO = cusCollectDAO;      
			}             
		/** *//**       * ��ҳ��ѯ        * @param currentPage ��ǰ�ڼ�ҳ       * @param pageSize ÿҳ��С        * @return ����˷�ҳ��Ϣ(������¼��list)��Bean       */       
		public PageBean queryForPage(int pageSize,int page){          
			final String hql = "from CusCollect";        //��ѯ���          
			int allRow = cusCollectDAO.getAllRowCount(hql);    //�ܼ�¼��           
			int totalPage = PageBean.countTotalPage(pageSize, allRow);    //��ҳ��         
			final int offset = PageBean.countOffset(pageSize, page);    //��ǰҳ��ʼ��¼         
			final int length = pageSize;    //ÿҳ��¼��           
			final int currentPage = PageBean.countCurrentPage(page);  
		 
		    List<WspShops> list = cusCollectDAO.queryForPage(hql,offset, length);        //"һҳ"�ļ�¼                     //�ѷ�ҳ��Ϣ���浽Bean��          
		    PageBean pageBean = new PageBean();          
		    pageBean.setPageSize(pageSize);              
		    pageBean.setCurrentPage(currentPage);          
		    pageBean.setAllRow(allRow);          
		    pageBean.setTotalPage(totalPage);          
		    pageBean.setList(list);         
		    pageBean.init();         
		    return pageBean;      
	    } 

}
