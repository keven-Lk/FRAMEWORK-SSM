package com.java.oop;

import com.java.oop.Outer02.Inner02;

class Outer02{
	int a;
	static int b;
	/**
	 * 静态内部类:
	 * 1)位置:类的内部,方法内部
	 * 2)修饰:使用static修饰,可以有任意访问修饰符
	 * 3)应用:不依赖于外部类对象,可以访问外类中的静态成员
	 */
	static class Inner02{
		int c;
		//c = 200;这样赋值是错误的 只能在定义时 或构造代码块 实例代码块赋值
		{//实例代码块(每次构件对象都会执行)
			System.out.println(this);
		}
		static {//静态代码块(类加载时可以执行,且执行一次)
			//System.out.println(this);错误
		}
		public void display() {
			//System.out.println("a="+a);错
			System.out.println("b="+b);
			//System.out.println(Ouer02.this);错
			System.out.println(this);
		}
	}
	public void creat() {
		new Inner02();
		//this.new Inner02();错误
	}
}
public class TestInnerClass02 {
	public static void main(String[] args) {
		//静态内部类在外界的构建方式
		Outer02.Inner02 inner01 = new Outer02.Inner02();
		Inner02 inner02 = new Inner02();
		//Error:new Outer02().new Inner02();
		
	}
}
