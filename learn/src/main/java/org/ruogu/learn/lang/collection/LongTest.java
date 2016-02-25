/**
 * 
 */
package org.ruogu.learn.lang.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * LongTest
 * 
 * @author xueyintao 2015年12月6日下午5:26:08
 */
public class LongTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Long baseUserId = 123L;

		Set<Long> set = new HashSet<Long>();
		set.add(new Long(123));
		set.add(234L);

		for (Long l : set) {
			System.out.println("l " + l + " == baseUserId:" + (l == baseUserId));
			System.out.println("l " + l + " == baseUserId:" + (l.equals(baseUserId)));
		}

		Long l1 = 123L;
		Long l2 = 123L;

		System.out.println("l1 == l2:" + (l1 == l2));

		Long l3 = 123L;
		Long l4 = new Long(123L);

		System.out.println("l3 == l4:" + (l3 == l4));
		System.out.println("l3 == l4:" + (l3.longValue() == l4));
		System.out.println("l3 == l4:" + (l3.longValue() == l4.longValue()));
	}

}
