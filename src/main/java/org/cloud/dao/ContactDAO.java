package org.cloud.dao;

import java.util.List;

import org.cloud.entity.Contact;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Contact entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 *
 * @author MyEclipse Persistence Tools
 * @see Contact
 */
public class ContactDAO extends HibernateDaoSupport {
    private static final Logger log = LoggerFactory.getLogger(ContactDAO.class);
    // property constants
    public static final String NAME = "name";
    public static final String TEL = "tel";
    public static final String MOBILE = "mobile";
    public static final String MAIL = "mail";
    public static final String DEL = "del";

    protected void initDao() {
        // do nothing
    }

    public void save(Contact transientInstance) {
        log.debug("saving Contact instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Contact persistentInstance) {
        log.debug("deleting Contact instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Contact findById(java.lang.Integer id) {
        log.debug("getting Contact instance with id: " + id);
        try {
            Contact instance = (Contact) getHibernateTemplate().get(
                    "org.cloud.entity.Contact", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<Contact> findByExample(Contact instance) {
        log.debug("finding Contact instance by example");
        try {
            List<Contact> results = (List<Contact>) getHibernateTemplate()
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
        log.debug("finding Contact instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Contact as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<Contact> findByName(Object name) {
        return findByProperty(NAME, name);
    }

    public List<Contact> findByTel(Object tel) {
        return findByProperty(TEL, tel);
    }

    public List<Contact> findByMobile(Object mobile) {
        return findByProperty(MOBILE, mobile);
    }

    public List<Contact> findByMail(Object mail) {
        return findByProperty(MAIL, mail);
    }

    public List<Contact> findByDel(Object del) {
        return findByProperty(DEL, del);
    }

    public List findAll() {
        log.debug("finding all Contact instances");
        try {
            String queryString = "from Contact";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Contact merge(Contact detachedInstance) {
        log.debug("merging Contact instance");
        try {
            Contact result = (Contact) getHibernateTemplate().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Contact instance) {
        log.debug("attaching dirty Contact instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Contact instance) {
        log.debug("attaching clean Contact instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static ContactDAO getFromApplicationContext(ApplicationContext ctx) {
        return (ContactDAO) ctx.getBean("ContactDAO");
    }
}