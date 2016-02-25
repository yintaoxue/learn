/**
 * 
 */
package org.ruogu.learn.lang.collection;

import java.util.Arrays;

/**
 * StringTest
 * 
 * @author xueyintao 2016年2月24日下午5:49:16
 */
public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] ss = new String[4];
		ss[0] = "a";
		ss[1] = "b";
		
		System.out.println(ss);
		System.out.println(ss.toString());
		System.out.println(Arrays.toString(ss));
	}

}
