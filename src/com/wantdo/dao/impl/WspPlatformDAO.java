package com.wantdo.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.IWspPlatformDAO;
import com.wantdo.domain.WspPlatform;

/**
 	* A data access object (DAO) providing persistence and search support for WspPlatform entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.wantdo.domain.WspPlatform
  * @author MyEclipse Persistence Tools 
 */
public class WspPlatformDAO extends HibernateDaoSupport implements IWspPlatformDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WspPlatformDAO.class);
		//property constants
	public static final String SYSTEMNAME = "systemname";
	public static final String SYSTEMURL = "systemurl";
	public static final String REMARK = "remark";
	public static final String ISENABLE = "isenable";



	protected void initDao() {
		//do nothing
	}
    
    
	/* (·Ç Javadoc) 
	* <p>Title: save</p> 
	* <p>Description: </p> 
	* @param transientInstance 
	* @see com.wantdo.dao.impl.IWspPlatformDAO#save(com.wantdo.domain.WspPlatform) 
	*/ 
    @Override
	public void save(WspPlatform transientInstance) {
        log.debug("saving WspPlatform instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WspPlatform persistentInstance) {
        log.debug("deleting WspPlatform instance");
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
	* @see com.wantdo.dao.impl.IWspPlatformDAO#findById(java.lang.Integer) 
	*/ 
    @Override
	public WspPlatform findById( java.lang.Integer id) {
        log.debug("getting WspPlatform instance with id: " + id);
        try {
            WspPlatform instance = (WspPlatform) getHibernateTemplate()
                    .get("com.wantdo.domain.WspPlatform", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WspPlatform instance) {
        log.debug("finding WspPlatform instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding WspPlatform instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WspPlatform as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	
	/* (·Ç Javadoc) 
	* <p>Title: findBySystemname</p> 
	* <p>Description: </p> 
	* @param systemname
	* @return 
	* @see com.wantdo.dao.impl.IWspPlatformDAO#findBySystemname(java.lang.Object) 
	*/ 
	@Override
	public List findBySystemname(Object systemname
	) {
		return findByProperty(SYSTEMNAME, systemname
		);
	}
	
	public List findBySystemurl(Object systemurl
	) {
		return findByProperty(SYSTEMURL, systemurl
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	
	public List findByIsenable(Object isenable
	) {
		return findByProperty(ISENABLE, isenable
		);
	}
	

	public List findAll() {
		log.debug("finding all WspPlatform instances");
		try {
			String queryString = "from WspPlatform";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WspPlatform merge(WspPlatform detachedInstance) {
        log.debug("merging WspPlatform instance");
        try {
            WspPlatform result = (WspPlatform) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WspPlatform instance) {
        log.debug("attaching dirty WspPlatform instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WspPlatform instance) {
        log.debug("attaching clean WspPlatform instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IWspPlatformDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IWspPlatformDAO) ctx.getBean("WspPlatformDAO");
	}
}