/**
 * 
 */
package org.ruogu.learn.lang.collection;

import java.util.Arrays;

/**
 * 
 * @author xueyintao 下午6:36:07
 */
public class Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = new String[4];
		arr[0] = "aa1";
		arr[1] = "bb2";
		arr[2] = "cc3";
		arr[3] = "dd3";
		
		System.out.println(arr);
		System.out.println(arr.toString());
		System.out.println(Arrays.toString(arr));

		String[][] arrs = new String[2][2];
		String[] a1 = {"a1", "a2"};
		String[] a2 = {"b1", "b2"};
		arrs[0] = a1;
		arrs[1] = a2;
		
		System.out.println(arrs);
		System.out.println(arrs.toString());
		System.out.println(Arrays.toString(arrs));
		System.out.println(Arrays.deepToString(arrs));
		
		String[] arrnull = null;
		System.out.println(Arrays.toString(arrnull));
		
	}

}
