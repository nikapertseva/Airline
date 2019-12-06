package ua.khnucea.csit.cs.pertseva.airline.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The class for storage of constant's lists.
 *
 * @author Pertseva Veronika
 *
 */
public class Lists {

	/** List of employee's occupations */
	public static final List<String> OCCUPATIONS = new ArrayList<>(
			Arrays.asList("pilot", "navigator", "radio_operator", "stewardess"));

	/** List of flight's statuses */
	public static final List<String> FLIGHTS_STATUS = new ArrayList<>(Arrays.asList("boarding", "cancelled", "check_in",
			"scheduled", "delayed", "departed", "gate_open", "gate_closing", "gate_closed", "without_status"));

	/** List of request's statuses */
	public static final List<String> REQUESTS_STATUS = new ArrayList<>(Arrays.asList("awaiting", "done", "rejected"));

	/** List of sorts */
	public static final List<String> SORTS = new ArrayList<>(
			Arrays.asList("ascendingNumbers", "descendingNumbers", "ascendingNames", "descendingNames"));

	/** List of user's roles */
	public static final List<String> USERS_ROLES = new ArrayList<>(Arrays.asList("dispatcher", "administrator"));
}
