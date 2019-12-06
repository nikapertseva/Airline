package ua.khnucea.csit.cs.pertseva.airline.entity.managers;

import java.sql.SQLException;
import java.util.List;

import ua.khnucea.csit.cs.pertseva.airline.dao.EmployeeDao;
import ua.khnucea.csit.cs.pertseva.airline.entity.Employee;

/**
 * Manager for calling employee's dao methods.
 *
 * @author Pertseva Veronika
 *
 */
public class EmployeeManager {

	/**
	 * Employee's dao.
	 *
	 * @see EmployeeDao
	 */
	private static EmployeeDao employeeDao = new EmployeeDao();

	/**
	 * Calls the method for getting available employees from database.
	 *
	 * @param dateDeparted - date of departure
	 * @param dateArrival   - date of arrival
	 * @return list of employee's entity
	 */
	public static List<Employee> getAvailableEmployees(String dateDeparted, String dateArrival) {
		return employeeDao.getAvailableEmployees(dateDeparted, dateArrival);
	}

	/**
	 * Calls the method for getting employee by id from database.
	 *
	 * @param id - employee's id
	 * @see Employee
	 * @return employee's entity
	 */
	public static Employee getEmployeeById(String id) {
		return employeeDao.getEmployeeById(id);
	}

	/**
	 * Calls the method for getting all employees from database.
	 *
	 * @see Employee
	 * @return list of employee's entity
	 */
	public static List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	/**
	 * Calls the method for adding employee to database.
	 *
	 * @param surname    - surname
	 * @param firstname  - firstname
	 * @param occupation - occupation
	 * @see Employee
	 */
	public static void addEmployee(String surname, String firstname, String occupation) {
		employeeDao.addEmployee(surname, firstname, occupation);

	}

	/**
	 * Calls the method for editing employee in database.
	 *
	 * @param surname    - surname
	 * @param firstname  - firstname
	 * @param occupation - occupation
	 * @param id         - employee's id
	 * @see Employee
	 */
	public static void editEmployee(String surname, String firstname, String occupation, String id) {
		employeeDao.editEmployee(surname, firstname, occupation, id);

	}

	/**
	 * Calls the method for removing employee from database.
	 *
	 * @param id - employee's id
	 * @throws SQLException
	 * @see Employee
	 */
	public static void removeEmployee(String id) throws SQLException {
		employeeDao.removeEmployee(id);

	}

}
