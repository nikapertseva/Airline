package ua.nure.pertseva.airline.commands;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.nure.pertseva.airline.constants.Urls;

public class EditFlightsStatusCommandTest {

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
		EditFlightsStatusCommand editFlightsStatusCommand = new EditFlightsStatusCommand();
		String path = editFlightsStatusCommand.executeCommand(request, response, "GET");
		assertEquals(path, Urls.ERROR_PAGE);
	}

	

}
