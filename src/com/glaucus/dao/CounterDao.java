package com.glaucus.dao;

import com.glaucus.entity.CounterEntity;
import com.glaucus.exception.GlaucusDBException;

public interface CounterDao {
	
	public void insert(CounterEntity counterEntity) throws GlaucusDBException ;
	public CounterEntity get(String counterName) throws GlaucusDBException ;
	public void update(CounterEntity counterEntity) throws GlaucusDBException ;
}
