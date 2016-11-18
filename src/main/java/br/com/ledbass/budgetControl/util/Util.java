package br.com.ledbass.budgetControl.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Use this class for miscellaneous methods;
 * 
 * Add and/or use methods from this class as needed
 * @author ledbass
 *
 */
public class Util {
	
	/**
	 * Use this method to convert a {@link Calendar} into a {@link String}
	 * @param calendarToConvert the {@link Calendar} object to be converted
	 * @return a {@link String} representation of the calendar received
	 */
	public String convertCalendarIntoString(Calendar calendarToConvert) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy - hh:MM:ss");
		String result = format.format(calendarToConvert.getTime());
		return result;
	}

}
