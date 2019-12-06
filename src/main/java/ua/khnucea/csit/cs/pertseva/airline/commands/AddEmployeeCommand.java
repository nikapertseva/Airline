package ua.khnucea.csit.cs.pertseva.airline.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.khnucea.csit.cs.pertseva.airline.constants.Lists;
import ua.khnucea.csit.cs.pertseva.airline.constants.Urls;
import ua.khnucea.csit.cs.pertseva.airline.entity.managers.EmployeeManager;
import ua.khnucea.csit.cs.pertseva.airline.utils.Validator;

/**
 * Class for command of adding employee.
 *
 * @author Pertseva Veronika
 *
 */
public class AddEmployeeCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(AddEmployeeCommand.class);

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
		LOGGER.info("Executing add employee command");
		String path = null;
		if (method.equals("POST")) {
			path = doPost(request);
		} else {
			path = Urls.ERROR_PAGE;
		}
		LOGGER.info("Add employee command has been executed.");
		return path;
	}

	/**
	 * Method gets parameters surname, firtsname and occupation, validates them and
	 * adds employee to data base.
	 *
	 * @param request  - request
	 * @return page's url
	 */
	private String doPost(HttpServletRequest request) {
		boolean error = true;
		String surname = request.getParameter("surname");
		String firstname = request.getParameter("firstname");
		String occupation = request.getParameter("occupation").toLowerCase();

		if (Validator.validateWord(surname) && Validator.validateWord(firstname)
				&& Lists.OCCUPATIONS.contains(occupation)) {
			EmployeeManager.addEmployee(surname, firstname, occupation);
			error = false;

		}
		addError(error, "error.empty.input", request);
		return Urls.REDIRECT_LIST_EMPLOYEES;
	}

}
