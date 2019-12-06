package ua.khnucea.csit.cs.pertseva.airline.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * The abstract class Dao.
 *
 * @author Pertseva Veronika
 *
 */
public abstract class AbstractDao {

	public final static Logger LOGGER = Logger.getLogger(AbstractDao.class);;

	/**
	 * Util meth for close connection.
	 *
	 * @param connection
	 */
	protected void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			LOGGER.error("Close connection error.", e);
		}
		LOGGER.info("Connection has been closed.");

	}
}
