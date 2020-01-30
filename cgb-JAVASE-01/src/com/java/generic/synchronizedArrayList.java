package com.java.generic;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * ��һ����̳еĸ����ʵ�ֵĽӿ���һ����������ͽӿ�ʱ,
 * ����Ҫ�������ʱҪô����ʵ������,Ҫô�͸����ʵ�ֽӿ�ʹ����ͬ�ķ���
 * @author Administrator
 *
 * @param <E>
 */
public class synchronizedArrayList<E> extends ArrayList<E>{
	@Override
	public synchronized boolean add(E e) {
		return super.add(e);
	}
	
	@Override
	public synchronized E get(int index) {
		return super.get(index);
	}
}

