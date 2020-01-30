package com.java.reflect;

import java.lang.reflect.Constructor;

class Point{
	private int x;
	private int y;
	static {
		System.out.println("Point.static");
	}//Point.class��ʽ������ʱ����ִ��static�����
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
		//1.�����(�ֽ���)��ȡ
		doLoadclass();
		//2.��������󹹽����ʵ������
		Point p1 = doCreatInstance(Point.class);
		System.out.println(p1);
		//3.��������󹹽����ʵ������
		Point p2 = doCreatInstance(Point.class,new Object[] {10,20},
				new Class[] {int.class,int.class});
		System.out.println(p2);
	}
	
	//��������ֽ�����󴴽����ʵ������
	private static <T>T doCreatInstance(Class<?> cls) throws Exception {
		//1.��ȡ���еĹ��췽������
		Constructor<?> con = cls.getDeclaredConstructor();
		//2.���ڹ��췽�����󹹽����ʵ������
		con.setAccessible(true);//���ù��췽���ɷ���
		return (T)con.newInstance();//Ĭ�ϵ����޲ι��캯��
	}
	
	@SuppressWarnings("unused")
	private static <T>T doCreatInstance(
			Class<T> cls,//�ֽ������
			Object[] args,//��������ʱ��Ҫ��ʵ�ʲ���
			Class<?>[] paramTypes//��������ʱ��Ҫ����ʽ����
			) throws Exception{
		//1.��ȡ���еĹ��췽������
		Constructor<T> con = cls.getDeclaredConstructor(paramTypes);
		//2.���ڹ��췽�����󹹽����ʵ������
		return con.newInstance(args);
	}
	
	//��ȡ�����
	private static void doLoadclass() throws ClassNotFoundException {
		Class<Point> c1 = Point.class;
		Class<?> c2 = Class.forName("com.java.reflect.Point");
		//Class<?> c3 = new Point().getClass();
		System.out.println(c1==c2);
		//System.out.println(c3==c2);
	}
}
