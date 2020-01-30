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
public class synchronizedHashMap<K,V> extends HashMap<K, V>{
	@Override
	public synchronized V put(K key, V value) {
		// TODO Auto-generated method stub
		return super.put(key, value);
	}
	
	@Override
	public synchronized V get(Object key) {
		// TODO Auto-generated method stub
		return super.get(key);
	}
}
