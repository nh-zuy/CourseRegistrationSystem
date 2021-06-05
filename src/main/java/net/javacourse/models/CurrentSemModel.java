package net.javacourse.models;
// Generated 28 May 2021, 22:10:28 by Hibernate Tools 5.4.30.Final

import java.util.List;
import org.hibernate.Transaction;

import net.javacourse.entities.Courses;
import net.javacourse.entities.CurrentSem;
import net.javacourse.entities.Semesters;

/**
 * Home object for domain model class Semesters.
 * @see net.javacourse.models.Semesters
 * @author Hibernate Tools
 */
public class CurrentSemModel extends Model {


	/**
	 * 
	 */
	public CurrentSemModel() {
		super();
		this._table = "CurrentSem";
	}
	
	/**
	 * 
	 * @return
	 */
	public CurrentSem getCurrentSemester() {
		return this.find(1);
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public boolean setCurrentSemester(CurrentSem data) {
		CurrentSem semester = this.getCurrentSemester();
		
		semester.setSubName(data.getSubName());
		semester.setYear(data.getYear());
		semester.setSemesters(data.getSemesters());
		semester.setId(1);
		
		return this.update(data);
	}
		

	/**
	 * 
	 * @return
	 */
	public List<CurrentSem> getAll() {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		List<CurrentSem> data = null;
		
		String query = "FROM " + this._table;
		try {
			transaction.begin();
			data = this._session.createQuery(query, CurrentSem.class).list();
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
	public CurrentSem find(Integer id) {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		CurrentSem data = null;
		
		try {
			transaction.begin();
			data = (CurrentSem)this._session.get(CurrentSem.class, id);
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
	public boolean add(CurrentSem data) {
		Integer id = data.getId();
		CurrentSem exist = this.find(id);
		
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
	public boolean updateById(Integer id, CurrentSem data) {
		CurrentSem exist = this.find(id);
		
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
		CurrentSem exist = this.find(id);
		
		if (exist == null) {
			return false;
		};
		
		return this.delete(exist);
	}
	
//	public void persist(Semesters transientInstance) {
//		logger.log(Level.INFO, "persisting Semesters instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			logger.log(Level.INFO, "persist successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Semesters instance) {
//		logger.log(Level.INFO, "attaching dirty Semesters instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Semesters instance) {
//		logger.log(Level.INFO, "attaching clean Semesters instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			logger.log(Level.INFO, "attach successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Semesters persistentInstance) {
//		logger.log(Level.INFO, "deleting Semesters instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			logger.log(Level.INFO, "delete successful");
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "delete failed", re);
//			throw re;
//		}
//	}
//
//	public Semesters merge(Semesters detachedInstance) {
//		logger.log(Level.INFO, "merging Semesters instance");
//		try {
//			Semesters result = (Semesters) sessionFactory.getCurrentSession().merge(detachedInstance);
//			logger.log(Level.INFO, "merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "merge failed", re);
//			throw re;
//		}
//	}
//

//
//	public List findByExample(Semesters instance) {
//		logger.log(Level.INFO, "finding Semesters instance by example");
//		try {
//			List results = sessionFactory.getCurrentSession().createCriteria("net.javacourse.models.Semesters")
//					.add(Example.create(instance)).list();
//			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "find by example failed", re);
//			throw re;
//		}
//	}
}