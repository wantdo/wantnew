package com.wantdo.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.IWspItemspecificationDAO;
import com.wantdo.domain.WspItemspecification;

/**
 * A data access object (DAO) providing persistence and search support for
 * WspItemspecification entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wantdo.domain.WspItemspecification
 * @author MyEclipse Persistence Tools
 */
public class WspItemspecificationDAO extends HibernateDaoSupport implements IWspItemspecificationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(WspItemspecificationDAO.class);
	// property constants
	public static final String ITEMNO = "itemno";
	public static final String SKUNAME = "skuname";
	public static final String ATTRVALID = "attrvalid";
	public static final String BARCODE = "barcode";
	public static final String GOODNO = "goodno";
	public static final String SALEPRICE = "saleprice";
	public static final String SPECIALPRICE = "specialprice";
	public static final String WEIGHT = "weight";
	public static final String LENGTH = "length";
	public static final String WIDTH = "width";
	public static final String HEIGHT = "height";
	public static final String ISUNSALED = "isunsaled";
	public static final String STRVALUES = "strvalues";
	public static final String STRDISPLAY = "strdisplay";
	public static final String PICNAMES = "picnames";
	public static final String SALESCOUNT = "salescount";
	public static final String I6ITEMNO = "i6itemno";
	public static final String DAILYPRICE = "dailyprice";
	public static final String IMAGEURL = "imageurl";

	protected void initDao() {
		// do nothing
	}

	
	/* (·Ç Javadoc) 
	* <p>Title: save</p> 
	* <p>Description: </p> 
	* @param transientInstance 
	* @see com.wantdo.dao.impl.IWspItemspecificationDAO#save(com.wantdo.domain.WspItemspecification) 
	*/ 
	@Override
	public void save(WspItemspecification transientInstance) {
		log.debug("saving WspItemspecification instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(WspItemspecification persistentInstance) {
		log.debug("deleting WspItemspecification instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	
	/* (·Ç Javadoc) 
	* <p>Title: findById</p> 
	* <p>Description: </p> 
	* @param id
	* @return 
	* @see com.wantdo.dao.impl.IWspItemspecificationDAO#findById(java.lang.String) 
	*/ 
	@Override
	public WspItemspecification findById(java.lang.String id) {
		log.debug("getting WspItemspecification instance with id: " + id);
		try {
			WspItemspecification instance = (WspItemspecification) getHibernateTemplate()
					.get("com.wantdo.domain.WspItemspecification", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(WspItemspecification instance) {
		log.debug("finding WspItemspecification instance by example");
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
		log.debug("finding WspItemspecification instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from WspItemspecification as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByItemno(Object itemno) {
		return findByProperty(ITEMNO, itemno);
	}

	public List findBySkuname(Object skuname) {
		return findByProperty(SKUNAME, skuname);
	}

	public List findByAttrvalid(Object attrvalid) {
		return findByProperty(ATTRVALID, attrvalid);
	}

	public List findByBarcode(Object barcode) {
		return findByProperty(BARCODE, barcode);
	}

	public List findByGoodno(Object goodno) {
		return findByProperty(GOODNO, goodno);
	}

	public List findBySaleprice(Object saleprice) {
		return findByProperty(SALEPRICE, saleprice);
	}

	public List findBySpecialprice(Object specialprice) {
		return findByProperty(SPECIALPRICE, specialprice);
	}

	public List findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List findByLength(Object length) {
		return findByProperty(LENGTH, length);
	}

	public List findByWidth(Object width) {
		return findByProperty(WIDTH, width);
	}

	public List findByHeight(Object height) {
		return findByProperty(HEIGHT, height);
	}

	public List findByIsunsaled(Object isunsaled) {
		return findByProperty(ISUNSALED, isunsaled);
	}

	public List findByStrvalues(Object strvalues) {
		return findByProperty(STRVALUES, strvalues);
	}

	public List findByStrdisplay(Object strdisplay) {
		return findByProperty(STRDISPLAY, strdisplay);
	}

	public List findByPicnames(Object picnames) {
		return findByProperty(PICNAMES, picnames);
	}

	public List findBySalescount(Object salescount) {
		return findByProperty(SALESCOUNT, salescount);
	}

	public List findByI6itemno(Object i6itemno) {
		return findByProperty(I6ITEMNO, i6itemno);
	}

	public List findByDailyprice(Object dailyprice) {
		return findByProperty(DAILYPRICE, dailyprice);
	}

	public List findByImageurl(Object imageurl) {
		return findByProperty(IMAGEURL, imageurl);
	}

	public List findAll() {
		log.debug("finding all WspItemspecification instances");
		try {
			String queryString = "from WspItemspecification";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public WspItemspecification merge(WspItemspecification detachedInstance) {
		log.debug("merging WspItemspecification instance");
		try {
			WspItemspecification result = (WspItemspecification) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(WspItemspecification instance) {
		log.debug("attaching dirty WspItemspecification instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WspItemspecification instance) {
		log.debug("attaching clean WspItemspecification instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IWspItemspecificationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IWspItemspecificationDAO) ctx.getBean("WspItemspecificationDAO");
	}
}