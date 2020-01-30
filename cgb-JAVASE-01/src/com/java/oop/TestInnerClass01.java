package com.java.oop;

import com.java.oop.Outer01.Inner01;

class Outer01{
	/**
	 * ʵ���ڲ���
	 * 1)λ��:����ڲ�,�������ⲿ
	 * 2)����:û��static����,�������η�����
	 * 3)Ӧ��:�������ⲿ�����,���Է����ⲿ�����г�Ա
	 */
	private int a;
	private static int b;
	class Inner01{
		public void display() {
			System.out.println(this);
			System.out.println(Outer01.this);
		}
	}
	/*ʵ������(ֻҪ�˷���������,�϶��ⲿ������Ѵ���)
	 * 1)ʵ���������������ʵ������
	 * 2)ʵ�������п���ʹ��thisָ����ǵ�ǰ�ı�������
	 */
	public void creat() {
		//this����ʡ��
		this.new Inner01().display();
		new Inner01().display();
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}

public class TestInnerClass01 {
	//˵��:
	//1)����ʵ���ڲ������Ĺ���,Ӧ�����ⲿ����� �����ڲ������
	//2)����ʵ���ڲ����������ⲿ������һ������
	//3)ʵ���ڲ�������η����ⲿ������?(�ⲿ��.this)
	public static void main(String[] args) throws ClassNotFoundException {
		Outer01 out = new Outer01();
		Inner01 inner = out.new Inner01();
		inner.display();
		out.creat();
		new Outer01().new Inner01().display();
	}
}
