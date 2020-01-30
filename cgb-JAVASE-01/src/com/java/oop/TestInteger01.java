package com.java.oop;

public class TestInteger01 {
	public static void main(String[] args) {
		Integer a = 200;//自动装箱
		Integer b = 200;
		System.out.println(a == b);
		Integer c = 100;//从池中取(-128~+127)
		Integer d = 100;
		System.out.println(c == d);
		
	}
}
