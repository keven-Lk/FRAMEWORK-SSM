package com.java.memory;

import java.util.ArrayList;
import java.util.List;

public class TestMemory01 {
	public static void main(String[] args) {
		//1.�ڴ����(�ڴ治���Դ洢)
//		Integer[] array = new Integer[Integer.MAX_VALUE-1];
//		System.out.println(array.length);
		//2.�ڴ����
		List<byte[]> list = new ArrayList<>();
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			list.add(new byte[1024*1024*10]);
			System.out.println(i);
		}
	}
}
