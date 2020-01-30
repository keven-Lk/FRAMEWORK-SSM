package com.java.reflect;

class Container{}//new Container();��Ķ���(���ʵ������)
public class TestClass01 {
	public static void main(String[] args) throws Exception {
		//�����(�ֽ������) �˶�����������ʱ����
		//�������ӳ�������Ľṹ��Ϣ(�ֽ�����Ϣ)
		//1.��Ļ�ȡ��ʽ1
		Class c1 = Container.class;
		//2.��Ļ�ȡ��ʽ2
		Class c2 = Class.forName("com.java.reflect.Container");
		//3.��Ļ�ȡ��ʽ3
		Container ct = new Container();//���ʵ��
		Class c3 = ct.getClass();
		//һ��JVM�ڲ�,�����(�ֽ������)�ڴ���ֻ��һ��
		System.out.println(c1==c2);//true
		System.out.println(c2==c3);
		Class c4 = Integer.class;
		System.out.println(c1==c4);
	}
}
