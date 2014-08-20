package com.wantdo.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.domain.CusOrderback;
import com.wantdo.dao.ICusOrderbackDAO;


/**
 * A data access object (DAO) providing persistence and search support for
 * CusOrderback entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wantdo.domain.CusOrderback
 * @author MyEclipse Persistence Tools
 */
public class CusOrderbackDAO extends HibernateDaoSupport implements ICusOrderbackDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CusOrderbackDAO.class);
	// property constants
	public static final String PURID = "purid";
	public static final String SUPPLIER = "supplier";
	public static final String GOODSNAME = "goodsname";
	public static final String BARCODE = "barcode";
	public static final String GOODSID = "goodsid";
	public static final String GOODSPROPERTY = "goodsproperty";
	public static final String NUM = "num";
	public static final String PRICE = "price";
	public static final String FARE = "fare";
	public static final String TOTAL = "total";
	public static final String REMARK1 = "remark1";
	public static final String EXPRESS = "express";
	public static final String WAYBILL = "waybill";
	public static final String ARRIVALNUM = "arrivalnum";
	public static final String MISTAKE = "mistake";
	public static final String CONDITION = "condition";
	public static final String OPENMAN = "openman";
	public static final String SIGNMAN = "signman";
	public static final String REMARK2 = "remark2";

	protected void initDao() {
		// do nothing
	}

	public void save(CusOrderback transientInstance) {
		log.debug("saving CusOrderback instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CusOrderback persistentInstance) {
		log.debug("deleting CusOrderback instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CusOrderback findById(java.lang.Integer id) {
		log.debug("getting CusOrderback instance with id: " + id);
		try {
			CusOrderback instance = (CusOrderback) getHibernateTemplate().get(
					"com.wantdo.domain.CusOrderback", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CusOrderback instance) {
		log.debug("finding CusOrderback instance by example");
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
		log.debug("finding CusOrderback instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CusOrderback as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPurid(Object purid) {
		return findByProperty(PURID, purid);
	}

	public List findBySupplier(Object supplier) {
		return findByProperty(SUPPLIER, supplier);
	}

	public List findByGoodsname(Object goodsname) {
		return findByProperty(GOODSNAME, goodsname);
	}

	public List findByBarcode(Object barcode) {
		return findByProperty(BARCODE, barcode);
	}

	public List findByGoodsid(Object goodsid) {
		return findByProperty(GOODSID, goodsid);
	}

	public List findByGoodsproperty(Object goodsproperty) {
		return findByProperty(GOODSPROPERTY, goodsproperty);
	}

	public List findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByFare(Object fare) {
		return findByProperty(FARE, fare);
	}

	public List findByTotal(Object total) {
		return findByProperty(TOTAL, total);
	}

	public List findByRemark1(Object remark1) {
		return findByProperty(REMARK1, remark1);
	}

	public List findByExpress(Object express) {
		return findByProperty(EXPRESS, express);
	}

	public List findByWaybill(Object waybill) {
		return findByProperty(WAYBILL, waybill);
	}

	public List findByArrivalnum(Object arrivalnum) {
		return findByProperty(ARRIVALNUM, arrivalnum);
	}

	public List findByMistake(Object mistake) {
		return findByProperty(MISTAKE, mistake);
	}

	public List findByCondition(Object condition) {
		return findByProperty(CONDITION, condition);
	}

	public List findByOpenman(Object openman) {
		return findByProperty(OPENMAN, openman);
	}

	public List findBySignman(Object signman) {
		return findByProperty(SIGNMAN, signman);
	}

	public List findByRemark2(Object remark2) {
		return findByProperty(REMARK2, remark2);
	}

	public List findAll() {
		log.debug("finding all CusOrderback instances");
		try {
			String queryString = "from CusOrderback";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CusOrderback merge(CusOrderback detachedInstance) {
		log.debug("merging CusOrderback instance");
		try {
			CusOrderback result = (CusOrderback) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CusOrderback instance) {
		log.debug("attaching dirty CusOrderback instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CusOrderback instance) {
		log.debug("attaching clean CusOrderback instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CusOrderbackDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CusOrderbackDAO) ctx.getBean("CusOrderbackDAO");
	}
}