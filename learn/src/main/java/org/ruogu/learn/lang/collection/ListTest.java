package org.ruogu.learn.lang.collection;

import java.util.Arrays;
import java.util.List;

/**
 * List
 * 
 * @author xueyintao 2016年2月27日 下午10:18:12
 */
public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("a", "b", "c");
		System.out.println(list1);
		
		String[] arr = {"d", "e"};
		List<String> list2 = Arrays.asList(arr);
		System.out.println(list2);
		
	}

}
