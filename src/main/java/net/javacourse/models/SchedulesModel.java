package net.javacourse.models;
// Generated 31 May 2021, 19:58:32 by Hibernate Tools 5.4.30.Final

import java.util.List;
import org.hibernate.Transaction;
import net.javacourse.entities.Schedules;


/**
 * Home object for domain model class Schedules.
 * @see net.javacourse.models.Schedules
 * @author Hibernate Tools
 */
public class SchedulesModel extends Model {

	public SchedulesModel() {
		super();
		this._table = "Schedules";
	}

	/**
	 * 
	 * @return
	 */
	public List<Schedules> getAll() {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		List<Schedules> data = null;
		
		String query = "FROM " + this._table;
		try {
			transaction.begin();
			data = this._session.createQuery(query, Schedules.class).list();
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
	public Schedules find(Integer id) {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		Schedules data = null;
		
		try {
			transaction.begin();
			data = (Schedules)this._session.get(Schedules.class, id);
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
	public int add(Schedules data) {
		Integer id = data.getId();
		Schedules exist = this.find(id);
		
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
	public boolean updateById(Integer id, Schedules data) {
		Schedules exist = this.find(id);
		
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
		Schedules exist = this.find(id);
		
		if (exist == null) {
			return false;
		};
		
		return this.delete(exist);
	}

//	public void persist(Schedules transientInstance) {
//		logger.log(Level.INFO, "persisting Schedules instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			logger.log(Level.INFO, "persist successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Schedules instance) {
//		logger.log(Level.INFO, "attaching dirty Schedules instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Schedules instance) {
//		logger.log(Level.INFO, "attaching clean Schedules instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Schedules persistentInstance) {
//		logger.log(Level.INFO, "deleting Schedules instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			logger.log(Level.INFO, "delete successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "delete failed", re);
//			throw re;
//		}
//	}
//
//	public Schedules merge(Schedules detachedInstance) {
//		logger.log(Level.INFO, "merging Schedules instance");
//		try {
//			Schedules result = (Schedules) sessionFactory.getCurrentSession().merge(detachedInstance);
//			logger.log(Level.INFO, "merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "merge failed", re);
//			throw re;
//		}
//	}
//
//	public Schedules findById(java.lang.Integer id) {
//		logger.log(Level.INFO, "getting Schedules instance with id: " + id);
//		try {
//			Schedules instance = (Schedules) sessionFactory.getCurrentSession().get("net.javacourse.models.Schedules",
//					id);
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
//	public List findByExample(Schedules instance) {
//		logger.log(Level.INFO, "finding Schedules instance by example");
//		try {
//			List results = sessionFactory.getCurrentSession().createCriteria("net.javacourse.models.Schedules")
//					.add(Example.create(instance)).list();
//			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "find by example failed", re);
//			throw re;
//		}
//	}
}
