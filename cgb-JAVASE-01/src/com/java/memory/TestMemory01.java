package com.java.memory;

import java.util.ArrayList;
import java.util.List;

public class TestMemory01 {
	public static void main(String[] args) {
		//1.内存溢出(内存不足以存储)
//		Integer[] array = new Integer[Integer.MAX_VALUE-1];
//		System.out.println(array.length);
		//2.内存溢出
		List<byte[]> list = new ArrayList<>();
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			list.add(new byte[1024*1024*10]);
			System.out.println(i);
		}
	}
}
