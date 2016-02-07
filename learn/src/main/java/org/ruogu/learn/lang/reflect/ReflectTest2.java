package org.ruogu.learn.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ReflectTest2
 * 
 * @author xueyintao 2016年2月6日 下午8:13:15
 */
public class ReflectTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 获得构造方法
		System.out.println("获得构造方法");
		Constructor[] cons = MyReflectClass.class.getConstructors(); // public
		for (Constructor c : cons) {
			System.out.println("" + c.getName());
		}
		try {
			// Integer.class不能表示int类型的参数
			Constructor consParam = MyReflectClass.class.getConstructor(new Class[]{Integer.class, String.class});
			System.out.println("consParam.getName:" + consParam.getName());
			Class[] params = consParam.getParameterTypes();
			for (Class c : params) {
				System.out.println("consParam.param:" + c.getName());
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		// 创建对象
		System.out.println("创建对象");
		Class clazz = MyReflectClass.class;
		MyReflectClass myRef = null;
		try {
			myRef = (MyReflectClass)clazz.newInstance();
			myRef.print();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		// 设置field的值
		System.out.println("设置field的值");
		try {
			Field field = MyReflectClass.class.getField("age");
			Object fieldValue = field.get(myRef);
			System.out.println("value of field age:" + fieldValue);
			field.set(myRef, 3);
			System.out.println("value of myRef age:" + myRef.getAge());
			field.set(null, 4);
			System.out.println("value of myRef age:" + myRef.getAge());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		// 调用method
		System.out.println("调用method");
		try {
			Method method = MyReflectClass.class.getMethod("printAdd", Integer.class, Integer.class);
			Object result = method.invoke(myRef, 1, 2);
			System.out.println("method return:" + result);
			
			Method methodGet = MyReflectClass.class.getMethod("getAge", null);
			Object resultGet = methodGet.invoke(myRef, null);
			System.out.println("method get return:" + resultGet);
			
			Method methodGet2 = MyReflectClass.class.getMethod("test", int.class, Integer.class);
			Object resultGet2 = methodGet2.invoke(myRef, 3, 4);
			System.out.println("resultGet2 get return:" + resultGet2);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		
		// 获得私有变量和方法
		System.out.println("获得私有变量和方法");
		try {
			Field privateField = MyReflectClass.class.getDeclaredField("name");
			System.out.println("privateField:" + privateField.getName());
			privateField.setAccessible(true); // 需要设置为true，否则获得成员值时报错：java.lang.IllegalAccessException
			Object privateValue = privateField.get(myRef);
			System.out.println("privateFieldValue:" + privateValue);
			
			System.out.println();
			Method privateMethod = MyReflectClass.class.getDeclaredMethod("printAddPrivate", Integer.class, Integer.class);
			System.out.println("privateMethod.name:" + privateMethod.getName());
			privateMethod.setAccessible(true);
			Object result = privateMethod.invoke(myRef, 10, 20);
			System.out.println("privateMethod result:" + result);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
