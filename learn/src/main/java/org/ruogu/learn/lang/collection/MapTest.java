package org.ruogu.learn.lang.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		testListToMap();
		
	}
	
	/**
	 * 将List转换为map
	 */
	public static void testListToMap() {
		List<Mem> list = new ArrayList<Mem>();
		Mem m1 = new Mem();
		m1.name = "m1";
		m1.age = 11;
		list.add(m1);
		Mem m2 = new Mem();
		m2.name = "m2";
		m2.age = 12;
		list.add(m2);
		Mem m3 = new Mem();
		m3.name = "m2";
		m3.age = 13;
		list.add(m3);
		
		Map<String, List<Mem>> memMap = new HashMap<String, List<Mem>>();
		
		for (Mem m : list) {
			List<Mem> l = memMap.get(m.name);
			if (l == null) {
				l = new ArrayList<Mem>();
				memMap.put(m.name, l);
			}
			l.add(m);
		}
		
		System.out.println("memMap:" + memMap);
	}
	
	

}

class Mem {
	String name;
	Integer age;
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mem [name=" + name + ", age=" + age + "]";
	}
}
