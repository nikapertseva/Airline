package ua.khnucea.csit.cs.pertseva.airline.utils;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import org.junit.Test;

public class FormatterTest {

	@Test
	public void testFormatDate() {
		assertEquals(Formatter.formatDate(Timestamp.valueOf("2018-05-10 13:15:16")), Date.valueOf("2018-05-10"));
	}
	
	@Test
	public void testFormatTime() {
		assertEquals(Formatter.formatTime(Timestamp.valueOf("2018-05-10 13:15:16")), Time.valueOf("10:15:16"));
	}

}
