package ua.khnucea.csit.cs.pertseva.airline.commands;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CommandManagerTest {

	@Test
	public void testGetCommand() throws IOException {
		CommandManager commandManager = new CommandManager();
		AbstractCommand command = commandManager.getCommand("login");
		assertEquals(command.getClass(), LoginCommand.class);
	}

}
