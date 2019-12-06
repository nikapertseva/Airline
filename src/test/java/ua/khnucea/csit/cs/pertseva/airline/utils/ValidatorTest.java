package ua.khnucea.csit.cs.pertseva.airline.utils;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {

	@Test
	public void testValidateText() {
		assertEquals(Validator.validateText("text"), true);
		assertEquals(Validator.validateText(""), false);
		assertEquals(Validator.validateText(null), false);
	}

	@Test
	public void testValidateWord() {
		assertEquals(Validator.validateWord("text"), true);
		assertEquals(Validator.validateWord("4text"), false);
		assertEquals(Validator.validateWord(""), false);
		assertEquals(Validator.validateWord(null), false);
	}
	
	@Test
	public void testValidateDate() {
		assertEquals(Validator.validateDate("2018-11-10"), true);
		assertEquals(Validator.validateDate("error"), false);
		assertEquals(Validator.validateDate(""), false);
		assertEquals(Validator.validateDate(null), false);
	}
	
	@Test
	public void testValidateTime() {
		assertEquals(Validator.validateTime("13:50"), true);
		assertEquals(Validator.validateTime("error"), false);
		assertEquals(Validator.validateTime(""), false);
		assertEquals(Validator.validateTime(null), false);
	}
	
	@Test
	public void testValidateDateWithoutPreviousDays() {
		assertEquals(Validator.validateDateWithoutPreviousDays("2118-11-09"), true);
		assertEquals(Validator.validateDateWithoutPreviousDays("2018-11-09"), false);
		assertEquals(Validator.validateDateWithoutPreviousDays("error"), false);
		assertEquals(Validator.validateDateWithoutPreviousDays(""), false);
		assertEquals(Validator.validateDateWithoutPreviousDays(null), false);
	}
	
	@Test
	public void testValidateDateTimeBefore() {
		assertEquals(Validator.validateDateTimeBefore(null, null, null, null),false);
		assertEquals(Validator.validateDateTimeBefore("2118-11-09", "13:50", "2118-11-10", "13:50"),true);
		assertEquals(Validator.validateDateTimeBefore("2118-11-09", "13:50", "2118-11-09", "18:50"),true);
		assertEquals(Validator.validateDateTimeBefore("2118-11-09", "13:50", "2118-11-09", "11:50"),false);
		assertEquals(Validator.validateDateTimeBefore("2118-11-05", "13:50", "2118-11-04", "11:50"),false);
		assertEquals(Validator.validateDateTimeBefore("2118-11-05", null, null, null),false);
		assertEquals(Validator.validateDateTimeBefore("2118-11-05", "13:50", null, null),false);
		assertEquals(Validator.validateDateTimeBefore("2118-11-05", "13:50", "2118-11-04", null),false);
		assertEquals(Validator.validateDateTimeBefore("2118-11-05", "13:50", null, "11:50"),false);
		assertEquals(Validator.validateDateTimeBefore("2118-11-05", null, "2118-11-04", "11:50"),false);
	}
	
	@Test
	public void testValidateInt() {
		assertEquals(Validator.validateInt("21"), true);
		assertEquals(Validator.validateInt("error"), false);
		assertEquals(Validator.validateInt(""), false);
		assertEquals(Validator.validateInt(null), false);
	}
	
	@Test
	public void testValidateEmail() {
		assertEquals(Validator.validateEmail("email@gmail.com"), true);
		assertEquals(Validator.validateEmail("error"), false);
		assertEquals(Validator.validateEmail(""), false);
		assertEquals(Validator.validateEmail(null), false);
	}
	
	@Test
	public void testValidatePassword() {
		assertEquals(Validator.validatePassword("password123"), true);
		assertEquals(Validator.validatePassword("error///"), false);
		assertEquals(Validator.validatePassword(""), false);
		assertEquals(Validator.validatePassword(null), false);
	}
}
