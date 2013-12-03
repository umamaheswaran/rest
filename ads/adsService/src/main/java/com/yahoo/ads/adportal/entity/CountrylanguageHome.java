package com.yahoo.ads.adportal.entity;

// Generated Apr 12, 2012 4:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Countrylanguage.
 * @see com.yahoo.ads.adportal.entity.Countrylanguage
 * @author Hibernate Tools
 */
public class CountrylanguageHome {

	private static final Log log = LogFactory.getLog(CountrylanguageHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Countrylanguage transientInstance) {
		log.debug("persisting Countrylanguage instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Countrylanguage instance) {
		log.debug("attaching dirty Countrylanguage instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Countrylanguage instance) {
		log.debug("attaching clean Countrylanguage instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Countrylanguage persistentInstance) {
		log.debug("deleting Countrylanguage instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Countrylanguage merge(Countrylanguage detachedInstance) {
		log.debug("merging Countrylanguage instance");
		try {
			Countrylanguage result = (Countrylanguage) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Countrylanguage findById(
			com.yahoo.ads.adportal.entity.CountrylanguageId id) {
		log.debug("getting Countrylanguage instance with id: " + id);
		try {
			Countrylanguage instance = (Countrylanguage) sessionFactory
					.getCurrentSession()
					.get("com.yahoo.ads.adportal.entity.Countrylanguage", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Countrylanguage> findByExample(Countrylanguage instance) {
		log.debug("finding Countrylanguage instance by example");
		try {
			List<Countrylanguage> results = (List<Countrylanguage>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.yahoo.ads.adportal.entity.Countrylanguage")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
