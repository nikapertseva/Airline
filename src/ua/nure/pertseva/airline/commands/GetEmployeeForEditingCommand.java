package ua.nure.pertseva.airline.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.pertseva.airline.constants.Lists;
import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.Employee;
import ua.nure.pertseva.airline.entity.managers.EmployeeManager;
import ua.nure.pertseva.airline.utils.Validator;

/**
 * The class for command of getting employee for editing.
 *
 * @author Pertseva Veronika
 *
 */
public class GetEmployeeForEditingCommand extends AbstractCommand {
	/** Logger */
	private final Logger LOGGER = Logger.getLogger(GetEmployeeForEditingCommand.class);

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
		LOGGER.info("Executing get employee for editing command");
		String path = null;
		if (method.equals("GET")) {
			path = doGet(request);
		}
		LOGGER.info("Get employee for editing command has been executed.");
		return path;
	}

	/**
	 * The method gets parameter id, validates it and sets attributes employee and
	 * occupations.
	 *
	 * @param request - request
	 * @return path to page file
	 * @throws IOException
	 */
	private String doGet(HttpServletRequest request) {
		boolean error = true;
		String id = request.getParameter("id");

		List<String> occupations = new ArrayList<>();
		if (Validator.validateInt(id)) {
			Employee employee = EmployeeManager.getEmployeeById(id);
			if (!Objects.isNull(employee)) {
				request.getSession().setAttribute("employee", employee);
				occupations = Lists.OCCUPATIONS.stream().filter((o) -> !o.equals(employee.getEmployeeOccupation()))
						.collect(Collectors.toList());
				request.getSession().setAttribute("occupations", occupations);
				error = false;

			}
		}
		if (error) {
			return Urls.ERROR_PAGE;
		} else {
			return Urls.PAGE_EDIT_EMPLOYEE;
		}

	}

}
