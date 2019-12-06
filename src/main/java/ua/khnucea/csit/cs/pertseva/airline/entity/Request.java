package ua.khnucea.csit.cs.pertseva.airline.entity;

import java.util.Date;

/**
 * The class is request's entity.
 *
 * @author Pertseva Veronika
 *
 */
public class Request {
	/** Request's id. */
	private int requestId;
	/** Request's user. */
	private User requestUser;
	/** Request's flight. */
	private Flight requestFlight;
	/** Request's topic. */
	private String requestTopic;
	/** Request's message. */
	private String requestMessage;
	/** Request's date. */
	private Date requestDate;
	/** Request's status. */
	private String requestStatus;

	/**
	 * Constructor.
	 *
	 * @param requestId      - request's id
	 * @param requestUser    - request's user
	 * @param requestFlight  - request's flight
	 * @param requestTopic   - request's topic
	 * @param requestMessage - request's message
	 * @param requestDate    - request's date
	 * @param requestStatus  - request's status
	 */
	public Request(int requestId, User requestUser, Flight requestFlight, String requestTopic, String requestMessage,
			Date requestDate, String requestStatus) {
		this.requestId = requestId;
		this.requestUser = requestUser;
		this.requestFlight = requestFlight;
		this.requestTopic = requestTopic;
		this.requestMessage = requestMessage;
		this.requestDate = requestDate;
		this.requestStatus = requestStatus;
	}

	/**
	 * Getter for request's id.
	 *
	 * @return request's id
	 */
	public int getRequestId() {
		return requestId;
	}

	/**
	 * Setter for request's id.
	 *
	 * @param requestId - request's id
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	/**
	 * Getter for request's user.
	 *
	 * @see User
	 * @return request's user
	 */
	public User getRequestUser() {
		return requestUser;
	}

	/**
	 * Setter for request's user.
	 *
	 * @see User
	 * @param requestUser - request's user
	 */
	public void setRequestUser(User requestUser) {
		this.requestUser = requestUser;
	}

	/**
	 * Getter for request's flight.
	 *
	 * @return request's flight
	 */
	public String getRequestMessage() {
		return requestMessage;
	}

	/**
	 * Setter for request's flight.
	 *
	 * @param requestMessage - request's flight
	 */
	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}

	/**
	 * Getter for request's topic.
	 *
	 * @see Flight
	 * @return request's topic
	 */
	public Flight getRequestFlight() {
		return requestFlight;
	}

	/**
	 * Setter for request's topic.
	 *
	 * @see Flight
	 * @param requestFlight - request's topic
	 */
	public void setRequestFlight(Flight requestFlight) {
		this.requestFlight = requestFlight;
	}

	/**
	 * Getter for request's message.
	 *
	 * @return request's message
	 */
	public String getRequestTopic() {
		return requestTopic;
	}

	/**
	 * Setter for request's message.
	 *
	 * @param requestTopic - request's message
	 */
	public void setRequestTopic(String requestTopic) {
		this.requestTopic = requestTopic;
	}

	/**
	 * Getter for request's date.
	 *
	 * @return request's date
	 */
	public Date getRequestDate() {
		return requestDate;
	}

	/**
	 * Setter for request's date.
	 *
	 * @param requestDate - request's date
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	/**
	 * Getter for request's status.
	 *
	 * @return request's status
	 */
	public String getRequestStatus() {
		return requestStatus;
	}

	/**
	 * Setter for request's status.
	 *
	 * @param requestStatus - request's status
	 */
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
}
