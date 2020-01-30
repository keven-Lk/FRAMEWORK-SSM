package com.java.oop;

import java.util.HashMap;
import java.util.Map;

class StaticExample02{
	public static StaticExample02 instance =
			new StaticExample02();
	public static Map<String,Object> map = new HashMap<>();
	public StaticExample02() {
		map.put("key1",100);
		map.put("key2",200);
	}
	
}

public class TestStatic02 {
	public static void main(String[] args) {
		System.out.println(
		StaticExample02.instance.map);
	}
}
