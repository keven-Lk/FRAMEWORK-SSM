package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class TestArray02 {
	public static void doTestArray(int []array) {
		if(array == null||array.length == 0)
			throw new RuntimeException("array is empty");
	}
	
	public static void main(String[] args) {
		//���ͱ���Ϊ��������
		List<Integer> list = new ArrayList<Integer>(100);//Object[];
		list.add(10);
		//�����ЧԪ�ظ���(��ӵ������е�Ԫ�ظ���)
		System.out.println(list.size());
		int[] array = {};
		doTestArray(array);
	}
}
