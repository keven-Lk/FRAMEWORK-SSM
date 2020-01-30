package com.java.modal;

import com.java.modal.proxy.ProxyFactory;
import com.java.modal.proxy.SearchService;
import com.java.modal.proxy.SearchServiceImpl;

public class TestProxy02 {
	public static void main(String[] args) {
		//1.����Ŀ�����
		SearchServiceImpl target = new SearchServiceImpl();
		//2.ΪĿ����󴴽��������
		SearchService service = (SearchService)ProxyFactory.newProxy(target);
		System.out.println(service.getClass().getClassLoader());
		//3.ִ�д�����󷽷�
		Object result = service.search("kairui");
		System.out.println(result);
	}
}
