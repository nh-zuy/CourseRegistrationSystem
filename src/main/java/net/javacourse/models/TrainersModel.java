package net.javacourse.models;
// Generated 28 May 2021, 22:10:28 by Hibernate Tools 5.4.30.Final

import java.util.List;
import org.hibernate.Transaction;
import net.javacourse.entities.Trainers;

/**
 * Home object for domain model class Trainers.
 * @see net.javacourse.models.Trainers
 * @author Hibernate Tools
 */
public class TrainersModel extends Model {


	public TrainersModel() {
		super();
		this._table = "Trainers";
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Trainers> getAll() {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		List<Trainers> data = null;
		
		String query = "FROM " + this._table;
		try {
			transaction.begin();
			data = this._session.createQuery(query, Trainers.class).list();
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
	public Trainers get(String id) {
		Trainers data = (Trainers)this.findById(id);
		return data;
	}
	
	/**
	 * Adding new student
	 * 
	 * @param data
	 * @return
	 */
	public boolean add(Trainers data) {
		String id = data.getTrainerId();
		Trainers exist = this.get(id);
		
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
	public boolean updateById(String id, Trainers data) {
		Trainers exist = this.get(id);
		
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
		Trainers exist = this.get(id);
		
		if (exist == null) {
			return false;
		};
		
		return this.delete(exist);
	}
	
//	public void persist(Trainers transientInstance) {
//		logger.log(Level.INFO, "persisting Trainers instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			logger.log(Level.INFO, "persist successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Trainers instance) {
//		logger.log(Level.INFO, "attaching dirty Trainers instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Trainers instance) {
//		logger.log(Level.INFO, "attaching clean Trainers instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Trainers persistentInstance) {
//		logger.log(Level.INFO, "deleting Trainers instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			logger.log(Level.INFO, "delete successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "delete failed", re);
//			throw re;
//		}
//	}
//
//	public Trainers merge(Trainers detachedInstance) {
//		logger.log(Level.INFO, "merging Trainers instance");
//		try {
//			Trainers result = (Trainers) sessionFactory.getCurrentSession().merge(detachedInstance);
//			logger.log(Level.INFO, "merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "merge failed", re);
//			throw re;
//		}
//	}
//
//	public Trainers findById(java.lang.String id) {
//		logger.log(Level.INFO, "getting Trainers instance with id: " + id);
//		try {
//			Trainers instance = (Trainers) sessionFactory.getCurrentSession().get("net.javacourse.models.Trainers", id);
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
//	public List findByExample(Trainers instance) {
//		logger.log(Level.INFO, "finding Trainers instance by example");
//		try {
//			List results = sessionFactory.getCurrentSession().createCriteria("net.javacourse.models.Trainers")
//					.add(Example.create(instance)).list();
//			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "find by example failed", re);
//			throw re;
//		}
//	}
}