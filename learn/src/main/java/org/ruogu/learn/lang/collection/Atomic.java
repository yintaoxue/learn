/**
 * 
 */
package org.ruogu.learn.lang.collection;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Atomic
 * 
 * @author xueyintao 2016年1月2日下午5:00:50
 */
public class Atomic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AtomicLong along = new AtomicLong(0);
		
		long rs1 = along.incrementAndGet();
		long rs2 = along.incrementAndGet();
		
		System.out.println("rs1:" + rs1 + ",rs2:" + rs2);
		
	}
	

}
