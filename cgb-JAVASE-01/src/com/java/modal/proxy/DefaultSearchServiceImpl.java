package com.java.modal.proxy;

/**
 * ͨ���̳�ʵ����չ
 *1)����:�ɶ��Ժ�
 *2)����:
 *	a)����Ը�(�����븸��֮������)
 *	b)�������������Ƚϴ�
 *	c)����һ����final������̳�
 *	
 * @author Administrator
 *
 */
public class DefaultSearchServiceImpl extends SearchServiceImpl {
	@Override
	public Object search(String key) {
		long t1 = System.nanoTime();
		Object result = super.search(key);
		long t2 = System.nanoTime();
		long t =t1 - t2;
		System.out.println("total time"+t);
		return result;
	}
}
