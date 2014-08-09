package com.wantdo.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.ICusOrdermstDAO;
import com.wantdo.domain.CusOrdermst;

/**
 * A data access object (DAO) providing persistence and search support for
 * CusOrdermst entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wantdo.domain.CusOrdermst
 * @author MyEclipse Persistence Tools
 */
public class CusOrdermstDAO extends HibernateDaoSupport implements ICusOrdermstDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CusOrdermstDAO.class);
	// property constants
	public static final String WSPID = "wspid";
	public static final String SENDFLG = "sendflg";
	public static final String ECID = "ecid";
	public static final String SYSNAME = "sysname";
	public static final String SHOPNAME = "shopname";
	public static final String SHOPMANAGER = "shopmanager";
	public static final String ORDERPAYSUM = "orderpaysum";
	public static final String LINKMAN = "linkman";
	public static final String HANDSET = "handset";
	public static final String RECADDR = "recaddr";
	public static final String CUSDESC = "cusdesc";
	public static final String CUSDETAIL = "cusdetail";
	public static final String OPERATEOPINION = "operateopinion";
	public static final String OPERATEMAN = "operateman";
	public static final String OPERATEREMARK = "operateremark";
	public static final String INCOMING_NO = "incomingNo";
	public static final String RELID = "relid";
	public static final String DEALERFLAG = "dealerflag";
	public static final String GOODSENDTYPE = "goodsendtype";
	public static final String ONLINEFLAG = "onlineflag";
	public static final String REFAMOUNT = "refamount";
	public static final String FREIGHT = "freight";
	public static final String PRICEDISPARITY = "pricedisparity";
	public static final String SHOPEMAIL = "shopemail";

	protected void initDao() {
		// do nothing
	}

	public void save(CusOrdermst transientInstance) {
		log.debug("saving CusOrdermst instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CusOrdermst persistentInstance) {
		log.debug("deleting CusOrdermst instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CusOrdermst findById(java.lang.Integer id) {
		log.debug("getting CusOrdermst instance with id: " + id);
		try {
			CusOrdermst instance = (CusOrdermst) getHibernateTemplate().get(
					"com.wantdo.domain.CusOrdermst", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CusOrdermst instance) {
		log.debug("finding CusOrdermst instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CusOrdermst instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CusOrdermst as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByWspid(Object wspid) {
		return findByProperty(WSPID, wspid);
	}

	public List findBySendflg(Object sendflg) {
		return findByProperty(SENDFLG, sendflg);
	}

	public List findByEcid(Object ecid) {
		return findByProperty(ECID, ecid);
	}

	public List findBySysname(Object sysname) {
		return findByProperty(SYSNAME, sysname);
	}

	public List findByShopname(Object shopname) {
		return findByProperty(SHOPNAME, shopname);
	}

	public List findByShopmanager(Object shopmanager) {
		return findByProperty(SHOPMANAGER, shopmanager);
	}

	public List findByOrderpaysum(Object orderpaysum) {
		return findByProperty(ORDERPAYSUM, orderpaysum);
	}

	public List findByLinkman(Object linkman) {
		return findByProperty(LINKMAN, linkman);
	}

	public List findByHandset(Object handset) {
		return findByProperty(HANDSET, handset);
	}

	public List findByRecaddr(Object recaddr) {
		return findByProperty(RECADDR, recaddr);
	}

	public List findByCusdesc(Object cusdesc) {
		return findByProperty(CUSDESC, cusdesc);
	}

	public List findByCusdetail(Object cusdetail) {
		return findByProperty(CUSDETAIL, cusdetail);
	}

	public List findByOperateopinion(Object operateopinion) {
		return findByProperty(OPERATEOPINION, operateopinion);
	}

	public List findByOperateman(Object operateman) {
		return findByProperty(OPERATEMAN, operateman);
	}

	public List findByOperateremark(Object operateremark) {
		return findByProperty(OPERATEREMARK, operateremark);
	}

	public List findByIncomingNo(Object incomingNo) {
		return findByProperty(INCOMING_NO, incomingNo);
	}

	public List findByRelid(Object relid) {
		return findByProperty(RELID, relid);
	}

	public List findByDealerflag(Object dealerflag) {
		return findByProperty(DEALERFLAG, dealerflag);
	}

	public List findByGoodsendtype(Object goodsendtype) {
		return findByProperty(GOODSENDTYPE, goodsendtype);
	}

	public List findByOnlineflag(Object onlineflag) {
		return findByProperty(ONLINEFLAG, onlineflag);
	}

	public List findByRefamount(Object refamount) {
		return findByProperty(REFAMOUNT, refamount);
	}

	public List findByFreight(Object freight) {
		return findByProperty(FREIGHT, freight);
	}

	public List findByPricedisparity(Object pricedisparity) {
		return findByProperty(PRICEDISPARITY, pricedisparity);
	}

	public List findByShopemail(Object shopemail) {
		return findByProperty(SHOPEMAIL, shopemail);
	}

	public List findAll() {
		log.debug("finding all CusOrdermst instances");
		try {
			String queryString = "from CusOrdermst";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CusOrdermst merge(CusOrdermst detachedInstance) {
		log.debug("merging CusOrdermst instance");
		try {
			CusOrdermst result = (CusOrdermst) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CusOrdermst instance) {
		log.debug("attaching dirty CusOrdermst instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CusOrdermst instance) {
		log.debug("attaching clean CusOrdermst instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CusOrdermstDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CusOrdermstDAO) ctx.getBean("CusOrdermstDAO");
	}
	
	public List findByOpDate(String startTime,String endTime) throws Exception{
		log.debug("finding CusOrdermst instance with startTime: " + startTime+" and endTime:"+endTime);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String queryString="from CusOrdermst as model where model.operatedate " +
					"between ? and ? order by model.operatedate asc";
			return getHibernateTemplate().find(queryString, new Date[]{sdf.parse(startTime),sdf.parse(endTime)});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("find by startTime and endTime failed", re);
			throw re;
		}
	}
	
	public List findAllByOpDate(String startTime,String endTime) throws Exception{
		log.debug("finding all instance with startTime: " + startTime+" and endTime:"+endTime);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String queryString="from CusOrdermst as mst,CusOrderdtl as dtl,CusShops shops where mst.operatedate " +
					"between ? and ? and mst.cusid=dtl.cusid and mst.wspshopid=shops.wspshopid order by mst.operatedate asc";
			return getHibernateTemplate().find(queryString, new Date[]{sdf.parse(startTime),sdf.parse(endTime)});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("find by startTime and endTime failed", re);
			throw re;
		}
	}
	public List findShopname() {
		log.debug("finding all CusOrdermst instances");
		try {
			String queryString = "from CusOrdermst as mst,CusShops as shop where mst.wspshopid=shop.wspshopid";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}