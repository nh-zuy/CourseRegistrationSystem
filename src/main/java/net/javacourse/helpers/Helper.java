package net.javacourse.helpers;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 
 * @author zuy
 *
 */
public class Helper {
	/**
	 * Helper class
	 */
	
	/**
	 * 
	 * @param dateToConvert
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	/**
	 * 
	 * @param dateToConvert
	 * @return
	 */
	public static LocalDateTime toLocalDateTimes(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date toDate(LocalDateTime date) {
		return Timestamp.valueOf(date);
	}
}
