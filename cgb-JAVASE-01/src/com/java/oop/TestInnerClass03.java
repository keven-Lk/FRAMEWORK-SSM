package com.java.oop;

class Outer03{//corejava(java ����)
	int a;
	static int b;
	public void creat() {
		/**
		 * �ֲ��ڲ���(Ӧ�ý���)
		 * λ��:�����ڲ�
		 * ����:����ʹ��static����,����ʹ�÷������η�
		 * Ӧ��:ֻ���ڷ����ڲ�,��������ⲿ�����г�Ա
		 */
		class Inner03{
			//static int c = 100;��
			int c = 300;
			public void display() {
				System.out.println(this);
				System.out.println(Outer03.this);
				System.out.println(a);
				System.out.println(b);
			}
		}//�����в�������static����
		//ֻ���ڷ����ڲ������˶���
		new Inner03().display();
	}
	public void newInstance() {
		//new Inner03();���� ���ɼ�
	}
}

public class TestInnerClass03 {
	public static void main(String[] args) {
		new Outer03().creat();
	}
}
