package ua.khnucea.csit.cs.pertseva.airline.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.khnucea.csit.cs.pertseva.airline.constants.Urls;

public class AddFlightCommandTest {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Mock
	HttpSession session;



	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	

	@Test
	public void testExecuteGetCommand() throws IOException {
		AddFlightCommand addFlightCommand = new AddFlightCommand();
		String path = addFlightCommand.executeCommand(request, response, "GET");
		Assert.assertEquals(path, Urls.ERROR_PAGE);
	}

	@Test
	public void testExecutePostCommandWithError() throws IOException, SQLException {

		AddFlightCommand addFlightCommand = new AddFlightCommand();
		when(request.getParameter("number")).thenReturn("");
		when(request.getParameter("name")).thenReturn("");
		when(request.getParameter("cityFrom")).thenReturn("");
		when(request.getParameter("cityTo")).thenReturn("");
		when(request.getParameter("dateDeparture")).thenReturn("");
		when(request.getParameter("timeDeparture")).thenReturn("");
		when(request.getParameter("dateArrival")).thenReturn("");
		when(request.getParameter("timeArrival")).thenReturn("");
		when(request.getSession()).thenReturn(session);
		String path = addFlightCommand.executeCommand(request, response, "POST");
		assertEquals(path, Urls.REDIRECT_ADMIN_PANEL);

	}

}
