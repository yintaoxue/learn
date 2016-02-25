package org.ruogu.learn.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static final long ONEDAY_MILLISECONDS = 1000 * 3600 * 24;
	public static final long ONEHOUR_MILLISECONDS = 1000 * 3600;

	public static final String DATETIME_FORMATSTR = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMATSTR = "yyyy-MM-dd";

	public static Date getToday() {
		return getDate(getNow());
	}

	/**
	 * 鍙栧緱鏃ユ湡閮ㄥ垎
	 * 
	 * @param now
	 * @return
	 */
	public static Date getDate(Date now) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();

	}

	public static Date getNow() {
		return new Date();
	}

	public static Date addYear(Date date, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}

	public static Date addMonth(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	public static Date addDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	public static Date addWeek(Date date, int week) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, week);
		return cal.getTime();
	}

	public static Date addHour(Date date, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, hour);
		return cal.getTime();
	}

	public static Date addMinute(Date date, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
	}

	public static Date addSecond(Date date, int second) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, second);
		return cal.getTime();
	}

	public static String formatDate(Date date, String formatStr) {
		SimpleDateFormat today_format = new SimpleDateFormat(formatStr);
		return today_format.format(date);
	}

	public static Date parseDate(String dateStr, String formatStr) throws Exception {
		SimpleDateFormat datetime_format = new SimpleDateFormat(formatStr);
		return datetime_format.parse(dateStr);
	}

	public static long betweenDay(Date before, Date after) {
		before = getDate(before);
		after = getDate(after);
		return (before.getTime() - after.getTime()) / ONEDAY_MILLISECONDS;
	}

}