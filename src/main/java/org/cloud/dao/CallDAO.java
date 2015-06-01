package org.cloud.dao;

import java.util.List;

import org.cloud.entity.Call;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Call
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see Call
 * @author MyEclipse Persistence Tools
 */
public class CallDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CallDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String NAME = "name";
	public static final String PHONE = "phone";
	public static final String DURATION = "duration";

	protected void initDao() {
		// do nothing
	}

	public void save(Call transientInstance) {
		log.debug("saving Call instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Call persistentInstance) {
		log.debug("deleting Call instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Call findById(java.lang.Integer id) {
		log.debug("getting Call instance with id: " + id);
		try {
			Call instance = (Call) getHibernateTemplate().get(
					"org.cloud.entity.Call", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Call> findByExample(Call instance) {
		log.debug("finding Call instance by example");
		try {
			List<Call> results = (List<Call>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Call instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Call as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Call> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Call> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Call> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<Call> findByDuration(Object duration) {
		return findByProperty(DURATION, duration);
	}

	public List findAll() {
		log.debug("finding all Call instances");
		try {
			String queryString = "from Call";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Call merge(Call detachedInstance) {
		log.debug("merging Call instance");
		try {
			Call result = (Call) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Call instance) {
		log.debug("attaching dirty Call instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Call instance) {
		log.debug("attaching clean Call instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CallDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CallDAO) ctx.getBean("CallDAO");
	}
}