package com.test;

public class TestThread03 {
	static String content;
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println(main.getName());
		new Thread() {
			public void run() {
				content = "hello";
			}
		}.start();
		while(content == null) Thread.yield();//����cpu�����Լ�����ȡ,�����ھ���̬
		System.out.println(content.toUpperCase());
	}
}
