package ua.nure.pertseva.airline.entity;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CrewTest {
	private Crew crew;
	
	@Before
	public void testCrew() {
		Flight flight = new Flight(0, null, null, null, null, null, null, null, null, null);
		Employee employee = new Employee(0, null, null, null);
		crew = new Crew(1, employee, flight);
	}
	
	
	@Test
	public void testGetCrewId() {
		int id = crew.getCrewId();
		assertEquals(id, 1);
	}

	@Test
	public void testSetUserId() {
		crew.setCrewId(2);
		int id = crew.getCrewId();
		assertEquals(id, 2);
	}

	@Test
	public void testGetCrewEmployee() {
		Employee employee = crew.getCrewEmployee();
		assertEquals(employee.getClass(), Employee.class);
	}
	
	@Test 
	public void testSetCrewEmployee() {
		crew.setCrewEmployee(new Employee(1, null, null, null));
		Employee employee = crew.getCrewEmployee();
		assertEquals(employee.getEmployeeId(), 1);
	}
	
	@Test
	public void testGetCrewFlight() {
		Flight flight = crew.getCrewFlight();
		assertEquals(flight.getClass(), Flight.class);
	}
	
	@Test 
	public void testSetCrewFlight() {
		crew.setCrewFlight(new Flight(1, null, null, null, null, null, null, null, null, null));
		Flight flight = crew.getCrewFlight();
		assertEquals(flight.getFlightId(), 1);
	}
	

}
