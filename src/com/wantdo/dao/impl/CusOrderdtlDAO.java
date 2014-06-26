package com.wantdo.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.ICusOrderdtlDAO;
import com.wantdo.domain.CusOrderdtl;

/**
 * A data access object (DAO) providing persistence and search support for
 * CusOrderdtl entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wantdo.domain.CusOrderdtl
 * @author MyEclipse Persistence Tools
 */
public class CusOrderdtlDAO extends HibernateDaoSupport implements ICusOrderdtlDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CusOrderdtlDAO.class);
	// property constants
	public static final String CUSID = "cusid";
	public static final String PRONAME = "proname";
	public static final String PROSPECIFICATION = "prospecification";
	public static final String PROQTY = "proqty";
	public static final String ITEMNO = "itemno";

	protected void initDao() {
		// do nothing
	}

	public void save(CusOrderdtl transientInstance) {
		log.debug("saving CusOrderdtl instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CusOrderdtl persistentInstance) {
		log.debug("deleting CusOrderdtl instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CusOrderdtl findById(java.lang.Integer id) {
		log.debug("getting CusOrderdtl instance with id: " + id);
		try {
			CusOrderdtl instance = (CusOrderdtl) getHibernateTemplate().get(
					"com.wantdo.domain.CusOrderdtl", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CusOrderdtl instance) {
		log.debug("finding CusOrderdtl instance by example");
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
		log.debug("finding CusOrderdtl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CusOrderdtl as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCusid(Object cusid) {
		return findByProperty(CUSID, cusid);
	}

	public List findByProname(Object proname) {
		return findByProperty(PRONAME, proname);
	}

	public List findByProspecification(Object prospecification) {
		return findByProperty(PROSPECIFICATION, prospecification);
	}

	public List findByProqty(Object proqty) {
		return findByProperty(PROQTY, proqty);
	}

	public List findByItemno(Object itemno) {
		return findByProperty(ITEMNO, itemno);
	}

	public List findAll() {
		log.debug("finding all CusOrderdtl instances");
		try {
			String queryString = "from CusOrderdtl";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CusOrderdtl merge(CusOrderdtl detachedInstance) {
		log.debug("merging CusOrderdtl instance");
		try {
			CusOrderdtl result = (CusOrderdtl) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CusOrderdtl instance) {
		log.debug("attaching dirty CusOrderdtl instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CusOrderdtl instance) {
		log.debug("attaching clean CusOrderdtl instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CusOrderdtlDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CusOrderdtlDAO) ctx.getBean("CusOrderdtlDAO");
	}
}