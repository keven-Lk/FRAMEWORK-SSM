package com.java.reflect;

import java.lang.reflect.Constructor;

class Point{
	private int x;
	private int y;
	static {
		System.out.println("Point.static");
	}//Point.class方式加载类时不会执行static代码块
	private Point() {
		System.out.println("Point.private");
	}
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		System.out.println(x);
		System.out.println(y);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

public class TestReflect01 {
	public static void main(String[] args) throws Exception {
		//1.类对象(字节码)获取
		doLoadclass();
		//2.基于类对象构建类的实例对象
		Point p1 = doCreatInstance(Point.class);
		System.out.println(p1);
		//3.基于类对象构建类的实例对象
		Point p2 = doCreatInstance(Point.class,new Object[] {10,20},
				new Class[] {int.class,int.class});
		System.out.println(p2);
	}
	
	//基于类的字节码对象创建类的实例对象
	private static <T>T doCreatInstance(Class<?> cls) throws Exception {
		//1.获取类中的构造方法对象
		Constructor<?> con = cls.getDeclaredConstructor();
		//2.基于构造方法对象构建类的实例对象
		con.setAccessible(true);//设置构造方法可访问
		return (T)con.newInstance();//默认调用无参构造函数
	}
	
	@SuppressWarnings("unused")
	private static <T>T doCreatInstance(
			Class<T> cls,//字节码对象
			Object[] args,//创建对象时需要的实际参数
			Class<?>[] paramTypes//创建对象时需要的形式参数
			) throws Exception{
		//1.获取类中的构造方法对象
		Constructor<T> con = cls.getDeclaredConstructor(paramTypes);
		//2.基于构造方法对象构建类的实例对象
		return con.newInstance(args);
	}
	
	//获取类对象
	private static void doLoadclass() throws ClassNotFoundException {
		Class<Point> c1 = Point.class;
		Class<?> c2 = Class.forName("com.java.reflect.Point");
		//Class<?> c3 = new Point().getClass();
		System.out.println(c1==c2);
		//System.out.println(c3==c2);
	}
}
