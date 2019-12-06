package ua.khnucea.csit.cs.pertseva.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.constants.Query;
import ua.khnucea.csit.cs.pertseva.airline.entity.Employee;

/**
 * The class is data access object of employee.
 *
 * @author Pertseva Veronika
 *
 */
public class EmployeeDao extends AbstractDao {
	/** Logger */
	public final static Logger LOGGER = Logger.getLogger(EmployeeDao.class);

	/**
	 * Getting available employees from database
	 *
	 * @param dateDeparture - date of departure
	 * @param dateArrival   - date of arrival
	 * @see Employee
	 * @return list of employee's entity
	 */
	public List<Employee> getAvailableEmployees(String dateDeparture, String dateArrival) {
		LOGGER.info("Getting available employees");
		List<Employee> employees = new ArrayList<>();
		List<Integer> id = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		LocalDate firstDate = LocalDate.parse(dateDeparture);
		LocalDate secondDate = LocalDate.parse(dateArrival).plusDays(1);
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_ALL_EMPLOYEES)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Employee employee = new Employee(resultSet.getInt("employee_id"),
						resultSet.getString("employee_surname"), resultSet.getString("employee_firstname"),
						resultSet.getString("employee_occupation"));
				Date flightDateDeparture = resultSet.getDate("flight_date_departure");
				Date flightDateArrival = resultSet.getDate("flight_date_arrival");
				if (Objects.isNull(flightDateDeparture)
						|| firstDate.isAfter(LocalDate.parse(flightDateDeparture.toString()).plusDays(1))
						|| secondDate.isBefore(LocalDate.parse(flightDateArrival.toString()))) {
					employees.add(employee);
				} else {
					id.add(resultSet.getInt("employee_id"));
				}

			}
			removeBusyEmployees(employees, id);
			removeSameEmployees(employees);
			LOGGER.info("Found: " + employees.size() + " available pilots");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}

		return employees;
	}

	/**
	 * Removing the same employees from employee's list
	 *
	 * @param employees - employee's list
	 */
	private void removeSameEmployees(List<Employee> employees) {
		int i = 1;
		while (i < employees.size()) {
			if (employees.get(i).getEmployeeId() == employees.get(i - 1).getEmployeeId()) {
				employees.remove(i);
			} else {
				i++;
			}
		}

	}

	/**
	 * Removing busy employees from employee's list
	 *
	 * @param employees - employee's list
	 * @param id        - list of id of busy employees
	 */
	private void removeBusyEmployees(List<Employee> employees, List<Integer> id) {
		Iterator<Employee> employeesIterator = employees.iterator();
		while (employeesIterator.hasNext()) {
			Employee employee = employeesIterator.next();
			if (id.contains(employee.getEmployeeId())) {
				employeesIterator.remove();
			}

		}

	}

	/**
	 * Getting employee by id from database
	 *
	 * @param id - employee's id
	 * @see Employee
	 * @return employee's entity
	 */
	public Employee getEmployeeById(String id) {
		LOGGER.info("Getting employee by id: " + id);
		Employee employee = null;
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_EMPLOYEE_BY_ID)) {
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employee = new Employee(resultSet.getInt("employee_id"), resultSet.getString("employee_surname"),
						resultSet.getString("employee_firstname"), resultSet.getString("employee_occupation"));
				LOGGER.info("Found: " + employee.getEmployeeId());
			}

		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return employee;
	}

	/**
	 * Getting all employees from database
	 *
	 * @see Employee
	 * @return list of employee's entity
	 */
	public List<Employee> getAllEmployee() {
		LOGGER.info("Getting all employees");
		List<Employee> employees = new ArrayList<>();
		Connection connection = ConnectingPool.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_GET_ALL_EMPLOYEES)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Employee employee = new Employee(resultSet.getInt("employee_id"),
						resultSet.getString("employee_surname"), resultSet.getString("employee_firstname"),
						resultSet.getString("employee_occupation"));

				employees.add(employee);

			}
			LOGGER.info("Found: " + employees.size() + " employees");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);

		}
		return employees;
	}

	/**
	 * Adding employee to database
	 *
	 * @param surname    - surname
	 * @param firstname  - firstname
	 * @param occupation - occupation
	 * @see Employee
	 */
	public void addEmployee(String surname, String firstname, String occupation) {
		LOGGER.info("Adding new employee");
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_ADD_EMPLOYEE);
			preparedStatement.setString(1, surname);
			preparedStatement.setString(2, firstname);
			preparedStatement.setString(3, occupation);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Employee has been added");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}

	}

	/**
	 * Editing employee in database
	 *
	 * @param surname    - surname
	 * @param firstname  - firstname
	 * @param occupation - occupation
	 * @param id         - employee's id
	 * @see Employee
	 */
	public void editEmployee(String surname, String firstname, String occupation, String id) {
		LOGGER.info("Editing employee by id: " + id);
		Connection connection = ConnectingPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.SQL_EDIT_EMPLOYEE);
			preparedStatement.setString(1, surname);
			preparedStatement.setString(2, firstname);
			preparedStatement.setString(3, occupation);
			preparedStatement.setString(4, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			LOGGER.info("Employee has been edited");
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			closeConnection(connection);
		}

	}

	/**
	 * Removing employee from database
	 *
	 * @param id - employee's id
	 * @throws SQLException
	 * @see Employee
	 */
	public void removeEmployee(String id) throws SQLException {
		LOGGER.info("Removing employee by id: " + id);
		Connection connection = ConnectingPool.getConnection();
		PreparedStatement removeCrew = null;
		PreparedStatement removeEmployee = null;
		try {
			connection.setAutoCommit(false);
			removeCrew = connection.prepareStatement(Query.SQL_REMOVE_CREW_BY_EMPLOYEE_ID);
			removeEmployee = connection.prepareStatement(Query.SQL_REMOVE_EMPLOYEE);
			removeCrew.setString(1, id);
			removeCrew.executeUpdate();
			removeEmployee.setString(1, id);
			removeEmployee.executeUpdate();
			connection.commit();
			LOGGER.info("Employee has been removed");
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			try {
				LOGGER.info("Transaction is being rolled back");
				connection.rollback();
			} catch (SQLException e1) {
				LOGGER.error(e1.getMessage());
			}

		} finally {
			if (!Objects.isNull(removeCrew)) {
				removeCrew.close();
			}
			if (!Objects.isNull(removeEmployee)) {
				removeEmployee.close();
			}
			connection.setAutoCommit(true);
			closeConnection(connection);
		}

	}

}
