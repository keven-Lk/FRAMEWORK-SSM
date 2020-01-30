package com.java.reflect;

class Container{}//new Container();类的对象(类的实例对象)
public class TestClass01 {
	public static void main(String[] args) throws Exception {
		//类对象(字节码对象) 此对象会在类加载时创建
		//类对象中映射的是类的结构信息(字节码信息)
		//1.类的获取方式1
		Class c1 = Container.class;
		//2.类的获取方式2
		Class c2 = Class.forName("com.java.reflect.Container");
		//3.类的获取方式3
		Container ct = new Container();//类的实例
		Class c3 = ct.getClass();
		//一个JVM内部,类对象(字节码对象)内存中只有一份
		System.out.println(c1==c2);//true
		System.out.println(c2==c3);
		Class c4 = Integer.class;
		System.out.println(c1==c4);
	}
}
