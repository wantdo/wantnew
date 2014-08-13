package com.wantdo.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.ICusLogisticsDAO;
import com.wantdo.domain.CusLogistics;

/**
 * A data access object (DAO) providing persistence and search support for
 * CusLogistics entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wantdo.domain.CusLogistics
 * @author MyEclipse Persistence Tools
 */
public class CusLogisticsDAO extends HibernateDaoSupport implements ICusLogisticsDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CusLogisticsDAO.class);
	// property constants
	public static final String WAYBILL = "waybill";
	public static final String LINKMAN = "linkman";
	public static final String HANDSET = "handset";
	public static final String RECADDR = "recaddr";
	public static final String ECID = "ecid";
	public static final String SYSNAME = "sysname";
	public static final String SHOPNAME = "shopname";
	public static final String CUSDESC = "cusdesc";
	public static final String CUSDETAIL = "cusdetail";
	public static final String OPERATEOPINION = "operateopinion";
	public static final String OPERATEMAN = "operateman";
	public static final String OPERATEREMARK = "operateremark";
	public static final String RELID = "relid";
	public static final String GOODSENDTYPE = "goodsendtype";

	protected void initDao() {
		// do nothing
	}

	public void save(CusLogistics transientInstance) {
		log.debug("saving CusLogistics instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CusLogistics persistentInstance) {
		log.debug("deleting CusLogistics instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void update(CusLogistics updateInstance) {
        log.debug("updating CusLogistics instance");
        try {
            getHibernateTemplate().update(updateInstance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

	public CusLogistics findById(java.lang.Integer id) {
		log.debug("getting CusLogistics instance with id: " + id);
		try {
			CusLogistics instance = (CusLogistics) getHibernateTemplate().get(
					"com.wantdo.domain.CusLogistics", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CusLogistics instance) {
		log.debug("finding CusLogistics instance by example");
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
		log.debug("finding CusLogistics instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CusLogistics as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByWaybill(Object waybill) {
		return findByProperty(WAYBILL, waybill);
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

	public List findByEcid(Object ecid) {
		return findByProperty(ECID, ecid);
	}

	public List findBySysname(Object sysname) {
		return findByProperty(SYSNAME, sysname);
	}

	public List findByShopname(Object shopname) {
		return findByProperty(SHOPNAME, shopname);
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

	public List findByRelid(Object relid) {
		return findByProperty(RELID, relid);
	}

	public List findByGoodsendtype(Object goodsendtype) {
		return findByProperty(GOODSENDTYPE, goodsendtype);
	}

	public List findAll() {
		log.debug("finding all CusLogistics instances");
		try {
			String queryString = "from CusLogistics";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CusLogistics merge(CusLogistics detachedInstance) {
		log.debug("merging CusLogistics instance");
		try {
			CusLogistics result = (CusLogistics) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CusLogistics instance) {
		log.debug("attaching dirty CusLogistics instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CusLogistics instance) {
		log.debug("attaching clean CusLogistics instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CusLogisticsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CusLogisticsDAO) ctx.getBean("CusLogisticsDAO");
	}
}