package com.glaucus.utility;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.instrument.classloading.glassfish.GlassFishLoadTimeWeaver;


public class GlaucusLogger {
	private static GlaucusLogger glaucusLogger;
	private Logger logger;
	private Handler handler;
	
	public GlaucusLogger(){
		logger = Logger.getLogger("GLAUCUS : Logger");
		handler = new ConsoleHandler();
		handler.setFormatter(new SimpleFormatter());
		logger.addHandler(handler);
		logger.setUseParentHandlers(false);
	}

	public static GlaucusLogger getLogger() {
		if(GlaucusLogger.glaucusLogger == null) {
			GlaucusLogger.glaucusLogger = new GlaucusLogger();
		}
		return glaucusLogger;
	}
	public void info(String msg){
		logger.info("GLAUCUS : " + msg);
	}
	
	public void severe(String msg){
		logger.severe("GLAUCUS : " + msg);
	}
	
	public void warning(String msg){
		logger.warning("GLAUCUS : " + msg);
	}
}
