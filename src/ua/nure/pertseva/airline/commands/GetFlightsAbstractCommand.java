package ua.nure.pertseva.airline.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.nure.pertseva.airline.constants.Urls;
import ua.nure.pertseva.airline.entity.Flight;
import ua.nure.pertseva.airline.entity.managers.FlightManager;

/**
 * The abstract class for command of getting flights.
 *
 * @author Pertseva Veronika
 *
 */
public abstract class GetFlightsAbstractCommand extends AbstractCommand {

	/**
	 * The method sets attributes url, citiesFrom, citiesTo, command and flights,
	 * and returns url of page.
	 *
	 * @param request    - request
	 * @param flights    - list of flights
	 * @param parameters - parameters for url
	 * @return url of page
	 */
	protected String getPage(HttpServletRequest request, List<Flight> flights, String parameters) {

		List<String> citiesFrom = FlightManager.getAllCitiesFrom();
		List<String> citiesTo = FlightManager.getAllCitiesTo();
		citiesFrom.sort(String.CASE_INSENSITIVE_ORDER);
		citiesTo.sort(String.CASE_INSENSITIVE_ORDER);
		String url = "controller?command=" + request.getParameter("command") + parameters;
		request.getSession().setAttribute("url", url);
		request.getSession().setAttribute("citiesFrom", citiesFrom);
		request.getSession().setAttribute("citiesTo", citiesTo);
		request.getSession().setAttribute("command", request.getParameter("command"));
		request.getSession().setAttribute("flights", flights);

		return Urls.PAGE_LIST_FLIGHTS;

	}
}
