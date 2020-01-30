package com.test;

public class TestVars01 {
//	static void doMethod(int a, int b) {
//		System.out.println("doMethod(int a,int b)");
//	}
//	static void doMethod(int a, int b ,int c) {}
//	static void doMethod(int a, int b,int c, int d) {}
	
	//JDK1.5新特性,可变参数
	static void doMethod(int... args) {
		//System.out.println("doMethod(int...args)");
		System.out.println(args.length);
	}
	public static void main(String[] args) {
		
		doMethod(10);
		doMethod(10,20);
		doMethod(10,20,30);
		
	}
}
