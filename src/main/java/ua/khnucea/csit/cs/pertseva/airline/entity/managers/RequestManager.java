package ua.khnucea.csit.cs.pertseva.airline.entity.managers;

import java.util.List;

import ua.khnucea.csit.cs.pertseva.airline.dao.RequestDao;
import ua.khnucea.csit.cs.pertseva.airline.entity.Request;

/**
 * Manager for calling request's dao methods.
 *
 * @author Pertseva Veronika
 *
 */
public class RequestManager {

	/**
	 * Request's Dao.
	 *
	 * @see RequestDao
	 */
	private static RequestDao requestDao = new RequestDao();

	/**
	 * Calls the method for adding new request to database.
	 *
	 * @param userId   - user's id
	 * @param flightId - flight's id
	 * @param topic    - topic
	 * @param message  - message
	 * @see Request
	 */
	public static void addRequest(String userId, String flightId, String topic, String message) {
		requestDao.addRequest(userId, flightId, topic, message);

	}

	/**
	 * Calls the method for removing request by flight's id from database.
	 *
	 * @param id - flight's id
	 * @see Request
	 */
	public static void removeRequestsByFlightId(String id) {
		requestDao.removeRequestsByFlightId(id);

	}

	/**
	 * Calls the method for getting requests by flight's id from database.
	 *
	 * @param id - flight's id
	 * @see Request
	 * @return list of request's entity
	 */
	public static List<Request> getRequestByFligthsId(String id) {
		return requestDao.getRequestByFligthsId(id);
	}

	/**
	 * Calls the method for getting all requests from database.
	 *
	 * @see Request
	 * @return list of request's entity
	 */
	public static List<Request> getAllRequests() {
		return requestDao.getAllRequests();
	}

	/**
	 * Calls the method for getting requests by id from database.
	 *
	 * @param id - request's id
	 * @see Request
	 * @return list of request's entity
	 */
	public static Request getRequestById(String id) {
		return requestDao.getRequestById(id);
	}

	/**
	 * Calls the method for editing request's status by id in database.
	 *
	 * @param status - new status
	 * @param id     - request's id
	 * @see Request
	 */
	public static void editRequestsStatus(String status, String id) {
		requestDao.editRequestsStatus(status, id);
	}

	/**
	 * Calls the method for removing request by user's id from database.
	 *
	 * @param id - user's id
	 * @see Request
	 */
	public static void removeRequestsByUserId(String id) {
		requestDao.removeRequestsByUserId(id);
	}

}
