package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Lists;
import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.Request;
import ua.nure.pertseva.airline.entity.Crew;
import ua.nure.pertseva.airline.entity.Employee;
import ua.nure.pertseva.airline.entity.Flight;
import ua.nure.pertseva.airline.entity.managers.RequestManager;
import ua.nure.pertseva.airline.entity.managers.CrewManager;
import ua.nure.pertseva.airline.entity.managers.EmployeeManager;
import ua.nure.pertseva.airline.entity.managers.FlightManager;
import ua.nure.pertseva.airline.utils.Validator;

/**
 * The class for command of getting information about flight for page flight's
 * info.
 *
 * @author Pertseva Veronika
 *
 */
public class GetFlightsInfoCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(GetFlightsInfoCommand.class);

	/**
	 * Method for command's executing.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return page's url
	 * @throws IOException
	 */
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response, String method)
			throws IOException {
		LOGGER.info("Executing get flight by id command");
		String path = null;
		if (method.equals("GET")) {
			path = doGet(request);
		}
		LOGGER.info("Get flight by id command has been executed.");
		return path;
	}

	/**
	 * The method gets parameter id, validates it, sets attribute flightStatus,
	 * statuses, requests, pilots, radioOperators, navigators, stewardesses,
	 * availablePilots, availableRadioOperators, availableNavigators,
	 * availableStewardesses and flightId and returns path to page's file.
	 *
	 * @param request - request
	 * @return path to page file
	 * @throws IOException
	 */
	private String doGet(HttpServletRequest request) {
		boolean error = true;
		String id = request.getParameter("id");
		if (Validator.validateInt(id)) {
			Flight flight = FlightManager.getFlightById(id);
			if (!Objects.isNull(flight)) {
				List<Crew> crew = CrewManager.getAllCrewByFlightId(id);
				List<Employee> availableEmployees = EmployeeManager.getAvailableEmployees(
						flight.getFlightDateDeparture().toString(), flight.getFlightDateArrival().toString());
				List<String> statuses = new ArrayList<>();
				List<Request> requests = RequestManager.getRequestByFligthsId(id);
				statuses = Lists.FLIGHTS_STATUS.stream().filter((s) -> !s.equals(flight.getFlightStatus()))
						.collect(Collectors.toList());
				request.getSession().setAttribute("flightStatus", flight.getFlightStatus());
				request.getSession().setAttribute("statuses", statuses);
				request.getSession().setAttribute("requests", requests);
				request.getSession().setAttribute("pilots",
						crew.stream().filter((c) -> c.getCrewEmployee().getEmployeeOccupation().equals("pilot"))
								.collect(Collectors.toList()));
				request.getSession().setAttribute("radioOperators",
						crew.stream()
								.filter((c) -> c.getCrewEmployee().getEmployeeOccupation().equals("radio_operator"))
								.collect(Collectors.toList()));
				request.getSession().setAttribute("navigators",
						crew.stream().filter((c) -> c.getCrewEmployee().getEmployeeOccupation().equals("navigator"))
								.collect(Collectors.toList()));
				request.getSession().setAttribute("stewardesses",
						crew.stream().filter((c) -> c.getCrewEmployee().getEmployeeOccupation().equals("stewardess"))
								.collect(Collectors.toList()));
				request.getSession().setAttribute("availablePilots", availableEmployees.stream()
						.filter((e) -> e.getEmployeeOccupation().equals("pilot")).collect(Collectors.toList()));
				request.getSession().setAttribute("availableRadioOperators",
						availableEmployees.stream().filter((e) -> e.getEmployeeOccupation().equals("radio_operator"))
								.collect(Collectors.toList()));
				request.getSession().setAttribute("availableNavigators", availableEmployees.stream()
						.filter((e) -> e.getEmployeeOccupation().equals("navigator")).collect(Collectors.toList()));
				request.getSession().setAttribute("availableStewardesses", availableEmployees.stream()
						.filter((e) -> e.getEmployeeOccupation().equals("stewardess")).collect(Collectors.toList()));
				request.getSession().setAttribute("flightId", id);
				error = false;
			}

		}
		if (error) {
			return Urls.ERROR_PAGE;
		} else {
			return Urls.PAGE_FLIGHT_INFO;
		}

	}

}
