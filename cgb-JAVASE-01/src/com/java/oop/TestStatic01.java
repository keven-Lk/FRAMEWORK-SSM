package com.java.oop;

class StaticExample01{
	/*
	 * ������������ʱ��ʼ��
	 */
	static int a = 10, b;
	static final int c;
	static final int d = 200;
	static {//�����ʱ����ִ��,��ִ��һ��
		b = 10;
		c = 100;
		//d = 300;����
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
