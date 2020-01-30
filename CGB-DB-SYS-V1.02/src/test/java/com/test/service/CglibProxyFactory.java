package com.test.service;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxyFactory {
	/**
	 * ΪĿ����󴴽��������
	 * @param target Ŀ�����
	 * @return �������
	 */
	public static Object newProxy(Object target) {
		//1.����enHancer����(�˶����൱��JDK�е�Proxy��)
		Enhancer e = new Enhancer();
		//2.����Ҫ�����Ĵ������Ӧ�ü̳��ĸ���(Ŀ�����)
		e.setSuperclass(target.getClass());
		//3.���ô����������
		e.setCallback(new MethodInterceptor() {
			//MethodInterceptor�൱��jdk���е�Invocation
			//�˷����൱��InvocationHandler�е�invoke����
			@Override
			public Object intercept(Object arg0, //proxy
					Method arg1, //target method
					Object[] arg2, //ʵ�ʲ���
					MethodProxy arg3) throws Throwable {
				System.out.println(arg0.getClass().getName());
				System.out.println("search start...");
				//ִ��Ŀ�귽��
//				Object result = arg1.invoke(target,arg2);
				Object result = arg3.invokeSuper(arg0, arg2);
				System.out.println("search end...");
				return result;//
			}
		});
		Object proxy = e.create();
		return proxy;
	}
	public static void main(String[] args) {
		//Ŀ�����
		DefaultSearchService target = new DefaultSearchService();
		//�����������
		DefaultSearchService proxy  =
				(DefaultSearchService) CglibProxyFactory.newProxy(target);
				
		//ִ��ҵ��
		proxy.search("tooc");
	}
}
	
