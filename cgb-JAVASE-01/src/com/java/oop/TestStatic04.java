package com.java.oop;
//ͨ���˲��� -XX:+TraceClassLoading�ɲ鿴����ع���
class StaticExample04{
	static int a = 10 ;
	static {
		System.out.println("StaticExample.static");
	}
}

class SubStaticExample04 extends StaticExample04{
	static {
		System.out.println("SubStaticExample04.static");
	}
}

public class TestStatic04 {
	public static void main(String[] args) {
		//��ͨ��������ʸ����Ա,����Ϊ��������,����Ϊ��������
		//�������ص���,�侲̬���벻��ִ��
		//System.out.println(SubStaticExample04.a);
		System.out.println(StaticExample04.a);
	}
}
