package ua.nure.pertseva.airline.entity.managers;

import java.sql.SQLException;
import java.util.List;
import ua.nure.pertseva.airline.dao.FlightDao;
import ua.nure.pertseva.airline.entity.Flight;

/**
 * Manager for calling flight's dao methods.
 *
 * @author Pertseva Veronika
 */
public class FlightManager {

	/**
	 * Flight's dao.
	 * 
	 * @see FlightDao
	 */
	private static FlightDao flightDao = new FlightDao();

	/**
	 * Calls the method for getting all flights from database.
	 *
	 * @see Flight
	 * @return list of flight's entity
	 */
	public static List<Flight> getAllFlights() {
		return flightDao.getAllFlights();
	}

	/**
	 * Calls the method for getting all searched flights from database.
	 *
	 * @param search - search
	 * @see Flight
	 * @return list of flight's entity
	 */
	public static List<Flight> getAllSearchedFlights(String search) {
		return flightDao.getAllSearchedFlights(search);
	}

	/**
	 * Calls the method for getting all citiesFrom from database.
	 *
	 * @return list of cities
	 */
	public static List<String> getAllCitiesFrom() {
		return flightDao.getAllCitiesFrom();
	}

	/**
	 * Calls the method for getting all citiesTo from database.
	 *
	 * @return list of cities
	 */
	public static List<String> getAllCitiesTo() {
		return flightDao.getAllCitiesTo();
	}

	/**
	 * Calls the method for getting flights by cities and date from database.
	 *
	 * @param cityFrom - from (city)
	 * @param cityTo   - to (city)
	 * @param date     - date
	 * @see Flight
	 * @return list of flight's entity
	 */
	public static List<Flight> getAllFlightsByCitiesAndDate(String cityFrom, String cityTo, String date) {
		return flightDao.getAllFlightsByCitiesAndDate(cityFrom, cityTo, date);
	}

	/**
	 * Calls the method for getting sorted flights from database.
	 *
	 * @param sort - sort
	 * @see Flight
	 * @return list of flight's entity
	 */
	public static List<Flight> getAllSortedFlights(String sort) {
		return flightDao.getAllSortedFlights(sort);
	}

	/**
	 * Calls the method for getting sorted flights by cities and date from database.
	 *
	 * @param cityFrom - from (city)
	 * @param cityTo   - to (city)
	 * @param date     - date
	 * @param sort     - sort
	 * @see Flight
	 * @return list of flight's entity
	 */
	public static List<Flight> getAllSortedFlightsByCitiesAndDate(String cityFrom, String cityTo, String date,
			String sort) {
		return flightDao.getAllSortedFlightsByCitiesAndDate(cityFrom, cityTo, date, sort);
	}

	/**
	 * Calls the method for getting sorted flights by search from database.
	 *
	 * @param search - search
	 * @param sort   - sort
	 * @see Flight
	 * @return list of flight's entity
	 */
	public static List<Flight> getSortedSearchedFlights(String search, String sort) {
		return flightDao.getSortedSearchedFlights(search, sort);
	}

	/**
	 * Calls the method for getting flight by id from database.
	 *
	 * @param id - flight's id
	 * @see Flight
	 * @return list of flight's entity
	 */
	public static Flight getFlightById(String id) {
		return flightDao.getFlightById(id);
	}

	/**
	 * Calls the method for adding flight to database.
	 *
	 * @param number        - number
	 * @param name          - name
	 * @param cityFrom      - cityFrom
	 * @param cityTo        - cityTo
	 * @param dateDeparture - date of departure
	 * @param dateArrival   - date of arrival
	 * @see Flight
	 */
	public static void addFlight(String number, String name, String cityFrom, String cityTo, String dateDeparture,
			String dateArrival) {
		flightDao.addFlight(number, name, cityFrom, cityTo, dateDeparture, dateArrival);

	}

	/**
	 * Calls the method for editing flight by id in database.
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
	public static void editFlight(String number, String name, String cityFrom, String cityTo, String dateDeparture,
			String dateArrival, String id) {
		flightDao.editFlight(number, name, cityFrom, cityTo, dateDeparture, dateArrival, id);

	}

	/**
	 * Calls the method for removing flight by id in database.
	 *
	 * @param id - flight's id
	 * @throws SQLException
	 * @see Flight
	 */
	public static void removeFlight(String id) throws SQLException {
		flightDao.removeFlight(id);

	}

	/**
	 * Calls the method for editing flight's status by id in database.
	 *
	 * @param status - new status
	 * @param id     - flight's id
	 * @see Flight
	 */
	public static void editFlightsStatus(String status, String id) {
		flightDao.editFlightsStatus(status, id);

	}

}
