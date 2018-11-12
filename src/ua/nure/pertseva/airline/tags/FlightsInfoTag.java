package ua.nure.pertseva.airline.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import ua.nure.pertseva.airline.entity.Flight;
import ua.nure.pertseva.airline.entity.managers.FlightManager;

/**
 * Tag for page of flight's info.
 *
 * @author Pertseva Veronika
 */
public class FlightsInfoTag extends SimpleTagSupport {

	private String id;

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter writer = getJspContext().getOut();
		writer.println(getFlights(id));
	}

	/**
	 * Method for getting flights and for creating flight's table.
	 *
	 * @param id - flight's id
	 * @return table
	 */
	private String getFlights(String id) {
		StringBuilder builder = new StringBuilder();
		Flight flight = FlightManager.getFlightById(id);

		builder.append("<td class=\"align-middle\">");
		builder.append(flight.getFlightNumber());
		builder.append("</td>");
		builder.append("<td class=\"align-middle\">");
		builder.append(flight.getFlightName());
		builder.append("</td>");
		builder.append("<td class=\"align-middle\">");
		builder.append(flight.getFlightCityFrom());
		builder.append("</td>");
		builder.append("<td class=\"align-middle\">");
		builder.append(flight.getFlightCityTo());
		builder.append("</td>");
		builder.append("<td class=\"align-middle\">");
		builder.append(flight.getFlightDateDeparture());
		builder.append("</td>");
		builder.append("<td class=\"align-middle\">");
		builder.append(flight.getFlightTimeDeparture());
		builder.append("</td>");
		builder.append("<td class=\"align-middle\">");
		builder.append(flight.getFlightDateArrival());
		builder.append("</td>");
		builder.append("<td class=\"align-middle\">");
		builder.append(flight.getFlightTimeArrival());
		builder.append("</td>");

		return builder.toString();
	}

}
