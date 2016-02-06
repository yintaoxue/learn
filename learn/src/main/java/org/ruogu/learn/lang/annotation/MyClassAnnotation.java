package org.ruogu.learn.lang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MyClassAnnotation
 * 
 * @author xueyintao 2016年2月6日 下午5:39:27
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyClassAnnotation {
	public String name();

	public String value();
}
