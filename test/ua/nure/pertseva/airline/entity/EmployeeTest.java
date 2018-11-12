package ua.nure.pertseva.airline.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	
	private Employee employee;

	@Before
	public void testEmployee() {
		employee = new Employee(1, "surname", "firstname", "occupation");
	}

	@Test
	public void testGetEmployeeId() {
		int id = employee.getEmployeeId();
		assertEquals(id, 1);
	}

	@Test
	public void testSetEmployeeId() {
		employee.setEmployeeId(2);
		int id = employee.getEmployeeId();
		assertEquals(id, 2);
	}

	@Test
	public void testGetEmployeeSurname() {
		String surname = employee.getEmployeeSurname();
		assertEquals(surname, "surname");
	}

	@Test
	public void testSetEmployeeSurname() {
		employee.setEmployeeSurname("newSurname");
		String surname = employee.getEmployeeSurname();
		assertEquals(surname, "newSurname");
	}

	@Test
	public void testGetEmployeeFirstname() {
		String firstname = employee.getEmployeeFirstname();
		assertEquals(firstname, "firstname");
	}

	@Test
	public void testSetEmployeeFirstname() {
		employee.setEmployeeFirstname("newFirstname");
		String firstname = employee.getEmployeeFirstname();
		assertEquals(firstname, "newFirstname");
	}

	@Test
	public void testGetEmployeeOccupation() {
		String occupation = employee.getEmployeeOccupation();
		assertEquals(occupation, "occupation");
	}
	
	@Test
	public void testSetEmployeeOccupation() {
		employee.setEmployeeOccupation("newOccupation");
		String occupation = employee.getEmployeeOccupation();
		assertEquals(occupation, "newOccupation");
	}
}
