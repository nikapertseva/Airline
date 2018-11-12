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
 * The class for command of getting flight's selection for dispatchers.
 *
 * @author Pertseva Veronika
 *
 */
public class GetFlightsSelectionCommand extends GetFlightsAbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(GetFlightsSelectionCommand.class);

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
		LOGGER.info("Executing get flights selection command");
		String path = null;
		if (method.equals("GET")) {
			path = doGet(request);
		}
		LOGGER.info("Get flights selection command has been executed.");
		return path;
	}

	/**
	 * The method gets parameters cityFrom, cityTo, date and sort, validates them
	 * and returns path to page's file from method getPage.
	 *
	 * @param request - request
	 * @return path to page file
	 * @throws IOException
	 */
	private String doGet(HttpServletRequest request) {
		boolean error = true;
		String cityFrom = request.getParameter("cityFrom");
		String cityTo = request.getParameter("cityTo");
		String date = request.getParameter("date");
		String sort = request.getParameter("sort");
		List<Flight> flights = null;
		String parameters = "";
		if (Validator.validateWord(cityFrom) && Validator.validateWord(cityTo) && Validator.validateDate(date)) {
			parameters = "&cityFrom=" + cityFrom + "&cityTo=" + cityTo + "&date=" + date;
			if (!Objects.isNull(sort)) {
				if (Lists.SORTS.contains(sort)) {
					flights = FlightManager.getAllSortedFlightsByCitiesAndDate(cityFrom, cityTo, date, sort);
					error = false;
				}
			} else {
				flights = FlightManager.getAllFlightsByCitiesAndDate(cityFrom, cityTo, date);
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
