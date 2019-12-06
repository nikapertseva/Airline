package ua.khnucea.csit.cs.pertseva.airline.commands;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.entity.managers.FlightManager;
import ua.khnucea.csit.cs.pertseva.airline.constants.Lists;
import ua.khnucea.csit.cs.pertseva.airline.entity.Flight;

/**
 * The class for command of getting flights for dispatchers.
 *
 * @author Pertseva Veronika
 *
 */
public class GetFlightsListCommand extends GetFlightsAbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(GetFlightsListCommand.class);

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
		LOGGER.info("Executing get flights list command");
		String path = null;
		if (method.equals("GET")) {
			path = doGet(request);
		}
		LOGGER.info("Get flights list command has been executed.");
		return path;
	}

	/**
	 * The method gets parameter sort, validates it and returns path to page's file
	 * from method getPage.
	 *
	 * @param request - request
	 * @return path to page file
	 */
	private String doGet(HttpServletRequest request) {
		boolean error = false;
		String sort = request.getParameter("sort");
		List<Flight> flights = null;
		if (!Objects.isNull(sort)) {
			if (Lists.SORTS.contains(sort)) {
				flights = FlightManager.getAllSortedFlights(sort);
			} else {
				error = true;
			}
		} else {
			flights = FlightManager.getAllFlights();
		}
		if (error) {
			addError(error, "error.sort", request);
		}

		return getPage(request, flights, "");

	}

}
