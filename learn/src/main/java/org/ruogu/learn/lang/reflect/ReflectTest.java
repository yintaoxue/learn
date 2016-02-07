package org.ruogu.learn.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import org.ruogu.learn.lang.reflect.MyReflectClass.MyReflectInnerClass;

/**
 * ReflectTest
 * 
 * @author xueyintao 2016年2月6日 下午7:32:15
 */
public class ReflectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 获得class
		System.out.println("获得class");
		Class class1 = MyReflectClass.class;
		Class class2 = null;
		try {
			class2 = Class.forName("org.ruogu.learn.lang.reflect.MyReflectClass");
			
			System.out.println("class.name:" + class1.getName());
			System.out.println("class.simpleName:" + class1.getSimpleName());
			System.out.println("class.canonicalName:" + class1.getCanonicalName());
			System.out.println("class1==class2:" + (class1 == class2));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		// 内部类的类名
		System.out.println("内部类的类名");
		Class innerClass = MyReflectInnerClass.class;
		System.out.println("innerClass.getName:" + innerClass.getName());
		System.out.println("innerClass.getCanonicalName:" + innerClass.getCanonicalName());
		System.out.println("innerClass.getSimpleName:" + innerClass.getSimpleName());
		System.out.println();
		
		// 数组的类名
		System.out.println("数组的类名");
		Class arrayClass = MyReflectClass[].class;
		System.out.println("arrayClass.getName:" + arrayClass.getName());
		System.out.println("arrayClass.getCanonicalName:" + arrayClass.getCanonicalName());
		System.out.println("arrayClass.getSimpleName:" + arrayClass.getSimpleName());
		System.out.println();

		// 修饰符
		System.out.println("修饰符");
		int modifiers = class1.getModifiers();
		System.out.println("isPublic:" + Modifier.isPublic(modifiers));
		System.out.println("isStatic:" + Modifier.isStatic(modifiers));
		System.out.println("isAbstract:" + Modifier.isAbstract(modifiers));
		System.out.println();
		
		// 获得报包
		System.out.println("获得报包");
		Package pkg = MyReflectClass.class.getPackage();
		System.out.println("package.getName:" + pkg.getName());
		System.out.println();
		
		// 获得method
		System.out.println("获得method");
		Method[] methods = MyReflectClass.class.getMethods();
		for (Method m : methods) {
			System.out.println("methods:" + m.getName());
			for (Parameter p : m.getParameters()) {
				System.out.println("param:" + p.getName() + "," + p.getType().getName());
			}
		}
		System.out.println();
		
		// 获得field，private的field获取不到
		System.out.println("获得field");
		Field[] fields = MyReflectClass.class.getFields();
		for (Field f : fields) {
			System.out.println("field:" + f.getName());
		}
		System.out.println();
		
	}

}
