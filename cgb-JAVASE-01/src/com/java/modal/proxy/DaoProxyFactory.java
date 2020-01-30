package com.java.modal.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DaoProxyHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("selectminsert...");
		return null;
	}
	
}

public class DaoProxyFactory {
	public <T>T newProxy(Class<T> targetCls){
		return (T) Proxy.newProxyInstance(
				targetCls.getClassLoader(),
				new Class[] {targetCls},
				new DaoProxyHandler());
	}
}
