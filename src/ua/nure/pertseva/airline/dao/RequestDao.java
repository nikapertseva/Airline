package ua.nure.pertseva.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Query;
import ua.nure.pertseva.airline.entity.Request;
import ua.nure.pertseva.airline.entity.Flight;
import ua.nure.pertseva.airline.entity.User;
import ua.nure.pertseva.airline.utils.Formatter;

/**
 * The class is data access object of request.
 *
 * @author Pertseva Veronika
 *
 */
public class RequestDao extends AbstractDao {
	/** Logger */
	public final static Logger LOGGER = Logger.getLogger(RequestDao.class);

	/**
	 * Adding new request to database.
	 *
	 * @param userId   - user's id
	 * @param flightId - flight's id
	 * @param topic    - topic
	 * @param message  - message
	 * @see Request
	 */
	public void addRequest(String userId, String flightId, String topic, String message) {
		LOGGER.debug("Adding new request.");
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_ADD_REQUEST);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, flightId);
			preparedStatement.setString(3, topic);
			preparedStatement.setString(4, message);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Request has been added");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Removing request by flight's id from database.
	 *
	 * @param id - flight's id
	 * @see Request
	 */
	public void removeRequestsByFlightId(String id) {
		LOGGER.debug("Removing requests by flight's id: " + id);
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_REMOVE_REQUESTS_BY_FLIGHT_ID);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Requests has been removed");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}

	}

	/**
	 * Getting requests by flight's id from database.
	 *
	 * @param id - flight's id
	 * @see Request
	 * @return list of request's entity
	 */
	public List<Request> getRequestByFligthsId(String id) {
		LOGGER.debug("Getting requests by flight's id: " + id);
		List<Request> requests = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_REQUESTS_BY_FLIGHT_ID)) {
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getInt("user_id"), resultSet.getString("user_email"),
						resultSet.getString("user_password"), resultSet.getString("user_role"));
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				requests.add(new Request(resultSet.getInt("request_id"), user, flight,
						resultSet.getString("request_topic"), resultSet.getString("request_message"),
						resultSet.getDate("request_date"), resultSet.getString("request_status")));
			}
			LOGGER.info("Found: " + requests.size() + " requests");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return requests;
	}

	/**
	 * Getting all requests from database.
	 *
	 * @see Request
	 * @return list of request's entity
	 */
	public List<Request> getAllRequests() {
		LOGGER.debug("Getting all requests");
		List<Request> requests = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_ALL_REQUESTS)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getInt("user_id"), resultSet.getString("user_email"),
						resultSet.getString("user_password"), resultSet.getString("user_role"));
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				requests.add(new Request(resultSet.getInt("request_id"), user, flight,
						resultSet.getString("request_topic"), resultSet.getString("request_message"),
						resultSet.getDate("request_date"), resultSet.getString("request_status")));
			}
			LOGGER.info("Found: " + requests.size() + " requests");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return requests;
	}

	/**
	 * Getting requests by id from database.
	 *
	 * @param id - request's id
	 * @see Request
	 * @return list of request's entity
	 */
	public Request getRequestById(String id) {
		LOGGER.debug("Getting requests by id: " + id);
		Request request = null;
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_REQUESTS_BY_ID)) {
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getInt("user_id"), resultSet.getString("user_email"),
						resultSet.getString("user_password"), resultSet.getString("user_role"));
				Timestamp timestampDeparture = resultSet.getTimestamp("flight_date_departure");
				Timestamp timestampArrival = resultSet.getTimestamp("flight_date_arrival");
				Flight flight = new Flight(resultSet.getInt("flight_id"), resultSet.getString("flight_number"),
						resultSet.getString("flight_name"), resultSet.getString("flight_city_from"),
						resultSet.getString("flight_city_to"), Formatter.formatDate(timestampDeparture),
						Formatter.formatTime(timestampDeparture), Formatter.formatDate(timestampArrival),
						Formatter.formatTime(timestampArrival), resultSet.getString("flight_status"));

				request = new Request(resultSet.getInt("request_id"), user, flight,
						resultSet.getString("request_topic"), resultSet.getString("request_message"),
						resultSet.getDate("request_date"), resultSet.getString("request_status"));
				LOGGER.info("Found: " + request.getRequestId());
			}

		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return request;
	}

	/**
	 * Editing request's status by id in database.
	 *
	 * @param status - new status
	 * @param id     - request's id
	 * @see Request
	 */
	public void editRequestsStatus(String status, String id) {
		LOGGER.debug("Editing request's status by id: " + id);
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_EDIT_REQUEST_STATUS);
			preparedStatement.setString(1, status);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Request's status has been edited");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Removing request by user's id from database.
	 *
	 * @param id - user's id
	 * @see Request
	 */
	public void removeRequestsByUserId(String id) {
		LOGGER.debug("Removing requests by user's id: " + id);
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_REMOVE_REQUESTS_BY_USER_ID);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Requests has been removed");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
	}

}
