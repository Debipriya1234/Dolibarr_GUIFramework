package com.dolibarr.erp.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Deepak
 *
 */
public class JavaUtility {
	/**
	 * get the random number , in the range of 0-5000
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random ranDom = new Random();
		int ranDomNumber = ranDom.nextInt(5000);
		return ranDomNumber;
	}

	/**
	 * get the system date based on YYYY-DD-MM format
	 * 
	 * @return
	 */
	public String getSystemDateMMDDYYYY() {

		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY");
		String date = sdf.format(dateObj);
		return date.replace('-', '/');
	}

	/**
	 * get the TAT date based on YYYY-DD-MM format
	 * 
	 * @return
	 */
	public String getRequriedDateYYYYDDMM(int days) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
}
