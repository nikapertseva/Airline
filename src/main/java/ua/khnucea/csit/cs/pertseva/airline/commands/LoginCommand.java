package ua.khnucea.csit.cs.pertseva.airline.commands;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.constants.Urls;
import ua.khnucea.csit.cs.pertseva.airline.entity.User;
import ua.khnucea.csit.cs.pertseva.airline.entity.managers.UserManager;
import ua.khnucea.csit.cs.pertseva.airline.utils.Hash;

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
		String path;
		if (method.equals("POST")) {
			path = doPost(request);
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
	 * @return path to page's redirecting
	 */
	private String doPost(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String result = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = UserManager.getUserByEmail(email);
		try {
			if (Objects.isNull(user) || !user.getUserPassword().equals(Hash.hash(password))) {
				session.setAttribute("error", true);
				LOGGER.info("Failed to login: email: " + email + " Password: " + password);
				session.setAttribute("email", email);
				result = Urls.REDIRECT_LOGIN_PAGE;
			} else {
				session.removeAttribute("error");
				LOGGER.info(user.getUserRole() + " " + user.getUserEmail() + " has logged in.");
				result = Urls.REDIRECT_FLIGHTS_LIST;
				ServletContext servletContext = request.getServletContext();
				servletContext.setAttribute("user", user);
				servletContext.setAttribute("role", user.getUserRole());
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
