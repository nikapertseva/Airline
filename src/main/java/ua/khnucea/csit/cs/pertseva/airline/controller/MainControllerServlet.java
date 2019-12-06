package ua.khnucea.csit.cs.pertseva.airline.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.commands.AbstractCommand;
import ua.khnucea.csit.cs.pertseva.airline.commands.CommandManager;
import ua.khnucea.csit.cs.pertseva.airline.constants.Urls;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("Obtain GET query");
		try {
			process(request, response, "GET");
		} catch (NoSuchAlgorithmException | IOException | ServletException | SQLException e) {
			LOGGER.error(e.getMessage());
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("Obtain POST query");
		try {
			process(request, response, "POST");
		} catch (NoSuchAlgorithmException | IOException | ServletException | SQLException e) {
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
						LOGGER.info("Redirect to: " + path);
						String redirectURL = response.encodeRedirectURL(path);
						response.sendRedirect(redirectURL);
						LOGGER.info("Controller has finished command executing");
					} else if (method.equals("GET")) {
						LOGGER.info("Forward to: " + path);
						request.getRequestDispatcher(path).forward(request, response);
						LOGGER.info("Controller has finished command executing");
					}
				}

			} else {
				if (commandName.equals("logout")) {
					ServletContext servletContext = request.getServletContext();
					servletContext.removeAttribute("user");
					servletContext.removeAttribute("role");
					response.sendRedirect(Urls.REDIRECT_LOGIN_PAGE);
				} else {
					LOGGER.info("Got bad command");
					request.getRequestDispatcher(Urls.ERROR_PAGE).forward(request, response);
				}
			}
		}

	}

}
