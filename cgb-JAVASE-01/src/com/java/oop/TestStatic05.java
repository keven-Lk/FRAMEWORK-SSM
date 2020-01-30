package com.java.oop;

class StaticExample05{
	static {
		System.out.println("StaticExample05");
	}
}

public class TestStatic05 {
	public static void main(String[] args) throws ClassNotFoundException {
		//��ʾ�����:��ʽ1
		//Class.forName("com.java.oop.StaticExample05");
		//��ʾ�����:��ʽ2
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		//System.out.println(loader.getClass().getName());
		loader.loadClass("com.java.oop.StaticExample05");
		Class.forName("com.java.oop.StaticExample05",
				true,//true��ִ�о�̬�����
				loader);
	}
}
