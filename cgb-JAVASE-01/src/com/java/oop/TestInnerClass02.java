package com.java.oop;

import com.java.oop.Outer02.Inner02;

class Outer02{
	int a;
	static int b;
	/**
	 * ��̬�ڲ���:
	 * 1)λ��:����ڲ�,�����ڲ�
	 * 2)����:ʹ��static����,����������������η�
	 * 3)Ӧ��:���������ⲿ�����,���Է��������еľ�̬��Ա
	 */
	static class Inner02{
		int c;
		//c = 200;������ֵ�Ǵ���� ֻ���ڶ���ʱ �������� ʵ������鸳ֵ
		{//ʵ�������(ÿ�ι������󶼻�ִ��)
			System.out.println(this);
		}
		static {//��̬�����(�����ʱ����ִ��,��ִ��һ��)
			//System.out.println(this);����
		}
		public void display() {
			//System.out.println("a="+a);��
			System.out.println("b="+b);
			//System.out.println(Ouer02.this);��
			System.out.println(this);
		}
	}
	public void creat() {
		new Inner02();
		//this.new Inner02();����
	}
}
public class TestInnerClass02 {
	public static void main(String[] args) {
		//��̬�ڲ��������Ĺ�����ʽ
		Outer02.Inner02 inner01 = new Outer02.Inner02();
		Inner02 inner02 = new Inner02();
		//Error:new Outer02().new Inner02();
		
	}
}
