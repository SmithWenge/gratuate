package com.team.graduate.common.log;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

/*
 * build a log4j listener
 */
public class Log4jContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String log4jConfigFile = context.getInitParameter("log4j-location");
		String fullPath = context.getRealPath("") + File.separator
				+ log4jConfigFile;

		PropertyConfigurator.configure(fullPath);
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}