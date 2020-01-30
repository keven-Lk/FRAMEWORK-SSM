package com.java.enums;

enum ExecutorType{
	SIMPLE,CACHE;//类的实例(类加载时创建),必须在第一行
	static {
		System.out.println("static");
	}
	private ExecutorType() {
		System.out.println("ExecutorType()");
	}
}

public class TestEnum03 {
	public static void main(String[] args) {
		ExecutorType type = ExecutorType.SIMPLE;
	}
}
