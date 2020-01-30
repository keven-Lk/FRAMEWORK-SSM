package com.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * �������½�����:
 * List<object> list1 = new ArrayList<String>();
 * List<Sting> list2 = new ArrayList<object>();
 * @author Administrator
 *
 */

public class TestGeneric06 {
	public static void main(String[] args) {
		doMethod01();
		ArrayList<String> lst1 = new ArrayList<String>();
		lst1.add("A");
		lst1.add("B");
		doMethod02(lst1);
		ArrayList<StringBuffer> lst2 = new ArrayList<>();
		StringBuffer sb1 = new StringBuffer();
		sb1.append("c").append("D");
		lst2.add(sb1);
		doMethod02(lst2);
	}
	//����˷����������һ��List��������
	//������ֻ�������ַ���ص�����
	static void doMethod02(List<? extends CharSequence> list) {
		System.out.println(list);
	}
	
	private static void doMethod01() {
		//ָ�������Ͻ�
		List<? extends Object> list1 = new ArrayList<String>();
		list1.add(null);
		//list1.add("123");//����,����ʱ���Ⱥ����
		//ָ�������½�
		List<? super String> list2 = new ArrayList<Object>();
		list2.add("1000");
		//list2.add(2000);//����,����ʱ���Ⱥ����
	}
}
