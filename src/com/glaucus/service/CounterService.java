package com.glaucus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaucus.dao.CounterDao;
import com.glaucus.dao.HibernateUtil;
import com.glaucus.entity.CounterEntity;
import com.glaucus.exception.GlaucusDBException;

@Service
public class CounterService {

	@Autowired
	CounterDao counterDao;
	
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
