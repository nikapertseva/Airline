package ua.nure.pertseva.airline.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * The class realizes connecting pool.
 *
 * @author Pertseva Veronika
 *
 */
public class ConnectingPool {

	/** Source of data */
	private static DataSource dataSource;

	/** Logger */
	public final static Logger LOGGER = Logger.getLogger(ConnectingPool.class);

	/**
	 * Getting connection method
	 *
	 * @return connection
	 */
	public static synchronized Connection getConnection() {
		Connection connection = null;
		try {
			LOGGER.debug("Obtain dataSource");
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/airline");

		} catch (NamingException e) {
			LOGGER.error("DataSource obtaining failed");
		}
		try {
			LOGGER.debug("Getting connection by datasource");
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			LOGGER.error("Connection to db failed");
		}
		LOGGER.debug("Connected!");
		return connection;

	}

}
