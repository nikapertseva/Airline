package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.Employee;
import ua.nure.pertseva.airline.entity.Flight;
import ua.nure.pertseva.airline.entity.managers.CrewManager;
import ua.nure.pertseva.airline.entity.managers.EmployeeManager;
import ua.nure.pertseva.airline.entity.managers.FlightManager;
import ua.nure.pertseva.airline.utils.Validator;

/**
 * Class for command of adding crew.
 *
 * @author Pertseva Veronika
 *
 */
public class AddCrewCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(AddCrewCommand.class);

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
		LOGGER.info("Executing add crew command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request, response);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Add crew command has been executed.");
		return path;
	}

	/**
	 * Method gets parameters employees id and flight's id, validates them and adds
	 * crew to data base.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return page's url
	 * @throws IOException
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean error = true;
		String[] employeesId = request.getParameterValues("employeesId");
		String flightId = request.getParameter("flightId");
		if (Validator.validateInt(flightId)) {
			Flight flight = FlightManager.getFlightById(flightId);
			if (!Objects.isNull(flight) && !Objects.isNull(employeesId)) {
				List<Employee> employees = EmployeeManager.getAllEmployee();
				for (String id : employeesId) {
					if (Validator.validateInt(id)) {
						Employee employee = employees.stream().filter((e) -> e.getEmployeeId() == Integer.parseInt(id))
								.findFirst().orElse(null);
						if (!Objects.isNull(employee)) {
							CrewManager.addCrew(id, flightId);
							error = false;
						}
					}
				}
			}
		}
		addError(error, "error.empty.choice", request);
		return Urls.REDIRECT_FLIGHT_INFO + "&id=" + flightId;
	}
}
