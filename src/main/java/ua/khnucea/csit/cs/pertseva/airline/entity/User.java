package ua.khnucea.csit.cs.pertseva.airline.entity;

/**
 * The class is user's entity.
 *
 * @author Pertseva Veronika
 *
 */
public class User {

	/** User's id. */
	private int userId;

	/** User's email. */
	private String userEmail;

	/** User's password. */
	private String userPassword;

	/** User's role. */
	private String userRole;

	/**
	 * Constructor.
	 *
	 * @param userId       - user's id
	 * @param userEmail    - user's email
	 * @param userPassword - user's password
	 * @param userRole     - user's role
	 */
	public User(int userId, String userEmail, String userPassword, String userRole) {
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}

	/**
	 * Getter for user's id.
	 *
	 * @return user's id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Setter for user's id.
	 *
	 * @param userId - user's id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Getter for user's email.
	 *
	 * @return user's email
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * Setter for user's email.
	 *
	 * @param userEmail - user's email
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * Getter for user's password.
	 *
	 * @return user's password
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * Setter for user's password.
	 *
	 * @param userPassword - user's password
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * Getter for user's role.
	 *
	 * @return user's role
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * Setter for user's role.
	 *
	 * @param userRole - user's role
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
