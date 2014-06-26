package com.wantdo.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.ICusDescDAO;
import com.wantdo.domain.CusDesc;
import com.wantdo.domain.CusDetail;

/**
 * A data access object (DAO) providing persistence and search support for
 * CusDesc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.domain.CusDesc
 * @author MyEclipse Persistence Tools
 */
public class CusDescDAO extends HibernateDaoSupport implements ICusDescDAO {
	private static final Logger log = LoggerFactory.getLogger(CusDescDAO.class);
	// property constants
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	public void save(CusDesc transientInstance) {
		log.debug("saving CusDesc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CusDesc persistentInstance) {
		log.debug("deleting CusDesc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void update(CusDesc updateInstance) {
        log.debug("updating CusDesc instance");
        try {
            getHibernateTemplate().update(updateInstance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

	
	/* (·Ç Javadoc) 
	* <p>Title: findById</p> 
	* <p>Description: </p> 
	* @param id
	* @return 
	* @see com.wantdo.dao.impl.ICusDescDAO#findById(java.lang.Integer) 
	*/ 
	@Override
	public CusDesc findById(java.lang.Integer id) {
		log.debug("getting CusDesc instance with id: " + id);
		try {
			CusDesc instance = (CusDesc) getHibernateTemplate().get(
					"com.wantdo.domain.CusDesc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CusDesc instance) {
		log.debug("finding CusDesc instance by example");
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
		log.debug("finding CusDesc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CusDesc as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
	/* (·Ç Javadoc) 
	* <p>Title: findByDescription</p> 
	* <p>Description: </p> 
	* @param description
	* @return 
	* @see com.wantdo.dao.impl.ICusDescDAO#findByDescription(java.lang.Object) 
	*/ 
	@Override
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all CusDesc instances");
		try {
			String queryString = "from CusDesc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CusDesc merge(CusDesc detachedInstance) {
		log.debug("merging CusDesc instance");
		try {
			CusDesc result = (CusDesc) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CusDesc instance) {
		log.debug("attaching dirty CusDesc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CusDesc instance) {
		log.debug("attaching clean CusDesc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ICusDescDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ICusDescDAO) ctx.getBean("CusDescDAO");
	}
}