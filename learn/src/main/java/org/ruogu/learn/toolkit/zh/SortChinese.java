package org.ruogu.learn.toolkit.zh;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * SortChinese
 * 
 * @author xueyintao 2016年2月27日 下午10:23:35
 */
public class SortChinese {

	private final static Comparator CHINESE_COMPARATOR = Collator.getInstance(java.util.Locale.CHINA);

	public static void main(String[] args) {
		List<String> list = Arrays.asList("中文", "排序", "测试");
		Collections.sort(list, CHINESE_COMPARATOR);
		System.out.println(list);
		
		String[] arr = {"中文", "排序", "测试"};
		Arrays.sort(arr, CHINESE_COMPARATOR);
		System.out.println(Arrays.asList(arr));
		
	}

}
