package ua.khnucea.csit.cs.pertseva.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.constants.Query;
import ua.khnucea.csit.cs.pertseva.airline.entity.Crew;
import ua.khnucea.csit.cs.pertseva.airline.entity.Employee;
import ua.khnucea.csit.cs.pertseva.airline.entity.Flight;
import ua.khnucea.csit.cs.pertseva.airline.utils.Formatter;

/**
 * The class is data access object of crew.
 *
 * @author Pertseva Veronika
 */
public class CrewDao extends AbstractDao {

	/** Logger */
	public final static Logger LOGGER = Logger.getLogger(CrewDao.class);

	/**
	 * Getting all crew by flight's id from database
	 *
	 * @param id - flight's id
	 * @see Crew
	 * @return list of crew's entity
	 */
	public List<Crew> getAllCrewByFlightId(String id) {
		LOGGER.info("Getting crew by flight's id: " + id);
		List<Crew> crew = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_ALL_CREW_BY_FLIGHT_ID)) {
			preparedStatement.setString(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee(resultSet.getInt("employee_id"),
						resultSet.getString("employee_surname"), resultSet.getString("employee_firstname"),
						resultSet.getString("employee_occupation"));
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				crew.add(new Crew(resultSet.getInt("crew_id"), employee, flight));
			}
			LOGGER.info("Found: " + crew.size() + " crew");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return crew;
	}

	/**
	 * Adding crew to database
	 *
	 * @param employeeId       - employee's id
	 * @param flightId - flight's id
	 * @see Crew
	 */
	public void addCrew(String employeeId, String flightId) {
		LOGGER.info("Adding new crew.");
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_ADD_CREW);
			preparedStatement.setString(1, employeeId);
			preparedStatement.setString(2, flightId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Crew has been added");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}

	}

	/**
	 * Getting crew by id from database
	 *
	 * @param crewId - crew's id
	 * @see Crew
	 * @return crew's entity *
	 */
	public Crew getCrewById(String crewId) {
		LOGGER.info("Getting crew by id: " + crewId);
		Crew crew = null;
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_CREW_BY_ID)) {
			preparedStatement.setString(1, crewId);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee(resultSet.getInt("employee_id"),
						resultSet.getString("employee_surname"), resultSet.getString("employee_firstname"),
						resultSet.getString("employee_occupation"));
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				crew = new Crew(resultSet.getInt("crew_id"), employee, flight);
				LOGGER.info("Found: " + crew.getCrewId());
			}

		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return crew;

	}

	/**
	 * Removing crew by id from database
	 *
	 * @param crewId - crew's id
	 * @see Crew
	 */
	public void removeCrew(String crewId) {
		LOGGER.info("Removing crew by id: " + crewId);
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_REMOVE_CREW);
			preparedStatement.setString(1, crewId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Crew has been removed");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Removing crew by flight's id from database
	 *
	 * @param id - flight's id
	 * @see Crew
	 */
	public void removeCrewByFlightId(String id) {
		LOGGER.info("Removing crew by flight's id: " + id);
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_REMOVE_CREW_BY_FLIGHT_ID);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Crew has been removed");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}

	}

	/**
	 * Removing crew by employee's id from database
	 *
	 * @param id - employee's id
	 * @see Crew
	 */
	public void removeCrewByEmployeeId(String id) {
		LOGGER.info("Removing crew by employee's id: " + id);
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_REMOVE_CREW_BY_EMPLOYEE_ID);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Crew has been removed");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}

	}

}
