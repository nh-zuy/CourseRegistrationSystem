package net.javacourse.models;
// Generated 28 May 2021, 22:10:28 by Hibernate Tools 5.4.30.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import net.javacourse.entities.Students;

/**
 * Home object for domain model class Students.
 * @see net.javacourse.models.Students
 * @author Hibernate Tools
 */
public class StudentsModel extends Model {

	private static final Logger logger = Logger.getLogger(StudentsModel.class.getName());

	/**
	 * 
	 */
	public StudentsModel() {
		super();
		this._table = "Students";
	}

	/**
	 * 
	 * @return
	 */
	public List<Students> getAll() {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		List<Students> data = null;
		
		String query = "FROM " + this._table;
		try {
			transaction.begin();
			data = this._session.createQuery(query, Students.class).list();
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		} finally {
			this._session.close();
		};
		
		return data;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Students get(String id) {
		Students data = (Students)this.findById(id);
		return data;
	}
	
	/**
	 * Adding new student
	 * 
	 * @param data
	 * @return
	 */
	public boolean add(Students data) {
		String id = data.getStudentId();
		Students exist = this.get(id);
		
		if (exist != null) {
			return false;
		};
		
		return this.save(data);
	}
	
	/**
	 * Update 
	 * 
	 * @param id
	 * @param data
	 * @return
	 */
	public boolean updateById(String id, Students data) {
		Students exist = this.get(id);
		
		if (exist == null) {
			return false;
		};
		
		return this.update(data);
	}
	
	/**
	 * Delete by ID
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(String id) {
		Students exist = this.get(id);
		
		if (exist == null) {
			return false;
		};
		
		return this.delete(exist);
	}
	
//	public void persist(Students transientInstance) {
//		logger.log(Level.INFO, "persisting Students instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			logger.log(Level.INFO, "persist successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Students instance) {
//		logger.log(Level.INFO, "attaching dirty Students instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Students instance) {
//		logger.log(Level.INFO, "attaching clean Students instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Students persistentInstance) {
//		logger.log(Level.INFO, "deleting Students instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			logger.log(Level.INFO, "delete successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "delete failed", re);
//			throw re;
//		}
//	}
//
//	public Students merge(Students detachedInstance) {
//		logger.log(Level.INFO, "merging Students instance");
//		try {
//			Students result = (Students) sessionFactory.getCurrentSession().merge(detachedInstance);
//			logger.log(Level.INFO, "merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "merge failed", re);
//			throw re;
//		}
//	}
//
//	public Students findById(java.lang.String id) {
//		logger.log(Level.INFO, "getting Students instance with id: " + id);
//		try {
//			Students instance = (Students) sessionFactory.getCurrentSession().get("net.javacourse.models.Students", id);
//			if (instance == null) {
//				logger.log(Level.INFO, "get successful, no instance found");
//			} else {
//				logger.log(Level.INFO, "get successful, instance found");
//			}
//			return instance;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(Students instance) {
//		logger.log(Level.INFO, "finding Students instance by example");
//		try {
//			List results = sessionFactory.getCurrentSession().createCriteria("net.javacourse.models.Students")
//					.add(Example.create(instance)).list();
//			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "find by example failed", re);
//			throw re;
//		}
//	}
}
