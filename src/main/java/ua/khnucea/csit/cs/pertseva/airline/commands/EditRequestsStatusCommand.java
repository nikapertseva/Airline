package ua.khnucea.csit.cs.pertseva.airline.commands;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.entity.managers.RequestManager;
import ua.khnucea.csit.cs.pertseva.airline.constants.Lists;
import ua.khnucea.csit.cs.pertseva.airline.constants.Urls;
import ua.khnucea.csit.cs.pertseva.airline.entity.Request;
import ua.khnucea.csit.cs.pertseva.airline.utils.Validator;

/**
 * Class for command of editing of request's status.
 *
 * @author Pertseva Veronika
 *
 */
public class EditRequestsStatusCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(EditRequestsStatusCommand.class);

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
		LOGGER.info("Executing edit request's status command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request, response);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Edit request's status command has been executed.");
		return path;
	}

	/**
	 * Method gets parameters id and status, validates them and edit the status of a
	 * request in a data base.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return page's url
	 * @throws IOException
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean error = true;
		String id = request.getParameter("requestId");
		String status = request.getParameter("status").toLowerCase();
		if (Validator.validateInt(id)) {
			Request flightRequest = RequestManager.getRequestById(id);
			if (!Objects.isNull(flightRequest) && Lists.REQUESTS_STATUS.contains(status)) {
				RequestManager.editRequestsStatus(status, id);
				error = false;
			}
		}
		addError(error, "error.empty.choice", request);
		return Urls.REDIRECT_LIST_REQUESTS;
	}

}
