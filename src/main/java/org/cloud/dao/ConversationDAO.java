package org.cloud.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Conversation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cloud.dao.Conversation
 * @author MyEclipse Persistence Tools
 */
public class ConversationDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ConversationDAO.class);
	// property constants
	public static final String COUNT = "count";
	public static final String _UNAME = "UName";

	protected void initDao() {
		// do nothing
	}

	public void save(Conversation transientInstance) {
		log.debug("saving Conversation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Conversation persistentInstance) {
		log.debug("deleting Conversation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Conversation findById(java.lang.Integer id) {
		log.debug("getting Conversation instance with id: " + id);
		try {
			Conversation instance = (Conversation) getHibernateTemplate().get(
					"org.cloud.dao.Conversation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Conversation> findByExample(Conversation instance) {
		log.debug("finding Conversation instance by example");
		try {
			List<Conversation> results = (List<Conversation>) getHibernateTemplate()
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
		log.debug("finding Conversation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Conversation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Conversation> findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public List<Conversation> findByUName(Object UName) {
		return findByProperty(_UNAME, UName);
	}

	public List findAll() {
		log.debug("finding all Conversation instances");
		try {
			String queryString = "from Conversation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Conversation merge(Conversation detachedInstance) {
		log.debug("merging Conversation instance");
		try {
			Conversation result = (Conversation) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Conversation instance) {
		log.debug("attaching dirty Conversation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Conversation instance) {
		log.debug("attaching clean Conversation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ConversationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ConversationDAO) ctx.getBean("ConversationDAO");
	}
}