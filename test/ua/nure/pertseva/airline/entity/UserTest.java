package ua.nure.pertseva.airline.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user;
	
	@Before
	public void testUser() {
		user  = new User(1, "email", "password", "role");
	}
	
	
	@Test
	public void testGetUserId() {
		int id = user.getUserId();
		assertEquals(id, 1);
	}

	@Test
	public void testSetUserId() {
		user.setUserId(2);
		int id = user.getUserId();
		assertEquals(id, 2);
	}

	@Test
	public void testGetUserEmail() {
		String email = user.getUserEmail();
		assertEquals(email, "email");
	}

	@Test
	public void testSetUserEmail() {
		user.setUserEmail("newEmail");
		String email = user.getUserEmail();
		assertEquals(email, "newEmail");
	}

	@Test
	public void testGetUserPassword() {
		String password = user.getUserPassword();
		assertEquals(password, "password");
	}

	@Test
	public void testSetUserPassword() {
		user.setUserPassword("newPassword");
		String password = user.getUserPassword();
		assertEquals(password, "newPassword");
	}

	@Test
	public void testGetUserRole() {
		String role = user.getUserRole();
		assertEquals(role, "role");
	}

	@Test
	public void testSetUserRole() {
		user.setUserRole("newRole");
		String role = user.getUserRole();
		assertEquals(role, "newRole");
	}

	

}
