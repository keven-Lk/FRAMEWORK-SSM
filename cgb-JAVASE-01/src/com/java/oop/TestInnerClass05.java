package com.java.oop;
abstract class ClassD{
	abstract void methodD();
}
abstract class ClassE extends ClassD{
	abstract void methodE();
}

public class TestInnerClass05 {
	public static void main(String[] args) {
		//父类引用指向子类对象
		ClassD d = new ClassE() {
			@Override
			void methodE() {
				System.out.println("methodE");
			}
			
			@Override
			void methodD() {
				System.out.println("methodD");
			}
		};
		//编译时看等号左边类型
		//d.methodE();
		d.methodD();
		((ClassE)d).methodE();
	}
}
