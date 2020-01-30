package com.java.modal;
/*
 * 类加载:将类通过类加载器加载到内存
 * 类加载的类型
 * 1)隐式加载(对象创建,访问类中的成员)
 * 2)显示加载(Class.forName(""),ClassLoader)
 */

class Singleton01{
//	private int[] array = new int[1024*1024*10];
	static class Inner{//静态内部类
		static {
			//私有的类 变量在外部类的方法中可以访问
			System.out.println("1111111111");
		}
		private static Singleton01 instance = new Singleton01();
	}//使用此类的目的是要实现外部类对象的延迟加载
	private Singleton01() {}
	public static Singleton01 getInstance(){
		return Inner.instance;
	}
	//静态方法
	public static void show() {}
	//实例方法(此方法必须通过对象实例访问)
	public void display(){}
}
public class TestSingleton01 {
	public static void main(String[] args) {
		//1.不允许外界构建某个类对象,请问如何设计
		//new Singleton01();
		
		//2.设计实现
		//1)构造方法私有化
		//2)类加载时构建对象
		//3)提供可访问的静态方法用于返回创建的实例
		
		//3.优化设计?
		//1)对象不使用时不要创建对象,有可能会占用资源
		//将如上设计思想可以理解为延迟加载(按需加载)
		//例如 Singleton01.show();
		Singleton01.show();
//		System.out.println(s1);
		Singleton01 s1 = Singleton01.getInstance();
//		s1.display();
	}
}
