package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.Request;
import ua.nure.pertseva.airline.entity.managers.RequestManager;

/**
 * The class for command of getting requests for admin-panel.
 *
 * @author Pertseva Veronika
 *
 */
public class GetRequestsForAdminCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(GetRequestsForAdminCommand.class);

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
		LOGGER.info("Executing get requests for admin command");
		String path = null;
		if (method.equals("GET")) {
			path = doGet(request);
		}
		LOGGER.info("Get requests for admin command has been executed.");
		return path;
	}

	/**
	 * The method gets list of requests, sets attribute request and returns path to
	 * page's file.
	 *
	 * @param request - request
	 * @return path to page file
	 * @throws IOException
	 */
	private String doGet(HttpServletRequest request) {
		List<Request> requests = RequestManager.getAllRequests();
		request.getSession().setAttribute("requests", requests);
		return Urls.PAGE_LIST_REQUESTS;
	}
}
