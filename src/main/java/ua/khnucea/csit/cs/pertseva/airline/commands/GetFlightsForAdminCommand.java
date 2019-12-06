package ua.khnucea.csit.cs.pertseva.airline.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.entity.managers.FlightManager;
import ua.khnucea.csit.cs.pertseva.airline.constants.Urls;
import ua.khnucea.csit.cs.pertseva.airline.entity.Flight;

/**
 * The class for command of getting flights for admin-panel.
 *
 * @author Pertseva Veronika
 *
 */
public class GetFlightsForAdminCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(GetFlightsForAdminCommand.class);

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
		LOGGER.info("Executing get flight for admin command");
		String path = null;
		if (method.equals("GET")) {
			path = doGet(request);
		}
		LOGGER.info("Get employee for flight command has been executed.");
		return path;
	}

	/**
	 * The method sets attribute flights and returns path to page's file.
	 *
	 * @param request - request
	 * @return path to page file
	 * @throws IOException
	 */
	private String doGet(HttpServletRequest request) {
		List<Flight> flights = FlightManager.getAllFlights();
		request.getSession().setAttribute("flights", flights);
		return Urls.PAGE_FLIGHTS_ADMIN;
	}

}
