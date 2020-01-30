package com.java.oop;
/*
 * ������
 */
class ClassA{
	public void show() {
		System.out.println("ClassA");
	}
}
//������
abstract class ClassB{
	abstract void show();
}
//�ӿ�
interface ClassC{
	void show();//Ĭ��ʹ��public abstract
}

public class TestInnerClass04 {
	static ClassC c2 = new ClassC() {
		public void show() {};
	};
	public static void main(String[] args) {
		ClassA a1 = new ClassA();
		//ClassB b1 = new ClassB();//����
		//ClassC c1 = new ClassC();//����
		//����ָ�����͵��������Ͷ����ʵ�������Ͷ���
		//1.����ClassA���͵��������
		ClassA a2 = new ClassA() {};//ClassA��������������ڲ���ClassA$1.class
		ClassA a3 = new ClassA() {//ClassA���������
			@Override
			public void show() {
				super.show();//superָ��˭?
			}
		};
		//2.����ClassB���͵��������
		ClassB b2 = new ClassB() {//�������ڲ��ุ��Ϊ������
			@Override
			void show() {
				System.out.println("classB,show()");
				//super.show();//����,���಻�ܹ�������
			}
		};
		//3.����ClassC���͵��������
		ClassC c1 = new ClassC() {//�������ǽ�ڵ�ʵ�������
			@Override
			public void show() {
				System.out.println("classC.show()");
			}
		};
		c1.show();
	}
}
