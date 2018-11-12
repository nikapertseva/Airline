package ua.nure.pertseva.airline.commands;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.nure.pertseva.airline.constants.Urls;

public class AddRequestCommandTest {

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
		AddRequestCommand addRequestCommand = new AddRequestCommand();
		String path = addRequestCommand.executeCommand(request, response, "GET");
		assertEquals(path, Urls.ERROR_PAGE);
	}

	

}
