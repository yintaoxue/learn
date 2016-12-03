/**
 * 
 */
package org.ruogu.learn.lang.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * SetTest
 * 
 * @author xueyintao 2015年12月6日下午1:18:11
 */
public class SetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Long> set = new HashSet<Long>();
		set.add(55L);
		set.add(56L);
		set.add(1000L);
		
		System.out.println("Set<Long>:" + set);
		System.out.println("set.contains(55L):" + set.contains(55L));
		System.out.println("set.contains(56L):" + set.contains(56L));
		System.out.println("set.contains(56):" + set.contains(56));
		System.out.println("set.contains(1000L):" + set.contains(1000L));
		System.out.println("set.contains(new Long(56)):" + set.contains(new Long(56)));
		
		Set<String> setStr = new HashSet<String>();
		setStr.add("55");
		setStr.add("56");
		
		System.out.println("Set<String>:" + setStr);
		System.out.println("setStr.contains(\"56\")" + setStr.contains("56"));
		System.out.println("setStr.contains(56)" + setStr.contains(56));
		
		Set<Long> lset = new HashSet<Long>();
		lset.add(55L);
		lset.add(55L);
		lset.add(56L);
		System.out.println(lset);
		
		HashSet<Long> llset = new HashSet<Long>();
		llset.iterator();
	}

}
