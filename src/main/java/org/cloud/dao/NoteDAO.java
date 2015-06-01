package org.cloud.dao;

import java.util.List;

import org.cloud.entity.Note;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Note
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see Note
 * @author MyEclipse Persistence Tools
 */
public class NoteDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NoteDAO.class);
	// property constants
	public static final String CONTENT = "content";

	protected void initDao() {
		// do nothing
	}

	public void save(Note transientInstance) {
		log.debug("saving Note instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Note persistentInstance) {
		log.debug("deleting Note instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Note findById(java.lang.Integer id) {
		log.debug("getting Note instance with id: " + id);
		try {
			Note instance = (Note) getHibernateTemplate().get(
					"org.cloud.entity.Note", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Note> findByExample(Note instance) {
		log.debug("finding Note instance by example");
		try {
			List<Note> results = (List<Note>) getHibernateTemplate()
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
		log.debug("finding Note instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Note as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Note> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all Note instances");
		try {
			String queryString = "from Note";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Note merge(Note detachedInstance) {
		log.debug("merging Note instance");
		try {
			Note result = (Note) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Note instance) {
		log.debug("attaching dirty Note instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Note instance) {
		log.debug("attaching clean Note instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NoteDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NoteDAO) ctx.getBean("NoteDAO");
	}
}