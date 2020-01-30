package com.java.oop;
class A{
	public void show() {
		
	}
}
class B extends A{
	public void display() {}
}
public class TestExtends01 {
	public static void main(String[] args) {
		A a = new B();
		a.show();
		//a.display();//编译时看变量类型
		((B)a).display();//运行时看变量指向的对象
	}
}
