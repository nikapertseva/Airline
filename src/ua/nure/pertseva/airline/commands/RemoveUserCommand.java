package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.User;
import ua.nure.pertseva.airline.entity.managers.UserManager;
import ua.nure.pertseva.airline.utils.Validator;

/**
 * The class for command of removing user.
 *
 * @author Pertseva Veronika
 *
 */
public class RemoveUserCommand extends AbstractCommand {

	/** Logger */
	private final Logger LOGGER = Logger.getLogger(RemoveUserCommand.class);

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
		LOGGER.info("Executing remove user command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request, response);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Remove user command has been executed.");
		return path;
	}

	/**
	 * The method gets parameter id, validates it, removes requests and user from
	 * data base and returns path to page's file.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return path to page file
	 * @throws IOException
	 * @throws SQLException
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		boolean error = true;
		String id = request.getParameter("id");
		if (Validator.validateInt(id)) {
			User user = UserManager.getUserById(id);
			if (!Objects.isNull(user)) {
				UserManager.removeUser(id);
				error = false;

			}
		}
		addError(error, "error.remove", request);
		return Urls.REDIRECT_LIST_USERS;
	}
}
