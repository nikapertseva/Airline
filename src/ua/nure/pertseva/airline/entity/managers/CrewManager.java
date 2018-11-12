package ua.nure.pertseva.airline.entity.managers;

import java.util.List;

import ua.nure.pertseva.airline.dao.CrewDao;
import ua.nure.pertseva.airline.entity.Crew;

/**
 * Manager for calling crew's dao methods.
 *
 * @author Pertseva Veronika
 *
 */
public class CrewManager {
	/**
	 * Crew's dao.
	 *
	 * @see CrewDao
	 */
	private static CrewDao crewDao = new CrewDao();

	/**
	 * Calls the method for getting all crew by flight's id from database.
	 *
	 * @param id - flight's id
	 * @return list of crew's entity
	 */
	public static List<Crew> getAllCrewByFlightId(String id) {
		return crewDao.getAllCrewByFlightId(id);
	}

	/**
	 * Calls the method for adding crew to database.
	 *
	 * @param id       - employee's id
	 * @param flightId - flight's id
	 */
	public static void addCrew(String id, String flightId) {
		crewDao.addCrew(id, flightId);

	}

	/**
	 * Calls the method for getting crew by id from database.
	 *
	 * @param crewId
	 * @return crew's entity
	 */
	public static Crew getCrewById(String crewId) {
		return crewDao.getCrewById(crewId);
	}

	/**
	 * Calls the method for removing crew by id from database.
	 *
	 * @param crewId - crew's id
	 */
	public static void removeCrew(String crewId) {
		crewDao.removeCrew(crewId);

	}

	/**
	 * Calls the method for removing crew by flight's id from database.
	 *
	 * @param id - flight's id
	 */
	public static void removeCrewByFlightId(String id) {
		crewDao.removeCrewByFlightId(id);

	}

	/**
	 * Calls the method for removing crew by employee's id from database.
	 *
	 * @param id - employee's id
	 */
	public static void removeCrewByEmployeeId(String id) {
		crewDao.removeCrewByEmployeeId(id);

	}

}
