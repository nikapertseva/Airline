package ua.khnucea.csit.cs.pertseva.airline.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.constants.Lists;
import ua.khnucea.csit.cs.pertseva.airline.constants.Urls;
import ua.khnucea.csit.cs.pertseva.airline.entity.User;
import ua.khnucea.csit.cs.pertseva.airline.entity.managers.UserManager;

/**
 * The class for command of getting users for admin-panel.
 *
 * @author Pertseva Veronika
 */
public class GetUsersForAdminCommand extends AbstractCommand {

	/** Logger */
	private final Logger LOGGER = Logger.getLogger(GetUsersForAdminCommand.class);

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
		LOGGER.info("Executing get users for admin command");
		String path = null;
		if (method.equals("GET")) {
			path = doGet(request);
		}
		LOGGER.info("Get users for admin command has been executed.");
		return path;
	}

	/**
	 * The method sets attributes users and roles and returns path to page's file.
	 *
	 * @param request - request
	 * @return path to page file
	 */
	private String doGet(HttpServletRequest request) {
		List<User> users = UserManager.getAllUsers();
		List<String> roles = Lists.USERS_ROLES;
		request.getSession().setAttribute("users", users);
		request.getSession().setAttribute("roles", roles);
		return Urls.PAGE_LIST_USERS;
	}
}
