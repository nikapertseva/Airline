package ua.khnucea.csit.cs.pertseva.airline.commands;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.entity.managers.FlightManager;
import ua.khnucea.csit.cs.pertseva.airline.constants.Urls;
import ua.khnucea.csit.cs.pertseva.airline.entity.Flight;
import ua.khnucea.csit.cs.pertseva.airline.utils.Validator;

/**
 * The class for command of getting flight for editing.
 *
 * @author Pertseva Veronika
 *
 */
public class GetFlightForEditingCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(GetFlightForEditingCommand.class);

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
		LOGGER.info("Executing get flight for editing command");
		String path = null;
		if (method.equals("GET")) {
			path = doGet(request);
		}
		LOGGER.info("Get flight for editing command has been executed.");
		return path;
	}

	/**
	 * The method gets parameter id, validates it, sets attribute flight and returns
	 * path to page's file.
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
				request.getSession().setAttribute("flight", flight);
				error = false;
			}
		}
		if (error) {
			return Urls.ERROR_PAGE;
		} else {
			return Urls.PAGE_EDIT_FLIGHT;
		}

	}

}
