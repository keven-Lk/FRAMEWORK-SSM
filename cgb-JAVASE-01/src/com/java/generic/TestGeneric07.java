package com.java.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Hello{
	int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}

public class TestGeneric07 {
	public static void main(String[] args) throws Exception {
		//�����Ǳ���ʱ��һ������,����ʱ��Ч
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		//list.add(100);
		//���÷��佫100��ӵ�list��
		//1.��ȡ����Ӧ�õ�������
		Class<?> cls = list.getClass();
		//2.����������ȡadd��������
		Method method = cls.getDeclaredMethod("add", //������
				Object.class);//��������
		//3.ִ��list���ϵ�add����
		method.invoke(list, 100);
		
		System.out.println(list);
	}
}
