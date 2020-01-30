package com.java.generic;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 当一个类继承的父类或实现的接口是一个泛型类或泛型接口时,
 * 我们要定义此类时要么传入实际类型,要么和父类或实现接口使用相同的泛型
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

