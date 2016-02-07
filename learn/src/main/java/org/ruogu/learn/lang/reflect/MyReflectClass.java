package org.ruogu.learn.lang.reflect;

/**
 * MyReflectClass
 * 
 * @author xueyintao 2016年2月6日 下午7:32:47
 */
public class MyReflectClass {
	
	// count
	public int count = 1;
	
	// name
	private String name = "name1";
	
	// age
	public static Integer age = 2;
	
	/** 空构造方法 */
	public MyReflectClass() {
	}
	
	/** 构造方法 */
	public MyReflectClass(Integer c, String s) {
		this.count = c;
		this.name = s;
	}
	
	/**
	 * 打印信息
	 */
	public void print() {
		System.out.println("print12345……");
	}
	
	/**
	 * 打印add值
	 * @return
	 */
	public Integer printAdd(Integer a, Integer b) {
		System.out.println("print:" + a + " + " + b + " = " + (a + b));
		return a + b;
	}
	
	/**
	 * 打印add值
	 * @return
	 */
	private Integer printAddPrivate(Integer a, Integer b) {
		System.out.println("printAddPrivate:" + a + " + " + b + " = " + (a + b));
		return a + b;
	}
	
	/**
	 * 测试参数类型
	 * @param a
	 * @param b
	 */
	public int test(int a, Integer b) {
		return a + b;
	}
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public static Integer getAge() {
		return age;
	}

	public static void setAge(Integer age) {
		MyReflectClass.age = age;
	}

	@Override
	public String toString() {
		return "MyReflectClass [count=" + count + ", name=" + name + "]";
	}
	
	class MyReflectInnerClass {
		
	}
}
