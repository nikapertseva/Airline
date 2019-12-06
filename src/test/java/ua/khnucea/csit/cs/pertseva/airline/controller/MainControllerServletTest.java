package ua.khnucea.csit.cs.pertseva.airline.controller;

import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MainControllerServletTest {

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
	public void testDoGetWithNull() throws IOException, ServletException {
		MainControllerServlet mainControllerServlet = new MainControllerServlet();
		when(request.getParameter("command")).thenReturn(null);
		mainControllerServlet.doGet(request, response);
	}
	
	@Test
	public void testDoPost() throws IOException, ServletException {
		MainControllerServlet mainControllerServlet = new MainControllerServlet();
		when(request.getParameter("command")).thenReturn(null);
		mainControllerServlet.doPost(request, response);
	}
	
	
}
