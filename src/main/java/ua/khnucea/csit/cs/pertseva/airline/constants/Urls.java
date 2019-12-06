package ua.khnucea.csit.cs.pertseva.airline.constants;

/**
 * The class for storage of constant's urls.
 *
 * @author Pertseva Veronika
 *
 */
public class Urls {

	public static final String PAGE_LIST_FLIGHTS = "WEB-INF/jsp/flights.jsp";
	public static final String PAGE_LIST_EMPLOYEES = "WEB-INF/jsp/employeesAdmin.jsp";
	public static final String PAGE_FLIGHT_INFO = "WEB-INF/jsp/flightInfo.jsp";
	public static final String PAGE_LIST_REQUESTS = "WEB-INF/jsp/requestsAdmin.jsp";
	public static final String PAGE_FLIGHTS_ADMIN = "WEB-INF/jsp/flightsAdmin.jsp";
	public static final String PAGE_EDIT_FLIGHT = "WEB-INF/jsp/editFlight.jsp";
	public static final String PAGE_EDIT_EMPLOYEE = "WEB-INF/jsp/editEmployee.jsp";
	public static final String PAGE_LIST_USERS = "WEB-INF/jsp/usersAdmin.jsp";

	public static final String REDIRECT_LOGIN_PAGE = "/airline/";
	public static final String REDIRECT_FLIGHTS_LIST = "/airline/controller?command=flights";
	public static final String REDIRECT_ERROR_PAGE = "/airline/controller?";
	public static final String REDIRECT_FLIGHT_INFO = "/airline/controller?command=flightInfo";
	public static final String REDIRECT_ADMIN_PANEL = "/airline/controller?command=flightsAdmin";
	public static final String REDIRECT_LIST_EMPLOYEES = "/airline/controller?command=employeesAdmin";
	public static final String REDIRECT_LIST_REQUESTS = "/airline/controller?command=requestsAdmin";
	public static final String REDIRECT_EDIT_EMPLOYEE = "/airline/controller?command=pageEditEmployee";
	public static final String REDIRECT_EDIT_FLIGHT = "/airline/controller?command=pageEditFlight";
	public static final String REDIRECT_LIST_USERS = "/airline/controller?command=usersAdmin";

	public static final String ERROR_PAGE = "WEB-INF/jsp/errorPage.jsp";

}
