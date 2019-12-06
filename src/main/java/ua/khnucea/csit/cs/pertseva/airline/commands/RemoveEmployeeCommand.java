package ua.khnucea.csit.cs.pertseva.airline.commands;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.constants.Urls;
import ua.khnucea.csit.cs.pertseva.airline.entity.Employee;
import ua.khnucea.csit.cs.pertseva.airline.entity.managers.EmployeeManager;
import ua.khnucea.csit.cs.pertseva.airline.utils.Validator;

/**
 * The class for command of removing employee.
 *
 * @author Pertseva Veronika
 *
 */
public class RemoveEmployeeCommand extends AbstractCommand {

	/** Logger */
	private final Logger LOGGER = Logger.getLogger(RemoveEmployeeCommand.class);

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
		LOGGER.info("Executing remove employee command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Remove employee command has been executed.");
		return path;
	}

	/**
	 * The method gets parameter id, validates it, removes crew and employee from
	 * data base and returns path to page's file.
	 *
	 * @param request  - request
	 * @return path to page file
	 * @throws SQLException
	 */
	private String doPost(HttpServletRequest request) throws SQLException {
		boolean error = true;
		String id = request.getParameter("id");
		if (Validator.validateInt(id)) {
			Employee employee = EmployeeManager.getEmployeeById(id);
			if (!Objects.isNull(employee)) {
				EmployeeManager.removeEmployee(id);
				error = false;
			}
		}
		addError(error, "error.remove", request);
		return Urls.REDIRECT_LIST_EMPLOYEES;
	}

}
