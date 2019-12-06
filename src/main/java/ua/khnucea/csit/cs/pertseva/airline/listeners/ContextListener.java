package ua.khnucea.csit.cs.pertseva.airline.listeners;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet Context Listener implementation class ContextListener for
 * initializing log4j.
 *
 * @author Pertseva Veronika
 */
public class ContextListener implements ServletContextListener {

	/**
	 * Initialize log4j when the application is being started.
	 * 
	 * @param event - ServletContextEvent
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String log4jConfigFile = context.getInitParameter("log4j-config-location");
		String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;

		PropertyConfigurator.configure(fullPath);

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

}
