package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class TestArray02 {
	public static void doTestArray(int []array) {
		if(array == null||array.length == 0)
			throw new RuntimeException("array is empty");
	}
	
	public static void main(String[] args) {
		//泛型必须为对象类型
		List<Integer> list = new ArrayList<Integer>(100);//Object[];
		list.add(10);
		//输出有效元素个数(添加到数组中的元素个数)
		System.out.println(list.size());
		int[] array = {};
		doTestArray(array);
	}
}
