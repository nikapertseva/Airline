package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.Flight;
import ua.nure.pertseva.airline.entity.User;
import ua.nure.pertseva.airline.entity.managers.RequestManager;
import ua.nure.pertseva.airline.entity.managers.FlightManager;
import ua.nure.pertseva.airline.utils.Validator;

/**
 * Class for command of adding employee.
 *
 * @author Pertseva Veronika
 *
 */
public class AddRequestCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(AddRequestCommand.class);

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
		LOGGER.info("Executing add request command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request, response);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Add request command has been executed.");
		return path;
	}

	/**
	 * Method gets parameters topic, message and flight's id, validates them and
	 * adds request to data base.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return page's url
	 * @throws IOException
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean error = true;
		Flight flight = null;
		String topic = request.getParameter("topic");
		String message = request.getParameter("message");
		String flightId = request.getParameter("flightId");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		String userId = String.valueOf(((User) session.getAttribute("user")).getUserId());

		if (Validator.validateInt(flightId)) {
			flight = FlightManager.getFlightById(flightId);
			if (!Objects.isNull(flight) && Validator.validateText(topic) && Validator.validateText(message)) {
				RequestManager.addRequest(userId, flightId, topic, message);
				error = false;
			}
		}
		addError(error, "error.empty.input", request);

		return Urls.REDIRECT_FLIGHT_INFO + "&id=" + flightId;
	}

}
