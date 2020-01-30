package com.java.generic;

import java.util.ArrayList;
import java.util.List;
class Container<T>{//类泛型:类名<泛型>
	
	public void add(T t) {}
	
	public T get() {
		return null;
	}
}

public class TestGeneric01 {
	public static void main(String[] args) {
		//doMethod01();
	}
	
	private static void doMethod() {
		Container<Integer> c1 = new Container<>();
		c1.add(100);//自动封箱  Integer.valueOf(100);
		Integer t1 = c1.get();
		
	}

	private static void doMethod01() {
		List list0 = new ArrayList<>();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<>();//JDK1.7
		ArrayList<Integer> list3 = new ArrayList<>();
		list1.add("ABCD");
		String s1 = list1.get(0);
		list0.add("AbCD");
		String s2 = (String)list0.get(0);//强转操作会损耗性能
		//泛型不允许是基本类型,所以如下写法错误
		//List<boolean> list4 = new ArrayList<boolean>();
		
	}
}
