package ua.khnucea.csit.cs.pertseva.airline.commands;

import java.util.HashMap;

/**
 * Class for connecting of command's name and class for the command.
 *
 * @author Pertseva Veronika
 *
 */
public class CommandManager {

	/**
	 * Hash Map, which have command's name as key and class for a command as value.
	 */
	private static HashMap<String, AbstractCommand> commands = new HashMap<>();

	static {
		commands.put("login", new LoginCommand());
		commands.put("changeLanguage", new ChangeLanguageCommand());

		commands.put("flights", new GetFlightsListCommand());
		commands.put("selection", new GetFlightsSelectionCommand());
		commands.put("search", new GetSearchedFlightsListCommand());
		commands.put("flightInfo", new GetFlightsInfoCommand());

		commands.put("flightsAdmin", new GetFlightsForAdminCommand());
		commands.put("employeesAdmin", new GetEmployeesForAdminCommand());
		commands.put("requestsAdmin", new GetRequestsForAdminCommand());
		commands.put("usersAdmin", new GetUsersForAdminCommand());

		commands.put("pageEditFlight", new GetFlightForEditingCommand());
		commands.put("pageEditEmployee", new GetEmployeeForEditingCommand());

		commands.put("addCrew", new AddCrewCommand());
		commands.put("addRequest", new AddRequestCommand());
		commands.put("addFlight", new AddFlightCommand());
		commands.put("addEmployee", new AddEmployeeCommand());
		commands.put("addUser", new AddUserCommand());

		commands.put("editFlight", new EditFlightCommand());
		commands.put("editEmployee", new EditEmployeeCommand());
		commands.put("editFlightsStatus", new EditFlightsStatusCommand());
		commands.put("editRequestsStatus", new EditRequestsStatusCommand());

		commands.put("removeCrew", new RemoveCrewCommand());
		commands.put("removeFlight", new RemoveFlightCommand());
		commands.put("removeEmployee", new RemoveEmployeeCommand());
		commands.put("removeUser", new RemoveUserCommand());
	}

	/**
	 * Method for getting command's class.
	 *
	 * @param command - name of command
	 * @return - class for a command
	 */
	public AbstractCommand getCommand(String command) {
		return commands.get(command);

	}
}
