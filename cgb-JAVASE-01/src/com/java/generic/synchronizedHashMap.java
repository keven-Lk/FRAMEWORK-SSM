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
