package com.glaucus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glaucus.exception.GlaucusDBException;
import com.glaucus.service.CounterService;
import com.glaucus.utility.GlaucusLogger;

/**
 * Handle all the requests starting with mapping 'counter'
 * 
 * @author nikhil
 * @version 1.0
 * @since 2019-01-03
 */
@Controller
@RequestMapping(value="counter")
public class CounterController {
	
	@Autowired
	CounterService counterService;
	
	GlaucusLogger logger = GlaucusLogger.getLogger();
	
	/**
	 * 
	 * @param counterName : name of the counter who`s value is about to be incremented 
	 * @return
	 */
	@RequestMapping(value="/{counterName}/increment")
	public ResponseEntity<String> incrementCounter(@PathVariable(name="counterName")
			String counterName){
		logger.info("In CounterController : incrementCounter");
		int counter;
		try {
			counter = counterService.incrementCounter(counterName);
		} catch (GlaucusDBException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<String>(String.valueOf(counter), HttpStatus.OK);
	}
}
