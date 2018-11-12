package ua.nure.pertseva.airline.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.nure.pertseva.airline.constants.Urls;

public class AddCrewCommandTest {

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
		AddCrewCommand addCrewCommand = new AddCrewCommand();
		String path = addCrewCommand.executeCommand(request, response, "GET");
		assertEquals(path, Urls.ERROR_PAGE);
	}

	@Test
	public void testExecutePostCommandWithError() throws IOException, SQLException {

		AddCrewCommand addCrewCommand = new AddCrewCommand();
		when(request.getParameter("employeesId")).thenReturn("");
		when(request.getParameter("flightId")).thenReturn("d");
		when(request.getSession()).thenReturn(session);
		String path = addCrewCommand.executeCommand(request, response, "POST");
		assertEquals(path, Urls.REDIRECT_FLIGHT_INFO + "&id=d");

	}

	

}
