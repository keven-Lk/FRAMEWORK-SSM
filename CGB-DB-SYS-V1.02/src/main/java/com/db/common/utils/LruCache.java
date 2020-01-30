package com.db.common.utils;

import java.util.LinkedHashMap;

public class LruCache<K,V> extends LinkedHashMap<K, V>{
	private static final long serialVersionUID = -1480905544707974010L;
	private int cap;
	private LinkedHashMap<K,V> cache;
	@SuppressWarnings("unchecked")
	public LruCache(int cap) {
		this.cap = cap;
		int maxCap = (int)Math.ceil(cap/0.75f)+1;
//		super(cap,0.75f,true);
		cache = new LinkedHashMap(maxCap,0.75f,true){
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
				return size()>cap;
			}
		};
	}
	public synchronized void put1(K key,V value) {
		cache.put(key,value);
	}
	
	public synchronized V get1(K key) {
		return cache.get(key);
	}
	
	@Override
	public String toString() {
		return "LruCache [cache=" + cache + "]";
	}
	public static void main(String[] args) {
		LruCache<String,Integer> lruCache = 
				new LruCache<>(3);
		lruCache.put1("A",100);
		lruCache.put1("B",200);
		lruCache.put1("C",300);
		lruCache.get1("A");
		lruCache.put1("D",400);
		System.out.println(lruCache);
	}
}
