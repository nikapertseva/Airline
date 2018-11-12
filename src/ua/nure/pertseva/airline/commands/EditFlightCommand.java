package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.Flight;
import ua.nure.pertseva.airline.entity.managers.FlightManager;
import ua.nure.pertseva.airline.utils.Validator;

/**
 * Class for command of editing flight.
 *
 * @author Pertseva Veronika
 *
 */
public class EditFlightCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(EditFlightCommand.class);

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
		LOGGER.info("Executing edit flight command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request, response);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Edit flight command has been executed.");
		return path;
	}

	/**
	 * Method gets parameters id, number, name, cityFrom, cityTo, date and time,
	 * validates them and edit information about employee in data base.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return page's url
	 * @throws IOException
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean error = true;
		String id = request.getParameter("id");
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String cityFrom = request.getParameter("cityFrom");
		String cityTo = request.getParameter("cityTo");
		String dateDeparture = request.getParameter("dateDeparture");
		String timeDeparture = request.getParameter("timeDeparture");
		String dateArrival = request.getParameter("dateArrival");
		String timeArrival = request.getParameter("timeArrival");
		if (Validator.validateInt(id)) {
			Flight flight = FlightManager.getFlightById(id);
			if (!Objects.isNull(flight) && Validator.validateText(number) && Validator.validateText(name)
					&& Validator.validateWord(cityFrom) && Validator.validateWord(cityTo)
					&& Validator.validateDateTimeBefore(dateDeparture, timeDeparture, dateArrival, timeArrival)) {
				FlightManager.editFlight(number, name, cityFrom, cityTo, dateDeparture + " " + timeDeparture,
						dateArrival + " " + timeArrival, id);
				error = false;
			}
		}
		addError(error, "error.empty.input", request);
		if (error) {
			return Urls.REDIRECT_EDIT_FLIGHT + "&id=" + id;
		} else {
			return Urls.REDIRECT_ADMIN_PANEL;
		}

	}

}
