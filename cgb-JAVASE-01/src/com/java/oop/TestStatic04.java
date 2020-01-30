package com.java.oop;
//通过此参数 -XX:+TraceClassLoading可查看类加载过程
class StaticExample04{
	static int a = 10 ;
	static {
		System.out.println("StaticExample.static");
	}
}

class SubStaticExample04 extends StaticExample04{
	static {
		System.out.println("SubStaticExample04.static");
	}
}

public class TestStatic04 {
	public static void main(String[] args) {
		//当通过子类访问父类成员,父类为主动加载,子类为被动加载
		//被动加载的类,其静态代码不会执行
		//System.out.println(SubStaticExample04.a);
		System.out.println(StaticExample04.a);
	}
}
