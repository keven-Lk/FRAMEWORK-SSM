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
		//a.display();//����ʱ����������
		((B)a).display();//����ʱ������ָ��Ķ���
	}
}
