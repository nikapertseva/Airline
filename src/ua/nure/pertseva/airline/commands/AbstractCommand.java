package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Abstract class for all commands.
 *
 * @author Pertseva Veronika
 *
 */

public abstract class AbstractCommand {
	/**
	 * Abstract method for command executing. Need to be realized for executing
	 * child command.
	 *
	 * @param request  - request
	 * @param response - response
	 * @param method   - method: "GET" or "POST"
	 * @return string url to redirect
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws SQLException
	 */
	public abstract String executeCommand(HttpServletRequest request, HttpServletResponse response, String method)
			throws IOException, NoSuchAlgorithmException, SQLException;

	/**
	 * Method for adding error's alert.
	 *
	 * @param error        - true or false
	 * @param errorMessage - message for alert
	 * @param request      - request
	 */
	public void addError(boolean error, String errorMessage, HttpServletRequest request) {
		if (error) {
			request.getSession().setAttribute("error", true);
			request.getSession().setAttribute("errorMessage", errorMessage);
		} else {
			request.getSession().setAttribute("error", false);
		}

	}

}
