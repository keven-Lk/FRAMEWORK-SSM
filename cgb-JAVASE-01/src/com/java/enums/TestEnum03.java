package com.java.enums;

enum ExecutorType{
	SIMPLE,CACHE;//���ʵ��(�����ʱ����),�����ڵ�һ��
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
