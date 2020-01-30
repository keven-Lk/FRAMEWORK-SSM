package com.java.memory;

import java.util.LinkedHashMap;
//Lru
public class TestLruCache01 {
	static class LruCache extends LinkedHashMap<String, Object>{
		/**�����������*/
		private int maxCap;
		public LruCache(int maxCap) {
			super(maxCap,0.75f,true);//accessOrder true��ʾ�����Ӽ�¼�ķ������� false��ʾ�������
			this.maxCap = maxCap;
		}
		/**
		 * �������������Ժ�,�ٷ�����
		 * �Ὣ�����г�ʱ�䲻���ʵ������Ƴ�
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
