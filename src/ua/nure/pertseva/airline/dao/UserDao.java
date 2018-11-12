package ua.nure.pertseva.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Query;
import ua.nure.pertseva.airline.entity.User;

/**
 * The class is data access object of user.
 *
 * @author Pertseva Veronika
 *
 */
public class UserDao extends AbstractDao {
	/** Logger. */
	public final static Logger LOGGER = Logger.getLogger(UserDao.class);

	/**
	 * Getting user by email from database.
	 *
	 * @param email - email
	 * @see User
	 * @return user's entity
	 */
	public User getUserByEmail(String email) {
		LOGGER.debug("Getting user by email: " + email);
		User user = null;
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_USER_BY_EMAIL)) {
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User(resultSet.getInt("user_id"), resultSet.getString("user_email"),
						resultSet.getString("user_password"), resultSet.getString("user_role"));
				LOGGER.info("Found: " + user.getUserId());
			}

		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return user;
	}

	/**
	 * Getting all users from database.
	 *
	 * @see User
	 * @return user's entity
	 */
	public List<User> getAllUsers() {
		LOGGER.debug("Getting all users");
		List<User> users = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_ALL_USERS)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getInt("user_id"), resultSet.getString("user_email"),
						resultSet.getString("user_password"), resultSet.getString("user_role"));
				users.add(user);
			}
			LOGGER.info("Found: " + users.size() + " users.");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
		return users;
	}

	/**
	 * Adding new user to database.
	 * 
	 * @param email    - email
	 * @param password - password
	 * @param role     - role
	 * @see User
	 */
	public void addUser(String email, String password, String role) {
		LOGGER.debug("Adding new user");
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_ADD_USER);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, role);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("User has been added");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Getting user by id from database.
	 *
	 * @param id - user's id
	 * @see User
	 * @return user's entity
	 */
	public User getUserById(String id) {
		LOGGER.debug("Getting user by id: " + id);
		User user = null;
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_USER_BY_ID)) {
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User(resultSet.getInt("user_id"), resultSet.getString("user_email"),
						resultSet.getString("user_password"), resultSet.getString("user_role"));
				LOGGER.info("Found: " + user.getUserId());
			}
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}
		return user;
	}

	/**
	 * Removing user by id from database.
	 *
	 * @param id - user's id
	 * @throws SQLException
	 * @see User
	 */
	public void removeUser(String id) throws SQLException {
		LOGGER.debug("Removing user by id: " + id);
		Connection connection = ConnectingPool.getConnection();
		PreparedStatement removeRequest = null;
		PreparedStatement removeUser = null;
		try {
			connection.setAutoCommit(false);
			removeRequest = connection.prepareStatement(Query.SQL_REMOVE_REQUESTS_BY_USER_ID);
			removeUser = connection.prepareStatement(Query.SQL_REMOVE_USER);
			removeRequest.setString(1, id);
			removeRequest.executeUpdate();
			removeUser.setString(1, id);
			removeUser.executeUpdate();
			connection.commit();
			LOGGER.info("User has been removed");
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			try {
				LOGGER.debug("Transaction is being rolled back");
				connection.rollback();
			} catch (SQLException e1) {
				LOGGER.error(e1.getMessage());
			}
		} finally {
			if (!Objects.isNull(removeRequest)) {
				removeRequest.close();
			}
			if (!Objects.isNull(removeUser)) {
				removeUser.close();
			}
			connection.setAutoCommit(true);
			closeConnection(connection);
		}
	}
}
