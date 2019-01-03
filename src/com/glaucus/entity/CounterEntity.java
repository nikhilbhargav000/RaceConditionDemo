package com.glaucus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  ORM of Counter Entity for 'Counter_Table' Table
 * 
 * @author nikhil
 * @version 1.0
 * @since 2019-01-03
 */
@Entity
@Table(name="Counter_Table")
public class CounterEntity {
	@Id
	@Column(name="counter_name")
	String counterName;
	@Column(name="counter")
	int counter;
	public CounterEntity() {
		
	}
	public CounterEntity(String counterName, int counter) {
		super();
		this.counterName = counterName;
		this.counter = counter;
	}
	public String getCounterName() {
		return counterName;
	}
	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	@Override
	public String toString() {
		return "CounterEntity [counterName=" + counterName + ", counter=" + counter + "]";
	}
}
