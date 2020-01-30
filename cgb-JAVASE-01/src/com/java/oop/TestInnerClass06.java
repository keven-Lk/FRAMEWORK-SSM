package com.java.oop;

/*
 * 何为内部类?类中定义的类,包含方法中类
 * 为何内部类?
 * 1)限定类的访问范围,同时也可以的对局部属性进行封装
 * 2)可以访问外部类成员(能访问哪些成员还要具体内部类的类型)
 * 3)实现更加优雅编程的一种实现方式
 * 内部类的类型
 * 1)实例内部类
 * 2)静态内部类
 * 3)局部内部类
 * 4)匿名内部类
 * 
 * 实力内部类应用
 * 1)特点
 * a)类内部,方法外部,没有static修饰
 * b)可以任意访问修饰符
 * c)对象实例会依赖于外部类对象
 * 2)使用
 * a)实例内部类对象访问外部类对象:外部类名.this
 * b)内部类对象构建时必须先构建外部类对象
 * c)实力内部类对象的生命周期因该在可控范围内比较好
 * 
 * 静态内部类
 * 1)特点
 * a)类的内部,方法外部,使用static修饰
 * b)可以使任意访问修饰符
 * c)对象实例不依赖于外部类对象
 * d)可访问外部类静态对象
 * 2)使用
 * a)可以直接构建静态内部类对象
 * b)内部不能获取外部类对象引用
 * 
 * 局部内部类
 * 1)特点
 * a)方法内部,不允许使用任何访问修饰符,不允许使用static修饰
 * b)对象实例是否依赖于外部类对象,要看类所在的方法
 * c)可访问外部类的成员受类所在方法影响
 * 
 * 2)使用
 * a)对象仅限于在方法内部创建,内部使用
 * 
 * 匿名内部类
 * 1)特点:
 * 没有类名,父类可以是具体类,抽象类,接口
 * 2)应用
 * 匿名内部类对象只能创建一次
 * 
 */

class Outer{
	/*
	 * 实例内部类
	 */
	class Inner01{}
	/*
	 * 静态内部类
	 */
	static class Inner02{}
	public void create() {
		/*
		 * 局部内部类
		 */
		class Inner03{}
	}
	
	private Runnable Inner04 = new Runnable() {
		/*
		 * 匿名内部类
		 * (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {};
	};
}

public class TestInnerClass06 {
	
}
