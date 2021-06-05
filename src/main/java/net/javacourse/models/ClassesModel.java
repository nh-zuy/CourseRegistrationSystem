package net.javacourse.models;
// Generated 31 May 2021, 19:58:32 by Hibernate Tools 5.4.30.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import net.javacourse.entities.Classes;
import net.javacourse.entities.Semesters;

/**
 * Home object for domain model class Classes.
 * @see net.javacourse.models.StudentList
 * @author Hibernate Tools
 */
public class ClassesModel extends Model {

	public ClassesModel() {
		super();
		this._table = "Classes";
	}
	
	/**
	 * Get all classes
	 * 
	 * @return
	 */
	public List<Classes> getAll() {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		List<Classes> data = null;
		
		String query = "FROM " + this._table;
		try {
			transaction.begin();
			data = this._session.createQuery(query, Classes.class).list();
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
	 * Find class by ID
	 * 
	 * @param id
	 * @return
	 */
	public Classes find(Integer id) {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		Classes data = null;
		
		try {
			transaction.begin();
			data = (Classes)this._session.get(Classes.class, id);
			transaction.commit();
		} catch (RuntimeException re) {
			transaction.rollback();
			re.printStackTrace();
		} finally {
			this._session.close();
		};
		
		return data;
	}
	
	/**
	 * Add new class
	 * 
	 * @param data
	 * @return
	 */
	public int add(Classes data) {
//		Integer id = data.getClassId();
//		Classes exist = this.find(id);
//		
//		if (exist != null) {
//			return (-1);
//		};
		
		this.save(data);
		return data.getClassId();
	}
	
	/**
	 * Update class by ID
	 * 
	 * @param id
	 * @param data
	 * @return
	 */
	public boolean updateById(Integer id, Classes data) {
		Classes exist = this.find(id);
		
		if (exist == null) {
			return false;
		};
		
		return this.update(data);
	}
	
	/**
	 * Delete class by ID
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id) {
		Classes exist = this.find(id);
		
		if (exist == null) {
			return false;
		};
		
		return this.delete(exist);
	}

//	public void persist(Classes transientInstance) {
//		logger.log(Level.INFO, "persisting Classes instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			logger.log(Level.INFO, "persist successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Classes instance) {
//		logger.log(Level.INFO, "attaching dirty Classes instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Classes instance) {
//		logger.log(Level.INFO, "attaching clean Classes instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Classes persistentInstance) {
//		logger.log(Level.INFO, "deleting Classes instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			logger.log(Level.INFO, "delete successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "delete failed", re);
//			throw re;
//		}
//	}
//
//	public Classes merge(Classes detachedInstance) {
//		logger.log(Level.INFO, "merging Classes instance");
//		try {
//			Classes result = (Classes) sessionFactory.getCurrentSession().merge(detachedInstance);
//			logger.log(Level.INFO, "merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "merge failed", re);
//			throw re;
//		}
//	}
//
//	public Classes findById(java.lang.Integer id) {
//		logger.log(Level.INFO, "getting Classes instance with id: " + id);
//		try {
//			Classes instance = (Classes) sessionFactory.getCurrentSession().get("net.javacourse.models.Classes", id);
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
//	public List findByExample(Classes instance) {
//		logger.log(Level.INFO, "finding Classes instance by example");
//		try {
//			List results = sessionFactory.getCurrentSession().createCriteria("net.javacourse.models.Classes")
//					.add(Example.create(instance)).list();
//			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "find by example failed", re);
//			throw re;
//		}
//	}
}
