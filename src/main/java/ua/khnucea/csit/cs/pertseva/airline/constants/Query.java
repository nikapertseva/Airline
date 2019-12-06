package ua.khnucea.csit.cs.pertseva.airline.constants;

/**
 * The class for storage of constant's query.
 *
 * @author Pertseva Veronika
 *
 */
public class Query {
	public static final String SQL_GET_ALL_FLIGHTS = "SELECT * FROM airline.flights";
	public static final String SQL_GET_ALL_CITIES_FROM = "SELECT flight_city_from FROM airline.flights";
	public static final String SQL_GET_ALL_CITIES_TO = "SELECT flight_city_to FROM airline.flights";
	public static final String SQL_GET_ALL_CREW_BY_FLIGHT_ID = "SELECT * FROM airline.crew INNER JOIN  airline.flights ON crew.crew_flight = flights.flight_id INNER JOIN  airline.employees ON crew.crew_employee = employees.employee_id WHERE flights.flight_id = ?";
	public static final String SQL_GET_ALL_EMPLOYEES = "SELECT * FROM airline.employees LEFT JOIN airline.crew ON employees.employee_id = crew.crew_employee LEFT JOIN airline.flights ON flights.flight_id = crew.crew_flight";
	public static final String SQL_GET_ALL_REQUESTS = "SELECT * FROM airline.requests INNER JOIN airline.users ON users.user_id = requests.request_user INNER JOIN airline.flights ON flights.flight_id = requests.request_flight";
	public static final String SQL_GET_ALL_USERS = "SELECT * FROM airline.users";

	public static final String SQL_GET_FLIGHT_BY_ID = "SELECT * FROM airline.flights WHERE flight_id = ?";
	public static final String SQL_GET_FLIGHTS_BY_SEARCH = "SELECT * FROM airline.flights WHERE flight_number LIKE ?";
	public static final String SQL_GET_FLIGHTS_BY_CITIES_AND_DATE = "SELECT * FROM airline.flights WHERE flight_city_from Like ? AND flight_city_to Like ? AND flight_date_departure LIKE ?";
	public static final String SQL_GET_FLIGHTS_SORTED_BY_NUMBER_ASC = "SELECT * FROM airline.flights ORDER BY flight_number";
	public static final String SQL_GET_FLIGHTS_SORTED_BY_NUMBER_DESC = "SELECT * FROM airline.flights ORDER BY flight_number DESC";
	public static final String SQL_GET_FLIGHTS_SORTED_BY_NAME_ASC = "SELECT * FROM airline.flights ORDER BY flight_name";
	public static final String SQL_GET_FLIGHTS_SORTED_BY_NAME_DESC = "SELECT * FROM airline.flights ORDER BY flight_name DESC";
	public static final String SQL_GET_FLIGHTS_BY_CITIES_AND_DATE_SORTED_BY_NUMBER_ASC = "SELECT * FROM airline.flights WHERE flight_city_from Like ? AND flight_city_to Like ? AND flight_date_departure LIKE ? ORDER BY flight_number";
	public static final String SQL_GET_FLIGHTS_BY_CITIES_AND_DATE_SORTED_BY_NUMBER_DESC = "SELECT * FROM airline.flights WHERE flight_city_from Like ? AND flight_city_to Like ? AND flight_date_departure LIKE ? ORDER BY flight_number DESC";
	public static final String SQL_GET_FLIGHTS_BY_CITIES_AND_DATE_SORTED_BY_NAME_ASC = "SELECT * FROM airline.flights WHERE flight_city_from Like ? AND flight_city_to Like ? AND flight_date_departure LIKE ? ORDER BY flight_name";
	public static final String SQL_GET_FLIGHTS_BY_CITIES_AND_DATE_SORTED_BY_NAME_DESC = "SELECT * FROM airline.flights WHERE flight_city_from Like ? AND flight_city_to Like ? AND flight_date_departure LIKE ? ORDER BY flight_name DESC";
	public static final String SQL_GET_FLIGHTS_BY_SEARCH_BY_NUMBER_ASC = "SELECT * FROM airline.flights WHERE flight_number LIKE ? ORDER BY flight_number";
	public static final String SQL_GET_FLIGHTS_BY_SEARCH_SORTED_BY_NUMBER_DESC = "SELECT * FROM airline.flights WHERE flight_number LIKE ? ORDER BY flight_number DESC";
	public static final String SQL_GET_FLIGHTS_BY_SEARCH_SORTED_BY_NAME_ASC = "SELECT * FROM airline.flights WHERE flight_number LIKE ? ORDER BY flight_name";
	public static final String SQL_GET_FLIGHTS_BY_SEARCH_SORTED_BY_NAME_DESC = "SELECT * FROM airline.flights WHERE flight_number LIKE ? ORDER BY flight_name DESC";
	public static final String SQL_GET_USER_BY_EMAIL = "SELECT * FROM airline.users WHERE user_email = ?";
	public static final String SQL_GET_USER_BY_ID = "SELECT * FROM airline.users WHERE user_id = ?";
	public static final String SQL_GET_EMPLOYEE_BY_ID = "SELECT * FROM airline.employees WHERE employees.employee_id = ?";
	public static final String SQL_GET_CREW_BY_ID = "SELECT * FROM airline.crew INNER JOIN  airline.flights ON crew.crew_flight = flights.flight_id INNER JOIN  airline.employees ON crew.crew_employee = employees.employee_id WHERE crew.crew_id = ?";
	public static final String SQL_GET_REQUESTS_BY_FLIGHT_ID = "SELECT * FROM airline.requests INNER JOIN airline.users ON users.user_id = requests.request_user INNER JOIN airline.flights ON flights.flight_id = requests.request_flight WHERE requests.request_flight = ?";
	public static final String SQL_GET_REQUESTS_BY_ID = "SELECT * FROM airline.requests INNER JOIN airline.users ON users.user_id = requests.request_user INNER JOIN airline.flights ON flights.flight_id = requests.request_flight WHERE requests.request_id = ?";

	public static final String SQL_ADD_EMPLOYEE = "INSERT INTO airline.employees(employee_surname, employee_firstname, employee_occupation) VALUES (?,?,?)";
	public static final String SQL_ADD_CREW = "INSERT INTO airline.crew(crew_employee, crew_flight) VALUES (?,?)";
	public static final String SQL_ADD_REQUEST = "INSERT INTO airline.requests(request_user, request_flight, request_topic, request_message, request_status) VALUES (?,?,?,?,'awaiting')";
	public static final String SQL_ADD_FLIGHT = "INSERT INTO airline.flights(flight_number, flight_name, flight_city_from, flight_city_to, flight_date_departure, flight_date_arrival, flight_status) VALUES (?,?,?,?,?,?,'without_status')";
	public static final String SQL_ADD_USER = "INSERT INTO airline.users(user_email, user_password, user_role) VALUES (?,?,?)";

	public static final String SQL_EDIT_EMPLOYEE = "UPDATE airline.employees SET employee_surname = ?, employee_firstname = ?, employee_occupation =?  WHERE employee_id = ?";
	public static final String SQL_EDIT_FLIGHT = "UPDATE airline.flights SET flight_number = ?, flight_name = ?, flight_city_from =?, flight_city_to = ?, flight_date_departure = ?, flight_date_arrival = ?  WHERE flight_id = ?";
	public static final String SQL_EDIT_FLIGHTS_STATUS = "UPDATE airline.flights SET flight_status = ? WHERE flight_id = ?";
	public static final String SQL_EDIT_REQUEST_STATUS = "UPDATE airline.requests SET request_status = ? WHERE request_id = ?";;

	public static final String SQL_REMOVE_CREW_BY_EMPLOYEE_ID = "DELETE  FROM airline.crew WHERE crew.crew_employee= ?";
	public static final String SQL_REMOVE_EMPLOYEE = "DELETE  FROM airline.employees WHERE employees.employee_id = ?";
	public static final String SQL_REMOVE_CREW = "DELETE  FROM airline.crew WHERE crew.crew_id= ?";
	public static final String SQL_REMOVE_REQUESTS_BY_FLIGHT_ID = "DELETE  FROM airline.requests WHERE requests.request_flight= ?";
	public static final String SQL_REMOVE_CREW_BY_FLIGHT_ID = "DELETE  FROM airline.crew WHERE crew.crew_flight= ?";
	public static final String SQL_REMOVE_FLIGHT = "DELETE  FROM airline.flights WHERE flights.flight_id = ?";
	public static final String SQL_REMOVE_REQUESTS_BY_USER_ID = "DELETE  FROM airline.requests WHERE requests.request_user= ?";
	public static final String SQL_REMOVE_USER = "DELETE  FROM airline.users WHERE users.user_id = ?";

}
