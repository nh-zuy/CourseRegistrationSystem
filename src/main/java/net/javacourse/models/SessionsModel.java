package net.javacourse.models;
// Generated 3 Jun 2021, 19:12:34 by Hibernate Tools 5.4.30.Final

import java.util.List;
import org.hibernate.Transaction;
import net.javacourse.entities.Sessions;

/**
 * Home object for domain model class Sessions.
 * @see net.javacourse.models.Sessions
 * @author Hibernate Tools
 */
public class SessionsModel extends Model {

	public SessionsModel() {
		super();
		this._table = "Sessions";
	}

	/**
	 * 
	 * @return
	 */
	public List<Sessions> getAll() {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		List<Sessions> data = null;
		
		String query = "FROM " + this._table;
		try {
			transaction.begin();
			data = this._session.createQuery(query, Sessions.class).list();
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
	public Sessions find(Integer id) {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		Sessions data = null;
		
		try {
			transaction.begin();
			data = (Sessions)this._session.get(Sessions.class, id);
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
	public int add(Sessions data) {
		Integer id = data.getId();
		Sessions exist = this.find(id);
		
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
	public boolean updateById(Integer id, Sessions data) {
		Sessions exist = this.find(id);
		
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
		Sessions exist = this.find(id);
		
		if (exist == null) {
			return false;
		};
		
		return this.delete(exist);
	}

//	public void persist(Sessions transientInstance) {
//		logger.log(Level.INFO, "persisting Sessions instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			logger.log(Level.INFO, "persist successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Sessions instance) {
//		logger.log(Level.INFO, "attaching dirty Sessions instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Sessions instance) {
//		logger.log(Level.INFO, "attaching clean Sessions instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Sessions persistentInstance) {
//		logger.log(Level.INFO, "deleting Sessions instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			logger.log(Level.INFO, "delete successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "delete failed", re);
//			throw re;
//		}
//	}
//
//	public Sessions merge(Sessions detachedInstance) {
//		logger.log(Level.INFO, "merging Sessions instance");
//		try {
//			Sessions result = (Sessions) sessionFactory.getCurrentSession().merge(detachedInstance);
//			logger.log(Level.INFO, "merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "merge failed", re);
//			throw re;
//		}
//	}
//
//	public Sessions findById(java.lang.Integer id) {
//		logger.log(Level.INFO, "getting Sessions instance with id: " + id);
//		try {
//			Sessions instance = (Sessions) sessionFactory.getCurrentSession().get("net.javacourse.models.Sessions", id);
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
//	public List findByExample(Sessions instance) {
//		logger.log(Level.INFO, "finding Sessions instance by example");
//		try {
//			List results = sessionFactory.getCurrentSession().createCriteria("net.javacourse.models.Sessions")
//					.add(Example.create(instance)).list();
//			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "find by example failed", re);
//			throw re;
//		}
//	}
}
