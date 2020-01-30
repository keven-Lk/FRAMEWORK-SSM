package com.java.oop;

class StaticExample01{
	/*
	 * 类变量在类加载时初始化
	 */
	static int a = 10, b;
	static final int c;
	static final int d = 200;
	static {//类加载时可以执行,且执行一次
		b = 10;
		c = 100;
		//d = 300;错误
		System.out.println("static{}");
	}
	public static void show() {
		System.out.println("StaticExapley01");
	}
}

public class TestStatic01 {
	public static void main(String[] args) {
		//int a = StaticExample01.a;
		StaticExample01.show();
		StaticExample01.show();
	}
}
