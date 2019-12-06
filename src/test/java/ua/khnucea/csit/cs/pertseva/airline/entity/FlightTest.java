package ua.khnucea.csit.cs.pertseva.airline.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class FlightTest {

	private Flight flight;

	@Before
	public void testFlight() {
		flight = new Flight(1, "number", "name", "cityFrom", "cityTo", new Date(), null, null, null, "status");
	}

	@Test
	public void testGetFlightId() {
		int id = flight.getFlightId();
		assertEquals(id, 1);
	}

	@Test
	public void testSetFlightId() {
		flight.setFlightId(2);
		int id = flight.getFlightId();
		assertEquals(id, 2);
	}

	@Test
	public void testGetFlightNumber() {
		String number = flight.getFlightNumber();
		assertEquals(number, "number");
	}

	@Test
	public void testSetFlightNumber() {
		flight.setFlightNumber("newNumber");
		String number = flight.getFlightNumber();
		assertEquals(number, "newNumber");
	}

	@Test
	public void testGetFlightName() {
		String name = flight.getFlightName();
		assertEquals(name, "name");
	}

	@Test
	public void testSetFlightName() {
		flight.setFlightName("newName");
		String name = flight.getFlightName();
		assertEquals(name, "newName");
	}

	@Test
	public void testGetFlightCityFrom() {
		String cityFrom = flight.getFlightCityFrom();
		assertEquals(cityFrom, "cityFrom");
	}

	@Test
	public void testSetFlightCityFrom() {
		flight.setFlightCityFrom("newCityFrom");
		String cityFrom = flight.getFlightCityFrom();
		assertEquals(cityFrom, "newCityFrom");
	}

	@Test
	public void testGetFlightCityTo() {
		String cityTo = flight.getFlightCityTo();
		assertEquals(cityTo, "cityTo");
	}

	@Test
	public void testSetFlightCityTo() {
		flight.setFlightCityTo("newCityTo");
		String cityTo = flight.getFlightCityTo();
		assertEquals(cityTo, "newCityTo");
	}

	
	@Test
	public void testGetFlightStatus() {
		String status = flight.getFlightStatus();
		assertEquals(status, "status");
	}

	@Test
	public void testSetFlightStatus() {
		flight.setFlightStatus("newStatus");
		String status = flight.getFlightStatus();
		assertEquals(status, "newStatus");
	}
}
