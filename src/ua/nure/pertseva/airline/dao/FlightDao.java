package ua.nure.pertseva.airline.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Query;
import ua.nure.pertseva.airline.entity.Flight;
import ua.nure.pertseva.airline.utils.Formatter;

/**
 * The class is data access object of flight.
 *
 * @author Pertseva Veronika
 *
 */
public class FlightDao extends AbstractDao {
	/** Logger */
	public final static Logger LOGGER = Logger.getLogger(FlightDao.class);

	/**
	 * Getting all flights from database.
	 *
	 * @see Flight
	 * @return list of flight's entity
	 */
	public List<Flight> getAllFlights() {
		LOGGER.debug("Getting all flights");
		List<Flight> flights = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_ALL_FLIGHTS)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				flights.add(flight);
			}

			LOGGER.info("Found: " + flights.size() + " flights");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return flights;
	}

	/**
	 * Getting all searched flights from database.
	 *
	 * @param search - search
	 * @see Flight
	 * @return list of flight's entity
	 */
	public List<Flight> getAllSearchedFlights(String search) {
		LOGGER.debug("Getting employees by search:" + search);
		List<Flight> flights = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_FLIGHTS_BY_SEARCH)) {
			preparedStatement.setString(1, "%" + search + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				flights.add(flight);
			}
			LOGGER.info("Found: " + flights.size() + " flights");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
		return flights;
	}

	/**
	 * Getting all citiesFrom from database.
	 *
	 * @return list of cities
	 */
	public List<String> getAllCitiesFrom() {
		LOGGER.debug("Getting all cities from");
		List<String> cities = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_ALL_CITIES_FROM)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				cities.add(resultSet.getString("flight_city_from"));
			}
			LOGGER.info("Found: " + cities.size() + " cities");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return cities;
	}

	/**
	 * Getting all citiesTo from database.
	 *
	 * @return list of cities
	 */
	public List<String> getAllCitiesTo() {
		LOGGER.debug("Getting all cities to");
		List<String> cities = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_ALL_CITIES_TO)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				cities.add(resultSet.getString("flight_city_to"));
			}
			LOGGER.info("Found: " + cities.size() + " cities");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return cities;
	}

	/**
	 * Getting flights by cities and date of departure from database.
	 *
	 * @param cityFrom - from (city)
	 * @param cityTo   - to (city)
	 * @param date     - date of departure
	 * @see Flight
	 * @return list of flight's entity
	 */
	public List<Flight> getAllFlightsByCitiesAndDate(String cityFrom, String cityTo, String date) {
		LOGGER.debug("Getting all flights by cities and date of departure");
		List<Flight> flights = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection
				.prepareStatement(Query.SQL_GET_FLIGHTS_BY_CITIES_AND_DATE)) {
			preparedStatement.setString(1, cityFrom + "%");
			preparedStatement.setString(2, cityTo + "%");
			preparedStatement.setString(3, date + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				flights.add(flight);
			}
			LOGGER.info("Found: " + flights.size() + " flights");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
		return flights;
	}

	/**
	 * Getting sorted flights from database.
	 *
	 * @param sort - sort
	 * @see Flight
	 * @return list of flight's entity
	 */
	public List<Flight> getAllSortedFlights(String sort) {
		LOGGER.debug("Getting all sorted flights");
		String query = null;
		switch (sort) {
		case "ascendingNumbers":
			query = Query.SQL_GET_FLIGHTS_SORTED_BY_NUMBER_ASC;
			break;
		case "descendingNumbers":
			query = Query.SQL_GET_FLIGHTS_SORTED_BY_NUMBER_DESC;
			break;
		case "ascendingNames":
			query = Query.SQL_GET_FLIGHTS_SORTED_BY_NAME_ASC;
			break;
		case "descendingNames":
			query = Query.SQL_GET_FLIGHTS_SORTED_BY_NAME_DESC;
			break;
		default:
			query = Query.SQL_GET_ALL_FLIGHTS;
		}
		List<Flight> flights = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				flights.add(flight);
			}
			LOGGER.info("Found: " + flights.size() + " flights");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return flights;
	}

	/**
	 * Getting sorted flights by cities and date of departure from database.
	 *
	 * @param cityFrom - from (city)
	 * @param cityTo   - to (city)
	 * @param date     - date of departure
	 * @param sort     - sort
	 * @see Flight
	 * @return list of flight's entity
	 */
	public List<Flight> getAllSortedFlightsByCitiesAndDate(String cityFrom, String cityTo, String date, String sort) {
		LOGGER.debug("Getting all sorted flights by cities and date of departure");
		String query = null;
		switch (sort) {
		case "ascendingNumbers":
			query = Query.SQL_GET_FLIGHTS_BY_CITIES_AND_DATE_SORTED_BY_NUMBER_ASC;
			break;
		case "descendingNumbers":
			query = Query.SQL_GET_FLIGHTS_BY_CITIES_AND_DATE_SORTED_BY_NUMBER_DESC;
			break;
		case "ascendingNames":
			query = Query.SQL_GET_FLIGHTS_BY_CITIES_AND_DATE_SORTED_BY_NAME_ASC;
			break;
		case "descendingNames":
			query = Query.SQL_GET_FLIGHTS_BY_CITIES_AND_DATE_SORTED_BY_NAME_DESC;
			break;
		default:
			query = Query.SQL_GET_FLIGHTS_BY_CITIES_AND_DATE;
		}
		List<Flight> flights = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, cityFrom + "%");
			preparedStatement.setString(2, cityTo + "%");
			preparedStatement.setString(3, date + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				flights.add(flight);
			}
			LOGGER.info("Found: " + flights.size() + " flights");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
		return flights;
	}

	/**
	 * Getting sorted flights by search from database.
	 *
	 * @param search - search
	 * @param sort   - sort
	 * @see Flight
	 * @return list of flight's entity
	 */
	public List<Flight> getSortedSearchedFlights(String search, String sort) {
		LOGGER.debug("Getting all sorted flights by search: " + search);
		String query = null;
		switch (sort) {
		case "ascendingNumbers":
			query = Query.SQL_GET_FLIGHTS_BY_SEARCH_BY_NUMBER_ASC;
			break;
		case "descendingNumbers":
			query = Query.SQL_GET_FLIGHTS_BY_SEARCH_SORTED_BY_NUMBER_DESC;
			break;
		case "ascendingNames":
			query = Query.SQL_GET_FLIGHTS_BY_SEARCH_SORTED_BY_NAME_ASC;
			break;
		case "descendingNames":
			query = Query.SQL_GET_FLIGHTS_BY_SEARCH_SORTED_BY_NAME_DESC;
			break;
		default:
			query = Query.SQL_GET_FLIGHTS_BY_SEARCH;
		}
		List<Flight> flights = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, "%" + search + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				flights.add(flight);
			}
			LOGGER.info("Found: " + flights.size() + " flights");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
		return flights;
	}

	/**
	 * Getting flight by id from database.
	 *
	 * @param id - flight's id
	 * @see Flight
	 * @return list of flight's entity
	 */
	public Flight getFlightById(String id) {
		LOGGER.debug("Getting flight by id: " + id);
		Flight flight = null;
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_FLIGHT_BY_ID)) {
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));
				LOGGER.info("Found: " + flight.getFlightId());
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		} finally {
			closeConnection(connection);
		}
		return flight;
	}

	/**
	 * Adding flight to database.
	 *
	 * @param number        - number
	 * @param name          - name
	 * @param cityFrom      - cityFrom
	 * @param cityTo        - cityTo
	 * @param dateDeparture - date of departure
	 * @param dateArrival   - date of arrival
	 * @see Flight
	 */
	public void addFlight(String number, String name, String cityFrom, String cityTo, String dateDeparture,
			String dateArrival) {
		LOGGER.debug("Adding new flight");
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_ADD_FLIGHT);
			preparedStatement.setString(1, number);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, cityFrom);
			preparedStatement.setString(4, cityTo);
			preparedStatement.setString(5, dateDeparture);
			preparedStatement.setString(6, dateArrival);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Flight has been added");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}

	}

	/**
	 * Editing flight by id in database.
	 *
	 * @param number        - number
	 * @param name          - name
	 * @param cityFrom      - cityFrom
	 * @param cityTo        - cityTo
	 * @param dateDeparture - date of departure
	 * @param dateArrival   - date of arrival
	 * @param id            - flight's id
	 * @see Flight
	 */
	public void editFlight(String number, String name, String cityFrom, String cityTo, String dateDeparture,
			String dateArrival, String id) {
		LOGGER.debug("Editing flight by id: " + id);
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_EDIT_FLIGHT);
			preparedStatement.setString(1, number);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, cityFrom);
			preparedStatement.setString(4, cityTo);
			preparedStatement.setString(5, dateDeparture);
			preparedStatement.setString(6, dateArrival);
			preparedStatement.setString(7, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Flight has been edited");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Removing flight by id in database.
	 *
	 * @param id - flight's id
	 * @throws SQLException
	 * @see Flight
	 */
	public void removeFlight(String id) throws SQLException {
		LOGGER.debug("Removing flight by id: " + id);
		Connection connection = ConnectingPool.getConnection();
		PreparedStatement removeCrew = null;
		PreparedStatement removeRequest = null;
		PreparedStatement removeFlight = null;
		try {
			connection.setAutoCommit(false);
			removeCrew = connection.prepareStatement(Query.SQL_REMOVE_CREW_BY_FLIGHT_ID);
			removeRequest = connection.prepareStatement(Query.SQL_REMOVE_REQUESTS_BY_FLIGHT_ID);
			removeFlight = connection.prepareStatement(Query.SQL_REMOVE_FLIGHT);
			removeCrew.setString(1, id);
			removeCrew.executeUpdate();
			removeRequest.setString(1, id);
			removeRequest.executeUpdate();
			removeFlight.setString(1, id);
			removeFlight.executeUpdate();
			connection.commit();
			LOGGER.info("Flight has been removed");
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			try {
				LOGGER.debug("Transaction is being rolled back");
				connection.rollback();
			} catch (SQLException e1) {
				LOGGER.error(e1.getMessage());
			}
		} finally {
			if (!Objects.isNull(removeCrew)) {
				removeCrew.close();
			}
			if (!Objects.isNull(removeRequest)) {
				removeRequest.close();
			}
			if (!Objects.isNull(removeFlight)) {
				removeFlight.close();
			}
			connection.setAutoCommit(true);
			closeConnection(connection);
		}

	}

	/**
	 * Editing flight's status by id in database.
	 *
	 * @param status - new status
	 * @param id     - flight's id
	 * @see Flight
	 */
	public void editFlightsStatus(String status, String id) {
		LOGGER.debug("Editing flight's status by id: " + id);
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_EDIT_FLIGHTS_STATUS);
			preparedStatement.setString(1, status);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Flight's status has been edited");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}

	}

}