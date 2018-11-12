package ua.nure.pertseva.airline.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class RequestTest {

	private Request request;

	@Before
	public void testRequest() {
		User user = new User(0, null, null, null);
		Flight flight = new Flight(0, null, null, null, null, null, null, null, null, null);
		request = new Request(1, user, flight, "topic", "message", new Date(), "status");
	}

	@Test
	public void testGetRequestId() {
		int id = request.getRequestId();
		assertEquals(id, 1);
	}

	@Test
	public void testSetRequestId() {
		request.setRequestId(2);
		int id = request.getRequestId();
		assertEquals(id, 2);
	}

	@Test
	public void testGetRequestUser() {
		User user = request.getRequestUser();
		assertEquals(user.getClass(), User.class);
	}
	
	@Test 
	public void testSetRequestUser() {
		request.setRequestUser(new User(1, null, null, null));
		User user = request.getRequestUser();
		assertEquals(user.getUserId(), 1);
	}
	
	@Test
	public void testGetRequestFlight() {
		Flight flight = request.getRequestFlight();
		assertEquals(flight.getClass(), Flight.class);
	}
	
	@Test 
	public void testSetRequestFlight() {
		request.setRequestFlight(new Flight(1, null, null, null, null, null, null, null, null, null));
		Flight flight = request.getRequestFlight();
		assertEquals(flight.getFlightId(), 1);
	}

	@Test
	public void testGetRequestTopic() {
		String topic = request.getRequestTopic();
		assertEquals(topic, "topic");
	}

	@Test
	public void testSetRequestTopic() {
		request.setRequestTopic("newTopic");
		String topic = request.getRequestTopic();
		assertEquals(topic, "newTopic");
	}

	@Test
	public void testGetRequestMessage() {
		String message = request.getRequestMessage();
		assertEquals(message, "message");
	}

	@Test
	public void testSetRequestMessage() {
		request.setRequestMessage("newMessage");
		String message = request.getRequestMessage();
		assertEquals(message, "newMessage");
	}

	@Test
	public void testGetRequestDate() {
		Date date = request.getRequestDate();
		assertEquals(date.getClass(), Date.class);
	}

	@Test
	public void testSetRequestDate() {
		request.setRequestDate(null);
		Date date = request.getRequestDate();
		assertNull(date);
	}

	@Test
	public void testGetRequestStatus() {
		String status = request.getRequestStatus();
		assertEquals(status, "status");
	}

	@Test
	public void testSetRequestStatus() {
		request.setRequestStatus("newStatus");
		String status = request.getRequestStatus();
		assertEquals(status, "newStatus");
	}
}