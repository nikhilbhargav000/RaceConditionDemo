package com.glaucus.dao;

import com.glaucus.entity.CounterEntity;
import com.glaucus.exception.GlaucusDBException;

/**
 * Implemented by CounterDaoImpl
 * 
 * @author nikhil
 * @version 1.0
 * @since 2019-01-03
 */
public interface CounterDao {
	
	public void insert(CounterEntity counterEntity) throws GlaucusDBException ;
	public CounterEntity get(String counterName) throws GlaucusDBException ;
	public void update(CounterEntity counterEntity) throws GlaucusDBException ;
}
