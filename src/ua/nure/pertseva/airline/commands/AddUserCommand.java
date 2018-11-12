package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Lists;
import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.managers.UserManager;
import ua.nure.pertseva.airline.utils.Hash;
import ua.nure.pertseva.airline.utils.Validator;

/**
 * Class for command of adding user.
 *
 * @author Pertseva Veronika
 *
 */
public class AddUserCommand extends AbstractCommand {

	/** Logger */
	private final Logger LOGGER = Logger.getLogger(AddUserCommand.class);

	/**
	 * Method for command's executing.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return page's url
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response, String method)
			throws IOException, NoSuchAlgorithmException {
		LOGGER.info("Executing add user command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request, response);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Add user command has been executed.");
		return path;
	}

	/**
	 * Method gets parameters email, password and role, validates them and adds user
	 * to data base.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return page's url
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, NoSuchAlgorithmException {
		boolean error = true;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		if (Validator.validateEmail(email) && Validator.validatePassword(password)
				&& Lists.USERS_ROLES.contains(role)) {
			UserManager.addUser(email, Hash.hash(password), role);
			error = false;

		}
		addError(error, "error.empty.input", request);
		return Urls.REDIRECT_LIST_USERS;
	}
}
