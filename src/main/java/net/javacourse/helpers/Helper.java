package net.javacourse.helpers;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
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
	public static Date DTtoDate(LocalDateTime date) {
		return Timestamp.valueOf(date);
	}
	
	/**
	 * 
	 * @param buffer
	 * @return
	 */
	public static int parseSemesterId(String buffer) {
		String token[] = buffer.split(" ");
		String semID = token[3].replace("(", "").replace(")", "");
		int ID = Integer.parseInt(semID);
		
		return ID;
	}
	
	/**
	 * 
	 * @param buffer
	 * @return
	 */
	public static int parseClassId(String buffer) {
		String token[] = buffer.split(" ");
		String semID = token[1].replace("(", "").replace(")", "");
		int ID = Integer.parseInt(semID);
		
		return ID;
	}
	
	/**
	 * 
	 * @param buffer
	 * @return
	 */
	public static String parseCode(String buffer) {
		String token[] = buffer.split("[(]");
		String code = token[1].replace(")", "").trim();
		
		return code;
	}
	
	/**
	 * 
	 * @param dateToConvert
	 * @return
	 */
	public static LocalDate toLocalDate(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	/**
	 * 
	 * @param dateToConvert
	 * @return
	 */
	public static Date DtoDate(LocalDate dateToConvert) {
	    return java.util.Date.from(dateToConvert.atStartOfDay()
	      .atZone(ZoneId.systemDefault())
	      .toInstant());
	}
}
