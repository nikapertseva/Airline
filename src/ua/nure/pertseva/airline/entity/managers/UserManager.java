package ua.nure.pertseva.airline.entity.managers;

import java.sql.SQLException;
import java.util.List;

import ua.nure.pertseva.airline.dao.UserDao;
import ua.nure.pertseva.airline.entity.User;

/**
 * Manager for calling user's dao methods.
 *
 * @author Pertseva Veronika
 *
 */
public class UserManager {

	/**
	 * User's dao.
	 *
	 * @see UserDao
	 */
	private static UserDao userDao = new UserDao();

	/**
	 * Calls the method for getting user by email from database.
	 *
	 * @param email - email
	 * @see User
	 * @return user's entity
	 */
	public static User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	/**
	 * Calls the method for getting all users from database.
	 *
	 * @see User
	 * @return user's entity
	 */
	public static List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	/**
	 * Calls the method for adding new user to database.
	 * 
	 * @param email    - email
	 * @param password - password
	 * @param role     - role
	 * @see User
	 */
	public static void addUser(String email, String password, String role) {
		userDao.addUser(email, password, role);
	}

	/**
	 * Calls the method for getting user by id from database.
	 *
	 * @param id - user's id
	 * @see User
	 * @return user's entity
	 */
	public static User getUserById(String id) {
		return userDao.getUserById(id);
	}

	/**
	 * Calls the method for removing user by id from database.
	 *
	 * @param id - user's id
	 * @throws SQLException
	 * @see User
	 */
	public static void removeUser(String id) throws SQLException {
		userDao.removeUser(id);
	}
}
