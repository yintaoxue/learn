package org.ruogu.learn.lang.object;

import java.util.HashSet;
import java.util.Set;

/**
 * ObjectEqual
 * 
 * @author xueyintao 2016年2月6日 上午10:16:41
 */
public class ObjectEqual {
	
	private int count;
	private String s;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectEqual other = (ObjectEqual) obj;
		if (count != other.count)
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjectEqual [count=" + count + ", s=" + s + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/** 测试Object的toString方法 */
		
		ObjectToString ots = new ObjectToString(10, "21");
		System.out.println(ots + "\n"); // org.ruogu.learn.lang.object.ObjectToString@6d06d69c
		// 因为Object默认的toString()方法：return getClass().getName() + "@" + Integer.toHexString(hashCode());

		
		
		/** 测试默认的hashCode生成方法，Object默认的hashCode方法根据对象的地址生成Integer */
		ObjectNoHashCode onhc1 = new ObjectNoHashCode(10, "s1");
		ObjectNoHashCode onhc2 = new ObjectNoHashCode(10, "s1");
		System.out.println("onhc1.equals(onhc2):" + onhc1.equals(onhc2));
		System.out.println("onhc1.hashCode():" + onhc1.hashCode());
		System.out.println("onhc2.hashCode():" + onhc2.hashCode());
		System.out.println("onhc2.hashCode():" + onhc2.hashCode());
		System.out.println();
		
		
		
		
		/** 测试hashCode方法在HashSet中的作用 */
		
		Set<ObjectNoHashCode> set = new HashSet<ObjectNoHashCode>();
		ObjectNoHashCode s1 = new ObjectNoHashCode(10, "s1");
		ObjectNoHashCode s2 = new ObjectNoHashCode(20, "s2");
		ObjectNoHashCode s3 = new ObjectNoHashCode(10, "s1");
		set.add(s1);
		set.add(s2);
		set.add(s3);
		
		// 会打印出三条记录
		for (ObjectNoHashCode s : set) {
			System.out.println(s);
		}
		System.out.println();
		
		
		Set<ObjectHasHashCode> set2 = new HashSet<ObjectHasHashCode>();
		ObjectHasHashCode s21 = new ObjectHasHashCode(10, "s1");
		ObjectHasHashCode s22 = new ObjectHasHashCode(20, "s2");
		ObjectHasHashCode s23 = new ObjectHasHashCode(10, "s1");
		set2.add(s21);
		set2.add(s22);
		set2.add(s23);
		
		// 会打印出两条记录
		for (ObjectHasHashCode s : set2) {
			System.out.println(s);
		}
		
	}

}

class ObjectToString {
	private int count;
	private String s;
	
	public ObjectToString(int count, String s) {
		this.count = count;
		this.s = s;
	}
}

class ObjectNoHashCode {
	private int count;
	private String s;
	
	public ObjectNoHashCode(int count, String s) {
		this.count = count;
		this.s = s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectNoHashCode other = (ObjectNoHashCode) obj;
		if (count != other.count)
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjectNoHashCode [count=" + count + ", s=" + s + "]";
	}
}

class ObjectHasHashCode {
	private int count;
	private String s;
	
	public ObjectHasHashCode(int count, String s) {
		this.count = count;
		this.s = s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectHasHashCode other = (ObjectHasHashCode) obj;
		if (count != other.count)
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ObjectHasHashCode [count=" + count + ", s=" + s + "]";
	}
}

