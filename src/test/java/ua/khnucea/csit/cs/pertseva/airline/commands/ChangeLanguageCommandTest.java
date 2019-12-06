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

public class ChangeLanguageCommandTest {

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
		ChangeLanguageCommand changeLanguageCommand = new ChangeLanguageCommand();
		String path = changeLanguageCommand.executeCommand(request, response, "GET");
		Assert.assertEquals(path, Urls.ERROR_PAGE);
	}

	@Test
	public void testExecutePostCommandWithError() throws IOException, SQLException {

		ChangeLanguageCommand changeLanguageCommand = new ChangeLanguageCommand();
		when(request.getParameter("url")).thenReturn("");
		when(request.getParameter("lang")).thenReturn("");
		when(request.getSession()).thenReturn(session);
		String path = changeLanguageCommand.executeCommand(request, response, "POST");
		assertEquals(path, Urls.REDIRECT_LOGIN_PAGE);

	}
	
	@Test
	public void testExecutePostCommand() throws IOException, SQLException {

		ChangeLanguageCommand changeLanguageCommand = new ChangeLanguageCommand();
		when(request.getParameter("url")).thenReturn("url");
		when(request.getParameter("lang")).thenReturn("");
		when(request.getSession()).thenReturn(session);
		String path = changeLanguageCommand.executeCommand(request, response, "POST");
		assertEquals(path, "controller?url");

	}
}
