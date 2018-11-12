package ua.nure.pertseva.airline.utils;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Class for formatting date and time.
 *
 * @author Pertseva Veronika
 *
 */
public class Formatter {

	/** Format for date. */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	/** Format for time. */
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

	/** Time zone. */
	private static final String TIME_ZONE = "GMT";

	/**
	 * Method formats date.
	 * 
	 * @param date - date
	 * @return formatted date
	 */
	public static Date formatDate(Timestamp date) {
		TIME_FORMAT.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
		return Date.valueOf(DATE_FORMAT.format(date));
	}

	/**
	 * Method formats time by time zone.
	 * 
	 * @param time - time
	 * @return formatted time
	 */
	public static Time formatTime(Timestamp time) {
		TIME_FORMAT.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
		return Time.valueOf(TIME_FORMAT.format(time));
	}

}
