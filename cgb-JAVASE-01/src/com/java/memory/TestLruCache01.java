package com.java.memory;

import java.util.LinkedHashMap;
//Lru
public class TestLruCache01 {
	static class LruCache extends LinkedHashMap<String, Object>{
		/**容器最大容量*/
		private int maxCap;
		public LruCache(int maxCap) {
			super(maxCap,0.75f,true);//accessOrder true表示由连接记录的访问数据 false表示添加数据
			this.maxCap = maxCap;
		}
		/**
		 * 当容器中满了以后,再放数据
		 * 会将容器中长时间不访问的数据移除
		 */
		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<String, Object> eldest) {
			return size()>maxCap;
		}
	}
	public static void main(String[] args) {
		LruCache map = new LruCache(3);
		map.put("A",100);
		map.put("C",200);
		map.put("B",300);
		map.get("A");
		map.get("B");
		map.put("D",400);
		System.out.println(map);
	}
}
