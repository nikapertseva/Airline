<%@tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="flight" required="true"
	type="ua.nure.pertseva.airline.entity.Flight"%>

	<td colspan="2" class="align-middle">${flight.flightNumber}</td>
	<td colspan="2" class="align-middle">${flight.flightName}</td>
	<td class="align-middle">${flight.flightCityFrom}</td>
	<td class="align-middle">${flight.flightCityTo}</td>
	<td class="align-middle">${flight.flightDateDeparture}</td>
	<td class="align-middle">${flight.flightTimeDeparture}</td>
	<td class="align-middle">${flight.flightDateArrival}</td>
	<td class="align-middle">${flight.flightTimeArrival}</td>
	

