package org.ruogu.learn.lang.clazz;

public class Clazz {

	public static void main(String[] args) {
		getResource();
	}
	
	/**
	 * 获得当前类的所在path
	 */
	public static void getResource() {
		String path = Clazz.class.getResource("/").getPath();
		System.out.println(path); // /Users/xueyintao/project/Github/learn/learn/target/classes/
		
		path = Clazz.class.getResource("").getPath();
		System.out.println(path); // /Users/xueyintao/project/Github/learn/learn/target/classes/org/ruogu/learn/jdk/clazz/
		
		// error ClassLoad调用getResource路径不能为"/"
		path = Clazz.class.getClassLoader().getResource("/").getPath();
		
		path = Clazz.class.getClassLoader().getResource("").getPath();
		System.out.println(path); // /Users/xueyintao/project/Github/learn/learn/target/classes/
	
	}

}
