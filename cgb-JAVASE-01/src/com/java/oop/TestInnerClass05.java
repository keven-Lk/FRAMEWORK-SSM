package com.java.oop;
abstract class ClassD{
	abstract void methodD();
}
abstract class ClassE extends ClassD{
	abstract void methodE();
}

public class TestInnerClass05 {
	public static void main(String[] args) {
		//��������ָ���������
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
		//����ʱ���Ⱥ��������
		//d.methodE();
		d.methodD();
		((ClassE)d).methodE();
	}
}
