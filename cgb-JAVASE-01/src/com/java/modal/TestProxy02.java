package com.java.modal;

import com.java.modal.proxy.ProxyFactory;
import com.java.modal.proxy.SearchService;
import com.java.modal.proxy.SearchServiceImpl;

public class TestProxy02 {
	public static void main(String[] args) {
		//1.构建目标对象
		SearchServiceImpl target = new SearchServiceImpl();
		//2.为目标对象创建代理对象
		SearchService service = (SearchService)ProxyFactory.newProxy(target);
		System.out.println(service.getClass().getClassLoader());
		//3.执行代理对象方法
		Object result = service.search("kairui");
		System.out.println(result);
	}
}
