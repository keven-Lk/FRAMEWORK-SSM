package com.java.oop;

class StaticExample03{
	static {
		System.out.println("StaticExample03.static");
	}
	static class Inner{
		public static int a = 10;
		static {
			System.out.println("Inner.static");
		}
	}
}

public class TestStatic03 {
	public static void main(String[] args) {
		System.out.println(StaticExample03.Inner.a);
	}
}
