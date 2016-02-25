/**
 * 
 */
package org.ruogu.learn.lang.collection;

import java.util.Calendar;
import java.util.Date;

/**
 * CalendarTest
 * 
 * @author xueyintao 2015年12月11日上午11:42:01
 */
public class CalendarTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Calendar todayStartTime = Calendar.getInstance();
//		todayStartTime.set(Calendar.HOUR_OF_DAY, 0);
//		todayStartTime.set(Calendar.MINUTE, 0);
//		todayStartTime.set(Calendar.SECOND, 0);
//		System.out.println(todayStartTime.getTime());
//		
//		Calendar tmp_v_date = Calendar.getInstance();
//		tmp_v_date.set(Calendar.HOUR_OF_DAY, 0);
//		tmp_v_date.set(Calendar.MINUTE, 0);
//		tmp_v_date.set(Calendar.SECOND, 0);
//		tmp_v_date.add(Calendar.DATE, 1);
//		System.out.println(tmp_v_date.getTime());
		Date endTime = new Date();
		
		Calendar todayStartTime = Calendar.getInstance();
		todayStartTime.set(Calendar.HOUR_OF_DAY, 0);
		todayStartTime.set(Calendar.MINUTE, 0);
		todayStartTime.set(Calendar.SECOND, 0);
		System.out.println("endTime:" + endTime);
		System.out.println("todayStartTime:" + todayStartTime.getTime());
		if (endTime != null && endTime.after(todayStartTime.getTime())) {
			Calendar endDayTime = Calendar.getInstance();
			endDayTime.set(Calendar.HOUR_OF_DAY, 0);
			endDayTime.set(Calendar.MINUTE, 0);
			endDayTime.set(Calendar.SECOND, 0);
			endDayTime.add(Calendar.DATE, 1);
			endTime = endDayTime.getTime();
			System.out.println("endDayTime:" + endDayTime.getTime());
		}
		System.out.println("todayStartTime:" + todayStartTime.getTime());
		System.out.println("endTime-new:" + endTime);
		
	}

}
