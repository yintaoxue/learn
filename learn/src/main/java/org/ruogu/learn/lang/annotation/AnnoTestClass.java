package org.ruogu.learn.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * AnnoTestClass
 * 
 * @author xueyintao 2016年2月6日 下午5:39:01
 */
@MyClassAnnotation(name = "myName123", value = "myValue456")
public class AnnoTestClass {

	@MyFieldAnnotation(name = "filed001")
	public String key;

	@MyMethodAnnotation("method123")
	public String getKey() {
		return key;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 获得class注解内容
		Annotation[] annos = AnnoTestClass.class.getAnnotations();
		for (Annotation a : annos) {
			if (a instanceof MyClassAnnotation) {
				MyClassAnnotation mya = (MyClassAnnotation) a;
				System.out.println("MyClassAnnotation.name:" + mya.name());
				System.out.println("MyClassAnnotation.name:" + mya.value());
			}
		}
		System.out.println();
		
		// 获得field注解, 如果key是private则报错java.lang.NoSuchFieldException
		try {
			Field filed = AnnoTestClass.class.getField("key");
			Annotation[] fieldAnnos = filed.getAnnotations();
			for (Annotation a : fieldAnnos) {
				MyFieldAnnotation mfa = (MyFieldAnnotation)a;
				System.out.println("MyFieldAnnotation.id:" + mfa.id());
				System.out.println("MyFieldAnnotation.name:" + mfa.name());
			}
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
		System.out.println();
		
		// 获得method注解
		try {
			Method method = AnnoTestClass.class.getMethod("getKey");
			Annotation[] methodAnnos = method.getAnnotations();
			for (Annotation a : methodAnnos) {
				if (a instanceof MyMethodAnnotation) {
					MyMethodAnnotation mma = (MyMethodAnnotation)a;
					System.out.println("MyMethodAnnotation.value:" + mma.value());
				}
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}

}
