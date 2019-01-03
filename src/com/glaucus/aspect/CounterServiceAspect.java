package com.glaucus.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.glaucus.utility.GlaucusLogger;

/**
 * Aspects for CounterService class`s methods
 * @author nikhil
 * @version 1.0
 * @since 2019-01-03
 */

@Component
@Aspect
public class CounterServiceAspect {
	
	GlaucusLogger logger = GlaucusLogger.getLogger();

	@Before(value="execution(* com.glaucus.service.CounterService.*(..))")
	public void beforeAdvice() {
		logger.info("Before : CounterService");
	}
	
	@After(value="execution(* com.glaucus.service.CounterService.*(..))")
	public void afterAdvice() {
		logger.info("After : CounterService");
	}
	
	@AfterThrowing(value="execution(* com.glaucus.service.CounterService.*(..))")
	public void afterThrowingAdvice() {
		logger.info("AfterThrowing : CounterService");
	}
	
}
