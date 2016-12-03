package org.ruogu.learn.lang.waitnotify;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * MultiThreadShareVariable
 * 
 * @author xueyintao 2016年12月3日 下午5:29:29
 */
public class MultiThreadShareVariable extends Thread {
	private int id;
	
	// 线程私有变量
	private int count = 0;
	
	// 多线程共享变量
	private static int scount = 0;
	private static volatile int vcount = 0;
	private static AtomicInteger acount = new AtomicInteger(0);
	
	private Counter counter;
	
	MultiThreadShareVariable(int id, Counter counter) {
		this.id = id;
		this.counter = counter;
	}
	
	@Override
	public void run() {
		System.out.println("start " + id);
		
		for (int i = 0; i < 10000; i++) {
			count++;
			scount++;
			vcount++;
			acount.incrementAndGet();
			counter.incr();
		}
		
		System.out.println("end " + id + ",count:" + count + ", scount:" + scount + ",vcount:" + vcount + ",acount:"
				+ acount.intValue() + ", " + counter.get());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter counter = new Counter();
		MultiThreadShareVariable t1 = new MultiThreadShareVariable(1, counter);
		MultiThreadShareVariable t2 = new MultiThreadShareVariable(2, counter);
		t1.start();;
		t2.start();;
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main: scount:" + scount + ", vcount:" + vcount + ",acount:" + acount.intValue() + ", "
				 + counter.get());
		
//		end 1,count:10000, scount:19634,vcount:19654,acount:19858, c.count19906,c.acount:20000,c.scount:20000
//		end 2,count:10000, scount:19879,vcount:19880,acount:20000, c.count19946,c.acount:20000,c.scount:20000
//		main: scount:19879, vcount:19880,acount:20000, c.count19946,c.acount:20000,c.scount:20000
		
	}

}

class Counter {
	private int count = 0;
	private AtomicInteger acount = new AtomicInteger(0);
	private int scount = 0;
	
	public void incr() {
		count++;
		acount.incrementAndGet();
		synchronized (Counter.class) {
			scount++;
		}
	}
	
	public String get() {
		return "c.count" + count + ",c.acount:" + acount.intValue() + ",c.scount:" + scount;
	}
}


