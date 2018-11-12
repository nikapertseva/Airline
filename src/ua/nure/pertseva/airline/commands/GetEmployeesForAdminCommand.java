package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Lists;
import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.Employee;
import ua.nure.pertseva.airline.entity.managers.EmployeeManager;

/**
 * The class for command of getting employees for admin-panel.
 *
 * @author Pertseva Veronika
 */
public class GetEmployeesForAdminCommand extends AbstractCommand {

	/** Logger */
	private final Logger LOGGER = Logger.getLogger(GetEmployeesForAdminCommand.class);

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
		LOGGER.info("Executing get employee for admin command");
		String path = null;
		if (method.equals("GET")) {
			path = doGet(request);
		}
		LOGGER.info("Get employee for admin command has been executed.");
		return path;
	}

	/**
	 * The method sets attributes employees and occupations and returns path to
	 * page's file.
	 *
	 * @param request - request
	 * @return path to page file
	 * @throws IOException
	 */
	private String doGet(HttpServletRequest request) {
		List<Employee> employees = EmployeeManager.getAllEmployee();
		List<String> occupations = Lists.OCCUPATIONS;
		request.getSession().setAttribute("employees", employees);
		request.getSession().setAttribute("occupations", occupations);
		return Urls.PAGE_LIST_EMPLOYEES;
	}

}
