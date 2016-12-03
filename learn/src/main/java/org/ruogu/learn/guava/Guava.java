package org.ruogu.learn.guava;

import com.google.common.base.Objects;

/**
 * Guava
 * 
 * @author xueyintao 2016年9月30日 下午4:01:47
 */
public class Guava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s1 = null;
		String s2 = "s2";
		
		System.out.println(Objects.equal(s1, s2));
		
	}

}
