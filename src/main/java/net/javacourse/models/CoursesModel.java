package net.javacourse.models;
// Generated 28 May 2021, 22:10:28 by Hibernate Tools 5.4.30.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import net.javacourse.entities.Courses;

/**
 * Home object for domain model class Courses.
 * @see net.javacourse.models.Courses
 * @author Hibernate Tools
 */
public class CoursesModel {

	private static final Logger logger = Logger.getLogger(CoursesModel.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Courses transientInstance) {
		logger.log(Level.INFO, "persisting Courses instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Courses instance) {
		logger.log(Level.INFO, "attaching dirty Courses instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(Courses instance) {
		logger.log(Level.INFO, "attaching clean Courses instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(Courses persistentInstance) {
		logger.log(Level.INFO, "deleting Courses instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public Courses merge(Courses detachedInstance) {
		logger.log(Level.INFO, "merging Courses instance");
		try {
			Courses result = (Courses) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public Courses findById(java.lang.String id) {
		logger.log(Level.INFO, "getting Courses instance with id: " + id);
		try {
			Courses instance = (Courses) sessionFactory.getCurrentSession().get("net.javacourse.models.Courses", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(Courses instance) {
		logger.log(Level.INFO, "finding Courses instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("net.javacourse.models.Courses")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
