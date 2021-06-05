package net.javacourse.models;
// Generated 4 Jun 2021, 16:20:08 by Hibernate Tools 5.4.30.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import net.javacourse.entities.Sessions;
import net.javacourse.entities.Studies;

/**
 * Home object for domain model class Studies.
 * @see net.javacourse.models.Studies
 * @author Hibernate Tools
 */
public class StudiesModel extends Model {

	public StudiesModel() {
		super();
		this._table = "Studies";
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Studies> getAll() {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		List<Studies> data = null;
		
		String query = "FROM " + this._table;
		try {
			transaction.begin();
			data = this._session.createQuery(query, Studies.class).list();
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
	 * Find by ID
	 * 
	 * @param id
	 * @return
	 */
	public Studies find(Integer id) {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		Studies data = null;
		
		try {
			transaction.begin();
			data = (Studies)this._session.get(Studies.class, id);
			transaction.commit();
		} catch (RuntimeException re) {
			transaction.rollback();
		} finally {
			this._session.close();
		};
		
		return data;
	}
	
	/**
	 * Adding new student
	 * 
	 * @param data
	 * @return
	 */
	public int add(Studies data) {
		Integer id = data.getId();
		Studies exist = this.find(id);
		
		if (exist != null) {
			return (-1);
		};
		
		this.save(data);
		return data.getId();
	}
	
	/**
	 * Update 
	 * 
	 * @param id
	 * @param data
	 * @return
	 */
	public boolean updateById(Integer id, Studies data) {
		Studies exist = this.find(id);
		
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
	public boolean deleteById(Integer id) {
		Studies exist = this.find(id);
		
		if (exist == null) {
			return false;
		};
		
		return this.delete(exist);
	}

//	public void persist(Studies transientInstance) {
//		logger.log(Level.INFO, "persisting Studies instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			logger.log(Level.INFO, "persist successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Studies instance) {
//		logger.log(Level.INFO, "attaching dirty Studies instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Studies instance) {
//		logger.log(Level.INFO, "attaching clean Studies instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Studies persistentInstance) {
//		logger.log(Level.INFO, "deleting Studies instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			logger.log(Level.INFO, "delete successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "delete failed", re);
//			throw re;
//		}
//	}
//
//	public Studies merge(Studies detachedInstance) {
//		logger.log(Level.INFO, "merging Studies instance");
//		try {
//			Studies result = (Studies) sessionFactory.getCurrentSession().merge(detachedInstance);
//			logger.log(Level.INFO, "merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "merge failed", re);
//			throw re;
//		}
//	}
//
//	public Studies findById(java.lang.Integer id) {
//		logger.log(Level.INFO, "getting Studies instance with id: " + id);
//		try {
//			Studies instance = (Studies) sessionFactory.getCurrentSession().get("net.javacourse.models.Studies", id);
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
//	public List findByExample(Studies instance) {
//		logger.log(Level.INFO, "finding Studies instance by example");
//		try {
//			List results = sessionFactory.getCurrentSession().createCriteria("net.javacourse.models.Studies")
//					.add(Example.create(instance)).list();
//			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "find by example failed", re);
//			throw re;
//		}
//	}
}
