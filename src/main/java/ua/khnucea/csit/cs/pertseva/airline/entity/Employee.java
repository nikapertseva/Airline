package ua.khnucea.csit.cs.pertseva.airline.entity;

/**
 * The class is employee's entity.
 *
 * @author Pertseva Veronika
 *
 */
public class Employee {

	/** Employee's id. */
	private int employeeId;
	/** Employee's surname. */
	private String employeeSurname;
	/** Employee's firstname. */
	private String employeeFirstname;
	/** Employee's occupation. */
	private String employeeOccupation;

	/**
	 * Constructor.
	 *
	 * @param employeeId         - employee's id
	 * @param employeeSurname    - employee's surname
	 * @param employeeFirstname  - employee's firstname
	 * @param employeeOccupation - employee's occupation
	 */
	public Employee(int employeeId, String employeeSurname, String employeeFirstname, String employeeOccupation) {
		this.employeeId = employeeId;
		this.employeeSurname = employeeSurname;
		this.employeeFirstname = employeeFirstname;
		this.employeeOccupation = employeeOccupation;
	}

	/**
	 * Getter for employee's id.
	 *
	 * @return employee's id
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Setter for employee's id.
	 *
	 * @param employeeId - employee's id
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Getter for employee's surname.
	 *
	 * @return employee's surname
	 */
	public String getEmployeeSurname() {
		return employeeSurname;
	}

	/**
	 * Setter for employee's surname.
	 *
	 * @param employeeSurname - employee's surname
	 */
	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}

	/**
	 * Getter for employee's firstname.
	 *
	 * @return employee's firstname
	 */
	public String getEmployeeFirstname() {
		return employeeFirstname;
	}

	/**
	 * Setter for employee's firstname.
	 *
	 * @param employeeFirstname - employee's firstname
	 */
	public void setEmployeeFirstname(String employeeFirstname) {
		this.employeeFirstname = employeeFirstname;
	}

	/**
	 * Getter for employee's occupation.
	 *
	 * @return employee's occupation
	 */
	public String getEmployeeOccupation() {
		return employeeOccupation;
	}

	/**
	 * Setter for employee's occupation.
	 *
	 * @param employeeOccupation - employee's occupation
	 */
	public void setEmployeeOccupation(String employeeOccupation) {
		this.employeeOccupation = employeeOccupation;
	}

}
