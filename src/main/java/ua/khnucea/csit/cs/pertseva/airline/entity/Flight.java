package ua.khnucea.csit.cs.pertseva.airline.entity;

import java.sql.Time;
import java.util.Date;

/**
 * The class is flight's entity.
 *
 * @author Pertseva Veronika
 *
 */
public class Flight {

	/** Flight's id. */
	private int flightId;

	/** Flight's number. */
	private String flightNumber;

	/** Flight's name. */
	private String flightName;

	/** Flight from (city). */
	private String flightCityFrom;

	/** Flight to (city). */
	private String flightCityTo;

	/** Flight's date of departure. */
	private Date flightDateDeparture;

	/** Flight's time of departure. */
	private Time flightTimeDeparture;

	/** Flight's date of arrival. */
	private Date flightDateArrival;

	/** Flight's time of arrival. */
	private Time flightTimeArrival;

	/** Flight's status. */
	private String flightStatus;

	/**
	 * Constructor.
	 *
	 * @param flightId            - flight's id
	 * @param flightNumber        - flight's number
	 * @param flightName          - flight's name
	 * @param flightCityFrom      - flight from (city)
	 * @param flightCityTo        - flight to (city)
	 * @param flightDateDeparture - flight's date of departure
	 * @param flightTimeDeparture - flight's time of departure
	 * @param flightDateArrival   - flight's date of arrival
	 * @param flightTimeArrival   - flight's time of arrival
	 * @param flightStatus        - flight's status
	 */
	public Flight(int flightId, String flightNumber, String flightName, String flightCityFrom, String flightCityTo,
			Date flightDateDeparture, Time flightTimeDeparture, Date flightDateArrival, Time flightTimeArrival,
			String flightStatus) {
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.flightCityFrom = flightCityFrom;
		this.flightCityTo = flightCityTo;
		this.flightDateDeparture = flightDateDeparture;
		this.flightTimeDeparture = flightTimeDeparture;
		this.flightDateArrival = flightDateArrival;
		this.flightTimeArrival = flightTimeArrival;
		this.flightStatus = flightStatus;

	}

	/**
	 * Getter for flight's id.
	 *
	 * @return flight's id
	 */
	public int getFlightId() {
		return flightId;
	}

	/**
	 * Setter for flight's id
	 *
	 * @param flightId - flight's id
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	/**
	 * Getter for flight's number.
	 *
	 * @return flight's number
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * Setter for flight's number.
	 *
	 * @param flightNumber - flight's number
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * Getter for flight's name.
	 *
	 * @return flight's name
	 */
	public String getFlightName() {
		return flightName;
	}

	/**
	 * Setter for flight's name.
	 *
	 * @param flightName - flight's name
	 */
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	/**
	 * Getter for flight from (city).
	 *
	 * @return flight from (city)
	 */
	public String getFlightCityFrom() {
		return flightCityFrom;
	}

	/**
	 * Setter for flight from (city).
	 *
	 * @param flightCityFrom - flight from (city)
	 */
	public void setFlightCityFrom(String flightCityFrom) {
		this.flightCityFrom = flightCityFrom;
	}

	/**
	 * Getter for flight to (city).
	 *
	 * @return flight to (city)
	 */
	public String getFlightCityTo() {
		return flightCityTo;
	}

	/**
	 * Setter for flight to (city).
	 *
	 * @param flightCityTo - flight to (city)
	 */
	public void setFlightCityTo(String flightCityTo) {
		this.flightCityTo = flightCityTo;
	}

	/**
	 * Getter for flight's date of departure.
	 *
	 * @return flight's date of departure
	 */
	public Date getFlightDateDeparture() {
		return flightDateDeparture;
	}

	/**
	 * Setter for flight's date of departure.
	 *
	 * @param flightDateDeparture - flight's time of departure
	 */
	public void setFlightDateDeparture(Date flightDateDeparture) {
		this.flightDateDeparture = flightDateDeparture;
	}

	/**
	 * Getter for flight's time of departure.
	 *
	 * @return flight's time of departure
	 */
	public Time getFlightTimeDeparture() {
		return flightTimeDeparture;
	}

	/**
	 * Setter for flight's time of departure.
	 *
	 * @param flightDate - flight's time of departure
	 */
	public void setFlightTimeDeparture(Time flightTimeDeparture) {
		this.flightTimeDeparture = flightTimeDeparture;
	}

	/**
	 * Getter for flight's date of arrival.
	 *
	 * @return flight's date of arrival
	 */
	public Date getFlightDateArrival() {
		return flightDateArrival;
	}

	/**
	 * Setter for flight's date of arrival.
	 *
	 * @param flightDateArrival - flight's date of arrival
	 */
	public void setFlightDateArrival(Date flightDateArrival) {
		this.flightDateArrival = flightDateArrival;
	}

	/**
	 * Getter for flight's time of arrival.
	 *
	 * @return flight's time of arrival
	 */
	public Time getFlightTimeArrival() {
		return flightTimeArrival;
	}

	/**
	 * Setter for flight's time of arrival.
	 *
	 * @param flightTimeArrival - flight's time of arrival
	 */
	public void setFlightTimeArrival(Time flightTimeArrival) {
		this.flightTimeArrival = flightTimeArrival;
	}

	/**
	 * Getter for flight's status.
	 *
	 * @return flight's status
	 */
	public String getFlightStatus() {
		return flightStatus;
	}

	/**
	 * Setter for flight's status.
	 *
	 * @param flightStatus - flight's status
	 */
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

}
