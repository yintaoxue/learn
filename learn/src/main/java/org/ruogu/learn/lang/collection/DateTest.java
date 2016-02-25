package org.ruogu.learn.lang.collection;

import java.util.Date;

import org.ruogu.learn.util.DateUtils;

/**
 * Date
 * 
 * @author xueyintao 2015年12月10日上午12:43:49
 */
public class DateTest {

	private static String day = "2015-12-08";
	private static Date blockStartTime = null;
	private static Date blockEndTime = null;
	private static String blockStartTimeStr = null;
	private static String blockEndTimeStr = null;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		blockStartTimeStr = "00:00:00";
		blockEndTimeStr = "10:10:00";
//		day = DateUtils.formatDate(new Date(), DateUtils.DATE_FORMATSTR);
		blockStartTime = DateUtils.parseDate(day + " " + blockStartTimeStr, DateUtils.DATETIME_FORMATSTR);
		blockEndTime = DateUtils.parseDate(day + " " + blockEndTimeStr, DateUtils.DATETIME_FORMATSTR);

		System.out.println(isBlock());

	}

	private static boolean isBlock() throws Exception {
		if (blockStartTime != null && blockEndTime != null) {
			Date now = new Date();
			String nowDay = DateUtils.formatDate(now, DateUtils.DATE_FORMATSTR);
			if (!nowDay.equals(day)) {
				day = nowDay;
				blockStartTime = DateUtils.parseDate(day + " " + blockStartTimeStr, DateUtils.DATETIME_FORMATSTR);
				blockEndTime = DateUtils.parseDate(day + " " + blockEndTimeStr, DateUtils.DATETIME_FORMATSTR);
				System.out.println("day:" + day + ",blockStartTime:"
						+ DateUtils.formatDate(blockStartTime, DateUtils.DATETIME_FORMATSTR) + ",blockEndTimeStr:"
						+ DateUtils.formatDate(blockEndTime, DateUtils.DATETIME_FORMATSTR));
			}
			if (now.after(blockStartTime) && now.before(blockEndTime)) {
				return true;
			}
		}
		return false;
	}

}
