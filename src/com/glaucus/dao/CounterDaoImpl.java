package com.glaucus.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.glaucus.entity.CounterEntity;
import com.glaucus.exception.GlaucusDBException;

/**
 * Dao layer implementation for CounterEntity 
 * 
 * @author nikhil
 * @version 1.0
 * @since 2019-01-03
 */
@Repository
public class CounterDaoImpl implements CounterDao {
	
	/**
	 *  insert CounterEntity into DB
	 */
	public void insert(CounterEntity counterEntity) throws GlaucusDBException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(counterEntity);
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			if(session != null) {
				session.getTransaction().rollback();
			}
			throw new GlaucusDBException();
		}finally {
			if(session != null ) {
				if(session.isOpen()) {
					session.close();
				}
			}
		}
		
	}
	
	/**
	 *  get CounterEntity from DB where Counter_Name is equal to counterName
	 */
	public CounterEntity get(String counterName) throws GlaucusDBException {
		Session session = null;
		CounterEntity counterEntity = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(CounterEntity.class);
			criteria.add(Restrictions.idEq(counterName));
			List<CounterEntity> listCounterEntity = criteria.list();
			if(listCounterEntity.size() > 0) {
				counterEntity = listCounterEntity.get(0);
			}
		}catch(HibernateException e) {
			e.printStackTrace();
			throw new GlaucusDBException();
		}finally {
			if(session != null ) {
				if(session.isOpen()) {
					session.close();
				}
			}
		}
		return counterEntity;
	}
	/**
	 * Update the CounterEnitity
	 */
	public void update(CounterEntity counterEntity) throws GlaucusDBException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(counterEntity);
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			if(session != null) {
				session.getTransaction().rollback();
			}
			throw new GlaucusDBException();
		}finally {
			if(session != null ) {
				if(session.isOpen()) {
					session.close();
				}
			}
		}
	}
}
