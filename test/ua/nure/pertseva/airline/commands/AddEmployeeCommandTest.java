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

public class AddEmployeeCommandTest {

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
		AddEmployeeCommand addEmployeeCommand = new AddEmployeeCommand();
		String path = addEmployeeCommand.executeCommand(request, response, "GET");
		assertEquals(path, Urls.ERROR_PAGE);
	}

	@Test
	public void testExecutePostCommandWithError() throws IOException, SQLException {

		AddEmployeeCommand addEmployeeCommand = new AddEmployeeCommand();
		when(request.getParameter("surname")).thenReturn("");
		when(request.getParameter("firstname")).thenReturn("");
		when(request.getParameter("occupation")).thenReturn("");
		when(request.getSession()).thenReturn(session);
		String path = addEmployeeCommand.executeCommand(request, response, "POST");
		assertEquals(path, Urls.REDIRECT_LIST_EMPLOYEES);

	}

}
