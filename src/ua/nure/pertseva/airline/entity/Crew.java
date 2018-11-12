package ua.nure.pertseva.airline.entity;

/**
 * The class is crew's entity.
 *
 * @author Pertseva Veronika
 *
 */
public class Crew {

	/** Crew's id. */
	private int crewId;
	/** Crew's employee. */
	private Employee crewEmployee;
	/** Crew's flight. */
	private Flight crewFlight;

	/**
	 * Constructor.
	 *
	 * @param crewId       - crew's id
	 * @param crewEmployee - crew's employee
	 * @param crewFlight   - crew's flight
	 */
	public Crew(int crewId, Employee crewEmployee, Flight crewFlight) {
		this.crewId = crewId;
		this.crewEmployee = crewEmployee;
		this.crewFlight = crewFlight;
	}

	/**
	 * Getter for crew's id.
	 *
	 * @return crew's id
	 */
	public int getCrewId() {
		return crewId;
	}

	/**
	 * Setter for crew's id.
	 *
	 * @param crewId - new crew's id
	 */
	public void setCrewId(int crewId) {
		this.crewId = crewId;
	}

	/**
	 * Getter for crew's employee.
	 *
	 * @see Employee
	 * @return crew's employee
	 */
	public Employee getCrewEmployee() {
		return crewEmployee;
	}

	/**
	 * Setter for crew's employee.
	 *
	 * @see Employee
	 * @param crewEmployee - new crew's employee
	 */
	public void setCrewEmployee(Employee crewEmployee) {
		this.crewEmployee = crewEmployee;
	}

	/**
	 * Getter for crew's flight.
	 *
	 * @see Flight
	 * @return crew's flight
	 */
	public Flight getCrewFlight() {
		return crewFlight;
	}

	/**
	 * Setter for crew's flight.
	 *
	 * @see Flight
	 * @param crewFlight - new crew's flight
	 */
	public void setCrewFlight(Flight crewFlight) {
		this.crewFlight = crewFlight;
	}
}
