package com.test.service;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxyFactory {
	/**
	 * 为目标对象创建代理对象
	 * @param target 目标对象
	 * @return 代理对象
	 */
	public static Object newProxy(Object target) {
		//1.创建enHancer对象(此对象相当于JDK中的Proxy类)
		Enhancer e = new Enhancer();
		//2.设置要创建的代理对象应该继承哪个类(目标对象)
		e.setSuperclass(target.getClass());
		//3.设置代理对象处理器
		e.setCallback(new MethodInterceptor() {
			//MethodInterceptor相当于jdk当中的Invocation
			//此方法相当于InvocationHandler中的invoke方法
			@Override
			public Object intercept(Object arg0, //proxy
					Method arg1, //target method
					Object[] arg2, //实际参数
					MethodProxy arg3) throws Throwable {
				System.out.println(arg0.getClass().getName());
				System.out.println("search start...");
				//执行目标方法
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
		//目标对象
		DefaultSearchService target = new DefaultSearchService();
		//创建代理对象
		DefaultSearchService proxy  =
				(DefaultSearchService) CglibProxyFactory.newProxy(target);
				
		//执行业务
		proxy.search("tooc");
	}
}
	
