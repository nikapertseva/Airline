package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.User;
import ua.nure.pertseva.airline.entity.managers.UserManager;
import ua.nure.pertseva.airline.utils.Hash;

/**
 * The class for command of user's login.
 *
 * @author Pertseva Veronika
 *
 */
public class LoginCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(LoginCommand.class);

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
		LOGGER.info("Executing login command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request, response);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Login command has been executed.");
		return path;
	}

	/**
	 * The method gets parameters email and password, check them, sets attributes
	 * user and role, and returns path to redirect to page.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return path to page's redirecting
	 * @throws IOException
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String result = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = UserManager.getUserByEmail(email);
		try {
			if (Objects.isNull(user) || !user.getUserPassword().equals(Hash.hash(password))) {
				session.setAttribute("error", true);
				LOGGER.trace("Failed to login: email: " + email + " Password: " + password);
				session.setAttribute("email", email);
				result = Urls.REDIRECT_LOGIN_PAGE;
			} else {
				session.removeAttribute("error");
				LOGGER.trace(user.getUserRole() + " " + user.getUserEmail() + " has logged in.");
				result = Urls.REDIRECT_FLIGHTS_LIST;
				session.setAttribute("user", user);
				session.setAttribute("role", user.getUserRole());
				if (user.getUserRole().equals("dispatcher")) {
					result = Urls.REDIRECT_FLIGHTS_LIST;
				} else {
					result = Urls.REDIRECT_ADMIN_PANEL;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
		return result;
	}

}
