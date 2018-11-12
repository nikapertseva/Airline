package ua.nure.pertseva.airline.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.commands.AbstractCommand;
import ua.nure.pertseva.airline.commands.CommandManager;
import ua.nure.pertseva.airline.constants.Urls;

/**
 * Servlet implementation class MainControllerServlet
 */
@WebServlet
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger LOGGER = Logger.getLogger(MainControllerServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("Obtain GET query");
		try {
			process(request, response, "GET");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e.getMessage());
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		} catch (ServletException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Obtain POST query");
		try {
			process(request, response, "POST");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e.getMessage());
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		} catch (ServletException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * The method gets parameter command, command's class and path, and goes to
	 * page.
	 *
	 * @param request  - request
	 * @param response - response
	 * @param method   - "GET" or "POST"
	 * @throws ServletException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws SQLException
	 */
	private void process(HttpServletRequest request, HttpServletResponse response, String method)
			throws ServletException, IOException, NoSuchAlgorithmException, SQLException {

		CommandManager manager = new CommandManager();
		String commandName = request.getParameter("command");

		if (!Objects.isNull(commandName)) {
			AbstractCommand command = manager.getCommand(commandName);
			if (!Objects.isNull(command)) {
				String path = command.executeCommand(request, response, method);
				if (!Objects.isNull(path)) {
					if (method.equals("POST")) {
						LOGGER.trace("Redirect to: " + path);
						response.sendRedirect(path);
						LOGGER.debug("Controller has finished command executing");
					} else if (method.equals("GET")) {
						LOGGER.trace("Forward to: " + path);
						request.getRequestDispatcher(path).forward(request, response);
						LOGGER.debug("Controller has finished command executing");
					}
				}

			} else {
				if (commandName.equals("logout")) {
					request.getSession().invalidate();
					response.sendRedirect(Urls.REDIRECT_LOGIN_PAGE);
				} else {
					LOGGER.trace("Got bad command");
					request.getRequestDispatcher(Urls.ERROR_PAGE).forward(request, response);
				}
			}
		}

	}

}
