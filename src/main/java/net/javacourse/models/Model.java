package net.javacourse.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import net.javacourse.entities.Database;

public class Model {
	protected final SessionFactory sessionFactory = Database.getSessionFactory();
	protected Session _session;
	protected String _table;
	
	/**
	 * 
	 */
	public Model() {
		_session = null;
	}
	
	/**
	 * Abstract
	 * @return
	 */
	public String table() {
		return this._table;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Object> all() {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		List<Object> data = null;
		
		String query = "FROM " + this._table;
		try {
			transaction.begin();
			data = this._session.createQuery(query, Object.class).list();
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
	public Object findById(int id) {
		Object data = null;
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		
		String query = "FROM " + this._table + " WHERE id = :id";
		try {
			transaction.begin();
			data = this._session.createQuery(query).setParameter("id", id).uniqueResult();
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		} finally {
			this._session.close();
		};
		
		return data;
	}
	public Object findById(String id) {
		Object data = null;
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		
		String query = "FROM " + this._table + " WHERE id = :id";
		try {
			transaction.begin();
			data = this._session.createQuery(query).setParameter("id", id).uniqueResult();
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
	 * Saving data into DB
	 * 
	 * @param data
	 * @return
	 */
	public boolean save(Object data) {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		
		try {
			transaction.begin();
			this._session.save(data);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			this._session.close();
		};
		
		return true;
	}
	
	/**
	 * 
	 * @param id
	 * @param data
	 * @return
	 */
	public boolean update(Object data) {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		
		try {
			transaction.begin();
			this._session.update(data);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			this._session.close();
		};
		
		return true;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Object data) {
		this._session = this.sessionFactory.openSession();
		Transaction transaction = this._session.getTransaction();
		
		try {
			transaction.begin();
			this._session.delete(data);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			this._session.close();
		};
		
		return true;
	}
}
