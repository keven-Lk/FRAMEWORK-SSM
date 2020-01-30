package com.java.memory;

public class TestMath01 {
	public static void main(String[] args) {
		int cap = 100;
		int max = (int)Math.ceil(cap/0.75f)+1;
		System.out.println(max);
	}
}
