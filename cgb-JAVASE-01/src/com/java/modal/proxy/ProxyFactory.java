package com.java.modal.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * �������Ĵ�����(���������ҵ��)
 * @author Administrator
 *
 */
class ProxyHandler implements InvocationHandler{
	private Object target;
	public ProxyHandler(Object target) {
		this.target = target;
	}

	/**
	 * ��ִ�д�����󷽷�ʱ,�ײ�����invoke����ִ�д˷����е�ҵ��:
	 * 1)�����չ����
	 * 2)����Ŀ��ҵ��
	 * @param proxy ָ��������
	 * @param method Ŀ��ӿڷ���
	 * @param args ִ��Ŀ��ӿڷ�������ʱ�����ʵ�ʲ���ֵ
	 * @author Administrator
	 *
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long t1 = System.nanoTime();
		//ִ��Ŀ�����target��method����
		Object result = method.invoke(target, args);
		long t2 = System.nanoTime();
		System.out.println("total time"+(t2-t1));
		return null;
	}
}

/**
 * Ϊĳ��Ŀ����󴴽��������Ĺ���
 * Ŀ��:���ڴ��������չĿ������ܲ��ҿ��Կ���Ŀ�����
 * @author Administrator
 *
 */
public class ProxyFactory{
	/**
	 * ΪĿ����󴴽��������
	 * @param targetĿ����� (����ʵ���˽ӿ�)
	 * @return
	 */
	public static Object newProxy(Object target) {
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),//loader 
				target.getClass().getInterfaces(), //interfaces
				new ProxyHandler(target));//handler
	}
}
