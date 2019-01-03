package com.glaucus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaucus.dao.CounterDao;
import com.glaucus.dao.HibernateUtil;
import com.glaucus.entity.CounterEntity;
import com.glaucus.exception.GlaucusDBException;

/**
 * Contains all the business logic related to counter mapping
 * 
 * @author nikhil
 * @version 1.0
 * @since 2019-01-03
 */
@Service
public class CounterService {

	@Autowired
	CounterDao counterDao;
	
	/**
	 * 
	 * @param counterName : counter name for which count is to be incremented
	 * @return
	 * @throws GlaucusDBException
	 */
	public int incrementCounter(String counterName) throws GlaucusDBException {
		
		synchronized (HibernateUtil.getSessionFactory()) {
			CounterEntity counterEntity = counterDao.get(counterName);
			if(counterEntity == null) {
				counterEntity = new CounterEntity(counterName, 0);
				counterDao.insert(counterEntity);
			}
			counterEntity.setCounter(counterEntity.getCounter() + 1);
			counterDao.update(counterEntity);
			return counterEntity.getCounter();
		}
	}
	
}
