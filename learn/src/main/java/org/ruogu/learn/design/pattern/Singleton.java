package org.ruogu.learn.design.pattern;

import java.io.Serializable;

/**
 * Singleton
 * 
 * @author xueyintao 2016年2月22日 下午10:45:48
 */
public class Singleton {
	
	private volatile static Singleton instance = null;	// volatile 线程能够自动发现其最新值
	
	private Singleton() {
	}
	
	/**
	 * 延迟加载
	 * 
	 * @return
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {	// double check 多线程情况下，不管哪个线程先获得锁，都不能阻止其他线程后续再获得锁进入代码块
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
	}

}

class Singleton1 {
	// JVM保证只初始化一次，在类加载时，初始化静态属性，只能由一个线程初始化一次，保证并发环境下不受影响
	private static Singleton1 instance = new Singleton1();
	
	private Singleton1() {}
	
	/**
	 * 非延迟加载
	 * 
	 * @return
	 */
	public static Singleton1 getInstance() {
		return instance;
	}
}

class LazySignleton {
	private LazySignleton() {}
	
	private static class LazyLoader {
		private static final LazySignleton instance = new LazySignleton();
	}
	
	public LazySignleton getInstance() {
		return LazyLoader.instance;
	}
	
}

/**
 * SerializableSingleton
 * http://www.javalobby.org/java/forums/t17491.html
 * 序列化对象通过流传给调用者，当调用者从ObjectInputStream流中读取序列化对象时，
 * 序列化对象返回给调用者之前会先查看是否已经实现这个方法，如果实现那么就返回这个对象的返回值
 * 
 * @author xueyintao 2016年2月22日 下午11:06:56
 */

class SerializableSingleton implements Serializable {
	private static final long serialVersionUID = 3595847795950590899L;
	
	static SerializableSingleton instance = new SerializableSingleton();
	
	private SerializableSingleton() {}
	
	private Object readResolve() {
		return instance;
	}
	
}


