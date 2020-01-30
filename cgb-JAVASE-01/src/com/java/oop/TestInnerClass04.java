package com.java.oop;
/*
 * 具体类
 */
class ClassA{
	public void show() {
		System.out.println("ClassA");
	}
}
//抽象类
abstract class ClassB{
	abstract void show();
}
//接口
interface ClassC{
	void show();//默认使用public abstract
}

public class TestInnerClass04 {
	static ClassC c2 = new ClassC() {
		public void show() {};
	};
	public static void main(String[] args) {
		ClassA a1 = new ClassA();
		//ClassB b1 = new ClassB();//错误
		//ClassC c1 = new ClassC();//错误
		//构建指定类型的子类类型对象或实现类类型对象
		//1.构建ClassA类型的子类对象
		ClassA a2 = new ClassA() {};//ClassA的子类对象匿名内部类ClassA$1.class
		ClassA a3 = new ClassA() {//ClassA的子类对象
			@Override
			public void show() {
				super.show();//super指向谁?
			}
		};
		//2.构建ClassB类型的子类对象
		ClassB b2 = new ClassB() {//此匿名内部类父类为抽象类
			@Override
			void show() {
				System.out.println("classB,show()");
				//super.show();//错误,父类不能构建对象
			}
		};
		//3.构建ClassC类型的子类对象
		ClassC c1 = new ClassC() {//构建的是借口的实现类对象
			@Override
			public void show() {
				System.out.println("classC.show()");
			}
		};
		c1.show();
	}
}
