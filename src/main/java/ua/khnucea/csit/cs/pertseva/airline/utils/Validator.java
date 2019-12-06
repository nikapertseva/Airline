package ua.khnucea.csit.cs.pertseva.airline.utils;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Class for validating inputs.
 *
 * @author Pertseva Veronika
 *
 */
public class Validator {

	/** Regular expression for text (only letters). */
	private static final String REGEXP_WORD = "\\w+";

	/** Regular expression for date. */
	private static final String REGEXP_DATE = "\\d{4}-\\d{2}-\\d{2}";

	/** Regular expression for time. */
	private static final String REGEXP_TIME = "\\d{2}:\\d{2}:\\d{2}";

	/** Regular expression for integer. */
	private static final String REGEXP_INT = "\\d+";

	/** Regular expression for email. */
	private static final String REGEXP_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/** Regular expression for password. */
	private static final String REGEXP_PASSWORD = "\\w+";

	/**
	 * Method for validating text.
	 * 
	 * @param str - input
	 * @return true or false
	 */
	public static boolean validateText(String str) {
		boolean result = true;
		if (Objects.isNull(str) || str.equals("")) {
			result = false;
		}
		return result;
	}

	/**
	 * Method for validating text (only letters).
	 * 
	 * @param str - input
	 * @return true or false
	 */
	public static boolean validateWord(String str) {
		boolean result = true;
		if (Objects.isNull(str) || str.equals("") || !str.matches(REGEXP_WORD)) {
			result = false;
		}
		return result;
	}

	/**
	 * Method for validating date.
	 * 
	 * @param str - input
	 * @return true or false
	 */
	public static boolean validateDate(String str) {
		boolean result = true;
		if (Objects.isNull(str) || str.equals("") || !str.matches(REGEXP_DATE)) {
			result = false;
		}
		return result;
	}

	/**
	 * Method for validating time.
	 * 
	 * @param str - input
	 * @return true or false
	 */
	public static boolean validateTime(String str) {
		boolean result = true;
		if (Objects.isNull(str) || str.equals("") || !str.matches(REGEXP_TIME)) {
			result = false;
		}
		return result;
	}

	/**
	 * Method for validating date (without previous dates).
	 * 
	 * @param str - input
	 * @return true or false
	 */
	public static boolean validateDateWithoutPreviousDays(String str) {
		boolean result = true;
		if (Objects.isNull(str) || str.equals("") || !str.matches(REGEXP_DATE)) {
			result = false;
		} else {
			LocalDate date = LocalDate.parse(str);
			if (date.isBefore(LocalDate.now())) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * Method checks that first date and time are before second date and time.
	 * 
	 * @param firstDate  - first date
	 * @param firstTime  - first time
	 * @param secondDate - second date
	 * @param secondTime - second time
	 * @return true or false
	 */
	public static boolean validateDateTimeBefore(String firstDate, String firstTime, String secondDate,
			String secondTime) {
		boolean result = false;
		if (validateDateWithoutPreviousDays(firstDate) && validateDateWithoutPreviousDays(secondDate)
				&& validateTime(firstTime) && validateTime(secondTime)) {

			LocalDate dateDeparture = LocalDate.parse(firstDate);
			LocalDate dateArrival = LocalDate.parse(secondDate);
			Time timeDeparture = Time.valueOf(firstTime);
			Time timeArrival = Time.valueOf(secondTime);
			if (!dateArrival.isBefore(dateDeparture)) {
				if (dateDeparture.equals(dateArrival)) {
					if (timeDeparture.before(timeArrival)) {
						result = true;
					}
				} else {
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * Method for validating integer.
	 * 
	 * @param str - input
	 * @return true or false
	 */
	public static boolean validateInt(String str) {
		boolean result = true;
		if (Objects.isNull(str) || str.equals("") || !str.matches(REGEXP_INT)) {
			result = false;
		}
		return result;
	}

	/**
	 * Method for validating email.
	 * 
	 * @param str - input
	 * @return true or false
	 */
	public static boolean validateEmail(String str) {
		boolean result = true;
		if (Objects.isNull(str) || str.equals("") || !str.matches(REGEXP_EMAIL)) {
			result = false;
		}
		return result;
	}

	/**
	 * Method for validating password.
	 * 
	 * @param str - input
	 * @return true or false
	 */
	public static boolean validatePassword(String str) {
		boolean result = true;
		if (Objects.isNull(str) || str.equals("") || !str.matches(REGEXP_PASSWORD)) {
			result = false;
		}
		return result;
	}
}
