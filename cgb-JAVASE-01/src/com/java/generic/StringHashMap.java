package com.java.generic;

import java.util.HashMap;
/**
 * �Զ���map,key����ΪString����,ֵû��Ҫ��
 * @author Administrator
 *
 * @param <V>
 */
public class StringHashMap<V> extends HashMap<String, V>{
	@Override
	public synchronized V put(String key, V value) {
		return super.put(key, value);
	}
	
	@Override
	public synchronized V get(Object key) {
		return super.get(key);
	}
	public static void main(String[] args) {
		StringHashMap<Integer> map = new StringHashMap<Integer>();
		map.put("k0",100);
	}
}
