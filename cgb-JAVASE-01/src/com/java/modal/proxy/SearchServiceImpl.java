package com.java.modal.proxy;

public class SearchServiceImpl implements SearchService{
	public Object search(String key) {
		//long t1 = System.nanoTime();
		System.out.println("search by"+key);
		String result = "result by" +key;
//		long t2 = System.nanoTime();
//		System.out.println("total time:" +(t2-t1));
		return result;
	}//OCP(����ԭ��):����չ����,���޸Ĺر�
}
