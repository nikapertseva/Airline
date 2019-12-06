package ua.khnucea.csit.cs.pertseva.airline.commands;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.entity.managers.FlightManager;
import ua.khnucea.csit.cs.pertseva.airline.constants.Urls;
import ua.khnucea.csit.cs.pertseva.airline.entity.Flight;
import ua.khnucea.csit.cs.pertseva.airline.utils.Validator;

/**
 * The class for command of removing flight.
 *
 * @author Pertseva Veronika
 *
 */
public class RemoveFlightCommand extends AbstractCommand {

	/** Logger */
	private final Logger LOGGER = Logger.getLogger(RemoveFlightCommand.class);

	/**
	 * Method for command's executing.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return page's url
	 * @throws IOException
	 * @throws SQLException
	 */
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response, String method)
			throws IOException, SQLException {
		LOGGER.info("Executing remove flight command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Remove flight command has been executed.");
		return path;
	}

	/**
	 * The method gets parameter id, validates it, removes requests, crew and flight
	 * from data base and returns path to page's file.
	 *
	 * @param request  - request
	 * @return path to page file
	 * @throws SQLException
	 */
	private String doPost(HttpServletRequest request) throws SQLException {
		boolean error = true;
		String id = request.getParameter("id");
		if (Validator.validateInt(id)) {
			Flight flight = FlightManager.getFlightById(id);
			if (!Objects.isNull(flight)) {
				FlightManager.removeFlight(id);
				error = false;

			}
		}
		addError(error, "error.remove", request);
		return Urls.REDIRECT_ADMIN_PANEL;
	}
}
