package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Lists;
import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.Employee;
import ua.nure.pertseva.airline.entity.managers.EmployeeManager;
import ua.nure.pertseva.airline.utils.Validator;

/**
 * Class for command of editing employee.
 *
 * @author Pertseva Veronika
 *
 */
public class EditEmployeeCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(EditEmployeeCommand.class);

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
		LOGGER.info("Executing edit employee command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request, response);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Edit employee command has been executed.");
		return path;
	}

	/**
	 * Method gets parameters id, surname, firtsname and occupation, validates them
	 * and edit information about employee in data base.
	 *
	 * @param request  - request
	 * @param response - response
	 * @return page's url
	 * @throws IOException
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean error = true;
		String id = request.getParameter("id");
		String surname = request.getParameter("surname");
		String firstname = request.getParameter("firstname");
		String occupation = request.getParameter("occupation").toLowerCase();
		if (Validator.validateInt(id)) {
			Employee employee = EmployeeManager.getEmployeeById(id);
			if (!Objects.isNull(employee) && Validator.validateWord(surname) && Validator.validateWord(firstname)
					&& Lists.OCCUPATIONS.contains(occupation)) {
				EmployeeManager.editEmployee(surname, firstname, occupation, id);
				error = false;
			}
		}
		addError(error, "error.empty.input", request);
		if (error) {
			return Urls.REDIRECT_EDIT_EMPLOYEE + "&id=" + id;
		} else {
			return Urls.REDIRECT_LIST_EMPLOYEES;
		}

	}
}
