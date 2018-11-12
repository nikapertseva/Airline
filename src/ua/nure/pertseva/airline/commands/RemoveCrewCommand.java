package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.Crew;
import ua.nure.pertseva.airline.entity.Flight;
import ua.nure.pertseva.airline.entity.managers.CrewManager;
import ua.nure.pertseva.airline.entity.managers.FlightManager;
import ua.nure.pertseva.airline.utils.Validator;

/**
 * The class for command of removing crew.
 *
 * @author Pertseva Veronika
 *
 */
public class RemoveCrewCommand extends AbstractCommand {

	/** Logger */
	private final Logger LOGGER = Logger.getLogger(RemoveCrewCommand.class);

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
		LOGGER.info("Executing remove crew command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request, response);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Remove crew command has been executed.");
		return path;
	}

	/**
	 * The method gets parameters crewId and flightId, validates them, removes crew
	 * from data base and returns path to page's file.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return path to page file
	 * @throws IOException
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean error = true;
		String crewId = request.getParameter("crewId");
		String flightId = request.getParameter("flightId");
		if (Validator.validateInt(crewId) && Validator.validateInt(flightId)) {
			Crew crew = CrewManager.getCrewById(crewId);
			Flight flight = FlightManager.getFlightById(flightId);
			if (!Objects.isNull(crew) && !Objects.isNull(flight)) {
				CrewManager.removeCrew(crewId);
				error = false;

			}
		}
		addError(error, "error.remove", request);
		return Urls.REDIRECT_FLIGHT_INFO + "&id=" + flightId;
	}

}
