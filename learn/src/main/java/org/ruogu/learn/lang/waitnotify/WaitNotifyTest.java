package org.ruogu.learn.lang.waitnotify;

/**
 * WaitNotifyTest
 * 
 * @author xueyintao 2016年12月3日 下午5:29:29
 */
public class WaitNotifyTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Object lock = new Object();
		
		
		
	}

}

class WaitThread extends Thread {
	
	private Object lock;
	
	WaitThread(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		System.out.println("WaitThread start...");
		
		synchronized (lock) {
			System.out.println("WaitThread get lock.");
			
		}
		
		System.out.println("WaitThread end...");
	}
	
}

class NotifyThread extends Thread {

	private Object lock;
	
	NotifyThread(Object lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		System.out.println("NotifyThread start...");
		
		System.out.println("NotifyThread end...");
	}
	
}