package com.java.generic;
/**
 * �෺��:ֻ��Ӧ����ʵ������,����Ӧ���ھ�̬����
 * ʵ����������û��static���εķ���
 * @author Administrator
 *
 */
class ClassUtil<T>{
	/*
	 * ʵ������:�˷����еķ��������;���
	 */
	T newInstance(Class<T> clazz){
		return null;
	}
	
	/*
	 * ���ͷ���:�����Ǿ�̬����,Ҳ������ʵ������
	 */
	public static <E>void print(E t) {}
}

public class TestGeneric04 {
	public static void main(String[] args) {
		ClassUtil<String> c1 = new ClassUtil<>();
		String o = c1.newInstance(String.class);
	}
}
