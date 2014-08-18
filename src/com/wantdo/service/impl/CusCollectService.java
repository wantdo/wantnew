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
	
	//通过applicationContext.xml配置文件注入CusCollectDAO的值     
		public void setCusCollectDAO(CusCollectDAO cusCollectDAO) {          
			this.cusCollectDAO = cusCollectDAO;      
			}             
		/** *//**       * 分页查询        * @param currentPage 当前第几页       * @param pageSize 每页大小        * @return 封闭了分页信息(包括记录集list)的Bean       */       
		public PageBean queryForPage(int pageSize,int page){          
			final String hql = "from CusCollect";        //查询语句          
			int allRow = cusCollectDAO.getAllRowCount(hql);    //总记录数           
			int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数         
			final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录         
			final int length = pageSize;    //每页记录数           
			final int currentPage = PageBean.countCurrentPage(page);  
		 
		    List<WspShops> list = cusCollectDAO.queryForPage(hql,offset, length);        //"一页"的记录                     //把分页信息保存到Bean中          
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
