package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Lists;
import ua.nure.pertseva.airline.entity.Flight;
import ua.nure.pertseva.airline.entity.managers.FlightManager;
import ua.nure.pertseva.airline.utils.Validator;

/**
 * The class for command of getting searched flights' list for dispatchers.
 *
 * @author Pertseva Veronika
 *
 */
public class GetSearchedFlightsListCommand extends GetFlightsAbstractCommand {

	/** Logger */
	private final Logger LOGGER = Logger.getLogger(GetSearchedFlightsListCommand.class);

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
		LOGGER.info("Executing get searched flights list command");
		String path = null;
		if (method.equals("GET")) {
			path = doGet(request);
		}
		LOGGER.info("Get searched flights list command has been executed.");
		return path;
	}

	/**
	 * The method gets parameters search and sort, validates it and returns path to
	 * page's file from method getPage.
	 *
	 * @param request - request
	 * @return path to page file
	 * @throws IOException
	 */
	private String doGet(HttpServletRequest request) {
		boolean error = true;
		String search = request.getParameter("value");
		String sort = request.getParameter("sort");
		List<Flight> flights = null;
		String parameters = "";
		if (Validator.validateText(search)) {
			parameters = "&value=" + search;
			if (!Objects.isNull(sort)) {
				if (Lists.SORTS.contains(sort)) {
					flights = FlightManager.getSortedSearchedFlights(search, sort);
					error = false;
				}
			} else {
				flights = FlightManager.getAllSearchedFlights(search);
				error = false;
			}
		}
		if (error) {
			flights = FlightManager.getAllFlights();
		}
		addError(error, "error.empty.input", request);

		return getPage(request, flights, parameters);

	}

}
